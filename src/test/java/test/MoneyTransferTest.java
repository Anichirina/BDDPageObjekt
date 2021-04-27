package test;

import ru.netology.data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.page.LoginPageV1;
import ru.netology.page.LoginPageV2;
import ru.netology.page.LoginPageV3;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test

    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");

        val loginPage = new LoginPageV1();
//    val loginPage = open("http://localhost:9999", LoginPageV1.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        open("http://localhost:9999");
        val loginPage = new LoginPageV2();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV3() {
        val loginPage = open("http://localhost:9999", LoginPageV3.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }
}
