# Developer_Interview
Translated by my tongue.

reference : [github regarding interview]()
**Tips**
1. Simple Concepts
2. Pros/Cons

## I. Common things

#### 1. Object Oriented Programming (OOP)
##### i. Concept
Object Oriented Programming concept is based on attempt implement real world to the code by Abstraction. They see an objects as a thing that have attributes, and behaviours.

객체지향프로그래밍 개념은 현실 세계를 추상화를 통해 그대로 코드로 구현하고자 하는 노력에 있습니다. 객체를 특성과 행동을 가지는 것으로 보고 구현하게 됩니다.

##### ii. Pros and Cons
Pros: Reusability => more Productive, more human-friendly
Cons: overhead (much load on hardware), state?! <=> Functional Programming

장점: 재사용성을 통해 생산성을 올릴 수 있습니다.
단점: 객체 간의 정보교환에 발생하는 부하가 조금 더 있습니다.
(함수형 프로그래밍?!)

#### 2. RESTful API
RESTful API is an abbreviation of REpresentational State Transfer. It is a convention regarding URL. In short, Getting rid of verbs in url. Implementaing web services can be thought as implemening CRUD operations in DataBase. In the past, we used two Http methods to do that: GET, and POST. R. Retreive is by GET. and C U D are by POST method. In this situation POST have in charge of several operations. It causes nessecity of various classifier in url such as create, update, and delete. Rather than using only these two Http methods, to move over this kinds of verbs to the backside by adding Http methods like put/patch, delete, and so on. It is RESTful API.



RESTful API는 REpresentational State Transfer의 약자입니다. URL에 관련된 규약으로, 한마디로 설명하자면, url에서 동사를 없애자는 것입니다. 웹 서비스를 구현하는 것은 데이터베이스의 CRUD operation을 적절히 구현하는 것이라고 생각할 수 있습니다. 기존의 Http method의 GET과 POST를 이용한 구현에서는 주로, CRUD의 R. Retreive는 GET으로, C U D. Create, Update, 그리고 Delete는 POST로 구현하였습니다. 문제는 POST로 여러 동작을 함께 구현하다보니, 이를 구분하기 위해서, url에 데이터에 관련된 resource이외에, create, update, delete등의 동사와 관련된 구분자가 들어가야 했습니다. 이를, Http method를 put/patch, delete등을 추가함으로써 Http method로 구분하고, url에는 db에 연관된 resource만 분명히 나타내자는 약속입니다.

#### 3. Test-Driven Development (TDD)
TDD is a paradigm in which writing test code


Test 코드를 다 짜 놓은 뒤에, 서비스를 개발하면서 Test문제 여부를 확인하며 개발하는 패러다임.

Pros: 소프트웨어가 복잡해질수록, 함수, 데이터 간의 얽힘이 심해질 수록 빠르게 문제 여부를 확인하며 개발할 수 있어서, 장기적으로는 관리와 생산성이 향상될 수 있으며, 보다 예상치 못한 버그로부터 강건한 소프트웨어를 개발할 수 있다.

Cons: Test코드를 짜는 것 자체가 많은 에너지가 된다. 단기적인 프로젝트의 소프트웨어 개발에는 적합하지 않을 수도 있다.


#### 4. 함수형 프로그래밍


#### 5. MVC 패턴 (MTV)

#### 6. MicroService


#### 7. TCP / UDP
User Datagram Protocol (UDP)
* IP 데이터그램을 캡슐화하여 보내는 방법과 연결 설정을 하지 않고 보내는 방법을 제공.
흐름제어, 오류제어, 혹은 재전송을 하지 않는다.

DNS에 쓰임.
사전 설정과 해제가 필요 없다.

Transmission Control Protocol (TCP)
신뢰성과 순차적전달이 필요한 대부분의 인터넷 응용 분야에는 TCP가 사용된다.
송수신자 모두 소켓을 생성하고, TCP에서 3-way-handshake를 통해서 연결된다.
전이중 (full-duplex): 전송이 양방향 동시에 일어날 수 있음.
점대점 (point to point): 연결이 정확히 2개의 종단점 (socket)을 가지고 있다.

#### 8. HTTP & HTTPS
HTTP의 문제점:
1. HTTP는 평문 통신=> 도청 가능
2. 통신 상대를 확인하지 않기 때문에, 위장 가능
3. 완전성을 증명할 수 없어, 변조 가능

* 도청에 대한 보안 방법:
    1. 통신 자체를 암호화 => SSL (Secure Socket Layer), and TLS(Transport Layer Security) 등의 다른 프로토콜과 조합함으로 암호화. etc: SSL + HTTP => HTTPS
    2. 콘텐츠를 암호화

* 위장에 대한 보안 방법:
    SSL에서 제공하는 증명서를 활용. (통신 상대가 내가 통신하고자 하는 서버임을 나타내도록)

* 변조(정보의 정확성을 해치는)에 대한 보안 방법:
    1. MD5, SHA-1 등의 해시값활용.
    2. HTTPS를 활용해야 한다.

결국 모두 SSL => 사용하라는 거네.

**HTTPS**
HTTP <=> SSL <=> TCP 통신.
(공통키 암호화, 공개키 암호화 방식을 혼합하여 사용.) 

![HTTPS is faster than HTTP?!](https://tech.ssut.me/https-is-faster-than-http/)



#### 9. 공통키 암호화와 공개키 암호화


#### 10. DNS round robin, weighted round robin, least-connection


#### 11. 우리가 브라우저를 실행히켜 특정 URL을 입력시키면 어떤 일이 일어나는가?!

##### i. in Browser
    1. 브라우저 내부에서 정해진 규칙에 따라 의미를 조사
    2. 조사된 의미에 맞춰 HTTP requset 메시지 작성
    3. 만들어진 메시지를 웹 서버로 전송.
    (전송 자체는 브라우저가 직접하는 것이 아니고, OS에 송신을 의뢰함. 이 과정에서는 도메인명이 아니라 ip주소로 상대를 지정해야 하기 때문에 DNS서버를 조회해야함.)

##### ii. Protocol Stack, LAN adaptor
    1. protocol stack(network control sofrware in OS)이 브라우저로 부터 메시지를 받음.
    2. 메시지를 패킷 속에 저장
    3. 여러 제어정보를 덧붙인뒤 패킷을 LAN어댑터에 넘김.
    4. LAN 어댑터는 패킷을 전기신호로 변환시키고, 신호를 LAN 케이블에 송출함.
프로토콜 스택은 일종의 네트워크 세계의 비서?!

##### iii. Hub, Switch, and Router.
    1. LAN어댑터가 송신한 패킷은 스위칭 허브를 경유, 인터넷 접속을 위한 라우터에 들어감.
    2. 라우터는 패킷을 통신사(Provider)에게 전달함.

##### iv. Access line, and Provider
    1. 패킷은 통신회선(Access line)에 의해 POP(Point Of Presence)가지 운반됨.
    2. POP를 거쳐 인터넷으로 들어가서 목적지를 향해 흘러감.

##### v. 방화벽, 캐시서버
    1. 패킷이 웹 서버측의 LAN에 도착함.
    2. 방화벽이 도착한 패킷을 검사함.
    3. 패킷이 웹서버까지 갈지 말지를 판단하는 캐시서버가 존재

##### vi. 웹서버
    1. 웹 서버의 프로토콜 스택이 패킷을 추출하여 메시지를 복원, 웹 서버 어플리케이션에 넘김.
    2. 웹 서버 어플리케이션은 요청 메시지에 따른 데이터를 응답메시지에 넣어 클라인트로 회송!
    3. 왔던 방식을 따라서 응답 메시지가 클라이언트에게 전달 됨.



## II. OS



## III. Database


## IV. BlockChain

## V. Idea

## VI. MachineLearning

## XXVIII. Etc


## XXIX. Question Based on Purpose of Statements




## XXX. 1min PR
안녕하십니까? ~~~~ 손지명입니다.



