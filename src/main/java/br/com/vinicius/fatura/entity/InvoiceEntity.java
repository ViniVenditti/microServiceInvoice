package br.com.vinicius.fatura.entity;

import javax.persistence.*;

@Entity
@Table(name = "TABELA_FATURA")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amountPaid;

    private String paidIn;

    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

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
