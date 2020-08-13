package br.com.vinicius.fatura.model;

public class InvoicePaidModel {

    private double amountPaid;

    private String paidIn;

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaidIn() {
        return paidIn;
    }

    public void setPaidIn(String paidIn) {
        this.paidIn = paidIn;
    }
}
