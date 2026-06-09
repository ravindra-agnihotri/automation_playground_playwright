package manager.execution;

import com.microsoft.playwright.Page;
import manager.playwright.BrowserFactory;
import manager.playwright.ContextManager;
import manager.playwright.PageManager;
import manager.playwright.PlaywrightProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    protected  Page page=null;

    @BeforeSuite
    public void beforeSuite(){
        PlaywrightProvider.getPlaywright();

    }

    @BeforeTest
    public void beforeTest(){
        BrowserFactory.getBrowser();
        ContextManager.createContext();
        page=PageManager.getPage();
    }



    public void afterSuite(){
        PageManager.closePage();
        ContextManager.closeContext();
        BrowserFactory.closeBrowser();
        PlaywrightProvider.releasePlaywright();

    }
}
