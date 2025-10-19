package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NanatsuData {

        public static List<Pergunta> getNanatsu() {
                ArrayList<Pergunta> lista = new ArrayList<>();

                lista.add(new Pergunta("Quem é o líder dos Sete Pecados Capitais?",
                                new String[] { "Meliodas", "Ban", "King", "Escanor" },
                                0,
                                new String[] { "Ops! Ban é forte, mas não lidera!",
                                                "Correto! Meliodas comanda o grupo!",
                                                "King cuida da floresta, não lidera!",
                                                "Escanor brilha, mas não lidera!" }));

                lista.add(new Pergunta("Qual é o poder de Ban?",
                                new String[] { "Imortalidade", "Manipulação de Fogo", "Controle da Floresta",
                                                "Transformação Divina" },
                                0,
                                new String[] { "Acertou! Ban é imortal!", "Fogo? Isso é Escanor às vezes!",
                                                "Controle da floresta? King é que faz isso!",
                                                "Transformação divina? Só Escanor no auge!" }));

                lista.add(new Pergunta("Quem é conhecido como o 'Orgulho do Pecado do Sol'?",
                                new String[] { "Escanor", "Meliodas", "Diane", "Gowther" },
                                0,
                                new String[] { "Correto! Escanor brilha com orgulho!", "Meliodas tem o pecado da Ira!",
                                                "Diane é da Inveja! Quase!", "Gowther é do Pecado da Luxúria!" }));

                lista.add(new Pergunta("Qual é o pecado de Diane?",
                                new String[] { "Inveja", "Ira", "Gula", "Avareza" },
                                0,
                                new String[] { "Correto! Diane é do Pecado da Inveja!", "Ira é do Meliodas!",
                                                "Gula não é dela!", "Avareza? Esse não é nenhum dos principais!" }));

                lista.add(new Pergunta("Quem é o mago do grupo?",
                                new String[] { "Gowther", "King", "Ban", "Escanor" },
                                0,
                                new String[] { "Correto! Gowther é o mago!", "King é o Rei da Floresta!",
                                                "Ban é imortal, não mago!",
                                                "Escanor é força bruta!" }));

                lista.add(new Pergunta("Qual membro é conhecido por sua força sobre-humana durante o dia?",
                                new String[] { "Escanor", "Meliodas", "Ban", "Diane" },
                                0,
                                new String[] { "Correto! Escanor brilha ao sol!",
                                                "Meliodas é forte, mas não depende do sol!",
                                                "Ban é imortal, não solário!", "Diane é gigante, mas não brilha!" }));

                lista.add(new Pergunta("Quem foi ressuscitado pelo Rei Demônio?",
                                new String[] { "Meliodas", "Escanor", "Ban", "King" },
                                0,
                                new String[] { "Acertou! Meliodas tem ligação com o Rei Demônio!",
                                                "Escanor não foi ressuscitado!",
                                                "Ban é imortal, não precisa disso!", "King não foi ressuscitado!" }));

                lista.add(new Pergunta("Qual é o objetivo principal do grupo?",
                                new String[] { "Salvar o reino de Liones", "Dominar o mundo", "Encontrar o One Piece",
                                                "Roubar tesouros" },
                                0,
                                new String[] { "Correto! Eles protegem Liones!", "Dominar o mundo? Nada a ver!",
                                                "One Piece é outro anime!", "Tesouros? Não é o foco deles!" }));

                lista.add(new Pergunta("Qual personagem é imortal e irreverente?",
                                new String[] { "Ban", "Meliodas", "King", "Gowther" },
                                0,
                                new String[] { "Correto! Ban é irreverente e imortal!",
                                                "Meliodas é poderoso, mas não irreverente assim!",
                                                "King é tímido!", "Gowther é lógico, não irreverente!" }));

                lista.add(new Pergunta("Quem é o Rei da Floresta?",
                                new String[] { "King", "Escanor", "Meliodas", "Diane" },
                                0,
                                new String[] { "Correto! King protege a floresta!",
                                                "Escanor brilha, mas não é rei da floresta!",
                                                "Meliodas comanda o grupo, mas não é rei da floresta!",
                                                "Diane é gigante, mas não rei!" }));

                Collections.shuffle(lista);
                return lista;
        }
}
