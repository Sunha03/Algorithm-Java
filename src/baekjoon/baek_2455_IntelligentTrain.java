package baekjun;

import java.util.*;

public class baek_2455_IntelligentTrain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0, max = -1;
		int train[][] = new int[4][2];
		for(int i=0;i<train.length;i++) {		//input
			for(int j=0;j<train[i].length;j++) {
				train[i][j] = sc.nextInt();

				if(j == 0)				//������ ���
					train[i][j] *= -1;
				
				sum += train[i][j];		//���� �ȿ� �ִ� �α� ��
				if(sum > max)			//�ִ밪 ����
					max = sum;
			}
		}
		
		System.out.println(max);
	}
}


/*
(input)
0 32
3 13
28 25
39 0
(output)
42
*/