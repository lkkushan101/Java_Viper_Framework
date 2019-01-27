package Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.*;
import javazoom.jl.decoder.JavaLayerException;

public class TestMusicCompare {

@Test
public void compareMusicTest() throws JavaLayerException 
{
	  CompareAudio cmp = new CompareAudio ();
	  float similarity = cmp.compareMusic("./AudioCompare/SampleAudio_0.4mb.mp3", "./AudioCompare/SampleAudio_0.5mb.mp3");
	  System.out.println("Similarity score = " + similarity);
  
}


}
