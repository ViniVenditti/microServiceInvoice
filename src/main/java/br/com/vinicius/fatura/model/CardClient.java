package br.com.vinicius.fatura.model;

import br.com.vinicius.fatura.configuration.CardClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CARD", configuration = CardClientConfiguration.class)
public interface CardClient {

    @GetMapping(value = "/cartao/{cardId}")
    CardDTO getCard(@PathVariable Long cardId);

    @GetMapping(value = "/cartao/blockCard/{cardId}")
    String blockCard(@PathVariable Long cardId);

}
