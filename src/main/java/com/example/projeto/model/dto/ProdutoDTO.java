package com.example.projeto.model.dto;


import java.util.Objects;

public class ProdutoDTO {

    private Long id;

    private String nome;

    private Integer quantitade;

    private Double valor;

    private String observacao;

    public ProdutoDTO(){};

    public ProdutoDTO(Long id, String nome, Integer quantitade, Double valor, String observacao){
        this.id = id;
        this.nome = nome;
        this.quantitade = quantitade;
        this.valor = valor;
        this.observacao = observacao;
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantitade() {
        return quantitade;
    }

    public void setQuantitade(Integer quantitade) {
        this.quantitade = quantitade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.example.projeto.model.dto.ProdutoDTO produtoDTO = (com.example.projeto.model.dto.ProdutoDTO) o;
        return Objects.equals(id, produtoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantitade=" + quantitade +
                ", valor=" + valor +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}

