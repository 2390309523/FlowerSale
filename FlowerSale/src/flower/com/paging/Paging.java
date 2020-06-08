package flower.com.paging;

public class Paging {
	private int sumRecord =0; 
	private int adder = 50;
	private int firstIndex = 0;
	private int maxIndex = 0;
	public Paging(int sumRecord,int adder,int firstIndex,int maxIndex){
		this.sumRecord = sumRecord;
		this.adder = adder;
		this.firstIndex = firstIndex;
		this.maxIndex = maxIndex;
	}
	public int getSumRecord() {
		return sumRecord;
	}
	public void setSumRecord(int sumRecord) {
		this.sumRecord = sumRecord;
	}
	public int getAdder() {
		return adder;
	}
	public void setAdder(int adder) {
		this.adder = adder;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	public int getMaxIndex() {
		return maxIndex;
	}
	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}

}
