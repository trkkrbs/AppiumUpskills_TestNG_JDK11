package generalstore.tests;

import generalstore.pages.FormSayfasi;
import org.testng.annotations.Test;

import static generalstore.utils.Driver.uygulamayiKapat;

public class TC02_NegativeTest {

    /*
    GeneralStore uygulamasina gir
    Menuden Angola secenegini sec
    Your Name kutusunu bos birak
    Let's Shop butonuna tikla
    Hata mesajini dogrula (Toast Message)
     */

    @Test
    public void tc02NegativeTest() {
        FormSayfasi formSayfasi = new FormSayfasi();
        formSayfasi.letsShopButonunaTikla();
        formSayfasi.hataMesajininGorundugunuDogrula("Please enter your name");
        uygulamayiKapat();

//        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//        String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
//        //                                               .xpath               "//tagName"                .getAttribute("name")
//        //                                                                                               .getAttribute("text")
//        //Developer toast mesaji olustururken name attribute'i kullanmak zorunda. Bu yuzden .getAttribute("text") yerine
//        // .getAttribute("name") ile locate'i alabiliriz. Bu methodu butun toast mesajlarinda kullanabilecegimiz icin
//        // reusable methodlara ekleyebiliriz.
//        Assert.assertEquals(toastMessage, "Please enter your name");


    }
}
