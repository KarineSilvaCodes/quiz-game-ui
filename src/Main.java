package src;

import src.data.*;
import src.core.Pergunta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {

    private JFrame frame;
    private JPanel panelMain;
    private List<Pergunta> perguntas;
    private int perguntaAtual = 0;
    private int acertos = 0;
    private String[] feedbacksFinal;
    private JLabel lblPergunta;
    private JButton[] btnOpcoes;

    // Paleta neutra
    private final Color COLOR_BACKGROUND = new Color(46, 46, 46);
    private final Color BTN_COLOR = new Color(85, 85, 85);
    private final Color BTN_HOVER = new Color(119, 119, 119);
    private final Color TEXT_COLOR = Color.WHITE;

    // Fontes
    private final Font FONT_EMOJI_20 = new Font("Segoe UI Emoji", Font.PLAIN, 20);
    private final Font FONT_EMOJI_16 = new Font("Segoe UI Emoji", Font.PLAIN, 16);
    private final Font FONT_EMOJI_24_BOLD = new Font("Segoe UI Emoji", Font.BOLD, 24);
    private final Font FONT_EMOJI_22_BOLD = new Font("Segoe UI Emoji", Font.BOLD, 22);

    public Main() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Quiz de Animes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 550);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        showAnimeSelection();
        frame.setVisible(true);
    }

    private void estilizarBotaoTransparente(JButton btn, Color baseColor) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);

        btn.setBackground(new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 180));
        btn.setForeground(TEXT_COLOR);

        btn.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                AbstractButton b = (AbstractButton) c;

                // Fundo com leve transparência
                g2.setColor(b.getBackground());
                g2.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);

                // Texto centralizado
                super.paint(g, c);
                g2.dispose();
            }
        });
    }

    private void showAnimeSelection() {
        panelMain = new BackgroundPanel("src/imagens/fundo_menu.png");
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Escolha o anime para jogar:", SwingConstants.CENTER);
        label.setFont(FONT_EMOJI_24_BOLD);
        label.setForeground(TEXT_COLOR);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(label);
        panelMain.add(Box.createVerticalStrut(30));

        addAnimeButton("Naruto", NarutoData.getNaruto(),
                "📝 BEM-VINDO AO QUIZ DE NARUTO! 📝",
                new String[]{"Você é um ninja de elite! 🥷", "Continue treinando no campo!", "Muito bem!", "Parabéns! Você completou o quiz!"},
                "src/imagens/naruto.png");

        addAnimeButton("Hunter x Hunter", HunterxHunterData.getHunterxHunter(),
                "📝 BEM-VINDO AO QUIZ DE HUNTER X HUNTER! 📝",
                new String[]{"Você está quase no nível de caçador! 🏹", "Continue treinando seu Nen!", "Muito bem! Mas não subestime os inimigos!", "Parabéns! Sobreviveu a todas as provas!"},
                "src/imagens/hxh.png");

        addAnimeButton("Kimetsu no Yaiba", KimetsuNoYaibaData.getKimetsuNoYaiba(),
                "📝 BEM-VINDO AO QUIZ DE KIMETSU NO YAIBA! 📝",
                new String[]{"Parabéns! Você está pronto para caçar demônios! ⚔️", "Muito bem! Mas cuidado com Muzan!", "Ótimo! Seu Nichirin está afiado! 🗡️", "Excelente! Você sobreviveu a todas as batalhas!"},
                "src/imagens/kimetsu.png");

        addAnimeButton("Tokyo Ghoul", TokyoGhoulData.getTokyoGhoul(),
                "🩸 BEM-VINDO AO QUIZ DE TOKYO GHOUL! 🩸",
                new String[]{"Você está pronto para ser um investigador! 🕵️‍♂️", "Cuidado para não virar um ghoul! 👀", "Quase lá, mas treine mais com Kaneki!", "Boa, mas não olhe direto nos olhos de um ghoul 😅"},
                "src/imagens/tokyo.png");

        addAnimeButton("Dragon Ball", DragonBallData.getDragonBall(),
                "🐉 BEM-VINDO AO QUIZ DE DRAGON BALL! 🐉",
                new String[]{"Você é um verdadeiro Super Saiyajin! 💥", "Quase um deus da destruição!", "Bom, mas ainda precisa treinar com o Mestre Kame!", "Nem o Goku iniciante erraria tanto 😅"},
                "src/imagens/dragon.png");

        addAnimeButton("Bleach", BleachData.getBleach(),
                "📝 BEM-VINDO AO QUIZ DE BLEACH! 📝",
                new String[]{"Você é um verdadeiro shinigami! ⚔️", "Cuidado para não virar hollow! 👀", "Continue treinando com o Gotei 13!", "Fim do quiz! Sobreviveu aos hollows! 🎯"},
                "src/imagens/bleach.png");

        addAnimeButton("Nanatsu no Taizai", NanatsuData.getNanatsu(),
                "📝 BEM-VINDO AO QUIZ DE NANATSU NO TAIZAI! 📝",
                new String[]{"Você é o próprio Meliodas! 👑", "Quase um verdadeiro herói de Liones! 🏰", "Bom, mas ainda precisa treinar com os Sete Pecados!", "Ops! Nem os Sete Pecados conseguiriam te salvar 😅"},
                "src/imagens/nanatsu.png");

        addAnimeButton("Death Note", DeathNoteData.getDeathNote(),
                "📝 BEM-VINDO AO QUIZ DE DEATH NOTE! 📝",
                new String[]{"Kira ficaria orgulhoso! 😈", "Você sobreviveu sem escrever nomes no caderno! 😅", "Investigue mais, detetive! 🕵️‍♂️", "Acertou bastante, mas cuidado com Shinigamis! 👀"},
                "src/imagens/death.png");

        addAnimeButton("Cavaleiros do Zodíaco", CavaleirosZodiacoData.getCavaleirosZodiaco(),
                "📝 BEM-VINDO AO QUIZ DE CAVALEIROS DO ZODÍACO! 📝",
                new String[]{"Você é digno do cosmo! ✨", "Continue treinando, cavaleiro!", "Quase lá! Estude mais os golpes e armaduras!", "Parabéns! Sobreviveu aos ataques de Hades!"},
                "src/imagens/cavaleiros.png");

        addAnimeButton("One Piece", OnePieceData.getOnePiece(),
                "🏴‍☠️ BEM-VINDO AO QUIZ DE ONE PIECE! 🏴‍☠️",
                new String[]{"Você é o verdadeiro Rei dos Piratas!", "Quase lá! Continue navegando!", "Bom, mas precisa treinar na Grand Line!", "Ops! Nem o Usopp conseguiria acertar tanto 😅"},
                "src/imagens/one.png");

        frame.setContentPane(panelMain);
        frame.revalidate();
    }

    private void addAnimeButton(String nome, List<Pergunta> perguntas, String titulo, String[] feedbacks, String imagemFundo) {
        JButton btn = new JButton(nome);
        estilizarBotaoTransparente(btn, BTN_COLOR);
        btn.setFont(FONT_EMOJI_16);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(400, 50));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SoundPlayer.playSound("src/sounds/hover.wav");
                btn.setBackground(new Color(BTN_HOVER.getRed(), BTN_HOVER.getGreen(), BTN_HOVER.getBlue(), 200));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(BTN_COLOR.getRed(), BTN_COLOR.getGreen(), BTN_COLOR.getBlue(), 180));
            }
        });

        btn.addActionListener(e -> {
            SoundPlayer.playSound("src/sounds/click.wav");
            startQuiz(perguntas, titulo, feedbacks, imagemFundo);
        });

        panelMain.add(btn);
        panelMain.add(Box.createVerticalStrut(15));
    }

    private void startQuiz(List<Pergunta> perguntas, String titulo, String[] feedbacks, String imagemFundo) {
        this.perguntas = perguntas;
        this.feedbacksFinal = feedbacks;
        this.perguntaAtual = 0;
        this.acertos = 0;

        panelMain = new BackgroundPanel(imagemFundo);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        lblPergunta = new JLabel("", SwingConstants.CENTER);
        lblPergunta.setFont(FONT_EMOJI_20);
        lblPergunta.setForeground(TEXT_COLOR);
        lblPergunta.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(lblPergunta);
        panelMain.add(Box.createVerticalStrut(20));

        btnOpcoes = new JButton[4];
        for (int i = 0; i < 4; i++) {
            btnOpcoes[i] = new JButton();
            estilizarBotaoTransparente(btnOpcoes[i], BTN_COLOR);
            btnOpcoes[i].setFont(FONT_EMOJI_16);
            btnOpcoes[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            btnOpcoes[i].setMaximumSize(new Dimension(500, 45));

            int index = i;
            btnOpcoes[i].addActionListener(e -> verificarResposta(index));

            btnOpcoes[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    SoundPlayer.playSound("src/sounds/hover.wav");
                    btnOpcoes[index].setBackground(new Color(BTN_HOVER.getRed(), BTN_HOVER.getGreen(), BTN_HOVER.getBlue(), 200));
                    btnOpcoes[index].setBorder(BorderFactory.createLineBorder(TEXT_COLOR, 2));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btnOpcoes[index].setBackground(new Color(BTN_COLOR.getRed(), BTN_COLOR.getGreen(), BTN_COLOR.getBlue(), 180));
                    btnOpcoes[index].setBorder(null);
                }
            });

            panelMain.add(btnOpcoes[i]);
            panelMain.add(Box.createVerticalStrut(10));
        }

        frame.setContentPane(panelMain);
        frame.setTitle(titulo);
        frame.revalidate();

        mostrarPergunta();
    }

    private void mostrarPergunta() {
        if (perguntaAtual >= perguntas.size()) {
            mostrarResultado();
            return;
        }

        Pergunta p = perguntas.get(perguntaAtual);
        lblPergunta.setText("<html><div style='text-align: center;'>" + p.getPergunta() + "</div></html>");
        String[] opcoes = p.getOpcoes();
        for (int i = 0; i < btnOpcoes.length; i++) {
            btnOpcoes[i].setText(opcoes[i]);
        }
    }

    private void verificarResposta(int escolha) {
        Pergunta p = perguntas.get(perguntaAtual);
        boolean correta = escolha == p.getIndiceCorreto();

        if (correta) {
            acertos++;
            SoundPlayer.playSound("src/sounds/acerto.wav");
        } else {
            SoundPlayer.playSound("src/sounds/erro.wav");
        }

        JOptionPane.showMessageDialog(frame, p.getFeedback(escolha));
        perguntaAtual++;
        mostrarPergunta();
    }

    private void mostrarResultado() {
        panelMain = new BackgroundPanel("src/imagens/nezuko.gif"); // imagem de fundo final
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel lblFinal = new JLabel("Fim do quiz! Você acertou " + acertos + "/" + perguntas.size(),
                SwingConstants.CENTER);
        lblFinal.setFont(FONT_EMOJI_22_BOLD);
        lblFinal.setForeground(TEXT_COLOR);
        lblFinal.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(lblFinal);
        panelMain.add(Box.createVerticalStrut(20));

        String feedback = (acertos > 5)
                ? "🎉 Parabéns! Você acertou bastante! 🎉"
                : "😢 Que pena! Você errou bastante, tente de novo! 😢";

        JLabel lblFeedback = new JLabel(feedback, SwingConstants.CENTER);
        lblFeedback.setFont(FONT_EMOJI_20);
        lblFeedback.setForeground(TEXT_COLOR);
        lblFeedback.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMain.add(lblFeedback);
        panelMain.add(Box.createVerticalStrut(20));

        JButton btnReiniciar = new JButton("Voltar para seleção de anime");
        estilizarBotaoTransparente(btnReiniciar, BTN_COLOR);
        btnReiniciar.setFont(new Font("Verdana", Font.BOLD, 16));
        btnReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReiniciar.setMaximumSize(new Dimension(400, 45));
        btnReiniciar.addActionListener(e -> showAnimeSelection());
        btnReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReiniciar.setBackground(new Color(BTN_HOVER.getRed(), BTN_HOVER.getGreen(), BTN_HOVER.getBlue(), 200));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReiniciar.setBackground(new Color(BTN_COLOR.getRed(), BTN_COLOR.getGreen(), BTN_COLOR.getBlue(), 180));
            }
        });

        panelMain.add(btnReiniciar);

        frame.setContentPane(panelMain);
        frame.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
