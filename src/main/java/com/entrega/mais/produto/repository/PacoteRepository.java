package com.entrega.mais.produto.repository;

import com.entrega.mais.produto.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {

    Optional<Pacote> findById(Long id);
    List<Optional<Pacote>> findByCdPedido(Long cdPedido);
    List<Optional<Pacote>> findByFornecedor(String fornecedor);
    List<Optional<Pacote>> findByTamanho(String tamanho);


}