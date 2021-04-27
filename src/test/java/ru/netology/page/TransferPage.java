package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement actionDeposit = $("[data-test-id = action-deposit]");
    private SelenideElement actionReloadButton = $("[data-test-id = action-reload]");
    DashboardPage numberCard = new DashboardPage();

    public class AddingMoneyToCard {
        private SelenideElement amountCard = $("[data-test-id=amount]");
        private SelenideElement fromCard = $("[data-test-id=from]");
        private SelenideElement buttonActionTransfer = $("[data-test-id=action-transfer]");
    }

    public void AddMoneyCard(int id, int amountToTransfer) {
        AddingMoneyToCard addingMoneyToCard = new AddingMoneyToCard();
        addingMoneyToCard.amountCard.setValue(String.valueOf(amountToTransfer));
        addingMoneyToCard.fromCard.setValue(String.valueOf(numberCard.getCardBalance(id)));
        addingMoneyToCard.buttonActionTransfer.click();
    }
}