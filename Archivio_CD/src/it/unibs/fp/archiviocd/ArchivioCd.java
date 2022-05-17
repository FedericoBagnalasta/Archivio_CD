package it.unibs.fp.archiviocd;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.NumeriCasuali;

public class ArchivioCd {
	
	ArrayList <Cd> elencoCD = new ArrayList <Cd>();
	
	public ArchivioCd() {
		
	}
	
	/**
	 * Metodo che permette all'utente di inserire un nuovo CD all'interno dell'archivio
	 */
	public void aggiungiCd() {
		String titoloCD = InputDati.leggiStringa("Inserisci il titolo del CD");
		String autoreCD = InputDati.leggiStringa("Inserisci il nome dell'autore del CD");
		Cd nuovoCD = new Cd(titoloCD, autoreCD);
		elencoCD.add(nuovoCD);
	}
	
	/**
	 * Metodo che stampa i nomi e i brani dei cd dell'archivio
	 * @return
	 */
	public boolean contiene(String nomeCD) {  //Stampare nomi CD?
		for(int i = 0; i < elencoCD.size(); i++) {
			if(nomeCD == elencoCD.get(i).getTitolo()) {
				System.out.println("IL tuo CD e' presente nell'archivio");
				return true;
			}	
		}
		System.out.println("Il CD cercato non compare nella lista");
		return false;
	}
	
	
	/**
	 * Metodo che permette all'utente di scegliere un CD e di visualizzarne il contenuto
	 */
	public void visualizzaCD() {   //da finire
		stampaCD();
		String nome = InputDati.leggiStringa("Seleziona un CD indicandone il nome");
		
		
	}
	
	/**
	 * Metodo che permette all'utente di scegliere un CD e di eliminarlo dall'archivio
	 */
	public void eliminaCd() {   //forse si può scrivere meglio usando cercaCD()
		stampaCD();
		String CDDaEliminare = InputDati.leggiStringa("Seleziona un CD da eliminare");
		for(int i = 0; i < elencoCD.size(); i++) {
			if(CDDaEliminare == elencoCD.get(i).getTitolo()) {
				elencoCD.remove(i);
			}
			else System.out.println("Il CD selezionato non compare nella lista");   //selezionato -> cercato (?)
		}		
	}
	
	/**
	 * Metodo che estrae in maniera casuale un CD dall'archivio
	 */
	public void estraiCDCasuale() {
		int num = NumeriCasuali.estraiIntero(0, elencoCD.size() - 1);
		Cd CDCasuale = elencoCD.get(num);
		System.out.println(CDCasuale.toString());		
	}
	
	/**
	 * Metodo che stampa a video l'elenco dei CD presenti all'interno dell'archivio
	 */
	public void stampaCD() {
		System.out.println(toString());
		/*for (int i = 0; i < elencoCD.size(); i++) {
			System.out.println(elencoCD.get(i).toString());
		}*/
	}
	
	public String toString() {
		String stringaArchivioCD = "L'archivio contiene i seguenti CD:\n";
		for (int i = 0; i < elencoCD.size(); i++) {
			stringaArchivioCD = stringaArchivioCD + elencoCD.get(i).toString();
		}
		return stringaArchivioCD;
	}	
}
