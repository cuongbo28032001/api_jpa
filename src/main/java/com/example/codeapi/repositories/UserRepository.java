package com.example.codeapi.repositories;

import com.example.codeapi.models.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Long>, JpaSpecificationExecutor<User> {
//List<User> finAll();

}
