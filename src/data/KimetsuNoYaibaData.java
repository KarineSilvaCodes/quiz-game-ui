package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;


public class KimetsuNoYaibaData {

        public static ArrayList<Pergunta> getKimetsuNoYaiba() {
                ArrayList<Pergunta> lista = new ArrayList<>();

                lista.add(new Pergunta("Quem é o protagonista da série?",
                                new String[] { "Tanjiro Kamado", "Nezuko Kamado", "Zenitsu Agatsuma",
                                                "Inosuke Hashibira" },
                                0,
                                new String[] { "Correto! Tanjiro é o protagonista!", "Nezuko é irmã de Tanjiro!",
                                                "Zenitsu é aliado!", "Inosuke é aliado!" }));

                lista.add(new Pergunta("Quem é a irmã de Tanjiro transformada em demônio?",
                                new String[] { "Nezuko", "Muzan", "Shinobu", "Kanao" },
                                0,
                                new String[] { "Correto! Nezuko é a irmã de Tanjiro!", "Muzan é o vilão!",
                                                "Shinobu é Hashira!", "Kanao é caçadora!" }));

                lista.add(new Pergunta("Quem é o vilão principal da série?",
                                new String[] { "Muzan Kibutsuji", "Tanjiro", "Zenitsu", "Giyu" },
                                0,
                                new String[] { "Correto! Muzan é o vilão supremo!", "Tanjiro é herói!",
                                                "Zenitsu é aliado!", "Giyu é Hashira!" }));

                lista.add(new Pergunta("Qual é a respiração de Tanjiro?",
                                new String[] { "Sol", "Fogo", "Relâmpago", "Besta" },
                                0,
                                new String[] { "Correto! Tanjiro usa respiração do Sol!", "Fogo? Não!",
                                                "Relâmpago é do Zenitsu!", "Besta é do Inosuke!" }));

                lista.add(new Pergunta("Quem é o Hashira dos Insetos?",
                                new String[] { "Shinobu Kocho", "Giyu Tomioka", "Kyojuro Rengoku", "Tengen Uzui" },
                                0,
                                new String[] { "Correto! Shinobu é Hashira dos Insetos!", "Giyu é da Água!",
                                                "Rengoku é da Chama!", "Uzui é do Som!" }));

                lista.add(new Pergunta("Quem é conhecido por usar respiração da Chama?",
                                new String[] { "Kyojuro Rengoku", "Tanjiro", "Inosuke", "Zenitsu" },
                                0,
                                new String[] { "Correto! Rengoku é Hashira da Chama!", "Tanjiro usa Sol!",
                                                "Inosuke usa Besta!", "Zenitsu usa Relâmpago!" }));

                lista.add(new Pergunta("Quem usa a respiração do Relâmpago?",
                                new String[] { "Zenitsu Agatsuma", "Tanjiro", "Inosuke", "Nezuko" },
                                0,
                                new String[] { "Correto! Zenitsu usa Relâmpago!", "Tanjiro usa Sol!",
                                                "Inosuke usa Besta!", "Nezuko não usa respiração!" }));

                lista.add(new Pergunta("Quem usa a respiração da Besta?",
                                new String[] { "Inosuke Hashibira", "Zenitsu", "Tanjiro", "Giyu" },
                                0,
                                new String[] { "Correto! Inosuke usa respiração Besta!", "Zenitsu usa Relâmpago!",
                                                "Tanjiro usa Sol!", "Giyu usa Água!" }));

                lista.add(new Pergunta("Quem é conhecido por atacar silenciosamente e rápido?",
                                new String[] { "Kanao Tsuyuri", "Tanjiro", "Zenitsu", "Inosuke" },
                                0,
                                new String[] { "Correto! Kanao é ágil e silenciosa!", "Tanjiro é mais direto!",
                                                "Zenitsu tem medo!", "Inosuke é explosivo!" }));

                lista.add(new Pergunta("Quem é o líder da Corporação dos Caçadores de Demônios?",
                                new String[] { "Kagaya Ubuyashiki", "Tanjiro", "Giyu", "Hashiras" },
                                0,
                                new String[] { "Correto! Kagaya é o líder!",
                                                "Tanjiro não!", "Giyu é Hashira!", "Hashiras são vários!" }));

                Collections.shuffle(lista);
                return lista;
        }
}
