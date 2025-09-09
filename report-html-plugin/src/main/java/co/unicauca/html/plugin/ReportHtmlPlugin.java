package co.unicauca.html.plugin;

import co.unicauca.common.interfaces.IReportPlugin;
import co.unicauca.common.entities.Project;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ReportHtmlPlugin implements IReportPlugin {

    @Override
    public String generateReport(List<Project> data) {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        sb.append("Reporte en formato HTML:\n")
          .append("<!DOCTYPE html>\n")
          .append("<html lang=\"es\">\n")
          .append("\t<head>\n")
          .append("\t\t<meta charset=\"UTF-8\">\n")
          .append("\t\t<title>Reporte de Proyectos de Grado</title>\n")
          .append("\t\t<style>\n")
          .append("\t\t\ttable { border-collapse: collapse; width: 100%; }\n")
          .append("\t\t\tth, td { border: 1px solid black; padding: 8px; text-align: left; }\n")
          .append("\t\t\tth { background-color: #f2f2f2; }\n")
          .append("\t\t</style>\n")
          .append("\t</head>\n")
          .append("\t<body>\n")
          .append("\t\t<h1>Reporte de Proyectos de Grado</h1>\n")
          .append("\t\t<table>\n")
          .append("\t\t\t<thead>\n")
          .append("\t\t\t\t<tr>\n")
          .append("\t\t\t\t\t<th>ID</th>\n")
          .append("\t\t\t\t\t<th>Nombre del Proyecto</th>\n")
          .append("\t\t\t\t\t<th>Fecha aprobacion formato A</th>\n")
          .append("\t\t\t\t\t<th>Estudiante(s)</th>\n")
          .append("\t\t\t\t\t<th>Profesor</th>\n")
          .append("\t\t\t\t\t<th>Tipo</th>\n")
          .append("\t\t\t\t\t<th>Programa</th>\n")
          .append("\t\t\t\t</tr>\n")
          .append("\t\t\t</thead>\n")
          .append("\t\t\t<tbody>\n");

        for (Project project : data) {
            sb.append("\t\t\t\t<tr>\n")
              .append("\t\t\t\t\t<td>").append(project.getId()).append("</td>\n")
              .append("\t\t\t\t\t<td>").append(project.getNombreProyecto()).append("</td>\n")
              .append("\t\t\t\t\t<td>").append(project.getFechaAprobacionFormatoA().format(formatter)).append("</td>\n")
              .append("\t\t\t\t\t<td>").append(String.join(", ", project.getEstudiantes())).append("</td>\n")
              .append("\t\t\t\t\t<td>").append(project.getProfesor()).append("</td>\n")
              .append("\t\t\t\t\t<td>").append(project.getTipo()).append("</td>\n")
              .append("\t\t\t\t\t<td>").append(project.getPrograma()).append("</td>\n")
              .append("\t\t\t\t</tr>\n");
        }

        sb.append("\t\t\t</tbody>\n")
          .append("\t\t</table>\n")
          .append("\t</body>\n")
          .append("</html>\n");

        String html = sb.toString();
        // Guardar en archivo reporte.html
        try {
            Files.write(Paths.get("reporte.html"), html.getBytes());
            System.out.println("Archivo 'reporte.html' generado con exito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }
}