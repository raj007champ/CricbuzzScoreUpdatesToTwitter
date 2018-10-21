package CricBuzz.CricBuzz;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.restassured.RestAssured;



public class Cricbuzz {


	@Test
	public void cricbuzztest() throws InterruptedException {
		
		
		String ConsumerKey="Enter your Consumer Key";
		
		String ConsumerSecret="Enter your Consumer Secret";
		
		String AccessToken="Enter Access Token";
		
	    String TokenSecret="Enter TokenSecret";
	    
		RestAssured.baseURI="https://api.twitter.com";
		
		RestAssured.basePath="/1.1/statuses";
		
		System.setProperty("webdriver.chrome.driver","E:\\PersonalWorkSpace\\FreeCRM\\Drivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
		
		WebDriver driver=new ChromeDriver(chromeOptions);
		
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("http://www.cricbuzz.com/live-cricket-scores/20084/rcb-vs-csk-24th-match-indian-premier-league-2018");
		
		String score=driver.findElement(By.xpath("//div[@class='cb-min-bat-rw']/h2")).getText();
	   
		String Progress=driver.findElement(By.xpath("(//div[@class='cb-text-inprogress'])[2]")).getText();
		
		System.out.println(score);
		
		System.out.println(Progress);
		
	given()
	    .auth()
	    .oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
       .queryParam("status",score+"\n" +Progress +"\n" +"#CSKvRCB  #RCBvCSK #PlayBold")
	   // .queryParam("status",score)
    .when()
        .post("update.json");
	
	driver.quit();
	
	} 

		
	}
	

