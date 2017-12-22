

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
    String region = "Киев";
    String priceFrom = "1000";
    String priceTo = "10000";
    String yearFrom = "2000";
    String yearTo = "2017";
    String currensy = "грн.";
    String categories = "Мото";
    String newOrOldCars = "New";



    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.get("https://auto.ria.com/");
        webDriver.findElement(By.xpath("//a[@class='cansel close']")).click();
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

    }
    @Test
    public void checkFilters(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.setRegion(region);
        mainPage.setPeriod(yearFrom,yearTo);
        mainPage.setPrice(priceFrom,priceTo);
        mainPage.setCurrency(currensy);
        mainPage.setCategories(categories);
        webDriver.findElement(By.id("NaRadioButton")).click();
        if (newOrOldCars == "New"){
            mainPage.setNewCars();
        }
        //mainPage.search();
    }

    @Test
    public void sss(){
        if (newOrOldCars == "New")
        webDriver.findElement(By.id("NaRadioButton")).click();
    }




    /*@Test
    public void testSearching() throws InterruptedException {
        //webDriver.findElement(By.xpath("//label[@for=\"brandTooltipBrandAutocompleteInput-1\"]")).click();
        webDriver.findElement(By.id("brandTooltipBrandAutocompleteInput-1")).sendKeys("Renault");
        Thread.sleep(2000);
        //webDriver.findElement(By.xpath("//ul[@class='unstyle scrollbar autocomplete-select']/li[13]")).click();
        webDriver.findElement(By.className("button-primary")).click();
        //webDriver.findElement(By.xpath("//a[@href='/car/renault/']")).click();
    }*/


}
