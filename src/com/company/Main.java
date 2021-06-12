package com.company;

import utilities.CSV;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

		List<Account> accounts = new LinkedList<>();
		String file = System.getProperty("user.dir") + "\\src\\utilities\\NewBank.csv";

		List<String[]> newAccountHolder = CSV.read(file);

		for (String[] accountHolder: newAccountHolder) {
			System.out.println("NEW ACCOUNT");
			String name = accountHolder[0];
			String sSn = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			System.out.println(name + " " + sSn + " " + accountType + " " + "$" + initDeposit);

			if (accountType.equals("Savings")) {
				accounts.add(new Saving(name, sSn, initDeposit));
			} else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSn, initDeposit));
			} else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}

		}
		for (Account acc: accounts) {
			System.out.println("********************");
			acc.showInfo();
		}

    }
}
