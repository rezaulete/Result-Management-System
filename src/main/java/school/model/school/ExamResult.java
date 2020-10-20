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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author Md Rezaul Karim
 */

@Entity
public class ExamResult {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "file_title")   
	private String title; 
	
	@Column(name = "file_grade")   
	private String grade; 
	
	@Column(name = "file_sesSion")   
	private String sesSion; 
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Date is required.")
    @Temporal(TemporalType.DATE)
	private Date publishDate;
	
	@Column(name = "picFile")
	private String picFile;

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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSesSion() {
		return sesSion;
	}

	public void setSesSion(String sesSion) {
		this.sesSion = sesSion;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPicFile() {
		return picFile;
	}

	public void setPicFile(String picFile) {
		this.picFile = picFile;
	}

	@Override
	public String toString() {
		return "ExamResult [id=" + id + ", title=" + title + ", grade=" + grade + ", sesSion=" + sesSion
				+ ", publishDate=" + publishDate + ", picFile=" + picFile + "]";
	}

	public ExamResult(Long id, String title, String grade, String sesSion,
			@NotNull(message = "Date is required.") Date publishDate, String picFile) {
		super();
		this.id = id;
		this.title = title;
		this.grade = grade;
		this.sesSion = sesSion;
		this.publishDate = publishDate;
		this.picFile = picFile;
	}

	public ExamResult() {
		super();
		// TODO Auto-generated constructor stub
	}

  
}
