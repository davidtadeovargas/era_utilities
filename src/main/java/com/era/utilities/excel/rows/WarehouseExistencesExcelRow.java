/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel.rows;

import com.era.utilities.excel.rows.models.WarehouseExistencesExcelRowModel;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author PC
 */
public class WarehouseExistencesExcelRow extends BaseExcelRow {
 
    public WarehouseExistencesExcelRow(){
    
        this.OnCell = (int cellNumber, int cellType, Cell Cell, Object RowExcelModel) -> {
            
            WarehouseExistencesExcelRowModel WarehouseExistencesExcelRowModel;
            if(RowExcelModel != null){
                WarehouseExistencesExcelRowModel = (WarehouseExistencesExcelRowModel)RowExcelModel;
            }
            else{
                WarehouseExistencesExcelRowModel = new WarehouseExistencesExcelRowModel();
            }
            
            switch(cellType){
                
                case CELL_TYPE_STRING:
                    
                    if(cellNumber == 0){
                        WarehouseExistencesExcelRowModel.setWarehouseCode(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 1){
                        WarehouseExistencesExcelRowModel.setProductCode(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 2){
                        WarehouseExistencesExcelRowModel.setExistence(Double.valueOf(Cell.getStringCellValue()));
                    }
                    
                    break;
                    
                case CELL_TYPE_NUMERIC:
                    WarehouseExistencesExcelRowModel.setExistence(Cell.getNumericCellValue());
                    break;
            }
            
            return WarehouseExistencesExcelRowModel;
        };
    }        
}
