/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */
package game.grammar;

import globals.WT;
import java.util.ArrayList;
import java.util.List;

/*
 * The SentenceAnalyzer is an object that is used when a List of WordAndType
 * Objects is being processed. It builds up a sentence composed of GrammarUnits
 * Any (as yet) unprocessed WordAndType objects are stored as 'rest'.
 */
public class SentenceAnalyzer implements java.io.Serializable {

    private List<GrammarUnit> sentence;
    private List<WordAndType> rest;
    private String error;

    public SentenceAnalyzer(List<WordAndType> wtlist) {
        rest = wtlist;
        sentence = new ArrayList<GrammarUnit>();
        error = "";
    }

    private WordAndType getNextElement() {
        if (rest.isEmpty()) {
            return null;
        } else {
            return rest.get(0);
        }
    }

    private ArrayList<String> getAdjectives(WordAndType wt) {
        ArrayList<String> adjectives = new ArrayList<>();
        boolean runloop = true;

        while (runloop) {
            if (wt == null) {
                runloop = false;
            } else if (wt.getWordtype() == WT.ADJECTIVE) {
                adjectives.add(wt.getWord());
                rest.remove(wt);
                wt = getNextElement();
            } else if (wt.getWordtype() == WT.PREPOSITION) {
                rest.remove(wt);
                wt = getNextElement();
            } else {
                runloop = false;
            }
        }
        return adjectives;
    }

    public String getError() {
        return error;
    }

    public boolean containsError() {
        boolean yes = false;
        error = "";
        for (GrammarUnit gu : sentence) {
            if (gu instanceof GrammarError) {
                error += ((GrammarError) gu).getWord() + "! ";
                yes = true;
            }
        }
        return yes;
    }

    private String getNoun(WordAndType wt) {
        String s = "";
        if (wt != null) {
            if (wt.getWordtype() == WT.NOUN) {
                s = wt.getWord();
            }
        }
        return s;
    }

    private void addNounPhrase(WordAndType wt) {
 	WordAndType nextWT;
 	String noun;
 	ArrayList<String> adjectives;

 	nextWT = wt;

 	// pega o substantivo
        // nextWT = getNextElement();
 	noun = getNoun(nextWT);

	// se nÃ£o tem substantivo, estÃ¡ errado.
 	if (noun.isEmpty()) {
 		sentence.add(new GrammarError("Missing Noun"));
 	} 
	// tem um substantivo, vamos pegar os adjetivos agora.
	else {	
                
                rest.remove(nextWT); 
                nextWT = getNextElement();
             
  
                adjectives = getAdjectives(nextWT);

		// se nÃ£o tem adjetivo, passamos o substantivo + a lista vazia de adjetivos e terminamos.
		if (adjectives.isEmpty()) {
			sentence.add(new NounPhrase(noun, adjectives));
                        	
			// essa linha aqui sÃ³ era necessÃ¡ria em ingles para remover o substantivo que pegamos agora 
			// se antes nÃ£o tivesse nenhum adjetivo previamente, entÃ£o ACHO QUE NÃƒO PRECISA MAIS.
		       // rest.remove(nextWT);
		
 			return ; // (? Terminamos?)
		}
		// tem adjetivos, passa eles.
		else  {
			sentence.add(new NounPhrase(noun, adjectives));
                        
 		
		}
	}
}
    
    private void addNounPhrase2(WordAndType wt) {
        WordAndType nextWT;
        String noun;
        ArrayList<String> adjectives;

        nextWT = wt;
        adjectives = getAdjectives(nextWT);
        // if adjectives empty, getNoun(wt) else get next element then getNoun
        if (adjectives.isEmpty()) {
            noun = getNoun(nextWT);
        } else {
            nextWT = getNextElement();
            noun = getNoun(nextWT);
        }
        if (noun.isEmpty()) {
            addError("Missing Noun");
        } else {
            sentence.add(new NounPhrase(noun, adjectives));
            rest.remove(nextWT);
        }
    }

    private void addError(String errorMsg) {
        sentence.add(new GrammarError(errorMsg));
    }

    private void addPreposition(WordAndType wt) {
        sentence.add(new Preposition(wt.getWord()));
        rest.remove(wt);
    }

    private void addVerb(WordAndType wt) {
        sentence.add(new Verb(wt.getWord()));
        rest.remove(wt);
    }

    public List<GrammarUnit> analyze() {
        WordAndType wt;
        String word;

        while (!rest.isEmpty()) {
            wt = getNextElement();
            word = wt.getWord();
            switch (wt.getWordtype()) {
                case VERB:
                    addVerb(wt);
                    break;
                case ADJECTIVE:
                case NOUN:
                    addNounPhrase(wt);
                    break;
                case PREPOSITION:
                    addPreposition(wt);
                    break;
                case ERROR:
                    addError("Grammar analysis ERROR");
                    break;
                default:
                    break;
            }
        }
        return sentence;
    }
}
