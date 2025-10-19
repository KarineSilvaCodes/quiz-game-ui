package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TokyoGhoul {

    private List<Pergunta> perguntas;
    private Random random;

    public TokyoGhoul() {
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
                "Quem é o protagonista de Tokyo Ghoul?",
                new String[]{"Kaneki Ken", "Touka Kirishima", "Nishiki Nishio", "Yamori"},
                0,
                new String[]{
                        "Correto! Kaneki é o protagonista!",
                        "Touka é importante, mas não protagonista!",
                        "Nishiki é coadjuvante!",
                        "Yamori é vilão!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é o tipo de kagune de Kaneki?",
                new String[]{"Rinkaku", "Ukaku", "Koukaku", "Bikaku"},
                0,
                new String[]{
                        "Correto! Kaneki tem Rinkaku!",
                        "Ukaku é da Touka!",
                        "Koukaku é de outros ghouls!",
                        "Bikaku é de Nishiki!"}
        ));

        perguntas.add(new Pergunta(
                "Quem dirige o Anteiku?",
                new String[]{"Yoshimura", "Kanou", "Amon", "Hinami"},
                0,
                new String[]{
                        "Correto! Yoshimura é o dono do café Anteiku!",
                        "Kanou é cientista!",
                        "Amon é investigador!",
                        "Hinami é jovem ghoul!"}
        ));

        perguntas.add(new Pergunta(
                "Quem tortura Kaneki em seu treinamento?",
                new String[]{"Yamori", "Nishiki", "Touka", "Hinami"},
                0,
                new String[]{
                        "Correto! Yamori é quem tortura Kaneki!",
                        "Nishiki não tortura Kaneki!",
                        "Touka não faz isso!",
                        "Hinami não participa!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é o apelido de Kaneki após a transformação?",
                new String[]{"Centipede", "One-Eyed King", "Black Reaper", "Dragon"},
                0,
                new String[]{
                        "Correto! Centipede é o apelido dele!",
                        "One-Eyed King aparece depois!",
                        "Black Reaper não é Kaneki!",
                        "Dragon não existe no contexto!"}
        ));

        perguntas.add(new Pergunta(
                "Qual investigador está sempre atrás dos ghouls?",
                new String[]{"Amon Koutarou", "Yoshimura", "Kanou", "Hinami"},
                0,
                new String[]{
                        "Correto! Amon é investigador!",
                        "Yoshimura é dono do café!",
                        "Kanou é cientista!",
                        "Hinami é ghoul!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é a melhor amiga e aliada de Kaneki?",
                new String[]{"Touka Kirishima", "Hinami", "Nishiki", "Rize Kamishiro"},
                0,
                new String[]{
                        "Correto! Touka é a aliada!",
                        "Hinami é amiga, mas mais nova!",
                        "Nishiki é rival/aliado depois!",
                        "Rize desencadeia o problema, mas não aliada!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o ghoul que Kaneki come depois de ser capturado?",
                new String[]{"Rize Kamishiro", "Yamori", "Shinohara", "Uta"},
                0,
                new String[]{
                        "Correto! Rize é o ghoul que inicia a transformação!",
                        "Yamori tortura depois!",
                        "Shinohara é investigador!",
                        "Uta é dono da loja de máscaras!"}
        ));

        perguntas.add(new Pergunta(
                "O que é um quinque?",
                new String[]{"Arma feita a partir de ghoul", "Tipo de kagune", "Investigator Rank", "Shinigami Tool"},
                0,
                new String[]{
                        "Correto! Arma feita a partir de ghoul!",
                        "Não, tipo de kagune é diferente!",
                        "Investigator Rank é outra coisa!",
                        "Shinigami Tool é de outro anime!"}
        ));

        perguntas.add(new Pergunta(
                "Qual grupo de ghouls quer dominar a cidade?",
                new String[]{"Aogiri Tree", "Anteiku", "CCG", "Clowns"},
                0,
                new String[]{
                        "Correto! Aogiri Tree quer dominar!",
                        "Anteiku é pacífico!",
                        "CCG é investigador!",
                        "Clowns é grupo caótico, mas não domina!"}
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
        TokyoGhoul quiz = new TokyoGhoul();
        Pergunta p;
        int acertos = 0, total = 0;
        Scanner scanner = new Scanner(System.in);
        Random randFinal = new Random();

        String[] feedbacksFinal = {
            "Você está pronto para ser um investigador! 🕵️‍♂️",
            "Cuidado para não virar um ghoul! 👀",
            "Quase lá, mas treine mais com Kaneki!",
            "Boa, mas não olhe direto nos olhos de Ryuk… ops, quer dizer, ghoul 😅",
            "Fim do quiz! Sobreviveu à CCG e Aogiri! 🎯"
        };

        System.out.println("🩸 BEM-VINDO AO QUIZ DE TOKYO GHOUL! 🩸");
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
