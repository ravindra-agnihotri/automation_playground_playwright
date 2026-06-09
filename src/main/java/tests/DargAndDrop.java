package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import manager.execution.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import manager.playwright.PageManager;
import util.Util;

public class DargAndDrop extends BaseClass{


    @BeforeClass
    public  void beforeClass(){
page=PageManager.getPage();
        page.navigate("pages/drag-drop.html");
    }


    @Test
    public void dragAndDrop(){

       Locator dragger=  page.getByTestId("item-alpha");
       dragger.dragTo( page.getByTestId("drop-zone-b"));
               Util.captureScreenShot(page);
    }
}
