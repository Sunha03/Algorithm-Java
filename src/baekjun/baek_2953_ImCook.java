package baekjun;

import java.util.*;

public class baek_2953_ImCook {
	public static void main(String[] args) {
		int ans_num = 0;
		int ans_max = -1;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			int sum = 0;
			
			for(int j=0;j<4;j++) {		//�丮�纰 ���� �ջ�
				sum += sc.nextInt();
			}
			
			if(ans_max < sum) {			//�ְ� ���� ����
				ans_num = i + 1;
				ans_max = sum;
			}
		}
		
		System.out.println(ans_num + " " + ans_max);	//���� ���
	}
}


/*
(input)
5 4 4 5
5 4 4 4
5 5 4 4
5 5 5 4
4 4 4 5

(output)
4 19
 */