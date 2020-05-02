#  텍스트마이닝 실습(1) 
#hotel.txt를 읽고 제일 많이 나온 명사 10개를 명칭과 횟수(내림차순)로
#구성되는 데이터프레임을 생성해서 hotel_top_word.csv 로 저장한다.
#작성된 R 소스는 tm1.R 저장한 후에 tm1.R 과 hotel_top_word.csv 을 제출한다.

koreasong <- readLines("c:/Sohottoday/Rstudy/hotel.txt")
koreasong
koreasong2 <-extractNoun(koreasong)

koreasong3 <- unlist(koreasong2)
koreasong3 <- gsub("[A-z[:punct:]]","",koreasong3)
koreasong3 <- unlist(koreasong3)
koreasong3 <- Filter(function(x){nchar(x)>=2}, koreasong3)
result1 <- NULL
result1 <- table(koreasong3)
result2 <- sort(result1, decreasing = T)
result3 <- head(result2, 10)
result10 <- names(result3)
result4 <- as.data.frame(result3)
result4
str(result3)
result4[1]
write.csv(result3, "hotel_top_word.csv")


