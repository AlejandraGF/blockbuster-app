package tec.bd.blockbuster.entity;

import java.sql.Timestamp;

public class Prestamo {
    private long cedula;
    private long codigo;
    private Timestamp fechaPrestamo;
    private Timestamp fechaDevolucion;
    private char estado;

    public Prestamo(long cedula, long codigo) {
        this.cedula = cedula;
        this.codigo = codigo;
    }

    public Prestamo(long cedula, long codigo, Timestamp fechaPrestamo, Timestamp fechaDevolucion) {
        this.cedula = cedula;
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(long cedula, long codigo, Timestamp fechaPrestamo, Timestamp fechaDevolucion, char estado) {
        this.cedula = cedula;
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Timestamp getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Timestamp fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Timestamp getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
