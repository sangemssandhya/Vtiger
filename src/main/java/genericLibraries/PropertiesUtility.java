package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains reusable methods to initialize and read data from properties file
 * @author SANDHYA
 * 
 */

public class PropertiesUtility {
	
		private Properties property;
		/**
		 * This method is used to initialize properties file 
		 * @param filepath
		 */
		
		public void propertiesInit(String filepath)
		{
		 FileInputStream fis=null;
			try {
		        fis=new FileInputStream(filepath);
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			property =new Properties();
			try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		/**
		 * this method fetches from properties file based on the key passed as an argument
		 * @param key
		 * @return
		 */
		public String readFromProperties(String key)
		{
		return property.getProperty(key);


		}
		
	}
	
	 


