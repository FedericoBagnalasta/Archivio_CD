package it.unibs.fp.archiviocd;

public class Brano {
	
	private String titolo;
	private int minDurata;
	private int secDurata;
	
	public Brano (String titolo, int minDurata, int secDurata) {
		this.titolo = titolo;
		this.minDurata = minDurata;
		this.secDurata = secDurata;
	}
	
	public String toString() {
		String stringaCanzone = titolo;
		stringaCanzone = stringaCanzone + (String.format(" [%02d:%02d] ", minDurata, secDurata));
		return stringaCanzone;		
	}

	public String getTitolo() {
		return titolo;
	}
}
