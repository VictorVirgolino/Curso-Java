package com.accenture.consumo.service;

import com.accenture.consumo.model.Endereco;
import com.accenture.consumo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }


    public List<Endereco> obterTodosEnderecos() {
        return enderecoRepository.findAll();
    }


    public Optional<Endereco> obterEnderecoPorId(Long id) {
        return enderecoRepository.findById(id);
    }


    public Endereco atualizarEndereco(Long id, Endereco enderecoAtualizado) {
        Optional<Endereco> enderecoExistenteOpt = enderecoRepository.findById(id);
        if (enderecoExistenteOpt.isPresent()) {
            Endereco enderecoExistente = enderecoExistenteOpt.get();
            enderecoExistente.setCep(enderecoAtualizado.getCep());
            enderecoExistente.setLogradouro(enderecoAtualizado.getLogradouro());
            enderecoExistente.setComplemento(enderecoAtualizado.getComplemento());
            enderecoExistente.setBairro(enderecoAtualizado.getBairro());
            enderecoExistente.setLocalidade(enderecoAtualizado.getLocalidade());
            enderecoExistente.setUf(enderecoAtualizado.getUf());
            enderecoExistente.setIbge(enderecoAtualizado.getIbge());
            enderecoExistente.setGia(enderecoAtualizado.getGia());
            enderecoExistente.setDdd(enderecoAtualizado.getDdd());
            enderecoExistente.setSiafi(enderecoAtualizado.getSiafi());
            return enderecoRepository.save(enderecoExistente);
        } else {
            throw new RuntimeException("Endereço não encontrado com o ID: " + id);
        }
    }


    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}

