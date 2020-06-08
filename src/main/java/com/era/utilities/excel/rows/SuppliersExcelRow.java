/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel.rows;

import com.era.utilities.excel.rows.models.SupplierExcelRowModel;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

/**
 *
 * @author PC
 */
public class SuppliersExcelRow extends BaseExcelRow {
 
    public SuppliersExcelRow(){
    
        this.OnCell = (int cellNumber, int cellType, Cell Cell, Object RowExcelModel) -> {
            
            SupplierExcelRowModel SupplierExcelRowModel;
            if(RowExcelModel != null){
                SupplierExcelRowModel = (SupplierExcelRowModel)RowExcelModel;
            }
            else{
                SupplierExcelRowModel = new SupplierExcelRowModel();
            }
            
            switch(cellType){
                
                case CELL_TYPE_STRING:
                    
                    if(cellNumber == 0){
                        SupplierExcelRowModel.setCode(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 1){
                        SupplierExcelRowModel.setSerie(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 2){
                        SupplierExcelRowModel.setName(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 3){
                        SupplierExcelRowModel.setRfc(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 4){
                        SupplierExcelRowModel.setPhone(Cell.getStringCellValue());
                    }                    
                    else if(cellNumber == 5){
                        SupplierExcelRowModel.setLada(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 6){
                        SupplierExcelRowModel.setCellphone(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 7){
                        SupplierExcelRowModel.setEmail(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 8){
                        SupplierExcelRowModel.setCity(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 9){
                        SupplierExcelRowModel.setEstate(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 10){
                        SupplierExcelRowModel.setCountry(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 11){
                        SupplierExcelRowModel.setStreet(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 12){
                        SupplierExcelRowModel.setColony(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 13){
                        SupplierExcelRowModel.setInteriorNumber(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 14){
                        SupplierExcelRowModel.setExternalNumber(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 15){
                        SupplierExcelRowModel.setWebpage(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 16){
                        SupplierExcelRowModel.setObservations(Cell.getStringCellValue());
                    }
                    
                    break;
                    
                case CELL_TYPE_NUMERIC:
                    break;
            }
            
            return SupplierExcelRowModel;
        };
    }        
}
