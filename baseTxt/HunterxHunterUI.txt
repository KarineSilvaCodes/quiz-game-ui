package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HunterxHunterUI extends JFrame {

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

    public HunterxHunterUI() {
        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } catch (Exception ignored) {}

        setTitle("🎯 Quiz Hunter x Hunter");
        setSize(760, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 245, 230)); // fundo laranja claro igual Naruto

        // Painel da pergunta
        JPanel painelPergunta = new JPanel(new BorderLayout());
        painelPergunta.setBackground(new Color(255, 200, 120)); // laranja médio
        painelPergunta.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblPergunta = new JLabel("", SwingConstants.CENTER);
        lblPergunta.setFont(new Font("Arial", Font.BOLD, 20));
        lblPergunta.setForeground(new Color(80, 40, 0)); // texto marrom escuro
        painelPergunta.add(lblPergunta, BorderLayout.CENTER);

        lblTempo = new JLabel("⏳ 15s", SwingConstants.RIGHT);
        lblTempo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTempo.setForeground(new Color(255, 180, 50)); // amarelo do timer
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
            botao.setBackground(new Color(255, 220, 180)); // cor inicial igual Naruto
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
        perguntas = gerarPerguntasHunterxHunter();
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
            lblFeedback.setForeground(new Color(34, 139, 34)); // verde acerto
            lblFeedback.setText("<html><center>" + p.getFeedback(true) + "</center></html>");
            btnOpcoes[idx].setBackground(new Color(144, 238, 144));
        } else {
            lblFeedback.setForeground(Color.RED); // vermelho erro
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
            "Você está quase no nível de caçador! 🏹",
            "Continue treinando seu Nen!",
            "Muito bem! Mas não subestime os inimigos!",
            "Parabéns! Sobreviveu a todas as provas!",
            "Fim do quiz! Seu cosmo de caçador está elevado! ⚡"
        };

        String resultadoHtml = "<html><center>" +
                "<span style='font-size:20px; font-weight:bold; color:#FF8C00;'>🎯 RESULTADO FINAL 🎯</span><br><br>" +
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

    private ArrayList<Pergunta> gerarPerguntasHunterxHunter() {
        ArrayList<Pergunta> lista = new ArrayList<>();
        lista.add(new Pergunta("Quem é o protagonista da série?",
                new String[]{"Gon Freecss", "Killua Zoldyck", "Kurapika", "Leorio"}, 0,
                new String[]{"Correto! Gon é o protagonista!", "Killua é amigo e rival!", "Kurapika é aliado!", "Leorio é amigo!"}));
        lista.add(new Pergunta("Quem é da famosa família assassina Zoldyck?",
                new String[]{"Killua", "Gon", "Kurapika", "Leorio"}, 0,
                new String[]{"Correto! Killua é da família Zoldyck!", "Gon não é assassino!", "Kurapika não!", "Leorio não!"}));
        lista.add(new Pergunta("Qual personagem possui correntes para lutar?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"}, 0,
                new String[]{"Correto! Kurapika usa correntes!", "Gon usa força física!", "Killua usa eletricidade!", "Leorio usa socos!"}));
        lista.add(new Pergunta("Quem tem habilidades de eletricidade?",
                new String[]{"Killua", "Gon", "Kurapika", "Leorio"}, 0,
                new String[]{"Correto! Killua domina eletricidade!", "Gon não!", "Kurapika não!", "Leorio não!"}));
        lista.add(new Pergunta("Quem é o melhor amigo de Gon?",
                new String[]{"Killua", "Kurapika", "Leorio", "Hisoka"}, 0,
                new String[]{"Correto! Killua é o melhor amigo!", "Kurapika é aliado!", "Leorio é amigo!", "Hisoka é antagonista!"}));
        lista.add(new Pergunta("Quem é membro da Tropa Fantasma?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"}, 0,
                new String[]{"Correto! Kurapika luta contra a Tropa Fantasma!", "Gon não!", "Killua não!", "Leorio não!"}));
        lista.add(new Pergunta("Qual personagem quer se tornar um caçador para achar seu pai?",
                new String[]{"Gon", "Killua", "Kurapika", "Leorio"}, 0,
                new String[]{"Correto! Gon quer achar seu pai!", "Killua não!", "Kurapika não!", "Leorio não!"}));
        lista.add(new Pergunta("Quem é médico aspirante e amigo do grupo?",
                new String[]{"Leorio", "Gon", "Killua", "Kurapika"}, 0,
                new String[]{"Correto! Leorio quer ser médico!", "Gon não!", "Killua não!", "Kurapika não!"}));
        lista.add(new Pergunta("Quem luta para vingar seu clã Kurta?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"}, 0,
                new String[]{"Correto! Kurapika busca vingança!", "Gon não!", "Killua não!", "Leorio não!"}));
        lista.add(new Pergunta("Quem participa do Exame Hunter junto com Gon?",
                new String[]{"Killua", "Kurapika", "Leorio", "Hisoka"}, 0,
                new String[]{"Correto! Killua participa com Gon!", "Kurapika não participa!", "Leorio participa!", "Hisoka participa, mas como antagonista!"}));
        Collections.shuffle(lista);
        return lista;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HunterxHunterUI::new);
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
