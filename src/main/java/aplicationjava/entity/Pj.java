package aplicationjava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pj {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private int vida;
private String url_imagen;

@ManyToOne
@JoinColumn (name = "Aldea_id")
private Aldea Aldea;

@OneToOne (mappedBy = "Pj")
private Poder Poder;


public Pj(String nombre, int vida, Aldea aldea, Poder poder) {
	super();
	this.nombre = nombre;
	this.vida = vida;
	Aldea = aldea;
	Poder = poder;
}

public Pj() {
	
}




public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getvida() {
	return vida;
}
public void setvida(int vida) {
	this.vida = vida;
}
public String getUrl_imagen() {
	return url_imagen;
}
public void setUrl_imagen(String url_imagen) {
	this.url_imagen = url_imagen;
}
public Aldea getAldea() {
	return Aldea;
}
public void setAldea(Aldea aldea) {
	Aldea = aldea;
}
public Poder getPoder() {
	return Poder;
}
public void setPoder(Poder poder) {
	Poder = poder;
}

}




