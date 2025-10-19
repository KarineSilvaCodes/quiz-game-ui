package src.core;

import java.util.Random;

public class Pergunta {
    private String pergunta;
    private String[] opcoes;
    private int indiceCorreto;
    private String[] feedbacks;

    public Pergunta(String pergunta, String[] opcoes, int indiceCorreto, String[] feedbacks) {
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.indiceCorreto = indiceCorreto;
        this.feedbacks = feedbacks;
    }

    public String getPergunta() { return pergunta; }
    public String[] getOpcoes() { return opcoes; }
    public int getIndiceCorreto() { return indiceCorreto; }

    public String getFeedback(boolean correta) {
        if (correta) return feedbacks[indiceCorreto];
        int i;
        do { i = new Random().nextInt(feedbacks.length); } 
        while (i == indiceCorreto);
        return feedbacks[i];
    }
}
