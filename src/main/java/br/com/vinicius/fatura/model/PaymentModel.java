package br.com.vinicius.fatura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentModel {

    private Long id;

    @JsonProperty("cartao_id")
    private Long cardId;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("valor")
    private double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
