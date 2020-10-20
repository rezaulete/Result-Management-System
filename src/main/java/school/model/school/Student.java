/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model.school;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import school.model.school.enumvalue.Gender;
import school.model.school.enumvalue.Religion;
import school.model.school.enumvalue.Stclass;
import school.model.school.enumvalue.Activity;

/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "presentroll")
	private Long presentroll;
	
	@Column(name = "fathername")
	private String fathername;
	
	
	@Column(name = "mothername")
	private String mothername;

	@Column(name = "gender")
	private Gender gender;
	
	private Religion religion;
	
	
	@Column(name = "presentclass")
	private Stclass presentclass;
	
	@ManyToOne
	private Stsession presentsession;

	@Column(name = "activity")
	private Activity activity;
	
	@OneToMany(cascade = CascadeType.ALL)
    private Set<Register> register = new HashSet<>();

	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
	private Date birthdate;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", updatable = false)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPresentroll() {
		return presentroll;
	}

	public void setPresentroll(Long presentroll) {
		this.presentroll = presentroll;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Religion getReligion() {
		return religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public Stclass getPresentclass() {
		return presentclass;
	}

	public void setPresentclass(Stclass presentclass) {
		this.presentclass = presentclass;
	}

	public Stsession getPresentsession() {
		return presentsession;
	}

	public void setPresentsession(Stsession presentsession) {
		this.presentsession = presentsession;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Set<Register> getRegister() {
		return register;
	}

	public void setRegister(Set<Register> register) {
		this.register = register;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Student(Long id, String name, Long presentroll, String fathername, String mothername, Gender gender,
			Religion religion, Stclass presentclass, Stsession presentsession, Activity activity,
			Set<Register> register, Date birthdate, Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.name = name;
		this.presentroll = presentroll;
		this.fathername = fathername;
		this.mothername = mothername;
		this.gender = gender;
		this.religion = religion;
		this.presentclass = presentclass;
		this.presentsession = presentsession;
		this.activity = activity;
		this.register = register;
		this.birthdate = birthdate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}


}
