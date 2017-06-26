package excel;


import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

/**
 * Created by Steven
 * Date:2017/6/24
 * Time:15:31
 */
public class ExcelWriteTest {

	public static void main(String[] args) throws Exception{
		Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Steven\\Desktop\\country.xls"));
		WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("C:\\Users\\Steven\\Desktop\\target.xls"), workbook);

		WritableSheet writableSheet = writableWorkbook.getSheet(0);
		Cell cell = writableSheet.getCell(1, 1);

		Label label1 = new Label(1, 8, "Test column");
		Label label2 = new Label(1, 7, cell.getContents());

		writableSheet.addCell(label1);
		writableSheet.addCell(label2);

		writableWorkbook.write();
		writableWorkbook.close();
	}
}
