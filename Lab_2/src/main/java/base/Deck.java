package base;
import pokerEnums.*;
import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck(){
		cards = new ArrayList<Card>();
		for(pokerEnums.ESuit suit : ESuit.values()){
			for (pokerEnums.ERank rank : ERank.values()){
				Card card = new Card(suit, rank);
				cards.add(card);
			}
		}
	}
	public void shuffle(){
		for ( int i = cards.size()-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = cards.get(i);
            cards.set(i, cards.get(rand));
            cards.set(rand, temp);
		}
	}
	public Card getCard() {
		if(cards.size()>0){
			Card card = cards.get(cards.size()-1);
			cards.remove(cards.size()-1);
			return card;
		}
		else{
			return null;
		}
		
	}
	//number of Cards in Deck
	private int numcards(){
		return cards.size();
	}
}
