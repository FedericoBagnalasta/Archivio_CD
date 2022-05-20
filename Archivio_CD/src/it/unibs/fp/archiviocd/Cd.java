package it.unibs.fp.archiviocd;

import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class Cd {
	
	private String titolo;
	private String autore;
	
	ArrayList <Brano> elencoBrani = new ArrayList <Brano>();
	
	public Cd (String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}
	
	/**
	 * Metodo che permette all'utente di creare e inserire un nuovo brano all'interno del Cd
	 */
	public void nuovoBrano () {
		boolean continua = false;
		String titoloBrano;
		do {
			titoloBrano = InputDati.leggiStringa("Inserisci il titolo del brano");
			for (int i = 0; i < elencoBrani.size(); i++) {
				if (elencoBrani.get(i).getTitolo() == titoloBrano) continua = true;
			}
		}while (continua);
		System.out.println("Inserisci la durata del brano nel formato minuti : secondi");
		int minBrano = InputDati.leggiIntero("Inserisci i minuti");
		int secBrano = InputDati.leggiIntero("Inserisci i secondi");
		Brano nuovoBrano = new Brano (titoloBrano, minBrano, secBrano);
		aggiungiBrano (nuovoBrano);
	}
	
	/**
	 * Metodo che permette di aggiungere un brano 
	 */
	public void aggiungiBrano (Brano brano) {
		elencoBrani.add(brano);
	}
	
	/**
	 * Metodo che estrae in maniera casuale un brano dal Cd
	 */
	public Brano branoCasuale () {
		int num = NumeriCasuali.estraiIntero(0, elencoBrani.size() - 1);
		Brano branoCasuale = elencoBrani.get(num);
		return branoCasuale;
	}
	
	/**
	 * Metodo che dopo aver ottenuto il titolo di un brano ne verifica la presenza all'interna dei Cd
	 */
	public boolean haTitolo (String nomeBrano) {
		for (int i = 0; i < elencoBrani.size(); i++) {
			if (nomeBrano == elencoBrani.get(i).getTitolo()) {
				return true;
			}
		}
		return false;
	}	
	
	/**
	 * Metodo che permette all'utente di selezionare un particolare brano all'interno del Cd
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
	
	/**
	 * Metodo per eliminare un brano dal Cd
	 */
	public void eliminaBrano () {
		System.out.println(toString());
		String nomeBrano = InputDati.leggiStringa("Inserisci il nome del brano che desideri eliminare");
		for (int i = 0; i < elencoBrani.size(); i++) {
			if(nomeBrano == elencoBrani.get(i).getTitolo()) {
				elencoBrani.remove(i);
			}
		}
		System.out.println("Il brano che stai cercando non e' presente all'interno del Cd");
	}

	/**
	 * Metodo che stampa a video l'elenco dei brani presenti all'interno del Cd
	 */
	public void stampaBrani () {
		for (int i = 0; i < elencoBrani.size(); i++) {
			System.out.println(elencoBrani.get(i).toString());
		}
	}
	
	/**
	 * Metodo che mostra le informazioni relative ad un Cd
	 */
	public String toString () {
		String stringaCD = String.format("Titolo: %s, Autore: %s, Lista dei brani: ", getTitolo(), getAutore());
		for (int i = 0; i < elencoBrani.size(); i++) {
			stringaCD = stringaCD + elencoBrani.get(i).toString() + "\n";
		}
		return stringaCD;
	}

	public String getTitolo () {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}
}
