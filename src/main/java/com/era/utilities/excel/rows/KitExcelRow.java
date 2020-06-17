/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel.rows;

import com.era.utilities.excel.rows.models.KitExcelRowModel;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

/**
 *
 * @author PC
 */
public class KitExcelRow extends BaseExcelRow {
 
    public KitExcelRow(){
    
        this.OnCell = (int cellNumber, int cellType, Cell Cell, Object RowExcelModel) -> {
            
            KitExcelRowModel KitExcelRowModel;
            if(RowExcelModel != null){
                KitExcelRowModel = (KitExcelRowModel)RowExcelModel;
            }
            else{
                KitExcelRowModel = new KitExcelRowModel();
            }
            
            switch(cellType){
                
                case CELL_TYPE_STRING:
                    
                    if(cellNumber == 0){
                        KitExcelRowModel.setKitCode(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 1){
                        KitExcelRowModel.setProductCode(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 2){
                        KitExcelRowModel.setCant(Cell.getStringCellValue());
                    }
                    
                    
                    break;
                    
                case CELL_TYPE_NUMERIC:
                    
                    KitExcelRowModel.setCant(String.valueOf(Cell.getNumericCellValue()));
                    
                    break;
            }
            
            return KitExcelRowModel;
        };
    }        
}
