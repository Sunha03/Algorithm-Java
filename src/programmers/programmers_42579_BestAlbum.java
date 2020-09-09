package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class programmers_42579_BestAlbum {

	public static void main(String[] args) {
		String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays1 = {500, 600, 150, 800, 2500};
		//solution(genres1, plays1);
		//(output) {4, 1, 3, 0}

		String[] genres2 = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays2 = {500, 600, 501, 800, 900};
		solution(genres2, plays2);
		//(output) {3, 2, 4, 1}
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[4];
        ArrayList<String> mostGenre = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Map<String, Integer> sortGenre = new HashMap<>();
        
        for(int i=0;i<genres.length;i++) {		//�帣 ���� ���� <�帣, �� ���Ƚ��>
        	if(!sortGenre.containsKey(genres[i])) {		//���ο� �帣
        		sortGenre.put(genres[i], plays[i]);
        	} else {		//������ �����ϴ� �帣
        		int beforePlay = sortGenre.get(genres[i]);
        		sortGenre.put(genres[i], beforePlay + plays[i]);
        	}
        }
        
        List<String> keySetList = new ArrayList<>(sortGenre.keySet());		//�帣 ���Ƚ���� ����
		Collections.sort(keySetList, (o1, o2) -> (sortGenre.get(o2).compareTo(sortGenre.get(o1))));
/*		for(String key : keySetList) {		//print
			System.out.println("key : " + key + " / " + "value : " + sortGenre.get(key));
		}
*/        
        
        for(String key : keySetList) {
            Map<Integer, Integer> mostPlayed = new HashMap<>();
            
	        for(int j=0;j<genres.length;j++)		//�뷡���� <������ȣ, ���Ƚ��> ����
	        	if(genres[j].equals(key))
	        		mostPlayed.put(j, plays[j]);
	        
	        List<Integer> keySetList2 = new ArrayList<>(mostPlayed.keySet());		//�뷡 ���Ƚ���� ����
			Collections.sort(keySetList2, (o1, o2) -> (mostPlayed.get(o2).compareTo(mostPlayed.get(o1))));
			
			for(int j=0;j<2;j++) {		//����Ʈ �ٹ��� �� �뷡 ����
				ans.add(keySetList2.get(j));
				if(keySetList2.size() == 1)		//�帣�� ���� ���� 1���� ��
					break;
			}
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        	answer[i] = ans.get(i);
        
        for(int i=0;i<answer.length;i++)
        	System.out.print(answer[i] + " ");
        System.out.println();
        return answer;
    }

}
