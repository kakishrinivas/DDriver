package dataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class TestBase {
	static Properties properties;
		
	public static void loadData() throws IOException{
		properties =new Properties();
		File f = new File(System.getProperty("user.dir")+"\\src\\prop\\Test1.properties");
		FileReader obj = new FileReader(f);
		properties.load(obj);
		
		File f1 = new File(System.getProperty("user.dir")+"\\src\\prop\\Test2.properties");
		FileReader obj1 = new FileReader(f1);
		properties.load(obj1);
	}
	
	public static String getObject(String Data) throws IOException{
		loadData();
		String data=properties.getProperty(Data);
		return data;
	}


  }
