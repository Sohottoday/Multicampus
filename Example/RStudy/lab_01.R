# 문제 1
v1 <- 1:10
v1
v2 <- v1*2
v2
max_v <- max(v2)
max_v
min_v <- min(v2)
min_v
avg_v <- mean(v2)
avg_v
sum_v <- sum(v2)
sum_v
v3 <- v2[c(-5)]
v3
v1; v2; v3; max_v; min_v; avg_v; sum_v;


# 문제 2
v4 <- seq(from=1, to=9, by=2)
v4
v5 <- rep(1, 5)
v5
v6 <- rep(1:3, 3)
v6
v7 <- rep(1:4, each=2)
v7
v4; v5; v6; v7

# 문제 3
nums <- sample(1:100, 10)
sort(nums)
sort(nums, decreasing = T)
nums[nums>50]
which(nums<=50)
which.max(nums)
which.min(nums)

# 문제 4
v8 <- seq(from=1, to=10, by=3)
v8
names(v8) <- c("A","B","C","D") #LETTERS[1:4]
v8

# 문제 5
score <- sample(1:20, 5)
score
myfriend <- c("둘리", "또치", "도우너", "희동", "듀크")
myfriend
paste(score, myfriend, sep="-")
myfriend[which.max(score)]
myfriend[which.min(score)]
myfriend[which(score>10)]
