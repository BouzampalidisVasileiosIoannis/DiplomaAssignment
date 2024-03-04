package myy803.diplomas_mgt_app_skeleton.model;

import javax.persistence.*;


@Entity
@Table(name="professor")
public class Professor {

	@Column(name = "threshold1")
	private float threshold1 = (float)0.0;

	@Column(name = "threshold2")
	private int threshold2=0;


	@Column(name = "username")
	private String username;


	@Column(name = "fullName")
	private String fullName;

	@Column(name = "specialty")
	private String specialty;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professor_id", unique = true)
	private int professor_id;
	
	public Professor(String fullName,String specialty,
			int professor_id,String username) {
		this.fullName = fullName;
		this.specialty = specialty;
		this.professor_id = professor_id;
		this.username = username;
		
	}
	public Professor() {}

	public Professor(String username) {

		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getThreshold1() {
		return threshold1;
	}
	public void setThreshold1(float threshold1) {
		this.threshold1 = threshold1;
	}
	public int getThreshold2() {
		return threshold2;
	}
	public void setThreshold2(int threshold2) {
		this.threshold2 = threshold2;
	}

}
