package junits;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import clinica.Executa_clinica_chrome;

public class TestRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(Executa_clinica_chrome.class);
		//Result result = JUnitCore.runClasses(foxTest.class);

		for(Failure failure : result.getFailures())
		{	
			//This will print message only in case of failure
			System.out.println(failure.getMessage());
		}
		//This will print the overall test result in boolean type
		System.out.println(result.wasSuccessful());
	}
	
}