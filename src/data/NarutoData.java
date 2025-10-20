package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;







public class NarutoData {

    public static ArrayList<Pergunta> getNaruto() {
        ArrayList<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Quem é o protagonista da série?",
                new String[] { "Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake" },
                0,
                new String[] { "Correto! Naruto é o protagonista!", "Sasuke é rival!", "Sakura é amiga!", "Kakashi é sensei!" }
        ));

        perguntas.add(new Pergunta(
                "Quem é o melhor amigo de Naruto?",
                new String[] { "Sasuke", "Sakura", "Kakashi", "Hinata" },
                0,
                new String[] { "Correto! Sasuke é melhor amigo!", "Sakura é amiga e crush!", "Kakashi é sensei!", "Hinata é colega!" }
        ));

        perguntas.add(new Pergunta(
                "Qual é o sonho de Naruto?",
                new String[] { "Ser Hokage", "Dominar Jutsu de Fogo", "Ser ANBU", "Vingar o clã Uzumaki" },
                0,
                new String[] { "Correto! Ele quer se tornar Hokage!", "Não é só dominar jutsus!", "ANBU é uma meta secundária!", "Vingança não é seu objetivo!" }
        ));

        perguntas.add(new Pergunta(
                "Quem é o sensei da Equipe 7?",
                new String[] { "Kakashi Hatake", "Iruka Umino", "Jiraiya", "Tsunade" },
                0,
                new String[] { "Correto! Kakashi lidera a Equipe 7!", "Iruka é professor da academia!", "Jiraiya é mentor pessoal!", "Tsunade é Hokage!" }
        ));

        perguntas.add(new Pergunta(
                "Qual é o clã de Sasuke?",
                new String[] { "Uchiha", "Hyuga", "Senju", "Akimichi" },
                0,
                new String[] { "Correto! Sasuke é do clã Uchiha!", "Hyuga é de outros personagens!", "Senju é outro clã!", "Akimichi cara, sério?" }
        ));

        perguntas.add(new Pergunta(
                "Qual é a habilidade principal do clã Hyuga?",
                new String[] { "Byakugan", "Sharingan", "Rinnegan", "Chidori" },
                0,
                new String[] { "Correto! Byakugan é a técnica do clã Hyuga!", "Sharingan é do Uchiha!", "Rinnegan é raro e não só Hyuga!", "Chidori é técnica de Sasuke!" }
        ));

        perguntas.add(new Pergunta(
                "Quem é a kunoichi principal da Equipe 7?",
                new String[] { "Sakura Haruno", "Hinata Hyuga", "Tsunade", "Ino Yamanaka" },
                0,
                new String[] { "Correto! Sakura é da Equipe 7!", "Hinata é colega, não da Equipe 7!", "Tsunade é Hokage!", "Ino é amiga de outro time!" }
        ));

        perguntas.add(new Pergunta(
                "Qual é a besta de nove caudas selada dentro de Naruto?",
                new String[] { "Kurama", "Shukaku", "Gyuki", "Matatabi" },
                0,
                new String[] { "Correto! Kurama é a Kyuubi de Naruto!", "Shukaku é do Gaara!", "Gyuki é o Oito Caudas!", "Matatabi é de outro Jinchuriki!" }
        ));

        perguntas.add(new Pergunta(
                "Quem é o lendário Sannin que treinou Naruto?",
                new String[] { "Jiraiya", "Orochimaru", "Tsunade", "Kakashi" },
                0,
                new String[] { "Correto! Jiraiya é o mentor!", "Orochimaru é inimigo!", "Tsunade é Hokage!", "Kakashi é o sensei da equipe!" }
        ));

        perguntas.add(new Pergunta(
                "Quem se torna o sexto Hokage?",
                new String[] { "Kakashi Hatake", "Naruto Uzumaki", "Tsunade", "Minato Namikaze" },
                0,
                new String[] { "Correto! Kakashi se torna o sexto Hokage!", "Naruto se torna o Sétimo!", "Tsunade é a quinta Hokage!", "Minato foi o quarto Hokage!" }
        ));

        Collections.shuffle(perguntas);
        return perguntas;
    }

}
