package com.springboot.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "points ")
public class Points {
	
	@Column(name = "the_geom")
	private String theGeom;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartodbId;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "color")
	private String color;
	
	public Points() {
		super();
	}

	public Points(String theGeom, long cartodbId, String tipo, String latitude, String longitude, String color) {
		super();
		this.theGeom = theGeom;
		this.cartodbId = cartodbId;
		this.tipo = tipo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.color = color;
	}

	public String getTheGeom() {
		return theGeom;
	}

	public void setTheGeom(String theGeom) {
		this.theGeom = theGeom;
	}

	public long getCartodbId() {
		return cartodbId;
	}

	public void setCartodbId(long cartodbId) {
		this.cartodbId = cartodbId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	

}
