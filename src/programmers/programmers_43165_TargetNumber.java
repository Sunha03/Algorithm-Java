package programmers;

public class programmers_43165_TargetNumber {
	static int answer = 0;

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		solution(numbers, 3);
		//(output) 5
	}

	public static int solution(int[] numbers, int target) {
        calc(0, numbers.length, 0, target, numbers);	//
        
        System.out.println(answer);
        return answer;
    }
	
	//DFS
	public static void calc(int now, int end, int calcNum, int target, int[] numbers) {
		if(now == end) {		//numbers�� ��� ��Ҹ� ���
			if(calcNum == target)		//����� target�� ������
				answer++;				//���� �߰�

			return;
		}
		
		calc(now+1, end, calcNum + numbers[now], target, numbers);		//���� ���� ���ϱ�
		calc(now+1, end, calcNum - numbers[now], target, numbers);		//���� ���� ����
	}
}
