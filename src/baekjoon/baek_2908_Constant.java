package baekjoon;

import java.util.*;

public class baek_2908_Constant {
	public static void main(String[] args) {
		int[] num = new int[2];
		int[] newNum = new int[2];
		
		Scanner sc = new Scanner(System.in);	//input
		for(int i=0;i<num.length;i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i=0;i<num.length;i++) {			//���� 2����ŭ
			for(int j=0;j<3;j++) {				//3�ڸ���ŭ
				int temp = num[i] % 10;			//������ ����
				num[i] /= 10;
				newNum[i] += temp * Math.pow(10, (2 - j));		//������ ���� �� ������
			}
		}
		
		if(newNum[0] < newNum[1])			//�� ���� �� �� ���� ���
			System.out.println(newNum[1]);
		else
			System.out.println(newNum[0]);
		
	}
}

/*
(input)
734 893

(output)
437
*/