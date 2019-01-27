package Test;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
import Utility.*;
public class Test_Accessibility {

	@Test
	public void testAccessibility () throws IOException 
	{
		 AccessibilityRunner ar = new AccessibilityRunner();
		 ar.accessibilityTest("http://www.google.lk");
		 ar.accessibilityTest("http://www.google.com");
	}

}
