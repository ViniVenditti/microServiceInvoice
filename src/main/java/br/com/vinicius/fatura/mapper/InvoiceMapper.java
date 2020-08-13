package br.com.vinicius.fatura.mapper;

import br.com.vinicius.fatura.entity.InvoiceEntity;
import br.com.vinicius.fatura.model.InvoicePaidModel;
import br.com.vinicius.fatura.model.InvoicePaidResponse;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    private InvoiceMapper (){}

    public InvoiceEntity from(InvoicePaidModel model) {
        InvoiceEntity entity = new InvoiceEntity();
        entity.setAmountPaid(model.getAmountPaid());
        entity.setPaidIn(model.getPaidIn());
        return entity;
    }

    public InvoicePaidResponse to (InvoiceEntity entity) {
        InvoicePaidResponse response = new InvoicePaidResponse();
        response.setId(entity.getId());
        response.setAmountPaid(entity.getAmountPaid());
        response.setPaidIn(entity.getPaidIn());
        return response;
    }

}
