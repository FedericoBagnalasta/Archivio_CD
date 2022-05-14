package it.unibs.fp.archiviocd;

import it.unibs.fp.mylib.*;

public class Main {

	public static void main(String[] args) {
		boolean continua = true;
		ArchivioCd archivio = new ArchivioCd();
		 
		String[] voci = {"Inserisci CD", "Elimina CD", "Aggiungi Brano"};
		MyMenu menu = new MyMenu ("Benvenuto nel archivio CD", voci);
		
		while (continua) {
			switch (menu.scegli()) {
			
			/**
			 *Case 1: Inserisce CD
			 */
			case 1: 
				archivio.inserisciCD();
				break;
				
			/**
			 * Case 2: Visualizza archivio CD
			 */
			case 2:
				archivio.cercaCD();
				break;
				
			/**
			 * Case 3: Elimina CD	
			 */
			case 3:
				archivio.stampaCD();
				break;
				
			case 0:
				continua = false;
				break;
			
			}
		}
		
		
		
		/*Brano b = new Brano("sda", 45, 56);
		System.out.println(b.toString());
		
		CD cd = new CD ("hbu", "djs");
		cd.aggiungiBrano();
		cd.aggiungiBrano();
		cd.estraiBranoCasuale();
		*/
	}

	
	/*L'inserimento CD non deve essere permesso se il nome usato e' gia stato inserito
	 * 
	 * estrazione CD da TUTTO l'archivio
	 * 
	 */
}
