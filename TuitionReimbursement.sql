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
