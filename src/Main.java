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
    private Color corAtual;

    // Paleta neutra
    private final Color COLOR_BACKGROUND = new Color(46, 46, 46); // fundo escuro
    private final Color BTN_COLOR = new Color(85, 85, 85);         // botão cinza médio
    private final Color BTN_HOVER = new Color(119, 119, 119);      // hover cinza claro
    private final Color TEXT_COLOR = Color.WHITE;                  // texto branco

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

    // Botões dos animes
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
            new String[]{"Você está pronto para ser um investigador! 🕵️‍♂️", "Cuidado para não virar um ghoul! 👀", "Quase lá, mas treine mais com Kaneki!", "Boa, mas não olhe direto nos olhos de Ryuk… ops, quer dizer, ghoul 😅"},
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
    btn.setFont(FONT_EMOJI_16);
    btn.setBackground(new Color(85, 85, 85, 200));
    btn.setOpaque(true);
    btn.setContentAreaFilled(true);
    btn.setForeground(TEXT_COLOR);
    btn.setFocusPainted(false);
    btn.setAlignmentX(Component.CENTER_ALIGNMENT);
    btn.setMaximumSize(new Dimension(400, 50));

    btn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            SoundPlayer.playSound("src/sounds/hover.wav");
            btn.setBackground(new Color(119, 119, 119, 180));
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btn.setBackground(new Color(85, 85, 85, 125));
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
    this.corAtual = COLOR_BACKGROUND;

    // Aqui usamos BackgroundPanel para o fundo do quiz
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
        btnOpcoes[i].setFont(FONT_EMOJI_16);
        btnOpcoes[i].setFocusPainted(false);
        btnOpcoes[i].setForeground(TEXT_COLOR);
        btnOpcoes[i].setBackground(new Color(85, 85, 85, 200));
        btnOpcoes[i].setOpaque(true);
        btnOpcoes[i].setContentAreaFilled(true);
        btnOpcoes[i].setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOpcoes[i].setMaximumSize(new Dimension(500, 45));

        int index = i;
        btnOpcoes[i].addActionListener(e -> verificarResposta(index));

        btnOpcoes[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SoundPlayer.playSound("src/sounds/hover.wav");
                btnOpcoes[index].setBackground(new Color(119, 119, 119, 220));
                btnOpcoes[index].setBorder(BorderFactory.createLineBorder(TEXT_COLOR, 2));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOpcoes[index].setBackground(new Color(85, 85, 85, 200));
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
    // Usa BackgroundPanel para manter a imagem de fundo
    panelMain = new BackgroundPanel("src/imagens/fundo_menu.png");
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
    btnReiniciar.setFont(new Font("Verdana", Font.BOLD, 16));
    btnReiniciar.setBackground(new Color(85, 85, 85, 200));
    btnReiniciar.setOpaque(true);
    btnReiniciar.setContentAreaFilled(true);
    btnReiniciar.setForeground(TEXT_COLOR);
    btnReiniciar.setFocusPainted(false);
    btnReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnReiniciar.setMaximumSize(new Dimension(400, 45));
    btnReiniciar.addActionListener(e -> showAnimeSelection());
    btnReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnReiniciar.setBackground(new Color(119, 119, 119, 220));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnReiniciar.setBackground(new Color(85, 85, 85, 200));
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
