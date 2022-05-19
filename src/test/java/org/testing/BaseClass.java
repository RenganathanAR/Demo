package org.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	static Select select;
	public static void browserLaunch() {
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	}
	public static void maximizeWindow() {
    driver.manage().window().maximize();
	}
	public static void openUrl(String url) {
	driver.get(url);	
    }
	public static WebElement locateById(String id) {
    WebElement findElementById = driver.findElement(By.id(id));
	return findElementById; 
	}
	public static WebElement locateByName(String name) {
    WebElement findElementByName = driver.findElement(By.name(name));
	return findElementByName;
	}
	public static WebElement locateByXpath(String xpathExpression) {
    WebElement elementByXpath = driver.findElement(By.xpath(xpathExpression));
	return elementByXpath;
	}
	public static void closeBrowser() {
    driver.close();
	}
	public static void selectByIndex(WebElement element, int index) {
	select=new Select(element);
    select.selectByIndex(index);
	}
	public static void selectByValue(String id,String value) {
	WebElement element = driver.findElement(By.id(id));	
	select=new Select(element);	
    select.selectByValue(value);
	}
    public static void inputText(WebElement element, String keysToSend) {
    element.sendKeys(keysToSend);
	}
    public static void clickFunction(WebElement element) {
    element.click();
	}
    public static void selectByVisibleText(WebElement element,String text) {
    select=new Select(element);
    select.deselectByVisibleText(text);
	}
    public static String inputExcelRead(String path,String sheet, int row,int cell ) throws IOException {
    String value=null;
    File f=new File(path);
    FileInputStream fin=new FileInputStream(f);
    Workbook w=new XSSFWorkbook(fin);
    Sheet s=w.getSheet(sheet);
    Row r = s.getRow(row);
    Cell c = r.getCell(cell);
    int cellType = c.getCellType();
   if (cellType==1) {
     value=c.getStringCellValue();	
} else if (cellType==0) {
	if (DateUtil.isCellDateFormatted(c)) {
        Date dateCellValue = c.getDateCellValue();
        SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy");
        value=sim.format(dateCellValue);
        System.out.println(value);
        }
	else {
		double numericCellValue = c.getNumericCellValue();
		long l=(long)numericCellValue;
		System.out.println(value);
	}
	
}
return value;
}
    
    		
    
	}

