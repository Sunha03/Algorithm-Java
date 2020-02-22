package baekjun;

import java.util.Scanner;
import javafx.util.Pair;

public class baek_14503_RobotVacuum {
	static int N, M, r, c, d;

	public static void main(String[] args) {
		int answer = 1;
		
		Scanner sc = new Scanner(System.in);		//input
		N = sc.nextInt();	M = sc.nextInt();
		r = sc.nextInt();	c = sc.nextInt();	d = sc.nextInt();

		int[][] map = new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				map[i][j] = sc.nextInt();
		
		while(!allClean(map, r, c)) {
			boolean clean = false;
			int tx, ty;
			int[] resTarget = new int[3];

			map[r][c] = 3;				//û��
			for(int i=0;i<4;i++) {
				resTarget = targetChange(r, c, d);		//Ÿ�� ��ǥ & ����
				tx = resTarget[0]; ty = resTarget[1];	d = resTarget[2];

				if(map[tx][ty] == 0) {		//û�� X (2-a)
					map[tx][ty] = 3;
					answer++;
					r = tx;		c = ty;
					clean = true;
					break;
				}
			}
			
			if(!clean) {
				int[] backTarget = back(r, c, d);	//���� ��ǥ
				int bx = backTarget[0];
				int by = backTarget[1];

				if(map[bx][by] == 1) {				//���� �Ұ�
					break;
				} else if(map[bx][by] == 3) {		//���� �̵�(�̹� û��)
					r = bx;			c = by;
				}
			}
			
			/*print(map);
			System.out.println(answer);*/
		}
		System.out.println(answer);					//���� ���
	}

	//x, y ��ǥ�� ���� ������ ���� üũ
	public static boolean inRange(int x, int y) {
		if(x >= 0 && y >= 0 && x < N && y < M)
			return true;
		else
			return false;
	}

	//û���� ��ǥ ���ϱ� & ���� ��ȯ
	public static int[] targetChange(int x, int y, int dir) {
		int[] target = new int[3];
		target[0] = x;
		target[1] = y;

		if(dir == 0) {
			if(inRange(x, y - 1))
				target[1] -= 1;
		} else if(dir == 1) {
			if(inRange(x - 1, y))
				target[0] -= 1;
		} else if(dir == 2) {
			if(inRange(x, y + 1))
				target[1] += 1;
		} else if(dir == 3) {
			if(inRange(x + 1, y))
				target[0] += 1;
		}

		target[2] = (dir + 3) % 4;

		return target;
	}
	
	//���� ��ǥ ���ϱ�
	public static int[] back(int x, int y, int dir) {
		int[] target = new int[2];
		target[0] = x;
		target[1] = y;

		if(dir == 0) {
			if(inRange(x + 1, y))
				target[0] += 1;
		} else if(dir == 1) {
			if(inRange(x, y - 1))
				target[1] -= 1;
		} else if(dir == 2) {
			if(inRange(x - 1, y))
				target[0] -= 1;
		} else if(dir == 3) {
			if(inRange(x, y + 1))
				target[1] += 1;
		}
		
		return target;
	}

	//��� ���� û�Ұ� �������� ���� üũ
	public static boolean allClean(int[][] map, int x, int y) {
		boolean res = true;

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0)
					res = false;
			}
		}

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(inRange(nx, ny)) {
				if(map[nx][ny] == 0)
					res = false;
			}
		}
		
		return res;
	}
	
	/*public static void print(int[][] map) {			//map ���
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}*/
}

/* 
(input)
3 3
1 1 0
1 1 1
1 0 1
1 1 1
(output)
1

(input)
11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
(output)
57
 */