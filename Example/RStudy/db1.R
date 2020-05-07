# [ R과 Oracle 연동 실습 ] 
# (1) iris 데이터셋을 Oracle 서버에 다음 사양으로 테이블이 생성되고 데이터들이 
# 저장되도록 R 코드를 구현한다.
# 테이블명 : IRIS
# 컬럼명 : SLENGTH, SWIDTH, PLENGTH, PWIDTH, SPECIES
# (2) IRIS 테이블의 내용을 모두 읽어 온다.
# (3) 다음과 같은 결과가 출력되도록 ggplot() 으로 시각화 R 코드를 구현한다.(2가지)
# 작성된 R 소스는 db1.R 로 생성된 시각화 결과는 db1.jpg, db2.jpg 로 저장하여
# 강사컴퓨터에 제출한다.

drv <- JDBC("oracle.jdbc.driver.OracleDriver","c:/Sohottoday/ojdbc6.jar")
conn <- dbConnect(drv,"jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest")

Riris <- iris
Riris$Species <- as.character(Riris$Species)
colnames(Riris) <- c("SLENGTH","SWIDTH","PLENGTH","PWIDTH","SPECIES")
dbWriteTable(conn,"IRIS",Riris)
result1 <- dbReadTable(conn,"IRIS")
result1

library(ggplot2)
iris_db1 <- ggplot(data = result1, aes(x=SLENGTH,y=SWIDTH,col=SPECIES))+geom_point()
ggsave("db1.jpg")
iris_db2 <- ggplot(data = result1, aes(x=PLENGTH,y=PWIDTH,col=SPECIES))+geom_point()
iris_db2
ggsave("db2.jpg")
