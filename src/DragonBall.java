package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DragonBall {

    private List<Pergunta> perguntas;
    private Random random;

    public DragonBall() {
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
                new String[]{"Goku", "Vegeta", "Gohan", "Piccolo"},
                0,
                new String[]{
                        "Correto! Goku é o protagonista!",
                        "Vegeta é rival!",
                        "Gohan é filho do Goku!",
                        "Piccolo é aliado!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é a transformação famosa de Goku?",
                new String[]{"Super Saiyajin", "Kaioken", "Mestre Roshi", "Ultra Instinct"},
                0,
                new String[]{
                        "Correto! Super Saiyajin é icônica!",
                        "Kaioken é outra técnica!",
                        "Mestre Roshi é sensei!",
                        "Ultra Instinct é usado depois!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o príncipe dos Saiyajins?",
                new String[]{"Vegeta", "Goku", "Gohan", "Trunks"},
                0,
                new String[]{
                        "Correto! Vegeta é o príncipe!",
                        "Goku é do planeta Saiyajin, mas não príncipe!",
                        "Gohan é filho!",
                        "Trunks é filho do Vegeta!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o melhor amigo e parceiro de Goku na infância?",
                new String[]{"Kuririn", "Yamcha", "Tenshinhan", "Chaozu"},
                0,
                new String[]{
                        "Correto! Kuririn é o amigo de infância!",
                        "Yamcha aparece depois!",
                        "Tenshinhan é rival!",
                        "Chaozu é parceiro secundário!"}
        ));

        perguntas.add(new Pergunta(
                "Qual personagem é o deus da destruição do Universo 7?",
                new String[]{"Bills", "Whis", "Goku", "Vegeta"},
                0,
                new String[]{
                        "Correto! Bills é o deus da destruição!",
                        "Whis é seu assistente!",
                        "Goku não!",
                        "Vegeta não!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o mentor de Goku durante a saga de Namekusei?",
                new String[]{"Kami", "Mestre Kame", "Dende", "Piccolo"},
                3,
                new String[]{
                        "Kami não! (essa é pegadinha)",
                        "Mestre Kame é sensei antigo!",
                        "Dende ajuda depois!",
                        "Correto! Piccolo treina Goku!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o irmão mais velho de Goku?",
                new String[]{"Raditz", "Gohan", "Vegeta", "Bardock"},
                0,
                new String[]{
                        "Correto! Raditz é irmão de Goku!",
                        "Gohan é filho!",
                        "Vegeta não é irmão!",
                        "Bardock é pai!"}
        ));

        perguntas.add(new Pergunta(
                "Quem forma o Gotenks?",
                new String[]{"Goten e Trunks", "Goku e Vegeta", "Gohan e Goten", "Piccolo e Gohan"},
                0,
                new String[]{
                        "Correto! Gotenks é fusão de Goten e Trunks!",
                        "Goku e Vegeta não formam Gotenks!",
                        "Gohan e Goten não!",
                        "Piccolo e Gohan não!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é o ataque assinatura de Goku?",
                new String[]{"Kamehameha", "Final Flash", "Galick Gun", "Destructo Disc"},
                0,
                new String[]{
                        "Correto! Kamehameha é ataque clássico!",
                        "Final Flash é do Vegeta!",
                        "Galick Gun é do Vegeta!",
                        "Destructo Disc é do Kuririn!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o androide que se torna aliado de Goku?",
                new String[]{"Androide 18", "Androide 17", "Cell", "Buu"},
                0,
                new String[]{
                        "Correto! Androide 18 se torna aliada!",
                        "Androide 17 ajuda depois!",
                        "Cell é vilão!",
                        "Buu é vilão!"}
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
        DragonBall quiz = new DragonBall();
        Pergunta p;
        int acertos = 0, total = 0;
        Scanner scanner = new Scanner(System.in);
        Random randFinal = new Random();

        String[] feedbacksFinal = {
            "Você está quase no nível Super Saiyajin! 💥",
            "Muito bem! Mas continue treinando seu Ki!",
            "Excelente! Você sobreviveu a todas as batalhas!",
            "Parabéns! Seu poder de luta está elevado! ⚡",
            "Fim do quiz! Continue evoluindo seu poder!"
        };

        System.out.println("📝 BEM-VINDO AO QUIZ DE DRAGON BALL! 📝");
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
