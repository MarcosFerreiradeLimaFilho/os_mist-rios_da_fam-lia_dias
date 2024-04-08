/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package gameobjects.special;

import game.data.GameData;
import gameobjects.ContainerThing;
import gameobjects.GenericThing;
import gameobjects.Room;
import gameobjects.Thing;
import gameobjects.ThingHolder;

/* Here you can define 'special' actions when certain things done
 * with certain objects need to be treated specially
 */
public class Actions {

    public static String putIntoSpecial(Thing t, ThingHolder th, ContainerThing container) {
        String s;
        Thing card;
        Thing slot;
        Thing console;
        Thing viewscreen;

        s = "";
        card = GameData.things.get("activationCard");
        slot = GameData.things.get("slot");
        console = GameData.things.get("console");
        viewscreen = GameData.things.get("viewscreen");

        if ((card == t) && (slot == container)) {
            /*
            s = "The activation card slides smoothly into the slot\n"
                    + "The console displays 'Activation sequence initialized'\n"
                    + "A low rumbling echoes throughout the starship as the\n"
                    + "FTL thrusters come online. Suddenly there is a blur of\n"
                    + "light as the stars streak past the viewscreen. The\n"
                    + "starship is headed towards an unknown destination.\n"
                    + "The rest is up to you...\n"
                    + "(To be continued)";
            */
            
            s = "O cartão desce de forma suave no conector\n"
                    + "O painel exibe a mensagem 'Sequência de ativação iniciada'\n"
                    + "Um estrondo baixo ecoa por toda a nave a medida que\n"
                    + "os motores dão a partida. Uma mancha de luz surge \n"
                    + "a medida que as estrelas atravessam a tela. A\n"
                    + "espaçonave adentra no espaço profundo.\n"
                    + "(FIM)";

            // console.setLongDescription("display console built into the desk.\nIt is displaying this message:\n"
            //        + "Starship currently in FTL mode (operate with caution!)");
            
            console.setLongDescription("painel de controle localizado na mesa de comando.\nEle está exibindo a mensagem:\n"
        + "Espaçonave em velocidade de dobra (dirija com cuidado)");
            
            // viewscreen.setLongDescription("a huge viewscreen showing lines of starlight zooming past\n" +
            //        "at faster-than-lightspeed");
            
            viewscreen.setLongDescription("grande tela exibindo rastros de estrelas atravessando o espaço\n" +
            "a uma velocidade superior a da luz");
            
            
            th.remove(t); // remove card from game
        }
        return s;
    }
    
    // TODO: Add more special actions
     public static String dropSpecial(Thing t, ThingHolder th, Room r, int mass) {
         String s;
         s = "";
         return s;
     }
     
     public static String takeSpecial(Thing t, ThingHolder th, Room r, int mass) {
         String s;
         s = "";
         return s;
     }
}
