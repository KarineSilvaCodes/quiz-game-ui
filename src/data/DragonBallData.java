package src.data;

import src.core.Pergunta;
import java.util.ArrayList;
import java.util.Collections;


public class DragonBallData {

    public static ArrayList<Pergunta> getDragonBall() {
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

        lista.add(new Pergunta(
            "Quem é o filho mais velho de Goku?",
            new String[] { "Gohan", "Goten", "Trunks", "Pan" },
            0,
            new String[] {
                "Correto! Gohan é o filho mais velho de Goku! 🎓",
                "Goten é o caçula!",
                "Trunks é filho de Vegeta e Bulma!",
                "Pan ainda é bebê nessa fase!"
            }));

        lista.add(new Pergunta(
            "Qual vilão devora planetas e é inimigo de Goku e os amigos?",
            new String[] { "Freeza", "Cell", "Majin Boo", "Jiren" },
            0,
            new String[] {
                "Correto! Freeza é o tirano espacial! ❄️",
                "Cell é artificial, mas não devora planetas!",
                "Majin Boo é um vilão diferente e engraçado!",
                "Jiren é do Torneio do Poder, não devora planetas!"
            }));

        lista.add(new Pergunta(
            "Quem é conhecido como o Androide que se torna amigo de Goku?",
            new String[] { "Android 18", "Cell", "Android 17", "Dr. Gero" },
            0,
            new String[] {
                "Correto! Android 18 eventualmente se torna aliada! 🤝",
                "Cell é o vilão que absorve androides!",
                "Android 17 também se torna aliado, mas 18 é mais icônica!",
                "Dr. Gero é o cientista, não o aliado!"
            }));

        lista.add(new Pergunta(
            "Qual é a técnica que dispara uma rajada de energia das mãos?",
            new String[] { "Kamehameha", "Final Flash", "Destructo Disc", "Spirit Bomb" },
            0,
            new String[] {
                "Correto! Kamehameha é a assinatura de Goku! 🌊",
                "Final Flash é técnica do Vegeta!",
                "Destructo Disc é de Kuririn!",
                "Spirit Bomb também é do Goku, mas é mais lenta e poderosa!"
            }));

        lista.add(new Pergunta(
            "Quem é o mestre de artes marciais que treinou Goku quando criança?",
            new String[] { "Mestre Kame", "Kami", "Piccolo", "Yamcha" },
            0,
            new String[] {
                "Correto! Mestre Kame treinou o Goku! 🐢",
                "Kami é o guardião da Terra, não o mestre!",
                "Piccolo inicialmente é inimigo de Goku!",
                "Yamcha é amigo, mas não treinador!"
            }));

        lista.add(new Pergunta(
            "Qual é o nome do filho de Vegeta e Bulma que luta ao lado de Goku?",
            new String[] { "Trunks", "Goten", "Pan", "Gohan" },
            0,
            new String[] {
                "Correto! Trunks é o filho de Vegeta e Bulma! ⚔️",
                "Goten é filho de Goku!",
                "Pan é neta de Goku!",
                "Gohan é irmão mais velho de Goten!"
            }));

        lista.add(new Pergunta(
            "Qual é a forma mais poderosa de Goku no Torneio do Poder?",
            new String[] { "Ultra Instinct", "Super Saiyajin Blue", "Super Saiyajin 3", "Kaioken" },
            0,
            new String[] {
                "Correto! Ultra Instinct é a forma máxima de Goku nesse arco! ✨",
                "Super Saiyajin Blue é forte, mas inferior ao Ultra Instinct!",
                "Super Saiyajin 3 é do arco anterior!",
                "Kaioken é útil, mas não é a forma final!"
            }));

        Collections.shuffle(lista);
        return lista;
    }
}
