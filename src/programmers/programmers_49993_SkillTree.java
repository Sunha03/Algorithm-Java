package programmers;

public class programmers_49993_SkillTree {

	public static void main(String[] args) {
		programmers_49993_SkillTree m = new programmers_49993_SkillTree();
		
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		//(output) 2
		
		m.solution(skill, skill_trees);
	}

	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[][] match = new int[skill_trees.length][skill.length()];
        
        for(int i=0;i<skill_trees.length;i++) {
        	boolean check = true;
        	int skill_num = 0;
        	
        	for(int j=0;j<skill_trees[i].length();j++) {	//��ųƮ�� �Է� �迭��ŭ
        		for(int k=0;k<skill.length();k++) {				//��ųƮ�� ������ŭ
        			if(skill_trees[i].charAt(j) == skill.charAt(k)) {			//���� char ã��
        				if(skill.indexOf(skill.charAt(k)) == skill_num) {		//�� ��ġ�� skill_num�̸�(�� ����������)
        					skill_num++;			//���� ���� ����
        				} else {												//�Ұ����� ��ų Ʈ��
            				check = false;
            				break;
            			}
        			}
        		}
        	}
        	
        	if(check)		//�Ұ����� ��ųƮ���� �ƴϸ� ���� + 1
        		answer++;
        }
        
        
        System.out.println(answer);
        
        return answer;
    }
}
