package baekjoon;

import java.util.*;

public class baek_14501_Leave {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int input[][] = new int [n][2];
		for(int i=0;i<n;i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}
		
		int answer = checkConsulting(input, 0, 0);
		System.out.println(answer);
	}

	public static int checkConsulting(int input[][], int today, int sumPrice) {
		int res1 = 0, res2 = 0;
		
		//System.out.println(today + " " + sumPrice);
		if(today >= input.length) {					//��� ��¥ ����
			return sumPrice;
		} else if(today == input.length - 1) {		//����ϱ� ����
			if(input[today][0] == 1)				//1��¥�� ���
				return sumPrice + input[today][1];
			else if(input[today][0] > 1)			//1�� �̻� ���
				return sumPrice;
		}
		
		
		res1 = checkConsulting(input, today + 1, sumPrice);		//���� ��� (X)
		if(today + input[today][0] <= input.length) {
			sumPrice += input[today][1];
			res2 = checkConsulting(input, today + input[today][0], sumPrice);	//���� ��� (O)
		}
			
		if(res1 > res2)		//�ִ� ���� �� ����
			return res1;
		else
			return res2;
	}
}