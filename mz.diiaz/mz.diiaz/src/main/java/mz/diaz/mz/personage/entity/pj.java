package mz.diaz.mz.personage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class pj {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private String raza;
private int nivelDePoder;
private String url_imagen;



public pj() {
	super();
}



public pj(Long id, String nombre, String raza, int nivelDePoder, String url_imagen) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.raza = raza;
	this.nivelDePoder = nivelDePoder;
	this.url_imagen = url_imagen;
}



public String getNombre() {
	return nombre;
}



public void setNombre(String nombre) {
	this.nombre = nombre;
}



public String getRaza() {
	return raza;
}



public void setRaza(String raza) {
	this.raza = raza;
}



public int getNivelDePoder() {
	return nivelDePoder;
}



public void setNivelDePoder(int nivelDePoder) {
	this.nivelDePoder = nivelDePoder;
}



public String getUrl_imagen() {
	return url_imagen;
}



public void setUrl_imagen(String url_imagen) {
	this.url_imagen = url_imagen;
}
}




