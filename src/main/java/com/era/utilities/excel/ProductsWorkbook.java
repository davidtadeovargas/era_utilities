/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel;

import com.era.utilities.excel.rows.ProductExcelRow;

/**
 *
 * @author PC
 */
public class ProductsWorkbook extends Workbook{

    public ProductsWorkbook() {
        super(new ProductExcelRow());
    }
}
