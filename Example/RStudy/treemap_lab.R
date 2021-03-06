# 위와 같이 출력되는 treepmap을 그려본다.
# 데이터는 GNI2014 데이터셋을 사용한다. 다음 명령으로 이 데이터셋을 로드하고
# 구조를 확인한 후에 그려본다.
# 영역을 나누는 우선 순위 : 대륙, 나라코드, 영역의 크기를 결정하는 값 : 인구수 
# (제목과 폰트 조정하는거 잊지마세용)
# data(GNI2014) 
# str(GNI2014)
# 구현된 R 소스 제출 파일명 : treemap_lab.R
# 제출 이미지 : treemap.png

library(treemap)
str(GNI2014)
View(GNI2014)
windowsFonts(lett=windowsFont("휴먼옛체"))
treemap(GNI2014,vSize = "population",index=c("continent","iso3"),title="전세계 인구 정보",fontfamily.title="lett",fontfamily.labels="lett")
dev.copy(png,"treemap.png")
dev.off()
