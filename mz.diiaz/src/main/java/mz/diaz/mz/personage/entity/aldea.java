package mz.diaz.mz.personage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class aldea {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private String url_imagen;


public aldea() {
	super();
}

public aldea(Long id, String nombre, String url_imagen) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.url_imagen = url_imagen;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getUrl_imagen() {
	return url_imagen;
}

public void setUrl_imagen(String url_imagen) {
	this.url_imagen = url_imagen;
}



}