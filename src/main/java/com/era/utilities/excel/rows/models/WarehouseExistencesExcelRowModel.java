/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel.rows.models;

/**
 *
 * @author PC
 */
public class WarehouseExistencesExcelRowModel {
    
    private String warehouseCode;
    private String productCode;
    private double existence;

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getExistence() {
        return existence;
    }

    public void setExistence(double existence) {
        this.existence = existence;
    }

    
    
    
    
}
