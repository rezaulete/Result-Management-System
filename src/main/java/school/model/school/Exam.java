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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name="Exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "Exam_title")
    private String title;
    
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
	private Date startdate;
	
    
    @Column(name = "Exam_year")
    private String year;
    


	public Exam() {
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



	public Date getStartdate() {
		return startdate;
	}



	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public Exam(Long id, String title, Date startdate, String year) {
		super();
		this.id = id;
		this.title = title;
		this.startdate = startdate;
		this.year = year;
	}	
	
	
}
