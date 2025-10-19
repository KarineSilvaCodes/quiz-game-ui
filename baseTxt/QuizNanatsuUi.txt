package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizNanatsuUi extends JFrame {

    private ArrayList<PerguntaNanatsu> perguntas;
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

    public QuizNanatsuUi() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        setTitle("⚔️ Quiz Nanatsu no Taizai ⚔️");
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

        // Painel das opções
        JPanel painelOpcoes = new JPanel(new GridBagLayout());
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        painelOpcoes.setBackground(new Color(255, 235, 200));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

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

        iniciarQuiz();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarQuiz() {
        perguntas = gerarPerguntasNanatsu();
        Collections.shuffle(perguntas);
        pontuacao = 0;
        perguntaAtual = 0;
        mostrarPergunta();
    }

    private void mostrarPergunta() {
        if (perguntaAtual < 10) {
            PerguntaNanatsu p = perguntas.get(perguntaAtual);
            lblPergunta.setText("<html><center>Pergunta " + (perguntaAtual + 1) + ": " + p.getTexto() + "</center></html>");
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
                PerguntaNanatsu p = perguntas.get(perguntaAtual);
                lblFeedback.setForeground(Color.RED);
                lblFeedback.setText("<html><center>Tempo esgotado! <br>➡ Resposta correta: " + 
                    p.getOpcoes()[p.getCorreta()] + "</center></html>");
                for (JButton btn : btnOpcoes) btn.setEnabled(false);
                avancarPergunta();
            }
        });
        timerContador.start();
    }

    private void verificarResposta(int idx) {
        timerContador.stop();
        PerguntaNanatsu p = perguntas.get(perguntaAtual);
        if (idx == p.getCorreta()) {
            pontuacao++;
            lblFeedback.setForeground(new Color(34, 139, 34));
            lblFeedback.setText("<html><center>" + p.getFeedback(true) + "</center></html>");
            btnOpcoes[idx].setBackground(new Color(144, 238, 144));
        } else {
            lblFeedback.setForeground(Color.RED);
            lblFeedback.setText("<html><center>" + p.getFeedback(false) +
                    "<br>➡ Resposta correta: " + p.getOpcoes()[p.getCorreta()] + "</center></html>");
            btnOpcoes[idx].setBackground(new Color(255, 99, 71));
            btnOpcoes[p.getCorreta()].setBackground(new Color(144, 238, 144));
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

        JPanel painelResultado = new JPanel(new BorderLayout());
        painelResultado.setBackground(new Color(255, 239, 213));
        painelResultado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 140, 0), 4, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        String resultadoHtml = "<html><center>" +
                "<span style='font-size:20px; font-weight:bold; color:#FF6347;'>⚔️ RESULTADO FINAL ⚔️</span><br><br>" +
                "Você acertou <b>" + pontuacao + " de 10</b> perguntas!<br>" +
                String.format("<b>(%.0f%% de acertos)</b><br>", percentual) +
                "<i>" + comentarioFinal(percentual) + "</i><br><br></center></html>";

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
        lblPontuacao.addMouseListener(new java.awt.event.MouseAdapter() {
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
        lblPontuacao.setText("Pontuação: 0/10");
        lblPontuacao.setCursor(Cursor.getDefaultCursor());
        lblPontuacao.removeMouseListener(lblPontuacao.getMouseListeners()[0]);
        iniciarQuiz();
    }

    private ArrayList<PerguntaNanatsu> gerarPerguntasNanatsu() {
        ArrayList<PerguntaNanatsu> lista = new ArrayList<>();
        lista.add(new PerguntaNanatsu("Quem é o líder dos Sete Pecados Capitais?",
                new String[]{"Meliodas", "Ban", "King", "Escanor"}, 0,
                new String[]{"Ops! Ban é forte, mas não lidera!", "Correto! Meliodas comanda o grupo!",
                        "King cuida da floresta, não lidera!", "Escanor brilha, mas não lidera!"} ));
        lista.add(new PerguntaNanatsu("Qual é o poder de Ban?",
                new String[]{"Imortalidade", "Manipulação de Fogo", "Controle da Floresta", "Transformação Divina"}, 0,
                new String[]{"Acertou! Ban é imortal!", "Fogo? Isso é Escanor às vezes!",
                        "Controle da floresta? King é que faz isso!", "Transformação divina? Só Escanor no auge!"} ));
        lista.add(new PerguntaNanatsu("Quem é conhecido como o 'Orgulho do Pecado do Sol'?",
                new String[]{"Escanor", "Meliodas", "Diane", "Gowther"}, 0,
                new String[]{"Correto! Escanor brilha com orgulho!", "Meliodas tem o pecado da Ira!",
                        "Diane é da Inveja! Quase!", "Gowther é do Pecado da Luxúria!"} ));
        lista.add(new PerguntaNanatsu("Qual é o pecado de Diane?",
                new String[]{"Inveja", "Ira", "Gula", "Avareza"}, 0,
                new String[]{"Correto! Diane é do Pecado da Inveja!", "Ira é do Meliodas!",
                        "Gula não é dela!", "Avareza? Esse não é nenhum dos principais!"} ));
        lista.add(new PerguntaNanatsu("Quem é o mago do grupo?",
                new String[]{"Gowther", "King", "Ban", "Escanor"}, 0,
                new String[]{"Correto! Gowther é o mago!", "King é o Rei da Floresta!", "Ban é imortal, não mago!",
                        "Escanor é força bruta!"} ));
        lista.add(new PerguntaNanatsu("Qual membro é conhecido por sua força sobre-humana durante o dia?",
                new String[]{"Escanor", "Meliodas", "Ban", "Diane"}, 0,
                new String[]{"Correto! Escanor brilha ao sol!", "Meliodas é forte, mas não depende do sol!",
                        "Ban é imortal, não solário!", "Diane é gigante, mas não brilha!"} ));
        lista.add(new PerguntaNanatsu("Quem foi ressuscitado pelo Rei Demônio?",
                new String[]{"Meliodas", "Escanor", "Ban", "King"}, 0,
                new String[]{"Acertou! Meliodas tem ligação com o Rei Demônio!", "Escanor não foi ressuscitado!",
                        "Ban é imortal, não precisa disso!", "King não foi ressuscitado!"} ));
        lista.add(new PerguntaNanatsu("Qual é o objetivo principal do grupo?",
                new String[]{"Salvar o reino de Liones", "Dominar o mundo", "Encontrar o One Piece", "Roubar tesouros"}, 0,
                new String[]{"Correto! Eles protegem Liones!", "Dominar o mundo? Nada a ver!",
                        "One Piece é outro anime!", "Tesouros? Não é o foco deles!"} ));
        lista.add(new PerguntaNanatsu("Qual personagem é imortal e irreverente?",
                new String[]{"Ban", "Meliodas", "King", "Gowther"}, 0,
                new String[]{"Correto! Ban é irreverente e imortal!", "Meliodas é poderoso, mas não irreverente assim!",
                        "King é tímido!", "Gowther é lógico, não irreverente!"} ));
        lista.add(new PerguntaNanatsu("Quem é o Rei da Floresta?",
                new String[]{"King", "Escanor", "Meliodas", "Diane"}, 0,
                new String[]{"Correto! King protege a floresta!", "Escanor brilha, mas não é rei da floresta!",
                        "Meliodas comanda o grupo, mas não é rei da floresta!", "Diane é gigante, mas não rei!"} ));
        Collections.shuffle(lista);
        return lista;
    }

    private String comentarioFinal(double pct) {
        if (pct == 100) return "Você é o próprio Meliodas! 👑";
        if (pct >= 80) return "Quase um verdadeiro herói de Liones! 🏰";
        if (pct >= 50) return "Bom, mas ainda precisa treinar com os Sete Pecados!";
        return "Ops! Nem os Sete Pecados conseguiriam te salvar 😅";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizNanatsuUi::new);
    }

    // ===== Classe interna Pergunta =====
    static class PerguntaNanatsu {
        private final String texto;
        private final String[] opcoes;
        private final int correta;
        private final String[] feedbacks;

        public PerguntaNanatsu(String texto, String[] opcoes, int correta, String[] feedbacks) {
            this.texto = texto;
            this.opcoes = opcoes;
            this.correta = correta;
            this.feedbacks = feedbacks;
        }

        public String getTexto() { return texto; }
        public String[] getOpcoes() { return opcoes; }
        public int getCorreta() { return correta; }

        public String getFeedback(boolean corretaEscolhida) {
            if (corretaEscolhida) return feedbacks[correta];
            int i;
            do { i = new Random().nextInt(feedbacks.length); } while (i == correta);
            return feedbacks[i];
        }
    }
}
