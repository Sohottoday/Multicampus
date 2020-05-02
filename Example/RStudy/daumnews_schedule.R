library(rvest)
url<-"http://media.daum.net/ranking/popular"
text4<-read_html(url)

nodes1<-html_nodes(text4,".list_news2>li>.cont_thumb>.tit_thumb>.link_txt")
title<-html_text(nodes1)
title<-gsub(",","",title)
nodes2<-html_nodes(text4, ".info_news")
newsname<-html_text(nodes2)
newsdate <- Sys.Date()

daumnews<-data.frame("제목"=title,"뉴스사"=newsname,'날짜'=newsdate)
headnews<-head(daumnews,5)