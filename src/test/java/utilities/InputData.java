package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputData {
	String ouput_config;

	public String c_input(String attribute) {

		File configFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");

		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			ouput_config = props.getProperty(attribute);
			reader.close();
		} catch (FileNotFoundException ex) {

		} catch (IOException ex) {

		}
		return ouput_config;

	}

	public LinkedHashMap<String, String> exl_inputs(String sheetname, String rowname) throws IOException {

		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\input_data.xlsx"));
		LinkedHashMap<String, String> mapvalue = new LinkedHashMap<String, String>();

		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = null;
		DataFormatter formatter = new DataFormatter();

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

			if (sheetname.equalsIgnoreCase(workbook.getSheetName(i))) {
				sheet = workbook.getSheetAt(i);

				for (int j = 0; j <= sheet.getLastRowNum(); j++) {
					
					if (rowname.equals(sheet.getRow(j).getCell(0).getStringCellValue())) {

						for (int k = 1; k < sheet.getRow(j).getLastCellNum(); k++) {

							System.out.println("key " + formatter.formatCellValue(sheet.getRow(0).getCell(k))
									+ "Value :" + formatter.formatCellValue(sheet.getRow(j).getCell(k)));
							mapvalue.put(formatter.formatCellValue(sheet.getRow(0).getCell(k)),
									formatter.formatCellValue(sheet.getRow(j).getCell(k)));

						}
						break;
					}

				}
			}
		}
		
		return mapvalue;

	}

	public LinkedHashMap<String, String> getExcelinputs() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String sheetname;
		String methodname;

		sheetname = stackTraceElements[2].getClassName();
		sheetname = sheetname.substring(sheetname.lastIndexOf('.') + 1);
		methodname = stackTraceElements[2].getMethodName();

		try {
			return exl_inputs(sheetname, methodname);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}