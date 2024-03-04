package myy803.diplomas_mgt_app_skeleton.model;

public enum Role {

	STUDENT("student"),
	PROFESSOR("professor");

	private String value;
	
	private Role(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}
