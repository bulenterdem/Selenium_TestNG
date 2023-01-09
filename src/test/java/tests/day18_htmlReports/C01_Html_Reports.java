package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_Html_Reports extends TestBaseRapor {


    @Test
    public void Test01(){

        extentTest=extentReports.createTest("Nutella","kullanici amazonda nutella arayabilmeli");

        // amazona gidelim

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon ana sayfaya gidildi");

        // nutella aratalim

        AmazonPage amazonPage=new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        extentTest.info("Arama kutusuna nutellayazip arama yapildi");

        // sonuclarin nutella iceridigini test eelim

        String actualSonucyazisi=amazonPage.aramaSonucuElemnti.getText();
        String expectedKelime="Nutella";
        extentTest.info("Arama sonuclari kaydedildi");

        Assert.assertTrue(actualSonucyazisi.contains(expectedKelime));
        extentTest.pass("Arama sonuclarinin Nutella icerdigi test edildi");

        Driver.closeDriver();

    }


}
