package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DragonBallData {

    public static List<Pergunta> getDragonBall() {
        List<Pergunta> lista = new ArrayList<>();

        lista.add(new Pergunta(
                "Quem é o protagonista da série?",
                new String[]{"Goku", "Vegeta", "Gohan", "Piccolo"},
                0,
                new String[]{
                        "Perfeito! Você liberou seu Super Saiyajin interior! 💥",
                        "Ops... parece que seu Ki falhou 😅"
                }));

        lista.add(new Pergunta(
                "Qual é a transformação famosa de Goku?",
                new String[]{"Super Saiyajin", "Kaioken", "Mestre Roshi", "Ultra Instinct"},
                0,
                new String[]{
                        "Incrível! Até o Goku ficaria impressionado!",
                        "Você foi derrotado antes do final flash!"
                }));

        lista.add(new Pergunta(
                "Quem é o príncipe dos Saiyajins?",
                new String[]{"Vegeta", "Goku", "Gohan", "Trunks"},
                0,
                new String[]{
                        "Você dominou o Kamehameha! ⚡",
                        "Nem o Vegeta acertaria isso tão fácil!"
                }));

        // ... adicione as outras perguntas do mesmo jeito

        Collections.shuffle(lista);
        return lista;
    }
}
