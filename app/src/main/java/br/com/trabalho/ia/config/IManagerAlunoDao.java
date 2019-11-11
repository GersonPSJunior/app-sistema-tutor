package br.com.trabalho.ia.config;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.trabalho.ia.domain.Aluno;

@Dao
public interface IManagerAlunoDao {

    @Insert
    void insert(Aluno aluno);

    @Update
    void update(Aluno aluno);

    @Delete
    void delete(Aluno aluno);

    @Query("SELECT * FROM aluno")
    List<Aluno> listAll();
}
