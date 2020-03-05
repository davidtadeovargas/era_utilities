
import com.era.logger.LoggerUtility;
import com.era.utilities.ConfigFileUtil;
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
public class ConfigUtilJUnitTest  {
    
    @Test
    @Order(1)
    public void createConfigFileTest() {
                       
        try{
            
            ConfigFileModel ConfigFileModel = new ConfigFileModel();
            ConfigFileModel.setInstance("localhost");
            ConfigFileModel.setUser("root");
            ConfigFileModel.setPassword("a5z8y1Tadeo");
            ConfigFileModel.setDb("dbempresas");
            ConfigFileModel.setSucursal("SUC1");
            ConfigFileModel.setCashNumber("CAJ1");
            ConfigFileModel.setPort("3306");
            ConfigFileModel.setCompanyName("My company");
            
            ConfigFileUtil.getSingleton().createConfigFile(ConfigFileModel);
            
            ConfigFileModel = ConfigFileUtil.getSingleton().getConfigFileModel();
            
            assertNotNull(ConfigFileModel);
            
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "instance: " + ConfigFileModel.getInstance());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "user: " + ConfigFileModel.getUser());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "password: " + ConfigFileModel.getPassword());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "db: " + ConfigFileModel.getDb());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "sucursal " + ConfigFileModel.getSucursal());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "cashNumber " + ConfigFileModel.getCashNumber());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "port " + ConfigFileModel.getPort());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "companyName " + ConfigFileModel.getCompanyName());
            
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
            
            ConfigFileModel ConfigFileModel = ConfigFileUtil.getSingleton().getConfigFileModel();
            
            assertNotNull(ConfigFileModel);
            
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "instance: " + ConfigFileModel.getInstance());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "user: " + ConfigFileModel.getUser());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "password: " + ConfigFileModel.getPassword());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "db: " + ConfigFileModel.getDb());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "sucursal " + ConfigFileModel.getSucursal());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "cashNumber " + ConfigFileModel.getCashNumber());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "port " + ConfigFileModel.getPort());
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "companyName " + ConfigFileModel.getCompanyName());                       
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(ConfigUtilJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "Failed");
        }            
    }
    
    @Test
    @Order(3)
    public void configFileExistsTest() {
                       
        try{
            
            final boolean exists = ConfigFileUtil.getSingleton().configFileExists();
            
            if(exists){
                Assertions.assertTrue(true);
            }
            else{
                Assertions.assertTrue(false);
            }
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(ConfigUtilJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "Failed");
        }            
    }
    
    @Test
    @Order(4)
    public void deleteFileTest() {
                       
        try{
            
            ConfigFileUtil.getSingleton().deleteFile();
            
            final boolean exists = ConfigFileUtil.getSingleton().configFileExists();
            
            if(!exists){
                Assertions.assertTrue(true);
            }
            else{
                Assertions.fail();
            }
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(ConfigUtilJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(ConfigUtilJUnitTest.class, "Failed");
        }            
    }
}
