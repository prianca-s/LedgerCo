package com.example.Main;

import com.example.enums.CommandEnum;
import com.example.interfaceImpl.LedgerManagerImpl;
import com.example.interfaces.LedgerManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* Created by priyanka.s on 06/06/21
*/

@Slf4j
@NoArgsConstructor
public class Geektrust {
    public static void main(String[] args) throws FileNotFoundException {
        LedgerManager ledgerManager = new LedgerManagerImpl();
        String inputPath = args[0];
        System.out.println(inputPath);

        File file = new File(inputPath);

//        File file = new File("src/main/resources/input.txt");

        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()) {
            String input = scan.nextLine();
            String[] inputList = input.split(" ");
            CommandEnum commandEnum = CommandEnum.valueOf(inputList[0]);
            String bankName = inputList[1];
            String borrowerName = inputList[2];
            switch (commandEnum) {
                case LOAN:
                    ledgerManager.createLoan(bankName, borrowerName, Integer.parseInt(inputList[3]), Integer.parseInt(inputList[4]), Integer.parseInt(inputList[5]));
                    break;
                case BALANCE:
                    ledgerManager.showBalance(bankName, borrowerName, Integer.parseInt(inputList[3]));
                    break;
                case PAYMENT:
                    ledgerManager.paymentLumpSum(bankName, borrowerName, Integer.parseInt(inputList[3]), Integer.parseInt(inputList[4]));
                    break;
            }
        }
    }
}
