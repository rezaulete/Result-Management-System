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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import school.model.school.enumvalue.Gender;
import school.model.school.enumvalue.Stclass;
import school.model.school.enumvalue.Version;

/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name="Student")
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "roll_no")
    private Long rollno;
    
    @Column(name = "registraion_no")
    private String registration;
    
    @Column(name = "stsession")
    private String stsession;
    
    @Column(name = "class")
    private Stclass grade;
    
    @Column(name = "Version")
    private Version version;
    
	@Column(name = "gender")
	private Gender gender;
    
	
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date",updatable=false)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;
	

	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
