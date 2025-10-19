package src.core;

public class Pergunta {
    private String pergunta;
    private String[] opcoes;
    private int indiceCorreto;
    private String[] feedbacks;

    public Pergunta(String pergunta, String[] opcoes, int indiceCorreto, String[] feedbacks) {
        if (opcoes.length != feedbacks.length) {
            throw new IllegalArgumentException("Cada opção deve ter um feedback correspondente!");
        }
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.indiceCorreto = indiceCorreto;
        this.feedbacks = feedbacks;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public int getIndiceCorreto() {
        return indiceCorreto;
    }

    /**
     * Retorna o feedback da resposta.
     * @param indiceEscolhido índice da opção selecionada pelo usuário
     * @return feedback coerente com a opção escolhida
     */
    public String getFeedback(int indiceEscolhido) {
        if (indiceEscolhido == indiceCorreto) {
            return feedbacks[indiceCorreto];
        } else {
            return feedbacks[indiceEscolhido];
        }
    }
}
