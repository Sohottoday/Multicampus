
# 문제 1
exam1<-function(){
  xxx<-paste(LETTERS,letters,sep="")
  return(xxx)
}
exam1()

# 문제 2
exam2<- function(p1) {
  xxx<-0
  for(n in 1:p1){
    xxx<-xxx+n
  }
  return(xxx)
}
exam2(5)
exam2(6)
exam2(7)
# 문제 3
exam3<-function(p1,p2) {
  xxx<-0
  if(p1>p2){
    xxx<- p1-p2
  } else if (p1==p2){
    xxx<-0
  } else {
    xxx<- p2-p1
  }
  return(xxx)
}
exam3(10,20)
exam3(20,5)
exam3(5,30)
exam3(6,3)

# 문제 4
exam4<-function(p1,p2,p3){
  xxx<-0
  if((p2=="%%" | p2=="%/%") & p1==0){
    xxx<-"오류1"
  } else if((p2=="%%" | p2=="%/%") & p3==0){
    xxx<-"오류2"
  } else {
    xxx<-switch(EXPR=p2,
         "+"=(p1+p3),
         "-"=(p1-p3),
         "*"=(p1*p3),
         "%/%"=(p1%/%p3),
         "%%"=(p1%%p3)
         )
  }
  return(xxx)
}
exam4(5,"+",10)
exam4(6,"*",5)
exam4(0,"%%",10)
exam4(4,"%/%",0)
0/5
5/0
# 문제 5
exam5<-function(p1,p2="#"){
  if(p1<0){
    p2<-""
  } else {
    for(i in 1:p1){
      cat(p2,sep="")
    }
  }
}
exam5(p1=5)
exam5(10,"$")
exam5(-5,"%")

# 문제 6
exam6<-function(p1){
  for(n in p1){
    if(is.na(n)){
      print("NA는 처리불가")      
    } else {
      if(n>=85 & n<=100){
        xxx<-"상"
#        print(paste(n,"점은 ",xxx,"등급 입니다.",sep=""))
      } else if(n>=70 & n<85){
        xxx<-"중"
#        print(paste(n,"점은 ",xxx,"등급 입니다.",sep=""))
      } else {
        xxx<-"하"
#        print(paste(n,"점은 ",xxx,"등급 입니다.",sep=""))
      }
      print(paste(n,"점은 ",xxx,"등급 입니다.",sep=""))
    }
  }
  
#  if(is.na(p1)){
#  } else {
#    for(n in p1) {
#      } else if(is.na(p1)){
#        if(n>=85 & n<=100){
#          xxx<-"상"
#          print(paste(n,"점은 ",xxx,"등급 입니다.",sep=""))
#        } else if(n>=70 & n<85){
#          xxx<-"중"
#          print(paste(n,"점은 ",xxx,"등급 입니다.",sep=""))
#        } else if(n<69){
#          xxx<-"하"
#          print(paste(n,"점은 ",xxx,"등급 입니다.",sep=""))
#      }
#    }
#  }
}

vvv <- c(88,77,66,55)
www <- c(85,75,T,55)
zzz <- c(44,NA,80)
exam6(88)
exam6(77)
exam6(52)
exam6(NA)
exam6(T)
exam6(vvv)
exam6(www)
exam6(zzz)
