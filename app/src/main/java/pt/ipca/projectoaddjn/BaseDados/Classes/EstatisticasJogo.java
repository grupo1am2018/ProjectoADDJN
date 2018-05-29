package pt.ipca.projectoaddjn.BaseDados.Classes;

public class EstatisticasJogo {

    public int idEstatisticasJogo;
    public int idJogo;
    public int idEquipa;
    public int golos;

    //Construtor da classe competição
    public EstatisticasJogo(int estatisticasJogo, int jogo, int equipa, int gol){
        this.idEstatisticasJogo = estatisticasJogo;
        this.idJogo = jogo;
        this.idEquipa = equipa;
        this.golos = gol;
    }

    //Função que devolve o idJogo da classe EstatisticasJogo
    public int getIdJogo(){
        return (idJogo);
    }

    //Função que devolve o idEquipa da classe EstatisticasJogo
    public int getIdEquipa(){
        return (idEquipa);
    }

    //Função que devolve os golos da classe EstatisticasJogo
    public int getGoals(){
        return (golos);
    }
}
