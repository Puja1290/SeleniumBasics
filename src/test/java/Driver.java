
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.jar.JarEntry;

public class Driver {
    //this is driver class
    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException, AWTException, IOException {

        //JavaTutorial jt = new JavaTutorial();
        //jt.method2();
        //JavaTutorial.method1();
        // JavaTutorial.method2();
        // JavaTutorial.method3(8);
        SeleniumTutorial st = new SeleniumTutorial();
//st.launchBrowserAndApplication();
//st.iframeHandling();
//st.loginWithRobotClass();
        //st.filterPrice();
        // st.loginWithPropertyFileData();
        // st.popupHandling();
//st.usingActionClass();
      //  st.multipleWindowHandling();
        st.dynamicWebTableHandling();
    }

}
