package steps;

import base.PageBase;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.user.SignInPage;
import providers.UserFactory;

public class UserSteps extends PageBase {

    public UserSteps(WebDriver driver) {
        super(driver);
    }

    public void signIn() {
        SignInPage signInPage = new SignInPage(driver);
        User user = UserFactory.getAlreadyRegisteredUser();
        signInPage.typeEmail(user.getEmail());
        signInPage.typePassword(user.getPassword());
        signInPage.clickSignInBtn();
    }
}
