package core;
import java.io.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.lang.reflect.Method;

public class PrimeNumberCheckerTest implements ITest {

// String csvFile = "./primes_10.csv"; // mvn site -Dtestcases="./primes_10.csv"
String csvFile = System.getProperty("testcases");

private String test_name = "";

public String getTestName() {return test_name;}

private void setTestName(String a) {test_name = a;}

@BeforeMethod(alwaysRun = true)
public void beforemethod(Method method, Object[] parameters) {

setTestName(method.getName());
Override a = method.getAnnotation(Override.class);

String testCaseId = (String) parameters[a.id()];
setTestName(testCaseId);
}

@DataProvider(name = "Prime Numbers")
public Iterator<String[]> data() throws IOException {
String cvsLine = "";
String[] a = null;
ArrayList<String[]> al = new ArrayList<>();
BufferedReader br = new BufferedReader(new FileReader(csvFile));
while ((cvsLine = br.readLine()) != null) {a = cvsLine.split(",");al.add(a);}
br.close();
return al.iterator();
}

@Override // @Override(id = 0)
@Test(timeOut = 1000, dataProvider = "Prime Numbers")
public void test(String a, String b, String c) {
assertThat(PrimeNumberChecker.validate(Integer.parseInt(b)), equalTo(Boolean.parseBoolean(c)));
 }
}