package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TokyoGhoulData {

    public static List<Pergunta> getTokyoGhoul() {
        ArrayList<Pergunta> lista = new ArrayList<>();

        lista.add(new Pergunta(
                "Quem é o protagonista da série?",
                new String[] { "Ken Kaneki", "Touka Kirishima", "Hideyoshi Nagachika", "Rize Kamishiro" },
                0,
                new String[] {
                        "Correto! Ken Kaneki é o protagonista que muda tudo!",
                        "Touka é importante, mas não é protagonista!",
                        "Hide é amigo, mas não o personagem principal!",
                        "Rize inicia a história, mas não é protagonista!"
                }));

        lista.add(new Pergunta(
                "Qual é a fruta do ghoul que Kaneki se torna?",
                new String[] { "Metamorfose de Kagune", "Quinx", "Hibrido humano-ghoul", "Quimera" },
                2,
                new String[] {
                        "Não é isso... ele se torna um híbrido humano-ghoul!",
                        "Quinx é outro conceito, não ele!",
                        "Acertou! Kaneki vira um híbrido humano-ghoul!",
                        "Quimera é outro tipo de ghoul, mas não Kaneki!"
                }));

        lista.add(new Pergunta(
                "Quem é a ghoul que trabalha no café Anteiku?",
                new String[] { "Touka Kirishima", "Rize Kamishiro", "Nishiki Nishio", "Ayato Kirishima" },
                0,
                new String[] {
                        "Correto! Touka é a atendente do Anteiku! ☕",
                        "Rize não trabalha no café!",
                        "Nishiki é ghoul, mas não trabalha lá!",
                        "Ayato é irmão da Touka, mas não atende no café!"
                }));

        lista.add(new Pergunta(
                "Qual é o nome do melhor amigo humano de Kaneki?",
                new String[] { "Hideyoshi Nagachika", "Touka Kirishima", "Yamori", "Nishiki Nishio" },
                0,
                new String[] {
                        "Acertou! Hide é o melhor amigo humano de Kaneki! 😊",
                        "Touka é amiga, mas não o melhor amigo humano!",
                        "Yamori é inimigo, não amigo!",
                        "Nishiki se torna aliado, mas não é melhor amigo humano!"
                }));

        lista.add(new Pergunta(
                "Quem é o ghoul que sequestra Kaneki e o tortura?",
                new String[] { "Yamori (Jason)", "Nishiki Nishio", "Rize Kamishiro", "Touka Kirishima" },
                0,
                new String[] {
                        "Correto! Yamori, também conhecido como Jason, é o torturador!",
                        "Nishiki não faz isso!",
                        "Rize só causa o acidente inicial!",
                        "Touka nunca tortura Kaneki!"
                }));

        lista.add(new Pergunta(
                "Qual é o café que serve como abrigo para ghouls?",
                new String[] { "Anteiku", "Café Re", "Café Goat", "Café Quinx" },
                0,
                new String[] {
                        "Perfeito! Anteiku é o refúgio dos ghouls! ☕",
                        "Café Re é outro grupo, não o café!",
                        "Café Goat é do Kaneki depois, não este!",
                        "Café Quinx não existe!"
                }));

        lista.add(new Pergunta(
                "Qual é o apelido de Kaneki após se unir ao grupo Goat?",
                new String[] { "Haise Sasaki", "Eyepatch", "Ken Kaneki", "Jason" },
                0,
                new String[] {
                        "Correto! Haise Sasaki é sua nova identidade! 👁️",
                        "Eyepatch é apenas um apelido inicial!",
                        "Ken Kaneki é seu nome antigo!",
                        "Jason é o inimigo!"
                }));

        lista.add(new Pergunta(
                "Quem é o investigador da CCG que persegue Kaneki?",
                new String[] { "Koutarou Amon", "Shuu Tsukiyama", "Nishiki Nishio", "Hideyoshi Nagachika" },
                0,
                new String[] {
                        "Acertou! Koutarou Amon é o investigador da CCG! 🔎",
                        "Shuu Tsukiyama é ghoul, não investigador!",
                        "Nishiki é ghoul, não investigador!",
                        "Hide é humano aliado, mas não investigador!"
                }));

        lista.add(new Pergunta(
                "Qual é a principal habilidade de ghouls?",
                new String[] { "Kagune", "Haki", "Quinx", "Regeneração de humanos" },
                0,
                new String[] {
                        "Correto! Kagune é a arma principal dos ghouls! ⚔️",
                        "Haki é Dragon Ball, não Tokyo Ghoul!",
                        "Quinx é humano com Kagune artificial, não geral!",
                        "Regeneração humana não é habilidade principal de ghouls!"
                }));

        lista.add(new Pergunta(
                "Qual é o objetivo de Kaneki após a transformação?",
                new String[] { "Proteger os ghouls", "Dominar os humanos", "Matar todos da CCG",
                        "Fugir e se esconder" },
                0,
                new String[] {
                        "Correto! Ele quer proteger os ghouls pacíficos! 🖤",
                        "Dominar humanos não é seu objetivo!",
                        "Matar todos da CCG? Não, ele evita mortes desnecessárias!",
                        "Fugir? Ele assume responsabilidades, não apenas se esconder!"
                }));

        Collections.shuffle(lista);
        return lista;
    }
}
