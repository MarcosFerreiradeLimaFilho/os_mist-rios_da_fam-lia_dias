

/*
 * Sample Java file by Huw Collingbourne
 *
 * This code (and other sample code) accompanies the book
 *    "The Little Book of Adventure Game Programming In Java"
 * Source code can be downloaded from:
 *     http://www.bitwisebooks.com
 */

package game;

import static game.Starcrash.game;
import static game.data.VocabularyData.vocab;
import game.grammar.WordAndType;
import game.grammar.GrammarUnit;
import game.grammar.NounPhrase;
import game.grammar.Preposition;
import game.grammar.SentenceAnalyzer;
import game.grammar.Verb;
import globals.WT;
import java.util.ArrayList;
import java.util.List;

public class Parser implements java.io.Serializable {

	private static String last_input; // salva a entrada de dados do usuário.

	// Conjunto de métodos para processar comandos entrados pelo 
	// usuário. Comandos são formados por objetos do tipo GrammarUnit
	static String processVerbNounPhrasePrepositionNounPhrase(List<GrammarUnit> command) {
		String msg = "";
		GrammarUnit gu1 = command.get(0);
		GrammarUnit gu2 = command.get(1);
		GrammarUnit gu3 = command.get(2);
		GrammarUnit gu4 = command.get(3);
		String verb_word = gu1.getWord();
		String noun_word = gu2.getWord();
		String preposition_word = gu3.getWord();
		String noun_word2 = gu4.getWord();

		Verb v = null;
		Preposition prep = null;
		NounPhrase np = null;
		NounPhrase np2 = null;

		if (gu1 instanceof Verb) {
			v = (Verb) gu1;
		}
		if (gu2 instanceof NounPhrase) {
			np = (NounPhrase) gu2;
		}
		if (gu3 instanceof Preposition) {
			prep = (Preposition) gu3;
		}
		if (gu4 instanceof NounPhrase) {
			np2 = (NounPhrase) gu4;
		}

		if ((v == null) || (prep == null)) {
			msg = "Não entendi.";

		} else if (np == null) {
			msg = "Não entendi.";
		} else if (np2 == null) {
			msg = "Não entendi.";
		} else {
			switch (verb_word + preposition_word) {
			case "putin":
			case "insirano":    
			case "putinto":
				msg = game.putObInContainer(np, np2);
				break;
			case "openwith":
				msg = game.openObWithSomething(np, np2);
				break;
			case "lockwith":
			case "tranquecom":    
				msg = game.lockObWithSomething(np, np2);
				break;
			case "unlockwith":
			case "destranquecom":
				msg = game.unlockObWithSomething(np, np2);
				break;
			default:
				msg = "Não entendi.";
				break;
			}
		}
		return msg;
	}

	// criado com base no método processVerbNounPhrasePrepositionNounPhrase da classe Parser
	static String processa_Frase_com_Verbo_Substantivo_e_Substantivo(List<GrammarUnit> command) {
		String msg = "";
		GrammarUnit gu1 = command.get(0);
		GrammarUnit gu2 = command.get(1);
		GrammarUnit gu3 = command.get(2);
		String verb_word = gu1.getWord();
		String noun_word = gu2.getWord();
		String noun_word_2 = gu3.getWord();


		Verb v = null;
		NounPhrase np = null;
		NounPhrase np2 = null;

		if (gu1 instanceof Verb) {
			v = (Verb) gu1;
		}
		if (gu2 instanceof NounPhrase) {
			np = (NounPhrase) gu2;
		}
		if (gu3 instanceof NounPhrase) {
			np2 = (NounPhrase) gu3;
		}

		if (v == null) {
			msg = "Não posso fazer isso.";

		} else if (np == null) {
			msg = "Não posso fazer isso porque '" + noun_word + "' não é um objeto!\r\n";
		} else if (np2 == null) {
			msg = "Não posso fazer isso porque '" + noun_word_2 + "' não é um objeto!\r\n";
		} else {
			switch (verb_word) {
			case "destranque":
				msg = game.unlockObWithSomething(np, np2);
				break;
			case "insira":
			case "use":    
				msg = game.putObInContainer(np, np2);
				break;
			default:
				msg = "Não entendi o que você quis dizer.";
				break;
			}
		}
		return msg;
	}


	static String processVerbPrepositionNounPhrase(List<GrammarUnit> command) {
		String msg = "";
		GrammarUnit gu1 = command.get(0);
		GrammarUnit gu2 = command.get(1);
		GrammarUnit gu3 = command.get(2);
		String verb_word = gu1.getWord();
		String preposition_word = gu2.getWord();
		String noun_word = gu3.getWord();
		Verb v = null;
		Preposition prep = null;
		NounPhrase np = null;

		if (gu1 instanceof Verb) {
			v = (Verb) gu1;
		}
		if (gu2 instanceof Preposition) {
			prep = (Preposition) gu2;
		}
		if (gu3 instanceof NounPhrase) {
			np = (NounPhrase) gu3;
		}

		if ((v == null) || (prep == null)) {
			msg = "Não posso fazer isso porque não entendi o comando '" + last_input + "' !";
		} else if (np == null) {
			msg = "Não posso fazer isso porque  '" + noun_word + "' não é um objeto!\r\n";
		} else {
			switch (verb_word + preposition_word) {
			case "lookat":
			case "olheo":
			case "olhea":    
				msg = Starcrash.game.lookAtOb(np);
				break;

			case "lookin":
			case "examineo":
			case "examinea":    
			case "lookinto":
				msg = Starcrash.game.lookInOb(np);
				break;
			default:
				msg = "Não entendi.";
				break;
			}
		}
		return msg;
	}

	static String processVerbNounPhrase(List<GrammarUnit> command) {
		String msg = "";
		GrammarUnit gu1 = command.get(0);
		GrammarUnit gu2 = command.get(1);
		String verb_word = gu1.getWord();
		String noun_word = gu2.getWord();
		Verb v = null;
		NounPhrase np = null;

		if (gu1 instanceof Verb) {
			v = (Verb) gu1;
		}
		if (gu2 instanceof NounPhrase) {
			np = (NounPhrase) gu2;
		}
		if (v == null) {
			msg = "Não entendi.";
		} else if (np == null) {
			msg = "Não entendi.";    
		} else {
			switch (verb_word) {
			case "olhe":
				msg = Starcrash.game.lookAtOb(np);
				break;
			case "examine":
				switch(noun_word)  {
				case "local":
					game.look();
					msg="";
					break;
				default:
					msg = Starcrash.game.lookInOb(np);

				}
				break;
			case "take":
			case "get":
			case "pegue":    
				msg = game.takeOb(np);
				break;
			case "drop":
			case "largue":    
				msg = game.dropOb(np);
				break;
			case "open":
			case "abra":    
				msg = game.openOb(np);
				break;
			case "close":
			case "feche":
				msg = game.closeOb(np);
				break;
			case "lock":
			case "tranque":    
				msg = game.lockOb(np);
				break;
			case "unlock":
			case "destranque":
				msg = game.unlockOb(np);
				break;
			case "observe":
				switch(noun_word)  {
				case "local":
					game.look();
					msg="";
					break;
				default:
					msg = game.lookInOb(np);

				}
				break; 


			default:
				msg = verb_word + " (não implementado)";
				break;
			}
		}
		return msg;
	}

	static String processVerb(List<GrammarUnit> command) {
		String msg = "";
		GrammarUnit gu = command.get(0);
		String word = gu.getWord();
		Verb v = null;

		if (gu instanceof Verb) {
			v = (Verb) gu;
		}
		if (v == null) {
			msg = "Não entendi.";
		} else {
			switch (word) {
			case "n":
			case "norte":
				game.goN();
				break;
			case "s":
			case "sul":    
				game.goS();
				break;
			case "w":
			case "oeste":
				game.goW();
				break;
			case "e":
			case "leste":
				game.goE();
				break;
			case "esquerda":    
			case "d":
			case "direita":
			case "u":
			case "up":
			case "suba":
				game.goUp();
				break;
			case "down":
			case "desca":
			case "desça":
				game.goDown();
				break;
			case "l":
			case "look":
			case "observe":
			case "olhe":    
				game.look();
				break;
			case "inventory":
			case "i":
			case "inventário":
			case "inventario":    
				game.showInventory();
				break;
			case "terminar":
				game.test();
				break;
			default:
				msg = word + " (não implementada)";
				break;
			}
		}
		return msg;
	}

	// Recebe uma lista de objetos WordAndType (uma string e 
	// uma constante WT como NOUN ou VERB) e cria uma lista de objetos 
	// GrammarUnit e passa essa lista para ser processada por um método apropriado
	static String processCommand(List<WordAndType> command) {
		String s = "";
		SentenceAnalyzer analyzer;
		List<GrammarUnit> grammarunits = new ArrayList<>(); // create Grammar Units

		analyzer = new SentenceAnalyzer(command); // Work Out Sentence Type
		grammarunits = analyzer.analyze();
		if (grammarunits.isEmpty()) {
			s = "Você precisa digitar um comando!";
		} else if (grammarunits.size() > 4) {
			s = "Comando muito longo!";
		} else if (analyzer.containsError()) {
			s = "Não consegui entender o comando - " + analyzer.getError();
		} else {
			switch (grammarunits.size()) {
			case 1:
				s = processVerb(grammarunits);
				break;
			case 2:
				s = processVerbNounPhrase(grammarunits);
				break;
			case 3:
				// s = processVerbPrepositionNounPhrase(grammarunits);
				// modificação para reconhecer o texto em português.
				GrammarUnit gu2 = grammarunits.get(1);
				GrammarUnit gu3 = grammarunits.get(2);
				if ( (gu2 instanceof NounPhrase) && (gu3 instanceof NounPhrase)) {
					// chama o meu MÉTODO PRÓPRIO PARA PROCESSAR ESSA SITUACAO (VERBO + SUBSTANTIVO + SUBSTANTIVO).
					s = processa_Frase_com_Verbo_Substantivo_e_Substantivo(grammarunits);
				}
				else {  // chama o código original.
					s = processVerbPrepositionNounPhrase(grammarunits);

				}

				break;
			case 4:
				s = processVerbNounPhrasePrepositionNounPhrase(grammarunits);
				break;
			default:
				s = "Incapaz de processar o comando";
				break;
			}
		}
		return s;
	}

	// Create a list of WordAndType objects by analysing a list of words
	static List<WordAndType> parseCommand(List<String> wordlist) {
		List<WordAndType> command = new ArrayList<>();
		WT wordtype;

		for (String k : wordlist) {
			if (vocab.containsKey(k)) {
				wordtype = vocab.get(k);
				if (wordtype == WT.ARTICLE) {       // ignore articles             
				} else {
					command.add(new WordAndType(k, wordtype));
				}
			} else { // if word not found in vocab
				command.add(new WordAndType(k, WT.ERROR));
			}
		}
		return command;
	}

	// show error message if a word in the list is not understood
	static private String parseErrors(List<WordAndType> command) {
		String s = "";

		for (WordAndType wt : command) {
			if (wt.getWordtype() == WT.ERROR) {
				s +=  " não entendi a palavra "+wt.getWord() + "\n";
			}
		}
		return s;
	}

	// Split input into individual words.
	// e.g. input = "take small box"
	// return list: "take", "small", "box"
	static List<String> wordList(String input) {
		String delims = "[ \t,.:;?!\"']+";
		List<String> strlist = new ArrayList<>();
		String[] words = input.split(delims);

		for (String word : words) {
			strlist.add(word);
		}
		return strlist;
	}

	// main parser method. Take string input and calls methods to parse and
	// process it as a command
	static String runCommand(String input) {
		List<String> words;
		String s;
		String lowstr;
		List<WordAndType> command;

		s = "ok";
		lowstr = input.trim().toLowerCase();
		if (!lowstr.equals("q")) {
			if (lowstr.equals("")) {
				s = "You must enter a command";
			} else {
				last_input = input; // save user input (for error messages)
				words = wordList(lowstr);
				command = parseCommand(words);
				s = parseErrors(command);
				if (s.isEmpty()) {
					s = processCommand(command);
				} else {
					s = "comando inválido: '" + input + "'\n" + s;
				}
			}
		}
		return s;
	}
}
