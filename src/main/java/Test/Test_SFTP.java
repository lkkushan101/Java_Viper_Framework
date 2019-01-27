package Test;
import org.testng.annotations.Test;

import Utility.*;
public class Test_SFTP {
	
	@Test 
	public void test()
	{
		SFTPRunner sftp = new SFTPRunner();
		
		sftp.downloadSFTPFile("test.rebex.net", 22, "demo", "password", "e:\\kushan.txt", "/pub/example/readme.txt");
	}
	

}
