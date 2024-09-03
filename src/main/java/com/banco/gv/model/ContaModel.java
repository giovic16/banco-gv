package com.banco.gv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Getter
@Setter
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;
    private int agencia;
    private int numero;
    private float saldo;
    private List<ClienteModel> cliente;
}
