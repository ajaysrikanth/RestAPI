package DataDriven;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;



public class base {
	
	public static int empID = 2;
	public Logger log = Logger.getLogger(base.class);
	
	@BeforeTest
	public void setUp() {
		
		java.util.logging.Logger.getLogger("org.apache.http.wire").setLevel(java.util.logging.Level.FINEST);
		java.util.logging.Logger.getLogger("org.apache.http.headers").setLevel(java.util.logging.Level.FINEST);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
		System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "ERROR");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "ERROR");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "ERROR");//System.setProperty("org.freemarker.loggerLibrary", "none");

	}
}
