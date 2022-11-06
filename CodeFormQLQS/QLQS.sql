CREATE DATABASE QuanLyQuanSu
GO
USE QuanLyQuanSu
GO
CREATE TABLE TaiKhoan(
ID int IDENTITY(1,1) NOT NULL,
TaiKhoan nvarchar(50) NOT NULL,
MatKhau nvarchar(50) NOT NULL,
MaDinhDanh nvarchar(10) NOT NULL,
VaiTro bit NOT NULL,
PRIMARY KEY(TaiKhoan),
UNIQUE(MaDinhDanh),
FOREIGN KEY (MaDinhDanh) REFERENCES QuanNhan(MaDinhDanh) ON UPDATE CASCADE
)
--Thêm dữ liệu vào bảng Tài Khoản
INSERT INTO TaiKhoan
VALUES ('admin001','123123','TV0303','1'),
('manager1','123123','QT0101','0'),
('manager2','123123','VA0305','0'),
('manager3','123123','CK0101','0'),
('manager4','123123','LD9127','0')

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
VALUES ('AO8172',N'Áo Ba Lỗ','1','01-01-2022','',''),
('DN8271',N'Dây Nịt','1','01-01-2022','',''),
('MC0192',N'Mũ Cối','1','01-01-2022','',''),
('AO8171',N'Áo Thun','1','01-01-2022','',''),
('QD817282',N'Quần Đùi','1','01-01-2022','',''),
('C91828',N'Cầu Vai','1','01-01-2022','',''),
('AO8175',N'Áo Bốn Lỗ','1','01-01-2022','',''),
('AO9287',N'Áo Năm Lỗ','2','01-01-2022','',''),
('AO8124',N'Áo Sáu Lỗ','1','01-01-2022','',''),
('AO0292',N'Áo Bảy Lỗ','5','01-01-2022','',''),
('A94717',N'Áo Tám Lỗ','2','01-01-2022','','')
CREATE TABLE NhanQuanPhuc(
MaBienNhan int IDENTITY(1,1) NOT NULL,
MaDinhDanh nvarchar(10) NOT NULL,
MaQuanPhuc nvarchar(10) NOT NULL,
UNIQUE(MaDinhDanh, MaQuanPhuc),
FOREIGN KEY (MaDinhDanh) REFERENCES QuanNhan(MaDinhDanh) ON UPDATE CASCADE,
FOREIGN KEY (MaQuanPhuc) REFERENCES QuanPhuc(MaQuanPhuc) ON DELETE CASCADE
)
CREATE TABLE SizeQuanPhuc(
ID int IDENTITY(1,1) NOT NULL,
MaDinhDanh nvarchar(10) NOT NULL,
SizeQuanPhuc int NOT NULL,
SizeGiay int NOT NULL,
SizeMu int NOT NULL,
FOREIGN KEY (MaDinhDanh) REFERENCES QuanNhan(MaDinhDanh) ON DELETE CASCADE
)
--Thêm dữ liệu vào bảng Size Quân Phục
INSERT INTO SizeQuanPhuc
VALUES ('TV0303','35','42','40'),
('CK0101','35','42','40'),
('KC0182','35','42','40'),
('MC0101','35','42','40'),
('VA0305','35','42','40'),
('YN0101','35','42','40'),
('KU8287','35','42','40')
CREATE TABLE VuTrang(MaVuTrang nvarchar(10) NOT NULL,TenVuTrang nvarchar(50) NOT NULL,MoTa nvarchar(500),UNIQUE(TenVuTrang),PRIMARY KEY(MaVuTrang))--Thêm dữ liệu vào bảng Vũ TrangINSERT INTO VuTrangVALUES('AK81727',N'Súng ngắn',N'Súng ngắn là một súng cầm tay có thể được giữ và sử dụng bằng một tay. Hai loại súng ngắn phổ biến nhất được sử dụng hiện nay là súng ngắn ổ quay và súng ngắn bán tự động (semi-auto).'),('CKC9182',N'Súng trường',N'Súng trường (tiếng Anh: Rifle) là một loại súng cá nhân gọn nhẹ với nòng súng được chuốt rãnh xoắn,có báng súng và ốp lót tay hoàn chỉnh để phục vụ mục đích bắn điểm xạ'),('TL8626',N'Súng tiểu liên',N'Súng tiểu liên là loại vũ khí cá nhân tầm gần, thuộc họ súng máy, cũng thuộc họ súngtự động tùy theo phân loại của các quốc gia.'),('SBT7162',N'Súng bắn tỉa',N'Súng bắn tỉa (còn gọi là súng ngắm) là một loại súng trường chuyên dụng cho công việc bắn các mục tiêu ở khoảng cách xa với độ chính xác cao hơn bất kỳ loại súng cầm tay nào khác.')CREATE PROC sp_ThongKeQuanNhan
AS BEGIN
SELECT
YEAR(NhapNgu) Nam,
DonVi,
COUNT(*) SoLuong
FROM QuanNhan
GROUP BY YEAR(NhapNgu),DonVi
END

CREATE PROC sp_ThongKeDoanhThu(@Year INT)
AS BEGIN
SELECT
TenCD ChuyenDe,
COUNT(DISTINCT kh.MaKH) SoKH,
COUNT(hv.MaHV) SoHV,
SUM(kh.HocPhi) DoanhThu,
MIN(kh.HocPhi) ThapNhat,
MAX(kh.HocPhi) CaoNhat,
AVG(kh.HocPhi) TrungBinh
FROM KhoaHoc kh
JOIN HocVien hv ON kh.MaKH=hv.MaKH
JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
WHERE YEAR(NgayKG) = @Year
GROUP BY TenCD
END

CREATE PROC sp_ThongKeDiem
AS BEGIN
SELECT
TenCD ChuyenDe,
COUNT(MaHV) SoHV,
MIN(Diem) ThapNhat,
MAX(Diem) CaoNhat,
AVG(Diem) TrungBinh
FROM KhoaHoc kh
JOIN HocVien hv ON kh.MaKH=hv.MaKH
JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
GROUP BY TenCD
END

CREATE PROC sp_BangDiem(@MaKH INT)
AS BEGIN
SELECT
nh.MaNH,
nh.HoTen,
hv.Diem
FROM HocVien hv
JOIN NguoiHoc nh ON nh.MaNH=hv.MaNH
WHERE hv.MaKH = @MaKH
ORDER BY hv.Diem DESC
END
