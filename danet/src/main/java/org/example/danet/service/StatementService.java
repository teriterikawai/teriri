package org.example.danet.service;

import lombok.RequiredArgsConstructor;
import org.example.danet.model.Statement;
import org.example.danet.model.Status;
import org.example.danet.model.User;
import org.example.danet.repo.StatementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementService {

    private final StatementRepository statementRepository;

    public List<Statement> getAll() {
        return statementRepository.findAll();
    }

    public List<Statement> getAllByAuthorId(Long id) {
        return statementRepository.findAllByAuthorId(id);
    }

    public void save(Statement statement, User user) {
        statement.setStatus(Status.NEW);
        statement.setAuthor(user);
        statementRepository.save(statement);
    }

    public void reject(Long id) {
        Statement statement = statementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заявление не найдено"));
        statement.setStatus(Status.REJECTED);
        statementRepository.save(statement);
    }

    public void confirm(Long id) {
        Statement statement = statementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заявление не найдено"));
        statement.setStatus(Status.CONFIRMED);
        statementRepository.save(statement);
    }

}
