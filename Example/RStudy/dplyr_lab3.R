#다음 문제들을 R로 작성하여 dplyr_lab3.R로 저장하여 제출한다.
#7. 다음에 제시된 문제를 각각 7-1, 7-2, 7-3, 7-4 로 넘버링 하여 해결 코드를
#R로 작성한다.
# mpg 데이터는 연비를 나타내는 변수가 hwy(고속도로 연비), cty(도시 연비) 두 종류로
#분리되어 있습니다. 두 변수를 각각 활용하는 대신 하나의 통합 연비 변수를
# 만들어 분석하려고 합니다.
# 7-1 mpg 데이터 복사본을 만들고, cty와 hwy를 더한 '합산 연비 변수'를 추가하시오.

mpg_copy<-ggplot2::mpg
mpg %>% 
  mutate(use_fuel=cty+hwy) -> mpg_copy

# 7-2 앞에서 만든 '합산 연비 변수'를 2로 나눠 '평균 연비 변수'를 추가하세요.

mpg_copy %>% 
  mutate(mean_fuel=use_fuel/2) -> mpg_copy

# 7-3 '평균 연비 변수'가 가장 높은 자동차 3 종의 데이터를 출력하세요.

mpg_copy %>% 
  arrange(desc(mean_fuel)) %>% 
  select(manufacturer,model,mean_fuel) %>% 
  head(3)

# 7-4 1~3번 문제를 해결할 수 있는 하나로 연결된 dplyr구문을 만들어 출력하세요.
# 데이터는 복사본 대신 원본을 이용하세요.

mpg %>% 
  mutate(use_fuel=cty+hwy) %>% 
  mutate(mean_fuel=use_fuel/2) %>% 
  arrange(desc(mean_fuel)) %>% 
  select(manufacturer,model,mean_fuel) %>% 
  head(3)
  
#8. 다음에 제시된 문제를 각각 8-1, 8-2, 8-3, 8-4 로 넘버링 하여 해결 코드를
# R로 작성한다.
# mpg 데이터를 이용하여 분석 문제를 해결하시오.
# 8-1 mpg 데이터의 class는 "suv","compact" 등 자동차의 특징에 따라 일곱 종류로
# 분류한 변수입니다. 어떤 차종의 연비가 높은지 비교하려 합니다.
# class별 cty 평균을 구해보시오

mpg %>% 
  group_by(class) %>% 
  summarise(mean_classcty = mean(cty))

# 8-2 앞 문제의 출력 결과는 class값 알파벳 순으로 정렬되어 있습니다. 어떤 차종의
# 도시 연비가 높은지 쉽게 알아볼 수 있도록 cty평균이 높은 순으로 출력하시오.

mpg %>% 
  group_by(class) %>% 
  summarise(mean_classcty = mean(cty)) %>% 
  arrange(desc(mean_classcty))

# 8-3 어떤 회사의 자동차의 hwy(고속도로 연비)가 가장 높은지 알아보려고 합니다.
# hwy 평균이 가장 높은 회사 세 곳을 출력하시오.

mpg %>% 
  group_by(manufacturer) %>% 
  summarise(mean_manuhwy = mean(hwy)) %>% 
  arrange(desc(mean_manuhwy)) %>% 
  head(3)

# 8-4 어떤 회사에서 "compact"(경차) 차종을 가장 많이 생산하는지 알아보려고
# 합니다. 각 회사별 "compact"차종 수를 내림차순으로 정렬해 출력하세요.

mpg %>% 
  group_by(manufacturer) %>% 
  filter(class=="compact") %>% 
  summarise(cnt_compact=n()) %>% 
  arrange(desc(cnt_compact))

#9. 다음에 제시된 문제를 각각 9-1, 9-2 로 넘버링하여 해결 코드를 R로 작성한다.
# mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
# mpg데이터의 fl 변수는 자동차에 사용하는 연료(fuel)를 의미합니다.
# 아래는 자동차의 연료별 가격을 나타낸 표입니다.
# fl      연료종류       가격(갤런당 USD)
# c        CNG             2.35
# d        disel           2.38
# e        ethanol E85     2.11
# p        premium         2.76
# r        regular         2.22

# 우선 이 정보를 이용해서 연료와 가격으로 구성된 데이터 프레임을 만들어 보세요.
fuel <- data.frame(fl = c('c','d','e','p','r'),
                   price_fl = c(2.35, 2.38, 2.11, 2.76, 2.22),
                   stringsAsFactors = F)
fuel

# 9-1 mpg데이터에는 연료 종류를 나타낸 f1변수는 있지만 연료 가격을 나타낸 변수
#는 없습니다. 위에서 만든 fuel 데이터를 이용해서 mpg 데이터에 price_fl(연료 가격)
# 변수를 추가하세요.

mpg <- full_join(mpg, fuel, by="fl")

# 9-2 연료 가격 변수가 잘 추가되었는지 확인하기 위해 model, fl, price_fl 변수를
# 추출해 앞부분 5행을 출력해 보세요.

mpg %>% 
  select(model, fl, price_fl) %>% 
  head(5)

#10. 다음에 제시된 문제를 각각 10-1, 10-2, 10-3, 10-4 로 넘버링하여
#해결 코드를 R로 작성한다.
# 미국 동부 437개 지역의 인구통계 정보를 담고있는 midwest 데이터를 사용해
# 데이터 분석 문제를 해결해 보세요. midwest는 ggplot2 패키지에 있습니다.
# 10-1 popadults 는 해당 지역의 성인 인구, poptotal은 전체 인구를 나타냅니다.
# midwest 데이터에 '전체 인구 대비 미성년 인구 백분율' 변수를 추가하세요.

midwest <- ggplot2::midwest
midwest %>% 
  mutate(per_kidasian = (poptotal-popadults)/poptotal) -> midwest

# 10-2 미성년 인구 백분율이 가장 높은 상위 5개 county(지역)의
# 미성년 인구 백분율을 출력하세요.

midwest %>% 
  arrange(desc(per_kidasian)) %>% 
  select(county,per_kidasian) %>% 
  head(5)

# 10-3 분류표의 기준에 따라 미성년 비율 등급 변수를 추가하고, 각 등급에
# 몇개의 지역이 있는지 알아보세요
# 분류         기준
# large        40% 이상
# middle       30~40% 미만
# small        30% 미만

midwest %>% 
  mutate(kid_category = ifelse(per_kidasian>=0.4,"large",ifelse(per_kidasian>=0.3,"middle","small"))) %>% 
  group_by(kid_category) %>% 
  summarise(cnt_kidcat=n())
  
# 10-4 popasian은 해당 지역의 아시아인 인구를 나타낸 것입니다. '전체 인구 대비
# 아시아인 인구 백분율' 변수를 추가하고, 하위 10개 지역의 state(주),
# country(지역명), 아시아인 인구 백분율 을 출력하시오.

midwest %>% 
  mutate(per_allasian = popasian/poptotal) %>% 
  select(state,county,per_allasian) %>% 
  arrange(per_allasian)

#11. 다음에 제시된 문제를 각각 11-1, 11-2 로 넘버링 하여 해결 코드를 R로 작성한다.
# mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
# mpg 데이터 원본에는 결측치가 없습니다. 우선 mpg 데이터를 불러와 몇 개의 값을
# 결측치로 만들겠습니다. 아래 코드를 실행하면 다섯 행의 hwy 변수에 NA가 할당됩니다.
mpg <- as.data.frame(ggplot2::mpg)
mpg[c(65,124,131,153,212),"hwy"] <- NA
# 결측치가 들어있는 mpg 데이터를 활용해서 문제를 해결해보세요.

# 11-1 drv(구동방식)별로 hwy(고속도로 연비) 평균이 어떻게 다른지 알아보려고
# 합니다. 분석을 하기 전에 우선 두 변수에 결측치가 있는지 확인해야 합니다.
# drv변수와 hwy변수에 결측치가 몇 개 있는지 확인하시오.

table(is.na(mpg$drv))
table(is.na(mpg$hwy))

# 11-2 filter()를 이용해 hwy 변수의 결측치를 제외하고, 어떤 구동방식의 hwy
# 평균이 높은지 알아보세요. 하나의 dplyr 구문으로 만들어야 합니다.

mpg %>% 
  filter(!is.na(hwy)) %>% 
  group_by(drv) %>% 
  summarise(mean_drvhwy = mean(hwy))

#12. 다음에 제시된 문제를 각각 12-1, 12-2, 12-3 으로 넘버링 하여
#해결 코드를 R로 작성한다.
# mpg 데이터를 이용해 분석 문제를 해결해 보세요.
# 우선 mpg 데이터를 불러와서 일부러 이상치를 만들겠습니다. drv(구동방식)
# 변수의 값은 4(사륜구동), f(전륜구동), r(후륜구동) 세 종류로 되어있습니다.
# 몇 개의 행에 존재할 수 없는 값 k를 할당하겠습니다. cty(도시연비) 변수도
# 몇 개의 행에 극단적으로 크거나 작은 값을 할당하겠습니다.
mpg <- as.data.frame(ggplot2::mpg)
mpg[c(10,14,58,93),"drv"] <- "k"
mpg[c(29,43,129,203), "cty"] <- c(3,4,39,42)

# 이상치가 들어가 있는 mpg 데이터를 활용해 문제를 해결해 보세요.
# 구동방식별로 도시 연비가 다른지 알아보려고 합니다. 분석을 하려면 우선
# 두 변수에 이상치가 있는지 확인하려고 합니다.

# 12-1 drv에 이상치가 있는지 확인하세요. 이상치를 결측 처리한 다음 이상치가
# 사라졌는지 확인하세요. 결측 처리를 할 때에는 %in% 기호를 활용하세요.

table(mpg$drv)
mpg$drv <- ifelse(mpg$drv=="k",NA,mpg$drv)

# 12-2 상자 그림을 이용해서 cty 에 이상치가 있는지 확인하세요. 상자 그림의
# 통계치를 이용해 정상 범위를 벗어난 값을 결측 처리한 후 다시 상자 그림을
# 만들어 이상치가 사라졌는지 확인하세요.

boxplot(mpg$cty)$stats
summary(mpg$cty)
mpg$cty <- ifelse(mpg$cty<9 | mpg$cty>26, NA, mpg$cty)
moxplot(mpg$cty)

# 12-3 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다. 이상치를
# 제외한 다음 drv 별로 cty 평균이 어떻게 다른지 알아보세요. 하나의
# dplyr 구문으로 만들어야 합니다.

mpg %>% 
  filter(!is.na(drv)) %>% 
  group_by(drv) %>% 
  summarise(mean_changecty = mean(cty,na.rm =T))
