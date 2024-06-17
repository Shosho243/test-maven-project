package Mts;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Проверка надписи в незаполненных полях услуги связи")
    public void checkCommunicationServiceEmptyFieldTest() {
        selectService("Услуги связи");

        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        String phoneNumberText = phoneNumberField.getAttribute("placeholder");
        String expectedPhoneNumberPlaceholder = "Номер телефона";
        Assert.assertEquals(expectedPhoneNumberPlaceholder, phoneNumberText);

        WebElement sumField = driver.findElement(By.xpath("//input[@class='total_rub']"));
        String sumFieldText = sumField.getAttribute("placeholder");
        String expectedSumPlaceholder = "Сумма";
        Assert.assertEquals(expectedSumPlaceholder, sumFieldText);

        WebElement emailField = driver.findElement(By.xpath("//input[@class='email']"));
        String emailText = emailField.getAttribute("placeholder");
        String expectedEmailPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(expectedEmailPlaceholder, emailText);
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях Домашний интернет")
    public void checkHomeInternetEmptyFieldTest() {
        selectService("Домашний интернет");

        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@placeholder='Номер абонента']"));
        String phoneNumberText = phoneNumberField.getAttribute("placeholder");
        String expectedPhoneNumberPlaceholder = "Номер абонента";
        Assert.assertEquals(expectedPhoneNumberPlaceholder, phoneNumberText);

        WebElement sumField = driver.findElement(By.xpath("//input[@id='internet-sum']"));
        String sumFieldText = sumField.getAttribute("placeholder");
        String expectedSumPlaceholder = "Сумма";
        Assert.assertEquals(expectedSumPlaceholder, sumFieldText);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='internet-email']"));
        String emailFieldText = emailField.getAttribute("placeholder");
        String expectedEmailPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(expectedEmailPlaceholder, emailFieldText);
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях рассрочка")
    public void checkInstallmentEmptyFieldTest() {
        selectService("Рассрочка");

        WebElement accountNumberField = driver.findElement(By.xpath("//input[@id='score-instalment']"));
        String accountNumberText = accountNumberField.getAttribute("placeholder");
        String expectedAccountNumberPlaceholder = "Номер счета на 44";
        Assert.assertEquals(expectedAccountNumberPlaceholder, accountNumberText);

        WebElement sumField = driver.findElement(By.xpath("//input[@id='instalment-sum']"));
        String sumFieldText = sumField.getAttribute("placeholder");
        String expectedSumPlaceholder = "Сумма";
        Assert.assertEquals(expectedSumPlaceholder, sumFieldText);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='instalment-email']"));
        String emailText = emailField.getAttribute("placeholder");
        String expectedEmailPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(expectedEmailPlaceholder, emailText);
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях задолженность")
    public void checkDebtEmptyFieldTest() {
        selectService("Задолженность");

        WebElement accountNumberField = driver.findElement(By.xpath("//input[@id='score-arrears']"));
        String accountNumberText = accountNumberField.getAttribute("placeholder");
        String expectedAccountNumberPlaceholder = "Номер счета на 2073";
        Assert.assertEquals(expectedAccountNumberPlaceholder, accountNumberText);

        WebElement sumField = driver.findElement(By.xpath("//input[@id='arrears-sum']"));
        String sumFieldText = sumField.getAttribute("placeholder");
        String expectedSumPlaceholder = "Сумма";
        Assert.assertEquals(expectedSumPlaceholder, sumFieldText);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='arrears-email']"));
        String emailFieldText = emailField.getAttribute("placeholder");
        String expectedEmailPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(expectedEmailPlaceholder, emailFieldText);
    }

    @Test
    @DisplayName("Проверка заполнить поля услуги связи и окно после кнопки продолжить")
    public void checkInputFormTest() {
        selectService("Услуги связи");

        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@class='phone']"));
        phoneNumberField.sendKeys("297777777");

        WebElement sumField = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumField.sendKeys("10");

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']/button[@type='submit']"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))));

        WebElement facticalResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Оплата:')]")));
        String actualResult = facticalResult.getText();
        String expectedResult = "Оплата: Услуги связи Номер:375297777777";
        assertEquals(actualResult, expectedResult);

        WebElement sumInButton = driver.findElement(By.xpath("//*[text()=' Оплатить  10.00 BYN ']"));
        String sumInButtonText = sumInButton.getText().trim();
        String expectedSumInButtonText = "Оплатить 10.00 BYN";
        Assert.assertEquals(expectedSumInButtonText, sumInButtonText);

        // Номер карты
        WebElement cardField = driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']"));
        String cardFieldText = cardField.getText();
        String expectedCardText = "Номер карты";
        Assert.assertEquals(expectedCardText, cardFieldText);

        // Срок действия
        WebElement validity = driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']"));
        String validityText = validity.getText();
        String expectedValidityText = "Срок действия";
        Assert.assertEquals(expectedValidityText, validityText);

        // Имя держателя
        WebElement nameOwner = driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']"));
        String nameOwnerText = nameOwner.getText();
        String expectedNameOwnerText = "Имя держателя (как на карте)";
        Assert.assertEquals(expectedNameOwnerText, nameOwnerText);

        WebElement mastercardLogo = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        Assert.assertTrue(mastercardLogo.isDisplayed(), "Иконка MasterCard не отображается");

        WebElement visaLogo = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        Assert.assertTrue(visaLogo.isDisplayed(), "Иконка Visa не отображается");

        WebElement belcartLogo = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        Assert.assertTrue(belcartLogo.isDisplayed(), "Иконка Белкард не отображается");

        WebElement mirLogo = driver.findElement(By.xpath("//div[@class='cards-brands cards-brands_random ng-tns-c61-0 ng-star-inserted']"));
        Assert.assertTrue(mirLogo.isDisplayed(), "Иконка Мир не отображается");


        driver.get("https://www.mts.by/");
    }

    private void selectService(String serviceName) {
        WebElement serviceDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='select__header']")));
        serviceDropdown.click();
        WebElement serviceOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + serviceName + "']")));
        serviceOption.click();
    }


    private void acceptCookies() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//button[@class='btn btn_black cookie__ok']")));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
            }
        } catch (Exception e) {
            System.out.println("Cookie popup not found or clickable");
        }
    }
}
