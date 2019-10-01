package Twitter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

public class TwitterAuthentication {
		WebDriver driver;
		
		public void  LoginLink()
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\patlo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			// TODO Auto-generated method stub
			driver=new ChromeDriver();
			driver.get("https://www.twitter.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			String Title=driver.getTitle();
			System.out.println("Title of page is :"+Title);
			//clicking the first LogIn button/link
			driver.findElement(By.xpath("//*[@id=\'doc\']/div/div[1]/div[1]/div[2]/div[2]/div/a[2]")).click();
			boolean LogInForm=driver.findElement(By.xpath("//*[@id='page-container']/div")).isDisplayed();
			if(LogInForm==true)
				System.out.println("Login Form is displayed");
			else
				System.out.println("Login Form is not displayed");
			driver.navigate().back();
						
			driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[2]/div[1]/a")).click();
			boolean LogIn=driver.findElement(By.xpath("//*[@id='page-container']/div")).isDisplayed();
			if(LogIn==true)
				System.out.println("Login Form is displayed");
			else
				System.out.println("Login Form is not displayed");
					}
		
		public void LoginForm()
		{
			String Username="";  // Please enter your twitter user Id here
			String Password="";  // Please enter your twitter password here
			try {
				boolean user=driver.findElement(By.xpath("//*[@id='page-container']/div")).isDisplayed();
				if (user==true)
				{	
					
					driver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/fieldset/div[1]/input")).sendKeys(Username);
					driver.findElement(By.className("js-password-field")).sendKeys(Password);
					driver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/div[2]/button")).click();
				}
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				boolean welcome=driver.findElement(By.xpath("//*[@id=\'react-root\']/div/div/div/main/div/div/div/div/div/div[2]/div/div/div/div[1]/span")).isDisplayed();
					if(welcome==true)
						System.out.println("Successful");	
					else
						System.out.println("Failed");	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwitterAuthentication Log=new TwitterAuthentication();
		Log.LoginLink();
		Log.LoginForm();
	
	}

}
