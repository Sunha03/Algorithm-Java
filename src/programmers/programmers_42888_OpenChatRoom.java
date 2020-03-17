package programmers;

import java.util.*;

public class programmers_42888_OpenChatRoom {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", 
							"Enter uid4567 Prodo",
							"Leave uid1234",
							"Enter uid1234 Prodo",
							"Change uid4567 Ryan"};
		/* (output)
		 * ["Prodo���� ���Խ��ϴ�.",
		 * "Ryan���� ���Խ��ϴ�.",
		 * "Prodo���� �������ϴ�.",
		 * "Prodo���� ���Խ��ϴ�."] */
		
		solution(record);
	}

	public static String[] solution(String[] record) {
        int size = 0, idx = 0;
        String[] answer;
        Map<String, String> nickList = new HashMap<String, String>();	//<���̵�, �г���>
        String[][] strList = new String[record.length][];				//Enter/uid1234/Muzi

        for(int i=0;i<record.length;i++) {
            String[] split = record[i].split(" ");	//���⸦ �������� ���ڿ� �ڸ���
            strList[i] = split;

            if(split[0].equals("Enter")) {
                size++;
                nickList.put(split[1], split[2]);	//�г���  ������Ʈ
            } else if(split[0].equals("Leave")) {
                size++;
            } else if(split[0].equals("Change")) {
                nickList.put(split[1], split[2]);
            }
        }

        answer = new String[size];

        for(int i=0;i<strList.length;i++) {
            String str = "";				//���� ���ڿ�
            String[] temp = strList[i];

            String nick = nickList.get(temp[1]);		//"(�г���)����"
            str = nick + "���� ";

            if(temp[0].equals("Enter")) {				//"���Խ��ϴ�."
                str = str + "���Խ��ϴ�.";
                answer[idx] = str;
                idx++;
            } else if(temp[0].equals("Leave")) {		//"�������ϴ�."
                str = str + "�������ϴ�.";
                answer[idx] = str;
                idx++;
            }
        }

        return answer;
    }
}
