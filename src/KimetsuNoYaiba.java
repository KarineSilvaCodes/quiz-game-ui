package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KimetsuNoYaiba {

    private List<Pergunta> perguntas;
    private Random random;

    public KimetsuNoYaiba() {
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
                new String[]{"Tanjiro Kamado", "Nezuko Kamado", "Zenitsu Agatsuma", "Inosuke Hashibira"},
                0,
                new String[]{
                        "Correto! Tanjiro é o protagonista!",
                        "Nezuko é irmã de Tanjiro!",
                        "Zenitsu é aliado!",
                        "Inosuke é aliado!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é a irmã de Tanjiro transformada em demônio?",
                new String[]{"Nezuko", "Muzan", "Shinobu", "Kanao"},
                0,
                new String[]{
                        "Correto! Nezuko é a irmã de Tanjiro!",
                        "Muzan é o vilão!",
                        "Shinobu é Hashira!",
                        "Kanao é caçadora!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o vilão principal da série?",
                new String[]{"Muzan Kibutsuji", "Tanjiro", "Zenitsu", "Giyu"},
                0,
                new String[]{
                        "Correto! Muzan é o vilão supremo!",
                        "Tanjiro é herói!",
                        "Zenitsu é aliado!",
                        "Giyu é Hashira!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é a respiração de Tanjiro?",
                new String[]{"Água", "Fogo", "Relâmpago", "Beast"},
                0,
                new String[]{
                        "Correto! Tanjiro usa respiração da Água!",
                        "Fogo? Não!",
                        "Relâmpago é do Zenitsu!",
                        "Beast é do Inosuke!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o Hashira da Insectos?",
                new String[]{"Shinobu Kocho", "Giyu Tomioka", "Kyojuro Rengoku", "Tengen Uzui"},
                0,
                new String[]{
                        "Correto! Shinobu é Hashira dos Insetos!",
                        "Giyu é da Água!",
                        "Rengoku é da Chama!",
                        "Uzui é da Névoa!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é conhecido por usar respiração da Chama?",
                new String[]{"Kyojuro Rengoku", "Tanjiro", "Inosuke", "Zenitsu"},
                0,
                new String[]{
                        "Correto! Rengoku é Hashira da Chama!",
                        "Tanjiro usa Água!",
                        "Inosuke usa Beast!",
                        "Zenitsu usa Relâmpago!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o amigo que usa respiração do Relâmpago?",
                new String[]{"Zenitsu Agatsuma", "Tanjiro", "Inosuke", "Nezuko"},
                0,
                new String[]{
                        "Correto! Zenitsu usa Relâmpago!",
                        "Tanjiro usa Água!",
                        "Inosuke usa Beast!",
                        "Nezuko não usa respiração!"}
        ));

        perguntas.add(new Pergunta(
                "Qual amigo usa respiração Beast?",
                new String[]{"Inosuke Hashibira", "Zenitsu", "Tanjiro", "Giyu"},
                0,
                new String[]{
                        "Correto! Inosuke usa respiração Beast!",
                        "Zenitsu usa Relâmpago!",
                        "Tanjiro usa Água!",
                        "Giyu usa Água!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é conhecido por atacar silenciosamente e rápido?",
                new String[]{"Kanao Tsuyuri", "Tanjiro", "Zenitsu", "Inosuke"},
                0,
                new String[]{
                        "Correto! Kanao é ágil e silenciosa!",
                        "Tanjiro é mais direto!",
                        "Zenitsu tem medo!",
                        "Inosuke é explosivo!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o líder da Corporação dos Caçadores de Demônios?",
                new String[]{"Muzan Kibutsuji", "Tanjiro", "Giyu", "Hashiras"},
                0,
                new String[]{
                        "Correto! Muzan é vilão principal, mas os Hashira lideram!",
                        "Tanjiro não!",
                        "Giyu é Hashira!",
                        "Hashiras são vários!"}
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
        KimetsuNoYaiba quiz = new KimetsuNoYaiba();
        Pergunta p;
        int acertos = 0, total = 0;
        Scanner scanner = new Scanner(System.in);
        Random randFinal = new Random();

        String[] feedbacksFinal = {
            "Parabéns! Você está pronto para caçar demônios! ⚔️",
            "Muito bem! Mas cuidado com Muzan!",
            "Ótimo! Seu Nichirin está afiado! 🗡️",
            "Excelente! Você sobreviveu a todas as batalhas!",
            "Fim do quiz! Continue treinando sua respiração!"
        };

        System.out.println("📝 BEM-VINDO AO QUIZ DE KIMETSU NO YAIBA! 📝");
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
