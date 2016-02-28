
package onix.Modules;

import StyleResources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;


public class DisplayModule {
  
private JPanelFactory jPanel;
    
    public DisplayModule (JPanel centerPanel) {
    
        jPanel=new JPanelFactory(centerPanel, 312, 190, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);

    }
    
}
