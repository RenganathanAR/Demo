package org.testing;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Adactin extends BaseClass {
    public static void main(String[] args) throws IOException, InterruptedException {
		Adactin b=new Adactin();
	    b.browserLaunch();
		b.openUrl("https://adactinhotelapp.com/index.php");
		b.inputExcelRead("C:\\Users\\Renganathan AR\\eclipse-workspace\\Adactin\\Excel\\Book1.xlsx", "sheet1", 1, 1);
		b.inputText(b.locateById("username"),b.inputExcelRead("C:\\Users\\Renganathan AR\\eclipse-workspace\\Adactin\\Excel\\Book1.xlsx", "sheet1", 1, 0));
		WebElement locateById = b.locateById("password");
		b.inputText(locateById,b.inputExcelRead("C:\\Users\\Renganathan AR\\eclipse-workspace\\Adactin\\Excel\\Book1.xlsx", "sheet1", 1, 1));
        b.clickFunction(b.locateById("login"));
        b.maximizeWindow();
        b.selectByIndex(b.locateById("location"), 3);
        b.selectByIndex(b.locateById("hotels"), 2);
        b.selectByIndex(b.locateById("room_type"), 4);
        b.selectByIndex(b.locateById("room_nos"), 7);
        b.selectByIndex(b.locateById("adult_room"), 3);
        b.selectByIndex(b.locateById("child_room"), 2);
        b.clickFunction(b.locateById("Submit"));
        b.clickFunction(b.locateById("radiobutton_0"));
        b.clickFunction(b.locateById("continue"));
        b.inputText(b.locateByName("first_name"), "Renganathan");
        WebElement lastname = b.locateByName("last_name");
        b.inputText(lastname, "AR");
        WebElement address = b.locateByName("address");
        b.inputText(address, "Chennai");
        b.inputText(b.locateByName("cc_num"), "1234567891234567");
        b.selectByIndex(b.locateByName("cc_type"), 1);
        b.selectByIndex(b.locateByName("cc_exp_month"), 4);
        b.selectByIndex(b.locateByName("cc_exp_year"), 6);
        b.inputText(b.locateByName("cc_cvv"), "234");
        b.clickFunction(b.locateByName("book_now"));
        Thread.sleep(6000);
        b.clickFunction(b.locateByName("search_hotel"));
    }
}
