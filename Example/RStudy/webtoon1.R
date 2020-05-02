#네이버 웹툰 댓글 페이지에서 
#베스트 댓글과 전체 댓글 50페이지를 읽어서 webtoon1.txt 파일에 저장(write())하는 
#코드를 작성한다. 
#제출 파일명 : webtoon1.txt, webtoon1.R

install.packages("RSelenium")
library(RSelenium)
remDr<-remoteDriver(remoteServerAddr="localhost",port=4445,browserName="chrome")
remDr$open()
url<-'http://comic.naver.com/comment/comment.nhn?titleId=570503&no=135'
remDr$navigate(url)

alldat_frame<-NULL

bestReview<-remDr$findElements(using = "css selector","ul.u_cbox_list span.u_cbox_contents")
bestReviewText<-sapply(bestReview,function(x){x$getElementText()})
bestReviewText<-unlist(bestReviewText)
alldat_frame<-c(alldat_frame,bestReviewText)
datall<-remDr$findElement(using = "css","#cbox_module > div > div.u_cbox_sort > div.u_cbox_sort_option > div > ul > li:nth-child(2) > a")
datall$clickElement()
Sys.sleep(1)
normaldat<-remDr$findElements(using = "css selector","ul.u_cbox_list span.u_cbox_contents")
normaldatText<-sapply(normaldat,function(x){x$getElementText()})
normaldatText<-unlist(normaldatText)
alldat_frame<-append(alldat_frame,normaldatText)

for(i in 1:5) {
  for(n in 4:13) {
    if(n>=4 & n<=12) {
      next_daum<-paste0("#cbox_module>div>div.u_cbox_paginate>div> a:nth-child(",n,") > span")
      next_daumpage<-remDr$findElement(using = "css",next_daum)
      next_daumpage$clickElement()
      Sys.sleep(1)
      normaldat<-remDr$findElements(using = "css selector","ul.u_cbox_list span.u_cbox_contents")
      normaldatText<-sapply(normaldat,function(x){x$getElementText()})
      normaldatText<-unlist(normaldatText)
      alldat_frame<-append(alldat_frame,normaldatText)
   
   } else if(n==13) {
      next_daum<-paste0("#cbox_module>div>div.u_cbox_paginate>div> a:nth-child(",n,") > span")
      next_daumpage<-remDr$findElement(using = "css",next_daum)
      next_daumpage$clickElement()
      Sys.sleep(1)
        if(i<=4){
          normaldat<-remDr$findElements(using = "css selector","ul.u_cbox_list span.u_cbox_contents")
          normaldatText<-sapply(normaldat,function(x){x$getElementText()})
          normaldatText<-unlist(normaldatText)
          alldat_frame<-append(alldat_frame,normaldatText)
        }
    }
  }
}

write.table(alldat_frame,file = "webtoon1.txt")

#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(3)
#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(4)
#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(4) 1페이지
#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(12) 10페이지

#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(13) 다음
#cbox_module > div > div.u_cbox_paginate > div > a:nth-child(4)