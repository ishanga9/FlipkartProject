package baseClasses;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener
{
	public void onTestStart(ITestResult result) {
	    // not implemented
		
		System.out.println("Test is Started "+result.getInstanceName()+" "+result.getName());
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  public void onTestSuccess(ITestResult result) {
	    // not implemented
			System.out.println("Test is Success "+result.getInstanceName()+" "+result.getName());
			
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult result) {
	    // not implemented
			System.out.println("Test is Failure "+result.getInstanceName()+" "+result.getName());

	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
			System.out.println("Test is Skipped "+result.getInstanceName()+" "+result.getName());

	  }

}
