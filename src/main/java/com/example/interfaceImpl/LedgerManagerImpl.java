package com.example.interfaceImpl;

import com.example.interfaces.LedgerManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.model.EMI;
import com.example.model.InterestInfo;
import com.example.model.LoanInfo;
import com.example.model.Payment;
import com.example.utils.EMIUtil;

/**
* Created by priyanka.s on 06/06/21
*/

public class LedgerManagerImpl implements LedgerManager {
    private final List<LoanInfo> loanInfoList = new ArrayList<>();
    private final Map<String, EMI> idToEMIMap = new HashMap<>();
    private final Map<Integer, List<Payment>> emiIdToPaymentsMap = new HashMap<>();
    private final List<Payment> emptyPaymentList = new ArrayList<>();

    /**
     * @param bankName
     * @param userName
     * @param principal
     * @param numOfYear
     * @param rate
     * calculate emi amount and creates emi object
     * It also stores LoanInformation in LoanInfo Object
     */
    public void createLoan(String bankName, String userName, int principal, int numOfYear, int rate) {
        InterestInfo interestInfo = new InterestInfo(principal, numOfYear, rate);
        EMI emi = EMIUtil.createEMI(interestInfo);
        idToEMIMap.put(bankName+userName, emi);

        LoanInfo loanInfo = new LoanInfo(bankName, userName, interestInfo, emi.getId());
        loanInfoList.add(loanInfo);
    }

    /**
     *
     * @param bankName
     * @param userName
     * @param amount
     * @param emiNumber
     * Insert Payment Info against emi and put it in a map for faster retrival
     */
    public void paymentLumpSum(String bankName, String userName, int amount, int emiNumber) {
        EMI emi = idToEMIMap.get(bankName + userName);
        Payment payment = new Payment(amount, emiNumber);
        emiIdToPaymentsMap.putIfAbsent(emi.getId(), new ArrayList<>());
        emiIdToPaymentsMap.get(emi.getId()).add(payment);
    }

    /**
     *
     * @param bankName
     * @param userName
     * @param emiNumber
     * It finds lumpsum amount for a given emiNumber,
     * Based on lumpsum amount and paid EMI amount, we find the total amount paid
     * We also calculate updated remainingEmi months
     */
    public void showBalance(String bankName, String userName, int emiNumber) {
        String identifier = bankName + userName;
        EMI emi = idToEMIMap.get(identifier);
        List<Payment> payments = emiIdToPaymentsMap.getOrDefault(emi.getId(), emptyPaymentList);
        int lumpsumAmount = EMIUtil.calculateLumpsumAmount(payments, emiNumber);
        int amountPaid = Math.min(emi.getMonthlyAmount()*emiNumber + lumpsumAmount, emi.getTotalPayable());
        int remainingEMIMonths = (int)Math.ceil((double)(emi.getTotalPayable()-amountPaid)/emi.getMonthlyAmount());
        System.out.println(bankName + " " + userName + " " + amountPaid + " " + remainingEMIMonths);
    }
}
