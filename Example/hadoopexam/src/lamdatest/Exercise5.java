package lamdatest;

interface ActionExpression {
	void exec(Object... param);
}

interface FuncExpression<T> {
	T exec(Object... param);
}

public class Exercise5 {
	public static void Test1(ActionExpression action) {
		action.exec("hello world");
	}

	public static void Test2(FuncExpression<String> func) {
		String ret = func.exec("hello world");
		System.out.println(ret);
	}

	public static void main(String[] args) throws Exception {

		Test1((action)->{
			System.out.println(action[0]);
		});
		
		Test2((asaf)-> {		//잘못이해하고 있었음 R처럼 하는것임. 기존의 변수를 쓰는것이 아닌 새로운 변수라고 생각하면 쉬움.
			System.out.println(asaf[0]);
			return "OK";
			
		});

		
		
		
		
//		Test1(new ActionExpression() {
//			public void exec(Object... data) {
//				System.out.println("Test1 - " + data[0]);
//			}
//		});
//		Test2(new FuncExpression<String>() {
//			public String exec(Object... data) {
//				System.out.println(data[0]);
//				return "OK";
//			}
//		});
	}
}
