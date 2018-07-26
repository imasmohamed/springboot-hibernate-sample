/**
 * 
 */
package lk.inova.mysample.common.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * @author imasmohamed
 * @Description Mapped entity class for APP_USER db table.
 */
@Entity
@Table(name = "APP_USER")
public class AppUser {

	@Id
	@SequenceGenerator(name = "APP_USER_ID_GENERATOR", sequenceName = "APP_USER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="APP_USER_ID_GENERATOR")
	@Column(name = "ID",unique=true,nullable=false)
	private Integer id;
	
	@Column(name="USER_NAME" )
	private String userName;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_AT",nullable=false)
	private Date createdAt;

	

	public AppUser() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public AppUser(String userName, Date createdAt) {
		super();
		this.userName = userName;
		this.createdAt = createdAt;
	}

}
