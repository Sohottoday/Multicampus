package lamdaexam;

public class MyFunctionalExam1 { 
	public static void main(String[] args) {
		MyFunctionalInterface1 fi;
		
		MyFunctionalInterface1.pr();
		fi= () -> { 
			String str = "method call1";
			System.out.println(str);
		};	//자식 클래스의 스펙을 지정해줌. 람다식으로 적용
		fi.method1();
		
		fi = new MyFunctionalInterface1 () {
			public void method1() {
				System.out.println("method call2"); 
			}
		};	//자식 클래스의 스펙을 지정해줌. 어노미넌스 방식으로 적용		
		fi.method1();		
	}
}











