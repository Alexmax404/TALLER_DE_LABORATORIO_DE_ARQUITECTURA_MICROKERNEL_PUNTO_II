
package co.unicauca.core.business;


import co.unicauca.common.entities.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectService {
    
    public List<Project> getAll() {
        
        List<Project> proyectos = new ArrayList<>();
        
        proyectos.add(new Project("1", "Sistema de Gestion de Tesis", LocalDate.of(2025, 3, 15), Arrays.asList("Carlos Lopez", "Maria Gomez"),"Dr. Perez", "Aplicacion Web", "Ingenieria de Sistemas"));
        proyectos.add(new Project("2","Sistema de Monitoreo Predictivo para Motores Electricos usando IoT",LocalDate.of(2025, 6, 10),Arrays.asList("Luis Ramirez"),"Ing. Fernando Castillo"
                        ,"Proyecto de Automatizacion","Ingenieria en Automatica Industrial"
));
        return proyectos;
    }
}
