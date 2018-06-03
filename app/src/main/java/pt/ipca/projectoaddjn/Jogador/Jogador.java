package pt.ipca.projectoaddjn.Jogador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pt.ipca.projectoaddjn.BaseDados.DatabaseHelper;
import pt.ipca.projectoaddjn.R;

public class Jogador {

    public int jId;
    public int jIdEquipa;
    public String jNome;
    public String jAplido;
    public String jDataNascimento;
    public String jPosicao;
    public float jPeso;
    public float jaltura;
    public String jPePreferencial;
    public String jClube;
    public int jLogoClube;

    public Jogador() {

    }

    public Jogador(int id, int IdEquipa, String nome, String aplido, String dataNascimento, String posicao, float peso, float altura, String pePreferencial, String clube, int logoClube) {
        this.jId = id;
        this.jIdEquipa = IdEquipa;
        this.jNome = nome;
        this.jAplido = aplido;
        this.jDataNascimento = dataNascimento;
        this.jPosicao = posicao;
        this.jPeso = peso;
        this.jaltura = altura;
        this.jPePreferencial = pePreferencial;
        this.jClube = clube;
        this.jLogoClube = logoClube;
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

    public void setAplido(String Aplido) {
        this.jNome = Aplido;
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

    // Inserir Jogador
    public static Jogador inserirJogador(int IdJogador, int IdEquipa, String Nome, String Aplido, String DataNascimento, String Posicao, float Peso, float Altura, String PePreferencial, String Clube, int LogoClube, Context context) {
        DatabaseHelper dpHelper = new DatabaseHelper(context);
        SQLiteDatabase database = dpHelper.getWritableDatabase();
        ContentValues jogador = new ContentValues();

        jogador.put("IdJogador", 1);
        jogador.put("IdEquipa", 1);
        jogador.put("Nome", "MATIC");
        jogador.put("Aplido", "NEMANJNA");
        jogador.put("DataNascimento", "01/08/1988");
        jogador.put("Posicao", "MC/MD");
        jogador.put("Peso", 78);
        jogador.put("Altura", 1.94);
        jogador.put("PePreferencial", "Direito");
        jogador.put("Clube", "Manchester United");
        jogador.put("LogoClube", R.drawable.logo_united);

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
        jogador.setAplido(cursor.getString(3));
        jogador.setDataNascimento(cursor.getString(4));
        jogador.setPosicao(cursor.getString(5));
        jogador.setPeso(cursor.getFloat(6));
        jogador.setAltura(cursor.getFloat(7));
        jogador.setPePreferencial(cursor.getString(8));
        jogador.setClube(cursor.getString(9));
        jogador.setLogoClube(cursor.getInt(10));
        return jogador;
    }
}
