package br.com.trabalho.ia.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.trabalho.ia.domain.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class SistemaTutorDatabase extends RoomDatabase {

    private static SistemaTutorDatabase instance;

    public abstract IManagerAlunoDao dao();

    public static synchronized SistemaTutorDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SistemaTutorDatabase.class, "sistema_tutor_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
