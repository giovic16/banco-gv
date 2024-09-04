package com.banco.gv.repository;

import com.banco.gv.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long> {

    ContaModel findByCliente(ContaModel cliente);
}
