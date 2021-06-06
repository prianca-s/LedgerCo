package com.example.utils;

import com.example.model.EMI;
import com.example.model.InterestInfo;
import com.example.model.Payment;
import java.util.List;

/**
* Created by priyanka.s on 06/06/21
*/

public class EMIUtil {
    public static EMI createEMI(InterestInfo interestInfo) {
        double interest = (interestInfo.getPrincipal()*interestInfo.getYear()*interestInfo.getRate())/100;
        double amountToRepay = interestInfo.getPrincipal()+interest;
        double emiAmount = (amountToRepay)/(interestInfo.getYear()* Constants.NUM_MONTHS_IN_YEAR);
        int finalEmiAmount = (int)Math.ceil(emiAmount);
        return new EMI(finalEmiAmount, (int) amountToRepay);
    }

    public static int calculateLumpsumAmount(List<Payment> payments, int emiNumber) {
        return payments.stream().filter(p -> emiNumber >= p.getEmiNumber()).mapToInt(Payment :: getAmount).sum();
    }
}
