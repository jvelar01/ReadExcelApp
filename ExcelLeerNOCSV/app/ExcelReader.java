import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public List<Pair<String, String>> readExcel(String filePath) {
        List<Pair<String, String>> dataList = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(filePath);

            // Crear un nuevo libro de trabajo de Excel
            Workbook workbook = WorkbookFactory.create(file);

            // Obtener la primera hoja de trabajo del libro de trabajo
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar sobre las filas de la hoja de trabajo
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Obtener celdas de la fila actual y leer datos
                Iterator<Cell> cellIterator = row.cellIterator();
                String name = "", content = "";
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getColumnIndex() == 0) {
                        name = cell.getStringCellValue();
                    } else if (cell.getColumnIndex() == 1) {
                        content = cell.getStringCellValue();
                    }
                }

                dataList.add(new Pair<>(name, content));
            }

            // Cerrar el archivo
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
