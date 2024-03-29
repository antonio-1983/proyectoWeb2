package com.web2.proyecto.model;



import javax.validation.constraints.Size;



public class ProductoModel {

	private int id;
	
	@Size(min=4, max=20)	
	private String descripcion;
	
	
	private String imagen;
	
	private float precio;
	
	
	
	

	@Override
	public String toString() {
		return "ProductoModel [id=" + id + ", descripcion=" + descripcion + ", imagen=" + imagen + ", precio=" + precio
				+ ", compra="  + "]";
	}

	public ProductoModel() {
		super();
	}



	public ProductoModel(int id, @Size(min = 4, max = 20) String descripcion, String imagen, float precio)
	{
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		
	}



	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	


}
