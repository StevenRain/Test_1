package excel;

import com.google.common.collect.Lists;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Steven
 * Date:2017/6/24
 * Time:15:05
 */
public class ExcelReadTest {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	static class Country {
		private Integer id;
		private String country;
	}

	public static void main(String[] args) throws Exception{
		Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Steven\\Desktop\\country.xls"));
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();

		List<Country> countries = Lists.newArrayList();
		for(int row = 1; row < rows; row ++) {
			Integer id = Integer.parseInt(sheet.getCell(0, row).getContents());
			String country = sheet.getCell(1, row).getContents();
			countries.add(Country.builder().id(id).country(country).build());
		}
		countries.forEach(System.out::println);
	}
}

