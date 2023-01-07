package tests.day16_SmokeTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.Reusablemethods;

public class C03_SwitchingWindows {


    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/iframe adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkine tiklayin
        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();

        // title'i "Elemental selenium:"Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
        //// olan yeni window'a gecis yapin

        Reusablemethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");


        //// ve sayfa uzerinde h1 tag'inda "Elemental Selenium" yazisi oldugunu test edin

        String expectedYazi="Elemental Selenium";
        String actualyazi= Driver.getDriver().findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualyazi,expectedYazi);


        Driver.quitDriver();



    }


}
