package zoloft.tests.tests;

import zoloft.tests.helpers.DriverUtils;
import zoloft.tests.pages.InvestPage;
import zoloft.tests.pages.MainPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TinkoffTests extends TestBase {

    @Test
    @Description("Проверка работы кнопки оформления карты")
    @DisplayName("Оформить карту")
    void debitCardTest() {
        step("Открываем сайт Tinkoff", () -> {
           mainPage.openPage();
        });

        step("Нажимаем кнопку 'оформить карту'", () -> {
            mainPage.debitCardFormTransfer();
        });

        step("Проверяем, что мы на верной странице", () -> {
            mainPage.debitCardFormCheck();
        });
    }

    @Test
    @Description("Проверка работы станицы и кнопки открытия брокерского счета")
    @DisplayName("Брокерский счет")
    void investmentTest() {
        step("Открываем сайт Tinkoff", () -> {
            mainPage.openPage();
        });

        step("Переходим на страницу 'Инвестиции'", () -> {
            mainPage.investPageTransfer();
        });

        step("Переходим на форму заполнения заявки", () -> {
            investPage.investAccountFormTransfer();
        });

        step("Проверяем, что мы на верном экране", () -> {
            investPage.investAccountFormCheck();
        });
    }

    @Test
    @Description("Проверка наличия Title на странице")
    @DisplayName("Работоспособность сайта")
    void titleTest() {
        step("Открываем сайт Tinkoff", () -> {
            mainPage.openPage();
        });
        step("Проверяем наличие Title", () -> {
            String expectedTitle = "Тинькофф — Кредитные и дебетовые карты, кредиты для бизнеса и физических лиц";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Проверка наличия ошибок в консоли")
    @DisplayName("Логи консоли страницы не должны содержать ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт Tinkoff", () -> {
            mainPage.openPage();
        });

        step("Логи в консоле не должны иметь 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
