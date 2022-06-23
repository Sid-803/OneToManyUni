package entity;
//POJO

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="l_name")
	private String l_name;
	@Column(name="f_name")
	private String f_name;
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="teacher_detail_id")
	private TeacherDetails teacherdetails;
	
	
	public TeacherDetails getTeacherdetails() {
		return teacherdetails;
	}

	public void setTeacherdetails(TeacherDetails teacherdetails) {
		this.teacherdetails = teacherdetails;
	}

	public Teacher() {
		
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Teacher(String l_name, String f_name, String email) {
		super();
		this.l_name = l_name;
		this.f_name = f_name;
		this.email = email;
	}


}
