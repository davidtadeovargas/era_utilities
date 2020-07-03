
import com.era.logger.LoggerUtility;
import com.era.utilities.ConfigFileUtil;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.models.ConfigFileModel;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
@TestMethodOrder(OrderAnnotation.class)
public class ImagesUtilityJUnitTest  {
    
    /*@Test
    @Order(1)
    public void createConfigFileTest() {
                       
        try{
            
            UtilitiesFactory.getSingleton().getImagesUtility().init("C:\\Users\\DavidTadeo.....Progr\\Documents\\Carpeta de trabajo\\easy-retail-campanita\\easy-retail-campanita");
            
            //UtilitiesFactory.getSingleton().getImagesUtility().saveImage("DANFRES15", "C:\\Users\\DavidTadeo.....Progr\\Downloads\\danone.jpg");
            
            Assertions.assertTrue(true);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(ConfigUtilJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "Failed");
        }            
    }
    
    @Test
    @Order(2)
    public void getConfigFileModelTest() {
                       
        try{
            
            final String prodPath = UtilitiesFactory.getSingleton().getImagesUtility().getProductImagePath("DANFRES15");
            if(prodPath.compareTo("C:\\Users\\DavidTadeo.....Progr\\Documents\\Carpeta de trabajo\\easy-retail-campanita\\easy-retail-campanita\\Imagenes\\Productos\\DANFRES15\\image.png")==0){
                Assertions.assertTrue(true);
            }
            else{
                Assertions.assertFalse(false);
            }
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(ConfigUtilJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "Failed");
        }            
    }*/
}
