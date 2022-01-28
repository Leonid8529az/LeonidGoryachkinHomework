package homework.encapsulation;

public class LotteryTest {

	public static void main(String[] args) {
		Lottery casinoLottery = new Lottery();
		casinoLottery.setPlayersNumber(10000);
		casinoLottery.setPrize(30000);
		casinoLottery.setWinnerTicket(487);
		
		System.out.println(casinoLottery.getPlayersNumber());
		System.out.println(casinoLottery.getPrize());
		System.out.println(casinoLottery.getWinnerTicket());

	}

}
