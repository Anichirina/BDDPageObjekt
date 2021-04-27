package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    DashboardPage numberCard = new DashboardPage();

    @Name("Страница перевода")
    public class TransferPageCardFirst {
    private SelenideElement actionDeposit = $("[data-test-id = action-deposit]");
    private SelenideElement actionReloadButton = $("[data-test-id = action-reload]");

}
    public void TransferPageFirst(TransferPage.TransferPageCardFirst translastion){
        TransferPageCardFirst.act.setValue();
    }
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