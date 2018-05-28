package pt.ipca.projectoaddjn.listarJogos;

public class Jogo {

    public int idJogo;
    public int idEquipa1;
    public int idEquipa2;
    public int idCompeticao;
    public String data;

    //Construtor da classe competição
    public Jogo(int jogo, int equipa1, int equipa2, int competicao, String date){
        this.idJogo = jogo;
        this.idEquipa1 = equipa1;
        this.idEquipa2 = equipa2;
        this.idCompeticao = competicao;
        this.data = date;
    }
}
