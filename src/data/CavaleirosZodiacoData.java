package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;

public class CavaleirosZodiacoData {

    public static ArrayList<Pergunta> getCavaleirosZodiaco() {
        ArrayList<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Quem é o protagonista da série?",
                new String[] { "Seiya", "Shiryu", "Hyoga", "Shun" },
                0,
                new String[] {
                        "Correto! Seiya é o protagonista!",
                        "Shiryu é aliado!",
                        "Hyoga é aliado!",
                        "Shun é aliado!"
                }));

        perguntas.add(new Pergunta(
                "Qual é o cavaleiro de bronze de Dragão?",
                new String[] { "Shiryu", "Seiya", "Hyoga", "Shun" },
                0,
                new String[] {
                        "Correto! Shiryu é o Cavaleiro de Dragão!",
                        "Seiya é Pégaso!",
                        "Hyoga é Cisne!",
                        "Shun é Andrômeda!"
                }));

        perguntas.add(new Pergunta(
                "Qual é o cavaleiro de bronze de Cisne?",
                new String[] { "Seiya", "Shiryu", "Hyoga", "Shun" },
                2,
                new String[] {
                        "Seiya é Pégaso!",
                        "Shiryu é Dragão!",
                        "Correto! Hyoga é o Cavaleiro de Cisne!",
                        "Shun é Andrômeda!"
                }));

        perguntas.add(new Pergunta(
                "Qual cavaleiro de bronze usa a armadura de Andrômeda?",
                new String[] { "Shun", "Seiya", "Hyoga", "Shiryu" },
                0,
                new String[] {
                        "Correto! Shun é Andrômeda!",
                        "Seiya é Pégaso!",
                        "Hyoga é Cisne!",
                        "Shiryu é Dragão!"
                }));

        perguntas.add(new Pergunta(
                "Quem é o cavaleiro de bronze de Pégaso?",
                new String[] { "Seiya", "Shiryu", "Hyoga", "Shun" },
                0,
                new String[] {
                        "Correto! Seiya veste a armadura de Pégaso!",
                        "Shiryu é Dragão!",
                        "Hyoga é Cisne!",
                        "Shun é Andrômeda!"
                }));

        perguntas.add(new Pergunta(
                "Qual cavaleiro é conhecido por seu golpe Meteoro de Pégaso?",
                new String[] { "Seiya", "Shiryu", "Hyoga", "Shun" },
                0,
                new String[] {
                        "Correto! Meteoro de Pégaso é de Seiya!",
                        "Shiryu usa Golpe do Dragão!",
                        "Hyoga usa Pó de Diamante!",
                        "Shun usa Corrente Nebulosa!"
                }));

        // Você pode adicionar mais perguntas seguindo o mesmo padrão

        Collections.shuffle(perguntas);
        return perguntas;
    }
}
