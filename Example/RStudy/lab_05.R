
# 문제 1
grade <- sample(1:6,1)
grade <- as.character(grade)
result <- switch (EXPR=grade,
  "1"=,"2"=,"3"="저학년",
  "4"=,"5"=,"6"="고학년"
)
cat(grade,"학년은 ",result,"입니다\n",sep="")

# 문제 2
choice <- sample(1:5, 1)
choice <- as.character(choice)
result2 <- switch(EXPR=choice,
                  "1"=(300+50),
                  "2"=(300-50),
                  "3"=(300*50),
                  "4"=(300/50),
                  "5"=(300%%50)
)
cat("결과값",":",result2)

if(choice==1){
  cat("결과값",":",300+50)
}else if(choice==2) {
  cat("결과값",":",300-50)
}else if(choice==3) {
  cat("결과값",":",300*50)
}else if(choice==4) {
  cat("결과값",":",300/50)
}else {
  cat("결과값",":",300%%50)
}

# 문제 3
count <- sample(3:10, 1)
deco <- sample(1:3,1)
if(deco==1){
  for(q in 1:count) {
    cat("*")
  }
} else if(deco==2) {
  for(q in 1:count) {
    cat("$")
  }
}else{
  for(q in 1:count) {
    cat("#")
  }
}

# 문제 4
score <- sample(0:100,1)
#score <- as.character(score)
#result3 <- switch (EXPR=score,
#  "90"=,"91"=,"92"=,"93"=,"94"=,"95"=,"96"=,"97"=,"98"=,"99"=,"100"="A 등급",
#  "80"=,"81"=,"82"=,"83"=,"84"=,"85"=,"86"=,"87"=,"88"=,"89"="B 등급",
#  "70"=,"71"=,"72"=,"73"=,"74"=,"75"=,"76"=,"77"=,"78"=,"79"="C 등급",
#  "60"=,"61"=,"62"=,"63"=,"64"=,"65"=,"66"=,"67"=,"68"=,"69"="D 등급",
#  "F 등급"
#)
result3 <- switch (EXPR=as.character(score%/%10),
  "9"=,"10"="A 등급",
  "8"="B 등급",
  "7"="C 등급",
  "6"="D 등급",
  "F 등급"
)
cat(score,"점은 ",result3,"입니다",sep="")

# 문제 5
LETTERS
letters
cat(paste(LETTERS,letters,sep=""))

for(l in 1:26) {
  cat(paste('"',LETTERS[l],letters[l],'" ',sep=""))
}

for(l in length(letters)) {
  alpha[l]<-paste(LETTERS[l],letters[l],sep="")
}

alpha <-paste0(c(LETTERS[1:26]),c(letters[1:26]))
alpha<-paste(LETTERS,letters,sep="")
alpha


# 1차문제 좌우 따옴표 붙이는데 시간 잡아먹음
# 2차문제 alpha에 넣으려는데 NULL값이 뜸.