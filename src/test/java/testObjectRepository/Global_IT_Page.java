package testObjectRepository;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import userDefinedLibraries.ScreenShot;

public class Global_IT_Page {
	
	
	public WebDriver driver;
	public ArrayList<String> app=new ArrayList<String>();
	JavascriptExecutor js;

	// Constructor that will be automatically called as soon as the object of the class is created
    public Global_IT_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    //Locating all the needed elements for scenario
	@FindBy(xpath="//div[@class='e_a_37591358 q_a_37591358']//div[@data-automation-id='HeroTitle']")
	public List<WebElement> apps;
	@FindBy(xpath="//*[text()='IT News']")
	public WebElement IT_News;
	@FindBy(xpath="//span[text()='Document Library']")
	public WebElement awardsView;
	@FindBy(id="it-awards")
	public WebElement IT_Awards;
	@FindBy(xpath="//div[@data-automation-id='gridNewsLayout']//a[@id='news_text_title']")
	public List<WebElement> newsHeadersList;
	@FindBy(xpath="//span[@data-automationid='splitbuttonprimary']//i[@data-icon-name='Info']")
	public WebElement awards1;
	@FindBy(xpath="/span[contains(@id,'displayNameColumn')]/span")
	public WebElement awards2;
	@FindBy(xpath="//div[@data-automation-id='listNewsLayout']//a[@data-automation-id='newsItemTitle']")
	public List<WebElement> awardsList;
	@FindBy(xpath="//div[@data-automation-id='CanvasLayout']/div[1]/div/div[1]/div[2]//div[@data-automation-id='textBox']/p")
	public List<WebElement> descriptionsList;

	//Exploring other apps in Global IT page
	public void exploreApps() {
		js=(JavascriptExecutor)driver;
		int j=1;
		for(int i=0;i<apps.size();i++) {
			js.executeScript("arguments[0].click();",apps.get(i));
			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String s=driver.getTitle();
			try {
			    //Taking screenshot
			   ScreenShot.getScreenShot(driver, "App"+j+".png");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			app.add(i, s);
			driver.navigate().back();
			j++;
		}
	}		

		
	}
	
	
	
	
	
	
	