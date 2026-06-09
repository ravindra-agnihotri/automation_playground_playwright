package manager.execution;

import com.microsoft.playwright.Page;
import manager.playwright.BrowserFactory;
import manager.playwright.ContextManager;
import manager.playwright.PageManager;
import manager.playwright.PlaywrightProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    protected  Page page;



    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Running Before Suite");
        PlaywrightProvider.getPlaywright();
        BrowserFactory.getBrowser();
        ContextManager.createContext();
        page=PageManager.getPage();
    }



@AfterSuite
    public void afterSuite(){
    System.out.println("Running After Suite");
        PageManager.closePage();
        ContextManager.closeContext();
        BrowserFactory.closeBrowser();
        PlaywrightProvider.releasePlaywright();

    }
}
