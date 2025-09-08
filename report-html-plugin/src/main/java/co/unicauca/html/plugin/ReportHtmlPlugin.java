package co.unicauca.html.plugin;

import co.unicauca.common.interfaces.IReportPlugin;
import co.unicauca.common.entities.Project;

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
          .append("\t\t<title>Reporte de Proyectos de Grado</title>\n")
          .append("\t</head>\n")
          .append("\t<body>\n")
          .append("\t\t<h1>Reporte de Proyectos de Grado</h1>\n")
          .append("\t\t<table>\n")
          .append("\t\t\t<thead>\n")
          .append("\t\t\t\t<tr>\n")
          .append("\t\t\t\t\t<th>ID</th>\n")
          .append("\t\t\t\t\t<th>Nombre del Proyecto</th>\n")
          .append("\t\t\t\t\t<th>Fecha aprobacion formato A </th>\n")
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

        return sb.toString();
    }
}
