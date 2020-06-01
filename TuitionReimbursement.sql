CREATE USER tuition
IDENTIFIED BY reimbursement
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to tuition;
GRANT resource to tuition;
GRANT create session TO tuition;
GRANT create table TO tuition;
GRANT create view TO tuition;

conn tuition/reimbursement

CREATE TABLE AUTHENTICATION(
USERNAME VARCHAR2(20) PRIMARY KEY,
PASSWORD VARCHAR2(20),
ACCOUNT_TYPE INTEGER);

/* account types are as follows:
0=employee
1=supervisor
2=department head
3=benco
4=CEO (full admin)
*/

INSERT INTO AUTHENTICATION VALUES ('backslash', 'backslash', 0);
INSERT INTO AUTHENTICATION VALUES ('garfield', 'lasagna', 4);
INSERT INTO AUTHENTICATION VALUES ('jon', 'arbuckle', 2);
INSERT INTO AUTHENTICATION VALUES ('lyman', 'odie', 1);
INSERT INTO AUTHENTICATION VALUES ('odie', 'woof', 3);
INSERT INTO AUTHENTICATION VALUES ('nermal', 'cute', 3);

CREATE TABLE SUPERVISOR(
EMPLOYEE VARCHAR2(20) PRIMARY KEY,
SUPERVISOR VARCHAR2(20));

INSERT INTO SUPERVISOR VALUES('backslash', 'lyman');
INSERT INTO SUPERVISOR VALUES('lyman', 'jon');
INSERT INTO SUPERVISOR VALUES('nermal', 'odie');
INSERT INTO SUPERVISOR VALUES('jon', 'garfield');
INSERT INTO SUPERVISOR VALUES('odie', 'garfield');

CREATE TABLE CURRENT_DATE(
TODAY INTEGER);

INSERT INTO CURRENT_DATE VALUES(1);

CREATE TABLE REQUESTS(
REQ_ID INTEGER PRIMARY KEY,
USERNAME VARCHAR2(20),
REQ_AMT NUMBER (38,2),
PEND_STATE INTEGER,
DEADLINE INTEGER);

/*pending state cheatsheet:
-1 denied
0 to supervisor to approve
1 to department head to approve
2 to benco to approve
3 waiting on user to give proof of grade
4 to benco to approve
5 to supervisor to approve
6 paid out
*/

CREATE SEQUENCE ID_GEN
START WITH 1
INCREMENT BY 1;

INSERT INTO REQUESTS VALUES(ID_GEN.NEXTVAL, 'garfield', 80.80, 0, 18);
