package it.unibs.fp.archiviocd;

import it.unibs.fp.mylib.*;

public class Main {

	public static void main(String[] args) {     
		boolean continua = true;
		ArchivioCd archivio = new ArchivioCd();
		 
		String[] voci = {"Inserisci CD", "Visualizza intero archivio", "Visualizza Cd dell'archivio", "Elimina CD", 
				"Estrai brano casuale", "Aggiungi Brano"}; // seleziona Brano a caso e brano specifico
		MyMenu menu = new MyMenu ("Benvenuto nel archivio CD", voci);
		
		while (continua) {
			switch (menu.scegli()) {
			
			/**
			 *Case 1: Inserisce Cd
			 */
			case 1: 
				archivio.aggiungiCd(archivio.creaCd());
				break;
				
			/**
			 * Case 2: Visualizza l'intero archivio	
			 */
			case 2:
				System.out.println(archivio.toString());
				break;
				
			/**
			 * Case 3: Visualizza Cd selezionato
			 */
			case 3:
				archivio.visualizzaCd(false);
				break;
				
			/**
			 * Case 3: Elimina Cd	
			 */
			case 4:
				archivio.stampaCd();
				String CdDaEliminare = InputDati.leggiStringa("Seleziona un CD da eliminare");
				archivio.eliminaCd(CdDaEliminare);
				break;
				
			/**
			 * Case 5: 	Estrae un Cd casualmente
			 */
			case 5:
				archivio.estraiCDCasuale();
				break;
				
			case 6: 
				archivio.visualizzaCd(true).nuovoBrano();
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
