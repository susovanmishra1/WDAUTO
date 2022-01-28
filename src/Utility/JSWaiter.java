package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rajat Kaushik
 */
public class JSWaiter {

    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;
    private static WebDriver driver;

    //Get the driver from relevant test
    public static void setDriver(WebDriver driver) {
        //jsWait = new WebDriverWait(driver, 5000);
        jsExec = (JavascriptExecutor) driver;
    }

    private void ajaxComplete() {
        jsExec.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");

    }

    private void waitForJQueryLoad() {
        try {
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) JSWaiter.driver)
                    .executeScript("return jQuery.active") == 0);

            boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

            if (!jqueryReady) {
               // jsWait.until(jQueryLoad);
                jsWait.pollingEvery(50000, TimeUnit.SECONDS);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitForAngularLoad() {
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        angularLoads(angularReadyScript);
    }

    private void waitUntilJSReady() {
        try {
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) JSWaiter.driver)
                    .executeScript("return document.readyState").toString().equals("complete");

            boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");

            if (!jsReady) {

               // jsWait.until(jsLoad);
            	jsWait.pollingEvery(50000, TimeUnit.SECONDS);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitUntilJQueryReady() {
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            poll(20);

            waitForJQueryLoad();
            poll(20);
        }
    }

    public void waitUntilAngularReady() {
        try {
            Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
            if (!angularUnDefined) {
                Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
                if (!angularInjectorUnDefined) {
                    poll(20);

                    waitForAngularLoad();

                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    public void waitUntilAngular5Ready() {
        try {
            Object angular5Check = jsExec.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
            if (angular5Check != null) {
                Boolean angularPageLoaded = (Boolean) jsExec.executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1");
                if (!angularPageLoaded) {
                    poll(20);

                    waitForAngular5Load();

                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitForAngular5Load() {
        String angularReadyScript = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
        angularLoads(angularReadyScript);
    }

    private void angularLoads(String angularReadyScript) {
        try {
            ExpectedCondition<Boolean> angularLoad = driver -> {
                assert driver != null;
                return Boolean.valueOf(((JavascriptExecutor) driver)
                        .executeScript(angularReadyScript).toString());
            };

            boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

            if (!angularReady) {

               // jsWait.until(angularLoad);
            	jsWait.pollingEvery(50000, TimeUnit.SECONDS);
            }
        } catch (WebDriverException ignored) {
        }
    }

    public void waitAllRequest() {
        try {
            waitUntilJSReady();
            ajaxComplete();
            waitUntilJQueryReady();
            waitUntilAngularReady();
            waitUntilAngular5Ready();

        } catch (Exception ignored) {

        }
    }

    /**
     * Created by Rajat Kaushik
     */
    public void waitForElementAreComplete(By by, int expected) {
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = JSWaiter.driver.findElements(by).size();
            return loadingElements >= expected;
        };
       // jsWait.until(angularLoad);
        jsWait.pollingEvery(50000, TimeUnit.SECONDS);
    }

    /**
     * Waits for the elements animation to be completed
     *
     * @param css
     */
    public void waitForAnimationToComplete(String css) {
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = JSWaiter.driver.findElements(By.cssSelector(css)).size();
            return loadingElements == 0;
        };
       // jsWait.until(angularLoad);
        jsWait.pollingEvery(50000, TimeUnit.SECONDS);
    }

    private void poll(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
