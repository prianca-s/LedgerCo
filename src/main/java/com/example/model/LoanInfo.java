package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Created by priyanka.s on 06/06/21
*/

@Getter
@Setter
@NoArgsConstructor
public class LoanInfo {
    private int id;
    private String bankName;
    private String userName;
    private InterestInfo info;
    private int emiId;
    private static int idCount = 0;

    public LoanInfo(String bankName, String userName, InterestInfo info, int emiId) {
        this.id = idCount++;
        this.bankName = bankName;
        this.userName = userName;
        this.info = info;
        this.emiId = emiId;
    }
}
