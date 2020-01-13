/*
Question 2 :
The following exercise does not require user login. Please use ID or class as selectors.

Steps:
1. Navigate to https://www.weightwatchers.com/us/
2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help”
3. On the right corner of the page, click on “Find a Studio”
4. Verify loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
5. In the search field, search for meetings for zip code: 10011
6. Print the title of the first result and the distance (located on the right of location title/name)
7. Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week
e.g. printMeetings("Sun")
Output should be:
Person A  3
Person B  1

Write an automated test for this scenario using WebDriver.
*/

//Note : I have used xpath as selectors wherever I could not use ID or Class as selectors.

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class WeightWatchers {
	
  public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.ie.driver","C:\\Users\\AMIT PODDAR\\Desktop\\Selenium Material\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		
		//1. Navigate to https://www.weightwatchers.com/us/
		
		driver.get("https://www.weightwatchers.com/us/");
		
		//2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help”
		
		String actualTitle = driver.getTitle();
        String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help";
        Assert.assertEquals(actualTitle, expectedTitle);
	    
        //3. On the right corner of the page, click on “Find a Studio”
        
        driver.findElement(By.className("find-a-meeting")).click();
        
       //4. Verify loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
        
        String loadedpageTitle1 = driver.getTitle();
        String loadedpageTitle2 = "Find WW Studios & Meetings Near You | WW USA";
        Assert.assertEquals(loadedpageTitle1,loadedpageTitle2);
          
        //5. In the search field, search for meetings for zip code: 10011
        
        driver.findElement(By.name("meetingSearch")).sendKeys("10011");
        
        driver.findElement(By.xpath("//form/div/button")).click();
        
       //6. Print the title of the first result and the distance (located on the right of location title/name)
         
       String firstresulttitle = driver.findElement(By.xpath("//location-address/div/div/div/div/span")).getText();
       System.out.println(firstresulttitle);
        
       String distance  = driver.findElement(By.xpath("//location-address/div/div/div/div[2]")).getText();
       System.out.println(distance);
        
        //7.Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
        
       driver.findElement(By.xpath("//span[contains(text(),'WW Studio Flatiron')]")).click();
       
       String firstsearchresultname = driver.findElement(By.xpath("//location-address/div/div/div/div/span")).getText();
       
       String displayedtitle = "WW Studio Flatiron";
       
       Assert.assertEquals(firstsearchresultname, displayedtitle);
        
        //8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
       
       String hoursofoperation1 = driver.findElement(By.xpath("//div[contains(text(),'10:30 AM')]")).getText();
       System.out.println(hoursofoperation1);
       
       String hoursofoperation2 = driver.findElement(By.xpath("//div[contains(text(),'12:00 PM')]")).getText();
       System.out.println(hoursofoperation2);
         
         
        /* 9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week
         e.g. printMeetings("Sun")
         Output should be:
         Person A  3
         Person B  1
        
       Solution : Needs screenscraping to be done - something I am not familiar with.
       It would be getting the page source code and then navigating to studio schedule and then for each of the lists iterating over them and reading each unique user.
       As each user is being read we would increment the count.
       I have not done this type of screenscraping and iteration. I am familiar with the logic but not from a code perspective,hence could not implement it.
        */
	}
}
	
