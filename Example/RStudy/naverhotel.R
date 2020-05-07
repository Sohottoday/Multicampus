#다음 사이트의 댓글들을 추출하는 기능을 동적 크롤링으로 구현해 본다.
#R 파일명 : naverhotel.R
#댓글을 모아서 저장하는 텍스트 파일명 : naverhotel.txt

#https://hotel.naver.com/hotels/item?hotelId=hotel:Shilla_Stay_Yeoksam&destination_kor=%EC%8B%A0%EB%9D%BC%EC%8A%A4%ED%85%8C%EC%9D%B4%20%EC%97%AD%EC%82%BC&rooms=2

remDr <- remoteDriver(remoteServerAddr = "localhost" , port = 4445, browserName = "chrome")
remDr$open()
url<-'https://hotel.naver.com/hotels/item?hotelId=hotel:Shilla_Stay_Yeoksam&destination_kor=%EC%8B%A0%EB%9D%BC%EC%8A%A4%ED%85%8C%EC%9D%B4%20%EC%97%AD%EC%82%BC&rooms=2'
remDr$navigate(url)

getReview<-NULL
rightNum<-NULL
getReview_v<-NULL

repeat {  

  doms1<-remDr$findElements(using = 'css selector','body > div > div.ng-scope > div.container.ng-scope > div.content > div.hotel_used_review.ng-isolate-scope > div.review_ta.ng-scope > ul > li > div.review_desc > p')
  getReview<-sapply(doms1,function(x){x$getElementText()})
  getReview_v<-c(getReview_v,unlist(getReview))
  
  afterDaum<-remDr$findElement(using='css','body > div > div.ng-scope > div.container.ng-scope > div.content > div.hotel_used_review.ng-isolate-scope > div.review_ta.ng-scope > div.paginate > span:nth-child(6) > strong')
  rightNum<-as.numeric(afterDaum$getElementText())
  if(!is.na(rightNum)){
    cat("종료\n")
    break;
  }

  daumPage<-remDr$findElement(using = 'css','body > div > div.ng-scope > div.container.ng-scope > div.content > div.hotel_used_review.ng-isolate-scope > div.review_ta.ng-scope > div.paginate > a.direction.next')
  daumPage$clickElement()
  Sys.sleep(1)

}

write(getReview_v,"naverhotel.txt")
