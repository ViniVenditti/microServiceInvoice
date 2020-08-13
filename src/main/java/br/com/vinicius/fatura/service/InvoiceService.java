package br.com.vinicius.fatura.service;

import br.com.vinicius.fatura.entity.InvoiceEntity;
import br.com.vinicius.fatura.mapper.InvoiceMapper;
import br.com.vinicius.fatura.model.InvoicePaidResponse;
import br.com.vinicius.fatura.repository.InvoiceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRespository invoiceRespository;
    @Autowired
    private InvoiceMapper mapper;

    public InvoiceEntity saveInvoice(InvoiceEntity entity) {
        return invoiceRespository.save(entity);
    }

    public List<InvoicePaidResponse> getInvoicePaids(Long clientId){
        List<InvoiceEntity> allByClientId = invoiceRespository.findAllByClientId(clientId);
        return allByClientId
                .stream()
                .map(entity -> mapper.to(entity))
                .collect(Collectors.toList());
    }
}