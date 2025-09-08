
package co.unicauca.common.interfaces;

import co.unicauca.common.entities.Project;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public interface IReportPlugin {
    String generateReport(List<Project>data);
}
