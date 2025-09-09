package co.unicauca.core.plugin.presentation;

import co.unicauca.core.business.ProjectService;
import co.unicauca.core.business.ReportService;
import java.util.Scanner;

public class Console {
    private final ProjectService projectService;
    private final ReportService reportService;
    private final Scanner scanner;

    public Console() {
        this.projectService = new ProjectService();
        this.reportService = new ReportService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;

        System.out.println("Aplicacion de Reportes de Proyectos de Grado");

        do {
            System.out.println();
            System.out.println("1. Generar reporte");
            System.out.println("2. Salir");

            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    askReportType();
                    break;
                case 2:
                    System.out.println("Aplicacion terminada.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (option != 2);
    }

    private void askReportType() {
        System.out.print("Ingrese el tipo de reporte: ");
        String reportType = scanner.nextLine().trim().toLowerCase();

        try {
            String report = reportService.generateReport(projectService.getAll(), reportType);
            System.out.println("\n=== REPORTE " + reportType.toUpperCase() + " ===");
            System.out.println(report);
        } catch (Exception e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }
}
