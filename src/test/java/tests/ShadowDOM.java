package tests;

import com.microsoft.playwright.Page;
import manager.execution.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import manager.playwright.PageManager;

public class ShadowDOM extends BaseClass {


    Page page=null;
    @BeforeClass
    public void beforeClass(){
        page.navigate("pages/shadow-dom.html");
    }
@Test
    public void shadowDom(){
        page.locator("#shadowInput").fill("new");
    }
}
