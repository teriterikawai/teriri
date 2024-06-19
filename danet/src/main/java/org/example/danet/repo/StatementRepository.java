package org.example.danet.repo;

import org.example.danet.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Long> {

    List<Statement> findAllByAuthorId(Long id);

}
