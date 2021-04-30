package ru.netology.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    public static VerificationCode getOtherVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("54321");
    }

    @Value
    public static class CardNumber {
        private String[] cardsNumbers;
    }

    public static CardNumber getCardsNumbers() {
        return new CardNumber(new String[]{"5559 0000 0000 0001", "5559 0000 0000 0002"});
    }
    public static int getBalanceAfterWritingOff(int balance, int cash) {
        int currentBalance = balance - cash;
        return currentBalance;
    }

    public static int getBalanceAfterReplenishment(int balance, int cash) {
        int currentBalance = balance + cash;
        return currentBalance;
    }
    public static int generateRandomCash() {
        Random random = new Random();
        int cash = random.nextInt(10000);
        return cash;
    }

    public static int generateInvalidCash() {
        Random random = new Random();
        int min = 11000;
        int max = 20000;
        int diff = max - min;
        int invalidCash = random.nextInt(diff);
        return invalidCash;
    }

}
