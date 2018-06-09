package pt.ipca.projectoaddjn.BaseDados.Classes;

public class EstatisticaJogo {

    public int estIdJogo;
    public int jId;
    public int idEquipa;
    public int estgolos;
    public double estJogPossedeBola;
    public int estJogTentativasDeGolo;
    public int estJogRematesaBaliza;
    public int estJogRemates;
    public int estJogRematesFora;
    public int estJogLivres;
    public int estJogCantos;
    public int estJogLançamentos;
    public int estJogDefesasGuardaRedes;
    public int estJogCartoesAmarelos;
    public int estJogCartoesVermelhos;
    public int estJogForadeJogo;

    public EstatisticaJogo(int Id, int jId, int idEquipa, int golos, double possedeBola, int tentativasDeGolo, int rematesaBaliza, int remates, int rematesFora, int livres, int cantos, int lancamentos, int defesasGuardaRedes, int cartoesAmarelos, int cartoesVermelhos, int foradeJogo) {
        this.estIdJogo = Id;
        this.jId = jId;
        this.idEquipa = idEquipa;
        this.estgolos = golos;
        this.estJogPossedeBola = possedeBola;
        this.estJogTentativasDeGolo = tentativasDeGolo;
        this.estJogRematesaBaliza = rematesaBaliza;
        this.estJogRemates = remates;
        this.estJogRematesFora = rematesFora;
        this.estJogLivres = livres;
        this.estJogCantos = cantos;
        this.estJogLançamentos = lancamentos;
        this.estJogDefesasGuardaRedes = defesasGuardaRedes;
        this.estJogCartoesAmarelos = cartoesAmarelos;
        this.estJogCartoesVermelhos = cartoesVermelhos;
        this.estJogForadeJogo = foradeJogo;
    }
}
