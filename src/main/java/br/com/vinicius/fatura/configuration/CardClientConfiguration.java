package br.com.vinicius.fatura.configuration;

import br.com.vinicius.fatura.decoder.CardClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {

    @Bean
    public ErrorDecoder getCardClientDecoder(){
        return new CardClientDecoder();
    }

}
