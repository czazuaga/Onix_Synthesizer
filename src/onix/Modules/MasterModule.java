
package onix.Modules;

import StyleResources.Colors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import onix.funcional.modules.JPanelFactory;


public class MasterModule {
    
   private JPanelFactory jPanel;

    
    public MasterModule (JPanel topPanel) {
     
    jPanel=new JPanelFactory(topPanel, 225, 132, Colors.DARK_BLUE,
            1, Colors.CRUNCH_WHITE);
      
   
    }
}
