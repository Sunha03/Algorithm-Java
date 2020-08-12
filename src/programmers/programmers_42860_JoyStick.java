package programmers;

public class programmers_42860_JoyStick {
	public static void main(String[] args) {
        solution("JEROEN");
        //(output) 56
        
        solution("JAN");
        //(output) 23
        //A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
    }
 
    static public int solution(String name) {
        int answer = 0;
        boolean hasZero = false;
        int updown[] = new int[name.length()];
        
        for(int i=0;i<name.length();i++) {			//���Ʒ� �̵� ī��Ʈ
            updown[i] = Math.abs('Z'-name.charAt(i)+1) < Math.abs('A'-name.charAt(i))
                    ? Math.abs('Z'-name.charAt(i)+1) : Math.abs('A'-name.charAt(i));
            answer += updown[i];
            //System.out.print(updown[i] + "   ");
        }
        
        int move = 0, start = -1;
        int cnt = 0;
        int max = -1, maxStart = -1;
        for(int i=0;i<name.length()-1;i++) {		//���� 'A' �ִ� ����, ���� ���� ���ϱ�
            if(name.charAt(i) == 'A') {
                if(start < 0)
                    start = i;
                cnt++;
                if(name.charAt(i+1) != 'A') {
                    if(cnt > max) {
                        max = cnt;
                        maxStart = start;
                    }
                    start = -1;
                    cnt = 0;
                }
            }
        }
        
        int left = maxStart > 0 ? maxStart : 0;			//�ִ� ���� 'A' ���� ����
        int right = name.length() - (maxStart + max);	//�ִ� ���� 'A' �� ����
        
        if(left == 0)			//A...AXXX ���
            move = right + 1;
        else if(right == 0)		//XXXA...A ���
            move = left - 1;
        else if(left < right)	//XXA...AXXX ���
            move = (left-1)*2 + right;
        else					//XXXA...AXX ���
            move = (right-1)*2 + left;
      
        if(move < name.length() - 1)	//��>�� >> ��>�� ���� ��ȯ
            answer += move;
        else							//��>�� �̵�
            answer += name.length() - 1;

        System.out.println(answer);
        return answer;
    }
}
