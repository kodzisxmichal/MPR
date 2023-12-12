package pl.edu.pjatk.michalk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTestAddPerson {

    public static final String URL = "localhost:8080/addPerson";
    WebDriver webDriver;
    @FindBy(name = "name")
    WebElement nameInput;

    @FindBy(name = "age")
    WebElement ageInput;

    @FindBy(name = "submit")
    WebElement addSubmit;

    public SeleniumTestAddPerson(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void fillFormCorrectly(){
        nameInput.sendKeys("aron");
        ageInput.sendKeys("6");
    }

    public void fillFormEmptyName(){
        nameInput.sendKeys("");
        ageInput.sendKeys("6");
    }

    public void fillFormWordAge(){
        nameInput.sendKeys("aron");
        ageInput.sendKeys("mucha");
    }

    public void fillFormNegativeAge(){
        nameInput.sendKeys("aron");
        ageInput.sendKeys("-1");
    }

    public void open(){
        webDriver.get(URL);
    }


}
