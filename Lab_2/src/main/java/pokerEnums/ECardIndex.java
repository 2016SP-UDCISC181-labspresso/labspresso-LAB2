
package pokerEnums;

/**
 * @author Auzi
 *
 */
//THIS ALLOWS YOU TO ACCESS A CARD IN HAND BY INDEX
public enum ECardIndex {
	FIRST(0),
	SECOND(1),
	THIRD(2),
	FOURTH(3),
	FIFTH(4),
	SIXTH(5),
	SEVENTH(6),
	EIGHTH(7),
	NINETH(8),
	TENTH(9),
	ELEVENTH(10);
	//it goes up to 11
	private int nthCard;
	
	public int getNthCard(){
		return nthCard;
	}
	
	private ECardIndex(int nthCard){
		this.nthCard = nthCard;
	}

}
