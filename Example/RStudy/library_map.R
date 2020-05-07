# [ 지도 출력 실습(1) ]
# 우리 집의 지도를 출력하는데 
# 현재의 초시간이 0~14초 사이이면 terrain 타입으로
# 현재의 초시간이 15~29초 사이이면 satellite 타입으로
# 현재의 초시간이 30~44초 사이이면 roadmap 타입으로
# 현재의 초시간이 45~59초 사이이면 hybrid 타입으로
# 지도를 출력하는 R 코드를 작성한다.
# 지도 제목으로 "XXX 동네"를 설정하고 "위도"와 "경도"도 출력한다.
# 파일명은 myhome_map.R 이고 지도는 이미지로 
# mymap.png 저장하여 함께 제출한다. 

myhouse <- "관악구 봉천동 1588-16"
gcmyhouse <- geocode(enc2utf8(myhouse))
df <- data.frame(myhouse = myhouse,
                 lon = gcmyhouse$lon,
                 lat = gcmyhouse$lat
                 )
Sys.sleep(1)
second_now <- as.character(Sys.time())
getsecondnow <- substr(second_now,18,19)
typewhat <- NULL
if(as.numeric(getsecondnow)>=0 & as.numeric(getsecondnow)<=14) {
  typewhat <- "terrain"
} else if(as.numeric(getsecondnow)>=15 & as.numeric(getsecondnow)<=29) {
  typewhat <- "satellite"
} else if(as.numeric(getsecondnow)>=30 & as.numeric(getsecondnow)<=44) {
  typewhat <- "roadmap"
} else {
  typewhat <- "hybrid"
}
map_on_myhouse <- get_googlemap(center = c(df$lon,df$lat),
                                maptype = typewhat,
                                zoom = 16,
                                size = c(640,640),
                                marker = gcmyhouse)
Sys.sleep(2)
ggmap(map_on_myhouse) + labs(title="위험한 동네", x="경도",y="위도") + geom_text(aes(x=df$lon,y=df$lat,label="위험한 동네",vjust=1,hjust=1))
ggsave("mymap.png")

  # [ 지도 출력 실습(2) ]
  # 서울 지도를 그리고 지역별 장애인 도서관 위치를 표시(투명한 point)한다. 
  # 도서관명을 함께 출력한다.
  
  #소스는 library_map.R로 구현하고 출력 결과는 library.png 로 저장하여 제출한다.

read_a_book<-read.csv("data/지역별장애인도서관정보.csv")
str(read_a_book)
addr <- as.character(read_a_book$주소)
#gc <- geocode(enc2utf8(addr))
#Sys.sleep(3)
cen <- c(mean(read_a_book$LON),mean(read_a_book$LAT))
map_book <- get_googlemap(center=cen,
                          maptype = "roadmap",
                          zoom = 11,
                          size=c(640,640),
                          #marker = gc
                          )
Sys.sleep(1)
ggmap(map_book) + geom_point(data = read_a_book,aes(x=LON,y=LAT),alpha=0.6,size=3,color="red")+geom_text(data = read_a_book,aes(x=LON,y=LAT),size=3,label=read_a_book$도서관명,vjust=1,hjust=1)
ggsave("library.png")
