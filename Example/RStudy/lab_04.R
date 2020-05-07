# 문제 1
L1 <- list(
  name = "scott",
  sal = 3000
)
result1 <- L1$sal*2

# 문제 2
L2 <- list("scott",c(100,200,300))

# 문제 3
#list(c(3,5,7), c("A","B","C"))[[2]][1] <- "Alpha"
L3 <- list(c(3,5,7), c("A","B","C"))
L3[[2]][1] <- "Alpha"

# 문제 4
L4 <- list(alpha=0:4, beta=sqrt(1:5), gamma=log(1:5))
L4$alpha+10

# 문제 5
L5 <- list(
  math = list(95, 90),
  writing = list(90,85),
  reading = list(85,80)
)
unlist(L5)
mean(unlist(L5))

# 문제 6
time <- 32150
(time%/%3600)
(time%%3600%/%60)
(time%%3600%%60)
c((time%/%3600),"시간",(time%%3600%/%60),"분",(time%%3600%%60),"초")
t1 <- c((time%/%3600),(time%%3600%/%60),(time%%3600%%60))
t2 <- c("시간","분","초")
paste(t1, t2, collapse = "",sep = )
