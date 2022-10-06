import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$x;

/*
* Страница авторизации сайта ilswebreact-develop.azurewebsites.net
 */
public class AuthorizationPage {
    private final SelenideElement loginBoxInput = $x("//input[@id='login']");
    private final SelenideElement passBoxInput = $x("//input[@id='password']");
    private final SelenideElement buttonInput = $x("//span[text() = 'Войти']");
    private final SelenideElement popupError = $x("//div[contains(text(), 'Ошибка авторизации')]");
    private final SelenideElement alertErrorLogin = $x("//*[@role = 'alert'][contains(text(), 'логин')]");
    private final SelenideElement alertErrorPass = $x("//*[@role = 'alert'][contains(text(), 'пароль')]");

    public AuthorizationPage(String url) {
        Selenide.open(url);
    }

    /**
     * Авторизация
     *
     * @param loginString - Логин,
     * @param passString  - Пароль
     */
    public MainPage Authorization(String loginString, String passString) {
        loginBoxInput.setValue(loginString);
        passBoxInput.setValue(passString);
        buttonInput.click();
        return new MainPage();
    }

//авторизации без логина
    public void NullLogin(String passString) {
        passBoxInput.setValue(passString);
        buttonInput.click();
    }
//авторизация без пароля
    public void nullPass(String loginString) {
        loginBoxInput.setValue(loginString);
        buttonInput.click();
    }

    public boolean lgnChekIsVisible() {
        if (alertErrorLogin.isDisplayed()) return true;
        else return false;
    }

    public boolean passChekIsVisible() {
        if (alertErrorPass.isDisplayed()) return true;
        else return false;
    }
//
    public String GetTextError(){
      return popupError.getText();
    }
}
