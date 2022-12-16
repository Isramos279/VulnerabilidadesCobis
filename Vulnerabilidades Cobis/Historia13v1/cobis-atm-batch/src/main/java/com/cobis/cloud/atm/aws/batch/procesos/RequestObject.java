package com.cobis.cloud.atm.aws.batch.procesos;


public class RequestObject {
	private String fechaProceso;
	private String operacion;
	private String fechaInicio;
	private String fechaFin;
	private String iProducto;

	public String getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(String fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getiProducto() {
		return iProducto;
	}

	public void setiProducto(String iProducto) {
		this.iProducto = iProducto;
	}
}
