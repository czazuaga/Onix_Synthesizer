
package onix.funcional.modules;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class JPanelFactory extends JPanel {
    


private LayoutManager layout;

private Color borderColor,backgroundColor;

private int xSize,ySize,borderSize;
    
    public JPanelFactory (JPanel FatherPanel, int xSize, int ySize, Color backgroundColor, int borderSize, Color borderColor) {
    
        this.xSize=xSize;
        this.ySize=ySize;
        this.backgroundColor=backgroundColor;
        this.borderSize=borderSize;
        this.borderColor=borderColor;
        this.layout=layout;
        
        
        initComponents();
        FatherPanel.add(this);
   
    }
    
    public void initComponents (){
        
        this.setLayout(null);
        this.setPreferredSize(new Dimension(xSize,ySize));
        this.setBackground(backgroundColor);
        this.setBorder(BorderFactory.createLineBorder(borderColor, borderSize));
        
          
    }    

   
    
    
}
