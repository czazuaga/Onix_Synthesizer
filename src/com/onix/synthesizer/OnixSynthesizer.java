
package com.onix.synthesizer;

import StyleResources.ImportFonts;
import java.awt.FontFormatException;
import java.io.IOException;


public class OnixSynthesizer {

    
    private static MainSynth mainSynthesizer = new MainSynth();
   
   
    public static void main(String[] args) throws FontFormatException, IOException {
       
        ImportFonts importarFuentes = new ImportFonts();
        
        mainSynthesizer.MainSynt();
        
        
    }
    
    
    
}
