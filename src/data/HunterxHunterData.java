package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HunterxHunterData {

    public static List<Pergunta> getHunterxHunter() {
        ArrayList<Pergunta> lista = new ArrayList<>();

        lista.add(new Pergunta("Quem é o protagonista da série?",
                new String[]{"Gon Freecss", "Killua Zoldyck", "Kurapika", "Leorio"},
                0,
                new String[]{"Correto! Gon é o protagonista!", "Killua é amigo e rival!", "Kurapika é aliado!", "Leorio é amigo!"}));

        lista.add(new Pergunta("Quem é da famosa família assassina Zoldyck?",
                new String[]{"Killua", "Gon", "Kurapika", "Leorio"},
                0,
                new String[]{"Correto! Killua é da família Zoldyck!", "Gon não é assassino!", "Kurapika não!", "Leorio não!"}));

        lista.add(new Pergunta("Qual personagem possui correntes para lutar?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"},
                0,
                new String[]{"Correto! Kurapika usa correntes!", "Gon usa força física!", "Killua usa eletricidade!", "Leorio usa socos!"}));

        lista.add(new Pergunta("Quem tem habilidades de eletricidade?",
                new String[]{"Killua", "Gon", "Kurapika", "Leorio"},
                0,
                new String[]{"Correto! Killua domina eletricidade!", "Gon não!", "Kurapika não!", "Leorio não!"}));

        lista.add(new Pergunta("Quem é o melhor amigo de Gon?",
                new String[]{"Killua", "Kurapika", "Leorio", "Hisoka"},
                0,
                new String[]{"Correto! Killua é o melhor amigo!", "Kurapika é aliado!", "Leorio é amigo!", "Hisoka é antagonista!"}));

        lista.add(new Pergunta("Quem é membro da Tropa Fantasma?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"},
                0,
                new String[]{"Correto! Kurapika luta contra a Tropa Fantasma!", "Gon não!", "Killua não!", "Leorio não!"}));

        lista.add(new Pergunta("Qual personagem quer se tornar um caçador para achar seu pai?",
                new String[]{"Gon", "Killua", "Kurapika", "Leorio"},
                0,
                new String[]{"Correto! Gon quer achar seu pai!", "Killua não!", "Kurapika não!", "Leorio não!"}));

        lista.add(new Pergunta("Quem é médico aspirante e amigo do grupo?",
                new String[]{"Leorio", "Gon", "Killua", "Kurapika"},
                0,
                new String[]{"Correto! Leorio quer ser médico!", "Gon não!", "Killua não!", "Kurapika não!"}));

        lista.add(new Pergunta("Quem luta para vingar seu clã Kurta?",
                new String[]{"Kurapika", "Gon", "Killua", "Leorio"},
                0,
                new String[]{"Correto! Kurapika busca vingança!", "Gon não!", "Killua não!", "Leorio não!"}));

        lista.add(new Pergunta("Quem participa do Exame Hunter junto com Gon?",
                new String[]{"Killua", "Kurapika", "Leorio", "Hisoka"},
                0,
                new String[]{"Correto! Killua participa com Gon!", "Kurapika não participa!", "Leorio participa!", "Hisoka participa, mas como antagonista!"}));

        Collections.shuffle(lista);
        return lista;
    }
}
