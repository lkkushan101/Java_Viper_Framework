package Test;
import org.testng.annotations.Test;

import  Utility.*;
public class TestSSH {

	@Test 
	public void testCase()
	{
		SSHRunner ssh = new SSHRunner();
		ssh.runSSHCommand("testlk\\kushan1", "112.123.122.18", "password","dir");
	}
}
