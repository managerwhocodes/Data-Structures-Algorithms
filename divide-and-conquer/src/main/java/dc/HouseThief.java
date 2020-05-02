package dc;

public class HouseThief {

	protected int maxMoney(int []totalHouseMoney , int index) {
		
		if(index >= totalHouseMoney.length)
			return 0;
		
		int stealCurrentHouse = totalHouseMoney[index] + maxMoney(totalHouseMoney, index+2);
		int skipCurrentHouse = maxMoney(totalHouseMoney, index+1);
		
		return Math.max(stealCurrentHouse, skipCurrentHouse);
	}

	public static void main(String[] args) {
		HouseThief ht = new HouseThief();
		
		int []totalHouseMoney = {5,7,1,30,8,2,4}; 
		System.out.println("Total Number of Houses : "+totalHouseMoney.length);
		System.out.print("Money thief can steal from each house : ");
		for(int cost :totalHouseMoney) {
			System.out.print(cost+ " , ");
		}
		System.out.println("\nMaximum money the thief can steal : "+ht.maxMoney(totalHouseMoney, 0));
	}
}
