package sampleanno04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //
public class Engineer {
//	@Autowired // 1.타입 2. 이름순으로 찾아서 같은걸 집어넣음
	//@Qualifier("emp1") // 조금 더 확실하게 이름에 맞는걸 집어넣음 / 우선순위 조금 더 높음
	@Resource(name="emp1") //보이는 그대로 맞는것을 집어넣음..      여기서 말하는 객체는 모두 bean객체를 의미함.
	private Emp emp;
	private String dept;
	
	public Engineer() {
		super();
	}
	@Autowired
	public void ddd(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp.toString()+"\n"+ "and works at the "+dept+" department.";
	
	}
}








