/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.utilities;

/**
 *
 * @author PC
 */
public class UtilitiesFactory {

    private static UtilitiesFactory UtilityManager;
    private ImagesUtility ImagesUtility;
    private SecurityUtil SecurityUtil;
    private GeneralsUtility GeneralsUtility;
    private FileChooserUtility FileChooserUtility;
    private DialogPropertiesUitlity DialogPropertiesUitlity;
    private FilesUtility FilesUtility;
    private CertificatesUtility CertificatesUtility;
    private SessionUtility SessionUtility;
    private PathsUtility PathsUtility;
    private IconsUtility IconsUtility;
    private DateTimeUtility DateTimeUtility;
    
    
    private UtilitiesFactory(){
    }
   
    public static UtilitiesFactory getSingleton(){
        if(UtilityManager==null){
            UtilityManager = new UtilitiesFactory();
        }
        return UtilityManager;
    }

    public ImagesUtility getImagesUtility(){
        if(ImagesUtility==null){
            ImagesUtility = new ImagesUtility();
        }
        return ImagesUtility;
    }
    
    public SecurityUtil getSecurityUtil(){
        if(SecurityUtil==null){
            SecurityUtil = new SecurityUtil();
        }
        return SecurityUtil;
    }
    
    public GeneralsUtility getGeneralsUtility(){
        if(GeneralsUtility==null){
            GeneralsUtility = new GeneralsUtility();
        }
        return GeneralsUtility;
    }
    
    public FileChooserUtility getFileChooserUtility(){
        if(FileChooserUtility==null){
            FileChooserUtility = new FileChooserUtility();
        }
        return FileChooserUtility;
    }

    public DialogPropertiesUitlity getDialogPropertiesUitlity(){
        if(DialogPropertiesUitlity==null){
            DialogPropertiesUitlity = new DialogPropertiesUitlity();
        }
        return DialogPropertiesUitlity;
    }
    
    public FilesUtility getFilesUtility(){
        if(FilesUtility==null){
            FilesUtility = new FilesUtility();
        }
        return FilesUtility;
    }
    
    public CertificatesUtility getCertificatesUtility(){
        if(CertificatesUtility==null){
            CertificatesUtility = new CertificatesUtility();
        }
        return CertificatesUtility;
    }
    
    public SessionUtility getSessionUtility(){
        if(SessionUtility==null){
            SessionUtility = new SessionUtility();
        }
        return SessionUtility;
    }
    
    public PathsUtility getPathsUtility(){
        if(PathsUtility==null){
            PathsUtility = new PathsUtility();
        }
        return PathsUtility;
    }
    
    public IconsUtility getIconsUtility(){
        if(IconsUtility==null){
            IconsUtility = new IconsUtility();
        }
        return IconsUtility;
    }
    
    public DateTimeUtility getDateTimeUtility(){
        if(DateTimeUtility==null){
            DateTimeUtility = new DateTimeUtility();
        }
        return DateTimeUtility;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
