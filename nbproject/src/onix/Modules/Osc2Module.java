
package onix.Modules;

import StyleResources.Colors;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.UnitOscillator;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;
import onix.funcional.modules.KnobModule;


public class Osc2Module {
  
    
private  JPanelFactory jPanel;
    
    protected URL buttonURL,ledOnUrl,ledOffUrl;
    protected Icon selectFilterButtonIcon,led1Icon,led2Icon;
    
    public   UnitOscillator Osc;
    private  KnobModule semiToneKnob,mixKnob;
    private JButton selectFilterButton = new JButton();
    
    private Synthesizer synth;
    
    private int OscNum =0;
    
    public JLabel led1,led2;
    
    private FilterModule filterModule;
    
    
    
    public Osc2Module(JPanel leftPanel,Synthesizer mainSynth,
            FilterModule filterModule){
        
    this.filterModule=filterModule;
    this.synth=mainSynth;
        
    jPanel=new JPanelFactory(leftPanel,3,148, 252, 145, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
    
    }
    
    
    public void setFilterLowpass(){
    Osc.output.disconnect(filterModule.filterHighPass.input);
    Osc.output.connect(filterModule.filterLowPass.input);
    }
    
    public void setFilterHighpass(){
    Osc.output.disconnect(filterModule.filterLowPass.input);
    Osc.output.connect(filterModule.filterHighPass.input);
    }
    
    
}
