package br.com.vinicius.fatura.controller;

import br.com.vinicius.fatura.entity.InvoiceEntity;
import br.com.vinicius.fatura.exceptions.CardNotFoundException;
import br.com.vinicius.fatura.exceptions.ClientNotFoundException;
import br.com.vinicius.fatura.mapper.InvoiceMapper;
import br.com.vinicius.fatura.model.*;
import br.com.vinicius.fatura.service.InvoiceService;
import feign.FeignException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/fatura")
public class InvoiceController {

    private final PaymentClient paymentClient;
    private final PersonClient personClient;
    private final CardClient cardClient;
    private final InvoiceMapper mapper;
    private final InvoiceService service;

    public InvoiceController(PaymentClient paymentClient, PersonClient personClient, CardClient cardClient, InvoiceMapper mapper, InvoiceService service) {
        this.paymentClient = paymentClient;
        this.personClient = personClient;
        this.cardClient = cardClient;
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping(value = "/{clientId}/{cardId}")
    public List<PaymentModel> getExtract(@PathVariable Long clientId, @PathVariable Long cardId) {
        verifyCardAndClient(clientId, cardId);
        return paymentClient.getExtract(cardId);
    }

    private void verifyCardAndClient(Long clientId, Long cardId) {
        CardDTO card = cardClient.getCard(cardId);
        PersonModel clientById = personClient.getClientById(clientId);
    }

    @GetMapping(value = "/{clientId}/{cardId}/pagar")
    public InvoicePaidResponse payInvoice(@PathVariable Long clientId, @PathVariable Long cardId) {
        verifyCardAndClient(clientId, cardId);
        InvoicePaidModel invoicePaidModel = paymentClient.payInvoice(cardId);
        InvoiceEntity entity = mapper.from(invoicePaidModel);
        entity.setClientId(clientId);
        return mapper.to(service.saveInvoice(entity));
    }

    @GetMapping(value = "/pagas/{clientId}")
    public List<InvoicePaidResponse> invoicePaidTotal(@PathVariable Long clientId){
        return service.getInvoicePaids(clientId);
    }

    @GetMapping(value = "/{clientId}/{cardId}/expirar")
    public StatusResponse blockCardClient(@PathVariable Long clientId, @PathVariable Long cardId) {
        verifyCardAndClient(clientId, cardId);
        StatusResponse status = new StatusResponse();
        status.setStatus(cardClient.blockCard(cardId));
        return status;
    }



}
