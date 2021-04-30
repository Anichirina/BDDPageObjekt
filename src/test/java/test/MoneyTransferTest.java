package test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPageV2;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        val loginPage = new LoginPageV2();
        //    val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val firstCardBalanceBefore = dashboardPage.getFirstCardBalance();
        val secondCardBalanceBefore = dashboardPage.getLastCardBalance();
        val randomCash = DataHelper.generateRandomCash();
        val transferPage = DashboardPage.clickToReplenishFirstCard();
        val transferInfo = DataHelper.getCardsNumbers();
        transferPage.validTransferToFirst(transferInfo, randomCash);
        val firstCardBalanceAfter = DataHelper.getBalanceAfterReplenishment(firstCardBalanceBefore, randomCash);
        val secondCardBalanceAfter = DataHelper.getBalanceAfterWritingOff(secondCardBalanceBefore, randomCash);
        val firstCardCurrentBalance = dashboardPage.getFirstCardBalance();
        val secondCardCurrentBalance = dashboardPage.getLastCardBalance();
        assertEquals(firstCardBalanceAfter, firstCardCurrentBalance);
        assertEquals(secondCardBalanceAfter, secondCardCurrentBalance);
    }
    @Test
    void validTransferFromFirstToSecond() {
        val loginPage = new LoginPageV2();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val firstCardBalanceBefore = dashboardPage.getFirstCardBalance();
        val secondCardBalanceBefore = dashboardPage.getLastCardBalance();
        val randomCash = DataHelper.generateRandomCash();
        val transferPage = DashboardPage.clickToReplenishSecondCard();
        val transferInfo = DataHelper.getCardsNumbers();
        transferPage.validTransferToSecond(transferInfo, randomCash);
        val firstCardBalanceAfter = DataHelper.getBalanceAfterWritingOff(firstCardBalanceBefore, randomCash);
        val secondCardBalanceAfter = DataHelper.getBalanceAfterReplenishment(secondCardBalanceBefore, randomCash);
        val firstCardCurrentBalance = dashboardPage.getFirstCardBalance();
        val secondCardCurrentBalance = dashboardPage.getLastCardBalance();
        assertEquals(firstCardBalanceAfter, firstCardCurrentBalance);
        assertEquals(secondCardBalanceAfter, secondCardCurrentBalance);
    }

    @Test
    void shouldBeErrorWhenTransferMoreThanBalance() {
        val loginPage = new LoginPageV2();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val randomCash = DataHelper.generateInvalidCash();
        val transferPage = DashboardPage.clickToReplenishFirstCard();
        val transferInfo = DataHelper.getCardsNumbers();
        transferPage.validTransferToFirst(transferInfo, randomCash);
        transferPage.notEnoughBalance();
    }






}
