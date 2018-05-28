package pt.ipca.projectoaddjn.listarJogos;

public class Equipa {

    public int idEquipa;
    public  String nomeEquipa;
    public int logoEquipa;

    //Construtor da classe equipa
    public Equipa(int equipa, String nEquipa, int logo){
        this.idEquipa = equipa;
        this.nomeEquipa = nEquipa;
        this.logoEquipa = logo;
    }

    //Função que devolve o id da classe equipa
    public int getId(){
        return (idEquipa);
    }

    //Função que devolve o nome da classe equipa
    public String getName(){
        return (nomeEquipa);
    }

    //Função que devolve o logo da classe equipa
    public int getLogo(){
        return (logoEquipa);
    }
}
