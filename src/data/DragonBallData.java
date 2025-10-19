package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DragonBallData {

        public static List<Pergunta> getDragonBall() {
                ArrayList<Pergunta> lista = new ArrayList<>();

                lista.add(new Pergunta(
                                "Quem é o protagonista da série?",
                                new String[] { "Goku", "Vegeta", "Gohan", "Piccolo" },
                                0,
                                new String[] {
                                                "Correto! Goku é o verdadeiro herói! 💥",
                                                "Vegeta é forte, mas não é o protagonista!",
                                                "Gohan é incrível, mas ainda criança no começo!",
                                                "Piccolo é um aliado, mas não o protagonista!"
                                }));

                lista.add(new Pergunta(
                                "Qual é a transformação famosa de Goku?",
                                new String[] { "Super Saiyajin", "Kaioken", "Mestre Roshi", "Ultra Instinct" },
                                0,
                                new String[] {
                                                "Acertou! Super Saiyajin é lendário! ⚡",
                                                "Kaioken é bom, mas não é a transformação clássica!",
                                                "Mestre Roshi? Ele só ensina técnicas!",
                                                "Ultra Instinct é avançado demais, tente novamente!"
                                }));

                lista.add(new Pergunta(
                                "Quem é o príncipe dos Saiyajins?",
                                new String[] { "Vegeta", "Goku", "Gohan", "Trunks" },
                                0,
                                new String[] {
                                                "Correto! Vegeta é o príncipe orgulhoso! 👑",
                                                "Goku é protagonista, mas não príncipe!",
                                                "Gohan é filho de Goku, não príncipe!",
                                                "Trunks é futuro príncipe, mas não agora!"
                                }));

                Collections.shuffle(lista);
                return lista;
        }
}
