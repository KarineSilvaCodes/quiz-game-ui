package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;

public class BleachData {

        public static ArrayList<Pergunta> getBleach() {
                ArrayList<Pergunta> perguntas = new ArrayList<>();

                perguntas.add(new Pergunta(
                                "Quem é o protagonista de Bleach?",
                                new String[] { "Ichigo Kurosaki", "Rukia Kuchiki", "Renji Abarai", "Byakuya Kuchiki" },
                                0,
                                new String[] {
                                                "Correto! Ichigo é o protagonista!",
                                                "Rukia ajuda, mas não é protagonista!",
                                                "Renji é coadjuvante!",
                                                "Byakuya é nobre do Gotei 13!"
                                }));

                perguntas.add(new Pergunta(
                                "Qual é a zanpakutou de Ichigo?",
                                new String[] { "Zangetsu", "Sode no Shirayuki", "Senbonzakura", "Hyorinmaru" },
                                0,
                                new String[] {
                                                "Correto! Zangetsu é a espada de Ichigo!",
                                                "Sode no Shirayuki é de Rukia!",
                                                "Senbonzakura é de Byakuya!",
                                                "Hyorinmaru é de Toshiro!"
                                }));

                perguntas.add(new Pergunta(
                                "Quem é o capitão do 6º esquadrão do Gotei 13?",
                                new String[] { "Byakuya Kuchiki", "Renji Abarai", "Rukia Kuchiki", "Kisuke Urahara" },
                                0,
                                new String[] {
                                                "Correto! Byakuya é o capitão do 6º esquadrão!",
                                                "Renji é tenente!",
                                                "Rukia é shinigami de substituição!",
                                                "Urahara é ex-capitão do 12º esquadrão!"
                                }));

                perguntas.add(new Pergunta(
                                "Quem é conhecido como 'Shinigami substituto'?",
                                new String[] { "Ichigo Kurosaki", "Rukia Kuchiki", "Renji Abarai", "Uryu Ishida" },
                                0,
                                new String[] {
                                                "Correto! Ichigo é o Shinigami substituto!",
                                                "Rukia treina Ichigo!",
                                                "Renji é aliado!",
                                                "Uryu é Quincy!"
                                }));

                perguntas.add(new Pergunta(
                                "Qual espada possui a habilidade Senbonzakura Kageyoshi?",
                                new String[] { "Byakuya Kuchiki", "Ichigo Kurosaki", "Rukia Kuchiki",
                                                "Kenpachi Zaraki" },
                                0,
                                new String[] {
                                                "Correto! Byakuya usa a Senbonzakura Kageyoshi!",
                                                "Ichigo usa Zangetsu!",
                                                "Rukia usa Sode no Shirayuki!",
                                                "Kenpachi usa sua própria zanpakutou!"
                                }));

                Collections.shuffle(perguntas);
                return perguntas;
        }
}
