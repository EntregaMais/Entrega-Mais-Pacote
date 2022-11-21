package com.entrega.mais.produto.controller;

import com.entrega.mais.produto.model.Pacote;
import com.entrega.mais.produto.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/pacote")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @RequestMapping(value = "/pacotePorId/{id", method = RequestMethod.GET)
    public ResponseEntity<Pacote> GetById (@PathVariable(value = "id") Long id){
        Optional<Pacote> pacote = pacoteService.encontraPacotePorId(id);
        if(pacote.isPresent())
            return new ResponseEntity<Pacote>(pacote.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Pacote> salvar (@RequestBody Pacote pacote){
        return ResponseEntity.ok(pacoteService.salvarPacote(pacote));
    }

    @PostMapping("/pacoteEdicao/{id}/")
    public ResponseEntity<Pacote> editar (@PathVariable(value = "id") Long id, @RequestBody Pacote pacote){

        Pacote pacoteAtualizada = pacoteService.atualizarPacote(id,pacote);

        if(pacote != null) {
            return new ResponseEntity<Pacote>(pacoteAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ok")
    public ResponseEntity<String> testandoAPi() {
        return ResponseEntity.ok("ok");
    }




}