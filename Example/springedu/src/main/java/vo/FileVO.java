package vo;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private MultipartFile uploadFile; // 파일 여러개를 받고 싶을때는 MultipartFile[] 이런식으로 배열로 선언

	public MultipartFile getUploadFile() {		
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
