package pokerEnums;

public enum ESuit {
	HEARTS(1),
	SPADES(2),
	CLUBS(3),
	DIAMONDS(4);
	
	private int suitNumber;

	public int getSuitNumber() {
		return suitNumber;
	}

	private ESuit(int suitNumber) {
		this.suitNumber = suitNumber;
	}
	
	
	

}
