package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javafx.util.Pair;

public class baek_2667_ComplexNumbering_BFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] strMap = new String[N];
		int[][] map = new int[N][N];
		List<Integer> ans = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++)				//input
			strMap[i] = sc.next();
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j] = (int)(strMap[i].charAt(j) - '0');
		
		int groupNum = 0;
		for(int i=0;i<N;i++) {				//���� ã��
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					int count = 0;
					groupNum++;				//���� �� + 1
					Queue<Pair<Integer, Integer>> group = new LinkedList<Pair<Integer, Integer>>();
					
					map[i][j] = -1;
					group.add(new Pair<>(i, j));
					while(!group.isEmpty()) {
						int[] dx = {-1, 0, 1, 0};
						int[] dy = {0, -1, 0, 1};
						Pair<Integer, Integer> now = group.element();	//���� ��ǥ
						group.remove();									//���� ��ǥ ����
						count++;							//�̹� ���� �� �� + 1
						
						for(int k=0;k<4;k++) {				//4�������� �̵�
							int nx = now.getKey() + dx[k];
							int ny = now.getValue() + dy[k];
							if(nx >=0 && ny >= 0 && nx < N && ny < N) {
								if(map[nx][ny] == 1) {		//���� ������
									map[nx][ny] = -1;		//�湮���� üũ
									group.add(new Pair<>(nx, ny));
								}
							}
						}
					}
					ans.add(count);
				}
			}
		}
				
		Collections.sort(ans);				//������ �� �� ����
		
		/*for(int i=0;i<N;i++) {			//���� ���
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}*/
		
		System.out.println(groupNum);		//���� ���
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}

	}
}

/*
(input)
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

(output)
3
7
8
9
 */
