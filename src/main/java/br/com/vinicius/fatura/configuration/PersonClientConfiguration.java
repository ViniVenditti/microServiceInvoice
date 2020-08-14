package br.com.vinicius.fatura.configuration;

import br.com.vinicius.fatura.decoder.PersonClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PersonClientConfiguration {

    @Bean
    public ErrorDecoder getPersonClientDecoder() {
        return new PersonClientDecoder();
    }
}
