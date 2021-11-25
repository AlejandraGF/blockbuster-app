package tec.bd.blockbuster.entity;


import java.util.Date;

public class Prestamo {
    private long cedula;
    private long codigo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private char estado;

    public Prestamo(long cedula, long codigo) {
        this.cedula = cedula;
        this.codigo = codigo;
    }

    public Prestamo(long cedula, long codigo, Date fechaPrestamo, Date fechaDevolucion) {
        this.cedula = cedula;
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(long cedula, long codigo, Date fechaPrestamo, Date fechaDevolucion, char estado) {
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

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
