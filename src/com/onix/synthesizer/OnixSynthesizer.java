
package com.onix.synthesizer;

import java.awt.FontFormatException;
import java.io.IOException;
import javax.sound.midi.MidiUnavailableException;





public class OnixSynthesizer{

    private static MainSynth mainSynthesizer = new MainSynth();
  
    public static void main(String[] args) throws FontFormatException,
            IOException, MidiUnavailableException, InterruptedException {
       
        mainSynthesizer.MainSynt();
  
    }
    
}
