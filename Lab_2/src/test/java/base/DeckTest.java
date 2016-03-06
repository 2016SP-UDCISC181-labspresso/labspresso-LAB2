package base;
import static org.junit.Assert.*;
//junit

import org.junit.Test;
//reflectors
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class DeckTest {
	Deck testDeck = new Deck();
	
	@Test
	public void DrawsCard(){
		assertTrue(testDeck.getCard()instanceof Card);
		
		Deck d = new Deck();
		Object c = d.getCard();
		
		if(!(c instanceof Card)){
			fail("there was a problem drawing the card");
		}
		
	}
	
	@Test
	public void correctDeckSizeTest(){
		int correctDeckSize = 51;
		int irlDeckSize;
		
		try{
			
			Class<?> r = Class.forName("base.Deck");
			
			//r pretends to be Deck class
			
			Object deckinstance = r.newInstance();
			
			//deckinstance is an instance of r
			
			Method rgetCard = r.getDeclaredMethod("getCard", null);
			
			//this loads the getCard method. null is the parameters
			
			Method rnumcards = r.getDeclaredMethod("numcards", null);
			
			//loads private numcards method -> visability adjusted below
			
			rnumcards.setAccessible(true);
			Object rgetCardNow = rgetCard.invoke(deckinstance, null);
			
			//calls the rgetCard method
			
			Object rnumcardsNow = rnumcards.invoke(deckinstance, null);
			
			//calls the rnumcards method
			
			irlDeckSize = ((Integer) rnumcardsNow).intValue();
			
			assertEquals(correctDeckSize, irlDeckSize);
		
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
			
		}

	@Test//need to put expects exception here
	public void overDraw()throws Exception{
		
		Deck d = new Deck();
		Card c;
		for(int i = 0;i<100;i++){
			c = d.getCard();
			//System.out.print(c.getERank());
			//System.out.print(i +"\n");
		}
		
		}
	
	@Test
	public void shuffleTest(){
		ArrayList<Card> shuffled = new ArrayList<Card>();
		ArrayList<Card> unshuffled = new ArrayList<Card>();
		
		Deck US = new Deck();
		Deck S = new Deck();
		S.shuffle();
		
		for(int i = 1;i<10;i++){
			Card card = US.getCard();
			Card rCard = S.getCard();
			shuffled.add(rCard);
			unshuffled.add(card);
		}
			
		System.out.print(shuffled.size());	
		
			
		assertTrue(shuffled != unshuffled);
	
			
		
		
		
		
		

		
		
		
		
		
		
		
	}

}
