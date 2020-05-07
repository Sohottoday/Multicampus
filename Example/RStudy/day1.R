v1<-1:10
v2<-v1+100
print(v2)
# R은 열심히 합세다

v1 <- c(4, 1, 8, 6, 10)        #c는 기본적인 벡터를 입력하는 함수
print(v1)
v1
?rep   # 
#1번째 아규먼트를 2번째 아규먼트만큼 반복
rep(1, 100)   #1을 100번 반복
rep(1:3, 5)   #1부터 3까지를 5번 반복
rep(1:3, times=5)     #1부터 3까지를 5번 반복 / 키워드 파라미터 = 매개변수를 부여하는것
rep(1:3, each=5)      #1부터 3까지 각각 5번씩 반복

LETTERS
letters
month.name             
month.abb
pi               #이미 지정되어 있는 변수들

LETTERS;letters;month.name;month.abb;pi         # 이와같이 세미콜론으로 구분하여 출력 가능

LETTERS[1]; LETTERS[3:5]     #LETTERS[1] = LETTERS[c(1)] / LETTERS[3:5] = LETTERS[c(3,4,5)]
LETTERS[5:3]; LETTERS[-1]; #-를 주면 빼고 라는 뜻 따라서 A를 빼고 모두 출력
LETTERS[c(-2,-4)] # B와 D를 빼고 모두 출력

length(LETTERS)
length(month.name)
length(pi)    #length는 길이를 출력하는 함수


x <- c(10,2,7,4,15)
x
print(x)
class(x)    # 무슨 타입으로 구성되어 있는지 확인
rev(x)      # 기존의 순서를 뒤집는것
range(x)    # 범위(최소값에서부터 최대값까지)
sort(x)     # 값이 작은것부터 정렬
sort(x, decreasing = TRUE)   #값을 큰것부터 작은것으로 정렬
sort(x, decreasing = T)
#x <- sort(x)    / rev나 sort등 실제 데이터를 변환시키지는 않는다.
order(x)       #작은 값부터의 위치 2 4 3 1 5 => 가장 작은값은 2번째 index에 그다음 작은값은 4번째에 그 다음 작은 값은 3번째에 ~~ 이런식

order(x, decreasing = T)

x[3] <- 20    #3번째 원소값을 20으로 할당하시오
x
x + 1   #원소마다 연산되는것을 벡터연산
x <- x + 1
max(x);min(x);mean(x);sum(x)
summary(x)   # 요약하는 함수 MEDIAN 중간값, 1st Qu 1/4위치 값, 3rd Qu 3/4위치 값

x[c(2,4)] # x[2], x[4] 2번째와 4번째만 추출
x[c(F,T,F,T,F)] ; x[c(T,F)] #T값만 출력 2번째같은 경우에는 T F T F T F 반복되면서 T값만 출력
x > 5
x[x > 5] 
x[x > 5 & x < 15]  #일반적인 코딩언어처럼 &나 | 기호를 2개쓰지 않는다.
x[x > 5 | x < 15]

names(x)     #원소마다 이름이 부여되어 있는 벡터
names(x) <- LETTERS[1:5]
names(x) <- NULL
x[2];x["B"];# x[B()]


# &, &&
c(T, T, F, F) & c(T, F, T, F)
c(T, T, F, F) | c(T, F, T, F)
c(T, T, F, F) && c(T, F, T, F)
c(T, T, F, F) || c(T, F, T, F)


ls()    # 지금까지 만들어진 변수들 리스트를 보여줌
rm(x)  # REMOVE 즉, 삭제한다는 뜻 ->x를 삭제함
x
class(x)

rainfall <- c(21.6, 23.6, 45.8, 77.0, 
              102.2, 133.3,327.9, 348.0, 
              137.6, 49.3, 53.0, 24.9)
rainfall > 100
rainfall[rainfall > 100]
which(rainfall > 100)        # 연산에 맞는 값의 index값(위치값) 알려줌
month.name[which(rainfall > 100)]    #조건에 맞는 위치값의 이름들
month.abb[which(rainfall > 100)]     # 
month.korname <- c("1월","2월","3월",
                   "4월","5월","6월",
                   "7월","8월","9월",
                   "10월","11월","12월")
month.korname[which(rainfall > 100)]
which.max(rainfall)
which.min(rainfall)
month.korname[which.max(rainfall)]
month.korname[which.min(rainfall)]


sample(1:20, 3)    #중복을 제거하고 첫번째 아규먼트중에 두번째 아규먼트개만큼 랜덤추출하라
sample(1:45, 6)
sample(1:10, 7)
sample(1:10, 7, replace=T)    #replace=T 는 중복을 허용한다는 뜻

count <- sample(1:100,7)
month.korname <- c("일요일", "월요일", "화요일",
                   "수요일", "목요일", 
                   "금요일", "토요일")

paste(month.korname, count, sep = ":")   #첫번째 원소와 두번째 원소를 sep값을 활용해 하나의 문자열로 만들어준다. sep값이 없는 default값은 공백이다.
# 공백 없이 붙이고 싶을땐 sep="" 이런식으로 널값을 준다.
month.korname[which.max(count)]
month.korname[which.min(count)]
month.korname[which(count > 50)]

paste(month.korname, count, sep = " : ")    #paste : 문자열을 결합시켜주는 함수

paste("I'm","Duli","!!")  #아규먼트가 몇개가 오던 입력되는 가변형 함수이다.
paste("I'm","Duli","!!", sep="")   #따라서 델리미터를 줄 때 sep를 반드시 입력하는것이 좋다.
paste0("I'm","Duli","!!")   #paste0는 dafault값이 ""와 같다.

fruit <- c("Apple", "Banana", "Strawberry")
food <- c("Pie","Juice", "Cake")
paste(fruit, food)

paste(fruit, food, sep="")
paste(fruit, food, sep=":::")
paste(fruit, food, sep="", collapse="-")  # collapse = 각각의 원소들을 구분하는  정의
paste(fruit, food, sep="", collapse="")
paste(fruit, food, collapse=",")


# matrix 실습
x1 <-matrix(1:8, nrow = 2)
x1
x1<-x1*3
x1

sum(x1); min(x1);max(x1);mean(x1)

x2 <-matrix(1:8, nrow =3)
x2

(chars <- letters[1:10])

mat1 <-matrix(chars)
mat1; dim(mat1)
matrix(chars, nrow=1)
matrix(chars, nrow=5)
matrix(chars, nrow=5, byrow=T)
matrix(chars, ncol=5)
matrix(chars, ncol=5, byrow=T)
matrix(chars, nrow=3, ncol=5)
matrix(chars, nrow=3)


vec1 <- c(1,2,3)
vec2 <- c(4,5,6)
vec3 <- c(7,8,9)
mat1 <- rbind(vec1,vec2,vec3); mat1
mat2 <- cbind(vec1,vec2,vec3); mat2
mat1[1,1]
mat1[2,];mat1[,3]
mat1[1,1,drop=F]
mat1[2,,drop=F];mat1[,3,drop=F]

rownames(mat1) <- NULL
colnames(mat2) <- NULL
mat1;mat2
rownames(mat1) <- c("row1","row2","row3")
colnames(mat1) <- c("col1","col2","col3")
mat1
ls()
mean(x2)
sum(x2)
min(x2)
max(x2)
summary(x2)

mean(x2[2,])
sum(x2[2,])
rowSums(x2); colSums(x2)

apply(x2, 1, sum); apply(x2, 2, sum)  
?apply
apply(x2, 1, max)
apply(x2, 1, min)
apply(x2, 1, mean)

apply(x2, 2, max)
apply(x2, 2, min)
apply(x2, 2, mean)

