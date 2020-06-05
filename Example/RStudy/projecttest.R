
dataAll <- read.csv("c:/Sohottoday/data/biz_a.csv")

install.packages("DBI");
install.packages("RJDBC");
library(RJDBC)
library(DBI)
 
drv <- JDBC("oracle.jdbc.driver.OracleDriver","C:/Sohottoday/ojdbc6.jar")
conn <- dbConnect(drv,"jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest")
conn

dbGetQuery(conn, "select count(*) AS cnt, SNT_UPTAE_NM
from biz_d
GROUP by SNT_UPTAE_NM
order by cnt desc");

dbGetQuery(conn, "select count(*),To_Char(DCB_YMD,'YYYY')
from biz_a
where DCB_YMD is not null
GROUP by To_Char(DCB_YMD,'YYYY')
order by count(*) desc");

# 전체 업종 비율
upjongper <- dbGetQuery(conn, "select snt_cob_nm, count(*) as cnt
from biz_a
group by snt_cob_nm
order by cnt desc");
upjongper
head(upjongper)
ggplot(data = head(upjongper), aes(x = "", y=CNT, fill=SNT_COB_NM)) + geom_bar(width = 1,stat = "identity") + coord_polar("y",start=0)
str(upjongper)

# 전체 영업 시작 연도 비율
startyear <- dbGetQuery(conn, "select yy, count(*) as cnt
from biz_a
where yy >= 1995 and yy < 2020
group by yy
order by yy desc");
head(startyear,14)
ggplot(startyear, aes(x=YY, y=CNT)) + geom_line(color = "#3366ff",size=2, linetype = 1)
styr <- ggplot(startyear, aes(x=YY, y=CNT))

#전체 폐업 연도 비율
closeyear <- dbGetQuery(conn, "select to_char(dcb_ymd, 'yyyy') as close_year, count(*) as cnt
from biz_a
where to_char(dcb_ymd, 'yyyy') >= 1995 and to_char(dcb_ymd, 'yyyy') < 2020
group by to_char(dcb_ymd, 'yyyy')
order by to_char(dcb_ymd, 'yyyy') desc");
ggplot(closeyear, aes(x=as.numeric(CLOSE_YEAR), y=CNT)) + geom_line(color = "#ff5050",size=2, linetype = 1)



# 전체 무슨 구에 가게가 많은가
gucnt <- dbGetQuery(conn, "select cgg_code, count(*) as cnt
from biz_a
where cgg_code is not null
group by cgg_code
order by cgg_code");
ggplot(gucnt, aes(x=CGG_CODE,y=CNT,fill=CNT)) + geom_bar(stat = 'identity');

# 전체 폐업 이유 비율
closewhy <- dbGetQuery(conn, "select dcb_gbn_nm, count(*) as cnt
from biz_a
where dcb_gbn_nm is not null
group by dcb_gbn_nm");
ggplot(data = closewhy, aes(x = "", y=CNT/498663, fill=DCB_GBN_NM)) + geom_bar(width = 1,stat = "identity") + coord_polar("y",start=0)

# 전체 행정처분 받은 업태 비율
uptae <- dbGetQuery(conn, "select snt_uptae_nm, count(*) as cnt
from biz_d
where snt_uptae_nm is not null
group by snt_uptae_nm
order by cnt desc");
head(uptae,12)
ggplot(data = head(uptae,12), aes(x = "", y=CNT/12452, fill=SNT_UPTAE_NM)) + geom_bar(width = 1,stat = "identity") + coord_polar("y",start=0)

# 전체 어떤 법을 어겼나
dbGetQuery(conn, "select bas_law_clean, count(*) as cnt
from biz_d
where bas_law_clean is not null
group by bas_law_clean
order by cnt desc");

# 전체 어떤 처분을 받았나
dbGetQuery(conn, "select dispo_ctn_dt, count(*) as cnt
from biz_d
group by dispo_ctn_dt
order by cnt desc");

# 매장 크기별 행정처분 받은 비율
#dbGetQuery(conn, "select count(*) as cnt, trdp_area
#from biz_d
#group by trdp_area
#having ")
# 매장 면적별로 묶을 수 있는지?
# 0~50, 50~ 100, 100~150, 150~200, 200 이상

# 구별 업종 비율
dbGetQuery(conn, "select cgg_code, snt_cob_nm, count(*) as cnt
from biz_a
group by cgg_code,snt_cob_nm
order by cgg_code, cnt desc");
# where절로 하나씩 뽑기?

# 구별 영업 시작 연도 비율
dbGetQuery(conn, "select cgg_code, yy, count(*) as cnt
from biz_a
where yy >= 1995 and yy < 2020
group by cgg_code, yy
order by cgg_code, yy desc");

# 구별 폐업 연도 비율
dbGetQuery(conn, "select cgg_code, to_char(dcb_ymd, 'yyyy') as close_year, count(*) as cnt
from biz_a
where to_char(dcb_ymd, 'yyyy') >= 1995 and to_char(dcb_ymd, 'yyyy') < 2020
group by cgg_code, to_char(dcb_ymd, 'yyyy')
order by cgg_code, to_char(dcb_ymd, 'yyyy') desc");

# 구별 무슨동에 가게가 많은가?
dbGetQuery(conn, "select cgg_code, admdng_nm, count(*) as cnt
from biz_a
group by cgg_code, admdng_nm
having count(*) > 1
order by cgg_code, admdng_nm");
# 지나치게 작은 값은 결측치인지?

# 구별 행정처분 받은 업태 비율
dbGetQuery(conn, "select cgg_code, snt_uptae_nm, count(*) as cnt
from biz_d
group by cgg_code, snt_uptae_nm
order by cgg_code, cnt desc");

# 구별 어떤 법을 어겼는지?
dbGetQuery(conn, "select cgg_code, bas_law, count(*) as cnt
from biz_d
where bas_law is not null
group by cgg_code, bas_law
order by cgg_code");

# 구별 어떤 처분을 받았는지?
dbGetQuery(conn, "select cgg_code, dispo_ctn, count(*) as cnt
           from biz_d
           group by cgg_code, dispo_ctn
           order by cgg_code, cnt desc");

# 구별 적발 구분 비율
dbGetQuery(conn, "select cgg_code, insp_gbn_code, count(*) as cnt
from biz_d
where insp_gbn_code is not null
group by cgg_code, insp_gbn_code
order by cgg_code, cnt desc");

dataapt <- read.csv("c:/Sohottoday/data/totalapt.csv");

write.csv(dataapt, file = "ttapt.csv", fileEncoding = "UTF-8");

test <- dbGetQuery(conn, "select to_char(DCB_YMD,'YYYY') - to_char(VIOR_YMD,'YYYY') AS upsoyear, cnt
from (select DISTINCT biz_c.VIOR_YMD, biz_c.UPSO_NM, biz_c.SITE_ADDR,biz_c.SITE_STDT,biz_c.DCB_YMD,cnt
from
(select biz_a.UPSO_NM,biz_a.SITE_ADDR,biz_a.SITE_STDT,nvl(biz_a.DCB_YMD,Sysdate + (INTERVAL '10' YEAR)) as DCB_YMD,biz_d.VIOR_YMD
from (SELECT UPSO_NM, SITE_ADDR,VIOR_YMD
FROM biz_d
where DISPO_CTN not like '%폐쇠%' and DISPO_CTN not like '%폐쇄%') biz_d inner join biz_a
on biz_a.upso_nm = biz_d.upso_nm and biz_a.SITE_ADDR = biz_d.SITE_ADDR) biz_c
inner join
(select biz_a.UPSO_NM,biz_a.SITE_ADDR,count(*) AS cnt
from (SELECT UPSO_NM, SITE_ADDR,VIOR_YMD
FROM biz_d
where DISPO_CTN not like '%폐쇠%' and DISPO_CTN not like '%폐쇄%') biz_d inner join biz_a
on biz_a.upso_nm = biz_d.upso_nm and biz_a.SITE_ADDR = biz_d.SITE_ADDR
group by biz_a.UPSO_NM,biz_a.SITE_ADDR) biz_d
on biz_c.UPSO_NM = biz_d.upso_nm
ORDER by VIOR_YMD desc)
where cnt<6 and to_char(DCB_YMD,'YYYY') - to_char(VIOR_YMD,'YYYY') >= 0")
test # dataframe으로 다운받기 성공~!!

write.csv(test, file = "dfdf.csv", fileEncoding = "UTF-8");
