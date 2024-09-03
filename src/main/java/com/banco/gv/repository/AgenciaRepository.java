package com.banco.gv.repository;

import com.banco.gv.model.AgenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Long, AgenciaModel> {
}
