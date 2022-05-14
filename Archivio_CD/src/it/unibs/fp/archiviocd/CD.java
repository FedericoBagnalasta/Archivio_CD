package it.unibs.fp.archiviocd;

import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class CD {
	
	private String titolo;
	private String autore;
	
	ArrayList <Brano> elencoBrani = new ArrayList <Brano>();
	
	public CD (String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}
	
	/**
	 * Metodo che permette all'utente di inserire un nuovo brano all'interno del CD
	 */
	public void aggiungiBrano () {
		String titoloBrano = InputDati.leggiStringa("Inserisci il titolo del brano");
		System.out.println("Inserisci la durata del brano nel formato minuti : secondi");
		int minBrano = InputDati.leggiIntero("Inserisci i minuti");
		int secBrano = InputDati.leggiIntero("Inserisci i secondi");
		Brano nuovoBrano = new Brano (titoloBrano, minBrano, secBrano);
		elencoBrani.add(nuovoBrano);
	}
	
	/**
	 * Metodo che estrae in maniera casuale un brano dal CD
	 */
	public void estraiBranoCasuale () {
		int num = NumeriCasuali.estraiIntero(0, elencoBrani.size() - 1);
		Brano branoCasuale = elencoBrani.get(num);
		System.out.println(branoCasuale.toString());
	}
	
	/**
	 * Metodo che permette all'utente di selezionare un particolare brano all'interno del CD
	 * @return
	 */
	public Brano selezionaBrano () {
		stampaBrani();
		String nome = InputDati.leggiStringa("Seleziona un brano indicandone il nome");
		for (int i = 0; i < elencoBrani.size(); i++) {
			if (nome == elencoBrani.get(i).getTitolo()) {
				return elencoBrani.get(i);
			}	
		}
		System.out.println("Il brano cercato non compare nella lista");
		return null;
	}
	
	public void eliminaBrano () {
		System.out.println(toString());
		String nomeBrano = InputDati.leggiStringa("Inserisci il nome del brano che desideri eliminare");
		for (int i = 0; i < elencoBrani.size(); i++) {
			if(nomeBrano == elencoBrani.get(i).getTitolo()) {
				elencoBrani.remove(i);
			}
		}
	}

	/**
	 * Metodo che stampa a video l'elenco dei brani presenti all'interno del CD
	 */
	public void stampaBrani () {
		for (int i = 0; i < elencoBrani.size(); i++) {
			System.out.println(elencoBrani.get(i).toString());
		}
	}
	
	/*public void stampaNomiCD () {
		for (int i = 0; i < elencoBrani.size() - 1; i++) {
			System.out.println(elencoBrani.get(i).getTitolo());
		}
	}
	*/
	public String toString () {
		String stringaCD = String.format("%s\nIl CD contiene i seguenti brani:\n", getTitolo());
		for (int i = 0; i < elencoBrani.size(); i++) {
			stringaCD = stringaCD + elencoBrani.get(i).toString();
		}
		return stringaCD;
	}

	public String getTitolo () {
		return titolo;
	}
}
