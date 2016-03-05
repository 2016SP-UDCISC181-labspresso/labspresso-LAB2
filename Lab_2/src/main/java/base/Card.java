package base;
import java.util.Comparator;
import pokerEnums.ESuit;
import pokerEnums.ERank;


public class Card implements Comparable {
	private ESuit ESuit;
	private ERank ERank;
	
	
	public Card(pokerEnums.ESuit ESuit, pokerEnums.ERank ERank){
		this.ESuit = ESuit;
		this.ERank = ERank;
		
		
	}

	public ESuit getESuit() {
		return ESuit;
	}

	private void setESuit(ESuit eSuit) {
		ESuit = eSuit;
	}

	public ERank getERank() {
		return ERank;
	}

	private void setERank(ERank eRank) {
		ERank = eRank;
	}





	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
