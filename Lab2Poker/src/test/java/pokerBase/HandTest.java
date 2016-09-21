package pokerBase;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eRank;
import pokerEnums.eSuit;




public class HandTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void TestRoyalFlush() {	
		HandScore hs = new HandScore();
		ArrayList<Card> RoyalFlush = new ArrayList<Card>();
		RoyalFlush.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		RoyalFlush.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		RoyalFlush.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		RoyalFlush.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isRoyalFlush);
		boolean ActIsRoyalFlush = Hand.isRoyalFlush(h,hs);
		boolean ExpisRoyalFlush = true;
		assertEquals(ActIsRoyalFlush,ExpisRoyalFlush);
	}

	@Test
	public void TestFourOfAKind() {	
		HandScore hs = new HandScore();
		ArrayList<Card> FourOfAKind = new ArrayList<Card>();
		FourOfAKind.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		FourOfAKind.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		FourOfAKind.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		FourOfAKind.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isFourOfAKind);
		boolean ActIsFourOfAKind = Hand.isFourOfAKind(h,hs);
		boolean ExpisFourOfAKind = true;
		assertEquals(ActIsFourOfAKind,ExpisFourOfAKind);
	}

	@Test
	public void TestStraightFlush() {
		HandScore hs = new HandScore();
		ArrayList<Card> StraightFlush = new ArrayList<Card>();
		StraightFlush.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		StraightFlush.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		StraightFlush.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		StraightFlush.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isStraightFlush);
		boolean ActIsStraightFlush = Hand.isStraightFlush(h,hs);
		boolean ExpisFourOfAKind = true;
		assertEquals(ActIsStraightFlush,ExpisStraightFlush);
	}
	
	public void TestFullHouse() {
		HandScore hs = new HandScore();
		ArrayList<Card> FullHouse = new ArrayList<Card>();
		FullHouse.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		FullHouse.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		FullHouse.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		FullHouse.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isFullHouse);
		boolean ActIsFullHouse = Hand.isFullHouse(h,hs);
		boolean ExpisFullHouse = true;
		assertEquals(ActIsFullHouse,ExpisFullHouse);
	}
	public void TestFlush() {
		HandScore hs = new HandScore();
		ArrayList<Card> Flush = new ArrayList<Card>();
		Flush.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		Flush.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		Flush.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		Flush.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isFlush);
		boolean ActIsFlush = Hand.isFlush(h,hs);
		boolean ExpisFlush = true;
		assertEquals(ActIsFlush,ExpisFlush);
	}
	public void TestStraight(){
		HandScore hs = new HandScore();
		ArrayList<Card> Straight = new ArrayList<Card>();
		Straight.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		Straight.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		Straight.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		Straight.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isStraight);
		boolean ActIsStraight = Hand.isStraight(h,hs);
		boolean ExpisStraight = true;
		assertEquals(ActIsStraight,ExpisStraight);
	}
		
	public void TestThreeOfAKind(){
		HandScore hs = new HandScore();
		ArrayList<Card> ThreeOfAKind = new ArrayList<Card>();
		ThreeOfAKind.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		ThreeOfAKind.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		ThreeOfAKind.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		ThreeOfAKind.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isThreeOfAKind);
		boolean ActIsThreeOfAKind = Hand.isThreeOfAKind(h,hs);
		boolean ExpisThreeOfAKind = true;
		assertEquals(ActIsThreeOfAKind,ExpisThreeOfAKind);
	}
	
	public void TestTwoPairs(){
		HandScore hs = new HandScore();
		ArrayList<Card> TwoPairs = new ArrayList<Card>();
		TwoPairs.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		TwoPairs.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		TwoPairs.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		TwoPairs.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isTwoPairs);
		boolean ActIsTwoPairs = Hand.isTwoPairs(h,hs);
		boolean ExpisTwoPairs = true;
		assertEquals(ActIsTwoPairs,ExpisTwoPairs);
	}
	public void TestPairs(){
		HandScore hs = new HandScore();
		ArrayList<Card> Pairs = new ArrayList<Card>();
		Pairs.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		Pairs.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		Pairs.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		Pairs.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isPairs);
		boolean ActIsPairs = Hand.isPairs(h,hs);
		boolean ExpisPairs = true;
		assertEquals(ActIsPairs,ExpisPairs);
	}
	
	public void TestHighCard(){
		HandScore hs = new HandScore();
		ArrayList<Card> HighCard = new ArrayList<Card>();
		HighCard.add(new Card(eSuit.SPADES,eRank.FIVE,0));
		HighCard.add(new Card(eSuit.CLUBS,eRank.FIVE,0));
		HighCard.add(new Card(eSuit.DIAMONDS,eRank.FIVE,0));
		HighCard.add(new Card(eSuit.HEARTS,eRank.FIVE,0));
		Hand h = new Hand();
		h = SetHand(isHighCard);
		boolean ActIsHighCard = Hand.isHighCard(h,hs);
		boolean ExpisHighCard = true;
		assertEquals(ActIsHighCard,ExpisHighCard);
	}
	
	
}
