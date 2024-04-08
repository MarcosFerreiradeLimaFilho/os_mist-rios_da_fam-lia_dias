/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package game.data;

/*
 * Here you can initialize the objects (rooms, treasures etc.) of the game
 */
import gameobjects.Actor;
import gameobjects.ContainerThing;
import gameobjects.GameThing;
import gameobjects.GenericThing;
import gameobjects.LockableThing;
import gameobjects.Room;
import gameobjects.Thing;
import globals.Dir;
import globals.Mass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GameData implements java.io.Serializable {

    // NOTE: 
    // map: 
    // This is not needed for the functioning of this game
    // since the player (an Actor object) can move from Room to Room
    // autonomously. However, a sequential list of all Rooms is useful
    // for debugging. 
    // 
    // things: 
    // The HashMap of things lets you find a thing (by its key) 
    // when you need to verify its state (open, closed, etc.) Again this
    // is not needed for the functioning of the game but it's useful
    // when debugging.
    public static ArrayList<Room> map; // the map - an ArrayList of Rooms    
    public static HashMap<String, Thing> things; // treasures
    public static Actor player;  // player - provides 'first person perspective'  
    private static String introtext = ""; // intro description

    public static void initGame() {

        // To construct a new Game, you should create and initialze objects 
        // in the order show. That's because some objects require other
        // objects - for example, all Rooms must be created before they
        // are initialized because Rooms refernce other Rooms for their 'exits'
        // --- construct a new adventure ---
        // 1) --- Create rooms ---
        // Room readyRoom = new Room("Ready Room");
        /* 
        Room readyRoom = new Room("Sala de espera");
        
        Room bridge = new Room("Ponte de comando");
        // Room meetingRoom = new Room("Meeting Room");
        Room meetingRoom = new Room("Sala de reunião");
        Room engineRoom = new Room("Engenharia");
        Room holoDeck = new Room("Holo Deck");
        // Room corridor = new Room("Corridor");
        Room corridor = new Room("Corredor");
        // Room basement = new Room("Basement");
        Room basement = new Room("Porão");
        Room diningRoom = new Room("Dining Room");
        Room hydroponicsNorth = new Room("Hidroponia");
        Room hydroponicsCentral = new Room("Hidroponia");
        Room hydroponicsSouth = new Room("Hidroponia");
        Room greenhouse = new Room("Greenhouse");
        */
        // --- Create new rooms ---
        Room laboratory = new Room("Laboratório de Perícia");
        Room frontHouse = new Room("Frente da Casa de Branca Dias");
        Room roomHouse = new Room("Sala da Casa de Branca Dias");
        Room bathroomHouse = new Room("Banheiro da Casa de Branca Dias");
        Room weirShallow = new Room("Açude Raso");
        Room weirBottom = new Room("Açude Fundo");
        Room florestMargin = new Room("Margem da Floresta");
        Room cemetery = new Room("Cemitério da Família");
        Room behindHouse = new Room("Parte de Trás da Casa de Branca Dias");
        Room tunnelOne = new Room("Túnel 1");
        Room tunnelTwo = new Room("Túnel 2");
        Room tunnelThree = new Room("Túnel 3");
        
        // 2) --- Create Containers ---
        //   small cardboard box
        ContainerThing cardboard_box = new ContainerThing("caixa", "caixa pequena de papelão", Mass.SMALL);
        cardboard_box.setOpenable(true);
        cardboard_box.setOpen(false);
        cardboard_box.addAdjectives(new String[]{"pequena", "papelão"});

        //  big wooden box (caixa grande de madeira)
        // ContainerThing wooden_box = new ContainerThing("box", "box big wooden", Mass.MEDIUM);
        ContainerThing wooden_box = new ContainerThing("caixa", "caixa grande de madeira", Mass.MEDIUM);
        
        wooden_box.setOpenable(true);
        wooden_box.setOpen(false);
        // wooden_box.addAdjectives(new String[]{"big", "wooden"});
        
        wooden_box.addAdjectives(new String[]{"grande", "madeira"});

        //   tiny cardboard box
        ContainerThing tinybox = new ContainerThing("caixa", "caixa minúscula de ônix", Mass.TINY);
        tinybox.setOpenable(true);
        tinybox.setOpen(false);
        tinybox.addAdjectives(new String[]{"minúscula", "ônix"});
        tinybox.setLongDescription("caixa minúscula feita de ônix primorosamente esculpido");

        // ContainerThing slot = new ContainerThing("slot", "small slot", Mass.TINY, false, false, false, true);
        ContainerThing slot = new ContainerThing("conector", "conector pequeno", Mass.TINY, false, false, false, true);
       
        slot.addAdjectives(new String[]{"pequeno"});
        slot.setShow(false);

        //   cupboard (locked)
        LockableThing cupboard = new LockableThing("armário", "armário na parede", Mass.MEDIUM, false, false, true, false, true);
        cupboard.setShow(false);

        // pitcher plant
        ContainerThing pitcherPlant = new ContainerThing("planta", "planta carnívora", Mass.SMALL);
        pitcherPlant.setOpen(true);
        pitcherPlant.setTakable(false);
        pitcherPlant.addAdjectives(new String[]{"carnívora"});
        
        // --- Create New Containers ---
        
        //Alçapão
        ContainerThing trapdoor = new ContainerThing("Alçapão", "Alçapão no chão do banheiro", Mass.MEDIUM);
        trapdoor.setOpenable(true);
        trapdoor.setOpen(false);
        trapdoor.addAdjectives(new String[]{"chão", "banheiro"});

        // 3) --- Create Game Things (and Generic Things) --- 
        
        // GameThing desk = new GameThing("desk", "metal control desk", Mass.BIG, false, false);
        GameThing desk = new GameThing("mesa", "mesa de controle metálica", Mass.BIG, false, false);
        desk.addAdjectives(new String[]{"metálica", "controle"});
        desk.setLongDescription("mesa de controle metálica. O controle da nave faz parte dela.\n"
        + "Existe um pequeno conector nela");
        // desk.setLongDescription("metal control desk. There is a console built into the desk.\n"
        //         + "There is a small slot beneath the console");
        desk.setShow(false);

        // GameThing console = new GameThing("console", "display console", Mass.MEDIUM, false, false);
        GameThing console = new GameThing("painel", "painel de controle", Mass.MEDIUM, false, false);
        console.addAdjectives(new String[]{"de", "controle"});
        // console.setLongDescription("display console built into the desk.\nIt is displaying this message:\n"
        //         + "Place activation card into slot to engage faster-than-light drive");
        console.setLongDescription("painel de controle localizado na mesa de comando.\nEle está exibindo a mensagem:\n"
        + "Insira cartão de ativação no conector para ligar o motor de dobra");
 
        console.setShow(false);

        GameThing goldKey = new GameThing("chave", "chave dourada", Mass.TINY);
        goldKey.addAdjectives(new String[]{"pequena", "dourada"});
        goldKey.setLongDescription("chave pequena dourada");

        GameThing silverKey = new GameThing("chave", "chave de prata", Mass.TINY);
        silverKey.setAdjectives(new ArrayList<>(Arrays.asList("pequena", "prata")));
        silverKey.setLongDescription("chave pequena de prata");

        // GameThing activationCard = new GameThing("card", "small, plastic activation card", Mass.TINY);
        GameThing activationCard = new GameThing("cartão", "cartão de ativação de plástico", Mass.TINY);
        // activationCard.addAdjectives(new String[]{"small", "activation", "plastic"});
        activationCard.addAdjectives(new String[]{"ativação", "plástico"});

        // GameThing viewscreen = new GameThing("viewscreen", "huge viewscreen", Mass.HUGE);
        GameThing viewscreen = new GameThing("tela", "tela enorme", Mass.HUGE);
        viewscreen.setTakable(false);
        viewscreen.setShow(false);
        viewscreen.addAdjectives(new String[]{"enorme"});
        viewscreen.setLongDescription("grande tela exibindo incontáveis estrelas");

        // GenericThings (scenery objects - not intended to be 'used' or taken)
        GenericThing lights = new GenericThing("lights", "flashing lights set into the walls", true);
        GenericThing plants = new GenericThing("plants", "huge spiky plants", true);
        GenericThing plant = new GenericThing("plant", "huge spiky plant", false);

        plant.addAdjectives(new String[]{"huge", "spiky"});
        plants.addAdjectives(new String[]{"huge", "spiky"});
        lights.addAdjectives(new String[]{"flashing"});
        
        //--- Create new Game Things (and Generic Things) --- 
        
        //Kit de Autópsia
        GameThing kit = new GameThing("Kit", "Kit de autópsia", Mass.UNKNOWN);
        
        //Lupa
        GameThing loupe = new GameThing("Lupa", "Lupa de investigação", Mass.UNKNOWN);
        
        //Lanterna
        GameThing flashlight = new GameThing("Lanterna", "Lanterna de investigação", Mass.UNKNOWN);
        
        //Equipamento de Mergulho
        GameThing divingEquipment = new GameThing("Equipamento de mergulho", "Equipamento de Mergulho", Mass.UNKNOWN);
        
        //Relógio
        GameThing clock = new GameThing("Relógio", "Relógio de bolso", Mass.TINY);
        clock.setAdjectives(new ArrayList<>(Arrays.asList("pequeno", "bolso")));
        clock.setLongDescription("pequeno relógio de bolso que parou de funcionar e consta o horário 04:20");

        //Chave de Madeira
        GameThing key = new GameThing("Chave", "Chave de Madeira", Mass.TINY);
        key.setAdjectives(new ArrayList<>(Arrays.asList("pequena", "madeira")));
        key.setLongDescription("chave pequena de madeira");
        
        

        // 4) --- Add Things to Containers (that is, put them "into" Containers)
        wooden_box.addThing(cardboard_box);
        cardboard_box.addThing(tinybox);
        tinybox.addThing(silverKey);
        pitcherPlant.addThing(goldKey);
        cupboard.addThing(activationCard);

        // 5) --- Add objects to Rooms  
        // --- new ---
        laboratory.addThing(kit);
        laboratory.addThing(loupe);
        laboratory.addThing(flashlight);
        
        tunnelThree.addThing(divingEquipment);
        
        frontHouse.addThing(clock);
        
        cemetery.addThing(key);
        
        // 6) Set any 'special' attributes
        cupboard.canBeUnlockedWith(goldKey);

        // 7) Optional but recommended - add all game objects to things
        // --- add all things to HashMap (for debugging)
        things = new HashMap<>();
        
        // --- new --- 
        things.put("kit", kit);
        things.put("loupe", loupe);
        things.put("flashlight", flashlight);
        things.put("divingEquipment", divingEquipment);
        things.put("clock", clock);
        things.put("key", key);
        

        // 8) Initialize rooms (including adding others room objects as 'exits'
        // and adding the pre-created lists (which may contain objects or may be empty)
        //           N,        S,           W,         E,       [Up],      [Down])
        // readyRoom
       
        
        //Laboratório. 
        //           N,        S,           W,         E
        laboratory.init("no laboratório de perícia de Recife - PE. \nUma grande mesa onde se vê o cadáver de uma mulher sobre ela",
        		frontHouse, Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT );
        
        //Frente da casa
        //           N,        S,           W,         E,
        frontHouse.init("em um sobrado elegante",
        		roomHouse, Dir.NOEXIT, weirShallow, florestMargin);

        //Sala da casa
        //           N,        S,           W,         E,
        roomHouse.init("na sala de estar, que contém vários móveis nobres",
                Dir.NOEXIT, frontHouse, bathroomHouse, Dir.NOEXIT);
        
        //Banheiro da casa
        //           N,        S,           W,         E,
        bathroomHouse.init("no branheiro, ele é enorme para o seu tamanho e parece conter um chão falso",
        		tunnelOne, Dir.NOEXIT, behindHouse, roomHouse);
        
        //Parte de trás da casa
        //           N,        S,           W,         E,
        behindHouse.init("na parte de trás da casa",
                Dir.NOEXIT, bathroomHouse, weirShallow, florestMargin);
        
        //Açude raso
        //           N,        S,           W,         E,
        weirShallow.init("no açude raso, o corpo foi encontrado aqui",
                behindHouse,  Dir.NOEXIT, weirBottom, frontHouse);
        
        //Açude fundo
        //           N,        S,           W,         E,
        weirBottom.init("no açude fundo, parece que tem algo escondido nele",
                Dir.NOEXIT,  Dir.NOEXIT, Dir.NOEXIT, weirShallow);
        
        //Margem da floresta
        //           N,        S,           W,         E,
        florestMargin.init("em uma sala de reunião típica",
                behindHouse, cemetery, frontHouse, Dir.NOEXIT);
        
        //Cemitério
        //           N,        S,           W,         E,
        cemetery.init("no cemitério da família dias ",
                florestMargin,  Dir.NOEXIT, Dir.NOEXIT, Dir.NOEXIT);
        
        //Túnel 1
        //           N,        S,           W,         E,
        tunnelOne.init("no primeiro túnel, parece haver mais dois",
                tunnelThree,  Dir.NOEXIT, bathroomHouse, tunnelTwo);
        
        //Túnel 2
        //           N,        S,           W,         E,
        tunnelTwo.init("no segundo túnel",
                tunnelThree,  cemetery, tunnelOne, Dir.NOEXIT);
        
        //Túnel 3
        //           N,        S,           W,         E,
        tunnelOne.init("no terceiro túnel",
                Dir.NOEXIT,tunnelOne, behindHouse, tunnelTwo);
        
        // 9) Optional but recommended - add Rooms to map
        // create list of rooms (for debugging)
        map = new ArrayList<>();
        //--- new ---
        map.add(laboratory);
        map.add(frontHouse);
        map.add(roomHouse);
        map.add(bathroomHouse);
        map.add(weirShallow);
        map.add(weirBottom);
        map.add(florestMargin);
        map.add(cemetery);
        map.add(behindHouse);
        map.add(tunnelOne);
        map.add(tunnelTwo);
        map.add(tunnelThree);
        
        // 10) create player and set location
        // player = new Actor("player", "loveable game-player", bridge);
        player = new Actor("player", "jogador adorável", laboratory);
        // 11) call method to define introductory text to show when game starts
        defineIntroText();
    }

    // Intro - add any text to be shown when game starts
    private static void defineIntroText() {
        introtext = "Você se encontra no laboratório de perícia de Recife - PE,\n"
                + "O que você deseja fazer?\n"
                + "(Digite q para encerrar e 'terminar' para ver o jogo até o fim) ";
    }

    public static String introText() {
        return introtext;
    }
}
