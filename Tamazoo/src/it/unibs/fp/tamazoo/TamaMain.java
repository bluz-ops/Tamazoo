package it.unibs.fp.tamazoo;
/**
 * @author Molla Blen Zena
 */
import it.unibs.fp.mylib.EstrazioniCasuali;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
public class TamaMain {
	
	public static final String MSG_OPZIONE = "Scegli un opzione";
	public static final String [] vociMenu = {"Dai biscotti ai Tamagotchi", "Dai carezze ai Tamagotchi"};
	public static final String INSERIMENTO_NUMERO = "\nINSERIMENTO NUMERO ";
	public static final int MODELLO_GORDO = 3;
	public static final int MODELLO_TRISTE = 2;
	public static final int MODELLO_BASE = 1;
	public static final int NUM_SPECIE = 3;
	public static final String RICHIESTA_NUM_TAMAGOTCHI = "Quanti Tamagotchi ci sono nello zoo? ";
	public static final String MSG_BENVENUTO = "Benvenuto al TamaZoooo!";
	private static TamaZoo mioZoo = new TamaZoo();
	
	public static void main(String[] args) {
		//benvenuto
		System.out.println(MSG_BENVENUTO);
		//si richiede all'utente il numero di Tamagotchi
		int numTamagotchi = InputDati.leggiIntero(RICHIESTA_NUM_TAMAGOTCHI);
		//creazione dello zoo 
		for(int i=1; i<=numTamagotchi;i++) {
			System.out.println(INSERIMENTO_NUMERO + i);
			Tamagotchi nuovo = creaTamagotchi();
			mioZoo.inserisci(nuovo);
		}
		
		MyMenu menuPrincipale = new MyMenu(MSG_OPZIONE, vociMenu);
		
		boolean fine = false;
		do {
			int voceScelta = menuPrincipale.scegli();
			
			switch (voceScelta) {
			case 1: 
				int numBiscotti = EstrazioniCasuali.estraiIntero(0, 100);
				System.out.printf("A ogni TamaGotchi nello zoo verranno dati %d biscotti\n" ,numBiscotti);
				mioZoo.daiBiscotti(numBiscotti);
				break;
			case 2:
				int numCarezze = EstrazioniCasuali.estraiIntero(0, 100);
				System.out.printf("A ogni TamaGotchi nello zoo verranno date %d carezze\n" ,numCarezze);
				mioZoo.daiCarezze(numCarezze);
				break;
			case 0:
				fine = true;
				System.out.println("Arrivederci e Grazie!");
			default: 
				System.out.println("Opzione non inclusa");
				break;
			}
			if (!mioZoo.ciSonoVivi()) {
				fine = true;
				System.out.println("Non ci sono superstiti");
			}
		} 
		while (!fine);
		
	}
	
	public static Tamagotchi creaTamagotchi() {
		System.out.println("Creazione Tamagotchi");
		String nome = InputDati.leggiStringa("Inserisci nome: ");
		int specie= EstrazioniCasuali.estraiIntero(1, NUM_SPECIE);
		Tamagotchi nuovo = null;
		int affetto, sazieta;
		switch(specie) {
			case MODELLO_BASE: 
				affetto = EstrazioniCasuali.estraiIntero(0, Tamagotchi.AFFETTO_MAX);
				sazieta = EstrazioniCasuali.estraiIntero(0, Tamagotchi.SAZIETA_MAX);
				nuovo = new Tamagotchi(nome, affetto, sazieta);
				break;
			case MODELLO_TRISTE:
				sazieta = EstrazioniCasuali.estraiIntero(0, Tamagotchi.SAZIETA_MAX);
				nuovo = new TamaTriste(nome, sazieta);
				break;
			case MODELLO_GORDO:
				sazieta = EstrazioniCasuali.estraiIntero(0, Tamagotchi.SAZIETA_MAX);
				nuovo = new TamaGordo(nome, sazieta);
				break;
		}
		return nuovo;
	}

}
