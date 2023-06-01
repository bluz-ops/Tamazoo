package it.unibs.fp.tamazoo;

/**
 * 
 * @author Daian
 *
 * Il TamaGordo è una specie di Tamagotchi caratterizzata dall'indifferenza nei confronti del lato
 * affettivo e la cui sopravvivenza dipende esclusivamente dal grado di sazieta'.
 */


public class TamaGordo extends Tamagotchi {

	protected static final int FATT_AMPLIFICAZIONE_CAREZZE = 2;

	public TamaGordo(String _nome, int _sazieta) {
		super(_nome, AFFETTO_MAX, _sazieta);
		this.nomeTipo = "gordo";
	}

	
	 //getters
    /**
     * 
     * @return String nome
     */
	@Override
	public String getNome() {
        return nome;
    }
    /**
     * 
     * @return double sazieta
     */
    @Override
    public double getSazieta() {
        return sazieta;
    }
    /**
     * 
     * @return double affetto
     */
    @Override
    public double getAffetto() {
        return AFFETTO_MAX;
    }
	
	
	
	
	//metodi per variare i livelli di soddisfazione e sazieta in base agli stimoli esterni ricevuti
    /**
     * Il grado di soddisfazione affettiva del TamaGordo è sempre massimo, quindi non necessita di carezze.
     * Se viene coccolato comunque, il grado di sazieta' cala del doppio rispetto alla
     * norma.
     * @param carezze int pseudocasuale
     */
    @Override
    public void riceviCarezze (int carezze) {
        sazieta = Math.max(SAZIETA_MIN, sazieta - FATT_AMPLIFICAZIONE_CAREZZE*carezze/ FATTORE_CAREZZE);
    }
	
	
    
    /**
     * Come precedentemente detto, l'affetto del TamaGordo non puo' essere alterato.
     * Si alimenta in maniera analoga ad un Tamagotchi Base.
     * @param biscotti int pseudocasuale
     */
   @Override
    public void riceviBiscotti(int biscotti) {
        for (int i=0; i < biscotti; i++) {
            sazieta= Math.min(SAZIETA_MAX, sazieta + sazieta * FATTORE_PERCENTUALE); //sazieta<=100
        }
    }
    
   /**
    * @return String descrizione TamaGordo
    */
   @Override
   public String toString(){
   		StringBuffer descrizione = new StringBuffer();
   		descrizione.append("\nSpecie="+ nomeTipo);
   		descrizione.append("\nNickname="+ nome);
   		descrizione.append("\nSazieta=" + sazieta);
   		descrizione.append("\nSoddisfazione=" + AFFETTO_MAX);
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
   	}
    
   
   /**
    * Il TamaGordo è triste solo se la sazieta' e' troppo bassa
    * e mai se e' troppo elevata.
    * 
    * @return true if if condition is verified
    */
   @Override
   public boolean isTriste() {
		if ( getSazieta()<SAZIETA_BASSA) {
			return true;
		}
		else {
			return false;
		}
   }
   
   /**
    * Il TamaGordo è felice anche quando mangia troppo.
    * @return true if if condition is verified
    * 
    */
   @Override
   public boolean isFelice() {
   	return (sazieta > SAZIETA_ELEVATA);
   }
   
   /**
    * Il TamaGordo muore solo se mangia troppo poco.
    * @return true se si verifica l'if
    */
  @Override
   public boolean isMorto() {
       return (sazieta==SAZIETA_MIN);
     }
   
   
   
}
