package pl.edu.pjatk.michalk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

    WebDriver webDriver;
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "./file/geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void test(){
        SeleniumTestAddPerson page = new SeleniumTestAddPerson(webDriver);
        page.open();
        page.fillFormEmptyName();
        page.fillFormWordAge();
        page.fillFormNegativeAge();
        page.fillFormCorrectly();
    }


}
