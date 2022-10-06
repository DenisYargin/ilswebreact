import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

public class TestClass extends BaseClass {
    private final static String Base_Url = "https://ilswebreact-develop.azurewebsites.net/";
    private final static String login_valid = "rekame2869@seinfaq.com";
    private final static String login_InValid = "ABC123";
    private final static String pass_Valid = "XRCa91zn4fsJzcHW";
    private final static String pass_InValid = "ABC123";
    private final static String chekMain = "Рабочий стол";
    private final static String expected_error = "Ошибка авторизации. Не верные логин/пароль";

    //Проверка на валидную авторизацию, ожидаем вывод главной страницы
    @Test
    public void checkAuthorization_valid() {
        Assert.assertTrue(new AuthorizationPage(Base_Url)
                .Authorization(login_valid, pass_Valid)
                .getHead()
                .contains(chekMain));
    }

    //Негативная проверка, на неправильный логин. Ожидаем попап с ошибкой
    @Test
    public void checkAuthorization_When_loginInvalid() {
        AuthorizationPage authPg = new AuthorizationPage(Base_Url);
        authPg.Authorization(login_InValid, pass_Valid);
        String errorCheck = authPg.GetTextError();
        Assert.assertEquals(expected_error,errorCheck);
    }

    //Негативная проверка, на неправлильный пароль. Ожидаем попап с ошибкой
    @Test
    public void checkAuthorization_When_PassInvalid() {
        AuthorizationPage authPg = new AuthorizationPage(Base_Url);
        authPg.Authorization(login_valid, pass_InValid);
        String errorCheck = authPg.GetTextError();
        Assert.assertEquals(expected_error,errorCheck);
    }

    //Негативная проверка, на незаполненный логин и попытка авторизироваться. Ожидаем подсказку, Пожалуйста, введите логин
    @Test
    public void checkAlert_When_noLogin(){
        AuthorizationPage authPg = new AuthorizationPage(Base_Url);
        authPg.NullLogin(pass_Valid);
        Assert.assertTrue(authPg.lgnChekIsVisible());

    }

    //Негативная проверка, на незаполненный логин и попытка авторизироваться. Ожидаем подсказку, Пожалуйста, введите пароль
    @Test
    public void checkAlert_When_noPassword(){
        AuthorizationPage authPg = new AuthorizationPage(Base_Url);
        authPg.nullPass(login_valid);
        Assert.assertTrue(authPg.passChekIsVisible());
    }



}


