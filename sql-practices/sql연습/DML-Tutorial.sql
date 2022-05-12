-- Basic Query
select version(), current_date;
--  ��ҹ� ������ ����.
SELECT VERSION(), CURRENT_DATE;
select vErSion(), current_DATE;
-- �����Լ�
select sin(pi()/4), (4+1)*5;

-- ���̺� ����
drop table pet;

-- ���̺� ����
create table pet(
	name varchar(20),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth date,
    death date
);

-- schema Ȯ��
desc pet;

-- ������ �ֱ�(����, Create)
insert into pet values('��ź��', '�ȴ���', 'dog', 'm', '2018-12-25', null); 

-- ������ �˻�(�б�, Read)
select name, owner, species, gender, birth, death from pet;

-- ������ ����(����, Delete)
delete from pet where name = '��ź��';

-- load data local infile 
load data local infile 'd:\\pet.txt' into table pet;

--- ������ ����(����, Update)
update pet set death=null where name != 'Bowser';

-- ��ȸ(�˻�) ����1: where

-- 1990�� ���Ŀ� �¾ ���̵���?
select name, species, birth
  from pet
 where birth >= '1991-01-01'; 

-- Gwen�� ���� ��� ���̵���?
select name, species, owner
  from pet
 where owner = 'Gwen';
 
-- null �ٷ�� 1: ��� �ִ� �ֵ���?
select name, species, death
  from pet
 where death is null; 

-- null �ٷ�� 2: ���� �ֵ���?
select name, species, death
  from pet
 where death is not null; 

-- like �˻�1(���� ��Ī) : �̸��� b�� �����ϴ� ���̵���?
select name, species
  from pet
 where name like 'b%'; 

-- like �˻�2(���� ��Ī) : �̸��� b�� �����ϴ� ���̵��߿� �̸��� 6���� ���̴�?
select name, species
  from pet
 where name like 'B_____';

-- ����(���) �Լ�
select count(*) from pet;

select count(death) from pet;
select count(*) from pet where death is not null;

-- ����: order by
-- ���̰� ���� � ���� ������ �̸�, ��, ���Ϸ� ��� �ϼ���.
  select name, species, birth
    from pet
order by birth desc, name asc; 