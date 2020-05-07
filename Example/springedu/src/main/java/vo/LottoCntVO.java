package vo;

public class LottoCntVO {
	private int lottoCnt;
	
	public LottoCntVO() {
		this.lottoCnt=1;
	}
	public int getLottoCnt() {
		return lottoCnt;
	}

	public void setLottoCnt(int lottoCnt) {
		this.lottoCnt += lottoCnt;
	}
	
}
