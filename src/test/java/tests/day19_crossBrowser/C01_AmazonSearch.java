package tests.day19_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossDriver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {

    @Test
    public void test01(){

        // amazon anasayfaya gidin

       driver.get(ConfigReader.getProperty("amazonUrl"));

        // nutella icin arama yapalim
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));

        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);

        // sonuclarin nutella icerdigini test edin

        WebElement sonucyazielmenti= driver.findElement(By.xpath(("//div[@class='a-section a-spacing-small a-spacing-top-small']")));

        String actualsonucyazisi=sonucyazielmenti.getText();
        String expectedKelime="Nutella";

        Assert.assertTrue(actualsonucyazisi.contains(expectedKelime));

    }
}
