package manager.playwright;

import com.microsoft.playwright.BrowserContext;

public class ContextManager {


    private static ThreadLocal<BrowserContext> contextThreadLocal= new ThreadLocal<>();

    public static BrowserContext createContext(){
        if (contextThreadLocal.get()==null) {
            BrowserContext context = BrowserFactory.getBrowser().newContext(PlaywrightHelper.newContextOption());
            contextThreadLocal.set(context);
            return contextThreadLocal.get();
        }else {
            return contextThreadLocal.get();
        }
    }
public static void closeContext(){
        if (contextThreadLocal.get()!=null){
        contextThreadLocal.get().close();
        contextThreadLocal.remove();
}


}}
