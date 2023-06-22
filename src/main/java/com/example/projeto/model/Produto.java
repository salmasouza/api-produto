package com.example.projeto.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_produtos")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produto_nome")
    private String nome;

    @Column(name = "produto_quantidade")
    private Integer quantitade;

    @Column(name = "produto_valor")
    private Double valor;

    @Column(name = "produto_observacao")
    private String observacao;


    public Produto(){};

    public Produto(Long id, String nome, Integer quantitade, Double valor, String observacao){
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
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
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
