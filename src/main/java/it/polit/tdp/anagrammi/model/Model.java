package it.polit.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	AnagrammaDAO anagrammaDAO=new AnagrammaDAO();
	
	public Set<String> calcolaAnagrammi(String parola){
		Set<String> anagrammi=new HashSet<>();
		String parziale="";
		calcola(parziale, parola, 0, anagrammi);
		return anagrammi;
	}

	private void calcola(String parziale, String parola, int livello, Set<String> anagrammi) {
		if(livello==parola.length()) { //condizione di uscita
			anagrammi.add(parziale);
			return;
		}
		
		for(int i=0; i<parola.length(); i++) {
			if(this.charCounter(parziale, parola.charAt(i))<this.charCounter(parola, parola.charAt(i))) {
			//se il numero di ricorrenze della lettere in parziale è minore di quelle della parola vera
				parziale+=parola.charAt(i);
				calcola(parziale, parola, livello+1, anagrammi);
				parziale=parziale.substring(0, parziale.length()-1);
			}
		}
	}
	
	private int charCounter(String string, char c) {
		int count=0;
		for(int i=0; i<string.length();i++) {
			if(string.charAt(i)==c) //se la i-esima lettera è = a quella passata..
				count++; //incrementiamo contatore
		}
		return count;
	}
	
	public boolean isCorrect(String anagramma) {
		return this.anagrammaDAO.isCorrect(anagramma);
	}
	

}
