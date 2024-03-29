/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.datamodels.CertificatesDataModel;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 *
 * @author PC
 */
public class CertificatesUtility {
    
    protected CertificatesUtility(){        
    }
    
    public Date getDate(final String filePath) throws Exception {
        
        // use FileInputStream to read the file
        FileInputStream fis = new FileInputStream(filePath);

        // read the bytes
        byte value[] = new byte[fis.available()];
        fis.read(value);
        ByteArrayInputStream bais = new ByteArrayInputStream(value);

        // get X509 certificate factory
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

        // certificate factory can now create the certificate 
        X509Certificate xRes = (X509Certificate)certFactory.generateCertificate(bais);
        return xRes.getNotAfter();
    }
    
    public String validateCertificate( final String certificatePath, 
                                        final String certificateKeyPath,
                                        final String password) throws Exception{
        
        final Date Date = this.getDate(certificatePath);
        
        String error = null;
        Date dtNow    = new java.util.Date();
        if(Date.compareTo(dtNow)<0){
            error = "errors_certdate";
            return error;
        }
        
        final PrivateKey PrivateKey = getPrivateKey(certificateKeyPath, password);
        if(PrivateKey==null){
            error = "errors_certprivatekey";
        }
        
        return error;
    }
    
    
    private PrivateKey getPrivateKey(final String certificateKeyPath, final String password) throws Exception {
        
        FileInputStream in = new FileInputStream(certificateKeyPath);
        org.apache.commons.ssl.PKCS8Key pkcs8 = new org.apache.commons.ssl.PKCS8Key(in, password.toCharArray());
        byte [] decrypted = pkcs8.getDecryptedBytes();
        java.security.spec.PKCS8EncodedKeySpec spec = new java.security.spec.PKCS8EncodedKeySpec(decrypted);
        PrivateKey pk = null;            
        if(pkcs8.isDSA())
            pk = KeyFactory.getInstance("DSA").generatePrivate(spec);
        else if(pkcs8.isRSA())
            pk = KeyFactory.getInstance("RSA").generatePrivate(spec);

        pk = pkcs8.getPrivateKey();
        return pk;        
    }
        
    public CertificatesDataModel copyCertificatesToFoler(   final String companyCode,
                                                            final String appPath, 
                                                            final String certificateFromPath, 
                                                            final String certificateKeyPath) throws Exception {
        
        String rutaCarpeta = appPath + "\\CSD";
        
        //Create the certificates folder
        final FilesUtility FilesUtility = UtilitiesFactory.getSingleton().getFilesUtility();
        if(!FilesUtility.fileExists(rutaCarpeta)){
            FilesUtility.createNewDir(rutaCarpeta);
        }
        
        //Create the company code folder
        rutaCarpeta  += "\\" + companyCode;
        if(!FilesUtility.fileExists(rutaCarpeta)){
            FilesUtility.createNewDir(rutaCarpeta);
        }
                
        String archivoCer = FilesUtility.getFileNameFromPath(certificateFromPath);
        String archivoKey = FilesUtility.getFileNameFromPath(certificateKeyPath);
        
        archivoCer = rutaCarpeta + "\\" + archivoCer;
        archivoKey = rutaCarpeta + "\\" + archivoKey;
        
        FilesUtility.copyFile(certificateFromPath, archivoCer);
        FilesUtility.copyFile(certificateKeyPath, archivoKey);
        
        final CertificatesDataModel CertificatesDataModel = new CertificatesDataModel();
        CertificatesDataModel.setCertificatePath(certificateFromPath);
        CertificatesDataModel.setCertificateKeyPath(certificateKeyPath);
        
        return CertificatesDataModel;
    }
}
