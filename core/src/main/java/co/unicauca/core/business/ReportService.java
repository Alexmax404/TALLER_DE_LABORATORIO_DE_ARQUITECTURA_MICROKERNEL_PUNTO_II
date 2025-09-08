package co.unicauca.core.business;

import co.unicauca.common.entities.Project;
import co.unicauca.common.interfaces.IReportPlugin;
import co.unicauca.core.plugin.manager.ReportPluginManager;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class ReportService {

    public String generateReport(List<Project> projects, String reportType) throws Exception {
        ReportPluginManager manager = ReportPluginManager.getInstance();
        IReportPlugin plugin = manager.getReportPlugin(reportType);

        if (plugin == null) {
            throw new Exception("No hay un plugin disponible para el tipo de reporte: " + reportType);
        }

        return plugin.generateReport(projects);
    }
}
