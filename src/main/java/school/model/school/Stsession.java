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

import school.model.school.enumvalue.Epoch;

/**
 *
 * @author Md Rezaul karim
 */
@Entity
@Table(name="Stsession")
public class Stsession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "title")
    private String title;
    
	@Column(name = "epoch")
	private Epoch epoch;

	public Stsession() {
		super();
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

	public Epoch getEpoch() {
		return epoch;
	}

	public void setEpoch(Epoch epoch) {
		this.epoch = epoch;
	}

	public Stsession(Long id, String title, Epoch epoch) {
		super();
		this.id = id;
		this.title = title;
		this.epoch = epoch;
	}

}
