package br.com.vinicius.fatura.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "PAYMENT")
public interface PaymentClient {

    @GetMapping("/pagamento/{idCard}")
    List<PaymentModel> getExtract(@PathVariable Long idCard);

    @GetMapping("/pagamento/pagar/{cardId}")
    InvoicePaidModel payInvoice(@PathVariable Long cardId);

}
