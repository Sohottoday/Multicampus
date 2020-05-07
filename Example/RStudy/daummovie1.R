#다음영화 사이트에 올려진 (http://movie.daum.net/) 댓글에 대하여 고객 평점과
#리뷰글을 1페이지(10개)만 스크래핑하여 데이터프레임 형식으로 만들어 "daummovie1.csv" 로 저장한다.

#https://movie.daum.net/moviedb/main?movieId=127122 
#또는
#https://movie.daum.net/moviedb/grade?movieId=131576&type=netizen
#R 코드는 movie1.R 로 생성하여 csv 파일과 함께 제출하세요.

url<-"https://movie.daum.net/moviedb/grade?movieId=131576&type=netizen"
text2<-read_html(url)

dat <- html_nodes(text2, ".raking_grade em")
dattext <- html_text(dat)

content0 <- html_nodes(text2, ".desc_review")
content0text<-html_text(content0)

daummovie<-data.frame("평점"=dattext,"리뷰"=content0text,stringsAsFactors=F)
str(daummovie)
write.csv(daummovie, file="daummovie1.csv")
