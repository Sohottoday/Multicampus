# 문제 1

click_log<-read.table("data/product_click.log")
click_cnt<-click_log[2]

p001<-length(which(click_cnt$V2=="p001"))
p002<-length(which(click_cnt$V2=="p002"))
p003<-length(which(click_cnt$V2=="p003"))
p004<-length(which(click_cnt$V2=="p004"))
p005<-length(which(click_cnt$V2=="p005"))
p006<-length(which(click_cnt$V2=="p006"))
p007<-length(which(click_cnt$V2=="p007"))
p008<-length(which(click_cnt$V2=="p008"))
p009<-length(which(click_cnt$V2=="p009"))
p010<-length(which(click_cnt$V2=="p010"))

  
click_summary<-c(p001,p002,p003,p004,p005,p006,p007,p008,p009,p010)

barplot(click_summary, main = "세로바 그래프 실습",xlab="상품ID",ylab="클릭수",col=terrain.colors(10))

dev.copy(png,"clicklog1.png")
dev.off()

# 문제 2

summary(click_log)
click_time<-click_log$V1
click_timeCnt<-as.factor(substr(click_time,9,10))
cclicckk<-as.numeric(levels(click_timeCnt))
table(click_timeCnt)
summary(click_timeCnt)
pie(table(click_timeCnt),labels = paste(cclicckk,"~",(cclicckk+1)) ,col = rainbow(10),main = "파이그래프 실습")

dev.copy(png, "clicklog2.png")
dev.off()

#table(click_log$V1)
#hour0<-length(which(click_timeCnt=="00"))
#hour1<-length(which(click_timeCnt=="01"))
#hour2<-length(which(click_timeCnt=="02"))
#hour3<-length(which(click_timeCnt=="03"))
#hour4<-length(which(click_timeCnt=="04"))
#hour5<-length(which(click_timeCnt=="05"))
#hour6<-length(which(click_timeCnt=="06"))
#hour7<-length(which(click_timeCnt=="07"))
#hour8<-length(which(click_timeCnt=="08"))
#hour9<-length(which(click_timeCnt=="09"))
#hour10<-length(which(click_timeCnt=="10"))
#hour11<-length(which(click_timeCnt=="11"))
#hour12<-length(which(click_timeCnt=="12"))
#hour13<-length(which(click_timeCnt=="13"))
#hour14<-length(which(click_timeCnt=="14"))
#hour15<-length(which(click_timeCnt=="15"))
#hour16<-length(which(click_timeCnt=="16"))
#hour17<-length(which(click_timeCnt=="17"))
#hour18<-length(which(click_timeCnt=="18"))

#click_timePie<-NULL
#for(n in 0:18) {
  #hourvv<-paste("hour",n,sep = "")
  
#  if(hourvv>0)
#  click_timePie<-c(click_timePie,hourvv)
#}
#click_timePie<-c(hour0,hour1,hour2,hour3,hour4,hour5,hour6,hour7,hour8,hour9,hour10,hour11,hour12,hour13,hour14,hour15,hour16,hour17,hour18)
#click_labels<-paste(0:23,"~",1:24)

