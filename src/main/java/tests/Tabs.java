package tests;

import com.microsoft.playwright.Page;
import manager.execution.BaseClass;
import manager.playwright.PageManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.ConfigReader;
import util.ScreenshotUtil;
import util.Util;

public class Tabs extends BaseClass{


    @BeforeClass
    public void beforeClass(){
       page= PageManager.getPage();
        page.navigate("/pages/tabs.html");
    }


    @Test
    public void tabOps(){

       Page newTab= page.context().waitForPage(()-> page.getByTestId("btn-blank-tab").click());
        System.out.println(newTab.url());
      page.bringToFront();
      Page onePage=page.context().waitForPage(()->page.getByTestId("btn-delayed-tab").click());
        System.out.println(onePage.url());
        Page named=page.context().waitForPage(()->page.getByTestId("btn-named-window").click());
        named.setViewportSize(ConfigReader.getIntegerConfig("SCREEN_WIDTH"),ConfigReader.getIntegerConfig("SCREEN_HEIGHT"));
        page.bringToFront();
        named.close();
        onePage.close();
        ScreenshotUtil.screenshot(page);



    }


    }

