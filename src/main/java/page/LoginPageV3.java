package page;

import data.DataHelper;

public class LoginPageV3 {
    private SelenideElement loginField;
    private SelenideElement passwordField;
    private SelenideElement loginButton;

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return page(VerificationPage.class);
    }
}
