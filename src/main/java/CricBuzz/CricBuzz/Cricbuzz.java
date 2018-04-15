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
	public void cricbuzztest() {
String ConsumerKey="ZD40Ccigo2MQMs0rtI2Us9Lx1";
		
		String ConsumerSecret="JAUq6FkYbF2RYdORBiZDSRMbSB0NkUML0K4jxwVnZtzwj2TLyW";
		
		String AccessToken="985546526326849536-KFpYfp1LFuz5mld0JmlyeogxyUidCg7";
		
	    String TokenSecret="ENTa0yfFX9fsrR90oo6UcKFHu9TDMACCmpEHsiVI7vtId";
	    
		RestAssured.baseURI="https://api.twitter.com";
		
		RestAssured.basePath="/1.1/statuses";
		
		System.setProperty("webdriver.chrome.driver","E:\\PersonalWorkSpace\\FreeCRM\\Drivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
		
		WebDriver driver=new ChromeDriver(chromeOptions);
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://www.cricbuzz.com/live-cricket-scores/20072/kxip-vs-csk-12th-match-indian-premier-league-2018");
		
		String score=driver.findElement(By.xpath("//div[@class='cb-min-bat-rw']/h2")).getText();
	   
		//String Progress=driver.findElement(By.xpath("(//div[@class='cb-text-inprogress'])[2]")).getText();
		
		
		
		System.out.println(score);
		
		//System.out.println(Progress);
		
	given()
	    .auth()
	    .oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
       // .queryParam("status",score+"\n" +Progress +"\n" +"#IPL2018 #KXIPvCSK")
	    .queryParam("status",score)
    .when()
        .post("update.json");

		driver.quit(); 
	}
	}

