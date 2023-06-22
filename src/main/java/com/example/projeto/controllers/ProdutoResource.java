package com.example.projeto.controllers;

import com.example.projeto.model.Produto;
import com.example.projeto.model.dto.ProdutoDTO;
import com.example.projeto.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<ProdutoDTO> produtos = produtoService.findAll();

        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<?> findById(@PathVariable Long id){
        Optional<ProdutoDTO> produtos = produtoService.findById(id);
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produto){
        produto = produtoService.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto>  updateProduto(@RequestBody Produto produto, @PathVariable Long id){
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO produtoDTO = mapper.map(produto, ProdutoDTO.class);
        produtoDTO = produtoService.atualizar(id, produtoDTO);


        return new ResponseEntity<>(
                mapper.map(produtoDTO, Produto.class),
                HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
