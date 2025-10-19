package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BleachUI extends JFrame {

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

    public BleachUI() {
        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } catch (Exception ignored) {}

        setTitle("⚔️ Quiz de Bleach - Mostre que é um verdadeiro Shinigami!");
        setSize(760, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 235, 200)); // mesma cor do NarutoUI

        // Painel da pergunta
        JPanel painelPergunta = new JPanel(new BorderLayout());
        painelPergunta.setBackground(new Color(255, 170, 85)); // mesma cor laranja do NarutoUI
        painelPergunta.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblPergunta = new JLabel("", SwingConstants.CENTER);
        lblPergunta.setFont(new Font("Arial", Font.BOLD, 20));
        lblPergunta.setForeground(Color.WHITE);
        painelPergunta.add(lblPergunta, BorderLayout.CENTER);

        lblTempo = new JLabel("⏳ 15s", SwingConstants.RIGHT);
        lblTempo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTempo.setForeground(new Color(255, 255, 100));
        painelPergunta.add(lblTempo, BorderLayout.EAST);

        add(painelPergunta, BorderLayout.NORTH);

        // Painel das opções
        JPanel painelOpcoes = new JPanel(new GridBagLayout());
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        painelOpcoes.setBackground(new Color(255, 235, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;

        for (int i = 0; i < 4; i++) {
            JButton botao = new JButton();
            botao.setFont(new Font("Arial", Font.PLAIN, 15));
            botao.setFocusPainted(false);
            botao.setBackground(new Color(210, 230, 255));
            botao.setForeground(Color.DARK_GRAY);
            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botao.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(180, 200, 255), 2, true),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)));
            botao.setPreferredSize(new Dimension(300, 50));

            botao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) { botao.setBackground(new Color(180, 210, 255)); }
                @Override
                public void mouseExited(MouseEvent e) { botao.setBackground(new Color(210, 230, 255)); }
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
        painelInferior.setBackground(new Color(255, 235, 200));

        lblFeedback = new JLabel("", SwingConstants.CENTER);
        lblFeedback.setFont(new Font("Arial", Font.ITALIC, 16));

        lblPontuacao = new JLabel("Pontuação: 0/10", SwingConstants.CENTER);
        lblPontuacao.setFont(new Font("Arial", Font.BOLD, 14));
        lblPontuacao.setForeground(new Color(0, 102, 204));

        painelInferior.add(lblFeedback, BorderLayout.CENTER);
        painelInferior.add(lblPontuacao, BorderLayout.SOUTH);

        add(painelInferior, BorderLayout.SOUTH);

        carregarPerguntas();
        iniciarQuiz();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarQuiz() {
        Collections.shuffle(perguntas);
        pontuacao = 0;
        perguntaAtual = 0;
        mostrarPergunta();
    }

    private void mostrarPergunta() {
        if (perguntaAtual < perguntas.size()) {
            Pergunta p = perguntas.get(perguntaAtual);
            lblPergunta.setText("<html><center>Pergunta " + (perguntaAtual + 1) + ": " + p.getPergunta() + "</center></html>");
            String[] opcoes = p.getOpcoes();
            for (int i = 0; i < 4; i++) {
                btnOpcoes[i].setText((i + 1) + ") " + opcoes[i]);
                btnOpcoes[i].setEnabled(true);
                btnOpcoes[i].setBackground(new Color(210, 230, 255));
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
                ((Timer) e.getSource()).stop();
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
        lblPontuacao.setText("Pontuação: " + pontuacao + "/" + perguntas.size());
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
        double percentual = (pontuacao / (double) perguntas.size()) * 100;

        String[] feedbacksFinal = {
            "Você se saiu como um verdadeiro shinigami! ⚔️",
            "Cuidado para não virar hollow! 👀",
            "Bom, mas ainda precisa treinar com o Gotei 13!",
            "Quase lá! Continue estudando os Bankais!",
            "Fim do quiz! Sobreviveu aos hollows e inimigos! 🎯"
        };

        String resultadoHtml = "<html><center>" +
                "<span style='font-size:20px; font-weight:bold; color:#FF6347;'>⚔️ RESULTADO FINAL ⚔️</span><br><br>" +
                "Você acertou <b>" + pontuacao + " de " + perguntas.size() + "</b> perguntas!<br>" +
                String.format("<b>(%.0f%% de acertos)</b><br>", percentual) +
                "<i>" + feedbacksFinal[random.nextInt(feedbacksFinal.length)] + "</i><br><br>"  +
                "</center></html>";

        lblPergunta.setText(resultadoHtml);
        lblPergunta.setFont(new Font("Arial", Font.BOLD, 18));
        lblPergunta.setForeground(new Color(255, 69, 0));
        lblFeedback.setText("");
        lblTempo.setText("");

        for (JButton btn : btnOpcoes) btn.setVisible(false);

        lblPontuacao.setText("<html><center>Clique aqui para reiniciar</center></html>");
        lblPontuacao.setFont(new Font("Arial", Font.BOLD, 16));
        lblPontuacao.setForeground(new Color(30, 144, 255));
        lblPontuacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblPontuacao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) { reiniciarQuiz(); }
            @Override
            public void mouseEntered(MouseEvent e) { lblPontuacao.setForeground(new Color(65, 105, 225)); }
            @Override
            public void mouseExited(MouseEvent e) { lblPontuacao.setForeground(new Color(30, 144, 255)); }
        });
    }

    private void reiniciarQuiz() {
        for (JButton btn : btnOpcoes) btn.setVisible(true);
        lblPontuacao.setText("Pontuação: 0/" + perguntas.size());
        lblPontuacao.setCursor(Cursor.getDefaultCursor());
        lblPontuacao.removeMouseListener(lblPontuacao.getMouseListeners()[0]);
        iniciarQuiz();
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
        // Continue adicionando todas as perguntas do Bleach
        Collections.shuffle(perguntas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BleachUI::new);
    }

    static class Pergunta {
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
            do { i = new Random().nextInt(feedbacks.length); } while (i == indiceCorreto);
            return feedbacks[i];
        }
    }
}
