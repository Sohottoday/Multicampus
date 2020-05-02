#다음의 요구 사항대로 구현하고 모든 소스와 생성된 csv 파일을 제출한다.
#다음은 https://comic.naver.com/genre/bestChallenge.nhn 사이트의 콘텐츠 일부이다.
#박스로 표시된 내용을 추출하고 “comicName,  comicSummary, comicGrade” 
#열명으로 DataFrame을 생성하여
#navercomic.csv로 저장하고 소스는 navercomic.R로 저장한다. 
#모든 페이지를 크롤링하고 스크래핑한다.

site<-"https://comic.naver.com/genre/bestChallenge.nhn?&page="
text<-NULL
comic<-NULL
comicall<-NULL
for(n in 1:200){
  url<-paste(site,n,sep="")
  text<-read_html(url)
  nodes1 <- html_nodes(text,".challengeInfo>.challengeTitle")
  comicName <- html_text(nodes1)
  nodes2 <- html_nodes(text, ".challengeInfo>.summary")
  comicSummary <- html_text(nodes2)
  nodes3 <- html_nodes(text, ".challengeInfo>.rating_type>strong")
  comicGrade <- html_text(nodes3)
  comic<-cbind(comicName,comicSummary,comicGrade)
  comicall<-rbind(comicall,comic)
  
}
write.csv(comicall, file="navercomic.csv")

