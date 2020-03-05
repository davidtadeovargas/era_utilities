/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities.models;

/**
 *
 * @author PC
 */
public class BDConf {
    
    /*Declara variables de la base de datos remota*/
    public String sInst;
    public String sUsr;
    public String sContra;
    public String sBD; 
    public String sPort; 
    
    /*Variable que contendrá la sucursal*/
    public String sSucur;
    
    /*Variabl que contendrá el nùmero de caja*/
    public String sNumCaj;
    
    /*Variable que contendrá el nombre de la empresa*/
    public String sNombEmp;
    
    /*Variable que contendrá si es estación de trabajo o no*/
    public String sEstacTrab;
    
    /*Declara variables de la base de datos local temporal*/
    public String sInstLoc;
    public String sUsrLoc;
    public String sContraLoc;
    public String sPortLoc;

    public String getsInst() {
        return sInst;
    }

    public void setsInst(String sInst) {
        this.sInst = sInst;
    }

    public String getsUsr() {
        return sUsr;
    }

    public void setsUsr(String sUsr) {
        this.sUsr = sUsr;
    }

    public String getsContra() {
        return sContra;
    }

    public void setsContra(String sContra) {
        this.sContra = sContra;
    }

    public String getsBD() {
        return sBD;
    }

    public void setsBD(String sBD) {
        this.sBD = sBD;
    }

    public String getsPort() {
        return sPort;
    }

    public void setsPort(String sPort) {
        this.sPort = sPort;
    }

    public String getsSucur() {
        return sSucur;
    }

    public void setsSucur(String sSucur) {
        this.sSucur = sSucur;
    }

    public String getsNumCaj() {
        return sNumCaj;
    }

    public void setsNumCaj(String sNumCaj) {
        this.sNumCaj = sNumCaj;
    }

    public String getsNombEmp() {
        return sNombEmp;
    }

    public void setsNombEmp(String sNombEmp) {
        this.sNombEmp = sNombEmp;
    }

    public String getsEstacTrab() {
        return sEstacTrab;
    }

    public void setsEstacTrab(String sEstacTrab) {
        this.sEstacTrab = sEstacTrab;
    }

    public String getsInstLoc() {
        return sInstLoc;
    }

    public void setsInstLoc(String sInstLoc) {
        this.sInstLoc = sInstLoc;
    }

    public String getsUsrLoc() {
        return sUsrLoc;
    }

    public void setsUsrLoc(String sUsrLoc) {
        this.sUsrLoc = sUsrLoc;
    }

    public String getsContraLoc() {
        return sContraLoc;
    }

    public void setsContraLoc(String sContraLoc) {
        this.sContraLoc = sContraLoc;
    }

    public String getsPortLoc() {
        return sPortLoc;
    }

    public void setsPortLoc(String sPortLoc) {
        this.sPortLoc = sPortLoc;
    }
}
