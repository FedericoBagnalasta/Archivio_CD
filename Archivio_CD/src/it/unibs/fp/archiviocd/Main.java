package it.unibs.fp.archiviocd;

import it.unibs.fp.mylib.*;

public class Main {

	public static void main(String[] args) {     
		boolean continua = true;
		ArchivioCd archivio = new ArchivioCd();
		 

		String[] voci = {"Inserisci Cd", "Visualizza intero archivio", "Visualizza Cd dell'archivio", "Elimina Cd", 
				"Estrai un Cd casuale", "Aggiungi brano", "Estrai un brano casuale"};
		MyMenu menu = new MyMenu ("Benvenuto nell'archivio Cd", voci);

		while (continua) {
			switch (menu.scegli()) {
			
			/**
			 *Case 1: Inserisce Cd
			 */
			case 1: 

				archivio.aggiungiCd();

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
				archivio.visualizzaCd();
				break;
				
			/**
			 * Case 4: Elimina Cd	
			 */
			case 4:
				archivio.stampaCd();
				String CdDaEliminare = InputDati.leggiStringa("Seleziona un Cd da eliminare");
				archivio.eliminaCd(CdDaEliminare);
				break;
				
			/**
			 * Case 5: Estrae un Cd casualmente
			 */
			case 5:
				try {
				archivio.estraiCdCasuale();
				}
				catch (IllegalArgumentException e){
					System.out.println("Inserisci prima dei Cd!");
				}
				break;
				
			/**
			 * Case 6: Aggiunge un brano al Cd selezionato
			 */
			case 6: 
				Cd nomeCd = archivio.selezionaCd();
				if(nomeCd != null) {
					nomeCd.nuovoBrano();		
				}
				break;
				
			/**
			 * Case 7: Estrae un brano casualmente
			 */
			case 7:
				try {
				String branoCasuale = archivio.selezionaCdCasuale().branoCasuale().toString();
				System.out.println(branoCasuale);
				}
				catch (IllegalArgumentException e) {
					System.out.println("Inserisci prima dei brani!");
				}
				break;
				
			/**
			 * Case 0: Esce dal programma
			 */
			case 0:
				continua = false;
				break;
			
			}
		}		
	}
	
}
