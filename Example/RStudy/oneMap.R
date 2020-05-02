# [ leaflet 지도 실습(2) ] 
# 
# map7를 잘 분석해 보고 구현하는 실습이다.
# map7 처럼 1인 가구에 대한 정보를 지도에 각 동별로 나눠서 칼라링하여 출력하고자 한다.
# 수업 시간에는 광진구를 출력했는데....
# 
# 구현해야 하는 것은 강남구, 종로구, 관악구(또는 원하는 구) 중에서 하나를 선택해서 출력해 본다.
# 소스는 oneMap.R로 구현하고 출력 결과는 oneMap.html 로 저장하여 제출한다.
# 
# 필요시 http://web-r.org/webrboard/6477 도 참고해 보고
# 11월7일 폴더에 있는 leaflet.pdf 도 참고한다.

library(dplyr)

Encoding(names(korpopmap2))<-'UTF-8'
Encoding(korpopmap2@data$name)<-'UTF-8'
Encoding(korpopmap2@data$행정구역별_읍면동)<-'UTF-8'
Encoding(names(korpopmap3))<-'UTF-8'

Encoding(korpopmap3@data$name)<-'UTF-8'
Encoding(korpopmap3@data$행정구역별_읍면동)<-'UTF-8'

k2 <- korpopmap2
k3 <- korpopmap3

k2@data[c("C행정구역별_읍면동", "행정구역별_읍면동")]
k3@data[c("C행정구역별_읍면동", "행정구역별_읍면동")]

k3@data[grep('^11210', k3@data$C행정구역별_읍면동),  
        c("C행정구역별_읍면동", "행정구역별_읍면동")]

guname <- "관악구"       #11210
gucode <- k2@data[k2@data$name == guname,'code.data']
pattern <- paste0('^',gucode)
k3@data[grep(pattern, k3@data$code.data), c("code.data","name")]
View(k3@data)

#k3@data<-k3@data[c(320:340),] 
k3@data<-korpopmap3@data[grep(pattern, korpopmap3@data$code.data),]
#k3@polygons<-k3@polygons[c(320:340)] 
k3@polygons<-korpopmap3@polygons[grep(pattern, korpopmap3@data$code.data)]
View(k3)
k3@data$name<-gsub('·','',k3@data$name) 
DONG <- read.csv("data/one.csv")
colnames(DONG)<-c('구별','name','일인가구')
dong <- DONG %>% filter(구별=='관악구')

k3@data<-merge(k3@data, dong, by.x='name', sort=FALSE)
mymap <- k3@data

library(leaflet)
bongcheonpalette <- colorNumeric(palette = 'Set1', domain = k3@data$'일인가구')
bongcheonpopup <- paste0(mymap$name,"<br> 1인가구 : ", k3@data$'일인가구')

library(ggmap)
register_google(key='AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c')
gucheong <- "관악구청"
gucheongloc <- geocode(enc2utf8(gucheong))
install.packages("rgeos")
library(rgeos)
bongcheonmap <- NULL
bongcheonmap <- leaflet(k3) %>% addTiles() %>% 
  setView(lat = gucheongloc$lat, lng = gucheongloc$lon,zoom = 12) %>% 
  addPolygons(stroke = FALSE,fillOpacity = .7,popup = bongcheonpopup, 
              color = ~bongcheonpalette(k3@data$일인가구)) %>%  #fillopacity 채우기의 투명도.
  addLegend(values = ~k3@data$일인가구, pal = bongcheonpalette,
            title = '인구수', opacity = 1)
bongcheonmap
library(htmlwidgets)
saveWidget(bongcheonmap,"oneMap.html")
