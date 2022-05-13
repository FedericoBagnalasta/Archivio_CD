package it.unibs.fp.archiviocd;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.NumeriCasuali;

public class ArchivioCD {
	
	ArrayList <CD> elencoCD = new ArrayList <CD>();
	
	public ArchivioCD() {
		
	}
	
	public void inserisciCD() {
		String titoloCD = InputDati.leggiStringa("Inserisci il titolo del CD");
		String autoreCD = InputDati.leggiStringa("Inserisci il nome dell'autore del CD");
		CD nuovoCD = new CD(titoloCD, autoreCD);
		elencoCD.add(nuovoCD);
	}

	public CD cercaCD() {
		String nome = InputDati.leggiStringa("Seleziona un CD indicandone il nome");
		for(int i = 0; i < elencoCD.size() - 1; i++) {
			if(nome == elencoCD.get(i).getTitolo()) {
				return elencoCD.get(i);
			}	
		}
		System.out.println("Il CD cercato non compare nella lista");
		return null;
	}
	
	public void visualizzaCD() {   //da finire
		stampaCD();
		String nome = InputDati.leggiStringa("Seleziona un CD indicandone il nome");
		
		
	}
	
	public void eliminaCD() {   //forse si può scrivere meglio usando cercaCD()
		stampaCD();
		String CDDaEliminare = InputDati.leggiStringa("Seleziona un CD da eliminare");
		for(int i = 0; i < elencoCD.size() - 1; i++) {
			if(CDDaEliminare == elencoCD.get(i).getTitolo()) {
				elencoCD.remove(i);
			}
			else System.out.println("Il CD selezionato non compare nella lista");   //selezionato -> cercato (?)
		}		
	}
	
	public void estraiCDCasuale() {
		int num = NumeriCasuali.estraiIntero(0, elencoCD.size() - 1);
		CD CDCasuale = elencoCD.get(num);
		System.out.println(CDCasuale.toString());		
	}
	
	public void stampaCD() {
		for (int i = 0; i < elencoCD.size() - 1; i++) {
			System.out.println(elencoCD.get(i).toString());
		}
	}
	
	public String toString() {
		String stringaArchivioCD = "L'archivio CD contiene i seguenti brani:\n";
		for (int i = 0; i < elencoCD.size() - 1; i++) {
			stringaArchivioCD = stringaArchivioCD + elencoCD.get(i).toString();
		}
		return stringaArchivioCD;
	}	
}
