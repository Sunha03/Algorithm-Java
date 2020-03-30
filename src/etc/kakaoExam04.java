package etc;

import java.util.ArrayList;
import java.util.List;

public class kakaoExam04 {
	public static void main(String[] args) {
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		solution(k, room_number);
		//(output) [1,3,4,2,5,6]
	}
	
	public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        long[] room = new long[(int)k + 1];
        //List<Integer> room = new ArrayList<Integer>((int)k);
        
        for(int i=0;i<room_number.length;i++) {
        	long pick = room_number[i] - 1;
        	if(room[(int)pick] == 0) {		//���ϴ� �� == �� ��
        		room[(int)pick] = 1;		//�� ä���
        		answer[i] = pick + 1;		//���信 ���ȣ ����
        	} else {
        		for(int j=(int)pick+1;j<room.length;j++) {		//���ϴ� �� ������ �� �� ã��
        			if(room[j] == 0) {
        				room[j] = 1;
                		answer[i] = j + 1;
        				break;
        			}
        		}
        	}
        }
        
        for(int i=0;i<room.length;i++) {
        	System.out.print(room[i] + "\t");
        }System.out.println();
        
        for(int i=0;i<room_number.length;i++) {
        	System.out.print(answer[i] + "\t");
        }System.out.println();
        
        return answer;
    }
}
