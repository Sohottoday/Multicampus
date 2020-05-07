package sampleanno09;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")     //싱글톤으로 쓰는게 아닌 요청할때마다 만드는 프로토타입으로 실행       
public class MyMessage {
	String message;
	
	public MyMessage(){
		System.out.println("Create object");
		message="Good day!!";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}
