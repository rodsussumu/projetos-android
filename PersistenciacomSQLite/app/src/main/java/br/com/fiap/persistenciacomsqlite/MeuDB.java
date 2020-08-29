package br.com.fiap.persistenciacomsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MeuDB extends SQLiteOpenHelper {

    private static final String NOME_DO_BANCO = "MeuDB";
    private static final int VERSAO = 1;
    private static final String TB_CONTATO = "Contato";

    public MeuDB(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TB_CONTATO + " (" +
                " id INTEGER NOT NULL," +
                " nome TEXT," +
                " email TEXT," +
                " telefone TEXT," +
                "PRIMARY KEY(id AUTOINCREMENT)" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void inserir(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", contato.getNome());
        cv.put("email", contato.getEmail());
        cv.put("telefone", contato.getTelefone());

        db.insert(TB_CONTATO, null, cv);
    }

    public void atualizar (Contato contato) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", contato.getNome());
        cv.put("email", contato.getEmail());
        cv.put("telefone", contato.getTelefone());
        db.update(TB_CONTATO, cv, "id = ?", new String[]{String.valueOf(contato.getId())});
    }

    public void excluir(int id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(TB_CONTATO, "id = ?", new String[]{String.valueOf(id)});
    }

    public List<Contato> todos() {
        List<Contato> contatos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                TB_CONTATO,
                new String[]{"id", "nome", "email", "telefone"},
                null,
                null,
                null,
                null,
                "nome"
                );

        cursor.moveToFirst();
        if(cursor.moveToFirst()) {
            do{
                Contato contato = new Contato();
                contato.setId(cursor.getInt(0));
                contato.setNome(cursor.getString(1));
                contato.setEmail(cursor.getString(2));
                contato.setTelefone(cursor.getString(3));
                contatos.add(contato);
            }while(cursor.moveToNext());
        }
        cursor.close();

        return contatos;
    }

    public List<Contato> porNome(String nome) {
        List<Contato> contatos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TB_CONTATO,
                new String[]{"id", "nome", "email", "telefone"},
                "nome = ?",
                new String[]{nome},
                null,
                null,
                null
        );

        cursor.moveToFirst();
        if(cursor.moveToFirst()) {
            do{
                Contato contato = new Contato();
                contato.setId(cursor.getInt(0));
                contato.setNome(cursor.getString(1));
                contato.setEmail(cursor.getString(2));
                contato.setTelefone(cursor.getString(3));
                contatos.add(contato);
            }while(cursor.moveToNext());
        }
        cursor.close();

        return contatos;
    }

}
