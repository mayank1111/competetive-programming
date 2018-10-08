import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Knapsack {
	static int weight;
	static int n;
	static int itemsInCargo;
	static int maxProfit=0;
	static class Cargo
	{
		int cargoNo;
		int weight;
		int profit;
	}
	//static Cargo[] cargoArr;
	
	static int[][] cargoList;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		weight = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		itemsInCargo = Integer.parseInt(br.readLine());
		cargoList = new int[n][itemsInCargo];
		//cargoArr = new Cargo[n];
		for(int i=0;i<n;++i)
		{
			String[] split = br.readLine().split(" ");
			//Cargo c = new Cargo();
			cargoList[i][0] = Integer.parseInt(split[0]);
			cargoList[i][1] = Integer.parseInt(split[1]);
			cargoList[i][2] = Integer.parseInt(split[2]);
			//cargoArr[i] = c;
		}
		knapSack();
		
	}

	public static void knapSack()
	{

		int profitArr[][] = new int[n + 1][weight + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= weight; w++) {
				if (i == 0 || w == 0)
					profitArr[i][w] = 0;
				else if (cargoList[i - 1][1] <= w)
					profitArr[i][w] = Math.max(cargoList[i - 1][2] + 
							profitArr[i - 1][w - cargoList[i - 1][1]], profitArr[i - 1][w]);
				else
					profitArr[i][w] = profitArr[i - 1][w];
			}
		}

		int numberOfElements = 0;
		maxProfit  = profitArr[n][weight];
		int tempMaxProfit = maxProfit;
		int tempWeight = weight;
		ArrayList<Integer> cargoIdList = new ArrayList<Integer>();
		
		for (int reverseInd = n; reverseInd > 0 && tempMaxProfit > 0; --reverseInd) {

			// element not picked
			if (tempMaxProfit == profitArr[reverseInd - 1][tempWeight])
				continue;
			// element picked
			else {
				++numberOfElements;
				cargoIdList.add(cargoList[reverseInd-1][0]);

				
				tempMaxProfit = tempMaxProfit - cargoList[reverseInd - 1][2];
				tempWeight = tempWeight - cargoList[reverseInd - 1][1];
			}
		}
		
		for(int i=numberOfElements-1;i>=0;--i)
		{
			System.out.println(cargoIdList.get(i));
		}
		System.out.println(maxProfit);
		
	}

}
