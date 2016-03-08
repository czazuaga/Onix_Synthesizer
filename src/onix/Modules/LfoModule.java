
package onix.Modules;

import StyleResources.Colors;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;
import onix.funcional.modules.KnobModule;


public class LfoModule implements ActionListener {
    
    
   
    private  JPanelFactory jPanel;
    public JLabel led1,led2,led3,led4,led5,shapeFormsJLabel;
    
    protected URL buttonURL,ledOnUrl,ledOffUrl,shapesUrl;
    protected Icon selectOscShapeButtonIcon,shapesIcon,ledOnIcon,ledOffIcon;
    
    private  KnobModule sineRate;
    
    private JButton selectFilterButton = new JButton();
    
    private Synthesizer synth;
    
    private int oscNum =0;
    
    private FilterModule filterModule;
    private AmpEnvelopeModule ampEnvelopeModule;
    

    public SineOscillator sineOsc = new SineOscillator();
    
    
    
     //Constructor
    
    public LfoModule(JPanel rightPanel,Synthesizer mainSynth,
            FilterModule filterModule,AmpEnvelopeModule ampEnvelopeModule){
        
        
    this.filterModule=filterModule;
    this.synth=mainSynth;
    this.ampEnvelopeModule=ampEnvelopeModule;
    
    
 
    sineOsc.frequency.setup( 0.001, 1, 10.0 );
    
    
  
    synth.add(sineOsc);
    
    jPanel=new JPanelFactory(rightPanel,0,3, 235, 182, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
    

      
    sineRate = new KnobModule(sineOsc.frequency, jPanel, 0.001, 10.0, 5,175,11,50,50);    
    
    
    
    oscShapeUI();
    
    addLabels();
    
    selectOscButton();
    
    }
    
    
    
    //---------------------------------------
    
    protected void  addLabels () {
    
        JLabel jLabelModuleName = new JLabel("LFO");
        
        jLabelModuleName.setFont(new Font("2Tech", 0, 15));
        jLabelModuleName.setBounds(20, 0, 200, 40);
        jLabelModuleName.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(jLabelModuleName);
        
        
        JLabel offLabel = new JLabel("OFF");
        
        offLabel.setFont(new Font("2Tech", 1, 15));
        offLabel.setBounds(55, 29, 40, 32);
        offLabel.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(offLabel);
        
        
        JLabel onLabel = new JLabel("ON");
        
        onLabel.setFont(new Font("2Tech", 1, 15));
        onLabel.setBounds(55, 55, 40, 32);
        onLabel.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(onLabel);
        
        
        JLabel jLabelHP = new JLabel("RATE");
        
        jLabelHP.setFont(new Font("2Tech", 1, 11));
        jLabelHP.setBounds(187, 56, 32, 32);
        jLabelHP.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelHP);
          
        
    }
    
    protected void oscShapeUI () {
    
        ledOnUrl = getClass().getResource("/images/ledOn.png");
        ledOffUrl = getClass().getResource("/images/ledOff.png"); 
        shapesUrl = getClass().getResource("/images/shapes.png");
   
        
        ledOnIcon=new ImageIcon(ledOnUrl);
        ledOffIcon=new ImageIcon(ledOffUrl);
        shapesIcon=new ImageIcon(shapesUrl);
        
        led1 = new JLabel(ledOnIcon);
        led1.setBackground(Colors.DARK_BLUE);
        led1.setBounds(20,30, 32, 32);
        jPanel.add(led1);
        
        
        led2 = new JLabel(ledOffIcon);
        led2.setBackground(Colors.DARK_BLUE);
        led2.setBounds(20,56, 32, 32);
        jPanel.add(led2);
     
    }
    
    
    
    
    public int getOscType (){
    
        return this.oscNum;
        
    }
    
    public void setOscType (int oscNum) {

    this.oscNum=oscNum;
    
    }

    //-----------------------------------------------
    
    
     @Override
    public void actionPerformed(ActionEvent ae) {
      
         if (ae.getActionCommand().equals("selectOsc")){
            
             
             
            if(getOscType()==0){
    
                led1.setIcon(ledOffIcon);
                led2.setIcon(ledOnIcon);
                
              oscNum=1;
              
            }else if (getOscType()==1){
          
                led2.setIcon(ledOffIcon);
                led1.setIcon(ledOnIcon);
                
              oscNum=0;
            }                  
            
            System.out.println(getOscType());
            OscTypeChange();
        }
   
    }
    
    ////////////////////////////////////
    
    
    
    ////////////////////////////////////
    
    void OscTypeChange(){
    
    if(oscNum==1){
        
        sineOsc.output.connect(ampEnvelopeModule.envelope.input);
        ampEnvelopeModule.envelope.output.connect(filterModule.mixerOut.amplitude);
              
    }else if(oscNum==0){
         
        sineOsc.output.disconnect(ampEnvelopeModule.envelope.input);
        
        ampEnvelopeModule.envelope.output.disconnect(filterModule.mixerOut.amplitude);      

    }                
    }
    
    //-------------------------------------------------
    
    protected void selectOscButton () { 
 
        buttonURL = getClass().getResource("/images/button.png");
        
        selectOscShapeButtonIcon = new ImageIcon(buttonURL);
          
        selectFilterButton.addActionListener(this);
        selectFilterButton.setActionCommand("selectOsc");
        selectFilterButton.setBackground(Colors.DARK_BLUE);
        selectFilterButton.setBorder(null);
        selectFilterButton.setIcon(new ImageIcon(buttonURL));
        selectFilterButton.setBounds(108, 90, 43, 42);
        
        jPanel.add(selectFilterButton);
        
    }
    
    //---------------------------------------------------
}
