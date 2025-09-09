package co.unicauca.json.plugin;

import co.unicauca.common.interfaces.IReportPlugin;
import co.unicauca.common.entities.Project;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Nicolas
 */
public class ReportJsonPlugin implements IReportPlugin{

@Override
public String generateReport(List<Project> data) {
    StringBuilder sb = new StringBuilder();
    sb.append("[\n");
    for (int i = 0; i < data.size(); i++) {
        Project project = data.get(i);

        // Sacar estudiantes individuales
        String estudiante1 = project.getEstudiantes().size() > 0 ? project.getEstudiantes().get(0) : null;
        String estudiante2 = project.getEstudiantes().size() > 1 ? project.getEstudiantes().get(1) : null;

        // Formato fecha dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = project.getFechaAprobacionFormatoA().format(formatter);

        sb.append("  {\n")
          .append("    \"id\": \"").append(project.getId()).append("\",\n")
          .append("    \"nombre\": \"").append(project.getNombreProyecto()).append("\",\n")
          .append("    \"fechaFormatoA\": \"").append(fecha).append("\",\n")
          .append("    \"estudiante1\": ").append(estudiante1 != null ? "\"" + estudiante1 + "\"" : "null").append(",\n")
          .append("    \"estudiante2\": ").append(estudiante2 != null ? "\"" + estudiante2 + "\"" : "null").append(",\n")
          .append("    \"profesor\": \"").append(project.getProfesor()).append("\",\n")
          .append("    \"tipo\": \"").append(project.getTipo()).append("\",\n")
          .append("    \"programa\": \"").append(project.getPrograma()).append("\"\n")
          .append("  }");

        if (i < data.size() - 1) {
            sb.append(",");
        }
        sb.append("\n");
    }
    sb.append("]");
    String json = sb.toString();
    
    // Guardar en archivo reporte.json
    try {
        Files.write(Paths.get("reporte.json"), json.getBytes());
        System.out.println("Archivo 'reporte.json' generado con exito.");
    } catch (IOException e) {
            e.printStackTrace();
    }
    
    return json;
}


}
