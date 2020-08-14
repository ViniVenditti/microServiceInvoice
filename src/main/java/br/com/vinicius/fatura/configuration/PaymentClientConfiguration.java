package br.com.vinicius.fatura.configuration;

import br.com.vinicius.fatura.decoder.PaymentClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PaymentClientConfiguration {

    @Bean
    public ErrorDecoder getPaymentDecoder() { return new PaymentClientDecoder(); }
}
