package base;
import java.util.Comparator;
import pokerEnums.ESuit;
import pokerEnums.ERank;


public class Card implements Comparable {
	private ESuit ESuit;
	private ERank ERank;
	private int rankNum;
	
	public Card(pokerEnums.ESuit ESuit, pokerEnums.ERank ERank,int rankNum){
		this.ESuit = ESuit;
		this.ERank = ERank;
		this.rankNum = rankNum;
		
	}

	public ESuit getESuit() {
		return ESuit;
	}

	private void setESuit(ESuit eSuit) {
		ESuit = eSuit;
	}

	public ERank getERank() {
		return ERank;
	}

	private void setERank(ERank eRank) {
		ERank = eRank;
	}

	public int getRankNum() {
		return rankNum;
	}

	private void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
