package inputData;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;

public class ReadData {

	public static void main(String[] args) throws Exception  {
		File f = new File("C:/Users/Nirnay/Desktop/Test/TestData2.xlsx");
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet("Sheet1");
		int rows = s.getRows();
		int columns = s.getColumns();
		System.out.println(rows);
		System.out.println(columns);

	}

}
