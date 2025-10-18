import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizGameUi extends JFrame {

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

    public QuizGameUi() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {
        }

        setTitle("🍥 Quiz de Naruto - Prove que é um verdadeiro ninja!");
        setSize(760, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 235, 200));

        // Painel da pergunta
        JPanel painelPergunta = new JPanel(new BorderLayout());
        painelPergunta.setBackground(new Color(255, 170, 85));
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

        // Painel das opções (melhorado)
        JPanel painelOpcoes = new JPanel(new GridBagLayout());
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        painelOpcoes.setBackground(new Color(255, 235, 200));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // espaçamento entre os botões
        gbc.fill = GridBagConstraints.NONE; // não estica automaticamente

        for (int i = 0; i < 4; i++) {
            JButton botao = new JButton();
            botao.setFont(new Font("Arial", Font.PLAIN, 15));
            botao.setFocusPainted(false);
            botao.setBackground(new Color(210, 230, 255));
            botao.setForeground(Color.DARK_GRAY);
            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Bordas arredondadas
            botao.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(180, 200, 255), 2, true),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)));

            // Tamanho preferido menor e mais retangular
            botao.setPreferredSize(new Dimension(300, 50));

            // Efeito hover
            botao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    botao.setBackground(new Color(180, 210, 255));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    botao.setBackground(new Color(210, 230, 255));
                }
            });

            int finalI = i;
            botao.setActionCommand(String.valueOf(finalI));
            botao.addActionListener(e -> verificarResposta(Integer.parseInt(botao.getActionCommand())));

            btnOpcoes[i] = botao;

            // Posiciona os botões em 2x2
            gbc.gridx = i % 2; // coluna
            gbc.gridy = i / 2; // linha
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

        iniciarQuiz();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarQuiz() {
        perguntas = gerarPerguntasNaruto();
        Collections.shuffle(perguntas);
        pontuacao = 0;
        perguntaAtual = 0;
        mostrarPergunta();
    }

    private void mostrarPergunta() {
        if (perguntaAtual < 10) {
            Pergunta p = perguntas.get(perguntaAtual);
            lblPergunta.setText(
                    "<html><center>Pergunta " + (perguntaAtual + 1) + ": " + p.getTexto() + "</center></html>");
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
        tempoRestante = 1005;
        lblTempo.setText("⏳ " + tempoRestante + "s");
        if (timerContador != null)
            timerContador.stop();

        timerContador = new Timer(1000, e -> {
            tempoRestante--;
            lblTempo.setText("⏳ " + tempoRestante + "s");
            if (tempoRestante <= 0) {
                ((Timer) e.getSource()).stop();
                lblFeedback.setForeground(Color.RED);
                lblFeedback.setText("<html><center>Tempo esgotado! ⏳<br>➡ Resposta correta: " +
                        perguntas.get(perguntaAtual).getOpcoes()[perguntas.get(perguntaAtual).getCorreta()]
                        + "</center></html>");
                for (JButton btn : btnOpcoes)
                    btn.setEnabled(false);
                avancarPergunta();
            }
        });
        timerContador.start();
    }

    private void verificarResposta(int idx) {
        timerContador.stop();
        Pergunta p = perguntas.get(perguntaAtual);
        if (idx == p.getCorreta()) {
            pontuacao++;
            lblFeedback.setForeground(new Color(34, 139, 34));
            lblFeedback.setText("<html><center>" + respostaCertaAleatoria() + "</center></html>");
            btnOpcoes[idx].setBackground(new Color(144, 238, 144));
        } else {
            lblFeedback.setForeground(Color.RED);
            lblFeedback.setText("<html><center>" + respostaErradaAleatoria() +
                    "<br>➡ Resposta correta: " + p.getOpcoes()[p.getCorreta()] + "</center></html>");
            btnOpcoes[idx].setBackground(new Color(255, 99, 71));
            btnOpcoes[p.getCorreta()].setBackground(new Color(144, 238, 144));
        }
        lblPontuacao.setText("Pontuação: " + pontuacao + "/10");
        for (JButton btn : btnOpcoes)
            btn.setEnabled(false);
        avancarPergunta();
    }

    private void avancarPergunta() {
        timerDelay = new Timer(100, e -> {
            perguntaAtual++;
            mostrarPergunta();
            timerDelay.stop();
        });
        timerDelay.start();
    }

    private void mostrarResultadoFinal() {
    double percentual = (pontuacao / 10.0) * 100;

    // Configura o painel de resultado
    JPanel painelResultado = new JPanel(new BorderLayout());
    painelResultado.setBackground(new Color(255, 239, 213)); // Tom creme suave
    painelResultado.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 140, 0), 4, true), // Borda laranja arredondada
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
    ));

    // Texto do resultado em HTML
    String resultadoHtml = "<html><center>" +
            "<span style='font-size:20px; font-weight:bold; color:#FF6347;'>🍥 RESULTADO FINAL 🍥</span><br><br>" +
            "Você acertou <b>" + pontuacao + " de 10</b> perguntas!<br>" +
            String.format("<b>(%.0f%% de acertos)</b><br>", percentual) +
            "<i>" + comentarioFinal(percentual) + "</i><br><br>"  +
            "</center></html>";

    lblPergunta.setText(resultadoHtml);
    lblPergunta.setFont(new Font("Arial", Font.BOLD, 18));
    lblPergunta.setForeground(new Color(255, 69, 0)); // Laranja avermelhado
    lblFeedback.setText("");
    lblTempo.setText("");

    // Oculta os botões de opção
    for (JButton btn : btnOpcoes) {
        btn.setVisible(false);
    }

    // Configura o label de pontuação como botão de reinício
    lblPontuacao.setText("<html><center>Clique aqui para reiniciar</center></html>");
    lblPontuacao.setFont(new Font("Arial", Font.BOLD, 16));
    lblPontuacao.setForeground(new Color(30, 144, 255));
    lblPontuacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblPontuacao.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            reiniciarQuiz();
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            lblPontuacao.setForeground(new Color(65, 105, 225));
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            lblPontuacao.setForeground(new Color(30, 144, 255));
        }
    });
}


    private void reiniciarQuiz() {
        for (JButton btn : btnOpcoes)
            btn.setVisible(true);
        lblPontuacao.setText("Pontuação: 0/10");
        lblPontuacao.setCursor(Cursor.getDefaultCursor());
        lblPontuacao.removeMouseListener(lblPontuacao.getMouseListeners()[0]);
        iniciarQuiz();
    }

    // === Perguntas originais ===
    private ArrayList<Pergunta> gerarPerguntasNaruto() {
        ArrayList<Pergunta> lista = new ArrayList<>();
        lista.add(new Pergunta("Qual o nome completo do Naruto?",
                new String[] { "Naruto Uchiha", "Naruto Uzumaki", "Naruto Hatake", "Naruto Haruno" }, 1));
        lista.add(new Pergunta("Quem é o melhor amigo do Naruto?", new String[] { "Sasuke", "Neji", "Kiba", "Gaara" },
                0));
        lista.add(new Pergunta("Qual é o nome da raposa de nove caudas selada em Naruto?",
                new String[] { "Kurama", "Gyūki", "Shukaku", "Matatabi" }, 0));
        lista.add(new Pergunta("Quem treinou o Naruto após a luta com Sasuke no Vale do Fim?",
                new String[] { "Jiraiya", "Kakashi", "Iruka", "Minato" }, 0));
        lista.add(new Pergunta("Quem é o pai do Naruto?", new String[] { "Hashirama", "Tobirama", "Minato", "Hiruzen" },
                2));
        lista.add(new Pergunta("Qual é o sonho do Naruto?",
                new String[] { "Ser Hokage", "Ser o ninja mais forte do mundo", "Ser um herói", "Casar com a Hinata" },
                0));
        lista.add(
                new Pergunta("Quem era o sensei do Time 7?", new String[] { "Asuma", "Kurenai", "Kakashi", "Guy" }, 2));
        lista.add(new Pergunta("Qual é o nome da mãe do Naruto?",
                new String[] { "Kushina Uzumaki", "Mikoto Uchiha", "Kaguya Otsutsuki", "Tsunade" }, 0));
        lista.add(new Pergunta("Quem matou o Jiraiya?", new String[] { "Pain", "Itachi", "Madara", "Obito" }, 0));
        lista.add(new Pergunta("Qual é a vila natal do Naruto?",
                new String[] { "Vila da Areia", "Vila da Nuvem", "Vila da Folha", "Vila da Névoa" }, 2));
        return lista;
    }

    private String respostaCertaAleatoria() {
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

    private String respostaErradaAleatoria() {
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

    private String comentarioFinal(double pct) {
        if (pct == 100)
            return "Você é o próprio Sábio dos Seis Caminhos!";
        if (pct >= 80)
            return "Quase um Hokage! 🏆";
        if (pct >= 50)
            return "Bom, mas ainda precisa treinar com o Jiraiya!";
        return "Nem o Naruto no começo do anime errava tanto 😅";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizGameUi::new);
    }
}

class Pergunta {
    private final String texto;
    private final String[] opcoes;
    private final int correta;

    public Pergunta(String texto, String[] opcoes, int correta) {
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
