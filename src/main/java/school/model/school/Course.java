/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model.school;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import school.model.school.enumvalue.Coursetype;
import school.model.school.enumvalue.Stclass;
import school.model.school.enumvalue.Groups;

/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name = "Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "firstcode")
	private String firstcode;
	
	@Column(name = "secondcode")
	private String secondcode;

	@Column(name = "thirdcode")
	private String thirdcode;
	
	@Column(name = "stclass")
	private Stclass stclass;

	@Column(name = "Course_type")
	private Coursetype coursetype;

	@Column(name = "groups")
	private Groups groups;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", updatable = false)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(name = "Course_take"
	 ,joinColumns = @JoinColumn(name = "Course_id", referencedColumnName = "id")
	 ,inverseJoinColumns =@JoinColumn(name = "Take_id", referencedColumnName = "id"))
     private List<TakeCourse> takeCourse;
//	 private List<TakeCourse> takeCourse;


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstcode() {
		return firstcode;
	}

	public void setFirstcode(String firstcode) {
		this.firstcode = firstcode;
	}

	public String getSecondcode() {
		return secondcode;
	}

	public void setSecondcode(String secondcode) {
		this.secondcode = secondcode;
	}

	public String getThirdcode() {
		return thirdcode;
	}

	public void setThirdcode(String thirdcode) {
		this.thirdcode = thirdcode;
	}

	public Stclass getStclass() {
		return stclass;
	}

	public void setStclass(Stclass stclass) {
		this.stclass = stclass;
	}

	public Coursetype getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
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

	public List<TakeCourse> getTakeCourse() {
		return takeCourse;
	}

	public void setTakeCourse(List<TakeCourse> takeCourse) {
		this.takeCourse = takeCourse;
	}


	public Course(Long id, String title, String firstcode, String secondcode, String thirdcode, Stclass stclass,
			Coursetype coursetype, Groups groups, Date createDate, Date modifyDate, List<TakeCourse> takeCourse
			) {
		super();
		this.id = id;
		this.title = title;
		this.firstcode = firstcode;
		this.secondcode = secondcode;
		this.thirdcode = thirdcode;
		this.stclass = stclass;
		this.coursetype = coursetype;
		this.groups = groups;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.takeCourse = takeCourse;
	
	}
}
