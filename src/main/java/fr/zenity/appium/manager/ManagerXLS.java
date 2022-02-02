package fr.zenity.appium.manager;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerXLS {

    public ManagerXLS(){}

    private List<List<String>> list;

    private static final String fileName = "C:\\Users\\Wbenmessaoud\\Desktop\\Wass\\TrainingZenity\\Appium-demo-Zenity\\src\\main\\resources\\Donnes.xlsx";

    private Sheet sheet = null;

    public void load(String sheetName) {


        //Get first sheet from the workbook
        try {
            final Workbook workbook = WorkbookFactory.create(new File(fileName));
            //this.sheet = workbook.getSheet("Feuil1");
            this.sheet = workbook.getSheet(sheetName);
        }catch(Exception e){
            System.out.println("Sheet doesn't exist");
        }
    }

    public int getSize(){
        return sheet.getLastRowNum();
    }

    public List<String> getLine(int lineNumber){
        List<Object> line = new ArrayList<>();

        this.sheet.getRow(lineNumber + 1).iterator().forEachRemaining(cell -> {
            line.add(cell.getStringCellValue());
        });

        return line.stream()
                .map(value -> String.valueOf(value))
                .collect(Collectors.toList());
    }

    public List<List<String>> getLines(){
        List<List<String>> lines= new ArrayList<>();

        try {
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                lines.add(getLine(i));
            }
        }catch(Exception e){
            return lines;
        }

        return lines;

    }

}
