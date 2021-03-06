package it.unibs.fp.archiviocd;

import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class ArchivioCd {
	
	ArrayList <Cd> elencoCd = new ArrayList <Cd>();
	
	public ArchivioCd() {
		
	}
	
	/**
	 * Metodo che permette all'utente di creare ed inserire un nuovo Cd all'interno dell'archivio
	 */
	public void aggiungiCd() {
		boolean continua;
		String titoloCd = null;
		do {
		continua = false;
		titoloCd = InputDati.leggiStringa("Inserisci il titolo del Cd");
		for(int i = 0; i < elencoCd.size(); i++) {
			if(titoloCd.equals(elencoCd.get(i).getTitolo())) {
				continua = true;
				System.out.println("Il Cd che vuoi inserire e' gia' presente");
				}
			}
		}while(continua);
		String autoreCd = InputDati.leggiStringa("Inserisci il nome dell'autore del Cd");
		Cd nuovoCd = new Cd(titoloCd, autoreCd);
		elencoCd.add(nuovoCd);
	}

	/**
	 * Metodo per inserire un Cd nell'archivio
	 * @param nuovoCd
	 */
	public void aggiungiCd(Cd nuovoCd) {
		elencoCd.add(nuovoCd);
	}
	
	/**
	 * Metodo che stampa i nomi e i brani dei Cd dell'archivio
	 * @return
	 */
	public boolean contiene(String nomeCd) { 
		stampaCd();
		for(int i = 0; i < elencoCd.size(); i++) {
			if(nomeCd.equals(elencoCd.get(i).getTitolo())) {
				System.out.println("Il tuo Cd e' presente nell'archivio");
				return true;
			}	
		}
		System.out.println("Il Cd che stai cercando non e' presente nell'archivio");
		return false;
	}
	
	/**
	 * Metodo che permette all'utente di scegliere un Cd e di visualizzarne il contenuto
	 */
	public void visualizzaCd() {
		stampaCd();
		String nomeCd = InputDati.leggiStringa("Seleziona un Cd indicandone il nome");
		for(int i = 0; i < elencoCd.size(); i++) {
			if(nomeCd.equals(elencoCd.get(i).getTitolo())) {
				System.out.println(elencoCd.get(i).toString());
				return;
			}			
		}
		System.out.println("Il Cd che stai cercando non e' presente nell'archivio");
	}
	
	/**
	 * Metodo che restituisce il Cd selezionato
	 */
	public Cd selezionaCd() {
		stampaCd();
		String nomeCd = InputDati.leggiStringa("Seleziona un Cd indicandone il nome");
		for(int i = 0; i < elencoCd.size(); i++) {
			if(nomeCd.equals(elencoCd.get(i).getTitolo())) {
				return elencoCd.get(i);
			}
		}
		System.out.println("Il Cd che stai cercando non e' presente nell'archivio");
		return null;
	}	
	
	/**
	 * Metodo per eliminare un Cd dall'archivio
	 * @param CdDaEliminare
	 */
	public void eliminaCd(String CdDaEliminare) {
			for(int i = 0; i < elencoCd.size(); i++) {
				if(CdDaEliminare.equals(elencoCd.get(i).getTitolo())) {
					elencoCd.remove(i);
					System.out.println("Il Cd selezionato e' stato eliminato");
					return;
				}
			}	
			System.out.println("Il Cd che desideri eliminare non e' presente nell'archivio");
	}
	
	/**
	 * Metodo che estrae in maniera casuale un Cd dall'archivio e restituisce una stringa
	 */
	public void estraiCdCasuale() {
		int num = NumeriCasuali.estraiIntero(0, elencoCd.size() - 1);
		Cd CdCasuale = elencoCd.get(num);
		System.out.println(CdCasuale.toString());		
	}
	
	/**
	 * Metodo che estrae in maniera casuale un Cd dall'archivio e restituisce un oggetto di tipo Cd
	 * @return
	 */
	public Cd selezionaCdCasuale() {
		int num = NumeriCasuali.estraiIntero(0, elencoCd.size() - 1);   // HO MESSO - 1
		Cd CdCasuale = elencoCd.get(num);
		return CdCasuale;
	}
	
	/**
	 * Metodo che restituisce il numero di Cd dell'archivio
	 * @return
	 */
	public int getNumeroCd () {
		return elencoCd.size();
	}
	
	/**
	 * Metodo che stampa a video l'elenco dei Cd presenti all'interno dell'archivio
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
		String stringaArchivioCD = "L'archivio contiene i seguenti Cd:\n";
		for (int i = 0; i < elencoCd.size(); i++) {
			stringaArchivioCD = stringaArchivioCD + elencoCd.get(i).toString();
		}
		return stringaArchivioCD;
	}	
}
