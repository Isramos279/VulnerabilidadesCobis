package com.cobis.cloud.channelscommons.aws.batch.procesos;

import javax.validation.constraints.NotNull;

public class RequestObject {

	@NotNull(message= "Fecha Proceso cannot be null")
	private String fechaProceso;

	@NotNull(message= "Fecha Actual cannot be null")
	private String fechaActual;

	private String trn;

	private String producto;

	public String getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(String fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
}
