
package onix.Modules;

import StyleResources.Colors;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.EnvelopeDAHDSR;
import com.jsyn.unitgen.SineOscillator;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;
import onix.funcional.modules.KnobModule;


public class AmpEnvelopeModule {

private KnobModule attackKnob,decayKnob,sustainKnob,releaseKnob;
private JPanelFactory jPanel;
public EnvelopeDAHDSR envelope = new EnvelopeDAHDSR();

private FilterModule filterModule;
private Osc1Module osc1Module;
public SineOscillator gatingOsc;

    
public AmpEnvelopeModule (JPanel downPanel,Synthesizer mainSynth,
            FilterModule filterModule,Osc1Module osc1Module){

this.filterModule = filterModule; 
this.osc1Module = osc1Module;
    
jPanel = new JPanelFactory(downPanel, 256, 3, 168, 126,
        Colors.DARK_BLUE, 1, Colors.CLEAN_WHITE);

mainSynth.add(envelope);
addLabels ();

createKnobs (); 

envelope.delay.set(0);


}
    
protected void  addLabels () {
    
        JLabel jLabelModuleName = new JLabel("Lfo Envelope");
        
        jLabelModuleName.setFont(new Font("2Tech", 0, 15));
        jLabelModuleName.setBounds(20, 0, 200, 40);
        jLabelModuleName.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(jLabelModuleName);
        
        
        JLabel jLabelKnobAttackName = new JLabel("Attack");
        
        jLabelKnobAttackName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobAttackName.setBounds(22, 88, 58, 32);
        jLabelKnobAttackName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobAttackName);
        
        JLabel jLabelKnobDecayName = new JLabel("Sustain");
        
        jLabelKnobDecayName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobDecayName.setBounds(93, 88, 58, 32);
        jLabelKnobDecayName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobDecayName);
       
        
        
        
    }
    
private void createKnobs () {
    
attackKnob = new KnobModule(envelope.attack, jPanel, 0, 1, 0, 22, 38, 50, 50);
decayKnob = new KnobModule(envelope.sustain, jPanel, 0, 1, 0.5, 87, 38, 50, 50);   
    
}

}
