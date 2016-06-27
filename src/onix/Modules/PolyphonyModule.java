
package onix.Modules;

import StyleResources.Colors;
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
import onix.funcional.modules.MidiControl;


public class PolyphonyModule implements ActionListener {
    
private JPanelFactory jPanel;

protected URL buttonURL,polyDisplay,monoDisplay;
protected Icon buttonIcon,polyDisplayIcon,monoDisplayIcon;
protected JLabel displayLabel,moduleName;
public int buttonState=0;

 private JButton changePolyphonyButton = new JButton();
 
 private MidiControl midiControl;

    
    public PolyphonyModule (JPanel topPanel,MidiControl midiControl) {
        
        this.midiControl=midiControl;
     
    jPanel=new JPanelFactory(topPanel,256,3, 290, 126, Colors.DARK_BLUE,
      1, Colors.CRUNCH_WHITE);
      
    polyDisplay = getClass().getResource("/images/poly.png");
    monoDisplay = getClass().getResource("/images/mono.png");
    
    polyDisplayIcon=new ImageIcon(polyDisplay);
    monoDisplayIcon=new ImageIcon(monoDisplay);
    
    displayLabel = new JLabel(polyDisplayIcon);
        displayLabel.setBackground(Colors.DARK_BLUE);
        displayLabel.setBounds(45, 55, 150,40);
        jPanel.add(displayLabel);
        
        moduleName = new JLabel("Voices");
        
        moduleName.setFont(new Font("2Tech", 0, 15));
        moduleName.setBounds(20, 0, 200, 40);
        moduleName.setForeground(Colors.CLEAN_WHITE);
        jPanel.add(moduleName);
    
    selectPolyphonyButton();
   
    }

     public int getButtonState (){
    
        return this.buttonState;
        
    }
    
    public void setButtonState (int buttonState) {

    this.buttonState=buttonState;
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
         if (ae.getActionCommand().equals("selectPolyphony")){
         
             
             
              if(getButtonState()==0){
                
                midiControl.setMono();
                displayLabel.setIcon(monoDisplayIcon);
                
                
              buttonState=1;
              
            }else if (getButtonState()==1){
                  
                midiControl.setPoly();
                displayLabel.setIcon(polyDisplayIcon);
                
                
              buttonState=0;
            }
             
         }
        
    }
    
    //-------------------------------------------------
    
    protected void selectPolyphonyButton () { 
 
        buttonURL = getClass().getResource("/images/button.png");
        
       
          
        changePolyphonyButton.addActionListener(this);
        changePolyphonyButton.setActionCommand("selectPolyphony");
        changePolyphonyButton.setBackground(Colors.DARK_BLUE);
        changePolyphonyButton.setBorder(null);
        changePolyphonyButton.setIcon(new ImageIcon(buttonURL));
        changePolyphonyButton.setBounds(220, 55, 43, 42);
        
        jPanel.add(changePolyphonyButton);
        
    }
    
    //---------------------------------------------------
    
}
