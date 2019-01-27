package Utility;
import com.jcraft.jsch.*;
public class SFTPRunner {
	
	public void downloadSFTPFile (String ip_address, int port , String user, String password, String dest_file, String source_file)
	{
		   JSch jsch = new JSch();
	        Session session = null;
	        try {
	            session = jsch.getSession(user, ip_address, port);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.setPassword(password);
	            session.connect();

	            Channel channel = session.openChannel("sftp");
	            channel.connect();
	            ChannelSftp sftpChannel = (ChannelSftp) channel;
	            sftpChannel.get(source_file,dest_file);
	            sftpChannel.exit();
	            session.disconnect();
	        } catch (JSchException e) {
	            e.printStackTrace();  
	        } catch (SftpException e) {
	            e.printStackTrace();
	        }
	    }
	

}
