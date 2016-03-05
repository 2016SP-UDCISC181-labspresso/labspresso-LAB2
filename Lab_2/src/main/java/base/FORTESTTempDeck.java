package base;
import java.util.ArrayList;
import pokerEnums.ERank;
import pokerEnums.ESuit;

public class FORTESTTempDeck {
	ArrayList<Card> tempDeck = new ArrayList<Card>();// ArrayList<type of object stored in the damn thing>, got it?

	public ArrayList<Card> add(){
		
		tempDeck.add(new Card(ESuit.HEARTS,ERank.QUEEN));
		return tempDeck;
		
				
		
	}
	public Card draw(){//removes top card from tempDeck, and returns the Card
		Card cardDrawn = tempDeck.get(0);
		tempDeck.remove(0);
		return cardDrawn;
		
		
	}
	public FORTESTTempDeck(ArrayList<Card> tempDeck) {
		this.tempDeck = tempDeck;
	}

	

}
