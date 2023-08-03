문제



현재 테스트 기간으로 테스트 코드를 꼼꼼하게 작성을 요구한다.
정상적으로 등록 수정 삭제가 되는지 확인한다.

-회원 -
회원의 pk는 데이터베이스에서 관리하는 전략을 사용한다.
회원의 닉네임의 길이는 최대 10자이다.
회원의 닉네임은 중복되지 않는다.
회원의 전화번호의 기본값은 010-0000-0000이다.
권한은 enumType으로 관리한다.
등록일,수정일은 날짜및 시간이 모두 저장되며
삭제일은 날짜만 표기한다.
수정일 삭제일을 제외한 모든 컬럼은 null을 허용하지 않는다.

- 주문
  주문번호는 데이터 베이스에서 관리한다.
  참조되는 회원번호는 무시한다.
  주문 상태, 수정일, 삭제일은 날짜 타입으로 원하는 설정으로 저장한다.

-- 주문 매핑
@EmbeddedId을 이용하여 주문번호화 제품 번호를 정의하여 참조한다.


-- 제품
제품 테이블의 접근은 필드 접근 타입이 아닌 속성 접근타입으로 설정한다.
제품 번호는 데이터베이스에서 관리한다.
제품명은 중복되지 않는다.
제품 가격은 입력시 int로 사용자에게 입력을 받으나 저장시 000원으로 저장한다.