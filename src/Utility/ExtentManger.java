package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import org.jdesktop.swingx.renderer.StringValue;

public class ExtentManger {

    public static String x;
    static String callerClassName = new Exception().getStackTrace()[0].getClassName();
    static java.util.Date date = new java.util.Date();
    static String[] date1 = date.toString().split(" ");
    static String[] date2 = date1[3].split(":");
    static String dateval = date2[0] + date2[1] + date2[2];
    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentHtmlReporter htmlReporter;


    String path = System.getProperty("user.dir");   // return project folder path

      private static String filePath = System.getProperty("user.dir") + "\\src\\Reports\\";

    public static String getName() {
        System.out.println("Get X=" + x);
        return x;
    }

    public static ExtentReports GetExtent() {
        if (extent != null) {
            System.out.println("within if ExtentReports");
            System.out.println(extent);
            return extent; //avoid creating new instance of html file
        }
        extent = new ExtentReports();

        extent.attachReporter(getHtmlReporter());
        return extent;
    }
    private static ExtentHtmlReporter getHtmlReporter() {

        //ExtentManger em = new ExtentManger();

        String filepath2 = filePath + getName() + date1[1] + date1[2] + dateval + ".html";
//        String filepath2 = filePath + getName() + ".html";
        System.out.println("File path of the report "+ filepath2);
       
        htmlReporter = new ExtentHtmlReporter(filepath2);
        String path = System.getProperty("user.dir");   // return project folder path
        String configpath = path + "\\src\\Config\\extent-config.xml";
        
        System.out.println(path);
        htmlReporter.loadXMLConfig(configpath);
        return htmlReporter;
    }

    public static ExtentTest createTest(String name, String description) {
        test = extent.createTest(name, description);
        return test;
    }

    public void setpath(String def) {

        this.x = def;
        System.out.println("Set X=" + this.x);

    }

}
