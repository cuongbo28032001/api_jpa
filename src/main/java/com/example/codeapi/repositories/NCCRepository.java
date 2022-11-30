package com.example.codeapi.repositories;


import com.example.codeapi.models.DMNCC;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NCCRepository extends CrudRepository<DMNCC, Long>, JpaSpecificationExecutor<DMNCC> {
}
