package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;


public class OnePieceData {

        public static ArrayList<Pergunta> getOnePiece() {
                ArrayList<Pergunta> lista = new ArrayList<>();

                lista.add(new Pergunta("Quem é o capitão dos Chapéus de Palha?",
                                new String[] { "Roronoa Zoro", "Monkey D. Luffy", "Sanji", "Usopp" }, 1,
                                new String[] {
                                                "Ops! Zoro é o espadachim!",
                                                "Correto! Luffy é o capitão com estilo!",
                                                "Sanji cozinha, não comanda!",
                                                "Usopp é bom de mentira, mas não de liderança!"
                                }));

                lista.add(new Pergunta("Qual é o sonho de Sanji?",
                                new String[] { "Encontrar o One Piece", "Se tornar o Rei dos Piratas",
                                                "Encontrar All Blue", "Dominar Haki" },
                                2,
                                new String[] {
                                                "Não é esse... ele sonha grande na cozinha!",
                                                "Luffy sonha nisso, não Sanji!",
                                                "Acertou! Ele quer encontrar o All Blue!",
                                                "Haki é bom, mas não é o sonho dele!"
                                }));

                lista.add(new Pergunta("Quem comeu a Gomu Gomu no Mi?",
                                new String[] { "Nami", "Zoro", "Luffy", "Chopper" }, 2,
                                new String[] {
                                                "Nami só rouba dinheiro, não come frutas mágicas!",
                                                "Zoro prefere treino e espadas!",
                                                "Acertou! Luffy ficou elástico!",
                                                "Chopper é fofinho, mas não come Gomu Gomu no Mi!"
                                }));

                lista.add(new Pergunta("Qual é o nome do navio atual dos Chapéus de Palha?",
                                new String[] { "Going Merry", "Thousand Sunny", "Red Force", "Sunny Go" }, 1,
                                new String[] {
                                                "Going Merry foi destruído, mas já foi lendário!",
                                                "Correto! O atual é Thousand Sunny!",
                                                "Red Force? Isso é de outro anime!",
                                                "Sunny Go? Quase, mas não é o nome oficial!"
                                }));

                lista.add(new Pergunta("Quem é o espadachim do bando?",
                                new String[] { "Zoro", "Sanji", "Franky", "Usopp" }, 0,
                                new String[] {
                                                "Correto! Zoro corta tudo!",
                                                "Sanji corta comida e chuta os inimigos!",
                                                "Franky constrói, não espada!",
                                                "Usopp só atira mentiras!"
                                }));

                lista.add(new Pergunta("Qual é o poder de Chopper?",
                                new String[] { "Transformação", "Haki", "Logia", "Gelo" }, 0,
                                new String[] {
                                                "Acertou! Chopper pode se transformar!",
                                                "Haki? Só alguns conseguem!",
                                                "Logia é outro tipo de Akuma no Mi!",
                                                "Gelo? Ele não controla isso!"
                                }));

                lista.add(new Pergunta("Quem é o médico do bando?",
                                new String[] { "Chopper", "Sanji", "Nami", "Robin" }, 0,
                                new String[] {
                                                "Correto! Chopper cuida da galera!",
                                                "Sanji cozinha, não cura!",
                                                "Nami só cuida da bússola!",
                                                "Robin descobre história, não medicinas!"
                                }));

                lista.add(new Pergunta("Qual o objetivo de Nico Robin?",
                                new String[] { "Se tornar pirata", "Descobrir o Rio Poneglyph", "Ser cozinheira",
                                                "Encontrar All Blue" },
                                1,
                                new String[] {
                                                "Ela é pirata sim, mas quer algo mais!",
                                                "Acertou! Ela quer decifrar a história do mundo!",
                                                "Cozinhar? Não é a dela!",
                                                "All Blue é Sanji, não Robin!"
                                }));

                lista.add(new Pergunta("Qual personagem é conhecido por suas mentiras exageradas?",
                                new String[] { "Usopp", "Sanji", "Zoro", "Franky" }, 0,
                                new String[] {
                                                "Correto! Usopp é o rei das mentiras!",
                                                "Sanji não mente, só cozinha!",
                                                "Zoro não fala muito, só corta!",
                                                "Franky é excêntrico, mas não mentiroso!"
                                }));

                lista.add(new Pergunta("Quem é o cozinheiro do bando?",
                                new String[] { "Nami", "Sanji", "Chopper", "Robin" }, 1,
                                new String[] {
                                                "Nami só navega, não cozinha!",
                                                "Correto! Sanji manda bem na cozinha!",
                                                "Chopper só cuida da saúde!",
                                                "Robin pesquisa história, não cozinha!"
                                }));

                Collections.shuffle(lista);
                return lista;
        }
}
