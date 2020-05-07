#다음 문제들을 R로 작성하여 dplyr_lab2.R로 저장하여 제출한다.
#1. ggplot2 패키지에서 제공되는 mpg 라는 데이터 셋의 구조를 확인한다.
#이 mpg 를 데이터프레임으로 변환하여 mpg 에 저장한다.(as.data.frame())
#install.packages("ggplot2")
#str(ggplot2::mpg)
#mpg <- as.data.frame(ggplot2::mpg)
#1-1 mpg의 구조를 확인한다.

str(mpg)

#1-2 mpg 의 행의 개수와 열의 개수를 출력한다.

nrow(mpg)
ncol(mpg)
dim(mpg)

#1-3 mpg의 데이터를 앞에서 10개 출력한다.

mpg %>% 
  head(10)

#1-4 mpg의 데이터를 뒤에서 10개 출력한다.

mpg %>% 
  tail(10)

#1-5. mpg의 데이터를 GUI 환경으로 출력한다.

View(mpg)

#1-6 mpg를 열 단위로 요약한다.          ??

summary(mpg)

#1-7 mpg 데이터셋에서 제조사별 차량의 수를 출력한다.

mpg %>% 
  group_by(manufacturer) %>% 
  summarise(m_count = n())

#1-8 mpg 데이터셋에서 제조사별 그리고 모델별 차량의 수를 출력한다.

mpg %>% 
  group_by(manufacturer, model) %>% 
  summarise(mnm_count = n())

#2. 다음에 제시된 문제를 각각 2-1, 2-2 으로 넘버링 하여 해결 코드를 R로 작성한다.
# mpg 데이터의 변수명은 긴 단어를 짧게 줄인 축약어로 되어있습니다. cty 변수는
# 도시 연비, hwy 변수는 고속도로 연비를 의미합니다. 변수명을 이해하기 쉬운
# 단어로 바꾸려고 합니다. mpg 데이터를 이용해서 아래 문제를 해결하시오.

# 2-1 복사본 데이터를 이용하여 cty는 city로, hwy는 highway로 변수명을 수정하세요.

mpg %>% 
  rename(city = cty, highway = hwy) -> mpg

# 2-2 데이터 일부를 출력하여 변ㅅ명이 바뀌었는지 확인하시오.

mpg %>% 
  head(10)

#3. 다음에 제시된 문제를 각각 3-1, 3-2, 3-3, 3-4로 넘버링 하여
# 해결 코드를 R로 작성한다.
#ggplot2 패키지에는 미국 동북중부 437개 지역의 인구통계 정보를 담은
#midwest라는 데이터가 포함되어 있습니다. midwest 데이터를 사용해 데이터 분석
#문제를 해결해보세요.

#문제1. ggplot2의 midwest 데이터를 데이터 프레임 형태로 불러와서
#데이터의 특성을 파악하세요.

midwest <- ggplot2::midwest
str(midwest)
summary(midwest)

#문제2. poptotal(전체 인구)을 total로, popasian(아시아 인구)을 asian으로
#변수명을 수정하세요.

midwest %>% 
  rename(total = poptotal, asian = popasian) -> midwest

#문제3. total, asian 변수를 이용해 '전체 인구 대비 아시아 인구 백분율'
#파생변수를 만들어 보세요

midwest %>% 
  mutate(aboutasian = asian/total) %>% 
  select(aboutasian) -> midwest

#문제4. 아시아 인구 백분율 전체 평균을 구하고, 평균을 초과하면 "large",
# 그 외에는 "small"을 부여하는 파생변수를 만들어 보세요.

mean(midwest$aboutasian) -> mean_aboutasian

midwest %>% 
  mutate(updown = ifelse(aboutasian > mean_aboutasian,"large","small")) %>% 
  select(aboutasian,updown)

#4. 다음에 제시된 문제를 각각 4-1, 4-2, 4-3 으로 넘버링 하여 해결 코드를
#R로 작성한다.

# 4-1 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 한다.
#   displ(배기량)이 4 이하인 자동차와 5 이상인 자동차 중 어떤 자동차의
# hwy(고속도로 연비)가 평균적으로 더 높은지 알아보세요.

mpg %>% 
  filter(displ<=4) %>% 
  summarise(mean_down4 = mean(highway))
mpg %>% 
  filter(displ>=5) %>% 
  summarise(mean_up5 = mean(highway))

mpg %>% 
  filter(displ<=4 | displ>=5 ) %>% 
  group_by(displ) %>% 
  summarise(mean_group = mean(highway))

# 4-2 자동차 제조회사에 따라 도시 연비가 다른지 알아보려고 합니다.
# "audi"와 "toyota" 중 어느 manufacturer(자동차의 제조 회사)의 cty(도시 연비)가
# 평균적으로 더 높은지 알아보세요.

mpg %>% 
  filter(manufacturer=="audi") %>% 
  summarise(mean_audi = mean(city))
mpg %>% 
  filter(manufacturer=="toyota") %>% 
  summarise(mean_toyota = mean(city))

#mpg %>% 
#  group_by(manufacturer) %>% summarise(mean(city)) %>% 
#  filter(manufacturer %in% c('audi', 'toyota'))

# 4-3 "chevrolet","ford","honda" 자동차의 고속도로 연비 평균을 알아보려고 합니다.
# 이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요.

mpg %>% 
  filter(manufacturer=="chevrolet"|manufacturer=="ford"|manufacturer=="honda") %>% 
  summarise(mean_3hwy = mean(highway))

mean(mpg$highway)

#5. 다음에 제시된 문제를 각각 5-1, 5-2 으로 넘버링 하여 해결 코드를 R로 작성한다.
# 5-1 mpg 데이터는 11개 변수로 구성되어 있습니다. 이 중 일부만 추출해서
# 분석에 사용하려고 합니다. mpg데이터에서 class(자동차의 종류), cty(도시 연비)
# 변수를 추출해 새로운 데이터를 만드세요. 새로 만든 데이터의 일부분을 출력해서
# 두 변수로만 구성되어 있는지 확인하세요

mpg %>% 
  select(class, city) %>% 
  head(10)

# 5-2 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 앞에서 추출한
# 데이터를 이용해서 class(자동차의 종류)가 "suv"인 자동차와 "compact"인 자동차 중
# 어떤 자동차의 cty(도시연비)가 더 높은지 알아보세요

mpg %>% 
  filter(class=="suv") %>% 
  summarise(mean_suv = mean(city))
mpg %>% 
  filter(class=="compact") %>% 
  summarise(mean_compact = mean(city))

#6. 다음에 제시된 문제에 대한  해결 코드를 R로 작성한다.
# "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 hwy(고속도로 연비)가
# 높은지 알아보려고 합니다.
# "audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 자동차의 데이터를 출력하시오.

mpg %>% 
  filter(manufacturer=="audi") %>% 
  arrange(desc(highway)) %>% 
  head(5)
