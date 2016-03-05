package base;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DeckTest {

	/*@Test
	public void isDrawCard(){//This test passes with a dumby deck!
		ArrayList<Card> testDeck = new ArrayList<Card>();
		
		TempDeck deckTestOne = new TempDeck(testDeck);
		deckTestOne.add();
		assertTrue(deckTestOne.draw() instanceof Card );*/
	}
	
	
	@Test
	public void isCardRemoved(testDeck){//Check if the card drawn is actually removed
	
	}
	
	@Test 
	public void isOverdrawException(testDeck){//See if overdrawing Deck creates exception
		
	}
	
	@Test
	public void isNewDeckFull(testDeck){//See if card w/o any draws contains 52 cards (w/o Jokers)

}

