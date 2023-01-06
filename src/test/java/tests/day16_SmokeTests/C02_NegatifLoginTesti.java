package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Reusablemethods;

public class C02_NegatifLoginTesti {


// 1.de yanlis email, dogru sifre
// 2.de dogru email yanlis sifre
// 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
// giris yapilamadigini test edin

    QualitydemyPage qualitydemyPage=new QualitydemyPage();

    @Test
    public void yanlisEmailtesti(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.loginButonu.click();
        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Reusablemethods.bekle(3);
        Driver.closeDriver();

    }


    @Test
    public void yanlisPasswordTesti(){

        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Reusablemethods.bekle(3);
        Driver.closeDriver();

    }


    @Test
    public void YanlisUsernameyanlisPasswordtesti(){

        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Reusablemethods.bekle(3);
        Driver.closeDriver();

    }


}
