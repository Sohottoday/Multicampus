result<-scan("data/iotest2.txt",what = "")
table(result)

ab<-table(result)
cat(names(ab[which.max(ab)]),"입니다")
cat("가장 많이 등장한 단어는 R(9회)입니다.")