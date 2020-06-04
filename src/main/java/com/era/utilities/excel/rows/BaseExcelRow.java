/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel.rows;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author PC
 */
public abstract class BaseExcelRow {    
    //public abstract Object onRow(final Row Row, final Iterator<Cell> cellIterator);
    
    protected OnCell OnCell;
    
    
    public Object onRow(final Row Row, final Iterator<Cell> cellIterator){
                
        Object RowExcelModel = null;
        
        boolean endFile = false;
        int x = 0;
        while(cellIterator.hasNext()){
         
            Cell cell = cellIterator.next();            
            
            switch(cell.getCellType()){
                case CELL_TYPE_STRING:
                    final String stringContent = cell.getStringCellValue();
                    if(stringContent.compareTo("FINARCHIVO")==0){
                       endFile = true; 
                    }
                    break;
            }                        
            
            if(endFile){
                break;
            }
            
            if(OnCell!=null){
                RowExcelModel = OnCell.onCell(x, cell.getCellType(), cell, RowExcelModel);
            }
                        
            ++x;
        }
        
        return RowExcelModel;
    }
    
    public interface OnCell{
        public Object onCell(int cellNumber, int cellType, final Cell Cell, Object RowExcelModel);
    }
}
