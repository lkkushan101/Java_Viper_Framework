package Utility;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Reusable_Requests.GetRequest;
import Utility.*;
public class TelegramReporter {
  public void TelegramReporter (String text) throws FileNotFoundException, IOException, ParseException
  {
	    String response;
		JSONReader _JSONRead = new JSONReader();
		GetRequest _getReq = new GetRequest();
		String chatID = _JSONRead.ReadJSONFile("Chat_ID", ".\\Data\\Telegram_Configure.json");

		String bot_auth = _JSONRead.ReadJSONFile("Bot_Auth", ".\\Data\\Telegram_Configure.json");
		String Req_URL = "https://api.telegram.org/bot"+bot_auth+"/sendMessage?chat_id="+chatID+"&text="+text+"";
		response = _getReq.getRequest(Req_URL);
  }
}
