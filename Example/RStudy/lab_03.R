
# 문제 1] 
str(airquality)
summary(airquality)

# [문제2] 
x <- c(1,2,3,4,5)
y <- c(2,4,6,8,10)
df1 <- data.frame(x,y)
df1

# 문제 3
col1 <- c(1,2,3,4,5)
col2 <- c('a','b','c','d','e')   #letters[1:5]
col3 <- c(6,7,8,9,10)
df2 <- data.frame(col1,col2,col3)
df2

# 문제 4
c1 <- c('사과', '딸기', '수박')
c2 <- c(1800,1500,3000)
c3 <- c(24,38,13)
df3 <- data.frame(c1,c2,c3,stringsAsFactors = F)     #이름 부여하는 방법 기억이 안남.
colnames(df3) <- c("제품명","가격","판매량")
df3 <- data.frame(제품명=c('사과','딸기','수박'), 가격=c(1800,1500,3000), 판매량=c(24,38,13),stringsAsFactors=F)
df3

# 문제 5
mean(df3$가격)
mean(df3$판매량)   #뜨긴 뜨는데 경고창 무엇?

# 문제 6
name <- c("Potter", "Elsa", "Gates", "Wendy", "Ben")
gender <- factor(c("M", "F", "M", "F", "M"))
math <- c(85, 76, 99, 88, 40)
is.character(name); is.factor(gender); is.numeric(math)
df4 <- data.frame(name,gender,math,stringsAsFactors = F)
df4
str(df4)

#a
df4$stat <- c(76,73,95,82,35)
#b
df4$score <- df4$math+df4$stat
#c
df4$grade <- ifelse(df4$score>=150,"A",
                    ifelse(df4$score>=100,"B",
                           ifelse(df4$score>=70,"C","D")))

#문제 7
emp
str(emp)
summary(emp)

#문제 8
emp[c(3,4,5),]

#문제 9
emp[,c("ename")]
emp$ename

#문제 10
emp[,c("ename","sal")]

#문제 11
subset(emp,emp$job=="SALESMAN",c("ename","sal","job"))

#문제 12
subset(emp,emp$sal>=1000 & emp$sal<=3000,c("ename","sal","empno"))

#문제 13
subset(emp,emp$job!="ANALYST",c("ename","job","sal"))

#문제 14
subset(emp,emp$job=="SALESMAN" | emp$job=="ANALYST", c("ename","job"))

#문제 15
subset(emp, is.na(emp$comm), c("ename","sal"))

#문제 16
emp[order(emp$sal),]         #구글 도움을 받아서 원리를 모르겠다. => 풀어서 생각하니 알겠다.
order(emp$sal)
