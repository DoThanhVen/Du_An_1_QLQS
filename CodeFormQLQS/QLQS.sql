CREATE DATABASE QuanLyQuanSu
GO
USE QuanLyQuanSu
GO
CREATE TABLE TaiKhoan(
ID int IDENTITY(1,1) NOT NULL,
TaiKhoan nvarchar(50) NOT NULL,
MatKhau nvarchar(50) NOT NULL,
VaiTro bit NOT NULL,
PRIMARY KEY(TaiKhoan)
)
--Thêm dữ liệu vào bảng Tài Khoản
INSERT INTO TaiKhoan
VALUES ('admin001','123123','1'),
('manager1','123123','0'),
('manager2','123123','0'),
('manager3','123123','0'),
('manager4','123123','0')

CREATE TABLE QuanNhan(
ID int IDENTITY(1,1) NOT NULL,
MaDinhDanh nvarchar(10) NOT NULL,
HoTen nvarchar(50) NOT NULL,
ChucVu nvarchar(50) NOT NULL,
DonVi nvarchar(50) NOT NULL,
NhapNgu date NOT NULL,
GioiTinh bit NOT NULL,
NgaySinh date NOT NULL,
HinhAnh nvarchar(500) NULL,
PRIMARY KEY(MaDinhDanh)
)
GO
--Thêm dữ liệu vào bảng Quân Nhân
INSERT INTO QuanNhan
VALUES('TV0303',N'Đỗ Thanh Vẹn',N'Đại Tướng',N'Đại Đội 1','01-01-2022','1','03-03-2003',''),
('YN0101',N'Nguyễn Yến Nương',N'Đại Tá',N'Đại Đội 5','01-01-2022','0','03-03-2003',''),
('QT0101',N'Nguyễn Quốc Thái',N'Đại Tá',N'Đại Đội 6','01-01-2022','1','03-03-2003',''),
('CK0101',N'Nguyễn Chí Khang',N'Binh Nhì',N'Đại Đội 1','01-01-2022','1','03-03-2003',''),
('VL0101',N'Nguyễn Văn Lợi',N'Binh Nhất',N'Đại Đội 1','01-01-2022','1','03-03-2003',''),
('MC0101',N'Trần Mộng Cơ',N'Đại Tá',N'Đại Đội 2','01-01-2022','0','03-03-2003',''),
('QT0201',N'Trần Quốc Toản',N'Đại Tá',N'Đại Đội 2','01-01-2022','1','03-03-2003',''),
('KC0303',N'Nguyễn Kim Cương',N'Đại Tá',N'Đại Đội 2','01-01-2022','0','03-03-2003',''),
('VA0305',N'Nguyễn Văn An',N'Đại Tá',N'Đại Đội 1','01-01-2022','1','03-03-2003',''),
('KC0182',N'Nguyễn Kiên Cường',N'Đại Tá',N'Đại Đội 5','01-01-2022','1','03-03-2003',''),
('KU8287',N'Phạm Thị Kiều Uyên',N'Thiếu Tá',N'Đại Đội 1','01-01-2022','0','03-03-2003',''),
('LD9127',N'Trần Lam Duyên',N'Binh Nhì',N'Đại Đội 1','01-01-2022','0','03-03-2003','')
CREATE TABLE QuanPhuc(
MaQuanPhuc nvarchar(10) NOT NULL,
TenQuanPhuc nvarchar(50) NOT NULL,
ThoiGianCap int NOT NULL,
NgayTao date NOT NULL DEFAULT getDate(),
NgayChinhSua date NOT NULL,
HinhAnh nvarchar(500) NULL,
PRIMARY KEY(MaQuanPhuc),
UNIQUE(TenQuanPhuc)
)
GO
--Thêm dữ liệu vào bảng Quân Phục
INSERT INTO QuanPhuc
VALUES ('AO82',N'Quân Phục Nam','1','01-01-2022','',''),
('AO81',N'Quân Phục Nữ','1','01-01-2022','',''),
('AO8172',N'Quần Lót','1','01-01-2022','',''),
('DN8271',N'Áo Lót','1','01-01-2022','',''),
('MC0192',N'Khăn Mặt','1','01-01-2022','',''),
('AO8171',N'Bít Tất','1','01-01-2022','',''),
('QD817282',N'Giày Vải','1','01-01-2022','',''),
('C91828',N'Dép Nhựa','1','01-01-2022','',''),
('AO8175',N'Chiếu Cói','1','01-01-2022','',''),
('AO9287',N'Mũ Cứng','2','01-01-2022','',''),
('AO8124',N'Mũ Kê Pi Chiến Sĩ','1','01-01-2022','',''),
('AO0292',N'Mũ Mềm Dã Chiến','5','01-01-2022','',''),
('A9472',N'Ba Lô + Túi Lót','2','01-01-2022','',''),
('A9477',N'Vỏ Chăn Cá Nhân','2','01-01-2022','',''),
('A94715',N'Màn Tuyn','2','01-01-2022','',''),
('A94123',N'Gối Cá Nhân','2','01-01-2022','',''),
('A94727',N'Dây Lưng Nhỏ','2','01-01-2022','','')
CREATE TABLE NhanQuanPhuc(
MaBienNhan int IDENTITY(1,1) NOT NULL,
MaDinhDanh nvarchar(10) NOT NULL,
MaQuanPhuc nvarchar(10) NOT NULL,
NgayNhan date NOT NULL DEFAULT getDate(),
NgayCapTiep date NULL,
UNIQUE(MaDinhDanh, MaQuanPhuc),
FOREIGN KEY (MaDinhDanh) REFERENCES QuanNhan(MaDinhDanh) ON UPDATE CASCADE,
FOREIGN KEY (MaQuanPhuc) REFERENCES QuanPhuc(MaQuanPhuc) ON DELETE CASCADE
)
CREATE TABLE SizeQuanPhuc(
ID int IDENTITY(1,1) NOT NULL,
MaDinhDanh nvarchar(10) NOT NULL,
SizeQuanPhuc nvarchar(10) NOT NULL,
SizeGiay float NOT NULL,
SizeMu float NOT NULL
)
--Thêm dữ liệu vào bảng Size Quân Phục
INSERT INTO SizeQuanPhuc
VALUES ('TV0303','S','42','40'),
('CK0101','XL','42','40'),
('KC0182','L','42','40'),
('MC0101','M','42','40'),
('VA0305','XL','42','40'),
('YN0101','XL','42','40'),
('KU8287','S','42','40')
CREATE TABLE VuTrang(MaVuTrang nvarchar(10) NOT NULL,TenVuTrang nvarchar(50) NOT NULL,MoTa nvarchar(500),UNIQUE(TenVuTrang),PRIMARY KEY(MaVuTrang))--Thêm dữ liệu vào bảng Vũ TrangINSERT INTO VuTrangVALUES('AK81727',N'Súng ngắn',N'Súng ngắn là một súng cầm tay có thể được giữ và sử dụng bằng một tay. Hai loại súng ngắn phổ biến nhất được sử dụng hiện nay là súng ngắn ổ quay và súng ngắn bán tự động (semi-auto).'),('CKC9182',N'Súng trường',N'Súng trường (tiếng Anh: Rifle) là một loại súng cá nhân gọn nhẹ với nòng súng được chuốt rãnh xoắn,có báng súng và ốp lót tay hoàn chỉnh để phục vụ mục đích bắn điểm xạ'),('TL8626',N'Súng tiểu liên',N'Súng tiểu liên là loại vũ khí cá nhân tầm gần, thuộc họ súng máy, cũng thuộc họ súngtự động tùy theo phân loại của các quốc gia.'),('SBT7162',N'Súng bắn tỉa',N'Súng bắn tỉa (còn gọi là súng ngắm) là một loại súng trường chuyên dụng cho công việc bắn các mục tiêu ở khoảng cách xa với độ chính xác cao hơn bất kỳ loại súng cầm tay nào khác.')--Thống kê số lượng quân nhân theo nămCREATE PROC sp_ThongKeQuanNhan
AS BEGIN
SELECT
YEAR(NhapNgu) Nam,
DonVi,
COUNT(*) SoLuong
FROM QuanNhan
GROUP BY YEAR(NhapNgu),DonVi
END
--Thống kê số lượng quân phục đã phát
CREATE PROC sp_ThongKeQuanPhucDaPhat
AS BEGIN
SELECT
NhanQuanPhuc.MaQuanPhuc,
QuanPhuc.TenQuanPhuc,
COUNT(*) SoLuong
FROM NhanQuanPhuc INNER JOIN QuanPhuc
ON NhanQuanPhuc.MaQuanPhuc = QuanPhuc.MaQuanPhuc
GROUP BY NhanQuanPhuc.MaQuanPhuc,QuanPhuc.TenQuanPhuc
END
