package com.accenture.consumo.controller;

import com.accenture.consumo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.model.Endereco;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping()
public class CepRestController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping("/listar")
    public ModelAndView listar() {
        List<Endereco> enderecos = enderecoService.obterTodosEnderecos();

        ModelAndView modelAndView = new ModelAndView("enderecos");
        modelAndView.addObject("enderecos", enderecos);

        return modelAndView;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {

        Endereco endereco = cepService.buscaEnderecoPorCep(cep);

        enderecoService.criarEndereco(endereco);

        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }





}
