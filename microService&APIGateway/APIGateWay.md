# API gateWay

API 게이트웨이의 기능들

#### 1. API 등록(registration)
API 개발팀에서 미리 정한 API 명세를 통해 URL을 포함하는 REST API 리소스 형태로 API 게이트웨이에 등록한다. API 명세는 Swagger라 부르는 OAS(OpenAPI Specification)를 많이 사용하며 YAML 또는 JSON형태로 작성한다.

#### 2. API 분기(routing)
클라이언트 API요청을 URL 경로 분석을 통해 해당 서비스를 담당하는 API 엔드 포인트로 연결하는 역할. 로드밸런서와 같이 특정 API 서버에 과다한 부하가 걸리지 않도록 트래픽을 분배하는 기능도 포함됨.

#### 3. API 사용자 인증(authentication)
인가된 클라이언트만 사용이 가능한 API의 경우, API키 또는 API토큰을 검사하여, 유효한 사용자만 API 응답을 받을 수 있도록 함.
최근에는 인증이 필요한 정보를 JSON파일로 전달하는 JWT(JSON Web Token)도 많이 사용함.

#### 4. API 캐싱(caching)
JSON이나 XML 형태를 가진 API 응답, proxy, CDN, 클라이언트에 일정 시간동안 캐싱이 가능하다. API는 데이터베이스 쿼리와 같은 백엔드 프로세스가 필요하기 때문에, 웹 성능에 영향을 미침. 그러므로 캐싱 최적화가 반드시 필요하다.

#### 5. API 사용빈도 제한(rate limiting)
과다한 API 사용 빈도를 API키 혹은 API클라이언트 별로 특정 시간에 몇 회로 제한하는 기능이다. API 공급자의 불필요한 트래픽 낭비를 막고 DDos성 공격을 막는 효과도 있다.

최근에는 REST API보다 좀 더 원하는 서비스 내용을 빠르고 가볍게 통신할 수 있는 GraphQL(Graph Query Language)에 대한 사용도 늘어나고 있다.
