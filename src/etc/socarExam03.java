package etc;

import java.util.List;
import java.util.ArrayList;

public class socarExam03 {
	static int maxAns;

	public static void main(String[] args) {
		int[][] delivery1 = {{1, 5}, {8, 3}, {4, 2}, {2, 3}, {3, 1}, {3, 2}, {4, 2}, {5, 2}, {4, 1}};
		solution(3, delivery1);
		//(output) 17
		
		int[][] delivery2 = {{1, 10}, {8, 1}, {8, 1}, {3, 100}, {8, 1}, {8, 1}, {8, 1}, {8, 1}, {8, 1}, {8, 1}, {8, 1}, {8, 1}, {9, 100}, {8, 1}, {8, 1}, {8, 1}};
		solution(4, delivery2);
		//(output) 217
	}

	public static int solution(int r, int[][] delivery) {
		maxAns = -1;
		int answer = 0;
		int maxTip = 0;
		int[][] visit = new int[r][r];
		
		ArrayList<ArrayList<Integer>> visited = new ArrayList<ArrayList<Integer>>();
		
		visit[0][0] = 1;
		move(delivery, visit, visited, delivery[0][1], 0, r, 0, 0);
		
		answer = maxAns;
		System.out.println(answer);
		return answer;
	}
	
	public static void move(int[][] delivery, int[][] visit, ArrayList<ArrayList<Integer>> visited, int tip, int time, int r, int x, int y) {
		int maxTip = maxTips(delivery, visit, r, tip, time);
		//System.out.println("time : " + time + ", tip : " + tip + ", max : " + maxTip);
		
		ArrayList<Integer> now = new ArrayList<>();		//��� �̷� ����
		now.add(x);			now.add(y);
		visited.add(now);
		//printVisited(visited);
		
		if(allVisit(visit)) {	//��ü ��ǥ Ž�� �Ϸ�
			if(maxAns < tip)
				maxAns = tip;
			//System.out.println("The End1! / ���� tip : " + tip + ", max : " + maxTip);
			//printVisited(visited);
			return;
		} else if(!hasTips(delivery, visit, r, time)) {	//�� �̻� ���� �� �ִ� �� ����
			if(maxAns < tip)
				maxAns = tip;
			//System.out.println("The End2! / ���� tip : " + tip + ", max : " + maxTip);
			//printVisited(visited);
			return;
		} else if(maxTip == tip) {		//���� �ִ�� ���� �� �ִ� �� = ������� ���� ��
			if(maxAns < tip)
				maxAns = tip;
			//System.out.println("The End3! / ���� tip : " + tip + ", max : " + maxTip);
			//printVisited(visited);
			return;
		} else if(maxAns > maxTip) {		//�ִ� �� > ���� �ִ�� ���� �� �ִ� �� (back)
			//System.out.println("back / ���� tip : " + tip + ", max : " + maxTip);
			//printVisited(visited);
			return;
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(rangeCheck(r, nx, ny)) {
				if(visit[nx][ny] == 0) {
					visit[nx][ny] = 1;
					if(time <= delivery[nx*r+ny][0])	//�� ȹ�� ����
						move(delivery, visit, visited, tip+delivery[nx*r+ny][1], time+1, r, nx, ny);
					else		//��޽ð� �ʰ��� �� ȹ�� �Ұ���
						move(delivery, visit, visited, tip, time+1, r, nx, ny);
					visit[nx][ny] = 0;
					visited.remove(visited.size() - 1);
				} else if(visit[nx][ny] == 1) {		//�̹� �湮 -> pass
					move(delivery, visit, visited, tip, time+1, r, nx, ny);
					visited.remove(visited.size() - 1);
				}
			}
		}
	}
	
	public static boolean rangeCheck(int r, int x, int y) {	//��ǥ ������ üũ �Լ�
		if(x >= 0 && y >= 0 && x < r && y < r)
			return true;
		else
			return false;
	}
	
	public static boolean allVisit(int[][] visit) {		//��ü �湮���� �Լ�
		for(int i=0;i<visit.length;i++)
			for(int j=0;j<visit[i].length;j++)
				if(visit[i][j] == 0)
					return false;
		return true;
	}
	
	public static boolean hasTips(int[][] delivery, int[][] visit, int r, int time) {	//���� �� �ִ� �� ���� �Լ�
		for(int i=0;i<r;i++)
			for(int j=0;j<r;j++)
				if(visit[i][j] == 0 && time <= delivery[i*r+j][0])
					return true;
		return false;
	}
	
	public static int maxTips(int[][] delivery, int[][] visit, int r, int tip, int time) {	//���� �� �ִ� �ִ� �� ���ϱ�
		int maxTip = tip;
		for(int i=0;i<r;i++)
			for(int j=0;j<r;j++)
				if(visit[i][j] == 0 && time <= delivery[i*r+j][0])
					maxTip += delivery[i*r+j][1];
		return maxTip;
	}
	
	public static void printVisited(ArrayList<ArrayList<Integer>> visited) {		//�湮�ߴ� ��ǥ ���
		System.out.println("����ߴ� ��ǥ : ");
		for(int i=0;i<visited.size();i++) {
			System.out.print("{" + visited.get(i).get(0) + ", " + visited.get(i).get(1) + "}  ");
		}System.out.println("\n");
	}
}
