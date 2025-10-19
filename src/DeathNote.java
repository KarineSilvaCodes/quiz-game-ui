package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DeathNote {

    private List<Pergunta> perguntas;
    private Random random;

    public DeathNote() {
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
                "Quem encontrou o Death Note primeiro?",
                new String[]{"Light Yagami", "L", "Ryuk", "Misa Amane"},
                0,
                new String[]{
                        "Correto! Light é quem encontra o caderno!",
                        "L só investiga depois!",
                        "Ryuk só deixou cair!",
                        "Misa só pega depois!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual é o objetivo principal de Light?",
                new String[]{"Criar um mundo sem crime", "Se tornar detetive", "Roubar tesouros", "Se tornar rei dos piratas"},
                0,
                new String[]{
                        "Correto! Light quer um mundo sem crime!",
                        "Detetive? L é que faz isso!",
                        "Tesouros? Não é o foco!",
                        "Rei dos piratas? Isso é outro anime!"
                }
        ));
        perguntas.add(new Pergunta(
                "Quem é o famoso detetive que persegue Kira?",
                new String[]{"L", "Near", "Mello", "Ryuk"},
                0,
                new String[]{
                        "Correto! L é o detetive genial!",
                        "Near aparece depois, mas não primeiro!",
                        "Mello ajuda depois, mas não é o inicial!",
                        "Ryuk é o Shinigami, não detetive!"
                }
        ));
        perguntas.add(new Pergunta(
                "Quem é a segunda dona do Death Note no anime?",
                new String[]{"Misa Amane", "Light Yagami", "Rem", "Ryuk"},
                0,
                new String[]{
                        "Correto! Misa pega o caderno depois!",
                        "Light já tinha o caderno!",
                        "Rem é o Shinigami protetor!",
                        "Ryuk é só observador!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual é o nome do Shinigami que deixa o caderno cair?",
                new String[]{"Ryuk", "Rem", "Sidoh", "Gelus"},
                0,
                new String[]{
                        "Correto! Ryuk adora ver o caos!",
                        "Rem protege Misa!",
                        "Sidoh aparece depois!",
                        "Gelus é outro Shinigami!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual é a regra principal do Death Note?",
                new String[]{"Qualquer pessoa cujo nome seja escrito morre", "O dono vira imortal", "Pode reviver qualquer pessoa", "Concede poderes de detetive"},
                0,
                new String[]{
                        "Correto! Escreveu o nome = morreu!",
                        "Não, não há imortalidade assim!",
                        "Não dá pra reviver!",
                        "Poder de detetive não existe no caderno!"
                }
        ));
        perguntas.add(new Pergunta(
                "Quem consegue se aproximar de Light sem suspeitar inicialmente?",
                new String[]{"Misa Amane", "L", "Ryuk", "Near"},
                0,
                new String[]{
                        "Correto! Misa confia e se aproxima!",
                        "L sempre suspeita!",
                        "Ryuk observa só!",
                        "Near aparece depois da história inicial!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual é o nome do verdadeiro detetive rival de Kira no final?",
                new String[]{"Near", "L", "Mello", "Ryuk"},
                0,
                new String[]{
                        "Correto! Near resolve o caso!",
                        "L morre antes!",
                        "Mello ajuda, mas não vence!",
                        "Ryuk só observa!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual é o apelido de Light quando ele é famoso por matar criminosos?",
                new String[]{"Kira", "Shinigami", "L", "God of Death"},
                0,
                new String[]{
                        "Correto! Kira aterroriza o mundo!",
                        "Shinigami é Ryuk!",
                        "L é o detetive!",
                        "God of Death é tradução, mas não apelido usado na história!"
                }
        ));
        perguntas.add(new Pergunta(
                "Quem é apaixonado por Light e também usa o Death Note?",
                new String[]{"Misa Amane", "Near", "Ryuk", "L"},
                0,
                new String[]{
                        "Correto! Misa é fã e se envolve!",
                        "Near não tem relação amorosa!",
                        "Ryuk só observa!",
                        "L não usa o Death Note!"
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
        DeathNote quiz = new DeathNote();
        Pergunta p;
        int acertos = 0, total = 0;
        Scanner scanner = new Scanner(System.in);
        Random randFinal = new Random();

        String[] feedbacksFinal = {
            "Kira ficaria orgulhoso! 😈",
            "Você sobreviveu sem escrever nomes no caderno! 😅",
            "Investigue mais, detetive! 🕵️‍♂️",
            "Acertou bastante, mas cuidado com Shinigamis! 👀",
            "Fim do quiz! Não olhe para Ryuk por muito tempo! 📖"
        };

        System.out.println("📖 BEM-VINDO AO QUIZ DE DEATH NOTE! 📖");
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
