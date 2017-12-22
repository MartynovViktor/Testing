

import org.apache.bcel.generic.Visitor;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestAutoRia {
    WebDriver webDriver;
    String region = "Одесса";
    String priceFrom = "1000";
    String priceTo = "100000";
    String yearFrom = "2000";
    String yearTo = "2017";
    String currensy = "$";// Только $; грн.; €
    String categories = "Легковые";
    String newOrOldCars = "New"; // Только Old или New



    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.get("https://auto.ria.com/");
        webDriver.findElement(By.xpath("//a[@class='cansel close']")).click();
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

    }
    @Test
    public void checkFilters() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.setRegion(region);
        mainPage.setPeriod(yearFrom,yearTo);
        mainPage.setPrice(priceFrom,priceTo);
        mainPage.setCurrency(currensy);
        mainPage.setCategories(categories);

        if (newOrOldCars.equals("New")){
            mainPage.chooseNewCars();
            mainPage.setMarksForNewCars();
            mainPage.setModelForNewCars();
        } else {
            //mainPage.setMarksForOldCars();
            //mainPage.setModelForOldCars();
            webDriver.findElement(By.id("brandTooltipBrandAutocompleteInput-1")).sendKeys("Mi");
            Thread.sleep(1500);
            webDriver.findElement(By.xpath("//ul[@class='unstyle scrollbar autocomplete-select']/li[2]")).click();
            Thread.sleep(1500);
            webDriver.findElement(By.xpath("//label[@for=\"brandTooltipModelAutocompleteInput-1\"]")).click();
            Thread.sleep(1500);
            webDriver.findElement(By.xpath("//li[@data-text='L 200']")).click();
        }
        mainPage.search();
    }

}
