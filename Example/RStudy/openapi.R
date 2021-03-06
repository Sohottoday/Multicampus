#4개의 문제를 모두 해결한 다음에 openapi.R 이라는 파일명으로 소스를 저장하고
#openapi.R, naverblog.txt, navernews.txt, twitter.txt 파일을 제출하시오.

#[ OPEN API 실습 1 ] 
#네이버의 블로그에서 “맛집” 이라는 단어가 들어간 글들을 검색하여 100개까지 
#추출한 다음 naverblog.txt 파일로 저장하시오.
#단, XML 형식의 요청을 처리한다.
#제거해야 하는 문자들 : <b>, </b>, &quot;, &gt;

searchUrl<- "https://openapi.naver.com/v1/search/blog.xml"
Client_ID <- "izGsqP2exeThwwEUVU3x"
Client_Secret <- "WrwbQ1l6ZI"

query <- URLencode(iconv("맛집","euc-kr","UTF-8"))
url <- paste0(searchUrl, "?query=", query, "&display=100")
doc <- GET(url, add_headers("Content_Type" = "application/xml",
                            "X-Naver-client-Id" = Client_ID, "X-naver-Client-Secret" = Client_Secret))
doc2 <- htmlParse(doc, encoding="UTF-8")
text<- xpathSApply(doc2, "//item/description", xmlValue)
text
text<-gsub("</?b>","",text)
text<-gsub("&.{,3}t;", "", text)
text
write(text,file = "naverblog.txt")

#[ OPEN API 실습 2 ] 
#트위터에서  “취업” 이라는 단어가 들어간 트윗 글들을 검색하여 100개까지 추출한 
#다음 twitter.txt 파일로 저장하시오.
#제거해야 하는 문자들과 데이터 값 : [단독], 특수문자, 개행문자, 영어, NA값
library(rtweet) 
appname <- "edu_data_collection"
api_key <- "RvnZeIl8ra88reu8fm23m0bST"
api_secret <- "wTRylK94GK2KmhZUnqXonDaIszwAsS6VPvpSsIo6EX5GQLtzQo"
access_token <- "959614462004117506-dkWyZaO8Bz3ZXh73rspWfc1sQz0EnDU"
access_token_secret <- "rxDWfg7uz1yXMTDwijz0x90yWhDAnmOM15R6IgC8kmtTe"
twitter_token <- create_token(
  app = appname,
  consumer_key = api_key,
  consumer_secret = api_secret,
  access_token = access_token,
  access_secret = access_token_secret)

key <- "취업"
key <- enc2utf8(key)
result <- search_tweets(key, n=100, token = twitter_token)
content <- result$retweet_text
#gsub("^\u\\d","",content)
#gsub("^\U\\d","",content)
content <- na.omit(content)
content <- gsub("\\[단독\\]","",content)
content <- gsub("[[:punct:]]","",content)
content <- gsub("[[:cntrl:]]","",content)
content <- gsub("[A-z]","",content)

write(content,file = "twitter.txt")


#[ OPEN API 실습 3 ] 
#공공DB에서 360번 차량에 대하여 정보를 추출한 다음 노선ID, 노선길이, 기점, 종점,
#배차간격을 다음 형식으로 출력하시오.

#[ 360번 버스정보 ]
#노선ID : xxx
#노선길이 : xxx
#기점 : xxx
#종점 : xxx
#배차간격 : xxx

#참고 : http://api.bus.go.kr/contents/sub02/getBusRouteList.html

library(XML)
API_key  <- "%2BjzsSyNtwmcqxUsGnflvs3rW2oceFvhHR8AFkM3ao%2Fw50hwHXgGyPVutXw04uAXvrkoWgkoScvvhlH7jgD4%2FRQ%3D%3D"
bus_No <- "360"
url <- paste("http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?ServiceKey=", API_key, "&strSrch=", bus_No, sep="")
doc <- xmlParse(url, encoding="UTF-8")
top <- xmlRoot(doc)
top
df <- xmlToDataFrame(getNodeSet(doc, "//itemList"))
df
View(df)
str(df)

df$busRouteId[1]
df$length[1]
df$edStationNm[1]
df$stStationNm[1]
df$term[1]

bus1<-paste("노선ID : ",df$busRouteId[1],sep="")
bus2<-paste("노선길이 : ", df$length[1],sep="")
bus3<-paste("기점 : ",df$edStationNm[1],sep="")
bus4<-paste("종점 : ",df$stStationNm[1],sep="")
bus5<-paste("배차간격 : ",df$term[1], sep="")

cat(bus_No,"번 버스정보 \n",bus1,"\n",bus2,"\n",bus3,"\n",bus4,"\n",bus5)


#[ OPEN API 실습 4 ] 
#네이버의 뉴스에서 “빅데이터” 라는 단어가 들어간 뉴스글들을 검색하여 100개까지 추출한 다음 
#뉴스 제목을 추출하여 navernews.txt 파일로 저장하시오.
#단, JSON 형식의 요청을 처리한다.
#제거해야 하는 문자들 : <b>, </b>, &quot;, &gt;

newsUrl<- "https://openapi.naver.com/v1/search/news.json"
Client_ID <- "izGsqP2exeThwwEUVU3x"
Client_Secret <- "WrwbQ1l6ZI"
query <- URLencode(iconv("빅데이터","euc-kr","UTF-8"))
url <- paste0(newsUrl, "?query=", query, "&display=100")
doc <- GET(url, add_headers("Content_Type" = "application/json",
                            "X-Naver-client-Id" = Client_ID, "X-naver-Client-Secret" = Client_Secret))
	
json_data <- content(doc,type='text',encoding="UTF-8")
json_obj <- fromJSON(json_data)
text <- json_obj[["items"]]["title"]
text <- gsub("</?b>", "", text)
text <- gsub("&.{,3}t;", "", text)

write(text,file = "navernews.txt")

