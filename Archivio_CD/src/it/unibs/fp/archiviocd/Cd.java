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
	 * Metodo che permette all'utente di creare e inserire un nuovo brano all'interno del CD
	 */
	public void nuovoBrano () {
		String titoloBrano = InputDati.leggiStringa("Inserisci il titolo del brano");
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
	 * Metodo che estrae in maniera casuale un brano dal CD
	 */
	public Brano branoCasuale () {
		int num = NumeriCasuali.estraiIntero(0, elencoBrani.size() - 1);
		Brano branoCasuale = elencoBrani.get(num);
		return branoCasuale;
	}
	
	/**
	 * Metodo che dopo aver ottenuto il titolo di un brano ne verifica la presenza all'interna dei CD
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
	
	public String toString () {
		String stringaCD = String.format("%s di %s\nIl CD contiene i seguenti brani:\n", getTitolo(), getAutore());
		for (int i = 0; i < elencoBrani.size(); i++) {
			stringaCD = stringaCD + elencoBrani.get(i).toString();
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
