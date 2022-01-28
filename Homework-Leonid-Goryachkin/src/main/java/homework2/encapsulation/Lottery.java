package homework.encapsulation;

public class Lottery {
	private int playersNumber;
	private int winnerTicket;
	private int prize;
	
	public int getPlayersNumber() {
		return playersNumber;
	}
	public void setPlayersNumber(int playersNumber) {
		this.playersNumber = playersNumber;
	}
	public int getWinnerTicket() {
		return winnerTicket;
	}
	public void setWinnerTicket(int winnerTicket) {
		this.winnerTicket = winnerTicket;
		
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	
}
