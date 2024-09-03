package com.banco.gv.repository;

import com.banco.gv.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Long, ClienteModel> {
}
