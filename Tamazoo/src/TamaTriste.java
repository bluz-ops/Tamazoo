package it.unibs.fp.tamazoo;

/**
 * 
 * @author Daian
 *
 *Il TamaTriste e' sempre infelice e la sua sopravvivenza dipende solo
 *dal grado di sazieta'. A differenza del TamaGordo, non presenta svantaggi extra se viene 
 *accarezzato, ma puo'morire se gli viene dato troppo cibo come farebbe un Tamagotchi normale. 
 */


public class TamaTriste extends Tamagotchi {

	public TamaTriste(String _nome, int _affetto, int _sazieta) {
		super(_nome, AFFETTO_MIN, _sazieta);
	}

	 //getters
    /**
     * 
     * @return String nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * 
     * @return double sazieta
     */
    public double getSazieta() {
        return sazieta;
    }
    /**
     * 
     * @return double affetto
     */
    public double getAffetto() {
        return affetto;
    }
	
  //metodi per variare i livelli di soddisfazione e sazieta in base agli stimoli esterni ricevuti
    /**
     * Quando un TamaTriste riceve carezze, la sazieta' cala nel modo in cui farebbe un Tamagotchi 
     * normale, mentre l'affetto rimane invariato. 
     * @param carezze int pseudocasuale
     */
    public void riceviCarezze (int carezze) {
        sazieta = Math.max(SAZIETA_MIN, sazieta - carezze/ FATTORE_CAREZZE);
    }
    
    /**
     * Quando un Tamatriste riceve biscotti, l'affetto non può calare perche' e' gia' al
     * minimo.
     * @param biscotti int pseudocasuale
     */
    public void riceviBiscotti(int biscotti) {
        for (int i=0; i < biscotti; i++) {
            sazieta= Math.min(SAZIETA_MAX, sazieta + sazieta * FATTORE_PERCENTUALE); //sazieta<=100
        }
    }
   
    /**
     * @return String descrizione Tamagotchi
     */
    public String toString(){
    		StringBuffer descrizione = new StringBuffer();
    		descrizione.append("\nNickname="+ nome);
    		descrizione.append("\nSazieta=" + sazieta);
    		descrizione.append("\nSoddisfazione=" + affetto);
    		if(isTriste()) {
    			descrizione.append(MSG_TRISTEZZA);
    		}
    		else if(isFelice()) {
    			descrizione.append(MSG_FELICITA);
    		}
    		else if(isMorto()) {
    			descrizione.append(MSG_MORTE);
    		}
    		else {
    			descrizione.append(MSG_VIVO);
    		}
    		return descrizione.toString();
    		//return String.format(DESCRIZIONE, nome, sazieta, affetto);
    	}
    /**
     * Il TamaTriste e' sempre triste.
     * 
     * @return true 
     */
    public boolean isTriste() {
			return true;
	
    }
    /**
     * Il TamaTriste non e' mai felice.
     * 
     * @return true if if condition is verified
     */
    public boolean isFelice() {
    	return false;
    }
    
    
    /**
     * Il TamaTriste muore solo se la sua sazieta' e' troppo alta
     * o troppo bassa.
     * @return true se si verifica l'if
     */
    public boolean isMorto() {
        return (sazieta==SAZIETA_MIN || sazieta==SAZIETA_MAX);
      }
 
	
}


