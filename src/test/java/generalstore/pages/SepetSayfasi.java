package generalstore.pages;

import generalstore.utils.Driver;
import generalstore.utils.ReusableMethods;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static generalstore.utils.Driver.driver;
import static generalstore.utils.ExtentReport.bilgiNotu;

public class SepetSayfasi extends ReusableMethods {
    public SepetSayfasi() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> urunler;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement toplamFiyat;
    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement kontrolKutusu;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement satinAlmaButonu;

    public void secilenUrunAdediniDogrula(int urunAdedi){
        System.out.println("urunler.size() = " + urunler.size());
        Assert.assertEquals(urunler.size(), urunAdedi);
        bilgiNotu("Secilen urun adedinin " +urunAdedi+ " oldugu dogrulandi.");
    }

    public void secilenUrunlerinToplamFiyatiniDogrula(){
        double total = 0;
        for (int i = 0; i < urunler.size(); i++) {
            String priceText = urunler.get(i).getText(); //$160.97 --> $120.0
            double price = Double.parseDouble(priceText.substring(1)); //160.97 --> 120.0
            total += price;
        }

        double totalAmount = Double.parseDouble(toplamFiyat.getText().substring(1));
        Assert.assertEquals(total, totalAmount);
        bilgiNotu("Secilen urunlerin toplam fiyatinin, Total Amount ile ayni oldugu dogrulandi.");
    }

    public void kontrolKutusunaTikla(){
        kontrolKutusu.click();
        bilgiNotu("Send me email... mesajli kontrol kutusu secildi.");
    }

    public void satinAlmaButonunaTikla() {
        satinAlmaButonu.click();
        bekle(3);
        driver.context("WEBVIEW_com.androidsample.generalstore"); //Driver'imizi web context degerine geciriyoruz.
        bilgiNotu("Satin Al butonuna tiklandi.");

    }

}
