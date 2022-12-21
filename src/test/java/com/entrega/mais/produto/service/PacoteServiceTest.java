package com.entrega.mais.produto.service;
import com.entrega.mais.produto.model.Pacote;
import com.entrega.mais.produto.repository.PacoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacoteServiceTest {

     @Autowired
     PacoteService service;
//     Pacote pacote = new Pacote (Long.valueOf(1), Long.valueOf(123), "Moda Center", "88997322", "M", "Pedido de Teste");

     @MockBean
     private PacoteRepository repository;

    @Test
    public void testEncontrarPacotePorId() {
        // Cria um pacote para simular o retorno do repository
        Pacote pacote = new Pacote();
        pacote.setId(1L);
        pacote.setFornecedor("Fornecedor 1");
        pacote.setTelefoneFornecedor("999999999");
        pacote.setTamanho("Pequeno");
        pacote.setObservacao("Observação");

        // Configura o mock do repository para retornar o pacote acima
        when(repository.findById(1L)).thenReturn(Optional.of(pacote));

        // Executa o método encontrarPacotePorId do serviço com o ID 1
        Optional<Pacote> pacoteEncontrado = service.encontraPacotePorId(1L);

        // Verifica se o pacote retornado é o mesmo que foi passado
        Assertions.assertTrue(pacoteEncontrado.isPresent());
        Assertions.assertEquals(pacote, pacoteEncontrado.get());
    }

    @Test
    public void testEncontrarPacotePorCdPedido() {
        // Cria um pacote para simular o retorno do repository
        Pacote pacote = new Pacote();
        pacote.setId(1L);
        pacote.setCdPedido(123456L);
        pacote.setFornecedor("Fornecedor Teste");
        pacote.setTelefoneFornecedor("(11) 99999-9999");
        pacote.setTamanho("M");
        pacote.setObservacao("Observação teste");
        // Configura o mock do repository para retornar o pacote acima
        when(repository.findByCdPedido(123L)).thenReturn(List.of(Optional.of(pacote)));


        // Executa o método findByCdPedido do serviço com o código de pedido 123456
        Optional<Pacote> pacoteEncontrado = service.encontraPacotePorCdPedido(123456L);

        // Verifica se o pacote encontrado é o esperado
        assertEquals(1L, pacoteEncontrado.get().getId());
        assertEquals(123456L, pacoteEncontrado.get().getCdPedido());
        assertEquals("Fornecedor Teste", pacoteEncontrado.get().getFornecedor());
        assertEquals("(11) 99999-9999", pacoteEncontrado.get().getTelefoneFornecedor());
        assertEquals("M", pacoteEncontrado.get().getTamanho());
        assertEquals("Observação teste", pacoteEncontrado.get().getObservacao());
    }

//    @Test
//    void salvarPacote() {
//         Assertions.assertNotNull(pacote);
//         Assertions.assertInstanceOf(Pacote.class, service.salvarPacote(pacote));
//    }

}