package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    DashboardPage numberCard = new DashboardPage();


    @Name("Страница перевода")
    public class TransferPageCard {
        private ElementsCollection actionDeposit = $$("[data-test-id = action-deposit]");
        private SelenideElement actionReloadButton = $("[data-test-id = action-reload]");
        private ElementsCollection balansCard = $$("[data-test-id]");


        public void TransferPageFirst(TransferPage.TransferPageCard translastion) {
            TransferPageCard transferPageCard = new TransferPageCard();
            transferPageCard.actionDeposit.get(1).click();
            return;
        }
        public void TransferPageLast(TransferPage.TransferPageCard translastion) {
            TransferPageCard transferPageCard = new TransferPageCard();
            transferPageCard.actionDeposit.get(2).click();
            return;
        }


    }
    public class AddingMoneyToCard {
        private SelenideElement amountCard = $("[data-test-id=amount]");
        private SelenideElement fromCard = $("[data-test-id=from]");
        private SelenideElement buttonActionTransfer = $("[data-test-id=action-transfer]");
    }

    public void AddMoneyCard(int id, int amountToTransfer) {
        AddingMoneyToCard addingMoneyToCard = new AddingMoneyToCard();
        addingMoneyToCard.amountCard.setValue(String.valueOf(amountToTransfer));
        addingMoneyToCard.fromCard.setValue(String.valueOf(DataHelper.CardNumber.class));
        addingMoneyToCard.buttonActionTransfer.click();
    }
}