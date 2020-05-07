package exam3;

import org.springframework.stereotype.Component;

@Component("afternoon")
public class AfternoonGreetingImpl implements Greeting{
	@Override
	public void greet() {
		System.out.println("상쾌한 아침입니다");
	}
}