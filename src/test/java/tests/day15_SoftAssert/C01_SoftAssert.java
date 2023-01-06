package tests.day15_SoftAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.Reusablemethods;

public class C01_SoftAssert {


    @Test
    public  void test01(){

        // amazon ana sayfaya gidin
        Driver.getDriver().get("http://www.amazon.com");

        // amazon anasayfaya gittginizi dogrulayin
        SoftAssert softAssert=new SoftAssert();

        String expectedUrlKelime="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime));

        //nutella aratin
        AmazonPage amazonPage=new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuclarinin nutella icerdigini dogrulayin

        String aramaSonucYazisi=amazonPage.aramaSonucuElemnti.getText();

        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"));

        // java aratin

        Reusablemethods.bekle(2);

        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java"+Keys.ENTER);
        // arama sonuclarinin 1000 den fazla oldugunu dogrulayim

        System.out.println(amazonPage.aramaSonucuElemnti.getText());

        aramaSonucYazisi=amazonPage.aramaSonucuElemnti.getText();
        String[] sonucArr=aramaSonucYazisi.split(" ");

        String javasonucsayisiStr=sonucArr[3];
        javasonucsayisiStr=javasonucsayisiStr.replaceAll("\\W","");

        int sonucsayisi=Integer.parseInt(javasonucsayisiStr);

        softAssert.assertTrue(sonucsayisi>1000);



        softAssert.assertAll();
        Driver.closeDriver();
    }
}
