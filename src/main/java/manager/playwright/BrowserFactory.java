package manager.playwright;

import com.microsoft.playwright.Browser;

public class BrowserFactory {


    private static ThreadLocal<Browser> browserThreadLocal= new ThreadLocal<>();



    public static Browser getBrowser(){
        if (browserThreadLocal.get()==null) {
            Browser browser = PlaywrightProvider.getPlaywright().chromium().launch(PlaywrightHelper.launchOption());
            browserThreadLocal.set(browser);
            System.out.println("Browser instance - " + browserThreadLocal.get());
            return browserThreadLocal.get();
        }else {
        return browserThreadLocal.get();
    }}


    public static void closeBrowser(){
        if (browserThreadLocal.get()!=null){
            browserThreadLocal.get().close();
            browserThreadLocal.remove();
        }

    }
}
