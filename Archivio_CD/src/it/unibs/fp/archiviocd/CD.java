package it.unibs.fp.archiviocd;

import it.unibs.fp.mylib.*;
import java.util.ArrayList;

public class CD {
	
	private String titolo;
	private String autore;
	
	ArrayList <Brano> elencoBrani = new ArrayList <Brano>();
	
	public CD (String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}
	
	public void aggiungiBrano() {
		String titoloBrano = InputDati.leggiStringa("Inserisci il nome del brano");
		System.out.println("Inserisci la durata del brano nel formato minuti : secondi");
		int minBrano = InputDati.leggiIntero("Inserisci i minuti");
		int secBrano = InputDati.leggiIntero("Inserisci i secondi");
		Brano nuovoBrano = new Brano (titoloBrano, minBrano, secBrano);
		elencoBrani.add(nuovoBrano);
	}
	
	public void estraiBranoCasuale () {
		int num = NumeriCasuali.estraiIntero(0, elencoBrani.size() - 1);
		Brano branoCasuale = elencoBrani.get(num);
		System.out.println(branoCasuale.toString());
	}
	
	public Brano selezionaBrano () {
		stampaBrani();
		String nome = InputDati.leggiStringa("Seleziona un brano indicandone il nome");
		for (int i = 0; i < elencoBrani.size() - 1; i++) {
			if (nome == elencoBrani.get(i).getTitolo()) {
				return elencoBrani.get(i);
			}	
		}
		System.out.println("Il brano cercato non compare nella lista");
		return null;
	}

	public void stampaBrani () {
		for (int i = 0; i < elencoBrani.size() - 1; i++) {
			System.out.println(elencoBrani.get(i).toString());
		}
	}
	
	public String toString () {
		String stringaCD = String.format("Il CD %s contiene i seguenti brani:\n", getTitolo());
		for (int i = 0; i < elencoBrani.size() - 1; i++) {
			stringaCD = stringaCD + elencoBrani.get(i).toString();
		}
		return stringaCD;
	}

	public String getTitolo() {
		return titolo;
	}
}
