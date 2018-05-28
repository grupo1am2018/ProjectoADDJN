package pt.ipca.projectoaddjn.listarJogos;

public class Competicao {

    public int idCompeticao;
    public  String nomeCompeticao;
    public  String dataInicio;
    public  String dataFim;
    public  String localCompeticao;



    //Construtor da classe competição
    public Competicao(int competicao, String nCompeticao, String dataIn, String dataF, String local){
        this.idCompeticao = competicao;
        this.nomeCompeticao = nCompeticao;
        this.dataInicio = dataIn;
        this.dataFim = dataF;
        this.localCompeticao = local;
    }

    //Função que devolve o id da classe competição
    public int getId(){
        return (idCompeticao);
    }

    //Função que devolve o nome da classe competição
    public String getName(){
        return (nomeCompeticao);
    }
}
