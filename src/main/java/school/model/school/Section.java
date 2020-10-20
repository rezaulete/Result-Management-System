/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model.school;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import school.model.school.enumvalue.Stclass;

/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name = "Section")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "stclass")
	private Stclass stclass;

	public Section() {
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

	public Stclass getStclass() {
		return stclass;
	}

	public void setStclass(Stclass stclass) {
		this.stclass = stclass;
	}

	public Section(Long id, String title, Stclass stclass) {
		super();
		this.id = id;
		this.title = title;
		this.stclass = stclass;
	}

	
}
