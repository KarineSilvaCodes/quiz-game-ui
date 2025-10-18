package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Nanatsu {

    private List<Pergunta> perguntas;
    private Random random;

    public Nanatsu() {
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
                "Quem é o líder dos Sete Pecados Capitais?",
                new String[]{"Meliodas", "Ban", "King", "Escanor"},
                0,
                new String[]{
                        "Ops! Ban é forte, mas não lidera!",
                        "Correto! Meliodas comanda o grupo!",
                        "King cuida da floresta, não lidera!",
                        "Escanor brilha, mas não lidera!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual é o poder de Ban?",
                new String[]{"Imortalidade", "Manipulação de Fogo", "Controle da Floresta", "Transformação Divina"},
                0,
                new String[]{
                        "Acertou! Ban é imortal!",
                        "Fogo? Isso é Escanor às vezes!",
                        "Controle da floresta? King é que faz isso!",
                        "Transformação divina? Só Escanor no auge!"
                }
        ));
        perguntas.add(new Pergunta(
                "Quem é conhecido como o 'Orgulho do Pecado do Sol'?",
                new String[]{"Escanor", "Meliodas", "Diane", "Gowther"},
                0,
                new String[]{
                        "Correto! Escanor brilha com orgulho!",
                        "Meliodas tem o pecado da Ira!",
                        "Diane é da Inveja! Quase!",
                        "Gowther é do Pecado da Luxúria!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual é o pecado de Diane?",
                new String[]{"Inveja", "Ira", "Gula", "Avareza"},
                0,
                new String[]{
                        "Correto! Diane é do Pecado da Inveja!",
                        "Ira é do Meliodas!",
                        "Gula não é dela!",
                        "Avareza? Esse não é nenhum dos principais!"
                }
        ));
        perguntas.add(new Pergunta(
                "Quem é o mago do grupo?",
                new String[]{"Gowther", "King", "Ban", "Escanor"},
                0,
                new String[]{
                        "Correto! Gowther é o mago!",
                        "King é o Rei da Floresta!",
                        "Ban é imortal, não mago!",
                        "Escanor é força bruta!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual membro é conhecido por sua força sobre-humana durante o dia?",
                new String[]{"Escanor", "Meliodas", "Ban", "Diane"},
                0,
                new String[]{
                        "Correto! Escanor brilha ao sol!",
                        "Meliodas é forte, mas não depende do sol!",
                        "Ban é imortal, não solário!",
                        "Diane é gigante, mas não brilha!"
                }
        ));
        perguntas.add(new Pergunta(
                "Quem foi ressuscitado pelo Rei Demônio?",
                new String[]{"Meliodas", "Escanor", "Ban", "King"},
                0,
                new String[]{
                        "Acertou! Meliodas tem ligação com o Rei Demônio!",
                        "Escanor não foi ressuscitado!",
                        "Ban é imortal, não precisa disso!",
                        "King não foi ressuscitado!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual é o objetivo principal do grupo?",
                new String[]{"Salvar o reino de Liones", "Dominar o mundo", "Encontrar o One Piece", "Roubar tesouros"},
                0,
                new String[]{
                        "Correto! Eles protegem Liones!",
                        "Dominar o mundo? Nada a ver!",
                        "One Piece é outro anime!",
                        "Tesouros? Não é o foco deles!"
                }
        ));
        perguntas.add(new Pergunta(
                "Qual personagem é imortal e irreverente?",
                new String[]{"Ban", "Meliodas", "King", "Gowther"},
                0,
                new String[]{
                        "Correto! Ban é irreverente e imortal!",
                        "Meliodas é poderoso, mas não irreverente assim!",
                        "King é tímido!",
                        "Gowther é lógico, não irreverente!"
                }
        ));
        perguntas.add(new Pergunta(
                "Quem é o Rei da Floresta?",
                new String[]{"King", "Escanor", "Meliodas", "Diane"},
                0,
                new String[]{
                        "Correto! King protege a floresta!",
                        "Escanor brilha, mas não é rei da floresta!",
                        "Meliodas comanda o grupo, mas não é rei da floresta!",
                        "Diane é gigante, mas não rei!"
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
        Nanatsu quiz = new Nanatsu();
        Pergunta p;
        int acertos = 0, total = 0;
        Scanner scanner = new Scanner(System.in);
        Random randFinal = new Random();

        String[] feedbacksFinal = {
            "Você sobreviveu aos Sete Pecados! 😎",
            "Eita! Quase virou banquete dos demônios! 😂",
            "Parabéns, herói de Liones! 🏰",
            "Não foi perfeito, mas pelo menos não morreu! 😏",
            "Fim do quiz! Que os Sete Pecados te protejam! ⚔️"
        };

        System.out.println("⚔️ BEM-VINDO AO QUIZ NANATSU NO TAISAI! ⚔️");
        System.out.println("--------------------------------------");

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
