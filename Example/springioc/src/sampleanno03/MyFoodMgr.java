package sampleanno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood")  //default : myFoodMgr
public class MyFoodMgr{
	@Autowired			//알아서 빈 객체를 적용하라는 뜻
	//@Qualifier(value="unFavoriteFood")
	private Food favoriteFood;     // setter - Can be omitted
	@Autowired
	private Food unFavoriteFood;
	                 
	
	@Override
	public String toString() {
		return "[Food1=" + favoriteFood + ", Food2=" + unFavoriteFood + "]";
	}
}
