package com.company;

public class Saving extends Account {
    int safetyDepositBoxID;
    int safetyDepositBoxPin;

    public Saving(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxPin = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println(
                "ACCOUNT TYPE: Saving" +
                "\nDEPOSIT BOX ID: " + safetyDepositBoxID +
                "\nDEPOSIT BOX PIN: " + safetyDepositBoxPin
        );
    }
}
