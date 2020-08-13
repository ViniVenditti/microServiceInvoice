package br.com.vinicius.fatura.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLIENT")
public interface PersonClient {

    @GetMapping("/cliente/{clienteId}")
    PersonModel getClientById(@PathVariable Long clienteId);

}
