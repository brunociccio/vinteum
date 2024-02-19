package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador) {

        if (jogador.parou()) return null;

        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }

    public boolean acabou() {

        var osDoisPararam = jogador.parou() && computador.parou();
        var jogadorEstourou = jogador.getPontos() > 21;
        var computadorEstourou = computador.getPontos () > 21;

        return osDoisPararam || jogadorEstourou || computadorEstourou;
    }

    public String resultado() {

        var pontosIguais = jogador.getPontos() == computador.getPontos();
        var osDoisEstouraram = jogador.estourou() && computador.estourou();
        var jogadorTemMaisPontos = jogador.getPontos() > computador.getPontos();

        if( pontosIguais || osDoisEstouraram ) return "Empatou";
        if( !jogador.estourou() == false && (computador.estourou() || jogadorTemMaisPontos)) return "Você ganhou!";
        return "Você perdeu!";
    }

}
