/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.excel;

import com.era.utilities.excel.rows.SuppliersExcelRow;

/**
 *
 * @author PC
 */
public class SuppliersWorkbook extends Workbook{

    public SuppliersWorkbook() {
        super(new SuppliersExcelRow());
    }
}
