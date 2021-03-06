# 텍스트마이닝 실습(3) 

#크롤링 시간에 크롤링 해놓은 “yes24.txt” 파일의 내용을 읽고 명사만 뽑아내
#많이 등장한 단어 순으로 다음과 같이 워드클라우딩 하는 R 코드를 작성하여
#tm3.R 로 그리고 워드 클라우딩 결과는 wc.html 로 저장하여 제출하시오. 
#단, 단어의 길이가 2자~4자로 제한한다.
#result<-wordcloud2(……………………………………)
#library("htmlwidgets") # 없으면 설치
#saveWidget(result,"wc.html",title="WORDCLOUD2 실습", selfcontained = F)

yes24 <- readLines("data/yes24.txt")
yes24
wow_yes24 <- extractNoun(yes24)
wow_yes24 <- unlist(wow_yes24)
wow_yes24 <- gsub("[^가-힣]","",wow_yes24)
textout_yes24 <- Filter(function(x){nchar(x)>=2 & nchar(x) <=4}, wow_yes24)
textout_yes <- table(textout_yes24)
textout_yes <- sort(textout_yes,decreasing = T)

result <- wordcloud2(textout_yes,,fontFamily = "휴먼옛체",color = brewer.pal(12,"Paired"))
saveWidget(result, "wc.html",selfcontained = F)

