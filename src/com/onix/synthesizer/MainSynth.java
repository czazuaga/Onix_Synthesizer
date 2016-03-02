
package com.onix.synthesizer;
import StyleResources.Colors;
import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.LineOut;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import onix.Modules.FilterModule;
import onix.Modules.LogoModule;
import onix.Modules.PresetsModule;
import onix.Modules.WhiteNoiseModule;


public class MainSynth {
    
JFrame jFrame;
    
JPanel fullPanel,topPanel,downPanel,leftPanel,centerPanel,rightPanel;
    
Synthesizer synth;
LineOut myOut;
    
    
    void MainSynt() {
        
        initComoponents(); 
        
    }
            

    private void initComoponents() {
       //Init synth components
        myOut = new LineOut();
        synth = JSyn.createSynthesizer();   
       
        jFrame = new JFrame("Onix Synthesizer");
        fullPanel = new JPanel(null);
        topPanel = new JPanel(null);
        downPanel = new JPanel(null);
        leftPanel = new JPanel(null);
        centerPanel = new JPanel(null);
        rightPanel = new JPanel(null);
   
    createPanels();
        
    }
    
    
    
    private void configSynth (){
        
      int numInputChannels = 2;
      int numOutputChannels = 2;
        
        synth.start( 44100, AudioDeviceManager.USE_DEFAULT_DEVICE, numInputChannels, AudioDeviceManager.USE_DEFAULT_DEVICE,
             numOutputChannels );     
  
        
    }
    
    
    
    private void createModules () {
        LogoModule logoModule = new LogoModule(topPanel);
        
        FilterModule filterModule = new FilterModule(downPanel, synth);

        WhiteNoiseModule whiteNoiseModule = new WhiteNoiseModule(rightPanel,
                synth,filterModule);
       
        filterModule.getNoiseModuleInstance(whiteNoiseModule);
        
        PresetsModule presetsModule = new PresetsModule(topPanel);
    }
    
    
    private void createPanels () {
        
        topPanel.setBackground(Color.BLACK);
        topPanel.setBounds(0, 0,784, 132);
        topPanel.setBorder(BorderFactory.createLineBorder(Colors.SWEET_PINK, 3));   
        
        downPanel.setBackground(Color.BLUE);
        downPanel.setBounds(0, 429,784, 132);
        downPanel.setBorder(BorderFactory.createLineBorder(Colors.SWEET_PINK, 3));
   
        leftPanel.setBackground(Color.RED);
        leftPanel.setBounds(0, 132,256, 297);
        leftPanel.setBorder(BorderFactory.createLineBorder(Colors.SWEET_PINK, 3));
 
        centerPanel.setBackground(Color.PINK);
        centerPanel.setBounds(256, 132,290, 297);
        centerPanel.setBorder(BorderFactory.createLineBorder(Colors.SWEET_PINK, 3));
          
        rightPanel.setBackground(Color.ORANGE);
        rightPanel.setBounds(546, 132,238, 297);
        rightPanel.setBorder(BorderFactory.createLineBorder(Colors.SWEET_PINK, 3));
        
        configSynth();
        
        createModules();
         
        fullPanel.add(topPanel);
         fullPanel.add(downPanel);
         fullPanel.add(leftPanel);
         fullPanel.add(centerPanel);
         fullPanel.add(rightPanel);
        
         createMainWindow();
                 
    }
    
    
    private void createMainWindow(){
    
    fullPanel.setBackground(Color.yellow);
    
    jFrame.setBounds(0, 0, 790, 590);   
    jFrame.setVisible(true);
    jFrame.setResizable(false);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
    jFrame.add(fullPanel);    
    
    }
    
}
