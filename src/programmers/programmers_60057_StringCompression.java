package programmers;

import java.util.ArrayList;
import java.util.List;

public class programmers_60057_StringCompression {

	public static void main(String[] args) {
		solution("aabbaccc");
		//(output) 7
		
		solution("ababcdcdababcdcd");
		//(output) 9
		
		solution("abcabcdede");
		//(output) 8
		
		solution("abcabcabcabcdededededede");
		//(output) 14
		
		solution("xababcdcdababcdcd");
		//(output) 17
	}

	static public int solution(String s) {
		int answer = 1001;
		
		for(int i=1;i<=s.length();i++) {		//������ ���ڿ� ����(1 ~ s.length())
			List<String> splitStr = new ArrayList<String>();

			int start = 0;
			while(true) {
				if(start + i > s.length()) {
					splitStr.add(s.substring(start, s.length()));
					break;
				} else {
					splitStr.add(s.substring(start, start + i));
				}
				
				start += i;
			}
			
			/*for(int j=0;j<splitStr.size();j++) {			//print
				System.out.print(splitStr.get(j) + "  ");
			}System.out.println();*/
			
			int count = 1;
			int size = splitStr.size();
			String str = "";
			String ansStr = "";
			for(int j=0;j<size-1;j++) {						//���ڿ� ����
				str = splitStr.get(j);
				
				if(splitStr.get(j).equals(splitStr.get(j+1))) {
					count++;
					
					if(j == size - 2)		//������ ���ڿ� �߰�
						ansStr += String.valueOf(count) + str;
				} else {
					if(count > 1)
						ansStr += String.valueOf(count) + str;
					else
						ansStr += str;
					count = 1;
					
					if(j == size - 2)		//������ ���ڿ� �߰�
						ansStr += splitStr.get(size-1);
				}
			}
			//System.out.println("ANSWER : " + ansStr);		//print(������ ���ڿ�)
			
			if(ansStr.length() < answer)		//���� ���ڿ� �ּҰ� ������Ʈ
				answer = ansStr.length();
		}
		
		System.out.println(answer);
		return answer;
	}
}
