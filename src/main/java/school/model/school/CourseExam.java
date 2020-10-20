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
import org.springframework.format.annotation.DateTimeFormat;

import school.model.school.enumvalue.Stclass;
/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name = "CourseExam")
public class CourseExam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	private Exam exam;

	@ManyToOne
	private Course course;

	@Column(name = "stclass")
	private Stclass stclass;

	@Column(name = "highest_mark", scale = 4)
	private double highestmark;

	@Column(name = "pass_mark", scale = 4)
	private double passmark;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
	private Date examdate;

	private String examtime; 
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", updatable = false)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	public CourseExam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Stclass getStclass() {
		return stclass;
	}

	public void setStclass(Stclass stclass) {
		this.stclass = stclass;
	}

	public double getHighestmark() {
		return highestmark;
	}

	public void setHighestmark(double highestmark) {
		this.highestmark = highestmark;
	}

	public double getPassmark() {
		return passmark;
	}

	public void setPassmark(double passmark) {
		this.passmark = passmark;
	}

	public Date getExamdate() {
		return examdate;
	}

	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}

	public String getExamtime() {
		return examtime;
	}

	public void setExamtime(String examtime) {
		this.examtime = examtime;
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

	public CourseExam(Long id, Exam exam, Course course, Stclass stclass, double highestmark, double passmark,
			Date examdate, String examtime, Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.exam = exam;
		this.course = course;
		this.stclass = stclass;
		this.highestmark = highestmark;
		this.passmark = passmark;
		this.examdate = examdate;
		this.examtime = examtime;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}


}
