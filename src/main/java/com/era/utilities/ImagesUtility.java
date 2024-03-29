/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

import com.era.utilities.exceptions.InvalidFileExtensionException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class ImagesUtility extends BaseUtility {
    
    private String appPath;
    
    private String imagesPath;
    private String productsPath;
    private String linesPath;
    private String ftechnicalPath;
    private String logoCompanyPath;
    private String logoLocalPath;
    private String usersPath;
    
    private String remsPath;
    private String cortxPath;
    private String cortzPath;
    private String notcPath;
    private String invoicesPath;
    private String ticketsPath;
    private String cancelsPath;
    private String devsPath;
    private String devspPath;
    private String acusesPath;
    
    
    
    protected ImagesUtility(){
    }
    
    public ImageIcon getImageIconScaledFromPath(final String pathImage, int w, int h){
        
        final ImageIcon ImageIcon = new ImageIcon(new ImageIcon(pathImage).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        return ImageIcon;
    }
    
    public ImageIcon scaleImage(ImageIcon ImageIcon, int w, int h){
        
        //Scale image
        java.awt.Image im = ImageIcon.getImage(); 
        java.awt.Image newimg = im.getScaledInstance( w, h,  java.awt.Image.SCALE_SMOOTH );  
        ImageIcon = new ImageIcon(newimg);
        
        //Return imageicon scaled
        return ImageIcon;
    }
    
    public void init(final String companyCode){
        this.appPath = System.getProperty("user.dir");
        
        remsPath = appPath + "\\Remisiones";
        if(!new File(remsPath).exists()){
            new File(remsPath).mkdir();
        }
        remsPath = remsPath + "\\" + companyCode;
        if(!new File(remsPath).exists()){
            new File(remsPath).mkdir();
        }
        
        cortxPath = appPath + "\\Cortes X";
        if(!new File(cortxPath).exists()){
            new File(cortxPath).mkdir();
        }
        cortxPath = cortxPath + "\\" + companyCode;
        if(!new File(cortxPath).exists()){
            new File(cortxPath).mkdir();
        }
        
        cortzPath = appPath + "\\Cortes Z";
        if(!new File(cortzPath).exists()){
            new File(cortzPath).mkdir();
        }
        cortzPath = cortzPath + "\\" + companyCode;
        if(!new File(cortzPath).exists()){
            new File(cortzPath).mkdir();
        }
        
        notcPath = appPath + "\\Notas credito";
        if(!new File(notcPath).exists()){
            new File(notcPath).mkdir();
        }
        notcPath = notcPath + "\\" + companyCode;
        if(!new File(notcPath).exists()){
            new File(notcPath).mkdir();
        }
        
        invoicesPath = appPath + "\\Facturas";
        if(!new File(invoicesPath).exists()){
            new File(invoicesPath).mkdir();
        }
        invoicesPath = invoicesPath + "\\" + companyCode;
        if(!new File(invoicesPath).exists()){
            new File(invoicesPath).mkdir();
        }
        
        ticketsPath = appPath + "\\Tickets";
        if(!new File(ticketsPath).exists()){
            new File(ticketsPath).mkdir();
        }
        ticketsPath = ticketsPath + "\\" + companyCode;
        if(!new File(ticketsPath).exists()){
            new File(ticketsPath).mkdir();
        }
        
        cancelsPath = appPath + "\\Cancelados";
        if(!new File(cancelsPath).exists()){
            new File(cancelsPath).mkdir();
        }
        cancelsPath = cancelsPath + "\\" + companyCode;
        if(!new File(cancelsPath).exists()){
            new File(cancelsPath).mkdir();
        }
        
        devsPath = appPath + "\\Devoluciones";
        if(!new File(devsPath).exists()){
            new File(devsPath).mkdir();
        }
        devsPath = devsPath + "\\" + companyCode;
        if(!new File(devsPath).exists()){
            new File(devsPath).mkdir();
        }
        
        devspPath = appPath + "\\Devoluciones Parciales";
        if(!new File(devspPath).exists()){
            new File(devspPath).mkdir();
        }
        devspPath = devspPath + "\\" + companyCode;
        if(!new File(devspPath).exists()){
            new File(devspPath).mkdir();
        }
        
        acusesPath = appPath + "\\Acuses";
        if(!new File(acusesPath).exists()){
            new File(acusesPath).mkdir();
        }
        acusesPath = acusesPath + "\\" + companyCode;
        if(!new File(acusesPath).exists()){
            new File(acusesPath).mkdir();
        }
        
        imagesPath = appPath + "\\Imagenes";
        if(!new File(imagesPath).exists()){
            new File(imagesPath).mkdir();
        }
        imagesPath = imagesPath + "\\" + companyCode;
        if(!new File(imagesPath).exists()){
            new File(imagesPath).mkdir();
        }
        
        productsPath = imagesPath + "\\Productos";
        if(!new File(productsPath).exists()){
            new File(productsPath).mkdir();
        }
        
        linesPath = imagesPath + "\\Lineas";
        if(!new File(linesPath).exists()){
            new File(linesPath).mkdir();
        }
        
        ftechnicalPath = appPath + "\\FTecnica";
        if(!new File(ftechnicalPath).exists()){
            new File(ftechnicalPath).mkdir();
        }
        ftechnicalPath = ftechnicalPath + "\\" + companyCode;
        if(!new File(ftechnicalPath).exists()){
            new File(ftechnicalPath).mkdir();
        }
        
        logoCompanyPath = appPath + "\\Logotipo Empresa";
        if(!new File(logoCompanyPath).exists()){
            new File(logoCompanyPath).mkdir();
        }
        logoCompanyPath = logoCompanyPath + "\\" + companyCode;
        if(!new File(logoCompanyPath).exists()){
            new File(logoCompanyPath).mkdir();
        }
        
        logoLocalPath = appPath + "\\Imagenes Sistema";        
                
        usersPath = imagesPath + "\\Usuarios";
        if(!new File(usersPath).exists()){
            new File(usersPath).mkdir();
        }
    }
    
    public void saveImageFromUrl(final String productCode, final String fromUrl) throws IOException {
        
        String folderPath = productsPath + "\\" + productCode;
        
        if(!new File(folderPath).exists()){
            new File(folderPath).mkdir();
        }
        
        String prodPath = folderPath + "\\image.png";
        
        saveImageToFile(fromUrl,prodPath);
    }

    public String getAppPath() {
        return appPath;
    }

    public String getRemsPath() {
        return remsPath;
    }

    public String getCortxPath() {
        return cortxPath;
    }

    public String getCortzPath() {
        return cortzPath;
    }

    public String getNotcPath() {
        return notcPath;
    }

    public String getInvoicesPath() {
        return invoicesPath;
    }

    public String getTicketsPath() {
        return ticketsPath;
    }

    public String getCancelsPath() {
        return cancelsPath;
    }

    public String getAcusesPath() {
        return acusesPath;
    }
        
    
    
    public void openRemsPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(remsPath);
    }
    public void openCortxPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(cortxPath);
    }
    public void openCortzPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(cortzPath);
    }
    public void openNotcPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(notcPath);
    }
    public void openInvoicesPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(invoicesPath);
    }
    public void openTicketsPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(ticketsPath);
    }
    public void openCancelsPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(cancelsPath);
    }
    public void openDevsPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(devsPath);
    }
    public void openDevspPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(devspPath);
    }
    public void openAcusesPath() throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(acusesPath);
    }
    
    public void openImageInVisor(final String imagePath) throws IOException {
        UtilitiesFactory.getSingleton().getDesktopUtility().open(imagePath);        
    }
    
    private void saveImageToFile(String imageUrl, String destinationFile) throws IOException {
        
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
    
    public String getFTecnicalProductPath(final String productCode) throws Exception {
        
        final String path = ftechnicalPath + "\\" + productCode;
        
        //Get the path to the technical file
        final String pathToFile = UtilitiesFactory.getSingleton().getFilesUtility().getFirstFilePathFromPath(path);
        
        //Return the path
        return pathToFile;
    }
    public void saveFTecnicaProduct(final String productCode, final String fromPath) throws Exception {
        
        String prodPath = ftechnicalPath + "\\" + productCode;
        
        if(!new File(prodPath).exists()){
            new File(prodPath).mkdir();
        }
                
        if(fromPath.endsWith(".pdf")){
            prodPath += "\\ftecnica.pdf";
        }
        else if(fromPath.endsWith(".docx")){
            prodPath += "\\ftecnica.docx";
        }
        else{
            throw new InvalidFileExtensionException();
        }
                
        if(!new File(fromPath).exists()){
            throw new FileNotFoundException();
        }
        
        copyFileUsingStream(new File(fromPath), new File(prodPath));
    }
    public void deleteFTechnicalProduct(final String productCode) throws Exception {
        
        //Path to the technical product file folder
        final String path = ftechnicalPath + "\\" + productCode;
        
        //Get the path to the technical file
        final String pathToFile = UtilitiesFactory.getSingleton().getFilesUtility().getFirstFilePathFromPath(path);
        
        if(!new File(pathToFile).exists()){
            throw new FileNotFoundException();
        }
        
        new File(pathToFile).delete();                
    }
    public boolean FTechnicalProductExists(final String productCode) throws Exception {
        
        final String path = ftechnicalPath + "\\" + productCode;
        
        if(!new File(path).exists()){
            new File(path).mkdir();
        }
        
        //Get the path to the technical file
        final String pathToFile = UtilitiesFactory.getSingleton().getFilesUtility().getFirstFilePathFromPath(path);
        
        return pathToFile!=null;
    }
    
    public void saveLineImage(final String lineCode, final String fromPath) throws IOException {
        
        String prodPath = linesPath + "\\" + lineCode;
        
        if(!new File(prodPath).exists()){
            new File(prodPath).mkdir();
        }
        
        prodPath += "\\image.png";
                
        if(!new File(fromPath).exists()){
            throw new FileNotFoundException();
        }
        
        copyFileUsingStream(new File(fromPath), new File(prodPath));
    }
    
    public void saveCompanyLogoImage(final String fromPath) throws IOException {
        
        String filePath = logoCompanyPath + "\\image.png";
        copyFileUsingStream(new File(fromPath), new File(filePath));
    }
    public void removeCompanyLogoImage() throws Exception {
        
        String filePath = logoCompanyPath + "\\image.png";
        UtilitiesFactory.getSingleton().getFilesUtility().deleteFile(filePath);
    }
    
    public String getCompanyLogoImagePath(){
        
        final String companyImagePath = logoCompanyPath + "\\image.png";        
        return companyImagePath;
    }
    
    public String getLocalLogoImagePath(){
        
        final String path = logoLocalPath + "\\logo_era.png";        
        return path;
    }
    
    public boolean companyLogoImageExists(){
        
        final String companyImagePath = logoCompanyPath + "\\image.png";
        return UtilitiesFactory.getSingleton().getFilesUtility().fileExists(companyImagePath);
    }
    
    public void saveProductImage(final String productCode, final String fromPath) throws IOException {
        
        String prodPath = productsPath + "\\" + productCode;
        
        if(!new File(prodPath).exists()){
            new File(prodPath).mkdir();
        }
        
        prodPath += "\\image.png";
                
        if(!new File(fromPath).exists()){
            throw new FileNotFoundException();
        }
        
        copyFileUsingStream(new File(fromPath), new File(prodPath));
    }
    public void deleteProductImage(final String productCode) throws IOException {
        
        String prodPath = productsPath + "\\" + productCode + "\\image.png";
        
        if(!new File(prodPath).exists()){
            throw new FileNotFoundException();
        }
        
        new File(prodPath).delete();                
    }
    public void deleteLineImage(final String lineCode) throws IOException {
        
        String prodPath = linesPath + "\\" + lineCode + "\\image.png";
        
        if(!new File(prodPath).exists()){
            throw new FileNotFoundException();
        }
        
        new File(prodPath).delete();                
    }
    public boolean productImageExists(final String productCode) throws IOException {
        
        String prodPath = productsPath + "\\" + productCode + "\\image.png";
        
        if(new File(prodPath).exists()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean lineImageExists(final String lineCode) throws IOException {
        
        String prodPath = linesPath + "\\" + lineCode + "\\image.png";
        
        if(new File(prodPath).exists()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public ImageIcon getProductImagePathImageIcon(final String productCode){
        return new ImageIcon(getProductImagePath(productCode));
    }
        
    public String getProductImagePath(final String productCode){
        
        final String prodPath = productsPath + "\\" + productCode + "\\image.png";
        return prodPath;
    }
   
    public String getLineImagePath(final String lineCode){
        
        final String prodPath = linesPath + "\\" + lineCode + "\\image.png";
        return prodPath;
    }
    
    public ImageIcon getLineImagePathImageIcon(final String lineCode){
        return new ImageIcon(getLineImagePath(lineCode));        
    }
    
    public void saveUserImage(final String user, final String fromPath) throws IOException {
        
        //Users specific code path should exist
        String userCodePath = usersPath + "\\" + user;
        if(!new File(userCodePath).exists()){
            new File(userCodePath).mkdir();
        }
        
        //Complete final path
        userCodePath += "\\image.png";
                
        //The source image should exist
        if(!new File(fromPath).exists()){
            throw new FileNotFoundException();
        }
        
        //Save the image
        copyFileUsingStream(new File(fromPath), new File(userCodePath));
    }
    public void deleteUserImage(final String user) throws IOException {
        
        String userPath = usersPath + "\\" + user + "\\image.png";
        
        if(!new File(userPath).exists()){
            throw new FileNotFoundException();
        }
        
        new File(userPath).delete();                
    }
    public boolean usersImageExists(final String user) throws IOException {
        
        String userPath = usersPath + "\\" + user + "\\image.png";
        
        if(new File(userPath).exists()){
            return true;
        }
        else{
            return false;
        }
    }
    public ImageIcon getUserImagePathImageIcon(final String productCode){
        final ImageIcon ImageIcon = new ImageIcon(getUserImagePath(productCode));
        ImageIcon.getImage().flush();
        return ImageIcon;
    }
    public String getUserImagePath(final String user){
        
        final String userPath = usersPath + "\\" + user + "\\image.png";        
        return userPath;
    }
    
    private void copyFileUsingStream(File source, File dest) throws IOException {
        
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }        
}
