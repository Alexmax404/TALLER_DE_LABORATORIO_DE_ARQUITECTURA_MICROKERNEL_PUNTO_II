package co.unicauca.core.plugin.manager;

import co.unicauca.common.interfaces.IReportPlugin;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es una fábrica que utiliza reflexión para crear dinámicamente los
 * plugins.
 *
 */
public class ReportPluginManager {

    private static final String FILE_NAME = "plugin.properties";
    private static ReportPluginManager instance;

    private Properties pluginProperties;

    private ReportPluginManager() {
        pluginProperties = new Properties();
    }

    public static ReportPluginManager getInstance() {
        return instance;
    }

    public static void init(String basePath) throws Exception {

        instance = new ReportPluginManager();
        instance.loadProperties(basePath);
        if (instance.pluginProperties.isEmpty()) {
            throw new Exception("Could not initialize plugins");
        }

    }

    /**
     * Retorna un plugin según el tipo de reporte solicitado (ej. "html", "json")
     *
     * @param reportType tipo de reporte definido en plugin.properties
     * @return instancia de IReportPlugin o null si no existe
     */
    public IReportPlugin getReportPlugin(String reportType) {
        String propertyName = "report." + reportType.toLowerCase();

        if (!pluginProperties.containsKey(propertyName)) {
            return null;
        }

        IReportPlugin plugin = null;
        String pluginClassName = pluginProperties.getProperty(propertyName);

        try {
            Class<?> pluginClass = Class.forName(pluginClassName);
            Object pluginObject = pluginClass.getDeclaredConstructor().newInstance();

            if (pluginObject instanceof IReportPlugin) {
                plugin = (IReportPlugin) pluginObject;
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                 NoSuchMethodException | InvocationTargetException ex) {
            Logger.getLogger("ReportPluginManager").log(Level.SEVERE, "Error al cargar el plugin", ex);
        }

        return plugin;
    }

    private void loadProperties(String basePath) {
        String filePath = basePath + FILE_NAME;
        try (FileInputStream stream = new FileInputStream(filePath)) {
            pluginProperties.load(stream);
        } catch (IOException ex) {
            Logger.getLogger("ReportPluginManager").log(Level.SEVERE, "No se pudo leer plugin.properties", ex);
        }
    }

}
