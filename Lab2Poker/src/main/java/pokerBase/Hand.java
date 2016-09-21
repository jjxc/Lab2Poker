package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Hand {

	private ArrayList<Card> CardsInHand;
	private HandScore HandScore;

	public Hand() {
		CardsInHand = new ArrayList<Card>();
	}
	
	private ArrayList<Card> getCardsInHand() {
		return CardsInHand;
	}
	
	public Hand AddCardToHand(Card c) {
		CardsInHand.add(c);
		return this;
	}

	public Hand Draw(Deck d) {
		for (int handSize = 0; handSize <  5; handSize++){
		CardsInHand.add(d.Draw());
		}
		return this;
	}

	
/*	
	public static HandStrength evalHand(Hand h){
		Collections.sort(h.getCardsInHand());
		if (h.getCardsInHand().size!=5){
			throw new Hand(h);
			getCardsInHand() = new Hand();
		}
	}/**/
	
	
	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {

		boolean isRoyalFlush = false;
		
		if (isHandStraight(h,hs) && (isHandFlush(h,hs)) && 
				(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr()) == 10)
		{
		isRoyalFlush = true;
		hs.setHandStrength(eHandStrength.RoyalFlush.getHandStrength());
		hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
		hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
		ArrayList<Card> kickers = new ArrayList<Card>();
		kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
		hs.setKickers(kickers);
		}
		
		return isRoyalFlush;
		
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {
		
		boolean isStraightFlush = false;
		
		if (isHandStraight(h,hs) && (isHandFlush(h,hs)))
		{
		isStraightFlush = true;
		hs.setHandStrength(eHandStrength.RoyalFlush.getHandStrength());
		hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
		hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
		ArrayList<Card> kickers = new ArrayList<Card>();
		kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
		hs.setKickers(kickers);
		}
		
		return isStraightFlush;
		
	}

	public static boolean isHandFourOfAKind(Hand h, HandScore hs) {

		boolean bHandCheck = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}

		return bHandCheck;
	}

	public static boolean isHandFullHouse(Hand h, HandScore hs) {

		boolean bHandCheck = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()&&
				(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank())) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			hs.setKickers(kickers);
		}
		
		else if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
					.get(eCardNo.SecondCard.getCardNo()).geteRank()&&(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank()
							== h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank())) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			hs.setKickers(kickers);
		}

		return bHandCheck;
	}

	public static boolean isHandFlush(Hand h, HandScore hs) {
		
		boolean bIsFlush = false;
		
		for (int i = 0; i <  5; i++) {
			if  (h.getCardsInHand().get(i).geteSuit() !=  (h.getCardsInHand().get(i+1).geteSuit())) {
				bIsFlush = true;
				hs.setHandStrength(eHandStrength.Flush.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(0);
				ArrayList<Card> kickers = new ArrayList<Card>();
				kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
				hs.setKickers(kickers);
			}
				return false;
			}
		return bIsFlush;
	}

	public static boolean isHandStraight(Hand h, HandScore hs) {
	
		boolean bIsStraight = false;
			
		for (int i = 0; i < 4; i++) {
			if (h.getCardsInHand().get(i).geteRank() != (h.getCardsInHand().get(i + 1).geteRank())) {
				bIsStraight = true;
				hs.setHandStrength(eHandStrength.Flush.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(0);
				ArrayList<Card> kickers = new ArrayList<Card>();
				kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
				hs.setKickers(kickers);
		}
			return bIsStraight;
		}
	return bIsStraight;
}
			 
	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {

		boolean bThreeOfKind = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) {
			bThreeOfKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			bThreeOfKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
			
		} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			bThreeOfKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			hs.setKickers(kickers);
	}

		return bThreeOfKind;
	}
	


	public static boolean isHandTwoPair(Hand h, HandScore hs) {

		boolean isTwoPair = false; {
			Card firstPair = null;
				for (int cardPosi = 0; cardPosi < 4; cardPosi++) {
					if((h.getCardsInHand().get(cardPosi).geteRank() == (h.getCardsInHand().get(cardPosi).geteRank()))){
						firstPair = h.getCardsInHand().get(cardPosi);
						// allows isTwoPair to remember the first pair it finds
						hs.setLoHand(h.getCardsInHand().get(cardPosi).geteRank().getiRankNbr()); 
						// LoHand here will be overwritten later if second 'if' is false
						ArrayList<Card> kickers = new ArrayList<Card>();
						if (cardPosi == 2){
							kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
						}
					break;
					}

				}		
				if (firstPair == null) 
					isTwoPair = false;
				for (int cardPosi = 0; cardPosi < 4; cardPosi++) {
					if((h.getCardsInHand().get(cardPosi).geteRank() == h.getCardsInHand().get(cardPosi+1).geteRank())&& 
							h.getCardsInHand().get(cardPosi)!=firstPair){
						isTwoPair = true;
						hs.setHiHand(h.getCardsInHand().get(cardPosi).geteRank().getiRankNbr());
						hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
						ArrayList<Card> kickers = new ArrayList<Card>();
						if (cardPosi == 3){
							kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
						}
						else
							kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
						hs.setKickers(kickers);
					}
				}
				return isTwoPair;
			}
	}

	public static boolean isHandPair(Hand h, HandScore hs) {
		boolean bIsPair = false;
		
		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.SecondCard.getCardNo()).geteRank()) {
			bIsPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) {
			bIsPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
			
		} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			bIsPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
			
		} else if (h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			bIsPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			hs.setKickers(kickers);

	}

		return bIsPair;
	}

	/**
	 * @param h
	 * @param hs
	 * @return
	 */
	public static boolean isHandHighCard(Hand h, HandScore hs) {
		hs.setHandStrength(eHandStrength.HighCard.getHandStrength());
		hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
		hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
		ArrayList<Card> kickers = new ArrayList<Card>();
		kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
		kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
		kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
		hs.setKickers(kickers);
		return true;
	}
}
