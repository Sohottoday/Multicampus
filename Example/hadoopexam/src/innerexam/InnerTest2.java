package innerexam;
class LocalTest {
   String name = "Java";

   void pr(String s) {
      int su = 100;      
      System.out.println(s + " : " + su);
   
      class Local {		//지금 현재의 메서드 안에서만 쓸 수 있다.
         void pr(String ls) {
            System.out.println("s : " + s);   	// Main Call
            System.out.println("ls : " + ls);   	// Local Call      
            System.out.println(name);        	// Java
            System.out.println(su);				// 100
            //su++;	//su 변수는 final로 인식되기 때문에 오류가 뜬다.
            //inner local class에서는 final형 변수만 사용 가능하다. (지역 변수만 사용 가능)
            //name = "Python";
            //member변수의 변경은 가능하다
         }
      }          
      //su++; //바깥에서 su를 변경시킨다는 뜻은 final로 쓰지 않겠다는 것을 의미한다. 따라서 inner local클래스에서 사용하지 않겠다는 의미이다.(사용 불가)
      Local lt = new Local();
      lt.pr("Local Call");
   }
}   
public class InnerTest2 {
   public static void main(String args[]) {
      LocalTest l = new LocalTest();
      l.pr("Main Call");
   }
}





