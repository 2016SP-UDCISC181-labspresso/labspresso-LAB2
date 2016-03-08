package base;
import pokerEnums.*;
import java.util.ArrayList;
import exceptions.DeckException;
/*
 * For the rest of the team, Collections Negates the need for a shuffle method
 * as it has a shuffle method built in.
 */
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards;
	/*
	 * Returns a shuffled deck of Cards
	 */
	public Deck(){
		cards = new ArrayList<Card>();
		for(pokerEnums.ESuit suit : ESuit.values()){
			for (pokerEnums.ERank rank : ERank.values()){
				Card card = new Card(suit, rank);
				cards.add(card);
			}
			Collections.shuffle(cards);
		}
	}
	
		
	
	public Card getCard() throws DeckException  {//aka Draw
		if(cards.size()>0){
			return cards.remove(0);
		}
		else{
			throw new DeckException(this);
		}
		
	}
	
	private int numcards(){
		return cards.size();
	}
}
