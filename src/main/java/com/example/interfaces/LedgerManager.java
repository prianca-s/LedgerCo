package com.example.interfaces;

/**
* Created by priyanka.s on 06/06/21
*/

public interface LedgerManager {
    void createLoan(String bankName, String userName, int principal, int numOfYear, int rate);

    void paymentLumpSum(String bankName, String userName, int amount, int emiNumber);

    void showBalance(String bankName, String userName, int emiNumber);
}
