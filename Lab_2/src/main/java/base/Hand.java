package base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.reflect.InvocationTargetException;
import exceptions.DeckException;
import exceptions.HandException;
import pokerEnums.*;
public class Hand {

	private ArrayList<Card> CardsInHand;
	private ArrayList<Card> BestCardsInHand;
	private HandScore HandScore;
	private boolean bScored = false;

	public Hand() {
		CardsInHand = new ArrayList<Card>();
		BestCardsInHand = new ArrayList<Card>();
	}

	public ArrayList<Card> getCardsInHand() {
		return CardsInHand;
	}

	private void setCardsInHand(ArrayList<Card> cardsInHand) {
		CardsInHand = cardsInHand;
	}

	public ArrayList<Card> getBestCardsInHand() {
		return BestCardsInHand;
	}

	public void setBestCardsInHand(ArrayList<Card> bestCardsInHand) {
		BestCardsInHand = bestCardsInHand;
	}

	public HandScore getHandScore() {
		return HandScore;
	}

	public void setHandScore(HandScore handScore) {
		HandScore = handScore;
	}

	public boolean isbScored() {
		return bScored;
	}

	public void setbScored(boolean bScored) {
		this.bScored = bScored;
	}

	public Hand AddCardToHand(Card c) {
		CardsInHand.add(c);
		return this;
	}

	public Hand Draw(Deck d) throws DeckException {
		CardsInHand.add(d.getCard());
		return this;
	}

	/**
	 * EvaluateHand is a static method that will score a given Hand of cards
	 * 
	 * @param h
	 * @return
	 * @throws HandException 
	 */
	public static Hand EvaluateHand(Hand h) throws HandException {

		Collections.sort(h.getCardsInHand());


		if (h.getCardsInHand().size() != 5) {
			throw new HandException(h);
		}

		HandScore handscore = new HandScore();
		try {
			Class<?> reflectorHand = Class.forName("base.Hand");

			for (EHandStrength hstr : EHandStrength.values()) {
				Class[] cArg = new Class[2];
				cArg[0] = base.Hand.class;
				cArg[1] = base.HandScore.class;

				Method method = reflectorHand.getMethod(hstr.getStringEval(), cArg);
				Object o = method.invoke(null, new Object[] { h, handscore });

				
				if ((Boolean) o) {
					break;
				}
			}

			h.bScored = true;
			h.HandScore = handscore;

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return h;
	}


	

	public static boolean isRoyalFlush(Hand h, HandScore hs) {
		boolean bHandCheck = false;
		if ((h.getCardsInHand().get(ECardIndex.FIRST.getNthCard()).getERank() == ERank.JACK)&&
			(h.getCardsInHand().get(ECardIndex.SECOND.getNthCard()).getERank() == ERank.QUEEN)&&
			(h.getCardsInHand().get(ECardIndex.THIRD.getNthCard()).getERank() == ERank.KING)&&
			(h.getCardsInHand().get(ECardIndex.FOURTH.getNthCard()).getERank() == ERank.ACE)&&
			((h.getCardsInHand().get(ECardIndex.FIRST.getNthCard()).getESuit())== 
			(h.getCardsInHand().get(ECardIndex.SECOND.getNthCard()).getESuit())&
			(h.getCardsInHand().get(ECardIndex.THIRD.getNthCard()).getESuit()) == 
			(h.getCardsInHand().get(ECardIndex.FOURTH.getNthCard()).getESuit())&
			(h.getCardsInHand().get(ECardIndex.FOURTH.getNthCard()).getESuit()) ==
			(h.getCardsInHand().get(ECardIndex.FIFTH.getNthCard()).getESuit())))
				
		{
			bHandCheck = true;
			hs.setHandStrength(EHandStrength.RoyalFlush.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(ECardIndex.FIRST.getNthCard()).getERank().getRankNum());
		}
		hs.setHandStrength(EHandStrength.RoyalFlush.getHandStrength());
		return bHandCheck;
	}
//////////////////////////////////////////////////////////////////////////////

	public static boolean isStraightFlush(Hand h, HandScore hs) {
		hs.setHandStrength(EHandStrength.StraightFlush.getHandStrength());
		return false;
	}
///////////////////////////////////////////////////////////////////////////
	public static boolean isFourOfAKind(Hand h, HandScore hs) {
		
		boolean bHandCheck = false;
		
		if (h.getCardsInHand().get(ECardIndex.FIRST.getNthCard()).getERank() == 
				h.getCardsInHand().get(ECardIndex.FOURTH.getNthCard()).getERank()) 
		{
			bHandCheck =true;
			hs.setHandStrength(EHandStrength.FourofAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(ECardIndex.FIRST.getNthCard()).getERank().getRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(ECardIndex.FIFTH.getNthCard()));
			hs.setKickers(kickers);
			
		} else if (h.getCardsInHand().get(ECardIndex.SECOND.getNthCard()).getERank() == 
				h.getCardsInHand().get(ECardIndex.FIFTH.getNthCard()).getERank()) 
		{
			bHandCheck =true;
			hs.setHandStrength(EHandStrength.FourofAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(ECardIndex.SECOND.getNthCard()).getERank().getRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(ECardIndex.FIRST.getNthCard()));
			hs.setKickers(kickers);
		}
		
		return bHandCheck;
	}

	public static boolean isHandFullHouse(Hand h, HandScore hs) {
		hs.setHandStrength(EHandStrength.FullHouse.getHandStrength());
		return false;
	}

	public static boolean isHandFlush(Hand h, HandScore hs) {
		boolean bHandCheck = false;
		if(((h.getCardsInHand().get(ECardIndex.FIRST.getNthCard()).getESuit())== 
			(h.getCardsInHand().get(ECardIndex.SECOND.getNthCard()).getESuit())&
			(h.getCardsInHand().get(ECardIndex.THIRD.getNthCard()).getESuit()) == 
			(h.getCardsInHand().get(ECardIndex.FOURTH.getNthCard()).getESuit())&
			(h.getCardsInHand().get(ECardIndex.FOURTH.getNthCard()).getESuit()) ==
			(h.getCardsInHand().get(ECardIndex.FIFTH.getNthCard()).getESuit())))
		{
			bHandCheck = true;
			hs.setHandStrength(EHandStrength.Flush.getHandStrength());
		}
		
		return bHandCheck;
	}

	public static boolean isHandStraight(Hand h, HandScore hs) {
		hs.setHandStrength(EHandStrength.Straight.getHandStrength());
		return false;
	}

	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {
		boolean bHandCheck = false;
		if (h.getCardsInHand().get(ECardIndex.FIRST.getNthCard()).getERank() == 
				h.getCardsInHand().get(ECardIndex.THIRD.getNthCard()).getERank())
		{
			bHandCheck = true;
			hs.setHandStrength(EHandStrength.ThreeOfAKind.getHandStrength());
		}
		else if (h.getCardsInHand().get(ECardIndex.SECOND.getNthCard()).getERank() == 
				h.getCardsInHand().get(ECardIndex.FOURTH.getNthCard()).getERank()) 
		{
			bHandCheck = true;
			hs.setHandStrength(EHandStrength.ThreeOfAKind.getHandStrength());
		}
		else if (h.getCardsInHand().get(ECardIndex.THIRD.getNthCard()).getERank() == 
				h.getCardsInHand().get(ECardIndex.FIFTH.getNthCard()).getERank()) 
		{
			bHandCheck = true;
			hs.setHandStrength(EHandStrength.ThreeOfAKind.getHandStrength());
		}
		return bHandCheck;
	}

	public static boolean isHandTwoPair(Hand h, HandScore hs) {
		hs.setHandStrength(EHandStrength.TwoPair.getHandStrength());
		return true;
	}

	public static boolean isHandPair(Hand h, HandScore hs) {
		hs.setHandStrength(EHandStrength.Pair.getHandStrength());
		return false;
	}

	public static boolean isHandHighCard(Hand h, HandScore hs) {
		hs.setHandStrength(EHandStrength.HighCard.getHandStrength());
		return false;
	}

}
