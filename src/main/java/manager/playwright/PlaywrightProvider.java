package manager.playwright;

import com.microsoft.playwright.Playwright;

public class PlaywrightProvider {

    private static ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    public static Playwright getPlaywright(){
        if (playwrightThreadLocal.get()==null){
            playwrightThreadLocal.set(Playwright.create());
            System.out.println(" playwright instance - "+ playwrightThreadLocal.get());
            return playwrightThreadLocal.get();
        }
        return playwrightThreadLocal.get();

    }

    public static void releasePlaywright(){
        if (playwrightThreadLocal.get() !=null){
            playwrightThreadLocal.get().close();
            playwrightThreadLocal.remove();
        }

    }
}
