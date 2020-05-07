
# 문제 1
countEvenOdd <- function(p1) {
  res <-NULL
  xxx <- 0
  yyy <- 0
    if(!is.vector(p1))   {
      res<-NULL
    } else {
      for(n in p1) {
        if(n%%2==0) {
          xxx <- xxx+1
        } else {
          yyy <- yyy+1
        }
      }
      res <- list(even=xxx,odd=yyy)
    }
  return(res)
  }
  
aaa <- c(2,4,5,6,7)
countEvenOdd(aaa)

# 문제 2
vmSum <- function(p1){
  xxx<-NULL
  if(!is.vector(p1) | is.list(p1)){
    cat("벡터만 전달하숑!")
  } else if(is.vector(p1) & is.character(p1)) {
    cat("숫자 벡터를 전달하숑!")
    xxx<-0
    
  } else {
    xxx<-sum(p1)
  }
  return(xxx)
}

aaa<- c(2,4,6,8,10)
bbb<- c(5,7,6,"으쌰")
ccc<- list(
  a=1,2,3,
  b=4,5,6
)
vmSum(aaa)
vmSum(bbb)
vmSum(ccc)

sum(aaa)


# 문제 3
vmSum2 <- function(p1){
  xxx<-NULL
  if(!is.vector(p1) | is.list(p1)) {
    stop("벡터만 전달하슈")
    xxx<-NULL
  } else if(is.vector(p1) & is.character((p1))) {
    warning("숫자 벡터를 전달하슈")
    xxx<-0
  } else {
    xxx<-sum(p1)
  }
  return(xxx)
}

vmSum2(aaa)
vmSum2(bbb)
vmSum2(ccc)


# 문제 4
mySum <- function(p1) {
  oddSum<-0
  evenSum<-0
  if(!is.vector(p1) | is.list(p1)){
    stop("벡터만 처리 가능")
  } else if(is.vector(p1) & any(is.na(p1))){
    warning("NA를 최저값으로 변경하여 처리함")
    p1 <-replace(p1,list=is.na(p1),values = min(p1,na.rm = TRUE))
    for(n in p1){
      if(n%%2==0) {
        oddSum<-oddSum+n
      } else {
        evenSum<-evenSum+n
      }
    }
    res<-list(oddSum=oddSum, evenSum=evenSum)
    
  } else if(is.null(p1)) {
    xxx <- NULL
  } else {
    for(n in p1){
      if(n%%2==0) {
        oddSum<-oddSum+n
      } else {
        evenSum<-evenSum+n
      }
    }
    res<-list(oddSum=oddSum, evenSum=evenSum)
  }
  return(res)
}
def<-c(3,5,2,NA,NA)
mySum(aaa)
mySum(def)

# 문제 5
myExpr <- function(p1) {
  xxx<-NULL
  if(!is.function(p1)){
    stop("수행 안할것임!")
  } else {
    xxx<-sample(1:45, 6)
  }
  return(xxx)
}

myExpr(vmSum2)
myExpr(aaa)

# 문제 6
createVector1 <- function(...) {
  p<-c(...)
  res<-NULL
  if(is.null(p)){
    res<-NULL
  } else if(any(is.na(p))){
    res<-NA
  } else {
    res<-p
  }
  return(res)
}
ooo <- NULL
uuu <- NA
jjj <- 5
jj <- 4
jjjj <- 3
createVector1(aaa)
createVector1(ooo)
createVector1(uuu)
createVector1(jj,jjj,jjjj)
createVector1(jj,jjj,jjjj,uuu)
createVector1()

# 문제 7
createVector2 <- function(...) {
  p<-list(...)
  cnt<-0
  nu<-c()
  ch<-c()
  tf<-c()
  res<-NULL
  if(is.null(p)){
    res<-NULL
  } else if(any(is.na(p))){
    res<-NA
  } else {
    for(n in p) {
      if(is.numeric(n)) {
        nu<-c(nu,n)
      } else if(is.character(n)) {
        ch<-c(ch,n)
      } else {
        tf<-c(tf,n)
      }
    }
    res<-list("숫자"=nu,"문자"=ch,"논리"=tf)
  }
  return(res)
}
jjjjj<-"하위"
createVector2(jj,jjj,jjjj)
createVector2(jj,jjj,jjjj,jjjjj)
createVector2(jj,jjj,jjjj,uuu)
createVector2()
createVector2(1,5,7,"굿바이",TRUE,F)
