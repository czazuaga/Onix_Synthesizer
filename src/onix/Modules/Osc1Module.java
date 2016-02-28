
package onix.Modules;

import StyleResources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;


public class Osc1Module {

private JPanelFactory jPanel;
    
    public Osc1Module (JPanel leftPanel) {
    
        jPanel=new JPanelFactory(leftPanel, 253, 151, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);

    }
    
}
