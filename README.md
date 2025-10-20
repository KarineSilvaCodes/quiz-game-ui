

<h1>🎮 Quiz de Animes</h1>
<p>Um quiz interativo em <strong>Java Swing</strong> que permite ao usuário testar seus conhecimentos sobre diversos animes famosos, como Naruto, Dragon Ball, One Piece, Hunter x Hunter, Kimetsu no Yaiba, Bleach, entre outros.</p>

<hr>

<h2>📝 Funcionalidades</h2>
<ul>
    <li>Tela inicial com <strong>seleção de anime</strong> desejado.</li>
    <li>Quiz com <strong>4 alternativas por pergunta</strong>.</li>
    <li>Feedback imediato de <strong>acerto ou erro</strong>, incluindo efeitos sonoros.</li>
    <li>Tela de resultado com pontuação e mensagem personalizada.</li>
    <li>Navegação fácil para <strong>reiniciar o quiz</strong> ou escolher outro anime.</li>
    <li>Fundo visual customizado para cada quiz.</li>
</ul>

<hr>

<h2>📂 Estrutura do Projeto</h2>
<pre>
QuizDeAnimes/
│
├── src/
│   ├── Main.java                   # Classe principal
│   ├── core/
│   │   └── Pergunta.java           # Modelo de pergunta
│   ├── data/                       # Perguntas por anime
│   │   ├── NarutoData.java
│   │   ├── HunterxHunterData.java
│   │   └── ...                     # Outras séries
│   ├── ui/
│   │   └── BackgroundPanel.java    # JPanel com imagem de fundo
│   └── utils/
│       └── SoundPlayer.java        # Toca efeitos sonoros
│
├── src/imagens/                     # Imagens do quiz
│   ├── fundo_menu.png
│   ├── naruto.png
│   └── ...
│
└── src/sounds/                      # Sons do quiz
    ├── hover.wav
    ├── click.wav
    ├── acerto.wav
    └── erro.wav


</pre>

<hr>

<h2>💻 Tecnologias Utilizadas</h2>
<ul>
    <li><strong>Java 25</strong> - Linguagem principal.</li>
    <li><strong>Swing</strong> - Interface gráfica.</li>
    <li><strong>Clip / JLayer</strong> - Reprodução de sons.</li>
</ul>

<hr>

<h2>🚀 Como Executar</h2>
<ol>
    <li>Clone o projeto:
    <pre><code>git clone https://github.com/SEU-USUARIO/quiz-de-animes.git</code></pre>
    </li>
    <li>Abra a pasta no IDE de sua preferência (IntelliJ, VS Code ou Eclipse).</li>
    <li>Compile e execute o projeto:
    <pre><code>javac -d bin src/**/*.java
java -cp bin src.Main</code></pre>
    Ou rode diretamente a classe <code>Main.java</code> na IDE.
    </li>
</ol>

<hr>

<h2>🎨 Personalização</h2>
<ul>
    <li><strong>Adicionar novo anime:</strong>
        <ul>
            <li>Crie um arquivo de dados em <code>src/data/</code>.</li>
            <li>Adicione as perguntas usando a classe <code>Pergunta</code>.</li>
            <li>Adicione o botão na função <code>showAnimeSelection()</code> em <code>Main.java</code>.</li>
            <li>Crie uma imagem de fundo na pasta <code>src/imagens/</code>.</li>
        </ul>
    </li>
    <li><strong>Adicionar novos sons:</strong>
        <ul>
            <li>Coloque o arquivo .wav em <code>src/sounds/</code> e use <code>SoundPlayer.playSound("src/sounds/NOME.wav");</code>.</li>
        </ul>
    </li>
</ul>

<hr>

<h2>📌 Observações</h2>
<p>O projeto segue o padrão MVC simplificado, separando dados, lógica e interface. É possível expandir com novos quizzes, efeitos sonoros e gráficos de resultados.</p>

<hr>

<h2>🤝 Contribuição</h2>
<p>Contribuições são bem-vindas! Abra um pull request ou crie uma issue para sugestões.</p>

<hr>

<h2>👨‍💻 Desenvolvedores</h2>
<ul>
    <li><a href="https://github.com/KarineSilvaCodes" target="_blank">Karine Silva</a></li>
    <li><a href="https://github.com/Samuel-Jonathan-QA" target="_blank">Samuel Jonathan</a></li>
</ul>

<hr>


<h2>🎁 Licença</h2>
<p>MIT License © 2025</p>

</body>
</html>
