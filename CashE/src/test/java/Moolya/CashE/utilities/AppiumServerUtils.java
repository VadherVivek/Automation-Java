package Moolya.CashE.utilities;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import Moolya.CashE.pages.BasePage;

public class AppiumServerUtils {
	
	// This method Is responsible for starting appium server. 
	public static void startAppium() throws IOException, InterruptedException { 
		// Created object of apache CommandLine class. 
		// It will start command prompt In background.
		String AppiumNodeFilePath = BasePage.getPropValue("AppiumNodeFilePath");
        String AppiumJavaScriptServerFile = BasePage.getPropValue("AppiumJavaScriptServerFile");
        String AppiumServerAddress = BasePage.getPropValue("AppiumServerAddress");
        String AppiumServerPort = BasePage.getPropValue("AppiumServerPort");
		CommandLine command = new CommandLine("cmd"); 
		// Add different arguments In command line which requires to start appium server.
		command.addArgument("/c"); 
		command.addArgument(AppiumNodeFilePath); 
		command.addArgument(AppiumJavaScriptServerFile); 
		command.addArgument("--address"); 
		command.addArgument(AppiumServerAddress); 
		command.addArgument("-p"); 
		command.addArgument(AppiumServerPort); 
//		command.addArgument("-bp");
//		command.addArgument("2251");
		command.addArgument("--no-reset");
		command.addArgument("--session-override");
//		command.addArgument("--log"); 
//		//Set path to store appium server log file. 
//		command.addArgument("./Logs/appiumLogs.txt"); 
		// Execute command line arguments to start appium server. 
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler(); 
		DefaultExecutor executor = new DefaultExecutor(); 
		executor.setExitValue(1); 
		executor.execute(command, resultHandler); 
		// Wait for 15 minutes so that appium server can start properly before going for test execution. // Increase this time If face any error. 
		Thread.sleep(5000);
	}
	
	
	// This method Is responsible for stopping appium server. 
	public static void stopAppium() throws IOException, InterruptedException { 
		// Add different arguments In command line which requires to stop appium server. 
		Thread.sleep(2000);
		CommandLine command = new CommandLine("cmd"); 
		command.addArgument("/c"); 
		command.addArgument("taskkill"); 
		command.addArgument("/F"); 
		command.addArgument("/IM"); 
		command.addArgument("node.exe"); 
		// Execute command line arguments to stop appium server. 
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler(); 
		DefaultExecutor executor = new DefaultExecutor(); 
		executor.setExitValue(1); 
		executor.execute(command, resultHandler);
	}



}
