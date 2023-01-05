package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C01_TestNGIlkTest {

    /*
        ---  TestNG method'lrini isim sirasina gore calistirir
        ---  priority degeri verilen methodlar ptiority degeri kucukten buyuge gore calisir
        ---  esit olan priority de harf sirasina bakilir
        ---  eger priority degeri yazmazsak priority=0 kabul edilir

     */



    @Test (priority = 6)
    public void ilkTest(){

        System.out.println("Ilk test calisti");

    }

    @Test (priority = 9)
    public void ikiniciTest(){

        System.out.println("Ikinci test calisti");
    }


    @Test (priority = 4)
    public void ucuncuTest(){

        System.out.println("Ucuncu test calisti");
    }

}
