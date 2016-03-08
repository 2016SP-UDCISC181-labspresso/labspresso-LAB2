package base;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


import org.junit.Test;


import exceptions.HandException;
import pokerEnums.ECardIndex;
import pokerEnums.ERank;
import pokerEnums.ESuit;

public class HandTest {


	

	private Hand makeTestHand(ArrayList<Card> setCards, Hand h)
	{
		Object t = null;
		
		try {
			//	Load the Class into 'c'
			Class<?> c = Class.forName("base.Hand");
			//	Create a new instance 't' from the no-arg Deck constructor
			t = c.newInstance();
			//	Load 'msetCardsInHand' with the 'Draw' method (no args);
			Method msetCardsInHand = c.getDeclaredMethod("setCardsInHand", new Class[]{ArrayList.class});
			//	Change the visibility of 'setCardsInHand' to true *Good Grief!*
			msetCardsInHand.setAccessible(true);
			//	invoke 'msetCardsInHand'
			Object oDraw = msetCardsInHand.invoke(t, setCards);
			
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
		
		h = (Hand)t;
		return h;
		
	}
	
	@Test(expected = HandException.class)
	public void notEnoughCards() throws Exception {
		
		Hand handtest = new Hand();//creates an instance of hand
		Card AOfClubs = new Card(ESuit.CLUBS,ERank.ACE);//creates an instance of a card
		Card QOfHearts = new Card(ESuit.HEARTS,ERank.QUEEN);//''
		ArrayList<Card> notEnoughCards = new ArrayList<Card>();
		notEnoughCards.add(AOfClubs);
		notEnoughCards.add(QOfHearts);

		handtest = makeTestHand(notEnoughCards,handtest);
		
		
		handtest = Hand.EvaluateHand(handtest);	//expect an exception here 
	}	
			
	@Test
	public void TestFourOfAKind() {
		
		HandScore testscore = new HandScore();
		ArrayList<Card> FourOfAKind = new ArrayList<Card>();
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.ACE));
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.ACE));
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.ACE));		
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.ACE));
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.KING));
		
		Hand handtest = new Hand();
		handtest = makeTestHand(FourOfAKind,handtest);
		
		boolean boolFOAK = Hand.isFourOfAKind(handtest, testscore);
		boolean boolExpFOAK = true;
		
		
		assertEquals(boolFOAK,boolExpFOAK);		
		
		assertEquals(testscore.getHiHand(),ERank.ACE.getRankNum(),0);		
		
		assertEquals(testscore.getKickers().get(ECardIndex.FIRST.getNthCard()).getESuit(), ESuit.CLUBS);
				
		assertEquals(testscore.getKickers().get(ECardIndex.FIRST.getNthCard()).getERank(), ERank.KING);
		
		HandScore test2 = new HandScore();
		ArrayList<Card> FourOfAKind2 = new ArrayList<Card>();
		Card AOH = new Card(ESuit.HEARTS,ERank.ACE);
		Card FOH = new Card(ESuit.HEARTS,ERank.FIVE);
		Card FOD = new Card(ESuit.DIAMONDS,ERank.FIVE);
		Card FOS = new Card(ESuit.SPADES,ERank.FIVE);
		Card FOC = new Card(ESuit.CLUBS,ERank.FIVE);
		
		FourOfAKind2.add(AOH);
		FourOfAKind2.add(FOC);
		FourOfAKind2.add(FOS);
		FourOfAKind2.add(FOD);
		FourOfAKind2.add(FOC);
		FourOfAKind2.add(FOH);
		
		Hand handtest2 = new Hand();
		handtest2 = makeTestHand(FourOfAKind,handtest2);
		boolean boolFOAK2 = Hand.isFourOfAKind(handtest2, test2);
		boolean boolExpFOAK2 = true;
		assertEquals(boolFOAK2,boolExpFOAK2);	
	}
	
	@Test
	public void TestFourOfAKindEval() {
		/*
		 * This makes an example of a Four of A Kind Hand
		 */
		
		ArrayList<Card> FourOfAKind = new ArrayList<Card>();
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.ACE));
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.ACE));
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.ACE));
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.ACE));
		FourOfAKind.add(new Card(ESuit.CLUBS,ERank.KING));
		
		Hand h = new Hand();
		h = makeTestHand(FourOfAKind,h);
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (HandException e) {			
			e.printStackTrace();
			fail("TestFourOfAKindEval failed");
		}
		HandScore hs = h.getHandScore();
		System.out.print(h.getHandScore());
		boolean bActualIsHandFourOfAKind = Hand.isFourOfAKind(h, hs);
		boolean bExpectedIsHandFourOfAKind = true;
		
		//	Did this evaluate to Four of a Kind?
		assertEquals(bActualIsHandFourOfAKind,bExpectedIsHandFourOfAKind);		
		//	Was the four of a kind an Ace?
		assertEquals(hs.getHiHand(),ERank.ACE.getRankNum());		
		//	FOAK has one kicker.  Was it a Club?
		assertEquals(hs.getKickers().get(ECardIndex.FIRST.getNthCard()).getESuit(), ESuit.CLUBS);
		//	FOAK has one kicker.  Was it a King?		
		assertEquals(hs.getKickers().get(ECardIndex.FIRST.getNthCard()).getERank(), ERank.KING);
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
