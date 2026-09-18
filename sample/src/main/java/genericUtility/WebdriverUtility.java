package genericUtility;


	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	import java.util.List;
	import java.util.Set;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebdriverUtility {
		WebDriver driver;
		public WebDriver launchBrowser(String browser) {
			if(browser.equalsIgnoreCase("chrome"))
				 driver=new ChromeDriver();
			 else if(browser.equalsIgnoreCase("firefox"))
				 driver=new FirefoxDriver();
			 else if(browser.equalsIgnoreCase("edge"))
				 driver=new EdgeDriver();
			 else 
				 driver=new ChromeDriver();
			return driver;
			 
		}
		public void getUrl(String url) {
			driver.get(url);
		}
	public void toSwitchToWindow(WebDriver driver,String partialTitle) {
		Set<String> allSessionid = driver.getWindowHandles();
		for (String string : allSessionid) {
			driver.switchTo().window(string);
			if(driver.getTitle().contains(partialTitle)) {
				break;
			}
		}
	}
	/**
	 * This Method is used to maximize the browser window.
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void customizeimplicitWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	/**
	 * This method is used to wait the driver implicity.
	 * @param driver
	 */
	public void toImplicityWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is used to perform  scrolling actions on the browser window based on web Element.
	 * @param driver
	 * @param element
	 */
	public void toScrollToElement(WebDriver driver, WebElement element) {
		Actions ac= new Actions(driver);
		ac.scrollToElement(element).perform();
	}
	/**
	 * This Method is used to perform scrolling actions on the browser window based on x and y values.
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void toScrollByAmount(WebDriver driver, int x, int y) {
		Actions ac= new Actions(driver);
		ac.scrollByAmount(x, y).perform();
	}
	/**
	 * This Method is used to perform  mouse hover action in the window based on the webelement.
	 * @param driver
	 * @param element
	 */
	public void toMoveToElement(WebDriver driver,WebElement element) {
		Actions ac= new Actions(driver);
		ac.moveToElement(element).perform();
	}
	/**
	 * This method is used to  perform mouse hover action in the window based on x and y values.
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void toMoveByOffset(WebDriver driver,int x,int y) {
		Actions ac = new Actions(driver);
		ac.moveByOffset(x, y).perform();
	}
	/**
	 * This method is used to select the options by using index value.
	 * @param element
	 * @param index
	 */
	public void toSelectByIndex(WebElement element, int index) {
		Select sc= new Select(element);
		sc.selectByIndex(index);
	}
	/**
	 * This Method is used to select options by using values.
	 * @param element
	 * @param value
	 */
	public void toSelectByValue(WebElement element, String value) {
		Select sc= new Select(element);
		sc.selectByValue(value);
	}
	/**
	 * This method is used to select options by using Visible text.
	 * @param element
	 * @param visibleText
	 */
	public void toSelectByVisibleText(WebElement element,String visibleText) {
		Select sc= new Select(element);
		sc.selectByVisibleText(visibleText);
	}
	/**
	 * This method is used to de-select the options by using index value.
	 * @param element
	 * @param index
	 */
	public void toDeselectByIndex(WebElement element, int index) {
		Select sc= new Select(element);
		sc.deselectByIndex(index);
	}
	/**
	 * This Method is used to de-select options by using values.
	 * @param element
	 * @param value
	 */
	public void toDeselectByValue(WebElement element, String value) {
		Select sc= new Select(element);
		sc.deselectByValue(value);
	}
	/**
	 * This method is used to de-select options by using Visible text.
	 * @param element
	 * @param visibleText
	 */
	public void toDeselectByVisibleText(WebElement element,String visibleText) {
		Select sc= new Select(element);
		sc.deselectByVisibleText(visibleText);
	}
	/**
	 * This method is used to wait the driver until the element to be click-able.
	 * @param driver
	 * @param element
	 */
	public void toWaitUntilElementIsClickable(WebDriver driver,WebElement element) {
		Duration duration= Duration.ofSeconds(10);
		WebDriverWait wait= new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to get the first selected option from drop_down.
	 * @param element
	 * @return WebElement
	 */
	public WebElement toGetFirstSelectedOption(WebElement element) {
		Select sc= new Select(element);
		 return sc.getFirstSelectedOption();
	}
	/**
	 * This method is used to get list of options web element from the drop_down.
	 * @param element
	 * @return List<WebElement.
	 */
	public List<WebElement> toGetOption(WebElement element) {
		Select sc= new Select(element);
		List<WebElement> options = sc.getOptions();
		return options;
	}
	/**
	 * This method is used to get all selected options from the drop_down.
	 * @param element
	 * @return List<WebElement>
	 */

	public List<WebElement> toGetAllSelectedOptions(WebElement element) {
		Select sc= new Select(element);
		 return sc.getAllSelectedOptions();

	}
	/**
	 * This method is used to de_select all the selected options from the drop_down. 
	 * @param element
	 */
	public void toDeselectAllOptions(WebElement element) {
		Select sc= new Select(element);
		sc.deselectAll(); 
	 }
	/**
	 * This method is used to check the drop_down is multiple select drop_down or not.
	 * @param element
	 * @return boolean.
	 */
	public boolean toCheckISMultiple(WebElement element) {
		Select sc= new Select(element);
		 return sc.isMultiple();
	}
	/**
	 * This method is used to Right Click the web element
	 * @param driver
	 * @param element
	 */
	public void toRightClickWebElement(WebDriver driver,WebElement element) {
		Actions ac= new Actions(driver);
		ac.contextClick(element).perform();;
		
	}
	/**
	 * This method is used to Right click the web page.
	 * @param driver
	 */
	public void toRightClickWebpage(WebDriver driver) {
		Actions ac= new Actions(driver);
		 ac.contextClick().perform();
	}
	/**
	 * This method is used to Click and Hold the web Element.
	 * @param driver
	 * @param element
	 */
	public void toClickAndHoldWebElement(WebDriver driver,WebElement element) {
		Actions ac= new Actions(driver);
		ac.clickAndHold(element).perform();
	}
	/**
	 * this method is used to click and hold the web page.
	 * @param driver
	 */
	public void toClickAndHoldWebpage(WebDriver driver) {
		Actions ac= new Actions(driver);
		ac.clickAndHold().perform();
	}
	/**
	 * This method is used to double click the WebElement.
	 * @param driver
	 * @param element
	 */
	public void toDoubleClickWebElement(WebDriver driver,WebElement element) {
		Actions ac= new Actions(driver);
		ac.doubleClick(element).perform();
	}
	/**
	 * This Method is Used to Double click the web page.
	 * @param driver
	 */
	public void toDoubleClickWebpage(WebDriver driver) {
		Actions ac= new Actions(driver);
		ac.doubleClick().perform();
	}
	/**
	 * This method is used to release the click and hold from the web page.
	 * @param driver
	 */
	public void toReleaseFromWebpage(WebDriver driver) {
		Actions ac= new Actions(driver);
		ac.release().perform();
	}
	/**
	 * This method is used to release the click and hold from the webElement.
	 * @param driver
	 * @param element
	 */
	public void toReleaseFromWeBElement(WebDriver driver,WebElement element) {
		Actions ac= new Actions(driver);
		ac.release(element).perform();
	}
	/**
	 * This method is used to perform Drag and drop action based on source and target webelement.
	 * @param driver
	 * @param Source
	 * @param target
	 */
	public void toDragAndDropByWebElement(WebDriver driver,WebElement Source,WebElement target) {
		Actions ac= new Actions(driver);
		ac.dragAndDrop(Source, target).perform();
	}
	/**
	 * This method is used to perform Drag and drop action based on web Element and offset values.
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void toDropAndDropByOffset(WebDriver driver,WebElement element,int x, int y) {
		Actions ac= new Actions(driver);
		ac.dragAndDropBy(element, x, y).perform();
	}
	/**
	 * This Method is used to get title of the current web page.
	 * @param driver
	 * @return String
	 */
	public String toGetTittle(WebDriver driver) {
	 return	driver.getTitle();
	}
	/**
	 * This method is used to navigate to url.
	 * @param driver
	 * @param url
	 */
	public void toGet(WebDriver driver,String url) {
		driver.get(url);
	}
	/**
	 * This Method is used to get the current Url of the webPage.
	 * @param driver
	 * @return String
	 */
	public String toGetCurrentUrl(WebDriver driver) {
		 return driver.getCurrentUrl();
	}
	/**
	 * This Method is used to get the Page source.
	 * @param driver
	 * @return String
	 */
	public String toGetPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	/**
	 * This Method is used to close the current web page.
	 * @param driver
	 */
	public void toClose(WebDriver driver) {
		driver.close();
	}
	/**
	 * This method is used to close all the web pages and terminate server connection.
	 * @param driver
	 */
	public void toQuit(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method is used to minimize the browser window.
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to full screen the browser window.
	 * @param driver
	 */
	public void toFullScreen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	/**
	 * This method is used to GetSize of the browser window.
	 * @param driver
	 * @return Dimension
	 */
	public Dimension toGetSize(WebDriver driver) {
		 return driver.manage().window().getSize();
	}
	/**
	 * This method is used to get height of the browser window.
	 * @param driver
	 * @return int
	 */
	public int toGetHeight(WebDriver driver) {
		 return driver.manage().window().getSize().getHeight();
	}
	/**
	 * This method is used to get width of the browser window.
	 * @param driver
	 * @return int
	 */
	public int toGetWidth(WebDriver driver) {
		 return driver.manage().window().getSize().getWidth();
	}
	/**
	 * This method is used to get position of browser window.
	 * @param driver
	 * @return Point
	 */
	public Point toGetPosition(WebDriver driver) {
		 return driver.manage().window().getPosition();
	}
	/**
	 * This method is used to get X coordinates of the browser window.
	 * @param driver
	 * @return int
	 */
	public int toGetX(WebDriver driver) {
		 return driver.manage().window().getPosition().getX();
		
	}
	/**
	 * This method is used to get Y coordinates of the browser window.
	 * @param driver
	 * @return int
	 */
	public int toGetY(WebDriver driver) {
		 return driver.manage().window().getPosition().getY();
	}
	/**
	 * This method is used to set the size of the browser window.
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void toSetSize(WebDriver driver,int x, int y) {
		driver.manage().window().setSize(new Dimension(x, y));
	}
	/**
	 * This Method is used to set position of the browser window.
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void toSetPosition(WebDriver driver,int x, int y) {
		driver.manage().window().setPosition(new Point(x, y));
	}
	/**
	 * This method is used to navigate back the browser web page.
	 * @param driver
	 */
	public void toNavigateBack(WebDriver driver) {
		driver.navigate().back();
	}
	/**
	 * This method is used to navigate forward the browser web page.
	 * @param driver
	 */
	public void toNavigateForward(WebDriver driver) {
		driver.navigate().forward();
	}
	/**
	 * This method is used to refresh the web page.
	 * @param driver
	 */
	public void toNavigateRefresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	/**
	 * This Method is used to navigate to url.
	 * @param driver
	 * @param Url
	 */
	public void toNavigateToUrl(WebDriver driver,String Url) {
		driver.navigate().to(Url);
	}
	/**
	 * This method is used to navigate url using URL class.
	 * @param driver
	 * @param Url
	 * @throws MalformedURLException
	 */
	public void toNavigateToURL(WebDriver driver,String Url) throws MalformedURLException {
		driver.navigate().to(new URL(Url));
	}
	/**
	 * This Method is used to get the current session id.
	 * @param driver
	 * @return String
	 */
	public String toGetCurrentSessionId(WebDriver driver) {
	 return	driver.getWindowHandle();
	}
	/**
	 * This method is used to get all session id
	 * @param driver
	 * @return Set<String>
	 */
	public Set<String> toGetAllSessionId(WebDriver driver) {
		return driver.getWindowHandles();
	}
	/**
	 * 
	 * @param driver
	 * @return Alert
	 */
	public Alert toHandleJSPopup(WebDriver driver) {
		return driver.switchTo().alert();
	}
	/**
	 * This method is used to enter the values in the disabled text field using javascriptExecutor.
	 * @param driver
	 * @param element
	 */
	public void toEnterValueInDisabledTextfiled(WebDriver driver,WebElement element,String value) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value= arguments[1]",element,value);
	}
	/**
	 * This method is used to scroll the web page using javascriptExecutor with the help of pixels.
	 * @param driver
	 * @param pixels
	 */
	public void toScrollByPixels(WebDriver driver, int pixels) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixels+")");
	}
	/**
	 * This method is used to scroll the web page to the particular pixels.
	 * @param driver
	 * @param pixels
	 */
	public  void toScrollTo(WebDriver driver, int pixels) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.ScrollTo(0,"+pixels+")");
	}
	/**
	 * This method is used to switch the driver control to frame using index.
	 * @param driver
	 * @param index
	 */
	public void toSwitchtoFrameByIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the driver control to frame using name/id.
	 * @param driver
	 * @param name
	 */
	public void toSwitchtoFrameByName(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	/**
	 * This method is used to switch the driver control to frame using frameElement
	 * @param driver
	 * @param element
	 */
	public void toSwitchtoFrameByWebElement(WebDriver driver,WebElement FrameElement) {
		driver.switchTo().frame(FrameElement);
	}
	/**
	 *This method is used to retrieve the driver control from frame to the immediateparentFrame.
	 * @param driver
	 */
	public void toswitchtoImmediateParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 *This method is used to retrieve the driver control the web page.
	 * @param driver
	 */
	public void toSwitchToWebpage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	}

