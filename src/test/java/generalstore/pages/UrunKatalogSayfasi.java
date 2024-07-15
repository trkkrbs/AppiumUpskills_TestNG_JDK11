package generalstore.pages;

import generalstore.utils.Driver;
import generalstore.utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static generalstore.utils.ExtentReport.bilgiNotu;

public class UrunKatalogSayfasi extends ReusableMethods {
    public UrunKatalogSayfasi() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ADD TO CART\"]")
    private List<WebElement> addToCart;
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement sepeteGit;

//    public void sepeteUrunEkle(String urun, int index){
//    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+urun+"\"))"));
//    addToCart.get(index).click();
//    bilgiNotu(urun + " urunu sepete eklendi.");
//    }

    @Override
    public void scrollToTextAndAddToCart(AndroidDriver driver, String productName) {
        super.scrollToTextAndAddToCart(driver, productName);
        bilgiNotu(productName + " urunu sepete eklendi.");
    }

    public void sepeteGit(){
        sepeteGit.click();
        bilgiNotu("Sepet butonuna tiklanarak Sepet sayfasina gidildi.");
    }
}
