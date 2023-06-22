package com.example.projeto.services;

import com.example.projeto.model.Produto;
import com.example.projeto.model.dto.ProdutoDTO;
import com.example.projeto.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoDTO> findAll(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> findById(Long id){
        Optional<Produto> produto =  produtoRepository.findById(id);
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(dto);
    }

    public ProdutoDTO save (ProdutoDTO produtoDTO){

        produtoDTO.setId(null);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDTO, Produto.class);
        produto = produtoRepository.save(produto);

        produtoDTO.setId(produto.getId());
        return produtoDTO;
    }

    public ProdutoDTO atualizar (Long id, ProdutoDTO produtoDTO){

        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDTO, Produto.class);
        produtoRepository.save(produto);
        return produtoDTO;
    }

    public void delete(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        produtoRepository.deleteById(id);
    }

    @Transactional
    public Produto salvar(Produto produto){

    }
}
