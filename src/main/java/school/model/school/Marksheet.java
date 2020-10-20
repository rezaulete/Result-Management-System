/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model.school;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name = "marksheet")
public class Marksheet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	 @OneToMany
	private List<Marks> marks;

	public Marksheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Marks> getMarks() {
		return marks;
	}

	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Marksheet [id=" + id + ", marks=" + marks + "]";
	}

	public Marksheet(Long id, List<Marks> marks) {
		super();
		this.id = id;
		this.marks = marks;
	}


}
