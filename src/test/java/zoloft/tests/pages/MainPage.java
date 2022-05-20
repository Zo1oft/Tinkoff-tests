package zoloft.tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    //locators
    SelenideElement
            debitCardButton = $$("button[type=button]").findBy(Condition.text("Оформить карту")),
            debitCardForm = $("div[data-qa-type='uikit/formGroup']"),
            investPage = $$(byLinkText("Инвестиции")).findBy(Condition.text("Инвестиции"));

    //actions
public MainPage openPage() {
    open("https://www.tinkoff.ru/");
    return this;
}

public void debitCardFormTransfer() {
    debitCardButton.click();

}

public void debitCardFormCheck() {
    debitCardForm.shouldHave(Condition.text("Заполните заявку за 5 минут"));

}

public void investPageTransfer() {
    investPage.click();

}
}
