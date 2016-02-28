
package onix.Modules;

import StyleResources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;


public class LfoModule {
   
    private JPanelFactory jPanel;
    
    public LfoModule (JPanel rightPanel) {
    
        jPanel=new JPanelFactory(rightPanel, 225, 190, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);

    }
    
}
