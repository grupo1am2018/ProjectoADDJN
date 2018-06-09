package pt.ipca.projectoaddjn.BaseDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Versão da Base de Dados
    private static final int DATABASE_VERSION = 1;

    // Nome da Base de dados
    private static final String DATABASE_NAME = "projectoADDJN.db";

    //Tabelas
    public static final String TABLE_JOGADOR = "Jogador";
    public static final String TABLE_FORMACAO_PLANTEL = "FormacaoPlantel";
    public static final String TABLE_JOGOS = "Jogos";

    // Tabela para o plantel
    public static final String COLUMN_PLANTEL_CODJOGADOR = "codJogador";
    public static final String COLUMN_PLANTEL_X = "x";
    public static final String COLUMN_PLANTEL_Y = "y";
    public static final String[] COLUMNS_PLANTEL = {COLUMN_PLANTEL_CODJOGADOR, COLUMN_PLANTEL_X, COLUMN_PLANTEL_Y};

    // Tabela para o jogador
    public static final String COLUMN_JOGADOR_IDJOGADOR = "IdJogador";
    public static final String COLUMN_JOGADOR_IDEQUIPA = "IdEquipa";
    public static final String COLUMN_JOGADOR_NOME = "Nome";
    public static final String COLUMN_JOGADOR_APELIDO = "Apelido";
    public static final String COLUMN_JOGADOR_DATANASCIMENTO ="DataNascimento";
    public static final String COLUMN_JOGADOR_POSICAO = "Posicao";
    public static final String COLUMN_JOGADOR_PESO = "Peso";
    public static final String COLUMN_JOGADOR_ALTURA = "Altura";
    public static final String COLUMN_JOGADOR_PEPREFERENCIAL = "PePreferencial";
    public static final String COLUMN_JOGADOR_CLUBE = "Clube";
    public static final String COLUMN_JOGADOR_LOGOCLUBE = "LogoClube";
    public static final String COLUMN_JOGADOR_NUMERO = "Numero";
    public static final String COLUMN_JOGADOR_FOTOJOGADOR = "FotoJogador";
    public static final String[] COLUMNS_JOGADOR = {COLUMN_JOGADOR_IDJOGADOR, COLUMN_JOGADOR_IDEQUIPA, COLUMN_JOGADOR_NOME,
            COLUMN_JOGADOR_APELIDO, COLUMN_JOGADOR_DATANASCIMENTO, COLUMN_JOGADOR_POSICAO, COLUMN_JOGADOR_PESO,
            COLUMN_JOGADOR_ALTURA, COLUMN_JOGADOR_PEPREFERENCIAL, COLUMN_JOGADOR_CLUBE, COLUMN_JOGADOR_LOGOCLUBE,
            COLUMN_JOGADOR_NUMERO, COLUMN_JOGADOR_FOTOJOGADOR};

    // Tabela para os jogos
    public static final String COLUMN_JOGOS_IDJOGOS = "IdJogos";
    public static final String COLUMN_JOGOS_IDCOMPETICAO = "IdCompeticao";
    public static final String COLUMN_JOGOS_IDEQUIPA1 = "IdEquipa1";
    public static final String COLUMN_JOGOS_IDEQUIPA2 = "IdEquipa2";
    public static final String COLUMN_JOGOS_DATA = "Data";
    public static final String[] COLUMNS_JOGOS = {COLUMN_JOGOS_IDJOGOS, COLUMN_JOGOS_IDCOMPETICAO,COLUMN_JOGOS_IDEQUIPA1,
            COLUMN_JOGOS_IDEQUIPA2, COLUMN_JOGOS_DATA};

    // Construtor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Criar a Tabela para o Jogador
        String Jogador = "CREATE TABLE " + TABLE_JOGADOR
                + "(" + COLUMN_JOGADOR_IDJOGADOR + " integer primary key AUTOINCREMENT,"
                + COLUMN_JOGADOR_IDEQUIPA +  " integer, "
                + COLUMN_JOGADOR_NOME + " text, "
                + COLUMN_JOGADOR_APELIDO + " text, "
                + COLUMN_JOGADOR_DATANASCIMENTO + " text, "
                + COLUMN_JOGADOR_POSICAO + " text, "
                + COLUMN_JOGADOR_PESO + " real, "
                + COLUMN_JOGADOR_ALTURA + " real, "
                + COLUMN_JOGADOR_PEPREFERENCIAL + " text, "
                + COLUMN_JOGADOR_CLUBE + " text, "
                + COLUMN_JOGADOR_LOGOCLUBE + " integer, "
                + COLUMN_JOGADOR_NUMERO + " integer NOT NULL UNIQUE, "
                + COLUMN_JOGADOR_FOTOJOGADOR + " integer)";
        sqLiteDatabase.execSQL(Jogador);

        // Criar a Tabela para o plantel
        String jogadorPlantel = "CREATE TABLE " + TABLE_FORMACAO_PLANTEL
                + "(" + COLUMN_PLANTEL_CODJOGADOR + " integer primary key,"
                + COLUMN_PLANTEL_X + " real,"
                + COLUMN_PLANTEL_Y + " real)";
        sqLiteDatabase.execSQL(jogadorPlantel);

        // Criar a Tabela para os jogos
        String jogos = "CREATE TABLE " + TABLE_JOGOS
                + "(" + COLUMN_JOGOS_IDJOGOS + " interger primary key AUTOINCREMENT,"
                + COLUMN_JOGOS_IDCOMPETICAO + " interger, "
                + COLUMN_JOGOS_IDEQUIPA1 + " interger, "
                + COLUMN_JOGOS_IDEQUIPA2 + " interger, "
                + COLUMN_JOGOS_DATA + " text)";
        sqLiteDatabase.execSQL(jogos);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void erase(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }

}