package it.unibs.fp.archiviocd;

public class Main {

	public static void main(String[] args) {
		Brano b = new Brano("sda", 45, 56);
		System.out.println(b.toString());
		
		CD cd = new CD ("hbu", "djs");
		cd.aggiungiBrano();
		cd.aggiungiBrano();
		cd.estraiBranoCasuale();
	}

}
