package tests;

import com.microsoft.playwright.Page;
import manager.execution.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import manager.playwright.PageManager;
import util.Util;

public class Alerts  extends BaseClass {


    int id=1;
    @BeforeClass
    public void beforeClass(){
        page= PageManager.getPage();
        page.navigate("pages/alerts.html");
    }



    @Test
    public void alert(){
        Util util= new Util();

       /* page.locator("#simpleAlertBtn").click();
        page.onceDialog(a->{
            System.out.println(a.message());
            a.accept();});*/
page.locator("#promptAlertBtn").click();
page.onceDialog(dilog->{

    dilog.accept("asdadadadad");
    dilog.accept();
});

        System.out.println(page.locator("#result").innerText());
    }
}
