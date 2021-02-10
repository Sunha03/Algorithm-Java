package programmers;

import java.util.Stack;

public class programmers_70129_RepeatBinaryConversion {

	public static void main(String[] args) {
		solution("110010101001");
		//(Outputs) {3, 8};
		
		solution("01110");
		//(Outputs) {3, 3};
		
		solution("1111111");
		//(Outputs) {4, 1};
	}

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int loopCnt = 0;
        
        while(!s.equals("1")) {
        	for(int i=0;i<s.length();i++) {		// 0 �����
        		if(s.charAt(i) == '0')
        			zeroCnt++;
        	}
    		s = s.replaceAll("0", "");
        	//System.out.println(zeroCnt + " ==== " + s);
        	
        	int sLength = s.length();	// 0 ������ ���ڿ��� ����
        	if(sLength > 1) {
	        	//s = binaryConv(sLength);	// ������ ���ڿ� ���̸� 2�������� ǥ�� (���� �Լ� ����)
        		s = Integer.toBinaryString(sLength);	// ������ ���ڿ� ���̸� 2�������� ǥ��(�����Լ� toBinaryString())
	        	//System.out.println(loopCnt + " -> " + s);
        	}
        	loopCnt++;
        }
        
        answer[0] = loopCnt;
        answer[1] = zeroCnt;
        System.out.println(answer[0] + ", " + answer[1]);
        
        return answer;
    }
    
    public static String binaryConv(int sLength) {		// 10���� -> 2����
    	String res = "";
    	Stack<Integer> binary = new Stack<>();
    	
    	if(sLength == 1)
    		return "1";
    	
    	while(sLength >= 2) {
    		binary.add(sLength%2);
    		sLength /= 2;
    	}
    	binary.add(sLength);
    	
    	int size = binary.size();
    	for(int i=0;i<size;i++) {
    		int n = binary.pop();
    		res += String.valueOf(n);
    	}
    	
    	return res;
    }
}
