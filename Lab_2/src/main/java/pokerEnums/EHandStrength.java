package pokerEnums;

public enum EHandStrength {
	RoyalFlush(100, "isRoyalFlush"){
		public String toString() {
			return "Royal Flush";
		}
	},
	StraightFlush(90, "isStraightFlush"){
		public String toString(){
			return "Straight Flush";
		}
	},
	FourofAKind(80, "isFourOfAKind"){
		public String toString(){
			return "Four of a Kind";
		}
	},
	FullHouse(70, "isFullHouse"){
		public String toString(){
			return "Full House";
		}
	},
	Flush(60,"isFlush"){
		public String toString(){
			return "Flush";
		}
	},
	Straight(50,"isStraight"){
		public String toString(){
			return "Flush";
		}
	},
	ThreeOfAKind(40,"isThreeOfAKind"){
		public String toString(){
			return "Three of a Kind";
		}
	},
	TwoPair(30,"isTwoPair"){
		public String toString(){
			return "Two Pair";
		}
	},
	Pair(20,"isPair"){
		public String toString(){
			return "Pair";
		}
	},
	HighCard(10,"isHighCard"){
		public String toString(){
			return "High Card";
		}
	};
	private EHandStrength(final int handStrength, final String stringEval){
		this.handStrength = handStrength;
		this.stringEval = stringEval;
	}
	private int handStrength;
	private String stringEval;
	
	public int getHandStrength(){
		return handStrength;
	}
	public String getStringEval(){
		return this.stringEval;
	}




}
