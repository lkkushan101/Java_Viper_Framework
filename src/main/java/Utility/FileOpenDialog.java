package Utility;
import java.io.File;



import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;

public class FileOpenDialog {
	public static String jvmBitVersion(){
	 return System.getProperty("sun.arch.data.model");
	}

	public void openDlg (String dlgTitle, String filePath, String button_title) throws InterruptedException
	{
		String jacobDllVersionToUse;
		if (jvmBitVersion().contains("32")){
		jacobDllVersionToUse = "jacob-1.19-x86.dll";
		}
		else {
		jacobDllVersionToUse = "jacob-1.19-x64.dll";
		}
		
		File file = new File("AutoIT", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

		AutoItX x = new AutoItX();
		
		x.winActivate(dlgTitle);
		x.send(filePath);
		x.sleep(3000);
		x.controlClick(dlgTitle, "", "Button1");
		
		}


	}


