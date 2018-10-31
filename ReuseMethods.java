package testNG;

import java.io.IOException;

public class ReuseMethods extends AdminLoginLogout {
	
	
	public static void main(String[] args) throws IOException {
		ReuseMethods obj=new ReuseMethods();
		obj.launchBrowser();
		obj.launchApp();
		obj.enterUname();
		obj.enterPassword();
		obj.clicklogin();
		obj.clicklogin();
		
	}
	




}
