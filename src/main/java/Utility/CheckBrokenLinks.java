package Utility;
import java.net.HttpURLConnection;
import java.net.URL;
public class CheckBrokenLinks {
	 public static int getResponseCode(String link) {
	        URL url;
	        HttpURLConnection connection = null;
	        Integer responsecode = 0;
	        try {
	            url = new URL(link);
	            connection = (HttpURLConnection) url.openConnection();
	            responsecode = connection.getResponseCode();
	        } catch (Exception e) {
	           
	        } finally {
	            if (null != connection)
	            	connection.disconnect();
	        }
	        return responsecode;
	    }
}
