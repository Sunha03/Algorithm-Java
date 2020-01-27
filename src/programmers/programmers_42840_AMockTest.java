package programmers;

public class programmers_42840_AMockTest {
	public static void main(String[] args) {
		int[] answers1 = {1,2,3,4,5};
		solution(answers1);
		//(output) {1}
		
		int[] answers2 = {1,3,2,4,2};
		solution(answers2);
		//(output) {1,2,3}
	}

    //1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    //2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    //3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	public static int[] solution(int[] answers) {
        int[] answer;
        int[][] students = {{1, 2, 3, 4, 5},					//������1
        					{2, 1, 2, 3, 2, 4, 2, 5},			//������2
        					{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};	//������3
        int[] correct = new int[3];
        
        for(int i=0;i<students.length;i++)		//�� �������� ���� ���� ���
        	for(int j=0;j<answers.length;j++)
        		if(answers[j] == students[i][j % students[i].length])
        			correct[i]++;
        	
        int max = -1;
        int maxCount = 0;
        for(int i=0;i<correct.length;i++) {		//�ִ� ���� ����(max) ���ϱ�
        	if(max < correct[i]) {
        		maxCount = 1;
        		max = correct[i];
        	} else if(max == correct[i]) {
        		maxCount++;
        	}
        }
        
        answer = new int[maxCount];
        int idx = 0;
        for(int i=0;i<correct.length;i++) {		//�ִ� ������ ���ϱ�
        	if(correct[i] == max) {
        		answer[idx] = i + 1;
        		idx++;
        	}
        }
        
        for(int i=0;i<answer.length;i++)		//���� ���
        	System.out.println(answer[i]);
        
        
        return answer;
    }
}
