package myy803.diplomas_mgt_app_skeleton.model;

import javax.persistence.*;


@Entity
@Table(name = "application")
public class Application {

	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id") // 1 pros 1
	private Student student;

	@OneToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id") // ena subject exei polla apps
	private Subject subject;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id", unique = true)
	private int application_id;

	@ManyToOne
	@JoinColumn(name = "professor_id", referencedColumnName = "professor_id")
	private Professor professor;
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Application(Student student, Subject subject, int application_id,Professor professor) {
		this.student = student;
		this.subject = subject;
		this.application_id = application_id;
		this.professor = professor;
	}
	
	public Application() {}

	public Application(Student student, Subject subject) {
		this.student = student;
		this.subject = subject;
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


	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}

	
	
	
	
	
}
