package src;
// Importações necessárias para listas, scanner e utilidades
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

// Classe principal do jogo (somente lógica, sem interface visual)
public class Naruto {

    // Scanner para entrada do usuário no console
    private static Scanner scanner = new Scanner(System.in);

    // Lista de perguntas
    private static ArrayList<Pergunta> perguntas = new ArrayList<>();

    // Variáveis de controle
    private static int pontuacao = 0;
    private static Random random = new Random();

    public static void main(String[] args) {
        // Mensagem inicial
        System.out.println("=== QUIZ DE NARUTO 🍥 ===");
        System.out.println("Responda as 10 perguntas e prove que é digno de ser Hokage!");
        System.out.println("-----------------------------------------------------------\n");

        // Gera as perguntas e embaralha
        perguntas = gerarPerguntasNaruto();
        Collections.shuffle(perguntas);

        // Loop principal: 10 perguntas
        for (int i = 0; i < 10; i++) {
            Pergunta p = perguntas.get(i);

            // Exibe a pergunta e as opções
            System.out.println("Pergunta " + (i + 1) + ": " + p.getTexto());
            String[] opcoes = p.getOpcoes();
            for (int j = 0; j < opcoes.length; j++) {
                System.out.println((j + 1) + ") " + opcoes[j]);
            }

            // Recebe a resposta do jogador
            System.out.print("Sua resposta (1-4): ");
            int respostaUsuario = receberRespostaValida();

            // Verifica se está correta
            if (respostaUsuario - 1 == p.getCorreta()) {
                pontuacao++;
                System.out.println("\u001B[32m" + respostaCertaAleatoria() + "\u001B[0m"); // Verde
            } else {
                System.out.println("\u001B[31m" + respostaErradaAleatoria() + "\u001B[0m"); // Vermelho
                System.out.println("➡ Resposta correta: " + opcoes[p.getCorreta()]);
            }

            // Linha separadora e pausa de 1.5 segundos antes da próxima pergunta
            System.out.println("-----------------------------------------------------------\n");
            esperar(1500);
        }

        // Exibe o resultado final
        double percentual = (pontuacao / 10.0) * 100;
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Você acertou " + pontuacao + " de 10 perguntas!");
        System.out.printf("(%.0f%% de acertos)\n", percentual);
        System.out.println(comentarioFinal(percentual));
        System.out.println("=========================");
    }

    // Método para garantir que o jogador digite um número válido (1 a 4)
    private static int receberRespostaValida() {
        while (true) {
            try {
                int resposta = Integer.parseInt(scanner.nextLine());
                if (resposta >= 1 && resposta <= 4) {
                    return resposta;
                } else {
                    System.out.print("Digite um número entre 1 e 4: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Digite um número entre 1 e 4: ");
            }
        }
    }

    // Método que cria e retorna as perguntas do quiz
    private static ArrayList<Pergunta> gerarPerguntasNaruto() {
        ArrayList<Pergunta> lista = new ArrayList<>();

        lista.add(new Pergunta("Qual o nome completo do Naruto?",
                new String[]{"Naruto Uchiha", "Naruto Uzumaki", "Naruto Hatake", "Naruto Haruno"}, 1));

        lista.add(new Pergunta("Quem é o melhor amigo do Naruto?",
                new String[]{"Sasuke", "Neji", "Kiba", "Gaara"}, 0));

        lista.add(new Pergunta("Qual é o nome da raposa de nove caudas selada em Naruto?",
                new String[]{"Kurama", "Gyūki", "Shukaku", "Matatabi"}, 0));

        lista.add(new Pergunta("Quem treinou o Naruto após a luta com Sasuke no Vale do Fim?",
                new String[]{"Jiraiya", "Kakashi", "Iruka", "Minato"}, 0));

        lista.add(new Pergunta("Quem é o pai do Naruto?",
                new String[]{"Hashirama", "Tobirama", "Minato", "Hiruzen"}, 2));

        lista.add(new Pergunta("Qual é o sonho do Naruto?",
                new String[]{"Ser Hokage", "Ser o ninja mais forte do mundo", "Ser um herói", "Casar com a Hinata"}, 0));

        lista.add(new Pergunta("Quem era o sensei do Time 7?",
                new String[]{"Asuma", "Kurenai", "Kakashi", "Guy"}, 2));

        lista.add(new Pergunta("Qual é o nome da mãe do Naruto?",
                new String[]{"Kushina Uzumaki", "Mikoto Uchiha", "Kaguya Otsutsuki", "Tsunade"}, 0));

        lista.add(new Pergunta("Quem matou o Jiraiya?",
                new String[]{"Pain", "Itachi", "Madara", "Obito"}, 0));

        lista.add(new Pergunta("Qual é a vila natal do Naruto?",
                new String[]{"Vila da Areia", "Vila da Nuvem", "Vila da Folha", "Vila da Névoa"}, 2));

        return lista;
    }

    // Feedbacks engraçados para respostas corretas
    private static String respostaCertaAleatoria() {
        String[] respostas = {
                "Dattebayo! 🌀 Você é um verdadeiro ninja!",
                "Caramba! Nem o Kakashi respondeu tão rápido!",
                "O Iruka ficaria orgulhoso!",
                "Hinata sorriu pra você agora mesmo 💕",
                "Você canalizou o chakra da sabedoria!",
                "Se continuar assim, vira Hokage logo 😎"
        };
        return respostas[random.nextInt(respostas.length)];
    }

    // Feedbacks engraçados para respostas erradas
    private static String respostaErradaAleatoria() {
        String[] respostas = {
                "Tem certeza que assistiu Naruto mesmo? 👀",
                "Ops... isso foi um Genjutsu?",
                "Nem o Konohamaru erraria essa!",
                "Tá igual o Naruto na escola ninja 😅",
                "Kakashi está desapontado, mas ainda há esperança.",
                "Respira... concentra o chakra e tenta de novo!"
        };
        return respostas[random.nextInt(respostas.length)];
    }

    // Comentário final de acordo com o desempenho
    private static String comentarioFinal(double pct) {
        if (pct == 100) return "Você é o próprio Sábio dos Seis Caminhos!";
        if (pct >= 80) return "Quase um Hokage! 🏆";
        if (pct >= 50) return "Bom, mas ainda precisa treinar com o Jiraiya!";
        return "Nem o Naruto no começo do anime errava tanto 😅";
    }

    // Método utilitário para pausar a execução (simula delay entre perguntas)
    private static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Classe que representa uma pergunta individual
class Pergunta1 {
    private String texto;       // Texto da pergunta
    private String[] opcoes;    // Alternativas
    private int correta;        // Índice da opção correta

    public Pergunta1(String texto, String[] opcoes, int correta) {
        this.texto = texto;
        this.opcoes = opcoes;
        this.correta = correta;
    }

    public String getTexto() {
        return texto;
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public int getCorreta() {
        return correta;
    }
}
