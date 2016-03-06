package base;
import pokerEnums.*;
import java.util.*;

public class Deck{

	Deck deck = createDeck();
	
	public static Deck createDeck(){

		for(pokerEnums.ESuit suit : ESuit.values()){
			for (pokerEnums.ERank rank : ERank.values()){
				Card card = new Card(suit, rank);
				deck = new ArrayList<Card>();
				deck.add(card);
				
			}
		}
		return deck;
	}
	
	private void add(Card card) {
		// TODO Auto-generated method stub
		
	}

	public Deck removeFromDeck(){
		return deck;
	}
	
	public Card drawDeck(){
		return deck.removeFromDeck(Card);
	}
	
	
	
	
}
