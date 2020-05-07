package rjavaapp;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab2 {
	public static void getHotelDataFrame() throws RserveException, REXPMismatchException{
		RConnection rc = new RConnection();
		REXP x = rc.eval("bravo_hotel<-source('c:/Sohottoday/Rstudy/lab.R',encoding='UTF-8'); bravo_hotel$value");
		RList list = x.asList();
		String[] hotel = list.at("koreasong3").asStrings();
		for(int n=0 ; n<hotel.length ; n++) {
			System.out.println(hotel[n]);
		}
		
		rc.close();
	}
	public static void main(String[] args) throws REXPMismatchException, REngineException {
	System.out.println("R이 보내온 최빈 명사들 : ");
	JavaRLab2.getHotelDataFrame();
	}
}
