package pt.ipca.projectoaddjn.BaseDados.Classes;

public class Jogador {

    public int jId;
    public int jIdEquipa;
    public int jNome;
    public String jDataNascimento;
    public String jPosicao;
    public int jPeso;
    public float jaltura;
    public String jPePreferencial;
    public String jClube;

    public Jogador(int id, int IdEquipa, int nome, String dataNascimento, String posicao, int peso, float altura, String pePreferencial, String clube) {
        this.jId = id;
        this.jIdEquipa = IdEquipa;
        this.jNome = nome;
        this.jDataNascimento = dataNascimento;
        this.jPosicao = posicao;
        this.jPeso = peso;
        this.jaltura = altura;
        this.jPePreferencial = pePreferencial;
        this.jClube = clube;
    }

}
