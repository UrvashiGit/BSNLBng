package com.sterlite.bsnl.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBLCIRCULARDETAIL")
public class CircularMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CIRCUARID")
	private int id;
	
	@Column(name="DESCRIPTION")
	private String desc;
	
	@Column(name="FILEPATH")
	private String filename;
	
	@Column(name="CIRCUARDATE")
	private Date circulardate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getCirculardate() {
		return circulardate;
	}

	public void setCirculardate(Date circulardate) {
		this.circulardate = circulardate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CircularMaster [id=").append(id).append(", desc=").append(desc).append(", filename=")
				.append(filename).append(", circulardate=").append(circulardate).append("]");
		return builder.toString();
	}
	
	
	

}
