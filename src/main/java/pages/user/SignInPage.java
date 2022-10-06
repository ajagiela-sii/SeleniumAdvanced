package pages.user;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase {

    @FindBy(css = "input[name=email]")
    private WebElement emailInput;
    @FindBy(css = "input[name=password]")
    private WebElement passwordInput;

    @FindBy(css = "#submit-login")
    private WebElement signInBtn;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        sendKey(emailInput, email);
    }

    public void typePassword(String password) {
        sendKey(passwordInput, password);
    }

    public void clickSignInBtn() {
        click(signInBtn);
    }


}
