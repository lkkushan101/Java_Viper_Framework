package Utility;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;


public class SecurityRunner {
	
	  
	public void ZAPSecurityScanner(String zap_address, int zap_port, String zap_key, String targetURL) throws IOException, ClientApiException
	{
		  

		   
		        ClientApi api = new ClientApi(zap_address, zap_port, zap_key);

		        try {
		            // Start spidering the target
		            System.out.println("Spider : " + targetURL);
		            // It's not necessary to pass the ZAP API key again, already set when creating the
		            // ClientApi.
		            ApiResponse resp = api.spider.scan(targetURL, null, null, null, null);
		            String scanid;
		            int progress;

		            // The scan now returns a scan id to support concurrent scanning
		            scanid = ((ApiResponseElement) resp).getValue();

		            // Poll the status until it completes
		            while (true) {
		                Thread.sleep(1000);
		                progress =
		                        Integer.parseInt(
		                                ((ApiResponseElement) api.spider.status(scanid)).getValue());
		                System.out.println("Spider progress : " + progress + "%");
		                if (progress >= 100) {
		                    break;
		                }
		            }
		            System.out.println("Spider complete");

		            // Give the passive scanner a chance to complete
		            Thread.sleep(2000);

		         

		            System.out.println("Alerts in the scan are in the security.xml");
		                   
		                //Writing the xml report
		                java.io.FileWriter fw = new java.io.FileWriter("./SecurityReports/security.xml");
		                fw.write(new String(api.core.xmlreport(), StandardCharsets.UTF_8));
		                fw.close();
		        } catch (Exception e) {
		            System.out.println("Exception : " + e.getMessage());
		            e.printStackTrace();
		        }
		    }
	
}


