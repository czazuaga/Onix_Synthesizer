
package onix.Modules;



import StyleResources.Colors;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelBackground;


public class LogoModule {
    
  protected JPanelBackground jPanelLogo;
   
  protected Graphics g;
 
  protected Dimension imgSize;
  
  protected URL url;
   

    public LogoModule (JPanel mainPanel){
  
     initComponents();
    
     jPanelLogo.setPreferredSize(new Dimension(252,132));
     mainPanel.add(jPanelLogo);

    }
    
    public void initComponents(){
    
    url=getClass().getResource("/images/logoBgPanel.png");
        
    jPanelLogo = new JPanelBackground();  
    jPanelLogo.setBorder(BorderFactory.createLineBorder(Colors.CRUNCH_WHITE, 1));
    jPanelLogo.setBackground(url);

    }

}
