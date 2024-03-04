package myy803.diplomas_mgt_app_skeleton.model;

import javax.persistence.*;

@Entity
@Table(name = "thesis")
public class Thesis {
	
	@Column (name = "title")
	private String title;
	@Column (name = "objectives")
	private String objectives;
	@ManyToOne
	@JoinColumn(name = "professor_id",referencedColumnName = "professor_id")
	private Professor supervisor;
	@ManyToOne
	@JoinColumn(name="subject_id",referencedColumnName = "subject_id") // ena subject exei polla apps
	private Subject subject;

	@ManyToOne
	@JoinColumn(name="student_id",referencedColumnName = "student_id") //1 pros 1
	private Student student;
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "thesis_id",unique = true)
	private int thesis_id;

	@Column (name = "grade")
	private float grade;

	public Thesis(String title, String objectives, Professor supervisor, int thesis_id, Subject subject,Student student) {
		this.title = title;
		this.objectives = objectives;
		this.supervisor = supervisor;
		this.thesis_id = thesis_id;
		this.subject = subject;
		this.student = student;
	}

	public Thesis() {}

	public Thesis(Subject subject,Student student) {
		this.subject = subject;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public Professor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Professor supervisor) {
		this.supervisor = supervisor;
	}

	public int getThesis_id() {
		return thesis_id;
	}

	public void setThesis_id(int thesis_id) {
		this.thesis_id = thesis_id;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
}
