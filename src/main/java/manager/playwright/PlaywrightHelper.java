package manager.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.options.ScreenSize;
import com.microsoft.playwright.options.ViewportSize;
import util.ConfigReader;

import static util.ConfigReader.*;

public class PlaywrightHelper {


    public static BrowserType.LaunchOptions launchOption(){
        BrowserType.LaunchOptions launchOptions= new BrowserType.LaunchOptions();
        launchOptions.headless=Boolean.parseBoolean( ConfigReader.getConfig("HEADLESS"));
        launchOptions.slowMo=ConfigReader.getDoubleConfig("SLOW_MO");

        return launchOptions;
    }


    public static Browser.NewContextOptions newContextOption(){
        return new Browser.NewContextOptions()
                .setBaseURL(ConfigReader.getConfig("BASE_URL"))
                .setScreenSize(new ScreenSize(getIntegerConfig("SCREEN_WIDTH"),getIntegerConfig("SCREEN_HEIGHT")))
                .setViewportSize(new ViewportSize(getIntegerConfig("SCREEN_WIDTH"),getIntegerConfig("SCREEN_HEIGHT")));
    }
}
