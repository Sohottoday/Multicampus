package rjavaapp;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab1 {
	public static void getHotel() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		rc.eval("library(KoNLP)");
		rc.eval("word_data<-readLines('c:/Sohottoday/Rstudy/hotel.txt')");
		rc.eval("word_data2 <- extractNoun(word_data)");
		rc.eval("word_data3 <- unlist(word_data2)");
		rc.eval("word_data3 <- gsub('[A-z[:punct:]]','',word_data3)");
		rc.eval("word_data3 <- unlist(word_data3)");
		rc.eval("word_data3 <- Filter(function(x){nchar(x)>=2}, word_data3)");
		rc.eval("result1 <- NULL");
		rc.eval("result1 <- table(word_data3)");
		rc.eval("result2 <- sort(result1,decreasing = T)");
		rc.eval("result3 <- head(result2,10)");
		REXP x = rc.eval("result10 <- names(result3)");
		String[] s = x.asStrings();
		for(int n=0; n<s.length ; n++) {
			System.out.print(s[n]+" ");
		}	
		rc.close();
	}
	public static void main(String[] args) throws REXPMismatchException, REngineException {
		System.out.print("R이 보내온 최빈 명사 : ");
		JavaRLab1.getHotel();
	}
}
