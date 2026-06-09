package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import manager.execution.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import manager.playwright.PageManager;
import util.Util;

import java.nio.file.Paths;

public class Forms extends BaseClass {


    int id=12;
    @BeforeClass
    public void beforeClass(){
        page=PageManager.getPage();
       page.navigate("pages/forms.html");
    }


    @Test
    public void formsTest(){
        Util util= new Util();

        page.locator("#firstName").fill("Ravindra");
       page.locator("#lastName").fill("Agnihotri");
      page.locator("#email").fill("ravindra.swt@gmail.com");
      page.locator("#password").fill("Rushika");
page.locator("#mobile").fill("9999999999");
page.locator("#country").selectOption("India");
page.locator("#technology").selectOption(new String[]{"Java","Selenium"});
page.getByRole(AriaRole.RADIO,new Page.GetByRoleOptions().setName("Female")).setChecked(true);
page.getByRole(AriaRole.CHECKBOX,new Page.GetByRoleOptions().setName("Java")).setChecked(true);
Locator birthDate=page.locator("#birthDate");
birthDate.scrollIntoViewIfNeeded();
if (birthDate.isVisible()&&birthDate.elementHandle().isEditable()) {
    System.out.println("yes");
    birthDate.click();
    birthDate.press("Control+A");
   // birthDate.press("Backspace");
    birthDate.type("01011989");
}
Locator time=page.locator("#joiningTime");
time.press("Control+A");
        time.type("11111");
        page.locator("#resumeUpload").setInputFiles(Paths.get("src/main/resources/playwright_config.properties"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        if (page.getByText("Form Submitted", new Page.GetByTextOptions().setExact(true)).isVisible()){
            System.out.println("Displayed..submitted and closing");

        }

    }


}
