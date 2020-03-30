package etc;

import java.util.*;

public class kakaoExam05 {
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		solution(stones, k);
		//(output) 3
	}
	
	public static int solution(int[] stones, int k) {
        int answer = 0;
        boolean end = false;
        
        while(!end) {
        	int jump = 0;
        	for(int i=0;i<stones.length;i++) {
        		if(stones[i] > 0) {		//¡�˴ٸ� ��� ����
        			if(jump == k) {
        				end = true;
        				break;
        			}
        			
        			stones[i]--;
        			jump = 0;
        		} else {
        			if(jump < k) {		//¡�˴ٸ� ��� �Ұ��� & ���� ����
        				jump++;
        			} else {			//���� �Ұ���
        				end = true;
        				break;
        			}
        		}
        	}
        	
        	for(int i=0;i<stones.length;i++) {
        		System.out.print(stones[i] + "\t");
        	}System.out.println();
        	
        	if(!end)
        		answer++;
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
