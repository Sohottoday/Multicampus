package lamdaexam;

public class UsingLocalVariable {
	void test_method(int arg) {  
		int localVar = 40; 	
		
		//arg = 31;  		
		//localVar = 41; 
		
		System.out.println(arg + ":" + localVar);
        
		//람다식
		MyFunctionalInterface5 fi= () -> {
			//로컬변수 사용
			System.out.println("arg: " + arg); 
			System.out.println("localVar: " + localVar + "\n");
		};
		fi.method5();
	}
}

