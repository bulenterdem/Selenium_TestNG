package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {


    @Test
    public void ilkTest(){

        System.out.println("Ilk test calisti");

    }

    @Test (dependsOnMethods = "ilkTest")
    public void ikiniciTest(){

        System.out.println("Ikinci test calisti");
    }


    @Test (dependsOnMethods = "ikinciTest")
    public void ucuncuTest(){

        System.out.println("Ucuncu test calisti");
    }
}
