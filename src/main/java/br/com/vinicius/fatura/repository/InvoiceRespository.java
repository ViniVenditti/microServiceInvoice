package br.com.vinicius.fatura.repository;

import br.com.vinicius.fatura.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRespository extends JpaRepository<InvoiceEntity, Long> {
    List<InvoiceEntity> findAllByClientId(Long clientId);
}
