


package onix.Modules;

import StyleResources.Colors;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.MixerStereo;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;
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




public class Osc1Module implements ActionListener {
    
    private  JPanelFactory jPanel;
    public JLabel led1,led2,led3,led4,shapeFormsJLabel;
    
    protected URL buttonURL,ledOnUrl,ledOffUrl,shapesUrl;
    protected Icon selectOscShapeButtonIcon,shapesIcon,ledOnIcon,ledOffIcon;
    
    public   UnitOscillator sawOsc,squareOsc,triangleOsc,sineOsc;
    
    private  KnobModule sawPitchKnob,sawAmpKnob,squPitchKnob,squAmpKnob,
            triPitchKnob,triAmpKnob,sinePitchKnob,sineAmpKnob;
    
    private JButton selectFilterButton = new JButton();
    
    private Synthesizer synth;
    
    private int oscNum =0;
    
    private FilterModule filterModule;
    
    //Config Oscillators : INIT
    
    public static final int MAX_VOICES=8;
    
    public MixerStereo mixerAllOscillators = new MixerStereo(4);
    
    private MixerStereo mixerSawOscillators = new MixerStereo(MAX_VOICES);
    private MixerStereo mixerSquareOscillators = new MixerStereo(MAX_VOICES);
    private MixerStereo mixerTriangleOscillators = new MixerStereo(MAX_VOICES);
    private MixerStereo mixerSineOscillators = new MixerStereo(MAX_VOICES);
    
    public SawtoothOscillator[] sawOscillatorsArray = new SawtoothOscillator[MAX_VOICES];
    public SquareOscillator[] squareOscillatorsArray = new SquareOscillator[MAX_VOICES];
    public TriangleOscillator[] triangleOscillatorsArray = new TriangleOscillator[MAX_VOICES];
    public SineOscillator[] sineOscillatorsArray = new SineOscillator[MAX_VOICES];
    
    
    //------------------------
    
    
    
    //Constructor
    
    public Osc1Module(JPanel leftPanel,Synthesizer mainSynth,
            FilterModule filterModule){
        
    this.filterModule=filterModule;
    this.synth=mainSynth;
    
    
     //Config Oscillators 
    
     //Saw  
    for (int i =0;i<MAX_VOICES;i++){
     
    sawOscillatorsArray[i] = new SawtoothOscillator();
    synth.add(sawOscillatorsArray[i]);
    sawOscillatorsArray[i].output.connect(mixerSawOscillators);
    sawOscillatorsArray[i].amplitude.set(0);    
    sawOscillatorsArray[i].start();
       
    }
    
    //Square
    for (int i =0;i<MAX_VOICES;i++){
     
    squareOscillatorsArray[i] = new SquareOscillator();
    synth.add(squareOscillatorsArray[i]);
    squareOscillatorsArray[i].amplitude.set(0);
    squareOscillatorsArray[i].output.connect(mixerSquareOscillators);
        
    }
    
    //Triangle
    for (int i =0;i<MAX_VOICES;i++){
     
    triangleOscillatorsArray[i] = new TriangleOscillator();
    synth.add(triangleOscillatorsArray[i]);
    triangleOscillatorsArray[i].amplitude.set(0);
    triangleOscillatorsArray[i].output.connect(mixerTriangleOscillators);
        
    }
    
    //Sine
    for (int i =0;i<MAX_VOICES;i++){
     
    sineOscillatorsArray[i] = new SineOscillator();
    synth.add(sineOscillatorsArray[i]);
    sineOscillatorsArray[i].amplitude.set(0);
    sineOscillatorsArray[i].output.connect(mixerSineOscillators);
        
    }
  
    //Connect the oscillators outputs to the Osc1Module main mixer 
    
        mixerSawOscillators.output.connect(mixerAllOscillators.input);
        mixerSquareOscillators.output.connect(mixerAllOscillators.input);
        mixerTriangleOscillators.output.connect(mixerAllOscillators.input);
        mixerSineOscillators.output.connect(mixerAllOscillators.input);
        
     //--------------------------
     
    mixerAllOscillators.output.connect(filterModule.filterLowPass.input); 
    
    
    sawOsc = new SawtoothOscillator();
    squareOsc = new SquareOscillator();
    triangleOsc = new TriangleOscillator();
    sineOsc = new SineOscillator();
    
    synth.add(sawOsc);
    synth.add(squareOsc);
    synth.add(triangleOsc);
    synth.add(sineOsc);
    
    
    

        
    jPanel=new JPanelFactory(leftPanel,3,3, 252, 145, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
    
    
    sawAmpKnob = new KnobModule(mixerSawOscillators.amplitude, jPanel, 0, 1, 0,175,11,50,50);    
    sawPitchKnob = new KnobModule(sawOsc.frequency, jPanel, 0, 300, 0,102,11,50,50);
    
    squAmpKnob = new KnobModule(mixerSquareOscillators.amplitude, jPanel, 0, 1, 0,175,11,50,50);    
    squPitchKnob = new KnobModule(squareOsc.frequency, jPanel, 0, 300, 0,102,11,50,50);
    
   triAmpKnob = new KnobModule(mixerTriangleOscillators.amplitude, jPanel, 0, 1, 0,175,11,50,50);    
    triPitchKnob = new KnobModule(triangleOsc.frequency, jPanel, 0, 300, 0,102,11,50,50);
    
    sineAmpKnob = new KnobModule(mixerSineOscillators.amplitude, jPanel, 0, 1, 0,175,11,50,50);    
    sinePitchKnob = new KnobModule(sineOsc.frequency, jPanel, 0, 300, 0,102,11,50,50);
    
    
    oscShapeUI();
    
    addLabels();
    
    selectOscButton();
    }
    
    ///////////////////////////////////
    
    protected void  addLabels () {
    
        JLabel jLabelModuleName = new JLabel("Osc I");
        
        jLabelModuleName.setFont(new Font("2Tech", 0, 15));
        jLabelModuleName.setBounds(20, 0, 200, 40);
        jLabelModuleName.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(jLabelModuleName);
        
        
        JLabel jLabelKnobName = new JLabel("SEMI");
        
        jLabelKnobName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobName.setBounds(110, 56, 40, 32);
        jLabelKnobName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobName);
        
        JLabel jLabelHP = new JLabel("AMP");
        
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
   
        
        led3 = new JLabel(ledOffIcon);
        led3.setBackground(Colors.DARK_BLUE);
        led3.setBounds(20,82, 32, 32);
        jPanel.add(led3);
        
        
        led4 = new JLabel(ledOffIcon);
        led4.setBackground(Colors.DARK_BLUE);
        led4.setBounds(20,108, 32, 32);
        jPanel.add(led4);

        
        shapeFormsJLabel = new JLabel(shapesIcon);
        shapeFormsJLabel.setBackground(Colors.DARK_BLUE);
        shapeFormsJLabel.setBounds(50, 34, 39,101);
        jPanel.add(shapeFormsJLabel);
        
        
    }
    
    ///////////////////////////////////
    
    
    public void setFilterLowpass(){
        
    mixerAllOscillators.output.disconnect(filterModule.filterHighPass.input);
   mixerAllOscillators.output.connect(filterModule.filterLowPass.input);
       
    }
    
    public void setFilterHighpass(){
        
    mixerAllOscillators.output.disconnect(filterModule.filterLowPass.input);
   mixerAllOscillators.output.connect(filterModule.filterHighPass.input);
        
    }
    
    
    /* 1 is LowPass Filter and 2 is HighPass Filter this methods are
    modified from the "onix.funtional.modules.ButtonConfig" class
    */
    
    
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
          
                led3.setIcon(ledOnIcon);
                led2.setIcon(ledOffIcon);
                
                
              oscNum=2;
            }else if (getOscType()==2){
          
                led3.setIcon(ledOffIcon);
                led4.setIcon(ledOnIcon);
                
              oscNum=3;
            }else if (getOscType()==3){
          
                led4.setIcon(ledOffIcon);
                led1.setIcon(ledOnIcon);
                
              oscNum=0;
            }         
            
            System.out.println(getOscType());
            OscTypeChange();
        }
   
    }
    
    ////////////////////////////////////
    
    void OscTypeChange(){
    
    if(oscNum==0){
        

        sineAmpKnob.setActive(false);
        sinePitchKnob.setActive(false);
        
        triAmpKnob.setActive(false);
        triPitchKnob.setActive(false);
        
        squAmpKnob.setActive(false);
        squPitchKnob.setActive(false);
        
        sawAmpKnob.setActive(true);
        sawPitchKnob.setActive(true);

        
    }else if(oscNum==1){
        

        sineAmpKnob.setActive(false);
        sinePitchKnob.setActive(false);
        
        triAmpKnob.setActive(false);
        triPitchKnob.setActive(false);
        
        squAmpKnob.setActive(true);
        squPitchKnob.setActive(true);
        
        sawAmpKnob.setActive(false);
        sawPitchKnob.setActive(false);

        
    }else if(oscNum==2){
        

        sineAmpKnob.setActive(false);
        sinePitchKnob.setActive(false);
        
        triAmpKnob.setActive(true);
        triPitchKnob.setActive(true);
        
        squAmpKnob.setActive(false);
        squPitchKnob.setActive(false);
        
        sawAmpKnob.setActive(false);
        sawPitchKnob.setActive(false);

        
    }else if(oscNum==3){
        

        sineAmpKnob.setActive(true);
        sinePitchKnob.setActive(true);
        
        triAmpKnob.setActive(false);
        triPitchKnob.setActive(false);
        
        squAmpKnob.setActive(false);
        squPitchKnob.setActive(false);
        
        sawAmpKnob.setActive(false);
        sawPitchKnob.setActive(false);
    
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
