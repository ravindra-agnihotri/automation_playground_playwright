package tests;

import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import manager.playwright.PageManager;

public class ShadowDOM {


    Page page=null;
    @BeforeClass
    public void beforeClass(){
        page= PageManager.getPage();
        page.navigate("pages/shadow-dom.html");
    }
@Test
    public void shadowDom(){
        page.locator("#shadowInput").fill("new");
    }
}
