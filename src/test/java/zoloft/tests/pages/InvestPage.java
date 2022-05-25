package zoloft.tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InvestPage {
    
    //locator
    SelenideElement
        createInvestAccount = $$("button[type=button]").findBy(Condition.text("Открыть счет")),
        investAccountForm = $("div[data-qa-file='FormWrapper']");

    //action

    public void investAccountFormTransfer() {
        createInvestAccount.click();
    }

    public void investAccountFormCheck() {
        investAccountForm.shouldHave(Condition.text("Контактная информация"));
    }
}
