package com.projeto.syncestoque.domain;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;



//@EqualsAndHashCode(of= "idVenda")
@Entity
@Table(name = "venda_e")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;
    private BigDecimal valorTotal;
    private LocalDateTime dataVenda;

    public Venda() {
    }

    public Venda(Long idVenda, BigDecimal valorTotal, LocalDateTime dataVenda) {
        this.idVenda = idVenda;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }
}
