package my.spring;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ExamManager {
	
	private List<Exam> exams;
		
	@Autowired	
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public ExamManager() {
		// TODO Auto-generated constructor stub
	}
	
	public ExamManager(List<Exam> exams) {
		this.exams = exams;
	}
	
	public void print()
	{
		for(Exam e : exams)
			System.out.printf("total : %d\n", e.total());
	}
}
