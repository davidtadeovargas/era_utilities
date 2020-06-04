/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel;

import com.era.utilities.excel.rows.BaseExcelRow;
import java.io.File;
import java.io.FileInputStream;
import static java.sql.JDBCType.NUMERIC;
import java.util.Iterator;
import javax.print.DocFlavor.STRING;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_ERROR;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PC
 */
public abstract class Workbook {
 
    private String filePath;
    private final BaseExcelRow BaseExcelRow;
    private OnCellRender OnCellRender;
    private OnFinish OnFinish;
    
    
    public Workbook(final BaseExcelRow BaseExcelRow){
        this.BaseExcelRow = BaseExcelRow;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setOnFinish(OnFinish OnFinish) {
        this.OnFinish = OnFinish;
    }
        
    public void load() throws Exception {
        
        FileInputStream FileInputStream =  new FileInputStream(new File(filePath));
        final XSSFWorkbook XSSFWorkbook = new XSSFWorkbook(FileInputStream);
        XSSFSheet sheet = XSSFWorkbook.getSheetAt(0);
        Iterator<Row> rowIt     = sheet.iterator();
        int x = -1;
        while(rowIt.hasNext())
        {   
            Row row = rowIt.next();
            
            ++x;
            
            if(x == 0){
                continue;
            }
                        
            Iterator<Cell> cellIterator = row.cellIterator();
            
            final Object Object = BaseExcelRow.onRow(row, cellIterator);
            
            //End of the file find
            if(Object==null){
                break;
            }
            
            if(OnCellRender != null){
                OnCellRender.oncell(Object);
            }
        }
        
        //Finish callback
        if(OnFinish != null){
            OnFinish.onFinish();
        }
    }

    public void setOnCellRender(OnCellRender OnCellRender) {
        this.OnCellRender = OnCellRender;
    }        
    
    public interface OnCellRender{
        public void oncell(Object CellModel);
    }
    
    public interface OnFinish{
        public void onFinish();
    }
}
