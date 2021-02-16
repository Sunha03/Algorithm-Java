package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baek_2632_SellingPizza2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// input
		int order = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sizeA = 0;				// ����A�� ��ü ũ��
		int sizeB = 0;				// ����B�� ��ü ũ��
		int answer = 0;
		int[] A = new int[m];		// ����A�� ���� �迭
		int[] B = new int[n];		// ����B�� ���� �迭
		ArrayList<Integer> subSumA = new ArrayList<>();		// ����A�� �κ��� ����Ʈ
		ArrayList<Integer> subSumB = new ArrayList<>();		// ����B�� �κ��� ����Ʈ
		for (int i = 0; i < m; i++) {
			A[i] = sc.nextInt();
			sizeA += A[i];
		}
		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
			sizeB += B[i];
		}
		
		subSumA.add(0);			
		subSumB.add(0);			// ���� ���� ���� X
		subSumA.add(sizeA);		
		subSumB.add(sizeB);		// ��ü ���� ���� ����
		
		getSubSum(A, subSumA, order);		// 1~(��ü��������-1) ������ �κ���
		getSubSum(B, subSumB, order);
		
		Collections.sort(subSumA);	// �κ��� ����
		Collections.sort(subSumB);	
		//(����) �������� : Collections.sort(subSumB, Comparator.reverseOrder());
		
		int a = 0;					// ����A�� ��������
		int b = subSumB.size()-1;	// ����B�� ��������
		while (a < subSumA.size() && b >= 0) {
			int sliceA = subSumA.get(a);
			int sliceB = subSumB.get(b);
			if (sliceA + sliceB == order) {		// ��ǥ ũ�⸦ ã����
				int cntA = 0;
				int cntB = 0;
				
				while (a < subSumA.size()) {		// ����A�� �κ��� ���� ī��Ʈ
					if (sliceA == subSumA.get(a)) {
						cntA++;
						a++;
					} else {
						break;
					}
				}
				while(b >= 0) {					// ����B�� �κ��� ���� ī��Ʈ
					if (sliceB == subSumB.get(b)) {
						cntB++;
						b--;
					} else {
						break;
					}
				}
				answer += cntA * cntB;			// ������ ������Ʈ
			}
			
			if (sliceA + sliceB < order) {		// ����A+����B �κ��� < ��ǥ��
				a++;
			}
			if (sliceA + sliceB > order) {		// ����A+����B �κ��� > ��ǥ��
				b--;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void getSubSum(int[] pizza, ArrayList<Integer> subSum, int order) {
		for (int i = 0; i < pizza.length; i++) {			// ���� ���� : ù��°~������
			int sum = 0;
			for (int j = 0; j < pizza.length - 1; j++) {	// ���� ���� ���� : 1~(��ü��������-1)
				sum += pizza[(i+j) % pizza.length];		// �κ���
				
				if (sum < order) {		// �ֹ��� ������ ���� �κ��ո� �߰�
					subSum.add(sum);
				}
			}
		}
	}
}


/*
(Input)
7
5 3
2 2 1 7 2
6 8 3
(Outputs)
5

(Input)
4
1 3
1
1 1 1
(Outputs)
1

(Input)
6
3 3
1 1 1 1 1 1
(Outputs)
1
*/
