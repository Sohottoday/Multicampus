package sampleanno06;

import org.springframework.stereotype.Component;

@Component("samsung")  //삼성이라는 객체를 생성한것
public class SamsungTv implements Tv{

	@Override
	public void powerOn() {
		System.out.println("SAMSUNG TV - Power On");
	}

	@Override
	public void powerOff() {
		System.out.println("SAMSUNG TV - Power Off");
	}

	@Override
	public void volumeUp() {
		System.out.println("SAMSUNG TV - Volume Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("SAMSUNG TV - Volume Down");
	}

}
