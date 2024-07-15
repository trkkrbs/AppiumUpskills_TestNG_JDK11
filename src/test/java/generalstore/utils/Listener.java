package generalstore.utils;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static generalstore.utils.ConfigReader.getProperty;
import static generalstore.utils.Driver.*;
import static generalstore.utils.ExtentReport.*;

public class Listener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        serverBaslat(getProperty("localIPAddress"), Integer.parseInt(getProperty("localPort")));
        raporOlustur();
    }

    @Override
    public void onTestStart(ITestResult result) {
        testOlustur(result.getMethod().getMethodName());
        test.info("Test Basladi.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test basariyla tamamlandi.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // Hata Mesaji
        test.fail("Test basarisiz oldu. Cunku: " + result.getThrowable().getMessage());


        // Ekran Goruntusu
        File dosya = driver.getScreenshotAs(OutputType.FILE);
        String dosyaYolu = System.getProperty("user.dir") + File.separator + result.getMethod().getMethodName() + "raporlar" + File.separator + ".png";
        try {
            FileUtils.copyFile(dosya, new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Ekran Goruntusunu Rapora Ekleme
        try {
            test.addScreenCaptureFromPath(dosyaYolu);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        uygulamayiKapat();
    }

    @Override
    public void onFinish(ITestContext context) {
        uygulamayiKapat();
        raporuKaydet();
        serverKapat();
    }
}
