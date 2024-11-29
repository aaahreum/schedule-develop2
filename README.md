# schedule-develop2
- 로그인, 로그아웃 기능 추가
- Servlet Filter 적용
  
## API 명세서
## 일정
|기능|Method|URL|request|response|상태코드|
|---|---|---|---|---|---|
|일정 등|`POST`|/api/schedules|요청 body|등록 정보|201:CREATED, 404:NOT FOUND|
|전체 일정 조회|`GET`|/api/schedules|요청 param|다건 응답 정보|200:OK, 404:NOT FOUND|
|선택 일정 조회|`GET`|/api/schedules/{id}|요청 param|단건 응답 정보|200:OK, 404:NOT FOUND|
|선택 일정 수정|`PUT`|/api/schedules/{id}|요청 body|수정 정보|200:OK, 404:NOT FOUND|
|선택 일정 삭제|`DELET`|/api/schedules/{id}|요청 param|삭제 정보|200:OK, 404:NOT FOUND|

### 일정 등록
- POST
- /api/schedules
- request
  ```
  {
    "title" : "제목",
    "contents" : "내용",
    "username": "test"
  }  
  ```
- response
- 상태 코드 </br> 201:CREATED, 404:NOT FOUND
### 전체 일정 조회
- GET
- /api/schedules
- 상태 코드 </br> 200:OK, 404:NOT FOUND
### 선택 일정 조회
- GET
- /api/schedules/{id}
- 상태 코드 </br> 200:OK, 404:NOT FOUND
### 선택 일정 수정
- PUT
- /api/schedules/{id}
- request
    ```
  {
    "title" : "제목 수정",
    "contents" : "내용 수정",
  }  
  ```
- 상태 코드 </br> 200:OK, 404:NOT FOUND
### 선택 일정 삭제
- DELETE
- /api/schedules/{id}
- 상태 코드 </br> 200:OK, 404:NOT FOUND

--------

## 유저
|기능|Method|URL|request|response|상태코드|
|---|---|---|---|---|---|
|유저 등록|`POST`|/api/users|요청 body|등록 정보|201:CREATED, 404:NOT FOUND|
|전체 유저 조회|`GET`|/api/users|요청 param|다건 응답 정보|200:OK, 404:NOT FOUND|
|선택 유저 조회|`GET`|/api/users/{id}|요청 param|단건 응답 정보|200:OK, 404:NOT FOUND|
|선택 유저 삭제|`DELET`|/api/users/{id}|요청 param|삭제 정보|200:OK, 404:NOT FOUND|

### 유저 등록
- POST
- /api/users
- request
  ```
  {
     "name": "이름",
     "email": "aaa@naver.com",
     "password": "1234"
  }  
  ```
- response
- 상태 코드 </br> 201:CREATED, 404:NOT FOUND
### 전체 유저 조회
- GET
- /api/users
- 상태 코드 </br> 200:OK, 404:NOT FOUND
### 선택 유저 조회
- GET
- /api/users/{id}
- 상태 코드 </br> 200:OK, 404:NOT FOUND

### 선택 유저 삭제
- DELETE
- /api/users/{id}
- 상태 코드 </br> 200:OK, 404:NOT FOUND

--------

## ERD
![schedule](https://github.com/user-attachments/assets/c4d210b0-63a6-4b86-90ed-2e48192306a9)





-------
