package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("login");

    public void login(String user, String pass) {
        actions.type(username, user);
        actions.type(password, pass);
        actions.click(loginBtn);
    }
}