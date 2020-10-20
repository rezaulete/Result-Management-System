/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model.school;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import school.model.school.enumvalue.Groups;
import school.model.school.enumvalue.Regularity;
import school.model.school.enumvalue.Stclass;
import school.model.school.enumvalue.Version;

/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name = "Register")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	private Stsession stsession;
	
	@ManyToOne
	private Student student;
	
	@Column(name = "name")
	private String name;

	@Column(name = "roll_no")
	private Long rollno;

	@Column(name = "registraion_no")
	private String registration;


	@ManyToOne
	private Section section;
	
	@Column(name = "stclass")
	private Stclass stclass;

	@Column(name = "Version")
	private Version version;
	
	@Column(name = "groups")
	private Groups groups;

	
	@Column(name = "regularity")
	private Regularity regularity;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", updatable = false)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stsession getStsession() {
		return stsession;
	}

	public void setStsession(Stsession stsession) {
		this.stsession = stsession;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getRollno() {
		return rollno;
	}

	public void setRollno(Long rollno) {
		this.rollno = rollno;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Stclass getStclass() {
		return stclass;
	}

	public void setStclass(Stclass stclass) {
		this.stclass = stclass;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public Regularity getRegularity() {
		return regularity;
	}

	public void setRegularity(Regularity regularity) {
		this.regularity = regularity;
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

	public Register(Long id, Stsession stsession, Student student, Long rollno, String registration, Section section,
			Stclass stclass, Version version, Groups groups, Regularity regularity, Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.stsession = stsession;
		this.student = student;
		this.rollno = rollno;
		this.registration = registration;
		this.section = section;
		this.stclass = stclass;
		this.version = version;
		this.groups = groups;
		this.regularity = regularity;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}


}
