#모든 매장들의 매장명(shopname), 위도(lat), 경도(lng), 주소(addr) 그리고 
#전화번호(telephone)를 추출하여 starbucks.csv 로 저장한다. 속성 정보를 추출하는
#API는 강사컴 학습관련소스와문서/4월7일 폴더의 RSelenium.pdf를 참고한다.
#starbucks.R 과 starbucks.csv 을 메일로(unicodaum@hanmail.net – 
#메일 제목 : 동적 크롤링 수행평가 - XXX)제출한다.

# 전체 매장 갯수 추출 코드
sizeCss<-'#container > div > form > fieldset > div > section > article.find_store_cont > article > article:nth-child(4) > div.loca_step3 > div.result_num_wrap > span'
#container > div > form > fieldset > div > section > article.find_store_cont > article > article:nth-child(4) > div.loca_step3 > div.result_num_wrap > span
size<-remDr$findElements(using='css selector', sizeCss)
limit<-sapply(size.function(x){x$getElementText()})

# 3개의 매장 정보를 읽고 세번째 매장 DOM 객체 위에서 스크롤 이벤트 발생
# 마지막 매장에 도달한 경우에는 더 이상 스크롤 이벤트 발생 불필요.
if(index %% 3 == 0 && index !=limit) {
  remDr$executeScript(
    "var dom = document.querySelectorAll('#mCSB_3_container > ul > li')[arguments[0]];
    dom.scrollIntoView();", list(index)
  )
}
# 주어진 문자열을 개행문자를 기준으로 자르기
strsplit(unlist(찾아온컨텐트),split="\n")



# 실습

remDr <- remoteDriver(remoteServerAddr = "localhost" , port = 4445, browserName = "chrome")
remDr$open()
url<-'https://www.istarbucks.co.kr/store/store_map.do?disp=locale'
remDr$navigate(url)

clickSeoul<-remDr$findElement(using = 'css','#container > div > form > fieldset > div > section > article.find_store_cont > article > article:nth-child(4) > div.loca_step1 > div.loca_step1_cont > ul > li:nth-child(1) > a')
clickSeoul$clickElement()
Sys.sleep(2)
clickSeoulAll<-remDr$findElement(using = 'css','#mCSB_2_container > ul > li:nth-child(1) > a')
clickSeoulAll$clickElement()
Sys.sleep(3)

doms1<-NULL
doms2<-NULL
doms3<-NULL
starbucksData<-NULL
starbucksDataAll<-NULL
sizeCss<-'#container > div > form > fieldset > div > section > article.find_store_cont > article > article:nth-child(4) > div.loca_step3 > div.result_num_wrap > span'
size<-remDr$findElements(using='css selector', sizeCss)
limit<-sapply(size,function(x){x$getElementText()})


for(index in 1:as.numeric(limit)) {
  starbucksCss<-paste('#mCSB_3_container > ul > li:nth-child(',index,') > p',sep="")
  starbucksTag<-paste('#mCSB_3_container > ul > li:nth-child(',index,')',sep="")
  doms1<-remDr$findElement(using = 'css',starbucksCss)
  doms2<-doms1$getElementText()
  domSplit<-strsplit(unlist(doms2),split="\n")
  addr<-domSplit[[1]][1]
  addr<-gsub(",","",addr)
  telephone<-domSplit[[1]][2]
  doms3<-remDr$findElement(using = 'css',starbucksTag)
  lat<-doms3$getElementAttribute("data-lat")
  lng<-doms3$getElementAttribute("data-long")
  shopname<-doms3$getElementAttribute("data-name")
  starbucksData<-cbind(shopname,addr,telephone,lat,lng)
  starbucksDataAll<-rbind(starbucksDataAll,starbucksData)

  if(index %% 3 == 0 && index !=limit) {
    remDr$executeScript(
      "var dom = document.querySelectorAll('#mCSB_3_container > ul > li')[arguments[0]];
    dom.scrollIntoView();", list(index)
    )
  }
}  
  write.csv(starbucksDataAll,"starbucks.csv")
  
