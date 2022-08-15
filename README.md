# report-musinsa

#기본 정보
- Spring boot 2.7.2
- Java 8
- H2 Database
- JPA


#상세 설명
package 분리
 - controller
 - domain
 - dto
 
 Base 데이터 -> docs에서 전달해준 데이터를 csv로 파일로 생성하여 기본값으로 DB에 저장하도록 설정
 
 #API 정보
 1. GET
  - /brand/total/min : 한 브랜드에서 모든 카테고리의 상품을 한꺼번에 구매할 경우 최저가 및 브랜드 조회
  - /brand/min/max/{category} : 카테고리 이름으로 최소,최대 가격 조회
  - /brand/all/min : 모든 카테고리의 상품을 브랜드 별로 자유롭게 선택해서 모든 상품을 구매할 때 최저가 조회
 
 2. POST
  - /brand/{brand_id} : Brand 생성
  
 3. PUT
  - /brand/{brand_id} : Brand 업데이트 (기존정보 존재시 update, 새로운 정보일시 create)
 
 4. DELETE
  - /brand/{brand_id} : Brand 삭제
