
package onix.Modules;

import StyleResources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;


public class DelayModule {
   
        private JPanelFactory jPanel;

    
    public DelayModule (JPanel downPanel) {
     
    jPanel=new JPanelFactory(downPanel, 225, 110, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
      
   
    }
    
}
