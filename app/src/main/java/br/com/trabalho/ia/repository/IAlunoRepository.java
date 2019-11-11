package br.com.trabalho.ia.repository;

import java.util.List;

import br.com.trabalho.ia.domain.Aluno;

public interface IAlunoRepository {

    void insert(Aluno aluno);

    void update(Aluno aluno);

    void delete(Aluno aluno);

    List<Aluno> listAll();
}
