package pt.ipca.projectoaddjn.Jogador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import pt.ipca.projectoaddjn.BaseDados.DatabaseHelper;

public class Jogador {

    public int jId;
    public int jIdEquipa;
    public String jNome;
    public String jApelido;
    public String jDataNascimento;
    public String jPosicao;
    public float jPeso;
    public float jaltura;
    public String jPePreferencial;
    public String jClube;
    public int jLogoClube;
    public int jFoto;
    public int jNumero;

    public Jogador() {
        
    }

    public Jogador(int id, int IdEquipa, String nome, String apelido, String dataNascimento, String posicao,
                   float peso, float altura, String pePreferencial, String clube, int logoClube, int foto, int numero) {
        this.jId = id;
        this.jIdEquipa = IdEquipa;
        this.jNome = nome;
        this.jApelido = apelido;
        this.jDataNascimento = dataNascimento;
        this.jPosicao = posicao;
        this.jPeso = peso;
        this.jaltura = altura;
        this.jPePreferencial = pePreferencial;
        this.jClube = clube;
        this.jLogoClube = logoClube;
        this.jFoto = foto;
        this.jNumero = numero;
    }

    public int getjId() {
        return jId;
    }

    public void setjId(int jId) {
        this.jId = jId;
    }

    public int getjIdEquipa() {
        return jIdEquipa;
    }

    public void setjIdEquipa(int jIdEquipa) {
        this.jIdEquipa = jIdEquipa;
    }

    public String getjNome() {
        return jNome;
    }

    public void setjNome(String jNome) {
        this.jNome = jNome;
    }

    public String getjApelido() {
        return jApelido;
    }

    public void setjApelido(String jApelido) {
        this.jApelido = jApelido;
    }

    public String getjDataNascimento() {
        return jDataNascimento;
    }

    public void setjDataNascimento(String jDataNascimento) {
        this.jDataNascimento = jDataNascimento;
    }

    public String getjPosicao() {
        return jPosicao;
    }

    public void setjPosicao(String jPosicao) {
        this.jPosicao = jPosicao;
    }

    public float getjPeso() {
        return jPeso;
    }

    public void setjPeso(float jPeso) {
        this.jPeso = jPeso;
    }

    public float getJaltura() {
        return jaltura;
    }

    public void setJaltura(float jaltura) {
        this.jaltura = jaltura;
    }

    public String getjPePreferencial() {
        return jPePreferencial;
    }

    public void setjPePreferencial(String jPePreferencial) {
        this.jPePreferencial = jPePreferencial;
    }

    public String getjClube() {
        return jClube;
    }

    public void setjClube(String jClube) {
        this.jClube = jClube;
    }

    public int getjLogoClube() {
        return jLogoClube;
    }

    public void setjLogoClube(int jLogoClube) {
        this.jLogoClube = jLogoClube;
    }

    public int getjFoto() {
        return jFoto;
    }

    public void setjFoto(int jFoto) {
        this.jFoto = jFoto;
    }

    public int getjNumero() {
        return jNumero;
    }

    public void setjNumero(int jNumero) {
        this.jNumero = jNumero;
    }

    // Inserir Jogador
    public static Jogador inserirJogador(int IdEquipa, String Nome, String Apelido,
                                         String DataNascimento, String Posicao, float Peso, float Altura,
                                         String PePreferencial, String Clube, int LogoClube, int FotoJogador, int Numero, Context context) {
        DatabaseHelper dpHelper = new DatabaseHelper(context);
        SQLiteDatabase database = dpHelper.getWritableDatabase();
        ContentValues jogador = new ContentValues();

        jogador.put(DatabaseHelper.COLUMN_JOGADOR_IDEQUIPA, IdEquipa);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_NOME, Nome);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_APELIDO, Apelido);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_DATANASCIMENTO, DataNascimento);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_POSICAO, Posicao);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_PESO, Peso);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_ALTURA, Altura);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_PEPREFERENCIAL, PePreferencial);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_CLUBE, Clube);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_LOGOCLUBE, LogoClube);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_FOTOJOGADOR, FotoJogador);
        jogador.put(DatabaseHelper.COLUMN_JOGADOR_NUMERO, Numero);

        long result = database.insert(DatabaseHelper.TABLE_JOGADOR, null, jogador);

        Cursor cursor = database.query(DatabaseHelper.TABLE_JOGADOR, DatabaseHelper.COLUMNS_JOGADOR, null, null, null, null, DatabaseHelper.COLUMN_JOGADOR_NUMERO);
        cursor.moveToFirst();
        Jogador jogadorNovo = novoJogador(cursor);
        cursor.close();
        database.close();
        return jogadorNovo;
    }

    public static Jogador novoJogador(Cursor cursor) {
        Jogador jogador = new Jogador();
        jogador.setjId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_IDJOGADOR)));
        jogador.setjIdEquipa(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_IDEQUIPA)));
        jogador.setjNome(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_NOME)));
        jogador.setjApelido(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_APELIDO)));
        jogador.setjDataNascimento(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_DATANASCIMENTO)));
        jogador.setjPosicao(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_POSICAO)));
        jogador.setjPeso(cursor.getFloat(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_PESO)));
        jogador.setJaltura(cursor.getFloat(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_ALTURA)));
        jogador.setjPePreferencial(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_PEPREFERENCIAL)));
        jogador.setjClube(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_CLUBE)));
        jogador.setjLogoClube(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_LOGOCLUBE)));
        jogador.setjFoto(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_FOTOJOGADOR)));
        jogador.setjNumero(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_NUMERO)));
        return jogador;
    }

    public static ArrayList<Jogador> getJogadores(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Jogador> aJogador = new ArrayList<>();
        Cursor res = db.rawQuery("select * from Jogador", null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            aJogador.add(new Jogador(
                    res.getInt(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_IDJOGADOR)),
                    res.getInt(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_IDEQUIPA)),
                    res.getString(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_NOME)),
                    res.getString(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_APELIDO)),
                    res.getString(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_DATANASCIMENTO)),
                    res.getString(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_POSICAO)),
                    res.getFloat(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_PESO)),
                    res.getFloat(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_ALTURA)),
                    res.getString(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_PEPREFERENCIAL)),
                    res.getString(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_CLUBE)),
                    res.getInt(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_LOGOCLUBE)),
                    res.getInt(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_FOTOJOGADOR)),
                    res.getInt(res.getColumnIndexOrThrow(DatabaseHelper.COLUMN_JOGADOR_NUMERO))));
            res.moveToNext();
        }
        res.close();
        db.close();
        return aJogador;
    }
}
