package core.basesyntax.service;

import static core.basesyntax.db.Storage.inventory;

import java.util.Map;

public class ReportGeneratorService {

    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();

        reportBuilder.append(REPORT_HEADER).append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(COMMA_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return reportBuilder.toString();
    }
}
