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
public class AgenciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgencia;
    private String nomeAgencia;
    private String endereco;
    private String telefone;
    private List<ClienteModel> cliente;
}
