package manager.playwright;

import com.microsoft.playwright.Page;

public class PageManager {


    private static ThreadLocal<Page> pageThreadLocal= new ThreadLocal<>();


    public static Page getPage(){
        if (pageThreadLocal.get()==null) {
            Page page = ContextManager.createContext().newPage();
            pageThreadLocal.set(page);

            System.out.println("Page instance -" + page);
            return page;
        }else {
            return pageThreadLocal.get();
        }
    }

    public static void closePage(){
        if (pageThreadLocal.get()!=null){
            pageThreadLocal.get().close();
            pageThreadLocal.remove();
        }
    }
}
