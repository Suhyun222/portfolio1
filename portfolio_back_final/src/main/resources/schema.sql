-- Table , 시퀀스 등 구조 정의
DROP SEQUENCE SQ_LIFE;
CREATE SEQUENCE SQ_LIFE START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SQ_LOVE;
CREATE SEQUENCE SQ_LOVE START WITH 1 INCREMENT BY 1;

DROP TABLE TB_LIFE CASCADE CONSTRAINT;
DROP TABLE TB_LOVE CASCADE CONSTRAINT;

CREATE TABLE TB_LIFE
(
    HNO         NUMBER NOT NULL PRIMARY KEY,
    LIFE_SENTENCE     VARCHAR2(255),
    LIFE_WRITER       VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

CREATE TABLE TB_LOVE
(
    LNO         NUMBER NOT NULL PRIMARY KEY,
    LOVE_SENTENCE     VARCHAR2(255),
    LOVE_WRITER       VARCHAR2(255),
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);


