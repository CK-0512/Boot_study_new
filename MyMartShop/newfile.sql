
/* Drop Triggers */

DROP TRIGGER TRI_Article_a_id;



/* Drop Tables */

DROP TABLE Article CASCADE CONSTRAINTS;
DROP TABLE Supply CASCADE CONSTRAINTS;
DROP TABLE Company CASCADE CONSTRAINTS;
DROP TABLE Indent CASCADE CONSTRAINTS;
DROP TABLE Goods CASCADE CONSTRAINTS;
DROP TABLE Member CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_Article_a_id;




/* Create Sequences */

CREATE SEQUENCE SEQ_Article_a_id INCREMENT BY 1 START WITH 1;



/* Create Tables */

-- 게시글
CREATE TABLE Article
(
	-- 글 번호
	a_id number NOT NULL,
	-- 작성자
	memberId varchar2(20) NOT NULL,
	-- 제목
	title varchar2(30) NOT NULL,
	-- 내용
	body clob NOT NULL,
	-- 이미지
	a_fileName varchar2(100) NOT NULL,
	-- 작성 일자
	writeDate date DEFAULT sysdate NOT NULL,
	-- 조회수
	hitCount number DEFAULT 0 NOT NULL,
	-- 비밀글 : 0 = 공개글, 1 = 비밀글
	secret number DEFAULT 0 NOT NULL,
	-- 글 종류 : notice = 공지사항, review = 리뷰, inquiry = 문의
	type varchar2(10) NOT NULL,
	PRIMARY KEY (a_id)
);


-- 제조업체
CREATE TABLE Company
(
	-- 제조사
	c_name varchar2(50) NOT NULL,
	-- 법인번호
	corNum varchar2(30) NOT NULL,
	-- 연락처
	c_tel varchar2(11) NOT NULL,
	-- 위치
	location varchar2(100) NOT NULL,
	-- 담당자
	manager varchar2(20) NOT NULL,
	-- 등록일자
	regDate date DEFAULT sysdate NOT NULL,
	PRIMARY KEY (c_name)
);


-- 상품
CREATE TABLE Goods
(
	-- 상품 번호
	g_Id number NOT NULL,
	-- 상품명
	g_name varchar2(20) NOT NULL,
	-- 이미지
	g_fileName varchar2(100) NOT NULL,
	-- 재고량
	g_amount number NOT NULL,
	-- 단가
	price number NOT NULL,
	-- 등록일자
	regDate date DEFAULT sysdate NOT NULL,
	PRIMARY KEY (g_Id)
);


-- 주문
CREATE TABLE Indent
(
	-- 주문 번호
	i_id number NOT NULL,
	-- 주문 수량
	i_amount number NOT NULL,
	-- 배송지
	address varchar2(100) NOT NULL,
	-- 주문 일자
	indentDate date DEFAULT sysdate NOT NULL,
	-- 총 금액
	totalPrice number NOT NULL,
	-- 상품 번호
	g_id number NOT NULL,
	-- 구매자
	memberId varchar2(20) NOT NULL,
	PRIMARY KEY (i_id)
);


-- 회원
CREATE TABLE Member
(
	-- 회원 아이디
	memberId varchar2(20) NOT NULL,
	-- 비밀번호
	pass varchar2(100) NOT NULL,
	-- 이름
	m_name varchar2(20) NOT NULL,
	-- 연락처
	m_tel varchar2(11) NOT NULL,
	-- 나이
	age number NOT NULL,
	-- 직업
	job varchar2(20) NOT NULL,
	-- 회원 등급 : 총 구입금액 0~ 500,000원 미만 일반, 1,000,000미만 우수, 2,000,000미만 VIP, 2,000,000이상 VVIP
	grade varchar2(20) DEFAULT '일반' NOT NULL,
	-- 총 구입금액
	totalSpent number DEFAULT 0 NOT NULL,
	-- 적립금
	point number DEFAULT 0 NOT NULL,
	-- 권한 : 1 = 일반유저, 3 = 관리자
	authLevel number DEFAULT 1 NOT NULL,
	-- 가입일자
	regDate date DEFAULT sysdate NOT NULL,
	-- 마지막 접속일자
	lastLogin date,
	PRIMARY KEY (memberId)
);


-- 공급정보
CREATE TABLE Supply
(
	-- 공급 번호
	s_id number NOT NULL,
	-- 공급 일자
	supplyDate date DEFAULT sysdate NOT NULL,
	-- 공급량
	s_amount number NOT NULL,
	-- 상품 번호
	g_id number NOT NULL,
	-- 제조사
	c_name varchar2(50) NOT NULL,
	PRIMARY KEY (s_id)
);



/* Create Foreign Keys */

ALTER TABLE Supply
	ADD FOREIGN KEY (c_name)
	REFERENCES Company (c_name)
;


ALTER TABLE Indent
	ADD FOREIGN KEY (g_id)
	REFERENCES Goods (g_Id)
;


ALTER TABLE Supply
	ADD FOREIGN KEY (g_id)
	REFERENCES Goods (g_Id)
;


ALTER TABLE Article
	ADD FOREIGN KEY (memberId)
	REFERENCES Member (memberId)
;


ALTER TABLE Indent
	ADD FOREIGN KEY (memberId)
	REFERENCES Member (memberId)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_Article_a_id BEFORE INSERT ON Article
FOR EACH ROW
BEGIN
	SELECT SEQ_Article_a_id.nextval
	INTO :new.a_id
	FROM dual;
END;

/




/* Comments */

COMMENT ON TABLE Article IS '게시글';
COMMENT ON COLUMN Article.a_id IS '글 번호';
COMMENT ON COLUMN Article.memberId IS '작성자';
COMMENT ON COLUMN Article.title IS '제목';
COMMENT ON COLUMN Article.body IS '내용';
COMMENT ON COLUMN Article.a_fileName IS '이미지';
COMMENT ON COLUMN Article.writeDate IS '작성 일자';
COMMENT ON COLUMN Article.hitCount IS '조회수';
COMMENT ON COLUMN Article.secret IS '비밀글 : 0 = 공개글, 1 = 비밀글';
COMMENT ON COLUMN Article.type IS '글 종류 : notice = 공지사항, review = 리뷰, inquiry = 문의';
COMMENT ON TABLE Company IS '제조업체';
COMMENT ON COLUMN Company.c_name IS '제조사';
COMMENT ON COLUMN Company.corNum IS '법인번호';
COMMENT ON COLUMN Company.c_tel IS '연락처';
COMMENT ON COLUMN Company.location IS '위치';
COMMENT ON COLUMN Company.manager IS '담당자';
COMMENT ON COLUMN Company.regDate IS '등록일자';
COMMENT ON TABLE Goods IS '상품';
COMMENT ON COLUMN Goods.g_Id IS '상품 번호';
COMMENT ON COLUMN Goods.g_name IS '상품명';
COMMENT ON COLUMN Goods.g_fileName IS '이미지';
COMMENT ON COLUMN Goods.g_amount IS '재고량';
COMMENT ON COLUMN Goods.price IS '단가';
COMMENT ON COLUMN Goods.regDate IS '등록일자';
COMMENT ON TABLE Indent IS '주문';
COMMENT ON COLUMN Indent.i_id IS '주문 번호';
COMMENT ON COLUMN Indent.i_amount IS '주문 수량';
COMMENT ON COLUMN Indent.address IS '배송지';
COMMENT ON COLUMN Indent.indentDate IS '주문 일자';
COMMENT ON COLUMN Indent.totalPrice IS '총 금액';
COMMENT ON COLUMN Indent.g_id IS '상품 번호';
COMMENT ON COLUMN Indent.memberId IS '구매자';
COMMENT ON TABLE Member IS '회원';
COMMENT ON COLUMN Member.memberId IS '회원 아이디';
COMMENT ON COLUMN Member.pass IS '비밀번호';
COMMENT ON COLUMN Member.m_name IS '이름';
COMMENT ON COLUMN Member.m_tel IS '연락처';
COMMENT ON COLUMN Member.age IS '나이';
COMMENT ON COLUMN Member.job IS '직업';
COMMENT ON COLUMN Member.grade IS '회원 등급 : 총 구입금액 0~ 500,000원 미만 일반, 1,000,000미만 우수, 2,000,000미만 VIP, 2,000,000이상 VVIP';
COMMENT ON COLUMN Member.totalSpent IS '총 구입금액';
COMMENT ON COLUMN Member.point IS '적립금';
COMMENT ON COLUMN Member.authLevel IS '권한 : 1 = 일반유저, 3 = 관리자';
COMMENT ON COLUMN Member.regDate IS '가입일자';
COMMENT ON COLUMN Member.lastLogin IS '마지막 접속일자';
COMMENT ON TABLE Supply IS '공급정보';
COMMENT ON COLUMN Supply.s_id IS '공급 번호';
COMMENT ON COLUMN Supply.supplyDate IS '공급 일자';
COMMENT ON COLUMN Supply.s_amount IS '공급량';
COMMENT ON COLUMN Supply.g_id IS '상품 번호';
COMMENT ON COLUMN Supply.c_name IS '제조사';



