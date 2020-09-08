package programmers;

public class programmers_12904_TheLongestPalindrome {

	public static void main(String[] args) {
		solution("abcdcba");
		//(output) 7
		
		solution("abacde");
		//(output) 3
	}

	public static int solution(String s)
    {
        int answer = 0;

        for(int i=s.length();i>0;i--) {
        	for(int j=0;j<s.length()-i+1;j++) {
        		boolean same = true;
            	int subStringStart = j;
            	int subStringEnd = j+i-1;
            	int subStart1 = 0;		int subEnd1 = 0;
            	int subStart2 = 0;		int subEnd2 = 0;
            	

        		subStart1 = j;			subEnd1 = j+i/2-1;
        		subEnd2 = j+i-1;
            	if(i%2 == 0)	//���ڿ� ���� = ¦��
            		subStart2 = j+i/2;
            	else	//���ڿ� ���� = Ȧ��
            		subStart2 = j+i/2+1;
            	
//            	System.out.println(s.substring(j, j+i));
//            	System.out.println(s.substring(subStart1, subEnd1+1) + " / "
//            			+ s.substring(subStart2, subEnd2+1) + "\n");
        		
            	int idx = 0;
        		for(int k=subStart1;k<=subEnd1;k++) {		//���ڿ�/2 ���� == ���ڿ�/2 ����
        			if(s.charAt(k) != s.charAt(subEnd2-idx)) {
    					same = false;
    					break;
        			}
        			idx++;
        		}
            	
            	if(same) {		//�Ӹ���� �ִ�
            		answer = i;
            		break;
            	}
        	}
        	if(answer > 0)
        		break;
        }

        System.out.println(answer);
        return answer;
    }
	//substring ��� || �Ӹ���� �� �Լ� ���� => ȿ���� ��� �ȵ�
}
