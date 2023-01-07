package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Reusablemethods;

public class C04_PozitifLoginTest {

    @Test
    public void pozitifLoginTest(){

        //qualitdemy anasayfaya git

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qualitydemyPage.loginButonu.click();

        Reusablemethods.bekle(3);

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());

        Driver.closeDriver();
    }
}
