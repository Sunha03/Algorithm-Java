package programmers;

public class programmers_12952_NQueen {
	public static int ANS = 0;

	public static void main(String[] args) {
		solution(4);
		//(Outputs) 2
	}

    public static int solution(int n) {
        int answer = 0;
        int[][] map = new int[n][n];
        
        placeQueen(map, 0);
        
        answer = ANS;
        System.out.println(answer);
        
        return answer;
    }
    
    public static void placeQueen(int[][] map, int x) {	// x�࿡ queen ��ġ
    	//printMap(map);
    	
		for (int j = 0; j < map.length; j++) {
			if (map[x][j] == 0) {
				int[][] copy = copyMap(map);
				copy[x][j] = 8;					// queen ��ġ
				checkCondition(copy, x, j);		// ���� queen�� �� �� ���� ��ġ ǥ��
				
				if (x < copy.length - 1) {
					placeQueen(copy, x+1);		// ���� �࿡ queen ��ġ
				} else {
					printMap(copy);
					ANS++;
				}
			}
		}
		
		return;
    }
    
    public static void checkCondition(int[][] map, int queenX, int queenY) {
		for (int j = 0; j < map.length; j++) {		// ���� Ȯ��
			if (j == queenY) {
				continue;
			} else if (map[queenX][j] == 0) {
				map[queenX][j] = -1;
			}
		}
		
		int x = queenX;
		int y = queenY;
		int move = 1;
		while(x - move >= 0) {
			if(inRange(x - move, y, map.length, map.length) && map[x - move][y] == 0) {		// ���� ����
				map[x - move][y] = -1;
			}
			if(inRange(x - move, y - move, map.length, map.length) && map[x - move][y - move] == 0) {	// ���� + ���� �밢��
				map[x - move][y - move] = -1;
			}
			if(inRange(x - move, y + move, map.length, map.length) && map[x - move][y + move] == 0) {	// ���� + ������ �밢��
				map[x - move][y + move] = -1;
			}
			move++;
		}
		
		x = queenX;
		y = queenY;
		move = 1;
		while(x + move < map.length) {
			if(inRange(x + move, y, map.length, map.length) && map[x + move][y] == 0) {		// �Ʒ��� ����
				map[x + move][y] = -1;
			}
			if(inRange(x + move, y - move, map.length, map.length) && map[x + move][y - move] == 0) {	// �Ʒ��� + ���� �밢��
				map[x + move][y - move] = -1;
			}
			if(inRange(x + move, y + move, map.length, map.length) && map[x + move][y + move] == 0) {	// �Ʒ��� + ������ �밢��
				map[x + move][y + move] = -1;
			}
			move++;
		}
    }

    public static int[][] copyMap(int[][] map) {
    	int[][] copy = new int[map.length][map[0].length];
    	
    	for (int i = 0; i < map.length; i++) {
    		for (int j = 0; j < map[i].length; j++) {
    			copy[i][j] = map[i][j];
    		}
    	}
    	
    	return copy;
    }

    public static boolean inRange(int x, int y, int maxX, int maxY) {
    	if (x >= 0 && y >= 0 && x < maxX && y < maxY) {
    		return true;
    	}
    	
    	return false;
    }
    
    public static void printMap(int[][] map) {
    	for (int i = 0; i < map.length; i++) {
    		for (int j = 0; j < map[i].length; j++) {
    			System.out.print(map[i][j] + "\t");
    		}System.out.println();
    	}System.out.println();
    }
}
