package Utility;

import java.util.Locale;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer; 
import javax.speech.synthesis.SynthesizerModeDesc; 

public class SpeachReporting {
	public Synthesizer setupSpeachReporting() throws EngineException
	{
		 System.setProperty("freetts.voices", 
		            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");  
		              
		       
		        Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral"); 

		      
		        Synthesizer synthesizer =                                          
		            Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));      
		      
		        return synthesizer;
		      
	}

	public void speachReport(String logStatement, Synthesizer syn) throws EngineException, AudioException, EngineStateError, IllegalArgumentException, InterruptedException
	{
       
	
		syn.allocate();         
          
       
		syn.resume();     
          
		syn.speakPlainText(logStatement, null);          
		syn.waitEngineState(Synthesizer.QUEUE_EMPTY);
		//syn.cancelAll();
        // Deallocate the Synthesizer. 
         
		//syn.deallocate(); 
		
	}
}