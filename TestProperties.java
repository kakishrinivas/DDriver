package dataProvider;

import java.io.IOException;

import org.testng.annotations.Test;

public class TestProperties extends TestBase{


	@Test
	public void testProperties() throws IOException{
		String n=getObject("name");
		System.out.println(n);
		String p=getObject("place");
		System.out.println(p);
		String u=getObject("url");
		System.out.println(u);
	}
	
	
}
