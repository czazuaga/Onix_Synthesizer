
package com.onix.synthesizer;
import StyleResources.Colors;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import onix.Modules.LogoModule;
import onix.Modules.PresetsModule;


public class MainSynth {
    
    JFrame jFrame;
    
    JPanel fullPanel,topPanel,downPanel,leftPanel,centerPanel,rightPanel;

    void MainSynt() {
        
        initComoponents();   
   
    }
    
    private void initComoponents() {
       
        jFrame = new JFrame("Onix Synthesizer");
        fullPanel = new JPanel(null);
        topPanel = new JPanel(null);
        downPanel = new JPanel(null);
        leftPanel = new JPanel(null);
        centerPanel = new JPanel(null);
        rightPanel = new JPanel(null);
   
    createPanels();
        
    }
    
    
    private void createModules () {
        LogoModule logoModule = new LogoModule(topPanel);
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
    
    jFrame.setBounds(0, 0, 800, 600);   
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
    jFrame.add(fullPanel);    
    
    }
    
}
