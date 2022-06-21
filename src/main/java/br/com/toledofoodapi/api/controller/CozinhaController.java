package br.com.toledofoodapi.api.controller;

import br.com.toledofoodapi.api.model.CozinhasXmlWrapper;
import br.com.toledofoodapi.domain.excetion.EntidadeEmUsoException;
import br.com.toledofoodapi.domain.excetion.EntidadeNaoEncontradaException;
import br.com.toledofoodapi.domain.model.Cozinha;
import br.com.toledofoodapi.domain.repository.CozinhaRepository;
import br.com.toledofoodapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/cozinhas")
@ResponseBody
@RestController
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @GetMapping
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml(){
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId){
        Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
        if(cozinha != null){
            return ResponseEntity.ok(cozinha);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha salvar(@RequestBody Cozinha cozinha){
        return cadastroCozinha.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@RequestBody Cozinha cozinha, @PathVariable Long cozinhaId){
        Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
        if(cozinhaAtual != null){
            BeanUtils.copyProperties(cozinha,cozinhaAtual,"id");
            cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> deletar(@PathVariable Long cozinhaId){
        try {
            cadastroCozinha.excluir(cozinhaId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}