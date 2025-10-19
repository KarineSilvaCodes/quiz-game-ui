package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DragonBallUI extends JFrame {

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

    public DragonBallUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        setTitle("🐉 Quiz Dragon Ball - Teste seu poder de luta!");
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
        perguntas = gerarPerguntasDragonBall();
        Collections.shuffle(perguntas);
        pontuacao = 0;
        perguntaAtual = 0;
        mostrarPergunta();
    }

    private void mostrarPergunta() {
        if (perguntaAtual < 10) {
            Pergunta p = perguntas.get(perguntaAtual);
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
                ((Timer)e.getSource()).stop();
                lblFeedback.setForeground(Color.RED);
                lblFeedback.setText("<html><center>Tempo esgotado! <br>➡ Resposta correta: " +
                        perguntas.get(perguntaAtual).getOpcoes()[perguntas.get(perguntaAtual).getCorreta()] + "</center></html>");
                for (JButton btn : btnOpcoes) btn.setEnabled(false);
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
                "<span style='font-size:20px; font-weight:bold; color:#FF6347;'>🐉 RESULTADO FINAL 🐉</span><br><br>" +
                "Você acertou <b>" + pontuacao + " de 10</b> perguntas!<br>" +
                String.format("<b>(%.0f%% de acertos)</b><br>", percentual) +
                "<i>" + comentarioFinal(percentual) + "</i><br><br>" +
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
        lblPontuacao.setText("Pontuação: 0/10");
        lblPontuacao.setCursor(Cursor.getDefaultCursor());
        lblPontuacao.removeMouseListener(lblPontuacao.getMouseListeners()[0]);
        iniciarQuiz();
    }

    private ArrayList<Pergunta> gerarPerguntasDragonBall() {
        ArrayList<Pergunta> lista = new ArrayList<>();
        lista.add(new Pergunta("Quem é o protagonista da série?",
                new String[] {"Goku", "Vegeta", "Gohan", "Piccolo"}, 0));
        lista.add(new Pergunta("Qual é a transformação famosa de Goku?",
                new String[] {"Super Saiyajin", "Kaioken", "Mestre Roshi", "Ultra Instinct"}, 0));
        lista.add(new Pergunta("Quem é o príncipe dos Saiyajins?",
                new String[] {"Vegeta", "Goku", "Gohan", "Trunks"}, 0));
        lista.add(new Pergunta("Quem é o melhor amigo de Goku na infância?",
                new String[] {"Kuririn", "Yamcha", "Tenshinhan", "Chaozu"}, 0));
        lista.add(new Pergunta("Quem é o deus da destruição do Universo 7?",
                new String[] {"Bills", "Whis", "Goku", "Vegeta"}, 0));
        lista.add(new Pergunta("Quem treina Goku durante a saga de Namekusei?",
                new String[] {"Kami", "Mestre Kame", "Dende", "Piccolo"}, 3));
        lista.add(new Pergunta("Quem é o irmão mais velho de Goku?",
                new String[] {"Raditz", "Gohan", "Vegeta", "Bardock"}, 0));
        lista.add(new Pergunta("Quem forma o Gotenks?",
                new String[] {"Goten e Trunks", "Goku e Vegeta", "Gohan e Goten", "Piccolo e Gohan"}, 0));
        lista.add(new Pergunta("Qual é o ataque assinatura de Goku?",
                new String[] {"Kamehameha", "Final Flash", "Galick Gun", "Destructo Disc"}, 0));
        lista.add(new Pergunta("Quem é o androide aliado de Goku?",
                new String[] {"Androide 18", "Androide 17", "Cell", "Buu"}, 0));
        return lista;
    }

    private String respostaCertaAleatoria() {
        String[] respostas = {
                "Perfeito! Você liberou seu Super Saiyajin interior! 💥",
                "Incrível! Até o Goku ficaria impressionado!",
                "Você dominou o Kamehameha! ⚡",
                "Seu Ki está elevado! Continue treinando!",
                "Sensacional! Você é digno de Namekusei!"
        };
        return respostas[random.nextInt(respostas.length)];
    }

    private String respostaErradaAleatoria() {
        String[] respostas = {
                "Ops... parece que seu Ki falhou 😅",
                "Você foi derrotado antes do final flash!",
                "Nem o Vegeta acertaria isso tão fácil!",
                "Cuidado! Treine mais seu poder!",
                "Seu Ki precisa de mais concentração!"
        };
        return respostas[random.nextInt(respostas.length)];
    }

    private String comentarioFinal(double pct) {
        if (pct == 100) return "Você é um verdadeiro Super Saiyajin!";
        if (pct >= 80) return "Quase um deus da destruição!";
        if (pct >= 50) return "Bom, mas ainda precisa treinar com o Mestre Kame!";
        return "Nem o Goku iniciante erraria tanto 😅";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DragonBallUI::new);
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

    public String getTexto() { return texto; }
    public String[] getOpcoes() { return opcoes; }
    public int getCorreta() { return correta; }
}
