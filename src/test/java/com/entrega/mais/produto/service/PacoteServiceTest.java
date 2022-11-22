package com.entrega.mais.produto.service;
import com.entrega.mais.produto.model.Pacote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacoteServiceTest {

    @Test
    void encontraPacotePorId() {

    }

    @Test
    void encontraPacotePorCdPedido() {
    }

    @Test
    void encontraPacotesPorFornecedor() {
    }

    @Test
    void encontraPacotePorTamanho() {
    }

    @Test
    void salvarPacote() {
        Pacote pacote = new Pacote (Long.valueOf(1), Long.valueOf(123), "Moda Center", "88997322", "M", "Pedido de Teste");
        PacoteService pacoteService = new PacoteService();
        //Assertions.assertEquals(pacoteService.salvarPacote(pacote));

        Assertions.assertNotNull(pacote);  //Checks for null
        Assertions.assertInstanceOf(PacoteService.class, pacoteService.salvarPacote(pacote));
    }

    @Test
    void atualizarPacote() {
    }
}