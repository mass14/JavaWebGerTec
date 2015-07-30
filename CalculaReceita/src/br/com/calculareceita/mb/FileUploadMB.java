package br.com.calculareceita.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class FileUploadMB {
	
	private UploadedFile file;
	
	public FileUploadMB(){
	
	}
	
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
   	public void doUpload(FileUploadEvent fileUploadEvent){
		
		file = fileUploadEvent.getFile();
		String fileNameUploaded = file.getFileName();
		long fileSizeUploaded = file.getSize();
		String infoAboutFile = "<br/> Arquivo recebido: <b>"
				+fileNameUploaded + "</b><br/>"  
				+"Tamanho do Arquivo:<b>"+ fileSizeUploaded+"</b>";
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage("Sucesso",infoAboutFile));
		
	}
}
