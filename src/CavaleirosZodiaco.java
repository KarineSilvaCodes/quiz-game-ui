package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CavaleirosZodiaco {

    private List<Pergunta> perguntas;
    private Random random;

    public CavaleirosZodiaco() {
        perguntas = new ArrayList<>();
        random = new Random();
        carregarPerguntas();
    }

    public Pergunta getPerguntaAleatoria() {
        if (perguntas.isEmpty()) return null;
        int index = random.nextInt(perguntas.size());
        Pergunta p = perguntas.get(index);
        perguntas.remove(index);
        return p;
    }

    private void carregarPerguntas() {
        perguntas.add(new Pergunta(
                "Quem é o protagonista da série?",
                new String[]{"Seiya", "Shiryu", "Hyoga", "Shun"},
                0,
                new String[]{
                        "Correto! Seiya é o protagonista!",
                        "Shiryu é aliado!",
                        "Hyoga é aliado!",
                        "Shun é aliado!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é o cavaleiro de bronze de Dragão?",
                new String[]{"Shiryu", "Seiya", "Hyoga", "Shun"},
                0,
                new String[]{
                        "Correto! Shiryu é o Cavaleiro de Dragão!",
                        "Seiya é Pégaso!",
                        "Hyoga é Cisne!",
                        "Shun é Andrômeda!"}
        ));

        perguntas.add(new Pergunta(
                "Qual cavaleiro usa a armadura de Cisne?",
                new String[]{"Hyoga", "Seiya", "Shiryu", "Ikki"},
                0,
                new String[]{
                        "Correto! Hyoga é o Cisne!",
                        "Seiya é Pégaso!",
                        "Shiryu é Dragão!",
                        "Ikki é Fênix!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é conhecido como cavaleiro de Fênix?",
                new String[]{"Ikki", "Seiya", "Shun", "Hyoga"},
                0,
                new String[]{
                        "Correto! Ikki é o Fênix!",
                        "Seiya é Pégaso!",
                        "Shun é Andrômeda!",
                        "Hyoga é Cisne!"}
        ));

        perguntas.add(new Pergunta(
                "Qual cavaleiro é irmão de Shun?",
                new String[]{"Ikki", "Seiya", "Hyoga", "Shiryu"},
                0,
                new String[]{
                        "Correto! Ikki é irmão de Shun!",
                        "Seiya não é irmão!",
                        "Hyoga não é irmão!",
                        "Shiryu não é irmão!"}
        ));

        perguntas.add(new Pergunta(
                "Quem possui a armadura de Pégaso?",
                new String[]{"Seiya", "Shiryu", "Hyoga", "Shun"},
                0,
                new String[]{
                        "Correto! Seiya é Pégaso!",
                        "Shiryu é Dragão!",
                        "Hyoga é Cisne!",
                        "Shun é Andrômeda!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é o cavaleiro de Andrômeda?",
                new String[]{"Shun", "Seiya", "Hyoga", "Shiryu"},
                0,
                new String[]{
                        "Correto! Shun é Andrômeda!",
                        "Seiya é Pégaso!",
                        "Hyoga é Cisne!",
                        "Shiryu é Dragão!"}
        ));

        perguntas.add(new Pergunta(
                "Qual cavaleiro possui golpes de gelo?",
                new String[]{"Hyoga", "Shiryu", "Seiya", "Shun"},
                0,
                new String[]{
                        "Correto! Hyoga usa golpes de gelo!",
                        "Shiryu usa força do dragão!",
                        "Seiya usa Pégaso!",
                        "Shun usa correntes!"}
        ));

        perguntas.add(new Pergunta(
                "Quem protege Saori Kido?",
                new String[]{"Os cavaleiros de bronze", "Os cavaleiros de ouro", "Os espectros de Hades", "Shinigamis"},
                0,
                new String[]{
                        "Correto! Os cavaleiros de bronze protegem Saori!",
                        "Cavaleiros de ouro ajudam, mas foco é bronze!",
                        "Espectros são inimigos!",
                        "Shinigamis não existem em Cavaleiros do Zodíaco!"}
        ));

        perguntas.add(new Pergunta(
                "Qual cavaleiro tem poder de corrente?",
                new String[]{"Shun", "Seiya", "Shiryu", "Hyoga"},
                0,
                new String[]{
                        "Correto! Shun usa correntes de Andrômeda!",
                        "Seiya usa socos Pégaso!",
                        "Shiryu usa Dragão!",
                        "Hyoga usa gelo!"}
        ));

        Collections.shuffle(perguntas);
    }

    public static class Pergunta {
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

    public static void main(String[] args) {
        CavaleirosZodiaco quiz = new CavaleirosZodiaco();
        Pergunta p;
        int acertos = 0, total = 0;
        Scanner scanner = new Scanner(System.in);
        Random randFinal = new Random();

        String[] feedbacksFinal = {
            "Você é digno do cosmo! ✨",
            "Continue treinando, cavaleiro!",
            "Quase lá! Estude mais os golpes e armaduras!",
            "Parabéns! Sobreviveu aos ataques de Hades!",
            "Fim do quiz! Cosmo elevado ao máximo! ⚡"
        };

        System.out.println("⚔️ BEM-VINDO AO QUIZ DE CAVALEIROS DO ZODÍACO! ⚔️");
        System.out.println("-----------------------------------");

        while ((p = quiz.getPerguntaAleatoria()) != null) {
            System.out.println("\n" + p.getPergunta());
            String[] opcoes = p.getOpcoes();

            for (int i = 0; i < opcoes.length; i++) {
                System.out.println((i + 1) + ". " + opcoes[i]);
            }

            int resposta;
            while (true) {
                System.out.print("👉 Sua resposta: ");
                resposta = scanner.nextInt() - 1;
                if (resposta >= 0 && resposta < opcoes.length) break;
                System.out.println("Número inválido! Digite um número entre 1 e " + opcoes.length + ".");
            }

            boolean correta = (resposta == p.getIndiceCorreto());
            System.out.println(p.getFeedback(correta));

            if (correta) acertos++;
            total++;

            try { Thread.sleep(1500); } catch (InterruptedException e) { }
        }

        System.out.println("\nFim do quiz! Você acertou " + acertos + "/" + total);
        System.out.println(feedbacksFinal[randFinal.nextInt(feedbacksFinal.length)]);

        scanner.close();
    }
}
