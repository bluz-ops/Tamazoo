package it.unibs.fp.tamazoo;

/**
 * Questa classe contiene l'oggetto Tamagotchi ed e' intesa da istanziare.
 * @author Molla Blen Zena
*/
public class Tamagotchi {
    protected static final int SAZIETA_VICINA_AL_LIMITE_MAX = 90;
	protected static final int AFFETTO_MAX = 100;
	protected static final int SAZIETA_BASSA = 30;
	protected static final int AFFETTO_BASSO = 30;
	protected static final int AFFETTO_ELEVATO = 80;
	protected static final int SAZIETA_ELEVATA = 80;
	protected static final int SAZIETA_MIN = 0;
	protected static final int AFFETTO_MIN = 0;
	protected static final int SAZIETA_MAX = 100;
	protected static final String MSG_VIVO = "\n I'm alright :| ";
	protected static final String MSG_MORTE = "\n Sono Morto !!!!";
	protected static final String MSG_FELICITA = "\nSono Felice :> ";
	protected static final String MSG_TRISTEZZA = "\nSono Triste :< ";
	//public static final String DESCRIZIONE = "Nickname: %s\n Sazieta:%2.1f \n Affetto:%2.1f \n";
	protected static final int FATTORE_CAREZZE = 2;  //
    protected static final int FATTORE_BISCOTTI = 4; //
    protected static final double FATTORE_PERCENTUALE = 0.1;  //
    
    //attributi di tamagotchi
    protected String nome; 
    protected double sazieta;
    protected double affetto;
  
    /**
     * NB: si e' scelto di inizializzare l'oggetto con interi mentre gli attributi sono double
     * @param _nome
     * @param _affetto
     * @param _sazieta
     */
    public Tamagotchi(String _nome, int _affetto, int _sazieta) {
        this.nome = _nome;
        this.affetto = _affetto;
        this.sazieta = _sazieta;
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
     * 
     * @param carezze int pseudocasuale
     */
    public void riceviCarezze (int carezze) {
        affetto = Math.min(AFFETTO_MAX, affetto + carezze);
        sazieta = Math.max(SAZIETA_MIN, sazieta - carezze/ FATTORE_CAREZZE);
    }
    /**
     * 
     * @param biscotti int pseudocasuale
     */
    public void riceviBiscotti(int biscotti) {
        for (int i=0; i < biscotti; i++) {
            sazieta= Math.min(SAZIETA_MAX, sazieta + sazieta * FATTORE_PERCENTUALE); //sazieta<=100
        }
        affetto= Math.max(AFFETTO_MIN, affetto - biscotti / FATTORE_BISCOTTI); //affetto >= 0
    }
   
    /*
     * 
     EVOLUZIONE
     METODO benessereComplessivo in termini di media
    */
    
    
    @Override
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
     * 
     * @return true if if condition is verified
     */
    public boolean isTriste() {
		if (getAffetto()<AFFETTO_BASSO || getSazieta()<SAZIETA_BASSA) {
			return true;
		}
		else if ( getSazieta()>SAZIETA_VICINA_AL_LIMITE_MAX && getSazieta()<100){
			return true;
		}
		else {
			return false;
		}
    }
    /**
     * 
     * @return true if if condition is verified
     * Soglia di felicita' posta a 80 (non indicata dalla consegna)
     */
    public boolean isFelice() {
    	return (sazieta<SAZIETA_VICINA_AL_LIMITE_MAX && sazieta > SAZIETA_ELEVATA && affetto > AFFETTO_ELEVATO);
    }
    /**
     * 
     * @return true se si verifica l'if
     */
    public boolean isMorto() {
        return (sazieta==SAZIETA_MIN || affetto==AFFETTO_MIN || sazieta==SAZIETA_MAX);
      }
 
}