
package onix.Modules;

import StyleResources.Colors;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import onix.funcional.modules.JPanelFactory;


public class AmplifierEnvelopeModule {
   
        private JPanelFactory jPanel;

    
    public AmplifierEnvelopeModule (JPanel downPanel) {
     
    jPanel=new JPanelFactory(downPanel, 313, 110, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
      
   
    }
    
}
