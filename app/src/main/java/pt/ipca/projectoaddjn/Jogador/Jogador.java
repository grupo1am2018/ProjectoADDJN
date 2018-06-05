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

    public void setIdJogador(int IdJogador) {
        this.jId = IdJogador;
    }

    public void setIdEquipa(int IdEquipa) {
        this.jIdEquipa = IdEquipa;
    }

    public void setNome(String Nome) {
        this.jNome = Nome;
    }

    public void setApelido(String Apelido) {
        this.jApelido = Apelido;
    }

    public void setDataNascimento(String DataNascimento) {
        this.jDataNascimento = DataNascimento;
    }

    public void setPosicao(String Posicao) {
        this.jPosicao = Posicao;
    }

    public void setPeso(float Peso) {
        this.jPeso = Peso;
    }

    public void setAltura(float Altura) {
        this.jaltura = Altura;
    }

    public void setPePreferencial(String PePreferencial) {
        this.jPePreferencial = PePreferencial;
    }

    public void setClube(String Clube) {
        this.jClube = Clube;
    }

    public void setLogoClube(int LogoClube) {
        this.jLogoClube = LogoClube;
    }

    public void setFoto(int Foto) {
        this.jFoto = Foto;
    }

    public void setNumero(int numero) {
        this.jNumero = numero;
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

        long result = database.insert("Jogador", null, jogador);

        Cursor cursor = database.query("Jogador", DatabaseHelper.COLUMNS_JOGADOR, "IdJogador" + " = " + result, null, null, null, null);
        cursor.moveToFirst();
        Jogador jogadorNovo = novoJogador(cursor);
        cursor.close();
        database.close();
        return jogadorNovo;
    }

    public static Jogador novoJogador(Cursor cursor) {
        Jogador jogador = new Jogador();
        jogador.setIdJogador(cursor.getInt(0));
        jogador.setIdEquipa(cursor.getInt(1));
        jogador.setNome(cursor.getString(2));
        jogador.setApelido(cursor.getString(3));
        jogador.setDataNascimento(cursor.getString(4));
        jogador.setPosicao(cursor.getString(5));
        jogador.setPeso(cursor.getFloat(6));
        jogador.setAltura(cursor.getFloat(7));
        jogador.setPePreferencial(cursor.getString(8));
        jogador.setClube(cursor.getString(9));
        jogador.setLogoClube(cursor.getInt(10));
        jogador.setFoto(cursor.getInt(11));
        jogador.setNumero(cursor.getInt(12));
        return jogador;
    }

    public static ArrayList<Jogador> getJogadores(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Jogador> aJogador = new ArrayList<>();
        Cursor res = db.rawQuery("select * from Jogador", null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            aJogador.add(new Jogador(res.getInt(0), res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getFloat(6), res.getFloat(7), res.getString(8), res.getString(9), res.getInt(10),
                    res.getInt(11), res.getInt(12)));
            res.moveToNext();
        }
        res.close();
        db.close();
        return aJogador;
    }
}
