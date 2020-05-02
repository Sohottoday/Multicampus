#제시된 memo.txt 파일을 행 단위로 읽어서 벡터를 리턴한다.
#벡터를 구성하고 있는 각 원소들의 내용을 확인한 후에 아래에 제시된 결과로
#변경되도록 문자 또는 문자열 변경을 시도한다. (gsub() 사용)
#원소마다 변경해야 하는 룰이 다르므로 원소마다 처리한다.
#처리된 결과를 memo_new.txt 파일에 저장한다. (write() 함수 사용)
#구현소스는 textmining1.R 로 저장하여 생성된 memo_new.txt 파일로 함께 제출한다.


scan("data/memo.txt",what = "",encoding="UTF-8")

memo1<-readLines("data/memo.txt", encoding = "UTF-8")
memo1
memo1[1]<-gsub("[[:punct:]]","",memo1[1])
memo1[2]<-gsub("e","E",memo1[2])
memo1[3]<-gsub("[[:digit:]]","",memo1[3])
memo1[4]<-gsub("[A-z]","",memo1[4]) #gsub("[[:upper:][:lower:]]","",memo1[4])  gsub("[A-Za-z]","",memo1[4])
memo1[5]<-gsub("[[:digit:][:punct:]]","",memo1[5])
memo1[6]<-gsub("[^가-힣]","",memo1[6])
memo1[7]<-gsub("YOU","you",memo1[7])
memo1[7]<-gsub("OK","ok",memo1[7])
length(memo1)<-7


write.table(memo1,file = "memo_new.txt")
