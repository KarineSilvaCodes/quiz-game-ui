package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TokyoGhoulUI extends JFrame {

    private ArrayList<Pergunta> perguntas = new ArrayList<>();
    private int pontuacao = 0;
    private Random random = new Random();
    private int perguntaAtual = 0;
    private int tempoRestante = 15;
    private Timer timerContador;
    private Timer timerDelay;

    private JLabel lblPergunta;
    private JButton[] btnOpcoes = new JButton[4];
    private JLabel lblFeedback;
    private JLabel lblPontuacao;
    private JLabel lblTempo;

    public TokyoGhoulUI() {
        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } catch (Exception ignored) {}

        setTitle("🩸 Quiz Tokyo Ghoul");
        setSize(760, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 245, 230));

        // Painel da pergunta
        JPanel painelPergunta = new JPanel(new BorderLayout());
        painelPergunta.setBackground(new Color(255, 200, 120));
        painelPergunta.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblPergunta = new JLabel("", SwingConstants.CENTER);
        lblPergunta.setFont(new Font("Arial", Font.BOLD, 20));
        lblPergunta.setForeground(new Color(80, 40, 0));
        painelPergunta.add(lblPergunta, BorderLayout.CENTER);

        lblTempo = new JLabel("⏳ 15s", SwingConstants.RIGHT);
        lblTempo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTempo.setForeground(new Color(255, 180, 50));
        painelPergunta.add(lblTempo, BorderLayout.EAST);

        add(painelPergunta, BorderLayout.NORTH);

        // Painel das opções
        JPanel painelOpcoes = new JPanel(new GridBagLayout());
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        painelOpcoes.setBackground(new Color(255, 245, 230));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        for (int i = 0; i < 4; i++) {
            JButton botao = new JButton();
            botao.setFont(new Font("Arial", Font.PLAIN, 15));
            botao.setFocusPainted(false);
            botao.setBackground(new Color(255, 220, 180));
            botao.setForeground(new Color(80, 40, 0));
            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

            botao.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(255, 180, 100), 2, true),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));

            botao.setPreferredSize(new Dimension(300, 50));

            botao.addMouseListener(new MouseAdapter() {
                @Override public void mouseEntered(MouseEvent e) { botao.setBackground(new Color(255, 200, 120)); }
                @Override public void mouseExited(MouseEvent e) { botao.setBackground(new Color(255, 220, 180)); }
            });

            int finalI = i;
            botao.setActionCommand(String.valueOf(finalI));
            botao.addActionListener(e -> verificarResposta(Integer.parseInt(botao.getActionCommand())));

            btnOpcoes[i] = botao;
            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            painelOpcoes.add(botao, gbc);
        }

        add(painelOpcoes, BorderLayout.CENTER);

        // Painel inferior
        JPanel painelInferior = new JPanel(new BorderLayout());
        painelInferior.setBackground(new Color(255, 245, 230));

        lblFeedback = new JLabel("", SwingConstants.CENTER);
        lblFeedback.setFont(new Font("Arial", Font.ITALIC, 16));

        lblPontuacao = new JLabel("Pontuação: 0/10", SwingConstants.CENTER);
        lblPontuacao.setFont(new Font("Arial", Font.BOLD, 14));
        lblPontuacao.setForeground(new Color(160, 80, 0));

        painelInferior.add(lblFeedback, BorderLayout.CENTER);
        painelInferior.add(lblPontuacao, BorderLayout.SOUTH);

        add(painelInferior, BorderLayout.SOUTH);

        iniciarQuiz();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarQuiz() {
        perguntas = gerarPerguntasTokyo();
        Collections.shuffle(perguntas);
        pontuacao = 0;
        perguntaAtual = 0;
        mostrarPergunta();
    }

    private void mostrarPergunta() {
        if (perguntaAtual < 10) {
            Pergunta p = perguntas.get(perguntaAtual);
            lblPergunta.setText("<html><center>Pergunta " + (perguntaAtual+1) + ": " + p.getPergunta() + "</center></html>");
            String[] opcoes = p.getOpcoes();
            for (int i = 0; i < 4; i++) {
                btnOpcoes[i].setText((i + 1) + ") " + opcoes[i]);
                btnOpcoes[i].setEnabled(true);
                btnOpcoes[i].setBackground(new Color(255, 220, 180));
            }
            lblFeedback.setText("");
            iniciarContador();
        } else {
            mostrarResultadoFinal();
        }
    }

    private void iniciarContador() {
        tempoRestante = 15;
        lblTempo.setText(tempoRestante + "s");
        if (timerContador != null) timerContador.stop();

        timerContador = new Timer(1000, e -> {
            tempoRestante--;
            lblTempo.setText(tempoRestante + "s");
            if (tempoRestante <= 0) {
                ((Timer)e.getSource()).stop();
                Pergunta p = perguntas.get(perguntaAtual);
                lblFeedback.setForeground(Color.RED);
                lblFeedback.setText("<html><center>Tempo esgotado! <br>➡ Resposta correta: " +
                        p.getOpcoes()[p.getIndiceCorreto()] + "</center></html>");
                for (JButton btn : btnOpcoes) btn.setEnabled(false);
                avancarPergunta();
            }
        });
        timerContador.start();
    }

    private void verificarResposta(int idx) {
        timerContador.stop();
        Pergunta p = perguntas.get(perguntaAtual);
        if (idx == p.getIndiceCorreto()) {
            pontuacao++;
            lblFeedback.setForeground(new Color(34, 139, 34));
            lblFeedback.setText("<html><center>" + p.getFeedback(true) + "</center></html>");
            btnOpcoes[idx].setBackground(new Color(144, 238, 144));
        } else {
            lblFeedback.setForeground(Color.RED);
            lblFeedback.setText("<html><center>" + p.getFeedback(false) + "<br>➡ Resposta correta: " +
                    p.getOpcoes()[p.getIndiceCorreto()] + "</center></html>");
            btnOpcoes[idx].setBackground(new Color(255, 99, 71));
            btnOpcoes[p.getIndiceCorreto()].setBackground(new Color(144, 238, 144));
        }
        lblPontuacao.setText("Pontuação: " + pontuacao + "/10");
        for (JButton btn : btnOpcoes) btn.setEnabled(false);
        avancarPergunta();
    }

    private void avancarPergunta() {
        timerDelay = new Timer(1500, e -> {
            perguntaAtual++;
            mostrarPergunta();
            timerDelay.stop();
        });
        timerDelay.start();
    }

    private void mostrarResultadoFinal() {
        double percentual = (pontuacao / 10.0) * 100;
        String[] feedbacksFinal = {
            "Você está pronto para ser um investigador! 🕵️‍♂️",
            "Cuidado para não virar um ghoul! 👀",
            "Quase lá, mas treine mais com Kaneki!",
            "Boa, mas não olhe direto nos olhos de Ryuk… ops, quer dizer, ghoul 😅",
            "Fim do quiz! Sobreviveu à CCG e Aogiri! 🎯"
        };

        String resultadoHtml = "<html><center>" +
                "<span style='font-size:20px; font-weight:bold; color:#FF8C00;'>🩸 RESULTADO FINAL 🩸</span><br><br>" +
                "Você acertou <b>" + pontuacao + " de 10</b> perguntas!<br>" +
                String.format("<b>(%.0f%% de acertos)</b><br>", percentual) +
                "<i>" + feedbacksFinal[random.nextInt(feedbacksFinal.length)] + "</i><br><br>"  +
                "</center></html>";

        lblPergunta.setText(resultadoHtml);
        lblPergunta.setFont(new Font("Arial", Font.BOLD, 18));
        lblPergunta.setForeground(new Color(255, 140, 0));
        lblFeedback.setText("");
        lblTempo.setText("");

        for (JButton btn : btnOpcoes) btn.setVisible(false);

        lblPontuacao.setText("<html><center>Clique aqui para reiniciar</center></html>");
        lblPontuacao.setFont(new Font("Arial", Font.BOLD, 16));
        lblPontuacao.setForeground(new Color(255, 165, 0));
        lblPontuacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblPontuacao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { reiniciarQuiz(); }
            @Override
            public void mouseEntered(MouseEvent e) { lblPontuacao.setForeground(new Color(255, 140, 0)); }
            @Override
            public void mouseExited(MouseEvent e) { lblPontuacao.setForeground(new Color(255, 165, 0)); }
        });
    }

    private void reiniciarQuiz() {
        for (JButton btn : btnOpcoes) btn.setVisible(true);
        lblPontuacao.setText("Pontuação: 0/10");
        lblPontuacao.setCursor(Cursor.getDefaultCursor());
        lblPontuacao.removeMouseListener(lblPontuacao.getMouseListeners()[0]);
        iniciarQuiz();
    }

    private ArrayList<Pergunta> gerarPerguntasTokyo() {
        ArrayList<Pergunta> lista = new ArrayList<>();
        lista.add(new Pergunta("Quem é o protagonista de Tokyo Ghoul?",
                new String[]{"Kaneki Ken", "Touka Kirishima", "Nishiki Nishio", "Yamori"}, 0,
                new String[]{"Correto! Kaneki é o protagonista!", "Touka é importante, mas não protagonista!", "Nishiki é coadjuvante!", "Yamori é vilão!"}));
        lista.add(new Pergunta("Qual é o tipo de kagune de Kaneki?",
                new String[]{"Rinkaku", "Ukaku", "Koukaku", "Bikaku"}, 0,
                new String[]{"Correto! Kaneki tem Rinkaku!", "Ukaku é da Touka!", "Koukaku é de outros ghouls!", "Bikaku é de Nishiki!"}));
        lista.add(new Pergunta("Quem dirige o Anteiku?",
                new String[]{"Yoshimura", "Kanou", "Amon", "Hinami"}, 0,
                new String[]{"Correto! Yoshimura é o dono do café Anteiku!", "Kanou é cientista!", "Amon é investigador!", "Hinami é jovem ghoul!"}));
        lista.add(new Pergunta("Quem tortura Kaneki em seu treinamento?",
                new String[]{"Yamori", "Nishiki", "Touka", "Hinami"}, 0,
                new String[]{"Correto! Yamori é quem tortura Kaneki!", "Nishiki não tortura Kaneki!", "Touka não faz isso!", "Hinami não participa!"}));
        lista.add(new Pergunta("Qual é o apelido de Kaneki após a transformação?",
                new String[]{"Centipede", "One-Eyed King", "Black Reaper", "Dragon"}, 0,
                new String[]{"Correto! Centipede é o apelido dele!", "One-Eyed King aparece depois!", "Black Reaper não é Kaneki!", "Dragon não existe no contexto!"}));
        lista.add(new Pergunta("Qual investigador está sempre atrás dos ghouls?",
                new String[]{"Amon Koutarou", "Yoshimura", "Kanou", "Hinami"}, 0,
                new String[]{"Correto! Amon é investigador!", "Yoshimura é dono do café!", "Kanou é cientista!", "Hinami é ghoul!"}));
        lista.add(new Pergunta("Quem é a melhor amiga e aliada de Kaneki?",
                new String[]{"Touka Kirishima", "Hinami", "Nishiki", "Rize Kamishiro"}, 0,
                new String[]{"Correto! Touka é a aliada!", "Hinami é amiga, mas mais nova!", "Nishiki é rival/aliado depois!", "Rize desencadeia o problema, mas não aliada!"}));
        lista.add(new Pergunta("Quem é o ghoul que Kaneki come depois de ser capturado?",
                new String[]{"Rize Kamishiro", "Yamori", "Shinohara", "Uta"}, 0,
                new String[]{"Correto! Rize é o ghoul que inicia a transformação!", "Yamori tortura depois!", "Shinohara é investigador!", "Uta é dono da loja de máscaras!"}));
        lista.add(new Pergunta("O que é um quinque?",
                new String[]{"Arma feita a partir de ghoul", "Tipo de kagune", "Investigator Rank", "Shinigami Tool"}, 0,
                new String[]{"Correto! Arma feita a partir de ghoul!", "Não, tipo de kagune é diferente!", "Investigator Rank é outra coisa!", "Shinigami Tool é de outro anime!"}));
        lista.add(new Pergunta("Qual grupo de ghouls quer dominar a cidade?",
                new String[]{"Aogiri Tree", "Anteiku", "CCG", "Clowns"}, 0,
                new String[]{"Correto! Aogiri Tree quer dominar!", "Anteiku é pacífico!", "CCG é investigador!", "Clowns é grupo caótico, mas não domina!"}));
        Collections.shuffle(lista);
        return lista;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TokyoGhoulUI::new);
    }

    static class Pergunta {
        private final String pergunta;
        private final String[] opcoes;
        private final int indiceCorreto;
        private final String[] feedbacks;

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
            do { i = new Random().nextInt(feedbacks.length); } while (i == indiceCorreto);
            return feedbacks[i];
        }
    }
}
