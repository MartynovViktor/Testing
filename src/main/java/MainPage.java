
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By regionLocator = By.id("regionCenters");
    By yearFromLocator = By.id("year");
    By yearToLocator = By.id("yearTo");
    By priceFromLocator = By.id("priceFrom");
    By priceToLocator = By.id("priceTo");
    By currencyLocator = By.id("currency");
    By categoriesLocator = By.id("categories");
    By searchButtonLocator = By.className("button-primary");
    By radioButtonNewLocator = By.id("NaRadioButton");
    By radioButtonOldLocator = By.id("BuRadioButton");
    By marksForNewCarsLocator = By.id("marks");
    By modelsNewLocator = By.id("models");
    By marksForOldCars = By.id("brandTooltipBrandAutocompleteInput-1");
    By modelsOldCar = By.xpath("//label[@for=\"brandTooltipModelAutocompleteInput-1\"]");

    public void setRegion(String setRegion) {
        Select select = new Select(webDriver.findElement(regionLocator));
        select.selectByVisibleText(setRegion);
    }
    public void  setPeriod(String fromDate , String toDate){
        Select selectFrom = new Select(webDriver.findElement(yearFromLocator));
        Select selectTo = new Select(webDriver.findElement(yearToLocator));
        selectFrom.selectByValue(fromDate);
        selectTo.selectByValue(toDate);
    }
    public void setPrice(String from, String to){
        WebElement priceFrom = webDriver.findElement(priceFromLocator);
        WebElement priceTo = webDriver.findElement(priceToLocator);
        priceFrom.sendKeys(from);
        priceTo.sendKeys(to);
    }
    public void setCurrency(String setCurrency){
        Select select = new Select(webDriver.findElement(currencyLocator));
        select.selectByVisibleText(setCurrency);
    }
    public void setCategories(String categories){
        Select select = new Select(webDriver.findElement(categoriesLocator));
        select.selectByVisibleText(categories);
    }
    public void search(){
        WebElement search = webDriver.findElement(searchButtonLocator);
        search.click();
    }
    public void chooseNewCars(){
        WebElement newCars = webDriver.findElement(radioButtonNewLocator);
        newCars.click();
    }
    public void setOldCars(){
        WebElement oldCars = webDriver.findElement(radioButtonOldLocator);
        oldCars.click();
    }

    public void setMarksForNewCars(){
        Select select=new Select(webDriver.findElement(marksForNewCarsLocator));
        select.selectByValue("52");
    }

    public void setModelForNewCars(){
        Select select=new Select(webDriver.findElement(modelsNewLocator));
        select.selectByValue("1478");
    }
    public void setMarksForOldCars(){
        WebElement oldCarsMark = webDriver.findElement(marksForOldCars);
        oldCarsMark.sendKeys("Mi");
        webDriver.findElement(By.xpath("//ul[@class='unstyle scrollbar autocomplete-select']/li[2]")).click();

    }
    public void setModelForOldCars(){
        WebElement oldCarsModel = webDriver.findElement(modelsOldCar);
        oldCarsModel.click();
        webDriver.findElement(By.xpath("//li[@data-text='L 200']")).click();
    }

}