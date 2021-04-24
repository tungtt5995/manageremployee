Drop database Personel
create database Personel

go
use Personel
go
create table Users(
	Username nvarchar(50) primary key not null,
	Password nvarchar(50) not null, 
	Fullname nvarchar(50) not null,  
)
create table Departs(
	Id nvarchar(10) primary key not null,
	Name nvarchar(50) not null
)
create table Staffs(
Id nvarchar(10) primary key not null,
Name nvarchar(50) not null, 
Gender bit not null,
Birthday date not null,
Photo nvarchar(50) not null, 
Email nvarchar(50) not null, 
Phone nvarchar(25) not null, 
Salary float not null, 
Notes nvarchar(500) null, 
DepartId nvarchar(10) not null foreign key references Departs(Id)
)
create table Records(
Id int identity(1,1) not null primary key,
Type bit not null,
Reason nvarchar(200) not null,
Date date not null,
StaffId nvarchar(10) not null foreign key references Staffs(Id)
)
/*User*/
insert into Users values(N'van123',N'van123',N'Nguyễn Hữu Vân')

insert into Users values(N'long123',N'long123',N'Nguyễn Hữu Long')

insert into Users values(N'dung123',N'dung123',N'Nguyễn Văn Dũng')

/*Departs*/
insert into Departs values('P01','Kế Toán')
insert into Departs values('P02','Kinh Doanh')
insert into Departs values('P03','IT')
insert into Departs values('P04','QHDN')
insert into Departs values('P05','Marketting')
/*Staff*/
insert into Staffs values('NV001',N'Tungtt','true','08/12/2000','tung1.jpg','teonv@gmail.com','0969145287','5000000',N'tính toán tốt','P01')
insert into Staffs values('NV002',N'HieuVM','true','09/20/2000','tung.jpg','teonv@gmail.com','0969145287','5000000',N'giao tiếp tốt','P02')
insert into Staffs values('NV003',N'NinhLx','true','09/20/2000','tung.jpg','teonv@gmail.com','0969145287','5000000',N'giao tiếp tốt','P02')
/*Records*/
insert into Records values('true',N'số lượng tính toán luôn đúng','10/1/2020','NV001')
insert into Records values('false',N'đi làm muộn','10/1/2020','NV001')
insert into Records values('true',N'sáng tạo sản phẩm','10/1/2020','NV002')
insert into Records values('false',N'hút thuốc','10/1/2020','NV001')
insert into Records values('true',N'ký hợp đồng','10/1/2020','NV001')

select * from Users
select * from Departs
select * from Staffs
select * from Records

SELECT r.StaffId,
	SUM(case when Type=1 then 1 else 0 end), 
	SUM(case when Type=0 then 1 else 0 end)
	 FROM Records  r 
	GROUP BY r.StaffId
