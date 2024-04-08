/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */

package game.data;

import globals.WT;
import java.util.HashMap;

public class VocabularyData implements java.io.Serializable {   

    public static HashMap<String, WT> vocab = new HashMap<>();
    
    public static void initVocab() {
        vocab.put("cama", WT.NOUN);
        
        vocab.put("caixa", WT.NOUN);
        
        vocab.put("botão", WT.NOUN);
        
        vocab.put("cartão", WT.NOUN);
        
        vocab.put("cadeira", WT.NOUN);
        
        vocab.put("moeda", WT.NOUN);
        
        vocab.put("computador", WT.NOUN);
        
        vocab.put("painel", WT.NOUN);
        
        
        vocab.put("armário", WT.NOUN);
        
        vocab.put("mesa", WT.NOUN);
        
        vocab.put("porta", WT.NOUN);
        
        vocab.put("chave", WT.NOUN);
        
        vocab.put("faca", WT.NOUN);
        
        vocab.put("lâmpada", WT.NOUN);
                
        vocab.put("folheto", WT.NOUN);
        
        vocab.put("alavanca", WT.NOUN);
        
        vocab.put("luz", WT.NOUN);
        
        
        vocab.put("papel", WT.NOUN);
      
        vocab.put("lápis", WT.NOUN);
        
        
        vocab.put("planta", WT.NOUN);
        
        
        vocab.put("plantas", WT.NOUN);
        
        vocab.put("anel", WT.NOUN);
        
        
        vocab.put("aviso", WT.NOUN);
        
        
        vocab.put("conector", WT.NOUN);
        
        vocab.put("mesa", WT.NOUN);
        
        
        vocab.put("árvore", WT.NOUN);
        
        vocab.put("monitor", WT.NOUN);
        vocab.put("tela", WT.NOUN);
        
         vocab.put("local", WT.NOUN);
        vocab.put("wombat", WT.NOUN);



        vocab.put("pegue", WT.VERB);
        vocab.put("i", WT.VERB);
        vocab.put("inventário", WT.VERB);
        vocab.put("inventario", WT.VERB);
        
        
        vocab.put("test", WT.VERB);
        vocab.put("teste", WT.VERB);
        
        vocab.put("largue", WT.VERB);
        vocab.put("insira", WT.VERB);
        vocab.put("use", WT.VERB);
        
        // para testar o jogo
        vocab.put("terminar", WT.VERB);
        
        
        vocab.put("observe", WT.VERB);
        vocab.put("olhe", WT.VERB);
        
        vocab.put("tranque", WT.VERB);
     
        vocab.put("destranque", WT.VERB);
        
        vocab.put("abra", WT.VERB);
        vocab.put("feche", WT.VERB);
        vocab.put("examine", WT.VERB);

        vocab.put("pressione", WT.VERB);
        
        vocab.put("puxe", WT.VERB);
        
        vocab.put("empurre", WT.VERB);
        
        vocab.put("norte", WT.VERB);
        vocab.put("sul", WT.VERB);
        vocab.put("oeste", WT.VERB);
        vocab.put("leste", WT.VERB);
        vocab.put("esquerda", WT.VERB);
        vocab.put("direita", WT.VERB);
        
        vocab.put("suba", WT.VERB);
    
        vocab.put("desca", WT.VERB);
        vocab.put("desça", WT.VERB);

        vocab.put("q", WT.VERB);
        vocab.put("quit", WT.VERB);
        vocab.put("encerrar", WT.VERB);
        
        vocab.put("ajuda", WT.VERB);
        vocab.put("ativação", WT.ADJECTIVE);
        
        vocab.put("pequeno", WT.ADJECTIVE);
        vocab.put("pequena", WT.ADJECTIVE);
        
        
        vocab.put("minúsculo", WT.ADJECTIVE);
        vocab.put("minúscula", WT.ADJECTIVE);
        
        vocab.put("grande", WT.ADJECTIVE);
        vocab.put("papelão", WT.ADJECTIVE);
        
        vocab.put("display", WT.ADJECTIVE);
        vocab.put("controle", WT.ADJECTIVE);
        
        vocab.put("enorme", WT.ADJECTIVE);
        
        vocab.put("metal", WT.ADJECTIVE);
        vocab.put("onyx", WT.ADJECTIVE);
        vocab.put("jóia", WT.ADJECTIVE);
        
        vocab.put("carnívora", WT.ADJECTIVE); 
        
        vocab.put("plástico", WT.ADJECTIVE);
        
        vocab.put("spiky", WT.ADJECTIVE);
        vocab.put("ouro", WT.ADJECTIVE);
        vocab.put("dourada", WT.ADJECTIVE);
        vocab.put("metálica", WT.ADJECTIVE);
        vocab.put("controle", WT.ADJECTIVE);
        
        vocab.put("prata", WT.ADJECTIVE);
        
        vocab.put("madeira", WT.ADJECTIVE);
      
 
        vocab.put("a", WT.ARTICLE);
        vocab.put("o", WT.ARTICLE);
       
 
        
        vocab.put("a", WT.PREPOSITION);        
        vocab.put("o", WT.PREPOSITION);   
        vocab.put("de", WT.PREPOSITION);   
        vocab.put("no", WT.PREPOSITION);   
        vocab.put("na", WT.PREPOSITION);   
        
        
        
        vocab.put("com", WT.PREPOSITION);
        vocab.put("para", WT.PREPOSITION);
        
        
    }
}
