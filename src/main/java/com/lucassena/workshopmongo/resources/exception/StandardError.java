package com.lucassena.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long timesStamp;
	private Integer status;
	private String error;
	private String mesage;
	private String path;
	
	public StandardError() {
		
	}

	public StandardError(Long timesStamp, Integer status, String error, String mesage, String path) {
		super();
		this.timesStamp = timesStamp;
		this.status = status;
		this.error = error;
		this.mesage = mesage;
		this.path = path;
	}

	public Long getTimesStamp() {
		return timesStamp;
	}

	public void setTimesStamp(Long timesStamp) {
		this.timesStamp = timesStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
