# [ leaflet 지도 실습(1) ] 
# 
# 다음과 같이 나의 집을 leafelt 으로 그려 본다.소스는 myhome_leaflet.R 로 
#그려진 결과는 mymap.html 로 제출한다.
# [ 그려진 leaflet 지도를 저장하기 ]
# install.packages("htmlwidgets")
# library(htmlwidgets)
# saveWidget(그려진내용을담은변수, file="파일명.html")

myhouse <- "관악구 봉천동 1588-16"
gcmyhouse <- geocode(enc2utf8(myhouse))
df <- data.frame(myhouse = myhouse,
                 lon = gcmyhouse$lon,
                 lat = gcmyhouse$lat)
lon <-df$lon
lat <- df$lat
msg <- "<strong>절대 아지트 아님</strong><hr>사람 조심! 물어요"
map_myhouse <- leaflet() %>% 
  setView(lng = lon,lat = lat,zoom = 16) %>% addTiles() %>% 
  addCircles(lng = lon,lat = lat,color = "magenta",popup = msg)
map_myhouse
saveWidget(map_myhouse, file = "mymap.html")
