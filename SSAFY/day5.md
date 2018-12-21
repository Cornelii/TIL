
# day5

## I. 환경변수 지정
### 1. Concepts

환경변수는  운영체제(OS)수준에서 관리되는 변수



### 2. Practice with GitBash

1. home directory 이동 cd ~
2. code .bashrc (visual code 있을 때) (.bashrc 파일 만듬. 확장자x?!)

> 파일 내에 export {환경변수 이름}="{변수로 지정할 것들}"

로 파일 작성 후 저장

3. git Bash에서 cat .bashrc로 확인
4. source .bashrc 실행

**Tip** {

* 숨김파일을 만들 때 파일 이름 앞에 . 붙힘.환경변수는 모두 대분자로 쓰는게 관례

* cat .gitconfig 해서 이름 없을 시 등록방법

  * git config --global user.name "{이름}"
  * cat .gitconfig 해서 다시 확인하기.

* echo ${환경변수}  : 'echo'는 터미널의 print기능, 환경변수 앞에는 $를 붙임.

* ctrl+u: git bash에서 코드를 친상태에서 지울 시

* ctrl+l: clear의 줄임형

* alias 설정

  * code .bashrc

  * > alias name="command" 
    >
    > ex) alias jupyter="cd ~/work && jupyter notebook"

* Pyenv, Venv 참고

* python os 모듈 os.getenv("환경변수이름")으로 값을 가져올 수 있음.

* gitbash에서 환경변수 설정 시, 윈도우에서는 못 가져올 수 있음. (단, git bash에서 실행)

* python requests 모듈 객체에서 get을 통해 가져오면 .json() 메소드를 통해서

  json.loads()를 활용한 효과와 동일하게 json형식 변환 가능

* pprint.pprint()로 print를 대체하면 예쁘게 출력 가능.

  (ex) 

  ```python
  from pprint import pprint as pp
  pp(Dictionary, json file etc...)
  ```

* d
* sss
* Computer Engineering에서 가장 중요한 것은 추상화 **Abstraction**!!!!

}



## II. WEB의 데이터 송수신
### 1. Concepts

* GET: 정보를 가져오기. (브라우저 url 입력은 GET 방식. )

* POST: 상대쪽에서 데이터를 보냄. (get방식(url)로 접근 허용x)

  get은 flask request.args.get에서 한 번 해보았음.

* POST의 경우 request.form.get()으로 함.

### 2. Practice

**Tip** postman 참고.
**Tip** REST API 참고 (웹:, 모바일:jwt json web token)_get,post 대신

## III. Webhook (웹훅)
### 1.Concepts

현재는 서버에서 telegram으로 request.get을 단방향으로만 보내줄 수 있는 것임.

웹훅을 통해서 텔레그램에서 서버로 실시간으로 뭔가를 보낼 수 있게 됨.

setWebhook

### 2.Practice

**Tip** Cloud9에서 c9 ~/.bashrc (c9을 통해서 editor 켤 수 있음?!)
**Tip**

## IV.
