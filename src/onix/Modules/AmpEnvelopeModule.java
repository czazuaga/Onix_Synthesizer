
package onix.Modules;

import StyleResources.Colors;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.EnvelopeDAHDSR;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import java.awt.Color;
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
    
jPanel = new JPanelFactory(downPanel, 255, 3, 291, 126,
        Colors.DARK_BLUE, 1, Colors.CLEAN_WHITE);

mainSynth.add(envelope);
addLabels ();

createKnobs (); 

envelope.delay.set(0);


    
mainSynth.add( gatingOsc = new SineOscillator() );
gatingOsc.frequency.setup( 0.001, 0.001, 10.0 );
gatingOsc.frequency.setName("Rate");


//gatingOsc.output.connect(envelope.input);

//envelope.output.connect(filterModule.mixerOut.amplitude);



//.output.connect(0,this.lineOut.input,0);//Right channel
//mixer.output.connect(0,this.lineOut.input,1);//Left channel

}
    
protected void  addLabels () {
    
        JLabel jLabelModuleName = new JLabel("Amplifier Envelope");
        
        jLabelModuleName.setFont(new Font("2Tech", 0, 15));
        jLabelModuleName.setBounds(20, 0, 200, 40);
        jLabelModuleName.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(jLabelModuleName);
        
        
        JLabel jLabelKnobAttackName = new JLabel("Attack");
        
        jLabelKnobAttackName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobAttackName.setBounds(22, 88, 58, 32);
        jLabelKnobAttackName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobAttackName);
        
        JLabel jLabelKnobDecayName = new JLabel("Decay");
        
        jLabelKnobDecayName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobDecayName.setBounds(93, 88, 58, 32);
        jLabelKnobDecayName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobDecayName);
       
        JLabel jLabelKnobSustainName = new JLabel("Sustain");
        
        jLabelKnobSustainName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobSustainName.setBounds(150, 88, 58, 32);
        jLabelKnobSustainName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobSustainName);
        
        JLabel jLabelKnobReleaseName = new JLabel("Release");
        
        jLabelKnobReleaseName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobReleaseName.setBounds(217, 88, 58, 32);
        jLabelKnobReleaseName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobReleaseName);
        
    }
    
private void createKnobs () {
attackKnob = new KnobModule(envelope.attack, jPanel, 0, 1, 0, 22, 38, 50, 50);
decayKnob = new KnobModule(envelope.decay, jPanel, -90, 0, -90, 87, 38, 50, 50);
sustainKnob = new KnobModule(envelope.sustain, jPanel, 0, 1, 0.5, 152, 38, 50, 50);
releaseKnob = new KnobModule(envelope.release, jPanel, -90, 0, -90, 217, 38, 50, 50);
    
    
}

}
