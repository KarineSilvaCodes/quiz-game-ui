package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OnePiece {

    private List<Pergunta> perguntas;
    private Random random;

    public OnePiece() {
        perguntas = new ArrayList<>();
        random = new Random();
        carregarPerguntas();
    }

    public Pergunta getPerguntaAleatoria() {
        if (perguntas.isEmpty()) {
            return null;
        }
        int index = random.nextInt(perguntas.size());
        Pergunta p = perguntas.get(index);
        perguntas.remove(index);
        return p;
    }

    private void carregarPerguntas() {
        perguntas.add(new Pergunta(
                "Quem é o capitão dos Chapéus de Palha?",
                new String[]{"Roronoa Zoro", "Monkey D. Luffy", "Sanji", "Usopp"},
                1,
                new String[]{
                        "Ops! Zoro é só o espadachim!",
                        "Correto! Luffy é o capitão com estilo!",
                        "Sanji só cozinha, não comanda!",
                        "Usopp é bom de mentira, mas não de liderança!"
                }
        ));

        perguntas.add(new Pergunta(
                "Qual é o sonho de Sanji?",
                new String[]{"Encontrar o One Piece", "Se tornar o Rei dos Piratas", "Encontrar All Blue", "Dominar Haki"},
                2,
                new String[]{
                        "Não é esse... ele sonha grande na cozinha!",
                        "Luffy sonha nisso, não Sanji!",
                        "Acertou! Ele quer encontrar o All Blue!",
                        "Haki é bom, mas não é o sonho dele!"
                }
        ));

        perguntas.add(new Pergunta(
                "Quem comeu a Gomu Gomu no Mi?",
                new String[]{"Nami", "Zoro", "Luffy", "Chopper"},
                2,
                new String[]{
                        "Nami só rouba dinheiro, não come frutas mágicas!",
                        "Zoro prefere treino e espadas!",
                        "Acertou! Luffy ficou elástico!",
                        "Chopper é fofinho, mas não come Gomu Gomu no Mi!"
                }
        ));

        perguntas.add(new Pergunta(
                "Qual é o nome do navio atual dos Chapéus de Palha?",
                new String[]{"Going Merry", "Thousand Sunny", "Red Force", "Sunny Go"},
                1,
                new String[]{
                        "Going Merry foi destruído, mas já foi lendário!",
                        "Correto! O atual é Thousand Sunny!",
                        "Red Force? Isso é de outro anime!",
                        "Sunny Go? Quase, mas não é o nome oficial!"
                }
        ));

        perguntas.add(new Pergunta(
                "Quem é o espadachim do bando?",
                new String[]{"Zoro", "Sanji", "Franky", "Usopp"},
                0,
                new String[]{
                        "Correto! Zoro corta tudo!",
                        "Sanji corta comida, não inimigos!",
                        "Franky constrói, não espada!",
                        "Usopp só atira mentiras!"
                }
        ));

        perguntas.add(new Pergunta(
                "Qual é o poder de Chopper?",
                new String[]{"Transformação", "Haki", "Logia", "Gelo"},
                0,
                new String[]{
                        "Acertou! Chopper pode se transformar!",
                        "Haki? Só alguns conseguem!",
                        "Logia é outro tipo de Akuma no Mi!",
                        "Gelo? Ele não controla isso!"
                }
        ));

        perguntas.add(new Pergunta(
                "Quem é o médico do bando?",
                new String[]{"Chopper", "Sanji", "Nami", "Robin"},
                0,
                new String[]{
                        "Correto! Chopper cuida da galera!",
                        "Sanji cozinha, não cura!",
                        "Nami só cuida da bússola!",
                        "Robin descobre história, não medicinas!"
                }
        ));

        perguntas.add(new Pergunta(
                "Qual o objetivo de Nico Robin?",
                new String[]{"Se tornar pirata", "Descobrir o Rio Poneglyph", "Ser cozinheira", "Encontrar All Blue"},
                1,
                new String[]{
                        "Ela é pirata sim, mas quer algo mais!",
                        "Acertou! Ela quer decifrar a história do mundo!",
                        "Cozinhar? Não é a dela!",
                        "All Blue é Sanji, não Robin!"
                }
        ));

        perguntas.add(new Pergunta(
                "Qual personagem é conhecido por suas mentiras exageradas?",
                new String[]{"Usopp", "Sanji", "Zoro", "Franky"},
                0,
                new String[]{
                        "Correto! Usopp é o rei das mentiras!",
                        "Sanji não mente, só cozinha!",
                        "Zoro não fala muito, só corta!",
                        "Franky é excêntrico, mas não mentiroso!"
                }
        ));

        perguntas.add(new Pergunta(
                "Quem é o cozinheiro do bando?",
                new String[]{"Nami", "Sanji", "Chopper", "Robin"},
                1,
                new String[]{
                        "Nami só navega, não cozinha!",
                        "Correto! Sanji manda bem na cozinha!",
                        "Chopper só cuida da saúde!",
                        "Robin pesquisa história, não cozinha!"
                }
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

        public String getPergunta() {
            return pergunta;
        }

        public String[] getOpcoes() {
            return opcoes;
        }

        public int getIndiceCorreto() {
            return indiceCorreto;
        }

        public String getFeedback(boolean correta) {
            if (correta) {
                return feedbacks[indiceCorreto];
            } else {
                int i;
                do {
                    i = new Random().nextInt(feedbacks.length);
                } while (i == indiceCorreto);
                return feedbacks[i];
            }
        }
    }

    public static void main(String[] args) {
        OnePiece quiz = new OnePiece();
        Pergunta p;
        int acertos = 0;
        int total = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("🏴‍☠️ BEM-VINDO AO QUIZ ONE PIECE! 🏴‍☠️");
        System.out.println("-----------------------------------");

        while ((p = quiz.getPerguntaAleatoria()) != null) {
            System.out.println("\n" + p.getPergunta());
            String[] opcoes = p.getOpcoes();

            for (int i = 0; i < opcoes.length; i++) {
                System.out.println((i + 1) + ". " + opcoes[i]);
            }

            System.out.print("👉 Sua resposta: ");
            int resposta = scanner.nextInt() - 1;

            boolean correta = (resposta == p.getIndiceCorreto());
            System.out.println(p.getFeedback(correta));

            if (correta) acertos++;
            total++;

            try { Thread.sleep(1500); } catch (InterruptedException e) { }
        }

        System.out.println("\nFim do quiz! Você acertou " + acertos + "/" + total);
        System.out.println("Obrigado por jogar, pirata dos mares! ⚓");

        scanner.close();
    }
}
