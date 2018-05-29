package pt.ipca.projectoaddjn.Chat;

/**
  Created by Nuno on 08/05/2018.
 */

public class Mensagem {

    // Variaveis de Instancia
    public String conteudo;

    // Construtor
    public Mensagem(String bConteudo) {
        conteudo  = bConteudo;
    }

    public Mensagem() {
        conteudo = "";
    }

    public String ToString() {
        return ("Remetente: " + conteudo + "\n");
    }
}