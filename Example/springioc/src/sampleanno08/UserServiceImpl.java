package sampleanno08;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component("userService")   //기본값 : userServiceImpl
public class UserServiceImpl implements UserService{
	//or @Autowired
	@Resource //변수명과 동일한걸 찾고 하나있으면 주입한다. 두개 이상이면 에러 , 멤버란 이름이 없고 user객체를 찾아서 하나면 주입하고 2개 이상이면 noUiqueException, 없으면 noSearchException
	User member;
	
	public void setMember(User member) {
		this.member = member;
	}

	@Override
	public void addUser() {
		System.out.println("Added member : " + member.getUserName());
	}
}
