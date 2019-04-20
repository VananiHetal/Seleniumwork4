import Practicework4.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Nopcommerce_reusablemethod extends Utils {


        @Before

        public void Setup() {
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Browserdriver\\chromedriver.exe");
            driver = new ChromeDriver();
            //implicit wait applied to driver instance-
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // asking driver to get the url
            driver.get("https://demo.nopcommerce.com");
        }

        @Test

        public void usershouldbeabletoregistersuccessfully() {
            //Click on register button
            clickElementBy(By.xpath("//a[@class='ico-register']"));

            //Select gender as female
            enterText(By.xpath("//input[@id=\"gender-female\"]"),"female");
            //Write  first name Peter
            enterText(By.xpath("//Input[@name='FirstName']"),"peter");
            //Write lastname Fordman
            enterText(By.xpath("//Input[@name='LastName']"),"Fordman");
            // write email
            //Generate random email ID
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(1000);
            enterText(By.xpath("//Input[@name=\"Email\"]"),"username" + randomInt + "@gmail.com");
            //select newsletter option
            tickElement(By.xpath("//input[@name=\"Newsletter\"]"));
            //enter password
            enterText(By.xpath("//Input[@name=\"Password\"]"),"Naman1234");
            //confirmed password
            enterText(By.xpath("//Input[@name=\"ConfirmPassword\"]"),"Naman1234");
            //click registration button
            clickElementBy(By.xpath("//Input[@name=\"register-button\"]"));
            waitforelementDisplay(By.xpath("//div[@class=\"result\"]"),10);
        }

        @Test

        public void usershouldbeabletonavigatetonotebookcategorypage() {
            //click on computer category
            clickElementBy(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
            //click on notebook category
            clickElementBy(By.partialLinkText("Notebooks"));
            waitforelementDisplay(By.xpath("//div[@class=\"page-title\"]"),10);
            System.out.println("User should be able to navigate to notebooks category");

        }

        @Test

        public void usershouldbeabletonavigatecellphonepage() {
            // click on electronics category
            clickElementBy(By.xpath("//a [@href=\"/electronics\"]"));
            //click on Cellphone
            clickElementBy(By.partialLinkText("Cell phones"));
            waitforelementDisplay(By.xpath("//div[ @class =\"page-title\"]"),10);
            System.out.println("User should be able to navigate to cell phones category");

        }

        @Test


        public void usershouldbeabletologinsuccessfully() {

            //click on login button
            clickElementBy(By.xpath("//a [@class =\"ico-login\"]"));
            //random email instance
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(1000);
            // write email
            enterText(By.xpath("//input[@class=\"email\"]"),"username111@gmail.com");
            //Write password
            enterText(By.xpath("//input[@class=\"password\"]"),"Raman1234");
            //click on log in button
            clickElementBy(By.xpath("//input[@class=\"button-1 login-button\"]"));

            waitforelementDisplay(By.xpath("//a[@class=\"ico-logout\"]"),10);
            System.out.println("User should be able to login sucessfully");


        }


        @Test

        public void usershouldbeabletoaddproducttoshoppingcart() {


            //click on jewelery category
            clickElementBy(By.xpath("//a[@href=\"/jewelry\"]"));
            //click on vintage style engagement-ring
            clickElementBy(By.xpath("//a[@href=\"/vintage-style-engagement-ring\"]"));
            //click on the shopping cart
            clickElementBy(By.xpath("//input[@id=\"add-to-cart-button-42\"]"));
            waitforelementDisplay(By.xpath("// p[ @class=\"content\"]"),10);
            System.out.println("User should be able to add product into the shopping cart");
        }

        @After
        public void closeBrowser() {

            //driver instance
            driver.quit();
        }

    }



