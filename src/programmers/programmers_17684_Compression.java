package programmers;

import java.util.*;

public class programmers_17684_Compression {

	public static void main(String[] args) {
		String msg1 = "KAKAO";
		solution(msg1);
		//[11, 1, 27, 15]
		
		String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
		solution(msg2);
		//[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
		
		String msg3 = "ABABABABABABABAB";
		solution(msg3);
		//[1, 2, 27, 29, 28, 31, 30]
	}
	
	static public int[] solution(String msg) {
        int[] answer;
        List<String> dic = new ArrayList<String>();
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<26;i++)			//������ ���ĺ� A~Z �ֱ�
        	dic.add((char)(65+i) + "");
        
        while(msg.length() > 0) {
        	String w = findW(dic, msg);		//������ �ִ� ���� �� ���ڿ� w ã��
        	for(int i=0;i<dic.size();i++)
        		if(w.equals(dic.get(i)))
        			ans.add(i+1);
        	
        	String wc;
        	if(w.length() < msg.length())
        		wc = w + msg.charAt(w.length());
        	else
        		wc = "";
        	
        	for(int i=0;i<dic.size();i++)		//���ڿ� w+c�� ������ ������ �߱�
        		if(w.equals(dic.get(i)))
        			dic.add(wc);
        	
        	msg = msg.substring(w.length(), msg.length());		//���ڿ� msg ������Ʈ
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        	answer[i] = ans.get(i);

        /*for(int i=0;i<answer.length;i++) {			//���� ���
        	System.out.print(answer[i] + "\t");
        }System.out.println();*/
        
        return answer;
    }
	
	static public String findW(List<String> dic, String subMsg) {		//������ �ִ� ���� �� ���ڿ� w ã��
		String w = subMsg;
		
		for(int i=0;i<subMsg.length();i++) {
			for(int j=0;j<dic.size();j++) {
				if(w.equals(dic.get(j)))		//������ �ִ� w ã����
					return w;
			}

			w = w.substring(0, w.length() - 1);
		}
		
		return w;
	}

}
