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
USER_ID INTEGER PRIMARY KEY,
USERNAME VARCHAR2(20),
PASSWORD VARCHAR2(20));