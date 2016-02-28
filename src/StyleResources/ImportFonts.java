
package StyleResources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;



public class ImportFonts {

    GraphicsEnvironment graphicsEnviroment = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
    
    
    public  ImportFonts() throws FontFormatException, IOException{
   
        importar();
    
    }
    
    public void importar() throws FontFormatException, IOException{
    
    graphicsEnviroment.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
            new File("src/fonts/2Tech.ttf")));
    
    graphicsEnviroment.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
            new File("src/fonts/LLPixel.ttf")));
    
    graphicsEnviroment.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
            new File("src/fonts/Pixel LCD7.ttf")));
    
    graphicsEnviroment.registerFont(Font.createFont(Font.TRUETYPE_FONT, 
            new File("src/fonts/SyntheticSyncronism.ttf")));
    
 
}
    }
    

