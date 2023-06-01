package it.unibs.fp.tamazoo;
/**
 * @author Molla Blen Zena
 */
import java.util.Vector;

public class TamaZoo {
	//uso di una collezione dinamica
	private Vector<Tamagotchi> creature;
	
	public TamaZoo() {
		creature = new Vector<Tamagotchi>();
	}
	
	public void inserisci(Tamagotchi daInserire) {
		creature.add(daInserire);
	}
	
	public boolean ciSonoVivi(){
		for (Tamagotchi elem: creature) {
			if(!elem.isMorto()) {
				return true;
			}
		} 
		return false;
	}
	
	public void daiBiscotti(int numBiscotti) {
		for (Tamagotchi elem: creature) {
			if (!elem.isMorto()) {
				elem.riceviBiscotti(numBiscotti);
				System.out.println(elem.toString());
				System.out.println();
			}
		}
	}
	
	public void daiCarezze(int numCarezze) {
		for (Tamagotchi elem: creature) {
			if (!elem.isMorto()) {
				elem.riceviBiscotti(numCarezze);
				System.out.println(elem.toString());
				System.out.println();
			}
		}
	}
}
