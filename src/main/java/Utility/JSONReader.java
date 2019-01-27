package Utility;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	JSONParser parser = new JSONParser();
	public String ReadJSONFile (String nodeValuie, String filePath) throws FileNotFoundException, IOException, ParseException
	{
		Object obj = parser.parse(new FileReader(filePath));

	    JSONObject jsonObject = (JSONObject) obj;
	    String value = (String) jsonObject.get(nodeValuie);
	    return value;
	}
}
