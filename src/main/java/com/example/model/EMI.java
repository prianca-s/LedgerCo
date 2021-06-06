package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Created by priyanka.s on 06/06/21
*/

@Getter
@Setter
@NoArgsConstructor
public class EMI {
    int id;
    int monthlyAmount;
    int totalPayable;
    private static int idCounter = 0;

    public EMI(int amount, int totalPayable) {
        this.id = idCounter++;
        this.monthlyAmount = amount;
        this.totalPayable = totalPayable;
    }
}
