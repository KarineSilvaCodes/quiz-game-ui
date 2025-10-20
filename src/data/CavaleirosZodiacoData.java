package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;

public class CavaleirosZodiacoData { 

    public static ArrayList<Pergunta> getCavaleirosZodiaco() {
        ArrayList<Pergunta> lista = new ArrayList<>();

        lista.add(new Pergunta(
            "Quem é o protagonista da série?",
            new String[] { "Seiya", "Shiryu", "Hyoga", "Shun" },
            0,
            new String[] {
                "Correto! Seiya é o Cavaleiro de Pégaso e protagonista! 🌟",
                "Shiryu é forte, mas não o protagonista!",
                "Hyoga é aliado importante, mas não principal!",
                "Shun é o pacífico, mas não é o herói principal!"
            }));

        lista.add(new Pergunta(
            "Qual é o Cavaleiro de Dragão?",
            new String[] { "Shiryu", "Seiya", "Hyoga", "Shun" },
            0,
            new String[] {
                "Correto! Shiryu é o Cavaleiro de Dragão! 🐉",
                "Seiya é de Pégaso!",
                "Hyoga é de Cisne!",
                "Shun é de Andrômeda!"
            }));

        lista.add(new Pergunta(
            "Quem é o Cavaleiro de Cisne?",
            new String[] { "Hyoga", "Seiya", "Shiryu", "Shun" },
            0,
            new String[] {
                "Correto! Hyoga é o Cavaleiro de Cisne! ❄️",
                "Seiya é de Pégaso!",
                "Shiryu é de Dragão!",
                "Shun é de Andrômeda!"
            }));

        lista.add(new Pergunta(
            "Qual Cavaleiro usa correntes como arma?",
            new String[] { "Shun", "Seiya", "Shiryu", "Hyoga" },
            0,
            new String[] {
                "Correto! Shun, o Cavaleiro de Andrômeda, usa correntes! ⛓️",
                "Seiya usa socos e velocidade!",
                "Shiryu usa punhos e golpes de dragão!",
                "Hyoga usa golpes de gelo!"
            }));

        lista.add(new Pergunta(
            "Quem é conhecida como a deusa que os Cavaleiros protegem?",
            new String[] { "Atena", "Hades", "Poseidon", "Artemis" },
            0,
            new String[] {
                "Correto! Atena é a deusa da justiça e paz! 👑",
                "Hades é o vilão do submundo!",
                "Poseidon é o deus do mar!",
                "Artemis não aparece na série!"
            }));

        lista.add(new Pergunta(
            "Qual técnica de Seiya é famosa por concentrar todo o poder nos punhos?",
            new String[] { "Meteoro de Pégaso", "Dragão Nascente", "Cólera do Cisne", "Corrente Nebulosa" },
            0,
            new String[] {
                "Correto! Meteoro de Pégaso é o ataque icônico de Seiya! 🌠",
                "Dragão Nascente é de Shiryu!",
                "Cólera do Cisne é de Hyoga!",
                "Corrente Nebulosa é de Shun!"
            }));

        lista.add(new Pergunta(
            "Qual Cavaleiro é conhecido por sua armadura verde e luta com punhos poderosos?",
            new String[] { "Shiryu", "Seiya", "Hyoga", "Shun" },
            0,
            new String[] {
                "Correto! Shiryu veste a Armadura de Dragão verde e é muito poderoso! 🐉",
                "Seiya veste armadura de Pégaso!",
                "Hyoga veste armadura de Cisne!",
                "Shun veste armadura de Andrômeda!"
            }));

        lista.add(new Pergunta(
            "Qual Cavaleiro tem laços com o gelo e usa golpes congelantes?",
            new String[] { "Hyoga", "Seiya", "Shiryu", "Shun" },
            0,
            new String[] {
                "Correto! Hyoga é o Cavaleiro de Cisne e domina o gelo! ❄️",
                "Seiya usa velocidade e punhos!",
                "Shiryu usa golpes de dragão!",
                "Shun usa correntes defensivas!"
            }));

        lista.add(new Pergunta(
            "Quem é o Cavaleiro de Andrômeda?",
            new String[] { "Shun", "Seiya", "Shiryu", "Hyoga" },
            0,
            new String[] {
                "Correto! Shun usa correntes defensivas e é muito pacífico! ⛓️",
                "Seiya é de Pégaso!",
                "Shiryu é de Dragão!",
                "Hyoga é de Cisne!"
            }));

        lista.add(new Pergunta(
            "Qual vilão é o deus do submundo que os Cavaleiros enfrentam?",
            new String[] { "Hades", "Poseidon", "Atena", "Ares" },
            0,
            new String[] {
                "Correto! Hades é o deus do submundo e principal vilão do arco! 💀",
                "Poseidon é o deus do mar, outro arco!",
                "Atena é a deusa que eles protegem!",
                "Ares não aparece na série!"
            }));

        Collections.shuffle(lista);
        return lista;
    }
}
