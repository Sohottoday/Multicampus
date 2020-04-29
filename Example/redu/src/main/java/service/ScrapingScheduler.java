package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScrapingScheduler {
		int newscnt=1;
	@Scheduled(fixedDelay=300000)
	public void schedule5min() throws RserveException, REXPMismatchException {
		RConnection r = new RConnection();
		REXP x = r.eval("newsdaum<-source('c:/Sohottoday/Rstudy/daumnews_schedule.R',encoding='UTF-8'); newsdaum$value");
		RList list = x.asList();
		String[] newstitle = list.at("제목").asStrings();
		String[] newspapername = list.at("뉴스사").asStrings();
		String[] newsdate = list.at("날짜").asStrings();
		
		FileWriter writer = null;
		String filepath = "c:/Sohottoday/RStudy";
		File file = new File(filepath);
		if(!file.exists()) {
			file.mkdir();
		}
		try {
			writer = new FileWriter("c:/Sohottoday/Rstudy/daumnews_schedule.csv",true);
			if(newscnt==1) {
			writer.write("뉴스 제목"+","+"뉴스사"+","+"날짜"+"\r\n");
			}
			newscnt+=1;
			
			for(int n=0 ; n<newstitle.length; n++) {
				writer.write(newstitle[n]+","+newspapername[n]+","+newsdate[n]+"\r\n");
			}
			System.out.println("업데이트 완료");
		} catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } finally {
            try {
            	if (writer != null)
            		writer.close();
            } catch (Exception e) {
            	System.out.println("파일을 닫는동안 오류 발생!!");
            }
        }
			r.close();		
	}
}
// 저런식으로 지역변수 +1로 설정하게 된다면 서버가 종료된 후 다시 가동될때 제목이 다시 들어가게 된다. 이러한 부분을 보완하는 방법을 생각해 보자.

/*
 * r = new RConnection(); r.eval("library(rvest)");
 * r.eval("url<-'http://media.daum.net/ranking/popular'");
 * r.eval("newstext<-read_html(url)"); r.eval(
 * "nodes1<-html_nodes(newstext,'.list_news2>li>.cont_thumb>.tit_thumb>.link_txt')"
 * ); r.eval("newstitle<-html_text(nodes1)");
 * r.eval("nodes2<-html_nodes(newstext,'.info_news')");
 * r.eval("newspapername<-html_text(nodes2)"); r.eval("datetime<-Sys.Date()");
 * r.eval(
 * "daumnews<-data.frame('뉴스제목'=newstitle,'신문사명'=newspapername,'날짜'=datetime)");
 * r.eval("headnews<-head(daumnews,5)"); r.eval()
 * r.eval("othernews<-totalnews");
 * r.eval("totalnews<-rbind(totalnews,headnews)");
 * r.eval("write.csv(totalnews, file='daumnews_schedule.csv')");
 */