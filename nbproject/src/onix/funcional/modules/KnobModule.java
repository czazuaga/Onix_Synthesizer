package onix.funcional.modules;

import StyleResources.Colors;
import com.jsyn.ports.UnitInputPort;
import com.jsyn.swing.PortBoundedRangeModel;
import com.jsyn.swing.RotaryController;
import javax.swing.JPanel;

public class KnobModule {

    private RotaryController Knob;
    private UnitInputPort unitInputPort;
    private double minValue,maxValue,defaulValue;
    private PortBoundedRangeModel model;
    

    public KnobModule(UnitInputPort unitInputPort,JPanel jPanel,double minValue,
            double maxValue,double defaultValue,int xPos,int yPos,int width,
            int height) {
        this.unitInputPort = unitInputPort;
        this.minValue = minValue;
        this.maxValue=maxValue;
        this.defaulValue=defaultValue;
        
        this.unitInputPort.setMinimum(minValue);
        this.unitInputPort.setMaximum(maxValue);
         
        model = new PortBoundedRangeModel(this.unitInputPort);
        model.setDoubleValue(defaultValue);
   
        Knob = new RotaryController(model);
        
        
        Knob.setBackground(Colors.DARK_BLUE);
        Knob.setStyle(RotaryController.Style.ARC);
        Knob.setLineColor(Colors.CRUNCH_WHITE);
        Knob.setKnobColor(Colors.DARK_GREY);
        Knob.setBounds(xPos, yPos, width, height);
        

       jPanel.add(Knob);
 
    }
    
    
 public void setActive(boolean set){
 Knob.setEnabled(set);
 Knob.setVisible(set);
 }
 
}
