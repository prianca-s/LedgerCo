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
@AllArgsConstructor
@NoArgsConstructor
public class InterestInfo {
    private int principal;
    private int year;
    private double rate;
}
