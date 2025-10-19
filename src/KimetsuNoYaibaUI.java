package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class KimetsuNoYaibaUI extends JFrame {

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

    public KimetsuNoYaibaUI() {
        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } catch (Exception ignored) {}

        setTitle("🎯 Quiz Kimetsu no Yaiba");
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
        perguntas = gerarPerguntasKimetsu();
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
            "Parabéns! Você está pronto para caçar demônios! ⚔️",
            "Muito bem! Mas cuidado com Muzan!",
            "Ótimo! Seu Nichirin está afiado! 🗡️",
            "Excelente! Você sobreviveu a todas as batalhas!",
            "Fim do quiz! Continue treinando sua respiração!"
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

    private ArrayList<Pergunta> gerarPerguntasKimetsu() {
        ArrayList<Pergunta> lista = new ArrayList<>();
        lista.add(new Pergunta("Quem é o protagonista da série?",
                new String[]{"Tanjiro Kamado", "Nezuko Kamado", "Zenitsu Agatsuma", "Inosuke Hashibira"}, 0,
                new String[]{"Correto! Tanjiro é o protagonista!", "Nezuko é irmã de Tanjiro!", "Zenitsu é aliado!", "Inosuke é aliado!"}));
        lista.add(new Pergunta("Quem é a irmã de Tanjiro transformada em demônio?",
                new String[]{"Nezuko", "Muzan", "Shinobu", "Kanao"}, 0,
                new String[]{"Correto! Nezuko é a irmã de Tanjiro!", "Muzan é o vilão!", "Shinobu é Hashira!", "Kanao é caçadora!"}));
        lista.add(new Pergunta("Quem é o vilão principal da série?",
                new String[]{"Muzan Kibutsuji", "Tanjiro", "Zenitsu", "Giyu"}, 0,
                new String[]{"Correto! Muzan é o vilão supremo!", "Tanjiro é herói!", "Zenitsu é aliado!", "Giyu é Hashira!"}));
        lista.add(new Pergunta("Qual é a respiração de Tanjiro?",
                new String[]{"Água", "Fogo", "Relâmpago", "Beast"}, 0,
                new String[]{"Correto! Tanjiro usa respiração da Água!", "Fogo? Não!", "Relâmpago é do Zenitsu!", "Beast é do Inosuke!"}));
        lista.add(new Pergunta("Quem é o Hashira da Insectos?",
                new String[]{"Shinobu Kocho", "Giyu Tomioka", "Kyojuro Rengoku", "Tengen Uzui"}, 0,
                new String[]{"Correto! Shinobu é Hashira dos Insetos!", "Giyu é da Água!", "Rengoku é da Chama!", "Uzui é da Névoa!"}));
        lista.add(new Pergunta("Quem é conhecido por usar respiração da Chama?",
                new String[]{"Kyojuro Rengoku", "Tanjiro", "Inosuke", "Zenitsu"}, 0,
                new String[]{"Correto! Rengoku é Hashira da Chama!", "Tanjiro usa Água!", "Inosuke usa Beast!", "Zenitsu usa Relâmpago!"}));
        lista.add(new Pergunta("Quem é o amigo que usa respiração do Relâmpago?",
                new String[]{"Zenitsu Agatsuma", "Tanjiro", "Inosuke", "Nezuko"}, 0,
                new String[]{"Correto! Zenitsu usa Relâmpago!", "Tanjiro usa Água!", "Inosuke usa Beast!", "Nezuko não usa respiração!"}));
        lista.add(new Pergunta("Qual amigo usa respiração Beast?",
                new String[]{"Inosuke Hashibira", "Zenitsu", "Tanjiro", "Giyu"}, 0,
                new String[]{"Correto! Inosuke usa respiração Beast!", "Zenitsu usa Relâmpago!", "Tanjiro usa Água!", "Giyu usa Água!"}));
        lista.add(new Pergunta("Quem é conhecido por atacar silenciosamente e rápido?",
                new String[]{"Kanao Tsuyuri", "Tanjiro", "Zenitsu", "Inosuke"}, 0,
                new String[]{"Correto! Kanao é ágil e silenciosa!", "Tanjiro é mais direto!", "Zenitsu tem medo!", "Inosuke é explosivo!"}));
        lista.add(new Pergunta("Quem é o líder da Corporação dos Caçadores de Demônios?",
                new String[]{"Muzan Kibutsuji", "Tanjiro", "Giyu", "Hashiras"}, 0,
                new String[]{"Correto! Muzan é vilão principal, mas os Hashira lideram!", "Tanjiro não!", "Giyu é Hashira!", "Hashiras são vários!"}));
        Collections.shuffle(lista);
        return lista;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KimetsuNoYaibaUI::new);
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
