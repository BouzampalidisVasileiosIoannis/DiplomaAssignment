package myy803.diplomas_mgt_app_skeleton.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Column (name = "fullName")
	private String fullName;
	@Column (name = "yearOfStudies")
	private int yearOfStudies;
	@Column (name = "currentAverageGrade")
	private float currentAverageGrade;
	@Column (name = "numberOfRemainingCoursesForGraduation")
	private int numberOfRemainingCoursesForGraduation;
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "student_id", unique = true)
	private int student_id;

	@Column(name="username")
	private String username;


	public Student(String fullName, int yearOfStudies , float currentAverageGrade, int numberOfRemainingCoursesForGraduation,
				   int student_id, String username)
	{
		this.fullName = fullName;
		this.yearOfStudies = yearOfStudies;
		this.currentAverageGrade = currentAverageGrade;
		this.numberOfRemainingCoursesForGraduation = numberOfRemainingCoursesForGraduation;
		this.student_id = student_id;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Student(String username) {
		this.username = username;
	}

	public Student(){}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfStudies() {
		return yearOfStudies;
	}

	public void setYearOfStudies(int yearOfStudies) {
		this.yearOfStudies = yearOfStudies;
	}

	public float getCurrentAverageGrade() {
		return currentAverageGrade;
	}

	public void setCurrentAverageGrade(float currentAverageGrade) {
		this.currentAverageGrade = currentAverageGrade;
	}

	public int getNumberOfRemainingCoursesForGraduation() {
		return numberOfRemainingCoursesForGraduation;
	}

	public void setNumberOfRemainingCoursesForGraduation(int numberOfRemainingCoursesForGraduation) {
		this.numberOfRemainingCoursesForGraduation = numberOfRemainingCoursesForGraduation;
	}


	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	

}
