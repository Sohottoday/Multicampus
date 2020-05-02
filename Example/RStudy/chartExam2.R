#다음 그래프들을 만들어 보고 chartExam2.R 로 제출한다.
#[ 문제 1 ]
#mpg 데이터 셋의 cty(도시 연비)와 hwy(고속도로 연비) 간에 어떤 관계가 있는지
#알아보려고 한다.
#x축은 cty, y축은 hwy로 된 산점도를 만들어 본다.
#다음 그래프와 동일한 내용으로 출력한다.

mpg <- ggplot2::mpg
plot(mpg$cty,mpg$hwy,type = "p",pch=3,xlab = "도시연비",ylab="고속도로 연비")
?plot

#[ 문제 2 ]
#mpg 데이터 셋에서 구동방식(drv)별 차량의 수를 다음과 같이 보여지도록
#바 그래프로 출력한다.

library(dplyr)
cnt_drv <- table(mpg$drv)
barplot(cnt_drv,col=rainbow(3))

# boxplot는 X~Y 형식의 포뮬러식을 지원한다. 이 식의 의미는 ‘Y별 X데이터를
#모아서’ 라는 것이다. 다음과 같이 data 변수에 그래프를 그리는데 사용하는
#데이터 프레임을 설정하고 첫 번째 아규먼트로 hwy~manufacturer을 설정하면
#제조사별 고속도로 연비를 추출하라는 의미가 된다.
# boxplot(hwy~manufacturer,data=mpg)
#제조사별로 다음과 같은 고속도로 연비에 대한 박스 플롯이 그려진다.……

#이 내용을 기반으로 하여 여러분들이 구현해야 하는 것은 바로 다음 화면이다.
#변경된 것을 찾아서 반영해 본다.
?boxplot
boxplot(hwy~manufacturer,data=mpg,las=2,col=heat.colors(15),
        main="*제조사별 고속도로 연비*", col.main="magenta")
