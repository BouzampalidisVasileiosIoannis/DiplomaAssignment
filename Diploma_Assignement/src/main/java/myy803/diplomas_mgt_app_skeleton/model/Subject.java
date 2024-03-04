package myy803.diplomas_mgt_app_skeleton.model;

import javax.persistence.*;


@Entity
@Table(name = "subject")
public class Subject {
	
	@Column (name = "title")
	private String title;
	@Column (name = "objectives")
	private String objectives;
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor supervisor;
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "subject_id", unique = true)
	private int subject_id;
	
	
	public Subject(String title, String objectives, Professor supervisor, int subject_id) {
		this.title = title;
		this.objectives = objectives;
		this.supervisor = supervisor;
		this.subject_id = subject_id;
	}

	public Subject() {}

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

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	

}
