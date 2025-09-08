
package co.unicauca.common.entities;

import java.time.LocalDate;
import java.util.List;


public class Project {
    private String id;
    private String nombreProyecto;
    private LocalDate fechaAprobacionFormatoA; 
    private List<String> estudiantes;
    private String profesor;
    private String tipo;
    private String programa;

    public Project(String id, String nombreProyecto, LocalDate fechaAprobacionFormatoA, List<String> estudiantes, String profesor, String tipo, String programa) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.fechaAprobacionFormatoA = fechaAprobacionFormatoA;
        this.estudiantes = estudiantes;
        this.profesor = profesor;
        this.tipo = tipo;
        this.programa = programa;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public LocalDate getFechaAprobacionFormatoA() {
        return fechaAprobacionFormatoA;
    }

    public void setFechaAprobacionFormatoA(LocalDate fechaAprobacionFormatoA) {
        this.fechaAprobacionFormatoA = fechaAprobacionFormatoA;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<String> estudiantes) {
        this.estudiantes = estudiantes;
    }

    
    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
    
}
