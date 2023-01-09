package tests.day18_htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderIleNegativeloginTesti {


    // Qualitdemi anasayfaya gidin
    // verilen yanlis kullanici adi ve password komdinasyonlari icin
    // giris yapilamadigini test edin
    // username     password
    // A11          A12345
    // B12          B12345
    // C13          C12345
    // D14          D12345
    // E15          E12345

    @DataProvider
    public static Object[][] kullanicibilgileri() {

        Object [][] kullaniciBilgileriArr= { {"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};
        return kullaniciBilgileriArr;
    }


    @Test (dataProvider = "kullanicibilgileri")
    public void negativeLoginTest(String username,String password){


        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

    }
}