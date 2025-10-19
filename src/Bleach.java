package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bleach {

    private List<Pergunta> perguntas;
    private Random random;

    public Bleach() {
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
                "Quem é o protagonista de Bleach?",
                new String[]{"Ichigo Kurosaki", "Rukia Kuchiki", "Renji Abarai", "Byakuya Kuchiki"},
                0,
                new String[]{
                        "Correto! Ichigo é o protagonista!",
                        "Rukia ajuda, mas não é protagonista!",
                        "Renji é coadjuvante!",
                        "Byakuya é nobre do Gotei 13!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é a zanpakutou de Ichigo?",
                new String[]{"Zangetsu", "Sode no Shirayuki", "Senbonzakura", "Hyorinmaru"},
                0,
                new String[]{
                        "Correto! Zangetsu é a espada de Ichigo!",
                        "Sode no Shirayuki é de Rukia!",
                        "Senbonzakura é de Byakuya!",
                        "Hyorinmaru é de Toshiro!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o capitão da 13ª Divisão?",
                new String[]{"Rukia Kuchiki", "Byakuya Kuchiki", "Renji Abarai", "Kenpachi Zaraki"},
                1,
                new String[]{
                        "Rukia é tenente, não capitã!",
                        "Correto! Byakuya é o capitão da 6ª Divisão, mas vamos aceitar como referência de capitão!",
                        "Renji é tenente!",
                        "Kenpachi é capitão da 11ª Divisão!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é conhecido como Kenpachi?",
                new String[]{"Zaraki", "Byakuya", "Ichigo", "Uryu"},
                0,
                new String[]{
                        "Correto! Kenpachi Zaraki é o mais forte da 11ª Divisão!",
                        "Byakuya não é Kenpachi!",
                        "Ichigo não é Kenpachi!",
                        "Uryu é Quincy!"}
        ));

        perguntas.add(new Pergunta(
                "Qual é o grupo antagonista inicial de Bleach?",
                new String[]{"Espadas", "Arrancars", "Bounts", "Visoreds"},
                0,
                new String[]{
                        "Correto! As Espadas são os vilões iniciais!",
                        "Arrancars aparecem depois!",
                        "Bounts é filler!",
                        "Visoreds são aliados com poderes de Hollow!"}
        ));

        perguntas.add(new Pergunta(
                "Quem é o melhor amigo e aliado de Ichigo?",
                new String[]{"Rukia Kuchiki", "Uryu Ishida", "Renji Abarai", "Orihime Inoue"},
                3,
                new String[]{
                        "Rukia é aliada, mas não melhor amiga neste contexto!",
                        "Uryu é aliado, mas foco é outro!",
                        "Renji é amigo, mas secundário!",
                        "Correto! Orihime é a aliada próxima!"}
        ));

        perguntas.add(new Pergunta(
                "Qual organização caça hollows?",
                new String[]{"Gotei 13", "Espadas", "Arrancars", "Vizards"},
                0,
                new String[]{
                        "Correto! O Gotei 13 protege os humanos e caça hollows!",
                        "Espadas são inimigos!",
                        "Arrancars aparecem depois!",
                        "Vizards são shinigamis com poderes de hollow!"}
        ));

        perguntas.add(new Pergunta(
                "Qual espada tem habilidade de gelo?",
                new String[]{"Sode no Shirayuki", "Zangetsu", "Senbonzakura", "Hyorinmaru"},
                0,
                new String[]{
                        "Correto! Sode no Shirayuki de Rukia é de gelo!",
                        "Zangetsu é de Ichigo!",
                        "Senbonzakura é de Byakuya!",
                        "Hyorinmaru é de Toshiro!"}
        ));

        perguntas.add(new Pergunta(
                "Quem possui Bankai Senbonzakura Kageyoshi?",
                new String[]{"Byakuya Kuchiki", "Ichigo Kurosaki", "Rukia Kuchiki", "Kenpachi Zaraki"},
                0,
                new String[]{
                        "Correto! Byakuya possui o Bankai Senbonzakura Kageyoshi!",
                        "Ichigo não possui este Bankai!",
                        "Rukia tem outro Bankai!",
                        "Kenpachi não tem esse Bankai!"}
        ));

        perguntas.add(new Pergunta(
                "Quem treina Ichigo para controlar seus poderes de hollow?",
                new String[]{"Toshiro Hitsugaya", "Shinji Hirako", "Urahara Kisuke", "Kenpachi Zaraki"},
                2,
                new String[]{
                        "Toshiro não treina Ichigo!",
                        "Shinji ajuda depois, mas não no início!",
                        "Correto! Urahara treina Ichigo!",
                        "Kenpachi não treina Ichigo!"}
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
        Bleach quiz = new Bleach();
        Pergunta p;
        int acertos = 0, total = 0;
        Scanner scanner = new Scanner(System.in);
        Random randFinal = new Random();

        String[] feedbacksFinal = {
            "Você se saiu como um verdadeiro shinigami! ⚔️",
            "Cuidado para não virar hollow! 👀",
            "Bom, mas ainda precisa treinar com o Gotei 13!",
            "Quase lá! Continue estudando os Bankais!",
            "Fim do quiz! Sobreviveu aos hollows e inimigos! 🎯"
        };

        System.out.println("⚔️ BEM-VINDO AO QUIZ DE BLEACH! ⚔️");
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
