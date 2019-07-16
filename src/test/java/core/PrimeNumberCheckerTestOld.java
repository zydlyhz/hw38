package core;

import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.*;
import java.util.*;

public class PrimeNumberCheckerTestOld {
 
	// String csvFile = "./primes_10.csv"; // mvn site -Dtestcases="./primes_10.csv"
	
	String csvFile = System.getProperty("testcases");
	
	@DataProvider(name = "Prime Numbers")
	public Iterator<String[]> data() throws IOException {
		String csvLine = "";
		String[] a = null;
		ArrayList<String[]> al = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		while ((csvLine = br.readLine()) != null) {
			a = csvLine.split(",");
			al.add(a);
		}
		br.close();
		return al.iterator();
		}
	
	@Test(timeOut = 1000, dataProvider = "Prime Numbers")
  public void test(String a, String b, String c) {
  
		assertThat(PrimeNumberChecker.validate(Integer.parseInt(b)), equalTo(Boolean.parseBoolean(c)));
	}
	
}
