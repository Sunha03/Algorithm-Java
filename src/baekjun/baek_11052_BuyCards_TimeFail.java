package baekjun;

import java.util.*;

public class baek_11052_BuyCards_TimeFail {
	public static int MAX_TEMP = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		int[] prices = new int[n];
		int[] maxPrices = new int[n+1];
		
		for(int i=0;i<n;i++) {
			prices[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {		// 1~n���� ������ �ִ� �ݾ� ã��(dp)
			maxPrices[i] = prices[i-1];	// ī�� i���� �ݾ�
			int findMax = findMaximum(maxPrices, i);	// dp�� �ִ� �ݾ� ã��
			
			if(findMax > maxPrices[i])	// ī�� i�� �ݾ� vs dp�� ã�� �ִ� �ݾ� �� �ִ밪���� ������Ʈ
				maxPrices[i] = findMax;
		}
		
		for(int i=1;i<=n;i++) {
			if(maxPrices[i] > answer)
				answer = maxPrices[i];
			//System.out.print(maxPrices[i] + "\t");	// maxPrices ���
		}//System.out.println();
		
		System.out.println(answer);
	}

	public static int findMaximum(int[] maxPrices, int num) {	// dp�� �ִ� �ݾ� ã��
		MAX_TEMP = -1;	// maxPrices[num]�� �ִ밪
		
		for(int i=1;i<=num;i++) {
			int[] arr = new int[num];
			DuplicateCombination(maxPrices, arr, num, i, 0, 1);	// nC1 ~ nCn �ߺ�����
		}
		
		return MAX_TEMP;
	}
	
	// ī�� ���� �ߺ� ����
	public static void DuplicateCombination(int[] maxPrices, int[] arr, int n, int r, int idx, int target) {
		// System.out.println(n + ", " + r + ", " + idx + ", " + target);
		if(r == 0) {
			int sum = 0;
			int sumPrice = 0;
			for(int i=0;i<arr.length;i++) {	// ī���� ���պ� �ݾ� �ջ�
				sum += arr[i];
				sumPrice += maxPrices[arr[i]];
			}
			
			if(sum == n) {
				if(sumPrice > MAX_TEMP)		// maxPrices[i]�� ī�� �ִ� �ݾ� ������Ʈ
					MAX_TEMP = sumPrice;

//				for(int i=0;i<arr.length;i++)	// ī�� ���� ����
//					System.out.print(arr[i] + "\t");
//				System.out.println("\nsum : " + sumPrice);
			}
			
			return;
		}
		
		if(target > n)
			return;
		
		arr[idx] = target;
		DuplicateCombination(maxPrices, arr, n, r-1, idx+1, target);	// ����
		DuplicateCombination(maxPrices, arr, n, r, idx, target+1);		// ���� X
	}
}


/*
(input)
4
1 5 6 7
(output)
10

(input)
5
10 9 8 7 6
(output)
50

(input)
10
1 1 2 3 5 8 13 21 34 55
(output)
55

(input)
10
5 10 11 12 13 30 35 40 45 47
(output)
50

(input)
4
5 2 8 10
(output)
20

(input)
4
3 5 15 16
(output)
18
*/
