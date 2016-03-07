
package com.onix.synthesizer;

import StyleResources.ImportFonts;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import onix.funcional.modules.MidiControl;



public class OnixSynthesizer {

    
    private static MainSynth mainSynthesizer = new MainSynth();
  
   
    public static void main(String[] args) throws FontFormatException,
            IOException, MidiUnavailableException, InterruptedException {
       
        ImportFonts importarFuentes = new ImportFonts();
        mainSynthesizer.MainSynt();
       
        
        
    }
    
    
    
}
