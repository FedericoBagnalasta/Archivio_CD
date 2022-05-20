package it.unibs.fp.archiviocd;

import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class ArchivioCd {
	
	ArrayList <Cd> elencoCd = new ArrayList <Cd>();
	
	public ArchivioCd() {
		
	}
	
	/**
	 * Metodo per creare un nuovo Cd
	 */
	public Cd creaCd () {
		String titoloCd = InputDati.leggiStringa("Inserisci il titolo del CD");
		String autoreCd = InputDati.leggiStringa("Inserisci il nome dell'autore del CD");
		Cd nuovoCd = new Cd(titoloCd, autoreCd);
		return nuovoCd;
	}
	
	/**
	 * Metodo che permette all'utente di inserire un nuovo CD all'interno dell'archivio
	 */
	public void aggiungiCd(Cd nuovoCd) {
		elencoCd.add(nuovoCd);
	}
	
	/**
	 * Metodo che stampa i nomi e i brani dei cd dell'archivio
	 * @return
	 */
	public boolean contiene(String nomeCD) { 
		stampaCd();
		for(int i = 0; i < elencoCd.size(); i++) {
			if(nomeCD == elencoCd.get(i).getTitolo()) {
				System.out.println("IL tuo Cd e' presente nell'archivio");
				return true;
			}	
		}
		System.out.println("Il Cd cercato non compare nella lista");
		return false;
	}
	
	/**
	 * Metodo che permette all'utente di scegliere un CD e di visualizzarne il contenuto
	 */
	public Cd visualizzaCd(boolean opzione) {   //da finire
		stampaCd();
		String nomeCd = InputDati.leggiStringa("Seleziona un CD indicandone il nome");
		for(int i = 0; i < elencoCd.size(); i++) {
			if(nomeCd == elencoCd.get(i).getTitolo() && opzione == false ) {
				System.out.println(elencoCd.get(i).toString());
			}
			else if(nomeCd == elencoCd.get(i).getTitolo() && opzione == true ) {
				return elencoCd.get(i);
			}
			
		}
		System.out.println("Il Cd che stai cercando non e' presente nell'archivio");
		return null;
	}
	
	/**
	 * Metodo che permette all'utente di scegliere un CD e di eliminarlo dall'archivio
	 */
	public void eliminaCd(String CdDaEliminare) {   //forse si può scrivere meglio usando cercaCD()
			for(int i = 0; i < elencoCd.size(); i++) {
			if(CdDaEliminare == elencoCd.get(i).getTitolo()) {
				elencoCd.remove(i);
			}
			else System.out.println("Il CD che desideri eliminare non e' presente nell'archivio");  
		}		
	}
	
	/**
	 * Metodo che estrae in maniera casuale un CD dall'archivio
	 */
	public void estraiCDCasuale() {
		int num = NumeriCasuali.estraiIntero(0, elencoCd.size() - 1);
		Cd CDCasuale = elencoCd.get(num);
		System.out.println(CDCasuale.toString());		
	}
	
	/**
	 * Metodo che restituisce il numero di Cd dell'archivio
	 * @return
	 */
	public int getNumeroCd () {
		return elencoCd.size();
	}
	
	/**
	 * Metodo che stampa a video l'elenco dei CD presenti all'interno dell'archivio
	 */
	public void stampaCd() {
		for (int i = 0; i < elencoCd.size(); i++) {
			System.out.println(elencoCd.get(i).getTitolo());
		}
	}
	
	/**
	 * Metodo che mostra le informazioni relative all'intero archivio
	 */
	public String toString() {
		String stringaArchivioCD = "L'archivio contiene i seguenti CD:\n";
		for (int i = 0; i < elencoCd.size(); i++) {
			stringaArchivioCD = stringaArchivioCD + elencoCd.get(i).toString();
		}
		return stringaArchivioCD;
	}	
}
