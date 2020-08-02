package programmers;

import java.util.ArrayList;
import java.util.List;

public class programmers_16787_NNotation {

	public static void main(String[] args) {
		solution(2, 4, 2, 1);
		//(output) 0111
		
		solution(16, 16, 2, 1);
		//(output) 02468ACE11111111
		
		solution(16, 16, 2, 2);
		//(output) 13579BDF01234567
	}

	static public String solution(int n, int t, int m, int p) {		//n:����, t:�̸� ���� ���� ����, m:���� ���� �ο�, p:Ʃ�� ����
        String answer = "";
        String nNotation = "0";
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    	int num = 1;
        while(true) {
        	int res;
        	int temp = num;
        	List<Character> nNum = new ArrayList<Character>();
        	
        	while(temp != 0) {		//10���� > N ���� ��ȯ
        		res = temp % n;
        		temp /= n;
        		nNum.add(numbers[res]);
        	}

        	for(int i=nNum.size()-1;i>=0;i--)
        		nNotation += nNum.get(i);
        	
        	num++;
        	if(nNotation.length() >= t * m)
        		break;
        }
        System.out.println(nNotation);		//print(N���� ��ü ����)
        
        for(int i=0;i<t;i++)			//Ʃ�갡 ���ؾ��ϴ� ����
        	answer += nNotation.charAt((i*m)+(p-1));
        
        System.out.println(answer);
        return answer;
    }
}
