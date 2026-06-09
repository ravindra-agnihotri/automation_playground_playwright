package util;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ScreenshotUtil {
    private static String dateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_dd_MM_ss", Locale.of("INDIA"));
        String datetime = LocalDateTime.now().format(formatter);
        return datetime;
    }
    public static void screenshot(Page page){
        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Path.of("src/main/resources/screenshots/"+dateTime()+".jpeg"))
                        .setFullPage(true)
                        .setType(ScreenshotType.JPEG)

        );
    }
}
