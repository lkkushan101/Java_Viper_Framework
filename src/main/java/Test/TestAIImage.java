package Test;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import Utility.*;
public class TestAIImage {
    
	@Test
	public void testImageCompare () throws IOException
	{
	
		ImageCompareClass ImageCompare = new ImageCompareClass();
		if (ImageCompare.SendAICompare(".\\Images\\sss.png", ".\\Images\\sss.png"))
		{
			System.out.println("Images are matching");
		}
		else 
		{
			System.out.println("Images are NOT matching");
			
		}
	}
}
