
package onix.Modules;

import StyleResources.Colors;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.FilterHighPass;
import com.jsyn.unitgen.FilterLowPass;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.MixerStereo;
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


public class FilterModule implements ActionListener {
    
    private JPanelFactory jPanel;    
    protected URL buttonURL,ledOnUrl,ledOffUrl;
    protected Icon selectFilterButtonIcon,led1Icon,led2Icon;  
    public JLabel led1,led2; 
    private  KnobModule cutOffLowPass,cutOffHighPass;
    private JButton selectFilterButton = new JButton();
    
    private int filterNum =0;
    
    
    //Get instances of the modules to process
    private WhiteNoiseModule whiteNoiseModule;
    private Osc1Module os1Module;
    
    
    public FilterLowPass filterLowPass= new FilterLowPass();
    public FilterHighPass filterHighPass= new FilterHighPass();  
    private Synthesizer synth;   
    private LineOut lineOut= new  LineOut();;   
    private MixerStereo mixer = new MixerStereo(2);

    // Constructor -------------------------------------

    
    public FilterModule (JPanel downPanel,Synthesizer mainSynth) {

        this.synth=mainSynth;
                   
        synth.add(this.filterLowPass);
        synth.add(this.filterHighPass);
        synth.add(this.lineOut);
        
        lineOut.start();
                
        jPanel=new JPanelFactory(downPanel,3,3, 252, 126, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
        
   
        filterLowPass.output.connect(mixer.input);

        synth.add(mixer);
        mixer.output.connect(0,this.lineOut.input,0);//Right channel
        mixer.output.connect(0,this.lineOut.input,1);//Left channel
        mixer.start();
       
       
             cutOffLowPass = new KnobModule(filterLowPass.frequency, jPanel, 0, 6000, 0,
            170,18,50,50);
             
             cutOffHighPass = new KnobModule(filterHighPass.frequency, jPanel, 0, 10000, 0,
            170,18,50,50);
        
             cutOffHighPass.setActive(false);
        
  
        selectFilterButton();
    
        FilterChange();
        
        addLabels();
    
    }

    
    //--------------------------------------------------
    
    protected void  addLabels () {
    
        JLabel jLabelModuleName = new JLabel("Filter");
        
        jLabelModuleName.setFont(new Font("2Tech", 0, 15));
        jLabelModuleName.setBounds(20, 0, 200, 40);
        jLabelModuleName.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(jLabelModuleName);
        
        
        JLabel jLabelKnobName = new JLabel("CutOff");
        
        jLabelKnobName.setFont(new Font("2Tech", 1, 11));
        jLabelKnobName.setBounds(172, 70, 200, 20);
        jLabelKnobName.setForeground(Colors.BRIGHT_BLUE);
        jPanel.add(jLabelKnobName);
        
        JLabel jLabelHP = new JLabel("HP");
        
        jLabelHP.setFont(new Font("2Tech", 1, 11));
        jLabelHP.setBounds(50, 56, 32, 32);
        jLabelHP.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(jLabelHP);
        
        JLabel jLabelLP = new JLabel("LP");
        
        jLabelLP.setFont(new Font("2Tech", 1, 11));
        jLabelLP.setBounds(50, 30, 32, 32);
        jLabelLP.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(jLabelLP);
        
    }
    
    //-------------------------------------------------
    
    protected void selectFilterButton () { 
 
        buttonURL = getClass().getResource("/images/button.png");
  
        selectFilterButtonIcon = new ImageIcon(buttonURL);
          
        selectFilterButton.addActionListener(this);
        selectFilterButton.setActionCommand("selectFilter");
        selectFilterButton.setBackground(Colors.DARK_BLUE);
        selectFilterButton.setBorder(null);
        selectFilterButton.setIcon(new ImageIcon(buttonURL));
        selectFilterButton.setBounds(100, 43, 43, 42);
        
        jPanel.add(selectFilterButton);
        
    }
    
    //---------------------------------------------------
    
    protected void FilterChange () {
    
        ledOnUrl = getClass().getResource("/images/ledOn.png");
        ledOffUrl = getClass().getResource("/images/ledOff.png"); 
   
        
        led1Icon=new ImageIcon(ledOnUrl);
        led1 = new JLabel(led1Icon);
        led1.setBackground(Colors.DARK_BLUE);
        led1.setBounds(20,30, 32, 32);
        jPanel.add(led1);
        
        led2Icon=new ImageIcon(ledOffUrl);
        led2 = new JLabel(led2Icon);
        led2.setBackground(Colors.DARK_BLUE);
        led2.setBounds(20,56, 32, 32);
        jPanel.add(led2);
   
        
    }
    
    /* 1 is LowPass Filter and 2 is HighPass Filter this methods are
    modified from the "onix.funtional.modules.ButtonConfig" class
    */
    
    
    public int getFilterType (){
    
        return this.filterNum;
        
    }
    
    public void setFilterType (int filterNum) {

    this.filterNum=filterNum;
    
    }

    //-----------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      
         if (ae.getActionCommand().equals("selectFilter")){
            
             
             
            if(getFilterType()==0){
    
                led1.setIcon(led2Icon);
                led2.setIcon(led1Icon);
                
              filterNum=1;
              
            }else{
          
                led1.setIcon(led1Icon);
                led2.setIcon(led2Icon);
                
              filterNum=0;
            }     
            System.out.println(getFilterType());
            cambioDeFiltro();
        }
   
    }
    
    void cambioDeFiltro(){
    
    if(filterNum==0){

        filterLowPass.output.connect(mixer.input);
        filterHighPass.output.disconnect(mixer.input);
        
        cutOffHighPass.setActive(false);
        cutOffLowPass.setActive(true);
        
        whiteNoiseModule.setFilterLowpass();
        os1Module.setFilterLowpass();
        
 
        ///////////////////////////
        System.out.println("Se ha ejecutado filtro paso bajo");
        
    }else if(filterNum==1){
        
        filterLowPass.output.disconnect(mixer.input);
        filterHighPass.output.connect(mixer.input);
        
        cutOffLowPass.setActive(false);
        cutOffHighPass.setActive(true);
        
        whiteNoiseModule.setFilterHighpass();
        os1Module.setFilterHighpass();
        
 
        ///////////////////////////
        System.out.println("Se ha ejecutado filtro paso alto");
        
    }  
    }
   
    
    //Get instances of the modules to process
    public void getNoiseModuleInstance(WhiteNoiseModule whiteNoiseModule){
    this.whiteNoiseModule=whiteNoiseModule;
        
    }
    
    public void getOsc1ModuleInstance(Osc1Module osc1Module){
    this.os1Module=osc1Module;
        
    }
    
}
