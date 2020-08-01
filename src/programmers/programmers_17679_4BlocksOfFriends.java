package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object a) {		//Set �ߺ� ���θ� ���� �Լ�
		Pair obj = (Pair) a;
		return (obj.x == this.x && obj.y == this.y);
	}
	
	@Override
	public int hashCode() {			//Set �ߺ� ���θ� ���� �Լ�
		return (String.valueOf(x)+String.valueOf(y)).hashCode();
	}
}

public class programmers_17679_4BlocksOfFriends {

	public static void main(String[] args) {
		String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		solution(4, 5, board1);
		//(output) 14
		
		String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		solution(6, 6, board2);
		//(output) 15
	}
	
    static public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean remove = true;
        char[][] charBoard = new char[m][n];
        
        for(int i=0;i<m;i++)			//board - String > char�迭
        	for(int j=0;j<n;j++)
        		charBoard[i][j] = board[i].charAt(j);
        
        while(remove) {			//������ ����� ���������� ����
        	Set<Pair> removePair = new HashSet<Pair>();
        	removePair = findRemove(charBoard);       	//������ 4��� ã��
        	
        	answer += removePair.size();		//answer += set ����
        	if(removePair.size() == 0)			//������ ��� ����
        		break;
        	
        	removeBlocks(charBoard, removePair);	//4 ��� ���� & ��� ������
        }
        
        System.out.println(answer);
        return answer;
    }

    //������ 4��� ã�� �Լ�
    static public Set<Pair> findRemove(char[][] charBoard) {
    	Set<Pair> res = new HashSet<Pair>();
    	
    	for(int i=0;i<charBoard.length - 1;i++) {		//(0, 0) ~ (m-1, n-1) Ž��
    		for(int j=0;j<charBoard[i].length - 1;j++) {
    			char now = charBoard[i][j];
    			if(now == charBoard[i][j+1] && now == charBoard[i+1][j] && now == charBoard[i+1][j+1]) { //4��� OK
    				if(now != '0') {
	    				res.add(new Pair(i, j));
	    				res.add(new Pair(i, j+1));
	    				res.add(new Pair(i+1, j));
	    				res.add(new Pair(i+1, j+1));
    				}
    			}
    		}
    	}
    	
    	return res;
    }
    
    //4��� ���� & ��� ������ �Լ�
    static public void removeBlocks(char[][] charBoard, Set<Pair> removePair) {
    	Iterator<Pair> it = removePair.iterator();		//4��� ����
    	while(it.hasNext()) {
    		Pair now = it.next();
    		charBoard[now.x][now.y] = '0';
    	}
    	
    	for(int j=0;j<charBoard[0].length;j++) {		//��� ������
    		List<Character> blocks = new ArrayList<Character>();
    		
    		for(int i=charBoard.length-1;i>=0;i--) {		//'0'�� �ƴ� ��� ���
    			if(charBoard[i][j] != '0')
    				blocks.add(charBoard[i][j]);
    		}
    		
    		int idx = 0;
    		for(int i=charBoard.length-1;i>=0;i--) {
    			if(idx >= blocks.size()) {			//������ '0'���� ä���
    				charBoard[i][j] = '0';
    			} else {
	    			charBoard[i][j] = blocks.get(idx);	//'0'�� �ƴ� ��� �ٴڿ������� ����
	    			idx++;
    			}
    		}
    	}
    }
    
    static public void print(char[][] charBoard) {		//print
    	for(int i=0;i<charBoard.length;i++) {
    		for(int j=0;j<charBoard[i].length;j++) {
    			System.out.print(charBoard[i][j] + " ");
    		}System.out.println();
    	}System.out.println();
    }
}
