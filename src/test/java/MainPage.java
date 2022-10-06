import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final SelenideElement head = $x("//div//h1");
    public String getHead(){
        return head.getOwnText();
    }

}
