package pt.ipca.projectoaddjn.BaseDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Versão da Base de Dados
    private static final int DATABASE_VERSION = 3;

    // Nome da Base de dados
    private static final String DATABASE_NAME = "projectoADDJN.db";

    // Tabela para o plantel
    public static final String COLUMN_PLANTEL_CODJOGADOR = "codJogador";
    public static final String COLUMN_PLANTEL_X = "x";
    public static final String COLUMN_PLANTEL_Y = "y";
    public static final String[] COLUMNS_PLANTEL = {COLUMN_PLANTEL_CODJOGADOR, COLUMN_PLANTEL_X, COLUMN_PLANTEL_Y};

    // Tabela para o jogador
    public static final String COLUMN_JOGADOR_IDJOGADOR = "IdJogador";
    public static final String COLUMN_JOGADOR_IDEQUIPA = "IdEquipa";
    public static final String COLUMN_JOGADOR_NOME = "Nome";
    public static final String COLUMN_JOGADOR_APLIDO = "Aplido";
    public static final String COLUMN_JOGADOR_DATANASCIMENTO ="DataNascimento";
    public static final String COLUMN_JOGADOR_POSICAO = "Posicao";
    public static final String COLUMN_JOGADOR_PESO = "Peso";
    public static final String COLUMN_JOGADOR_ALTURA = "Altura";
    public static final String COLUMN_JOGADOR_PEPREFERENCIAL = "PePreferencial";
    public static final String[] COLUMNS_JOGADOR = {COLUMN_JOGADOR_IDJOGADOR, COLUMN_JOGADOR_IDEQUIPA, COLUMN_JOGADOR_NOME, COLUMN_JOGADOR_APLIDO, COLUMN_JOGADOR_DATANASCIMENTO, COLUMN_JOGADOR_POSICAO, COLUMN_JOGADOR_PESO, COLUMN_JOGADOR_ALTURA, COLUMN_JOGADOR_PEPREFERENCIAL};

    // Construtor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Criar a Tabela para o plantel
        String jogadorPlantel = "CREATE TABLE FormacaoPlantel"
                + "(codJogador integer primary key,"
                + " x real,"
                + " y real)";
        sqLiteDatabase.execSQL(jogadorPlantel);

        // Criar a Tabela para o Jogador
        String Jogador = "CREATE TABLE Jogador"
                + "(IdJogador integer primary key,"
                + "IdEquipa int,"
                + "Nome String,"
                + "Aplido String,"
                + "DataNascimento String,"
                + "Posicao String,"
                + "Peso real,"
                + "Altura real,"
                + "PePreferencial String,"
                + "Clube String,"
                + "LogoClube int)";
        sqLiteDatabase.execSQL(Jogador);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void erase(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }
}