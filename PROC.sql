--Thống kê số lượng quân phục đã cấp
	SELECT
	QuanPhucDaiDoi.MaQuanPhuc,
	SUM(QuanPhucDaiDoi.SoLuong) AS SoLuongPhat
	FROM QuanPhucDaiDoi INNER JOIN QuanPhuc 
	ON QuanPhucDaiDoi.MaQuanPhuc = QuanPhuc.MaQuanPhuc
	GROUP BY QuanPhucDaiDoi.MaQuanPhuc,QuanPhuc.TenQuanPhuc
--Thống kê số lượng quân phục nhập vào
	SELECT
	QuanPhucDaiDoi.MaQuanPhuc,
	SUM(QuanPhucDaiDoi.SoLuong) AS SoLuongPhat
	FROM QuanPhucDaiDoi INNER JOIN QuanPhuc 
	ON QuanPhucDaiDoi.MaQuanPhuc = QuanPhuc.MaQuanPhuc
	GROUP BY QuanPhucDaiDoi.MaQuanPhuc,QuanPhuc.TenQuanPhuc
--Thống kê còn lại
	SELECT 
	QuanPhuc.MaQuanPhuc,
	SUM(NhapQuanPhuc.SoLuong)AS SoLuong
	FROM NhapQuanPhuc FULL OUTER JOIN QuanPhuc
	ON NhapQuanPhuc.MaQuanPhuc = QuanPhuc.MaQuanPhuc
	FULL OUTER JOIN QuanPhucDaiDoi
	ON QuanPhucDaiDoi.MaQuanPhuc = QuanPhuc.MaQuanPhuc
	WHERE NhapQuanPhuc.MaQuanPhuc = QuanPhucDaiDoi.MaQuanPhuc
	GROUP BY QuanPhuc.MaQuanPhuc,QuanPhuc.TenQuanPhuc


	