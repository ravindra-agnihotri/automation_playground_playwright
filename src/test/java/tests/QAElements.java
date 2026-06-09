package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import manager.execution.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import manager.playwright.PageManager;
import util.Util;

public class QAElements extends BaseClass {


    Page page = null;

    @BeforeClass
    public void beforeClass() {
        page.navigate("/pages/a.html");
    }


    @Test
    public void allElem() {
        page.getByTestId("input-text").fill("Ravi");
        page.getByTestId("input-email").fill("test@test.mlm");
        page.getByTestId("input-password").fill("Rushika");
        page.getByTestId("input-tel").fill("7757070893");
        page.getByTestId("input-number").fill("11");
        Locator date = page.getByTestId("input-date");
        date.press("Control+A");
        date.press("Backspace");
        date.type("01011989");
        page.getByTestId("select-single").selectOption("India");
        page.getByTestId("select-multi").scrollIntoViewIfNeeded();
        page.getByTestId("select-multi").selectOption(new String[]{"Java", "HTML"});
        page.locator("#btn-primary").click();
        boolean visible = page.locator("div[data-testid*=toast-area]").isVisible();
        System.out.println("Primary button visible?= " + visible);
        page.getByTestId("btn-double-click").click(Util.clickCount(2));
        if (page.locator("div[data-testid*=toast-area]").isVisible()) {
            String text = page.locator("div[data-testid*=toast-area]").textContent();
            System.out.println(text);

        }
        page.getByTestId("btn-right-click").click(Util.rightClick());
        if (page.locator("div[data-testid*=toast-area]").isVisible()) {
            String text = page.locator("div[data-testid*=toast-area]").textContent();
            System.out.println(text);

        }
        Locator locator = page.locator("tr[data-testid*=row-]");
        for (int i = 0; i <= locator.count() - 1; i++) {
            System.out.println(locator.nth(i).locator("td[data-testid*=row-]").count()+"td count");
            for (int j=0;j<=locator.nth(i).locator("td[data-testid*=row-]").count()-1;j++){
            System.out.println(locator.nth(i).locator("td[data-testid*=row-]").nth(j).textContent());



        }
    }
        page.locator("button[data-testid='btn-modal-open']").scrollIntoViewIfNeeded();
        page.locator("button[data-testid=btn-modal-open]").click();
        page.locator("button[data-testid=modal-confirm]").click();
}}