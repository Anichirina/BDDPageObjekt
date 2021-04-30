package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {

        private ElementsCollection actionDeposit = $$("[data-test-id = action-deposit]");
        private SelenideElement actionReloadButton = $("[data-test-id = action-reload]");
        private ElementsCollection balansCard = $$("[data-test-id]");
        private SelenideElement amountCard = $("[data-test-id=amount]");
        private SelenideElement fromCard = $("[data-test-id=from]");
        private SelenideElement buttonActionTransfer = $("[data-test-id=action-transfer]");

         public TransferPage() {
        amountCard.shouldBe(Condition.visible);
    }

    public DashboardPage validTransferToFirst(DataHelper.CardNumber cardInfo, int randomCash) {
        amountCard.setValue(String.valueOf(randomCash));
        fromCard.setValue(cardInfo.getCardsNumbers()[1]);
        buttonActionTransfer.click();
        return new DashboardPage();
    }

    public DashboardPage validTransferToSecond(DataHelper.CardNumber cardInfo, int randomCash) {
        amountCard.setValue(String.valueOf(randomCash));
        fromCard.setValue(cardInfo.getCardsNumbers()[2]);
        buttonActionTransfer.click();
        return new DashboardPage();
    }

    public void notEnoughBalance() {
        $(Selectors.byText("Недостаточно средств")).shouldBe(Condition.visible);
    }
}