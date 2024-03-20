package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite)
    {
        System.out.println("Suite start");
    }

    @Override
    public void onFinish(ISuite suite)
    {
        System.out.println("Suite finish");
    }
}
