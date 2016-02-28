
package onix.Modules;

import StyleResources.Colors;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.FilterLowPass;
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

    private  KnobModule cutOffKnob;
    
    private int filterNum =0;
    
    private JButton selectFilterButton = new JButton();
    
  
    
    
    // Constructor -------------------------------------
    
    
    
    public FilterModule (JPanel downPanel,Synthesizer mainSynth,FilterLowPass FilterUnit) {

        jPanel=new JPanelFactory(downPanel,0,0, 252, 110, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
     
    
        cutOffKnob = new KnobModule(FilterUnit.frequency, jPanel, 0, 6000, 0,170,18,50,50);
        
          
  
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
        }
   
    }
    
    
    
}
