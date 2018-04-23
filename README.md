# mini-home
oracle, java, jsp


query


create user mini identified by mini;
grant connect, resource, create view to mini;


--테이블 셋팅 쿼리문

-- member 테이블 생성
create table member(
    member_no number(30) primary key,
    id varchar2(30) not null,
    pw varchar2(50) not null,
    name varchar2(30) not null,
    birth varchar2(10) not null,
    reg_date date default sysdate
);

-- member_no 시퀀스 생성
create sequence member_no_sq;

-- category_group 테이블 생성
create table category_group(
    category_group_no number(30) primary key,
    name varchar2(30) not null
);

-- category_group_no 시퀀스 생성
create sequence category_group_no_sq;

-- category 테이블 생성
create table category(
    category_no number(30) primary key,
    category_group_no number(30) not null,
    name varchar2(30) not null,
     homepage_no number(30) not null
);

-- category_no 시퀀스 생성
create sequence category_no_sq;

-- homepage 테이블 생성
create table homepage(
    homepage_no number(30) primary key,
    id varchar2(30) not null, 
    bgm varchar2(1000) null,
    profile varchar2(1000) null,
    background_img varchar2(1000) null,
    introduce varchar2(1000) default '소개글을 입력하세요.',
    title varchar2(200) not null,
    visits number(30) default 0, 
    open_range varchar2(10) default 'PUBLIC',
    photo_gallary_use_yn char(2) default 'Y',    
    guest_book_use_yn char(2) default 'Y',
    diary_use_yn char(2) default 'Y',
    file_gallary_use_yn char(2) default 'Y'
);

-- homepage_no 시퀀스 생성
create sequence homepage_no_sq;


-- board 테이블 생성
create table board(
    no number(30) primary key,
    homepage_no number(30) not null,
    category_no number(30) not null,
    title varchar2(200) not null,
    writer varchar2(30) not null,
    content varchar2(4000) not null,
    reg_date date default sysdate,
    update_date date default sysdate,
    secret char(1) default 'F'
);

-- no 시퀀스 생성
create sequence no_sq;

-- board_comment 테이블 생성
create table board_comment(
    comment_no number(30) primary key,
    no number(30) not null,
    writer varchar(30) not null,
    content varchar(4000) not null,
    reg_date date default sysdate,
    update_date date default sysdate
);

-- comment_no 시퀀스 생성
create sequence comment_no_sq;

-- board_file 테이블 생성
create table board_file(
    file_no number(30) primary key,
    no number(30) not null,
    file_path varchar(1000) not null,
    ori_name varchar(200) not null,
    system_name varchar(200) not null,
    file_size number(30) not null
);

-- file_no 시퀀스 생성
create sequence file_no_sq;


-- friend 테이블 생성
create table friend(
    member_id varchar2(30) not null,
    friend_member_id varchar2(30) not null,
    status varchar2(10) default 'WAIT'
);


-- msg 테이블
create table msg(
    msg_no number(30) primary key,
    send_id varchar2(30) not null,
    rec_id varchar2(30) not null,
    content varchar2(2000) not null,
    send_date date default sysdate,
    is_read char(2) default 'F',
    rec_delete char(2) default 'F',
    send_delete char(2) default 'F'
);

-- msg_no 시퀀스
create sequence msg_no_sq;


-- vote like 테이블 생성
create table vote_like(
    member_no number(30) not null,
    no number(30) not null
);
-- vote hate 테이블 생성
create table vote_hate(
    member_no number(30) not null,
    no number(30) not null
);
