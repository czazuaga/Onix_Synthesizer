
package onix.Modules;

import StyleResources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;


public class FilterEnvelopeModule {
     private JPanelFactory jPanel;

    
    public FilterEnvelopeModule (JPanel centerPanel) {
     
    jPanel=new JPanelFactory(centerPanel, 312, 109, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
      
   
    }   
}
