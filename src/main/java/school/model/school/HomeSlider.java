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
 * @author Rezaul Karim Razu
 */
@Entity
public class HomeSlider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Date is required.")
    @Temporal(TemporalType.DATE)
	private Date publishDate;
	
	@Column(name = "picFile1")
	private String picFile1;
	
	@Column(name = "picFile2")
	private String picFile2;
	
	@Column(name = "picFile3")
	private String picFile3;
	
	@Column(name = "active")
	private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPicFile1() {
		return picFile1;
	}

	public void setPicFile1(String picFile1) {
		this.picFile1 = picFile1;
	}

	public String getPicFile2() {
		return picFile2;
	}

	public void setPicFile2(String picFile2) {
		this.picFile2 = picFile2;
	}

	public String getPicFile3() {
		return picFile3;
	}

	public void setPicFile3(String picFile3) {
		this.picFile3 = picFile3;
	}


	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
 
	
	@Override
	public String toString() {
		return "HomeSlider [id=" + id + ", publishDate=" + publishDate + ", picFile1=" + picFile1 + ", picFile2="
				+ picFile2 + ", picFile3=" + picFile3 + ", active=" + active + "]";
	}

	
	public HomeSlider(Long id, @NotNull(message = "Date is required.") Date publishDate, String picFile1,
			String picFile2, String picFile3, boolean active) {
		super();
		this.id = id;
		this.publishDate = publishDate;
		this.picFile1 = picFile1;
		this.picFile2 = picFile2;
		this.picFile3 = picFile3;
		this.active = active;
	}

	public HomeSlider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
