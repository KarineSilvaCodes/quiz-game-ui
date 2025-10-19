package src.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.core.Pergunta;

public class AnimeData {

    public static List<Pergunta> getNaruto() {
        List<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("Quem é o protagonista da série?",
                new String[]{"Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake"},
                0,
                new String[]{"Correto! Naruto é o protagonista!", "Sasuke é rival!", "Sakura é amiga!", "Kakashi é sensei!"}));
        perguntas.add(new Pergunta("Quem é o melhor amigo de Naruto?",
                new String[]{"Sasuke", "Sakura", "Kakashi", "Hinata"},
                0,
                new String[]{"Correto! Sasuke é melhor amigo!", "Sakura é amiga!", "Kakashi é sensei!", "Hinata é colega!"}));
        Collections.shuffle(perguntas);
        return perguntas;
    }

    public static List<Pergunta> getHunterxHunter() {
        List<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("Quem é o protagonista da série?",
                new String[]{"Gon Freecss", "Killua Zoldyck", "Kurapika", "Leorio"},
                0,
                new String[]{"Correto! Gon é o protagonista!", "Killua é amigo e rival!", "Kurapika é aliado!", "Leorio é amigo!"}));
        perguntas.add(new Pergunta("Quem é da famosa família assassina Zoldyck?",
                new String[]{"Killua", "Gon", "Kurapika", "Leorio"},
                0,
                new String[]{"Correto! Killua é da família Zoldyck!", "Gon não é assassino!", "Kurapika não!", "Leorio não!"}));
        Collections.shuffle(perguntas);
        return perguntas;
    }

    public static List<Pergunta> getKimetsuNoYaiba() {
        List<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("Quem é o protagonista da série?",
                new String[]{"Tanjiro Kamado", "Nezuko Kamado", "Zenitsu Agatsuma", "Inosuke Hashibira"},
                0,
                new String[]{"Correto! Tanjiro é o protagonista!", "Nezuko é irmã de Tanjiro!", "Zenitsu é aliado!", "Inosuke é aliado!"}));
        perguntas.add(new Pergunta("Quem é a irmã de Tanjiro transformada em demônio?",
                new String[]{"Nezuko", "Muzan", "Shinobu", "Kanao"},
                0,
                new String[]{"Correto! Nezuko é a irmã de Tanjiro!", "Muzan é o vilão!", "Shinobu é Hashira!", "Kanao é caçadora!"}));
        Collections.shuffle(perguntas);
        return perguntas;
    }

    public static List<Pergunta> getTokyoGhoul() {
        List<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("Quem é o protagonista de Tokyo Ghoul?",
                new String[]{"Kaneki Ken", "Touka Kirishima", "Nishiki Nishio", "Yamori"},
                0,
                new String[]{"Correto! Kaneki é o protagonista!", "Touka é importante, mas não protagonista!", "Nishiki é coadjuvante!", "Yamori é vilão!"}));
        perguntas.add(new Pergunta("Qual é o tipo de kagune de Kaneki?",
                new String[]{"Rinkaku", "Ukaku", "Koukaku", "Bikaku"},
                0,
                new String[]{"Correto! Kaneki tem Rinkaku!", "Ukaku é da Touka!", "Koukaku é de outros ghouls!", "Bikaku é de Nishiki!"}));
        Collections.shuffle(perguntas);
        return perguntas;
    }
}
