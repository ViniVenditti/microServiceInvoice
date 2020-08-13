package br.com.vinicius.fatura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoicePaidResponse {
    private Long id;

    @JsonProperty("valorPago")
    private double amountPaid;

    @JsonProperty("pagoEm")
    private String paidIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
