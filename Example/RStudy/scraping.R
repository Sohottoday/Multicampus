install.packages("rvest")
library(rvest)

url<-"http://unico2013.dothome.co.kr/crawling/exercise_bs.html"
text1<-read_html(url)
text1

#<h1> 태그의 컨텐츠
node1 <-html_nodes(text1, "h1")
node1

#텍스트 형식으로 내용을 가지고 있는 <a> 태그의 컨텐츠와 href 속성값
node2 <-html_nodes(text1, "a")
content1 <- html_text(node2)
content1
style1 <- html_attr(node2, "href")
style1

#<img> 태그의 src 속성값
node3 <- html_nodes(text1, "img")
style2 <- html_attr(node3, "src")
style2

#첫 번째 <h2> 태그의 컨텐츠
node4 <- html_nodes(text1, "h2:nth-of-type(1)")
node4
html_text(node4)

#<ul> 태그의 자식 태그들 중 style 속성의 값이 green으로 끝나는 태그의 컨텐츠
node5 <- html_nodes(text1, "ul>*")
style3<-html_attr(node5, "style")
style3
html_text(node5[which(style3=="color:green")])

#두 번째 <h2> 태그의 컨텐츠
node6 <- html_nodes(text1, "h2:nth-of-type(2)")
node6
html_text(node6)

#<ul> 태그의 모든 자식 태그들의 컨텐츠 
node7 <- html_nodes(text1, "ol>*")
node7
html_text(node7)

#<table> 태그의 모든 자손 태그들의 컨텐츠 
node8 <- html_nodes(text1, "table>*>*")
node8
html_text(node8)

#name이라는 클래스 속성을 갖는 <tr> 태그의 컨텐츠
node9 <- html_nodes(text1, ".name")
node9
html_text(node9)

#target이라는 아이디 속성을 갖는 <td> 태그의 컨텐츠
node10 <- html_nodes(text1, "#target")
node10
html_text(node10)

