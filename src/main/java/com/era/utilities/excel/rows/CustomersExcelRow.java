/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel.rows;

import com.era.utilities.excel.rows.models.CustomerExcelRowModel;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

/**
 *
 * @author PC
 */
public class CustomersExcelRow extends BaseExcelRow {
 
    public CustomersExcelRow(){
    
        this.OnCell = (int cellNumber, int cellType, Cell Cell, Object RowExcelModel) -> {
            
            CustomerExcelRowModel CustomerExcelRowModel;
            if(RowExcelModel != null){
                CustomerExcelRowModel = (CustomerExcelRowModel)RowExcelModel;
            }
            else{
                CustomerExcelRowModel = new CustomerExcelRowModel();
            }
            
            switch(cellType){
                
                case CELL_TYPE_STRING:
                    
                    if(cellNumber == 0){
                        CustomerExcelRowModel.setCompanyCode(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 1){
                        CustomerExcelRowModel.setName(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 2){
                        CustomerExcelRowModel.setPhone(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 3){
                        CustomerExcelRowModel.setLada(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 4){
                        CustomerExcelRowModel.setCellphone(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 5){
                        CustomerExcelRowModel.setEmail(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 6){
                        CustomerExcelRowModel.setCity(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 7){
                        CustomerExcelRowModel.setEstate(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 8){
                        CustomerExcelRowModel.setCountry(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 9){
                        CustomerExcelRowModel.setStreet(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 10){
                        CustomerExcelRowModel.setColony(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 11){
                        CustomerExcelRowModel.setInteriorNumber(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 12){
                        CustomerExcelRowModel.setExternalNumber(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 13){
                        CustomerExcelRowModel.setWebpage(Cell.getStringCellValue());
                    }
                    else if(cellNumber == 14){
                        CustomerExcelRowModel.setObservations(Cell.getStringCellValue());
                    }
                    
                    break;
                    
                case CELL_TYPE_NUMERIC:
                    break;
            }
            
            return CustomerExcelRowModel;
        };
    }        
}
