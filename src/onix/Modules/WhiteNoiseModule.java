
package onix.Modules;

import StyleResources.Colors;
import com.jsyn.Synthesizer;
import com.jsyn.ports.UnitInputPort;
import com.jsyn.ports.UnitPort;
import com.jsyn.unitgen.FilterBiquadCommon;
import com.jsyn.unitgen.FilterLowPass;
import com.jsyn.unitgen.WhiteNoise;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;
import onix.funcional.modules.KnobModule;


public class WhiteNoiseModule {
   
   private  JPanelFactory jPanel;
   
   private  WhiteNoise whiteNoise;
  
   private  KnobModule ampKnob;
   
   
   
   
    
    public WhiteNoiseModule (JPanel rightPanel,Synthesizer mainSynth,FilterLowPass lowpassFilter) {
    
        jPanel=new JPanelFactory(rightPanel,0,185, 235, 109, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
        
        whiteNoise = new WhiteNoise();
        
        ampKnob = new KnobModule(whiteNoise.amplitude, jPanel, 0, 1, 0,90,37,50,50);
        
        whiteNoise.output.connect(lowpassFilter.input);

        addLabels();
        mainSynth.add(whiteNoise);
    } 

    public void  addLabels () {
    
        JLabel jLabelModuleName = new JLabel("White Noise");
        
        jLabelModuleName.setFont(new Font("2Tech", 0, 15));
        jLabelModuleName.setBounds(20, 0, 200, 40);
        jLabelModuleName.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(jLabelModuleName);
        
        
        JLabel jLabelKnobName = new JLabel("Amp");
        
        jLabelKnobName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobName.setBounds(103, 88, 200, 20);
        jLabelKnobName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobName);
    }
    
    
    
}
