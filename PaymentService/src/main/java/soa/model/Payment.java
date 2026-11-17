
package soa.model;

public class Payment {
    private String payer;
    private String receiver;
    private double amount;

    public Payment() {
    }

    public Payment(String payer, String receiver, double amount) {
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
