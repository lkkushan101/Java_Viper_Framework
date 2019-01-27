package Test;
import org.testng.annotations.Test;
import java.io.*;
import Utility.*;
import freemarker.core.Environment;

import org.testng.annotations.Test;  
 
public class  PostmanRunTest
 {
	
@Test 
public void postmanRun() throws InterruptedException
	{
		PostmanRun ps = new PostmanRun();
		
		 int fileCount = new File(System.getProperty("user.dir")+"\\PostmanTest\\").list().length;
		 String[]  file1 = new File(System.getProperty("user.dir")+"\\PostmanTest\\").list();
		 ps.runCommand("npm install -g newman");
		 ps.runCommand("npm install -g  newman-reporter-html");
		 
		 for (int i = 0;i<fileCount; i++ )
		{
		
		 ps.runCommand("newman run "+ System.getProperty("user.dir")+"\\PostmanTest\\"+file1[i]+" -r html");
		 
		}
	}   
	
}  

