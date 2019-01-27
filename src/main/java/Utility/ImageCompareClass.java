package Utility;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Desktop;
import javax.imageio.ImageIO;

import org.json.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ImageCompareClass {
	
	public boolean SendAICompare(String fileSource, String fileDestination) throws IOException
	{
		
		  try {
			   File file =    new File(fileSource);
		   	   FileInputStream inputStream = new FileInputStream(file);
				
		   	   File file2 =    new File(fileDestination);
		   	   FileInputStream inputStream2 = new FileInputStream(file);
				
		        // take buffer data from botm image files //
		        BufferedImage biA = ImageIO.read(inputStream);
		        DataBuffer dbA = biA.getData().getDataBuffer();
		        int sizeA = dbA.getSize();                      
		        BufferedImage biB = ImageIO.read(inputStream2);
		        DataBuffer dbB = biB.getData().getDataBuffer();
		        int sizeB = dbB.getSize();
		        // compare data-buffer objects //
		        if(sizeA == sizeB) {
		            for(int i=0; i<sizeA; i++) { 
		                if(dbA.getElem(i) != dbB.getElem(i)) {
		                    return false;
		                }
		            }
		            return true;
		        }
		        else {
		            return false;
		        }
		    } 
		    catch (Exception e) { 
		        System.out.println("Failed to compare image files ...");
		        return  false;
		    }
		}
}
