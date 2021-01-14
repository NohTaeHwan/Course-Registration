# 수강 신청 서비스

## List

1. [Overview](#overview)
2. [Project info](#project-info)
3. [Description](#)

## Overview

Spring을 이용한 수강 신청 서비스입니다. DB는 Mysql로 구성하였고 ORM으로 Hibernate를 사용하였습니다. Restful API를 구성하여 서버를 개발하였습니다. Web에서 Ajax를 이용하여 Rest API와 통신합니다. 웹 페이지 디자인은 부트스트랩을 활용했습니다. 



## Project info

#### 사용 기술 및 라이브러리

- JDK 1.8
- spring 4.3.18
- mysql8
- hibernate 5.3.7
- lombok
- spring-security
- apache tiles 3.0.8
- bootstrap
- Ajax

#### project structure

- project framework : maven , spring MVC
- directory-tree



## Description

#### 주요 기능

유저

- 과목 조회 : 교과목들의 목록 조회
- 특정 과목 조회 : 연도 , 학기 , 학과의 조건을 통해 특정 과목 조회

관리자

- 교과목 관리 페이지를 통해 과목 등록 , 수정 , 삭제 가능
- 교과목 등록 : 과목 정보를 입력하여 과목 생성
- 교과목 수정 : 과목 정보를 입력하여 과목 수정
- 교과목 삭제 : 선택 과목을 삭제

