package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HunterxHunter {

    private List<Pergunta> perguntas;
    private Random random;

    public HunterxHunter() {
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
                new String[]{"Gon Freecss", "Killua Zoldyck", "Kurapika", "Leorio"},
                0,
                new String[]{
                        "Correto! Gon é o protagonista!",
                        "Killua é amigo e rival!",
                        "Kurapika é aliado!",
                        "Leorio é amigo!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é da famosa família assassina Zoldyck?",
                new String[]{"Killua", "Gon", "Kurapika", "Leorio"},
                0,
                new String[]{
                        "Correto! Killua é da família Zoldyck!",
                        "Gon não é assassino!",
                        "Kurapika não!",
                        "Leorio não!"}
        ));

        perguntas.add(new Pergunta(
                "Qual personagem possui correntes para lutar?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"},
                0,
                new String[]{
                        "Correto! Kurapika usa correntes!",
                        "Gon usa força física!",
                        "Killua usa eletricidade!",
                        "Leorio usa socos!"}
        ));

        perguntas.add(new Pergunta(
                "Quem tem habilidades de eletricidade?",
                new String[]{"Killua", "Gon", "Kurapika", "Leorio"},
                0,
                new String[]{
                        "Correto! Killua domina eletricidade!",
                        "Gon não!",
                        "Kurapika não!",
                        "Leorio não!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o melhor amigo de Gon?",
                new String[]{"Killua", "Kurapika", "Leorio", "Hisoka"},
                0,
                new String[]{
                        "Correto! Killua é o melhor amigo!",
                        "Kurapika é aliado!",
                        "Leorio é amigo!",
                        "Hisoka é antagonista!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é membro da Tropa Fantasma?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"},
                0,
                new String[]{
                        "Correto! Kurapika luta contra a Tropa Fantasma!",
                        "Gon não!",
                        "Killua não!",
                        "Leorio não!"}
        ));

        perguntas.add(new Pergunta(
                "Qual personagem quer se tornar um caçador para achar seu pai?",
                new String[]{"Gon", "Killua", "Kurapika", "Leorio"},
                0,
                new String[]{
                        "Correto! Gon quer achar seu pai!",
                        "Killua não!",
                        "Kurapika não!",
                        "Leorio não!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é médico aspirante e amigo do grupo?",
                new String[]{"Leorio", "Gon", "Killua", "Kurapika"},
                0,
                new String[]{
                        "Correto! Leorio quer ser médico!",
                        "Gon não!",
                        "Killua não!",
                        "Kurapika não!"}
        ));

        perguntas.add(new Pergunta(
                "Quem luta para vingar seu clã Kurta?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"},
                0,
                new String[]{
                        "Correto! Kurapika busca vingança!",
                        "Gon não!",
                        "Killua não!",
                        "Leorio não!"}
        ));

        perguntas.add(new Pergunta(
                "Quem participa do Exame Hunter junto com Gon?",
                new String[]{"Killua", "Kurapika", "Leorio", "Hisoka"},
                0,
                new String[]{
                        "Correto! Killua participa com Gon!",
                        "Kurapika não participa!",
                        "Leorio participa!",
                        "Hisoka participa, mas como antagonista!"}
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
        HunterxHunter quiz = new HunterxHunter();
        Pergunta p;
        int acertos = 0, total = 0;
        Scanner scanner = new Scanner(System.in);
        Random randFinal = new Random();

        String[] feedbacksFinal = {
            "Você está quase no nível de caçador! 🏹",
            "Continue treinando seu Nen!",
            "Muito bem! Mas não subestime os inimigos!",
            "Parabéns! Sobreviveu a todas as provas!",
            "Fim do quiz! Seu cosmo de caçador está elevado! ⚡"
        };

        System.out.println("📝 BEM-VINDO AO QUIZ DE HUNTER X HUNTER! 📝");
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
