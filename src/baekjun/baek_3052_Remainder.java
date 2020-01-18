package baekjun;

import java.util.*;

public class baek_3052_Remainder {
	public static void main(String[] args) {
		int answer = 0;
		int[] remainder = new int[42];

		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			int num = sc.nextInt();		//input
			remainder[num%42]++;		//������ ���� �߰�
		}
		
		for(int i=0;i<42;i++) {			//���� �ٸ� ������ ���� ī��Ʈ
			if(remainder[i] > 0) {
				answer++;
			}
		}
		
		System.out.println(answer);		//���� ���
	}
}


/*
(input)
39
40
41
42
43
44
82
83
84
85

(output)
6
*/