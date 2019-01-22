import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Poi_test{
	public static void main(String[] args) throws IOException {

	//ファイルを読み込み
	FileInputStream in = new FileInputStream("../templ01.xlsx");

    Workbook book = null;
	try {
	    book = WorkbookFactory.create(in);

	} catch (EncryptedDocumentException e1) {
	    e1.printStackTrace();

	}
	//シート名　シートを取得
	Sheet sheet = book.getSheet("Sheet1");

	// 行番後(0から)
	Row row = sheet.getRow(9);
	// セル番号(0から)
	Cell a1 = row.getCell(2);
	// セルに値を入力
	a1.setCellValue("xlsx編集テスト");

	// ここからファイル保存処理
	FileOutputStream out = null;
	//別名、別ディレクトリに保存すること
	out = new FileOutputStream("../Sample1.xlsx");
	book.write(out);
    out.close();
    book.close();
	System.out.println("出力完了");

	}
}