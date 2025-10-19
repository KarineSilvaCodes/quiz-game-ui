package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeathNoteData {

        public static List<Pergunta> getDeathNote() {
                List<Pergunta> lista = new ArrayList<>();

                lista.add(new Pergunta(
                                "Quem encontrou o Death Note primeiro?",
                                new String[] { "Light Yagami", "L", "Ryuk", "Misa Amane" },
                                0,
                                new String[] {
                                                "Correto! Light é quem encontra o caderno!",
                                                "L só investiga depois!",
                                                "Ryuk só deixou cair!",
                                                "Misa só pega depois!"
                                }));
                lista.add(new Pergunta(
                                "Qual é o objetivo principal de Light?",
                                new String[] { "Criar um mundo sem crime", "Se tornar detetive", "Roubar tesouros",
                                                "Se tornar rei dos piratas" },
                                0,
                                new String[] {
                                                "Correto! Light quer um mundo sem crime!",
                                                "Detetive? L é que faz isso!",
                                                "Tesouros? Não é o foco!",
                                                "Rei dos piratas? Isso é outro anime!"
                                }));
                lista.add(new Pergunta(
                                "Quem é o famoso detetive que persegue Kira?",
                                new String[] { "L", "Near", "Mello", "Ryuk" },
                                0,
                                new String[] {
                                                "Correto! L é o detetive genial!",
                                                "Near aparece depois, mas não primeiro!",
                                                "Mello ajuda depois, mas não é o inicial!",
                                                "Ryuk é o Shinigami, não detetive!"
                                }));
                lista.add(new Pergunta(
                                "Quem é a segunda dona do Death Note no anime?",
                                new String[] { "Misa Amane", "Light Yagami", "Rem", "Ryuk" },
                                0,
                                new String[] {
                                                "Correto! Misa pega o caderno depois!",
                                                "Light já tinha o caderno!",
                                                "Rem é o Shinigami protetor!",
                                                "Ryuk é só observador!"
                                }));
                lista.add(new Pergunta(
                                "Qual é o nome do Shinigami que deixa o caderno cair?",
                                new String[] { "Ryuk", "Rem", "Sidoh", "Gelus" },
                                0,
                                new String[] {
                                                "Correto! Ryuk adora ver o caos!",
                                                "Rem protege Misa!",
                                                "Sidoh aparece depois!",
                                                "Gelus é outro Shinigami!"
                                }));
                lista.add(new Pergunta(
                                "Qual é a regra principal do Death Note?",
                                new String[] { "Qualquer pessoa cujo nome seja escrito morre", "O dono vira imortal",
                                                "Pode reviver qualquer pessoa", "Concede poderes de detetive" },
                                0,
                                new String[] {
                                                "Correto! Escreveu o nome = morreu!",
                                                "Não, não há imortalidade assim!",
                                                "Não dá pra reviver!",
                                                "Poder de detetive não existe no caderno!"
                                }));
                lista.add(new Pergunta(
                                "Quem consegue se aproximar de Light sem suspeitar inicialmente?",
                                new String[] { "Misa Amane", "L", "Ryuk", "Near" },
                                0,
                                new String[] {
                                                "Correto! Misa confia e se aproxima!",
                                                "L sempre suspeita!",
                                                "Ryuk observa só!",
                                                "Near aparece depois da história inicial!"
                                }));
                lista.add(new Pergunta(
                                "Qual é o nome do verdadeiro detetive rival de Kira no final?",
                                new String[] { "Near", "L", "Mello", "Ryuk" },
                                0,
                                new String[] {
                                                "Correto! Near resolve o caso!",
                                                "L morre antes!",
                                                "Mello ajuda, mas não vence!",
                                                "Ryuk só observa!"
                                }));
                lista.add(new Pergunta(
                                "Qual é o apelido de Light quando ele é famoso por matar criminosos?",
                                new String[] { "Kira", "Shinigami", "L", "God of Death" },
                                0,
                                new String[] {
                                                "Correto! Kira aterroriza o mundo!",
                                                "Shinigami é Ryuk!",
                                                "L é o detetive!",
                                                "God of Death é tradução, mas não apelido usado na história!"
                                }));
                lista.add(new Pergunta(
                                "Quem é apaixonado por Light e também usa o Death Note?",
                                new String[] { "Misa Amane", "Near", "Ryuk", "L" },
                                0,
                                new String[] {
                                                "Correto! Misa é fã e se envolve!",
                                                "Near não tem relação amorosa!",
                                                "Ryuk só observa!",
                                                "L não usa o Death Note!"
                                }));

                Collections.shuffle(lista);
                return lista;
        }
}
