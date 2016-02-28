
package onix.Modules;



import StyleResources.Colors;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelBackground;


public class LogoModule {
    
  protected JPanelBackground jPanelLogo;
   
  protected Graphics g;
 

  
  protected URL url;
   

    public LogoModule (JPanel topJPanel){
  
     initComponents();
    
     
     topJPanel.add(jPanelLogo);

    }
    
    public void initComponents(){
    
    url=getClass().getResource("/images/logoBgPanel.png");
        
    jPanelLogo = new JPanelBackground();  
    
    jPanelLogo.setBorder(BorderFactory.createLineBorder(Colors.CRUNCH_WHITE, 1));
    jPanelLogo.setBackground(url);
    jPanelLogo.setBounds(3,3,253,126);

    }

}
