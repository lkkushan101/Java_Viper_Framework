package Utility;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.github.seratch.jslack.*;
import com.github.seratch.jslack.api.webhook.*;
public class SlackReporter {

	public void slackReporter(String testStatus, String userName, String channel) throws IOException, ParseException
	{
		JSONReader _JSONRead = new JSONReader();
		
		String url = _JSONRead.ReadJSONFile("Slack_URL", ".\\Data\\SlackConfigure.json");

		Payload payload = Payload.builder()
		  .channel(channel)
		  .username(userName)
		  .iconEmoji(":grin:")
		  .text(testStatus)
		  .build();

		Slack slack = Slack.getInstance();
		WebhookResponse response = slack.send(url, payload);
	}
}
