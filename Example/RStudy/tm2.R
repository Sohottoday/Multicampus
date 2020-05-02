 #텍스트마이닝 실습(2) 

#제공된 “공구.txt” 파일의 내용을 읽고 명사만 뽑아내서 전처리한 다음 많이 등장한
#단어 순으로 다음과 같이 워드클라우딩 하는 R 코드를 작성하여 tm2.R 로 그리고
#워드 클라우딩 결과는 wc.png 로 저장하여 제출하시오. 이미지이므로 기본 그래프를
#저장하는 방법과 동일하다. 가장 많이 등장한 단어의 크기가 가장 크게 처리하고
#점점 작아지게 하면 되며 칼라나 폰트의 종류 그리고 크기는 다르게 하더라도
#출력되는 단어의 구성은 최대한 맞춰본다. 한 글자는 제외한다. 
#그리고 전처리시 숫자, 특수문자 그리고 영어 등은 모두 삭제한다. 


gonggu <- readLines("data/공구.txt",encoding = "UTF-8")
gonggu1 <- extractNoun(gonggu)
gonggu1 <- unlist(gonggu1)
gonggu2 <- gsub("[^가-힣]","",gonggu1)         # gsub와 grep 할때의 값이 다름.
#gonggu2 <- grep("[가-힣]",gonggu1,value=T)   # [가-힣]을 했음에도 특문이 뽑힘 ^^ 같은것.
gonggu3 <- gsub("공구|해주","",gonggu2)
gonggu3 <- Filter(function(x){nchar(x)>=2},gonggu3)
gonggu4 <- table(gonggu3)
gonggu4 <- sort(gonggu4,decreasing = T)
wordwc <- data.frame(gonggu4)
install.packages("RColorBrewer")
library(RColorBrewer)
library(wordcloud)
windowsFonts(lett=windowsFont("휴먼옛체"))
wordcloud(wordwc$gonggu3,wordwc$Freq,
          min.freq = 1, random.order = FALSE, rot.per = 0.2, 
          scale = c(5,1), colors = brewer.pal(7,"Set1"),family="lett")

dev.copy(png, "wc.png")
dev.off()
