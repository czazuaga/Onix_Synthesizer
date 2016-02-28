
package onix.Modules;

import StyleResources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;


public class Osc2Module {

    private JPanelFactory jPanel;

    
    public Osc2Module (JPanel leftPanel) {
     
    jPanel=new JPanelFactory(leftPanel, 253, 148, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
      
   
    }
              
    
}
