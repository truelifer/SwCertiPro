package exam.h2220;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class UserSolution {
	
	class Student implements Comparable<Student>{
		int id;
		int grade;
		int gender;
		int score;
		
		public Student(int mId, int mGrade, int mGender, int mScore) {
			this.id = mId;
			this.grade = mGrade;
			this.gender = mGender;
			this.score = mScore;
		}

		@Override
		public int compareTo(Student o) {
			if(this.score == o.score) {
				return this.id - o.id;
			}
			
			return this.score - o.score;
		}
	}
	
	
	Map<Integer, Student> map = new HashMap<>();
	TreeSet<Student>[][] set = new TreeSet[3][2];
	
	public void init() {
		map.clear();
		
		for(int i=0;  i < 3; i++) {
			for (int j=0; j < 2; j++) {
				set[i][j] = new TreeSet<Student>();
			}
		}
	}

	public int add(int mId, int mGrade, char mGender[], int mScore) {
		int gender = mGender[0] == 'm' ? 0 : 1;
		Student s = new Student(mId, mGrade-1, gender, mScore);
		
		map.put(mId, s);
		set[s.grade][s.gender].add(s);
		
		return set[s.grade][s.gender].last().id;
	}

	public int remove(int mId) {
		Student s = map.get(mId);
		if(s == null) {
			return 0;
		}
		
		map.remove(mId);
		set[s.grade][s.gender].remove(s);
		
		if(set[s.grade][s.gender].isEmpty()) {
			return 0;
		}
		
		return set[s.grade][s.gender].first().id;
	}

	public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
		Student target = new Student(-1, -1, -1, mScore);
		Student minNode = null;
		
		for(int i=0; i < mGradeCnt; i++) {
			for(int j=0; j < mGenderCnt; j++) {
				int grade = mGrade[i] -1;
				int gender = mGender[j][0] == 'm' ? 0 : 1;
				Student node = set[grade][gender].ceiling(target);
				if(node == null) {
					continue;
				}
				
				if(minNode == null || node.score < minNode.score || ((node.score == minNode.score) && (node.id < minNode.id))) {
					minNode = node;
				}
			}
		}
		
		if(minNode == null) {
			return 0;
		}
		
		return minNode.id;
	}
}