package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;

public class BleachData {

    public static ArrayList<Pergunta> getBleach() {
        ArrayList<Pergunta> lista = new ArrayList<>();

        lista.add(new Pergunta(
            "Quem é o protagonista da série?",
            new String[] { "Ichigo Kurosaki", "Rukia Kuchiki", "Renji Abarai", "Byakuya Kuchiki" },
            0,
            new String[] {
                "Correto! Ichigo é o protagonista da série! ⚔️",
                "Rukia é importante, mas não a protagonista!",
                "Renji é aliado, mas não principal!",
                "Byakuya é líder do clã Kuchiki, não protagonista!"
            }));

        lista.add(new Pergunta(
            "Qual é o poder que permite aos Shinigamis cortar Hollows?",
            new String[] { "Zanpakutou", "Bankai", "Kido", "Hollowfication" },
            0,
            new String[] {
                "Correto! Zanpakutou é a espada que cada Shinigami usa! 🗡️",
                "Bankai é a forma liberada da Zanpakutou, mas não é o poder básico!",
                "Kido é magia, não a espada principal!",
                "Hollowfication é outro conceito, usado por Ichigo mais tarde!"
            }));

        lista.add(new Pergunta(
            "Quem é a Shinigami que transfere poderes a Ichigo no começo?",
            new String[] { "Rukia Kuchiki", "Orihime Inoue", "Yoruichi Shihoin", "Soi Fon" },
            0,
            new String[] {
                "Correto! Rukia transfere poderes a Ichigo! ⚡",
                "Orihime é aliada, mas não dá poderes!",
                "Yoruichi ajuda depois, mas não dá poderes inicialmente!",
                "Soi Fon é líder do esquadrão 2, não transfere poderes!"
            }));

        lista.add(new Pergunta(
            "Qual é o Bankai de Byakuya Kuchiki?",
            new String[] { "Senbonzakura Kageyoshi", "Tensa Zangetsu", "Hien", "Ryujin Jakka" },
            0,
            new String[] {
                "Correto! Senbonzakura Kageyoshi é seu Bankai icônico! 🌸",
                "Tensa Zangetsu é de Ichigo!",
                "Hien é de Shunsui Kyoraku!",
                "Ryujin Jakka é de Genryusai Yamamoto!"
            }));

        lista.add(new Pergunta(
            "Quem é o melhor amigo e rival de Ichigo?",
            new String[] { "Uryu Ishida", "Renji Abarai", "Chad", "Orihime" },
            0,
            new String[] {
                "Correto! Uryu Ishida é aliado, rival e amigo! 🏹",
                "Renji é aliado importante, mas rival mais fraco!",
                "Chad é amigo, mas não rival!",
                "Orihime é amiga, mas não rival!"
            }));

        lista.add(new Pergunta(
            "Qual Hollow Ichigo luta no começo da série?",
            new String[] { "Grand Fisher", "Menos Grande", "Ulquiorra", "Aizen" },
            0,
            new String[] {
                "Correto! Grand Fisher é o Hollow que Ichigo enfrenta primeiro! 👹",
                "Menos Grande não existe!",
                "Ulquiorra aparece bem depois!",
                "Aizen é o grande vilão, mas não Hollow inicial!"
            }));

        lista.add(new Pergunta(
            "Qual é a amiga de Ichigo que possui habilidades de cura?",
            new String[] { "Orihime Inoue", "Rukia Kuchiki", "Yasutora 'Chad' Sado", "Renji Abarai" },
            0,
            new String[] {
                "Correto! Orihime tem poderes de cura! ✨",
                "Rukia usa Kido e espada!",
                "Chad é lutador físico!",
                "Renji é espadachim!"
            }));

        lista.add(new Pergunta(
            "Quem é o capitão do 11º Esquadrão, famoso por seu poder e selvageria?",
            new String[] { "Kenpachi Zaraki", "Byakuya Kuchiki", "Soi Fon", "Shunsui Kyoraku" },
            0,
            new String[] {
                "Correto! Kenpachi Zaraki é o capitão selvagem do 11º Esquadrão! ⚔️",
                "Byakuya é do 6º Esquadrão!",
                "Soi Fon é do 2º Esquadrão!",
                "Shunsui é do 8º Esquadrão!"
            }));

        lista.add(new Pergunta(
            "Qual é a espada de Ichigo?",
            new String[] { "Zangetsu", "Senbonzakura", "Hyogokyuu", "Ryujin Jakka" },
            0,
            new String[] {
                "Correto! Zangetsu é a Zanpakutou de Ichigo! 🗡️",
                "Senbonzakura é de Byakuya!",
                "Hyogokyuu não existe!",
                "Ryujin Jakka é de Yamamoto!"
            }));

        lista.add(new Pergunta(
            "Quem é o vilão que se infiltra como capitão do 5º Esquadrão?",
            new String[] { "Aizen Sousuke", "Gin Ichimaru", "Tosen Kaname", "Yamamoto" },
            0,
            new String[] {
                "Correto! Aizen se infiltra e é o grande vilão da saga! 😈",
                "Gin é cúmplice, mas não o líder do plano!",
                "Tosen é aliado de Aizen, mas não capitão infiltrado!",
                "Yamamoto é capitão geral e não vilão!"
            }));

        Collections.shuffle(lista);
        return lista;
    }
}
