package Test;

import java.io.IOException;

import org.testng.annotations.Test;
import Utility.*;
public class ClientSidePerfTesting {
	
	@Test 
	public void test() throws IOException  
	{
		ClientSidePerformanceRunner cp = new ClientSidePerformanceRunner();
	    cp.clientSidePerformance("http://www.trc.gov.lk", "TRC", "C:\\trc.har");
	
	}
	
    
	

}
