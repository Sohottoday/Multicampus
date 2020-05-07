# CLI

Command Line Interface(명령어 인터페이스) ->개발자의 진정한 간지라는데...



## 명령어들

- `ls` : 현재 디렉토리 내부의 파일 & 디렉토리를 보여줌(**l**i**s**t)
- `pwd` : 현재 위치를 출력함(**p**rint **w**orking **d**irectory) - 절대경로(최상단 디렉토리로 부터)

- `mkdir [디렉토리명]` : 디렉토리(폴더) 생성(**m**a**k**e **dir**ectory)

- `cd [경로]` : 디렉토리를 변경/이동(**c**hange **d**irectory)

  `cd ..` : 상위 디렉토리로 이동(**..**)

  `cd .` : 현재 디렉토리로 이동(**.**)

  ~~`cd /` : 루트(최상단) 디렉토리로 이동 (**/**)~~

  cd ~ : 홈 디렉토리로 이동(**~**)

- `git init` :  git으로 관리하는 폴더 지정(master 표시가 뜬다.)

- `ls -a` : 숨김 디렉토리 또는 파일까지 보여줌(**a**ll)

  `ls -al` : 숨김파일 리스트 표시

- `rm [파일명]` : 파일을 삭제함(**r**e**m**ove) 단, 단일 파일을 지우는 것이므로 폴더를 지울수는 없음.

- `rm -r` : 폴더 자체를 지워버림 = `rm -rf`

- 리눅스 시스템에서의 . 은 숨김이라는 뜻

- code : vsc open

- git status : git의 상태를 물어보는 명령어

- `git add [파일명]` : git에 올릴(커밋하기 위한) 준비를 완료하는 명령어

- `git rm --cached [파일명]` : 커밋 준비를 위해 올려둔 파일을 제거하는 명령어

- `git diff` : git에서의 작업 과정을 보여줌(이미 등록된 파일에 변동사항이 있었을 때 사용 가능)
- `:q! ` : commit 에디터창 종료 명령어
- ``git remote add \[저장소의 이름][저장소의 주소]`
  - 보통 repository의 주소를 복사해서 붙여넣는다.
  - ex)git remote add origin https://github.com/Sohottoday/githum-~~~
- `git push \[저장소의 이름][브랜치의 이름]`
  - ex) git push origin master