package util;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

import java.nio.file.Path;

public class Util {

public static void captureScreenShot(Page page){
     page.screenshot(new Page.ScreenshotOptions()
             .setFullPage(true).setPath(Path.of("src/main/resources/aaa.png")));

}

public static Locator.ClickOptions clickCount(int times){
     Locator.ClickOptions clickOptions= new Locator.ClickOptions();
     clickOptions.clickCount=times;
     return clickOptions;
}

public static Locator.ClickOptions rightClick(){
Locator.ClickOptions clickOptions= new Locator.ClickOptions();
clickOptions.setButton(MouseButton.RIGHT);
return clickOptions;
}
}
