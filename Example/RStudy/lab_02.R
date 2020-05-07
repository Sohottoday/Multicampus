# 문제 1
ex1 <- seq(10,38,2)
m1 <- matrix(ex1,nrow = 3,ncol = 5, byrow = T)
m1
m2 <- m1+100
m2
m_max_v <- max(m1)
m_max_v
m_min_v <- min(m1)
row_max <- apply(m1,1,max)
row_max
col_max <- apply(m1,2,max)
col_max
m1; m2; m_max_v; m_min_v; row_max; col_max

# 문제 2
n1 <- c(1,2,3)
n2 <- c(4,5,6)
n3 <- c(7,8,9)
m2 <- cbind(n1,n2,n3)
m2

# 문제 3
m3 <- rbind(c(1,2,3),c(4,5,6),c(7,8,9))
m3

# 문제 4
rownames(m3) <- c("row1", "row2", "row3")
colnames(m3) <- c("col1", "col2", "col3")
m3

# 문제 5
alpha <- matrix(c("a","b","c","d","e","f"),nrow = 2,ncol = 3)
alpha
alpha2 <- alpha
ex2 <- matrix(c("x","y","z"), ncol = 3)
ex2
alpha2 <- rbind(alpha,ex2)
alpha2
ex3 <- matrix(c("s","p"),nrow = 2)
ex3
alpha3 <- cbind(alpha,ex3)
alpha3

# 문제 6
a <- array(1:24,dim=c(2,3,4))
a
a[2,3,4] #(1)
a[2,,]   #(2)
a[,1,]   #(3)
a[,,3]   #(4)
a+100    #(5)
a[,,4]*100   #(6)
a[1,2,];a[1,3,]   #(7)
a[2,,2] <- a[2,,2]+100
a[,,1] <-a[,,1]-2
a <- a * 10
a
rm(a)

