package Mts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        acceptCookies();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверить название блока 'Онлайн пополнение без комиссии")
    void testBlockTitle() {
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Онлайн пополнение')]")));
        assertNotNull(blockTitle, "Блок 'Онлайн пополнение без комиссии' не найден");
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void testPaymentLogos() {
        WebElement paymentLogos = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("pay__partners")));
        assertTrue(paymentLogos.isDisplayed());
    }


    @Test
    @DisplayName("Проверить работу ссылки 'Подробнее о сервисе'")
    public void testMoreAboutServiceLink() {
        WebElement moreLink = wait.until(ExpectedConditions.elementToBeClickable
                (By.linkText("Подробнее о сервисе")));
        assertNotNull(moreLink, "Ссылка 'Подробнее о сервисе' не найдена");
        moreLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertEquals(expectedUrl, driver.getCurrentUrl(),
                "Переход по ссылке 'Подробнее о сервисе' не произошёл");
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки 'Продолжить'")
    public void testFillFormAndContinue() {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("connection-phone")));
        phoneNumberField.sendKeys("297777777");
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("connection-sum")));
        amountField.sendKeys("10");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("connection-email")));
        emailField.sendKeys("dada212@gamil.com");
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//form[@class='pay-form opened']/button")));
        continueButton.click();

        assertNotNull(continueButton, "Окнно оплаты не открылось");
    }

    private void acceptCookies() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn_black cookie__ok']")));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
            }
        } catch (Exception e) {
            System.out.println("Cookie popup not found or clickable");
        }
    }
}



