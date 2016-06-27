/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onix.Modules;
import StyleResources.Colors;
import com.jsyn.Synthesizer;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelBackground;

/**
 *
 * @author Carlos Zamora
 */
public class OscilloscopeModule {
    
    
  protected JPanelBackground jPanel;
    
    public OscilloscopeModule (JPanel jPanelCenter, Synthesizer synth, FilterModule filterModule,WhiteNoiseModule whiteNoiseModule) {
    
        initComponents();
       
        jPanelCenter.add(jPanel);

        
        
        
    }
    
       
    public void initComponents(){
    
      URL url = getClass().getResource("/images/tubes.png");
        
      jPanel = new JPanelBackground();  
    
    jPanel.setBorder(BorderFactory.createLineBorder(Colors.CRUNCH_WHITE, 1));
    jPanel.setBackground(url);
    jPanel.setBounds(0,3,289,291);

    }
    
}
