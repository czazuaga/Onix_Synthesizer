
package onix.funcional.modules;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class JPanelFactory extends JPanel {
    




private Color borderColor,backgroundColor;

private int xPos,yPos,xSize,ySize,borderSize;
    
    public JPanelFactory (JPanel FatherPanel,int xPos,int yPos, int xSize, int ySize,
            Color backgroundColor, int borderSize, Color borderColor) {
    
        this.xSize=xSize;
        this.ySize=ySize;
        this.xPos=xPos;
        this.yPos=yPos;
        this.backgroundColor=backgroundColor;
        this.borderSize=borderSize;
        this.borderColor=borderColor;
        
        
        
        initComponents();
        FatherPanel.add(this);
   
    }
    
    public void initComponents (){
        
        this.setLayout(null);
        this.setBounds(xPos,yPos,xSize,ySize);
        this.setBackground(backgroundColor);
        this.setBorder(BorderFactory.createLineBorder(borderColor, borderSize));
        
          
    }    

   
    
    
}
