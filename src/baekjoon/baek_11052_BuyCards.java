package baekjun;

import java.util.*;

public class baek_11052_BuyCards {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		int[] prices = new int[n+1];
		int[] maxPrices = new int[n+1];
		
		for(int i=1;i<=n;i++)		// input
			prices[i] = sc.nextInt();
		
		maxPrices[1] = prices[1];
		for(int i=2;i<=n;i++) {
			maxPrices[i] = prices[i];	// ī�� 1���� ��
			
			for(int j=1;j<=i/2;j++) {
//				System.out.println(i-j + " : " + maxPrices[i-j]);
//				System.out.println(j + " : " + maxPrices[j]);
//				System.out.println(maxPrices[i] + " ,  " + (maxPrices[i-j] + prices[j]) + "\n");
				if(maxPrices[i] < maxPrices[i-j] + prices[j])	// ī�� i���� ��(ī�� i-j���� �� �ִ�ݾ� + ī�� j���� �� �ִ�ݾ�)
					maxPrices[i] = maxPrices[i-j] + prices[j];
			}
//			System.out.println("=> " + maxPrices[i]);
		}
		
//		for(int i=0;i<n;i++) {
//			System.out.print(maxPrices[i] + "\t");
//		}System.out.println();
		
		answer = maxPrices[n];
		System.out.println(answer);
	}
}


/*
4
1 5 6 7
(output)
10

5
10 9 8 7 6
(output)
50

10
1 1 2 3 5 8 13 21 34 55
(output)
55

10
5 10 11 12 13 30 35 40 45 47
(output)
50

4
5 2 8 10
(output)
20

4
3 5 15 16
(output)
18

14
10 25 10 48 31 21 33 6 37 6 43 35 1 20
(output)
175

16
3 32 39 41 39 3 39 34 32 9 20 13 37 26 16 39
(output)
256

12
25 111 8 113 4 111 29 100 99 118 47 101
(output)
666
*/
