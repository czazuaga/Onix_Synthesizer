package onix.funcional.modules;

import StyleResources.Colors;
import com.jsyn.ports.UnitInputPort;
import com.jsyn.swing.PortBoundedRangeModel;
import com.jsyn.swing.RotaryController;
import javax.swing.JPanel;

public class KnobModule {

    RotaryController Knob;
    

    public KnobModule(UnitInputPort unitInputPort,JPanel jPanel,double minValue,
            double maxValue,double defaultValue,int xPos,int yPos,int width,
            int height) {
        
     
        
        unitInputPort.setMinimum(minValue);
        unitInputPort.setMaximum(maxValue);
         
        PortBoundedRangeModel model = new PortBoundedRangeModel(unitInputPort);
        model.setDoubleValue(defaultValue);
   
        Knob = new RotaryController(model);
        
        
        Knob.setBackground(Colors.DARK_BLUE);
        Knob.setStyle(RotaryController.Style.ARC);
        Knob.setLineColor(Colors.CRUNCH_WHITE);
        Knob.setKnobColor(Colors.DARK_GREY);
        Knob.setBounds(xPos, yPos, width, height);
        
        
    
    
       jPanel.add(Knob);
 
    }
    
 
    
}
