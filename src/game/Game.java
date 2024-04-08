

/*
 * Portuguese version of Star Crash.
 * Original code and credits:
 * BIFF (Bitwise Interactive Fiction Framework)
 * Bitwise Books & Courses
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 *
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */

package game;

import game.data.VocabularyData;
import game.data.GameData;
import game.grammar.NounPhrase;
import gameobjects.Actor;
import globals.Dir;

public class Game implements java.io.Serializable {

    private Actor player;  // objeto que representa o jogador  

    public Game() {
        VocabularyData.initVocab();
        GameData.initGame();
        player = GameData.player;
    }

    public String openObWithSomething(NounPhrase np, NounPhrase np2) {
        return player.openWith(np, np2);
    }

    public String lockObWithSomething(NounPhrase np, NounPhrase np2) {
        return player.lockWith(np, np2);
    }

    public String unlockObWithSomething(NounPhrase np, NounPhrase np2) {
        return player.unlockWith(np, np2);
    }

    public String putObInContainer(NounPhrase np, NounPhrase np2) {
        return player.putInto(np, np2);
    }

    public String openOb(NounPhrase np) {
        return player.openOb(np);
    }

    public String closeOb(NounPhrase np) {
        return player.closeOb(np);
    }

    public String lockOb(NounPhrase np) {
        return player.lockOb(np);
    }

    public String unlockOb(NounPhrase np) {
        return player.unlockOb(np);
    }

    String takeOb(NounPhrase np) {
        String retStr;

        retStr = player.take(np);
        return retStr;
    }

    String dropOb(NounPhrase np) {
        String retStr;

        retStr = player.drop(np);
        return retStr;
    }

    void movePlayerTo(Dir dir) {
        if (player.moveTo(dir)) {
            showStr(player.describeLocation(false));
        } else {
            showStr("Não tem como ir nessa direção.");
        }
    }

    void goN() {
        movePlayerTo(Dir.NORTH);
    }

    void goS() {
        movePlayerTo(Dir.SOUTH);
    }

    void goW() {
        movePlayerTo(Dir.WEST);
    }

    void goE() {
        movePlayerTo(Dir.EAST);
    }

    void goUp() {
        movePlayerTo(Dir.UP);
    }

    void goDown() {
        movePlayerTo(Dir.DOWN);
    }

    void look() {
        showStr(player.describeLocation(true));
    }

    // imprime a string passada como parâmetro sem o \n.
    void showStr(String s) {
        if (s.endsWith("\n")) {
            s = s.substring(0, s.length() - 1);
        }
        if (!s.isEmpty()) {
            System.out.println(s);
        }
    }

    void showInventory() {
        showStr(player.inventory());
    }

    String lookAtOb(NounPhrase np) {
        return player.lookAt(np);
    }

    String lookInOb(NounPhrase np) {
        return player.lookIn(np);
    }

    public void showIntro() {
        showStr(GameData.introText());
    }

    public String runCommand(String inputstr) {
        String s;
        String lowstr;

        s = "ok";
        lowstr = inputstr.trim().toLowerCase();

        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "Digite um comando";
            } else {
                s = Parser.runCommand(inputstr);
            }
        }
        return s;
    }

    // Método para fins de debug, envia o comando para o jogo.
    void showTest(String s) {
        showStr("> " + s);
        showStr(runCommand(s));
    }

    // imprime a massa de um objeto.
    void showMass(int m) {
        showStr("Massa=" + m);
    }

    // método para fins de debug, entrando comandos para resolver o jogo.
    void test() {

    	showTest("examine local");  
    	showTest("examine painel");  
    	// examine o local não funciona. Verificar porque.
    	showTest("olhe o painel");
    	showTest("examine conector");
    	showTest("olhe conector");
        showTest("esquerda");
        showTest("abra caixa grande");
        showTest("examine caixa grande");
        showTest("olhe caixa pequena");
        showTest("abra caixa pequena");
        showTest("olhe caixa pequena");
        showTest("examine caixa pequena");
        showTest("abra caixa minúscula");
        showTest("olhe caixa minúscula");
        showTest("examine caixa minúscula");
        showTest("pegue caixa pequena"); // para que?
        showTest("pegue chave de prata");
        showTest("examine armário");
        showTest("abra armário");
        showTest("destranque armário");
        showTest("destranque armário com a chave de prata");
        showTest("direita");
        showTest("desça");
        showTest("direita");       
        showTest("desça");
        showTest("olhe"); 
        showTest("direita");
        showTest("sul"); 
        showTest("sul"); 
        showTest("oeste"); 
        showTest("oeste"); 
        showTest("leste"); 
        showTest("leste"); 
        showTest("olhe planta carnívora");
        showTest("examine planta carnívora");
        showTest("pegue chave dourada");
        showTest("norte");
        showTest("norte");
        showTest("esquerda");
        showTest("esquerda");
        showTest("suba");
        showTest("suba");
        showTest("esquerda");
        showTest("destranque armário com chave");
        showTest("destranque armário com chave dourada");
        showTest("abra armário");
        showTest("olhe armário");
        showTest("examine armário");
        showTest("pegue cartão");
        showTest("direita");
        showTest("insira cartão no conector");
        showTest("olhe painel");
        showTest("olhe tela");
        showTest("pegue relógio de bolso");
        
        
        
            
    }

    
}
