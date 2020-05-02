site<-"https://movie.daum.net/moviedb/grade?movieId=127122&type=netizen&page="
text3<-NULL
dattext<-NULL
content0text<-NULL
daummovie2<-NULL

for(n in 1:20){
  url <- paste(site,n,sep="")
  text3<- read_html(url)
  dat <- html_nodes(text3, ".raking_grade em")
  dattext <- html_text(dat)
  content0 <- html_nodes(text3, ".desc_review")
  content0text<-html_text(content0,trim = TRUE)
  page<-cbind(dattext,content0text)
  daummovie2<-rbind(daummovie2,page)
}

write.csv(daummovie2, file="daummovie2.csv")
