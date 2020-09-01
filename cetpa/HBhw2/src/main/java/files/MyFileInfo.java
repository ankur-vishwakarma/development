package files;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Table(name="my_files")
@Entity
public class MyFileInfo 
{
	private String fileName;
	private int fileSize;
	private byte[] fileData;

	@Id
	@Column(name="file_name",length=100)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="file_size",nullable=false)
	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	@Lob
	@Column(name="file_data")
	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public MyFileInfo() {
	}
}