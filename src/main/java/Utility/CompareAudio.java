package Utility;
import org.testng.annotations.Test;

import com.musicg.fingerprint.FingerprintManager;
import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.fingerprint.FingerprintSimilarityComputer;
import com.musicg.wave.Wave;
import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;
public class CompareAudio {

@Test
public float compareMusic(String sourcefile01, String sourcefile02) throws JavaLayerException
{
	    new Converter().convert(sourcefile01, "./AudioCompare/1.wave");
	    new Converter().convert(sourcefile02, "./AudioCompare/2.wave");
	    // Fingerprint from WAV
	    byte[] firstFingerPrint = new FingerprintManager().extractFingerprint(new Wave("./AudioCompare/1.wave"));
	    byte[] secondFingerPrint = new FingerprintManager().extractFingerprint(new Wave("./AudioCompare/2.wave"));
	    // Compare fingerprints
	   FingerprintSimilarity fingerprintSimilarity = new FingerprintSimilarityComputer(firstFingerPrint, secondFingerPrint).getFingerprintsSimilarity();
	   return fingerprintSimilarity.getSimilarity();
	  
}


}
