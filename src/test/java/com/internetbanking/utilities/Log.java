package com.internetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Log {

	static {

		try {
			Properties props = new Properties();
			FileInputStream cpr = new FileInputStream("./src/test/resources/Configurations/log4j.properties");
			props.load(cpr);
			PropertyConfigurator.configure(props);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Logger lsLog4j() {
		return Logger.getLogger(Thread.currentThread().getName());
	}

	public static String callerClass() {
		return Thread.currentThread().getStackTrace()[2].getClassName();
	}

	public static void testCaseInfo(String description) {

		lsLog4j().setLevel(Level.ALL);
		lsLog4j().info("");
		lsLog4j().log(callerClass(), Level.INFO, "****             " + description + "             *****", null);
		lsLog4j().info("");

	}
  public static void endTestCase() {
		lsLog4j().info("****             " + "-E---N---D-" + "             *****");
	}

	public static void message(String description) {
		lsLog4j().log(callerClass(), Level.INFO, description, null);
	}

	public static void event(String description) {
		lsLog4j().log(callerClass(), Level.DEBUG, description, null);
	}

	public static void pass(String description) {
		lsLog4j().log(callerClass(), Level.INFO, description, null);
	}

	public static void fail(String description, WebDriver driver) {
		lsLog4j().log(callerClass(), Level.ERROR, description, null);
	}

	public static void exception(Exception e, WebDriver driver) throws Exception {
		String eMessage = e.getMessage();
		if (eMessage != null && eMessage.contains("\n")) {
			eMessage = eMessage.substring(0, eMessage.indexOf("\n"));
		}
		lsLog4j().log(callerClass(), Level.FATAL, eMessage, e);
	}
}