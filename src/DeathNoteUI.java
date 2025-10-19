package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeathNoteUI extends JFrame {

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

    public DeathNoteUI() {
        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } catch (Exception ignored) {}

        setTitle("📖 Quiz Death Note");
        setSize(760, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(230, 230, 230));

        // Painel pergunta
        JPanel painelPergunta = new JPanel(new BorderLayout());
        painelPergunta.setBackground(new Color(50, 50, 50));
        painelPergunta.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblPergunta = new JLabel("", SwingConstants.CENTER);
        lblPergunta.setFont(new Font("Arial", Font.BOLD, 20));
        lblPergunta.setForeground(Color.WHITE);
        painelPergunta.add(lblPergunta, BorderLayout.CENTER);

        lblTempo = new JLabel("⏳ 15s", SwingConstants.RIGHT);
        lblTempo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTempo.setForeground(Color.YELLOW);
        painelPergunta.add(lblTempo, BorderLayout.EAST);

        add(painelPergunta, BorderLayout.NORTH);

        // Painel opções
        JPanel painelOpcoes = new JPanel(new GridBagLayout());
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        painelOpcoes.setBackground(new Color(230, 230, 230));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        for (int i = 0; i < 4; i++) {
            JButton botao = new JButton();
            botao.setFont(new Font("Arial", Font.PLAIN, 15));
            botao.setFocusPainted(false);
            botao.setBackground(new Color(200, 200, 200));
            botao.setForeground(Color.DARK_GRAY);
            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botao.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(150, 150, 150), 2, true),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)));
            botao.setPreferredSize(new Dimension(300, 50));

            int finalI = i;
            botao.setActionCommand(String.valueOf(finalI));
            botao.addActionListener(e -> verificarResposta(Integer.parseInt(botao.getActionCommand())));

            btnOpcoes[i] = botao;
            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            painelOpcoes.add(botao, gbc);

            botao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) { botao.setBackground(new Color(170, 170, 170)); }
                @Override
                public void mouseExited(MouseEvent e) { botao.setBackground(new Color(200, 200, 200)); }
            });
        }

        add(painelOpcoes, BorderLayout.CENTER);

        // Painel inferior
        JPanel painelInferior = new JPanel(new BorderLayout());
        painelInferior.setBackground(new Color(230, 230, 230));

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
                btnOpcoes[i].setBackground(new Color(200, 200, 200));
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
            "Kira ficaria orgulhoso! 😈",
            "Você sobreviveu sem escrever nomes no caderno! 😅",
            "Investigue mais, detetive! 🕵️‍♂️",
            "Acertou bastante, mas cuidado com Shinigamis! 👀",
            "Fim do quiz! Não olhe para Ryuk por muito tempo! 📖"
        };

        String resultadoHtml = "<html><center>" +
                "<span style='font-size:20px; font-weight:bold; color:#FF6347;'>📖 RESULTADO FINAL 📖</span><br><br>" +
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
        SwingUtilities.invokeLater(DeathNoteUI::new);
    }
}
