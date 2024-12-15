package com.proyecto.integrador.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registros {

    private Boolean activo = AppSettings.ACTIVO;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date creation_date = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date modification_date = new Date();

    public Registros(DatosRegistros datosRegistros) {
        this.modification_date = datosRegistros.modification_date();
        this.creation_date = datosRegistros.creation_date();
        this.activo = datosRegistros.activo();
    }

    public Registros actualizarRegistros(DatosRegistros datosRegistros) {
        this.modification_date = datosRegistros.modification_date();
        return this;
    }

    public String getReporteEstado() {
        return activo ? "Activo": "Inactivo";
    }

    public void desactivar() {
        this.setActivo(false);
    }
}
