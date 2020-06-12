/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel.rows;

import com.era.utilities.excel.rows.models.ProductExcelRowModel;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

/**
 *
 * @author PC
 */
public class ProductExcelRow extends BaseExcelRow {
 
    public ProductExcelRow(){
    
        this.OnCell = (int cellNumber, int cellType, Cell Cell, Object RowExcelModel) -> {
            
            ProductExcelRowModel ProductExcelRowModel;
            if(RowExcelModel != null){
                ProductExcelRowModel = (ProductExcelRowModel)RowExcelModel;
            }
            else{
                ProductExcelRowModel = new ProductExcelRowModel();
            }
            
            switch(cellType){
                
                case CELL_TYPE_STRING:
                    
                    if(cellNumber == 0){
                        ProductExcelRowModel.setCode(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 1){
                        ProductExcelRowModel.setDescription(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 2){
                        ProductExcelRowModel.setNombre(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 3){
                        ProductExcelRowModel.setSatCode(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 4){
                        ProductExcelRowModel.setInformation(Cell.getStringCellValue());
                    }                    
                    
                    
                    break;
                    
                case CELL_TYPE_NUMERIC:
                    
                    ProductExcelRowModel.setSatCode(String.valueOf(Cell.getNumericCellValue()));
                    
                    break;
            }
            
            return ProductExcelRowModel;
        };
    }        
}
