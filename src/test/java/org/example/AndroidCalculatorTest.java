package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidCalculatorTest {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", ".Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);


        WebElement el1 = driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        el1.click();
        WebElement el2 = driver.findElement(By.id("op_add"));
        el2.click();
        WebElement el3 = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        el3.click();
        WebElement el4 = driver.findElement(By.id("eq"));
        el4.click();

        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));

        Assert.assertEquals(result.getText(), "12");

    }

}
