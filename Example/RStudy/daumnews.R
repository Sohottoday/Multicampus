#다음에 제시된 웹 페이지는 다음뉴스의 랭킹페이지이다.
#(http://media.daum.net/ranking/popular/)
#이 페이지에서 각 뉴스의 제목과 이 뉴스를 올린 신문사명칭을 스크래핑(50개)하여
#newstitle, newspapername 형식의 데이터프레임을 만들어 
#CSV 파일로 저장한다.(daumnews.csv)
#
#파일명 : daumnews.R

url<-"http://media.daum.net/ranking/popular"
text4<-read_html(url)


nodes1<-html_nodes(text4,".list_news2>li>.cont_thumb>.tit_thumb>.link_txt")
title<-html_text(nodes1)
nodes2<-html_nodes(text4, ".info_news")
newsname<-html_text(nodes2)

daumnews<-data.frame("제목"=title,"뉴스사"=newsname)
write.csv(daumnews,file = "daumnews.csv")
