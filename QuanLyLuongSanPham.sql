USE [master]
GO
/****** Object:  Database [QuanLyLuongSP]    Script Date: 15/12/2023 1:28:19 PM ******/
CREATE DATABASE [QuanLyLuongSP]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyLuongSP', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyLuongSP.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyLuongSP_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyLuongSP_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyLuongSP] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyLuongSP].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyLuongSP] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyLuongSP] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyLuongSP] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyLuongSP] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyLuongSP] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyLuongSP] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyLuongSP] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyLuongSP] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyLuongSP] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyLuongSP] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyLuongSP] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyLuongSP] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyLuongSP] SET QUERY_STORE = OFF
GO
USE [QuanLyLuongSP]
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDCNV]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--CongNhanVien
CREATE FUNCTION [dbo].[AUTO_IDCNV]()
RETURNS VARCHAR(9)
AS
BEGIN
    DECLARE @ID VARCHAR(9)
    DECLARE @MaxID INT
    SELECT @MaxID = MAX(CAST(RIGHT(maCongNhanVien, 6) AS INT))
    FROM CongNhanVien
    IF @MaxID IS NULL
        SET @ID = 'CNV000001'
    ELSE
        SET @ID = 'CNV' + RIGHT('000000' + CAST(@MaxID + 1 AS VARCHAR(6)), 6)

    RETURN @ID
END;
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDNV]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDNV]()
RETURNS VARCHAR(5)
AS
BEGIN
    DECLARE @ID VARCHAR(5)
    DECLARE @MaxID INT
    
    -- Tìm giá trị lớn nhất trong cột maNhanVien
    SELECT @MaxID = MAX(CAST(SUBSTRING(maNhanVien, 3, 3) AS INT))
    FROM NhanVien

    -- Tạo mã mới
    IF @MaxID IS NULL
        SET @ID = 'NV001'
    ELSE
        SET @ID = 'NV' + RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3)

    RETURN @ID
END;
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDPB]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDPB]()
RETURNS VARCHAR(5)
AS
BEGIN
    DECLARE @ID VARCHAR(5)
    DECLARE @MaxID INT

    -- Tìm giá trị lớn nhất hiện có trong cột maPhongBan
    SELECT @MaxID = ISNULL(MAX(CAST(SUBSTRING(maPhongBan, 3, 3) AS INT)), 0) + 1 from PhongBan
    -- Format giá trị để có độ dài 3 ký tự và thêm 'PB' vào trước
    SET @ID = 'PB' + RIGHT('000' + CAST(@MaxID AS VARCHAR(3)), 3)

    RETURN @ID
END;

GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDSP]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDSP]()
RETURNS VARCHAR(5)
AS
BEGIN
    DECLARE @ID VARCHAR(5)
    DECLARE @MaxID INT
    
    -- Tìm giá trị lớn nhất trong cột maSanPham
    SELECT @MaxID = MAX(CAST(SUBSTRING(maSanPham, 3, 3) AS INT))
    FROM Dan

    -- Tạo mã mới
    IF @MaxID IS NULL
        SET @ID = 'SP001'
    ELSE
        SET @ID = 'SP' + RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3)

    RETURN @ID
END;
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDTLD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDTLD]()
RETURNS VARCHAR(6)
AS
BEGIN
    DECLARE @ID VARCHAR(6)
    DECLARE @MaxID INT
    
    -- Tìm giá trị lớn nhất trong cột maThoLamDan
    SELECT @MaxID = MAX(CAST(SUBSTRING(maThoLamDan, 4, 3) AS INT))
    FROM ThoLamDan

    -- Tạo mã mới
    IF @MaxID IS NULL
        SET @ID = 'TLD001'
    ELSE
        SET @ID = 'TLD' + RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3)

    RETURN @ID
END;
GO
/****** Object:  UserDefinedFunction [dbo].[generate_IDBCCNV]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[generate_IDBCCNV] (@maNhanVien VARCHAR(5), @ngay DATE)
RETURNS VARCHAR(16)
AS
BEGIN
    DECLARE @ID VARCHAR(16)
    DECLARE @MaxID INT

    DECLARE @NumericPart VARCHAR(3) = RIGHT(@maNhanVien, 3)

    SET @ID = 'BCCNV' + @NumericPart + FORMAT(@ngay, 'yyyyMMdd') 

    RETURN @ID
END;

GO
/****** Object:  UserDefinedFunction [dbo].[generate_IDBCCTLD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--BangChamCongThoLamDan
CREATE FUNCTION [dbo].[generate_IDBCCTLD] (@maThoLamDan VARCHAR(6), @ngay DATE)
RETURNS VARCHAR(17)
AS
BEGIN
    DECLARE @ID VARCHAR(17)
    DECLARE @MaxID INT

    -- Extract the numeric part of maThoLamDan (removing 'TLD')
    DECLARE @NumericPart VARCHAR(3) = RIGHT(@maThoLamDan, 3)

    SET @ID = 'BCCTLD' + @NumericPart + FORMAT(@ngay, 'yyyyMMdd') 

    RETURN @ID
END;
GO
/****** Object:  UserDefinedFunction [dbo].[generate_IDCD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[generate_IDCD](@maSanPham VARCHAR(5))
RETURNS VARCHAR(10)
AS
BEGIN
    DECLARE @ID VARCHAR(10)
    DECLARE @MaxID INT

    -- Tìm giá trị lớn nhất trong cột maCongDoan dựa trên mã sản phẩm
    SELECT @MaxID = MAX(CAST(SUBSTRING(maCongDoan, 8, 3) AS INT))
    FROM CongDoan
    WHERE maSanPham = @maSanPham AND ISNUMERIC(SUBSTRING(maCongDoan, 8, 3)) = 1

    -- Tạo mã mới dựa trên mã sản phẩm và số thứ tự trong mã công đoạn
    IF @MaxID IS NULL
        SET @ID = @maSanPham + 'CD001'
    ELSE
        SET @ID = @maSanPham + 'CD' + RIGHT('00' + CAST(@MaxID + 1 AS VARCHAR(3)), 3)

    RETURN @ID
END;


GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaBangLuongNV]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[GenerateMaBangLuongNV](@thang INT, @nam INT, @maNhanVien VARCHAR(5))
RETURNS VARCHAR(13)
AS
BEGIN
    DECLARE @maBangLuong VARCHAR(13)
    DECLARE @thangStr VARCHAR(2)
    DECLARE @namStr VARCHAR(4)
    
    SET @thangStr = RIGHT('0' + CONVERT(VARCHAR(2), @thang), 2)
    SET @namStr = RIGHT('000' + CONVERT(VARCHAR(4), @nam), 4)

    -- Remove the 'NV' prefix from @maNhanVien
    SET @maNhanVien = SUBSTRING(@maNhanVien, 3, 5)

    SET @maBangLuong = 'BLNV' + @maNhanVien + @thangStr + @namStr

    RETURN @maBangLuong
END;
GO
/****** Object:  UserDefinedFunction [dbo].[GenerateMaBangLuongTLD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[GenerateMaBangLuongTLD](@maTLD VARCHAR(6), @thang INT, @nam INT)
RETURNS VARCHAR(14)
AS
BEGIN
    DECLARE @maBangLuong VARCHAR(14)
    DECLARE @thangStr VARCHAR(2)
    DECLARE @namStr VARCHAR(4)
    
    SET @thangStr = RIGHT('0' + CONVERT(VARCHAR(2), @thang), 2)
    SET @namStr = RIGHT('000' + CONVERT(VARCHAR(4), @nam), 4)
	SET @maTLD = SUBSTRING(@maTLD, 4, 6)
    SET @maBangLuong = 'BLTLD' + @maTLD + @thangStr + @namStr

    RETURN @maBangLuong
END;
GO
/****** Object:  UserDefinedFunction [dbo].[tinhHeSoLuongTLD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create FUNCTION [dbo].[tinhHeSoLuongTLD](@tayNghe VARCHAR(255)) RETURNS FLOAT
AS
BEGIN
    DECLARE @trinhDo NVARCHAR(255) = @tayNghe;
    DECLARE @trinhDoOptions TABLE (trinhDo NVARCHAR(255), heSo FLOAT);
    INSERT INTO @trinhDoOptions VALUES ('Bậc 1', 1.0), ('Bậc 2', 1.2), ('Bậc 3', 1.4), ('Bậc 4', 1.6), ('Bậc 5', 1.8);

    DECLARE @heSoLuong FLOAT = COALESCE((SELECT heSo FROM @trinhDoOptions WHERE trinhDo = @trinhDo), 1.0);

    RETURN @heSoLuong;
END;

GO
/****** Object:  UserDefinedFunction [dbo].[tinhPhuCapThamNienTLD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[tinhPhuCapThamNienTLD](@ngayVaoLam DATE, @heSo FLOAT) RETURNS FLOAT
AS
BEGIN
    DECLARE @ngayVaoLamLocal DATE = @ngayVaoLam;
    DECLARE @ngayHienTai DATE = GETDATE();
    DECLARE @soNamLamViec INT = DATEDIFF(YEAR, @ngayVaoLamLocal, @ngayHienTai);
    DECLARE @tyLePhuCap FLOAT;

    IF @soNamLamViec >= 5 AND @soNamLamViec < 10
        SET @tyLePhuCap = 5.0;
    ELSE IF @soNamLamViec >= 10 AND @soNamLamViec < 15
        SET @tyLePhuCap = 10.0;
    ELSE IF @soNamLamViec >= 15 AND @soNamLamViec < 20
        SET @tyLePhuCap = 15.0;
    ELSE IF @soNamLamViec >= 20
        SET @tyLePhuCap = 20.0;
    ELSE
        SET @tyLePhuCap = 0.0;

    DECLARE @phuCapThamNien FLOAT = 3000000 * @heSo * (@tyLePhuCap / 100);

    RETURN @phuCapThamNien;
END;
GO
/****** Object:  Table [dbo].[BangChamCongNhanVien]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangChamCongNhanVien](
	[maBCCNhanVien] [varchar](16) NOT NULL,
	[maNhanVien] [varchar](5) NOT NULL,
	[ngayChamCong] [date] NULL,
	[trangThaiDiLam] [nvarchar](50) NULL,
	[soGioTangCa] [int] NULL,
	[maBangLuong] [varchar](13) NULL,
PRIMARY KEY CLUSTERED 
(
	[maBCCNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangChamCongThoLamDan]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangChamCongThoLamDan](
	[maBCCThoLamDan] [varchar](17) NOT NULL,
	[soLuongSanPham] [int] NULL,
	[ngayChamCong] [date] NOT NULL,
	[maBangLuong] [varchar](14) NULL,
	[maThoLamDan] [varchar](6) NULL,
	[maCongDoan] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maBCCThoLamDan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangLuongNhanVien]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuongNhanVien](
	[maBangLuong] [varchar](13) NOT NULL,
	[thang] [int] NULL,
	[nam] [int] NULL,
	[maNhanVien] [varchar](5) NOT NULL,
	[soNgayThuongDiLam] [float] NULL,
	[soGioTangCaNgayThuong] [int] NULL,
	[soNgayLamChuNhat] [float] NULL,
	[soGioTangCaChuNhat] [int] NULL,
	[soNgayNghiKhongPhep] [int] NULL,
	[soNgayNghiCoPhep] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangLuongThoLamDan]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuongThoLamDan](
	[maBangLuong] [varchar](14) NOT NULL,
	[maThoLamDan] [varchar](6) NULL,
	[thang] [int] NULL,
	[nam] [int] NULL,
	[soLuong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangPhanCong]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangPhanCong](
	[maThoLamDan] [varchar](6) NOT NULL,
	[maCongDoan] [varchar](10) NOT NULL,
	[ngayPhanCong] [date] NOT NULL,
	[soLuongSanPham] [int] NULL,
 CONSTRAINT [pk_BangPhanCong] PRIMARY KEY CLUSTERED 
(
	[maThoLamDan] ASC,
	[maCongDoan] ASC,
	[ngayPhanCong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongDoan]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongDoan](
	[maCongDoan] [varchar](10) NOT NULL,
	[tenCongDoan] [nvarchar](255) NOT NULL,
	[maSanPham] [varchar](5) NULL,
	[giaCongDoan] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maCongDoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongNhanVien]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongNhanVien](
	[maCongNhanVien] [varchar](9) NOT NULL,
	[hoTen] [nvarchar](255) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[ngaySinh] [date] NULL,
	[maCanCuocCongDan] [varchar](12) NULL,
	[soDienThoai] [varchar](10) NULL,
	[diaChi] [nvarchar](255) NULL,
	[trangThai] [bit] NOT NULL,
	[ngayVaoLam] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maCongNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Dan]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dan](
	[maSanPham] [varchar](5) NOT NULL,
	[tenSanPham] [nvarchar](255) NOT NULL,
	[loaiSanPham] [nvarchar](20) NULL,
	[moTa] [nvarchar](255) NOT NULL,
	[giaBan] [float] NULL,
	[matDan] [nvarchar](255) NULL,
	[eoLung] [nvarchar](255) NULL,
	[can] [nvarchar](255) NULL,
	[matPhim] [nvarchar](255) NULL,
	[day] [nvarchar](255) NULL,
	[khoa] [nvarchar](255) NULL,
	[cauNgua] [nvarchar](255) NULL,
	[trangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [varchar](5) NOT NULL,
	[chucVu] [nvarchar](50) NULL,
	[trinhDoVanHoa] [nvarchar](20) NULL,
	[luongCoBan] [float] NULL,
	[maPhongBan] [varchar](5) NULL,
	[maCongNhanVien] [varchar](9) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongBan]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongBan](
	[maPhongBan] [varchar](5) NOT NULL,
	[tenPhongBan] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhongBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[taiKhoan] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
	[maNhanVien] [varchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[taiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThoLamDan]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThoLamDan](
	[maThoLamDan] [varchar](6) NOT NULL,
	[tayNghe] [nvarchar](20) NULL,
	[maCongNhanVien] [varchar](9) NULL,
PRIMARY KEY CLUSTERED 
(
	[maThoLamDan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231107', N'NV001', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231108', N'NV001', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231109', N'NV001', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231110', N'NV001', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231112', N'NV001', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231113', N'NV001', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231127', N'NV001', CAST(N'2023-11-27' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231201', N'NV001', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231202', N'NV001', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231209', N'NV001', CAST(N'2023-12-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231210', N'NV001', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00120231212', N'NV001', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV001122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231107', N'NV002', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231108', N'NV002', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 2, N'BLNV002112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231109', N'NV002', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231110', N'NV002', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231112', N'NV002', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231113', N'NV002', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231201', N'NV002', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231202', N'NV002', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231210', N'NV002', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00220231212', N'NV002', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV002122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231106', N'NV003', CAST(N'2023-11-06' AS Date), N'Làm nguyên ngày công', 1, N'BLNV003112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231107', N'NV003', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 1, N'BLNV003112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231108', N'NV003', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231109', N'NV003', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231110', N'NV003', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231112', N'NV003', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231113', N'NV003', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231127', N'NV003', CAST(N'2023-11-27' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231201', N'NV003', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231202', N'NV003', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231210', N'NV003', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00320231212', N'NV003', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV003122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231107', N'NV004', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231108', N'NV004', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 1, N'BLNV004112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231109', N'NV004', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231110', N'NV004', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231112', N'NV004', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231113', N'NV004', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231114', N'NV004', CAST(N'2023-11-14' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231201', N'NV004', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231202', N'NV004', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231210', N'NV004', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00420231212', N'NV004', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV004122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231107', N'NV005', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231108', N'NV005', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231109', N'NV005', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231110', N'NV005', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231112', N'NV005', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231113', N'NV005', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231201', N'NV005', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231202', N'NV005', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231210', N'NV005', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00520231212', N'NV005', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV005122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231107', N'NV006', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 4, N'BLNV006112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231108', N'NV006', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231109', N'NV006', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231110', N'NV006', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231112', N'NV006', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231113', N'NV006', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231201', N'NV006', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231202', N'NV006', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231210', N'NV006', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00620231212', N'NV006', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV006122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231107', N'NV007', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231108', N'NV007', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 4, N'BLNV007112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231109', N'NV007', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231110', N'NV007', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231112', N'NV007', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231113', N'NV007', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231201', N'NV007', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231202', N'NV007', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231210', N'NV007', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00720231212', N'NV007', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV007122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231107', N'NV008', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231108', N'NV008', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 1, N'BLNV008112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231109', N'NV008', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231110', N'NV008', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231112', N'NV008', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231113', N'NV008', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231201', N'NV008', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231202', N'NV008', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231210', N'NV008', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00820231212', N'NV008', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV008122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231107', N'NV009', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 2, N'BLNV009112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231108', N'NV009', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 1, N'BLNV009112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231109', N'NV009', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV009112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231110', N'NV009', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV009112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231112', N'NV009', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV009112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231113', N'NV009', CAST(N'2023-11-13' AS Date), N'Nghỉ phép', 0, N'BLNV009112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231114', N'NV009', CAST(N'2023-11-14' AS Date), N'Làm nguyên ngày công', 0, N'BLNV009112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231201', N'NV009', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV009122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231202', N'NV009', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV009122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231210', N'NV009', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV009122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV00920231212', N'NV009', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV009122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231107', N'NV010', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 0, N'BLNV010112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231108', N'NV010', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 3, N'BLNV010112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231109', N'NV010', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV010112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231110', N'NV010', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV010112023')
GO
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231112', N'NV010', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV010112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231113', N'NV010', CAST(N'2023-11-13' AS Date), N'Nghỉ không phép', 0, N'BLNV010112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231201', N'NV010', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV010122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231202', N'NV010', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV010122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231210', N'NV010', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV010122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01020231212', N'NV010', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV010122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231107', N'NV011', CAST(N'2023-11-07' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231108', N'NV011', CAST(N'2023-11-08' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231109', N'NV011', CAST(N'2023-11-09' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231110', N'NV011', CAST(N'2023-11-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231112', N'NV011', CAST(N'2023-11-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231113', N'NV011', CAST(N'2023-11-13' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011112023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231201', N'NV011', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231202', N'NV011', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231210', N'NV011', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01120231212', N'NV011', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV011122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01420231201', N'NV014', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV014122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01420231202', N'NV014', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV014122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01420231210', N'NV014', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV014122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01420231212', N'NV014', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV014122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01520231201', N'NV015', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV015122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01520231202', N'NV015', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV015122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01520231210', N'NV015', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV015122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01520231212', N'NV015', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV015122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01620231201', N'NV016', CAST(N'2023-12-01' AS Date), N'Làm nguyên ngày công', 0, N'BLNV016122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01620231202', N'NV016', CAST(N'2023-12-02' AS Date), N'Làm nguyên ngày công', 0, N'BLNV016122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01620231210', N'NV016', CAST(N'2023-12-10' AS Date), N'Làm nguyên ngày công', 0, N'BLNV016122023')
INSERT [dbo].[BangChamCongNhanVien] ([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) VALUES (N'BCCNV01620231212', N'NV016', CAST(N'2023-12-12' AS Date), N'Làm nguyên ngày công', 0, N'BLNV016122023')
GO
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00120231110', 123, CAST(N'2023-11-10' AS Date), N'BLTLD001112023', N'TLD001', N'SP002CD001')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00120231111', 120, CAST(N'2023-11-11' AS Date), N'BLTLD001112023', N'TLD001', N'SP001CD001')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00120231201', 123, CAST(N'2023-12-01' AS Date), N'BLTLD001122023', N'TLD001', N'SP001CD001')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00120231212', 100, CAST(N'2023-12-12' AS Date), N'BLTLD001122023', N'TLD001', N'SP001CD001')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00220231110', 150, CAST(N'2023-11-10' AS Date), N'BLTLD002112023', N'TLD002', N'SP002CD001')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00220231111', 100, CAST(N'2023-11-11' AS Date), N'BLTLD002112023', N'TLD002', N'SP001CD004')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00220231212', 0, CAST(N'2023-12-12' AS Date), N'BLTLD002122023', N'TLD002', N'SP001CD004')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00320231110', 100, CAST(N'2023-11-10' AS Date), N'BLTLD003112023', N'TLD003', N'SP001CD004')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00320231111', 130, CAST(N'2023-11-11' AS Date), N'BLTLD003112023', N'TLD003', N'SP002CD001')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00320231212', 100, CAST(N'2023-12-12' AS Date), N'BLTLD003122023', N'TLD003', N'SP001CD005')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00420231212', 100, CAST(N'2023-12-12' AS Date), N'BLTLD004122023', N'TLD004', N'SP002CD001')
INSERT [dbo].[BangChamCongThoLamDan] ([maBCCThoLamDan], [soLuongSanPham], [ngayChamCong], [maBangLuong], [maThoLamDan], [maCongDoan]) VALUES (N'BCCTLD00520231212', 200, CAST(N'2023-12-12' AS Date), N'BLTLD005122023', N'TLD005', N'SP001CD005')
GO
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV001112023', 11, 2023, N'NV001', 6, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV001122023', 12, 2023, N'NV001', 4, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV002112023', 11, 2023, N'NV002', 5, 2, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV002122023', 12, 2023, N'NV002', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV003112023', 11, 2023, N'NV003', 7, 2, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV003122023', 12, 2023, N'NV003', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV004112023', 11, 2023, N'NV004', 6, 1, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV004122023', 12, 2023, N'NV004', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV005112023', 11, 2023, N'NV005', 5, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV005122023', 12, 2023, N'NV005', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV006112023', 11, 2023, N'NV006', 5, 4, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV006122023', 12, 2023, N'NV006', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV007112023', 11, 2023, N'NV007', 5, 4, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV007122023', 12, 2023, N'NV007', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV008112023', 11, 2023, N'NV008', 5, 1, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV008122023', 12, 2023, N'NV008', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV009112023', 11, 2023, N'NV009', 5, 3, 1, 0, 0, 1)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV009122023', 12, 2023, N'NV009', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV010112023', 11, 2023, N'NV010', 4, 3, 1, 0, 1, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV010122023', 12, 2023, N'NV010', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV011112023', 11, 2023, N'NV011', 5, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV011122023', 12, 2023, N'NV011', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV014112023', 11, 2023, N'NV014', 0, 0, 0, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV014122023', 12, 2023, N'NV014', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV015112023', 11, 2023, N'NV015', 0, 0, 0, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV015122023', 12, 2023, N'NV015', 3, 0, 1, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV016112023', 11, 2023, N'NV016', 0, 0, 0, 0, 0, 0)
INSERT [dbo].[BangLuongNhanVien] ([maBangLuong], [thang], [nam], [maNhanVien], [soNgayThuongDiLam], [soGioTangCaNgayThuong], [soNgayLamChuNhat], [soGioTangCaChuNhat], [soNgayNghiKhongPhep], [soNgayNghiCoPhep]) VALUES (N'BLNV016122023', 12, 2023, N'NV016', 3, 0, 1, 0, 0, 0)
GO
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD001102023', N'TLD001', 10, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD001112023', N'TLD001', 11, 2023, 243)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD001122023', N'TLD001', 12, 2023, 223)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD002102023', N'TLD002', 10, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD002112023', N'TLD002', 11, 2023, 250)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD002122023', N'TLD002', 12, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD003102023', N'TLD003', 10, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD003112023', N'TLD003', 11, 2023, 230)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD003122023', N'TLD003', 12, 2023, 100)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD004102023', N'TLD004', 10, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD004112023', N'TLD004', 11, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD004122023', N'TLD004', 12, 2023, 100)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD005102023', N'TLD005', 10, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD005112023', N'TLD005', 11, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD005122023', N'TLD005', 12, 2023, 200)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD006102023', N'TLD006', 10, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD006112023', N'TLD006', 11, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD006122023', N'TLD006', 12, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD007112023', N'TLD007', 11, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD008102023', N'TLD008', 10, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD008112023', N'TLD008', 11, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD008122023', N'TLD008', 12, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD009102023', N'TLD009', 10, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD009112023', N'TLD009', 11, 2023, 0)
INSERT [dbo].[BangLuongThoLamDan] ([maBangLuong], [maThoLamDan], [thang], [nam], [soLuong]) VALUES (N'BLTLD009122023', N'TLD009', 12, 2023, 0)
GO
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD001', N'SP001CD001', CAST(N'2023-11-11' AS Date), 120)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD001', N'SP001CD001', CAST(N'2023-12-01' AS Date), 123)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD001', N'SP001CD001', CAST(N'2023-12-10' AS Date), 123)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD001', N'SP001CD001', CAST(N'2023-12-12' AS Date), 100)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD001', N'SP002CD001', CAST(N'2023-11-10' AS Date), 123)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD002', N'SP001CD001', CAST(N'2023-12-01' AS Date), 120)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD002', N'SP001CD004', CAST(N'2023-11-11' AS Date), 100)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD002', N'SP001CD004', CAST(N'2023-12-12' AS Date), 100)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD002', N'SP002CD001', CAST(N'2023-11-10' AS Date), 150)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD003', N'SP001CD003', CAST(N'2023-11-13' AS Date), 123)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD003', N'SP001CD003', CAST(N'2023-12-01' AS Date), 140)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD003', N'SP001CD003', CAST(N'2023-12-11' AS Date), 123)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD003', N'SP001CD004', CAST(N'2023-11-10' AS Date), 100)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD003', N'SP001CD005', CAST(N'2023-12-12' AS Date), 100)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD003', N'SP002CD001', CAST(N'2023-11-09' AS Date), 123)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD003', N'SP002CD001', CAST(N'2023-11-11' AS Date), 134)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD004', N'SP001CD003', CAST(N'2023-12-01' AS Date), 123)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD004', N'SP002CD001', CAST(N'2023-12-12' AS Date), 120)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD005', N'SP001CD002', CAST(N'2023-11-13' AS Date), 1234)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD005', N'SP001CD005', CAST(N'2023-12-01' AS Date), 140)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD005', N'SP001CD005', CAST(N'2023-12-12' AS Date), 200)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD006', N'SP002CD001', CAST(N'2023-11-13' AS Date), 100)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD006', N'SP005CD006', CAST(N'2023-12-01' AS Date), 140)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD008', N'SP005CD003', CAST(N'2023-12-01' AS Date), 140)
INSERT [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham]) VALUES (N'TLD009', N'SP005CD006', CAST(N'2023-12-01' AS Date), 240)
GO
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP001CD001', N'Lựa chọn chất liệu gỗ', N'SP001', 10000)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP001CD002', N'Chế tác mặt đàn', N'SP001', 1000)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP001CD003', N'Xử lý độ ẩm', N'SP001', 1200)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP001CD004', N'Chế tác cầu ngựa', N'SP001', 123)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP001CD005', N'Tinh chỉnh âm thanh', N'SP001', 123)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP002CD001', N'Chế tác mặt đàn', N'SP002', 5000)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP002CD002', N'Xử lý độ ẩm', N'SP002', 111)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP004CD001', N'Chế tác cần đàn', N'SP004', 65000)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP004CD002', N'Lựa chọn chất liệu gỗ', N'SP004', 123)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP004CD003', N'Chế tác eo lưng', N'SP004', 113000)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP004CD004', N'Chế tác mặt phím', N'SP004', 12344)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP004CD005', N'Chế tác cầu ngựa', N'SP004', 12)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP004CD006', N'Xử lý độ ẩm', N'SP004', 122)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP004CD007', N'Hoàn thiện và làm đẹp', N'SP004', 3333)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP005CD001', N'Lựa chọn chất liệu gỗ', N'SP005', 2133)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP005CD002', N'Chế tác mặt đàn', N'SP005', 1220)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP005CD003', N'Xử lý độ ẩm', N'SP005', 12233)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP005CD004', N'Thiết kế lỗ thoát âm', N'SP005', 123)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP005CD005', N'Tinh chỉnh âm thanh', N'SP005', 123)
INSERT [dbo].[CongDoan] ([maCongDoan], [tenCongDoan], [maSanPham], [giaCongDoan]) VALUES (N'SP005CD006', N'Chế tác cầu ngựa', N'SP005', 13)
GO
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000001', N'Chung Gia B', 1, CAST(N'2003-09-24' AS Date), N'056203000071', N'0987654321', N'Quận Tân Bình, Tp. Hồ Chí Minh', 1, CAST(N'2022-03-10' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000002', N'Nguyễn Văn A', 1, CAST(N'1995-05-15' AS Date), N'012345678912', N'0987654322', N'Quận 1, Tp. Hồ Chí Minh', 1, CAST(N'2020-06-20' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000003', N'Trần Thị B', 0, CAST(N'1990-12-10' AS Date), N'098765431221', N'0123456789', N'Quận 2, Tp. Hồ Chí Minh', 1, CAST(N'2018-04-15' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000004', N'Lê Văn C', 1, CAST(N'1987-07-05' AS Date), N'012332456789', N'0987654323', N'Quận 3, Tp. Hồ Chí Minh', 1, CAST(N'2015-10-10' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000005', N'Phạm Thị D', 0, CAST(N'1988-09-20' AS Date), N'098547654321', N'0123456789', N'Quận 4, Tp. Hồ Chí Minh', 1, CAST(N'2017-12-05' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000006', N'Huỳnh Văn E', 1, CAST(N'1993-02-12' AS Date), N'012345646789', N'0987654324', N'Quận 5, Tp. Hồ Chí Minh', 1, CAST(N'2016-08-30' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000007', N'Võ Thị F', 0, CAST(N'1986-11-25' AS Date), N'098765234321', N'0123456789', N'Quận 6, Tp. Hồ Chí Minh', 1, CAST(N'2019-02-18' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000008', N'Lý Thị G', 0, CAST(N'1990-07-15' AS Date), N'012344556789', N'0987654325', N'Quận 7, Tp. Hồ Chí Minh', 1, CAST(N'2017-06-10' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000009', N'Nguyễn Văn H', 1, CAST(N'1991-03-30' AS Date), N'098765654321', N'0123456789', N'Quận 8, Tp. Hồ Chí Minh', 1, CAST(N'2018-08-25' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000010', N'Lê Thị I', 0, CAST(N'1992-08-05' AS Date), N'012893456789', N'0987654326', N'Quận 9, Tp. Hồ Chí Minh', 1, CAST(N'2020-01-12' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000011', N'Hồ Văn K', 1, CAST(N'1989-06-20' AS Date), N'095687654321', N'0123456789', N'Quận 10, Tp. Hồ Chí Minh', 1, CAST(N'2016-12-08' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000012', N'Trần Thị K', 0, CAST(N'1993-03-20' AS Date), N'012123456786', N'0987654328', N'Quận 7, Tp. Hồ Chí Minh', 0, CAST(N'2018-12-05' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000013', N'Võ Văn K', 1, CAST(N'1988-11-10' AS Date), N'098741654329', N'0123456785', N'Quận 6, Tp. Hồ Chí Minh', 0, CAST(N'2017-07-10' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000014', N'Hồ Hoàng Ki', 1, CAST(N'1998-11-10' AS Date), N'075203000052', N'0123456785', N'Quận Tân Phú, Tp. Hồ Chí Minh', 1, CAST(N'1998-11-10' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000015', N'Nguyễn Tiến L', 1, CAST(N'1990-01-15' AS Date), N'075203000063', N'0123456789', N'Quận 9, Tp. Hồ Chí Minh', 1, CAST(N'2018-08-20' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000016', N'Cao Nguyễn Quỳnh N', 0, CAST(N'1989-03-15' AS Date), N'075203000065', N'0123456791', N'Quận 2, Tp. Hồ Chí Minh', 1, CAST(N'2018-10-15' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000017', N'Lê Võ Quỳnh N', 0, CAST(N'1991-04-18' AS Date), N'075203000066', N'0123456792', N'Quận 3, Tp. Hồ Chí Minh', 1, CAST(N'2018-11-10' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000018', N'Nguyễn Công P', 1, CAST(N'1987-05-22' AS Date), N'075203000067', N'0123456793', N'Quận 4, Tp. Hồ Chí Minh', 1, CAST(N'2018-12-15' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000019', N'Trịnh Thị C', 0, CAST(N'1986-06-30' AS Date), N'075203000068', N'0123456794', N'Quận 5, Tp. Hồ Chí Minh', 1, CAST(N'2019-01-20' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000020', N'Phạm An T', 1, CAST(N'1992-07-28' AS Date), N'075203000069', N'0123456795', N'Quận 6, Tp. Hồ Chí Minh', 0, CAST(N'2019-02-25' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000021', N'Nguyễn Lê Thảo T', 0, CAST(N'1984-08-19' AS Date), N'075203000070', N'0123456796', N'Quận 7, Tp. Hồ Chí Minh', 1, CAST(N'2019-03-30' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000022', N'Nguyễn Ngọc T', 0, CAST(N'1983-09-15' AS Date), N'075203000071', N'0123456797', N'Quận 8, Tp. Hồ Chí Minh', 1, CAST(N'2019-04-10' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000023', N'Vũ Nguyễn Minh Đ', 1, CAST(N'2003-11-19' AS Date), N'075203000069', N'0369160539', N'Quận Tân Phú, TPHCM', 1, CAST(N'2023-11-28' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000024', N'Nguyễn Đức N', 0, CAST(N'2003-11-13' AS Date), N'075203000096', N'0399160539', N'Quận Tân Bình, Tphcm', 1, CAST(N'2023-11-28' AS Date))
INSERT [dbo].[CongNhanVien] ([maCongNhanVien], [hoTen], [gioiTinh], [ngaySinh], [maCanCuocCongDan], [soDienThoai], [diaChi], [trangThai], [ngayVaoLam]) VALUES (N'CNV000025', N'Nguyễn Bảo Ngọc', 0, CAST(N'2003-11-04' AS Date), N'047203000096', N'0369160531', N'Quận Bình Thạnh, TPHCM', 1, CAST(N'2023-12-12' AS Date))
GO
INSERT [dbo].[Dan] ([maSanPham], [tenSanPham], [loaiSanPham], [moTa], [giaBan], [matDan], [eoLung], [can], [matPhim], [day], [khoa], [cauNgua], [trangThai]) VALUES (N'SP001', N'ĐÀN GUITAR CLASSIC VE-70-C', N'ACOUSTIC', N'Bảo hành: 6 tháng', 950000, N'Gỗ thông sitka', N'Gỗ cẩm Ấn', N'Gỗ thao lao', N'Gỗ mật', N'Alice A107', N'Đài Loan', N'Gỗ mật', 1)
INSERT [dbo].[Dan] ([maSanPham], [tenSanPham], [loaiSanPham], [moTa], [giaBan], [matDan], [eoLung], [can], [matPhim], [day], [khoa], [cauNgua], [trangThai]) VALUES (N'SP002', N'Đàn Guitar Classic C-100', N'CLASSIC', N'Bảo hành 5 tháng', 1500000, N'Thông Cedar', N'Gỗ cẩm Ấn', N'Gỗ giá tỵ', N'Gỗ mun', N'Elixir', N'Nhật Bản', N'Gỗ mun', 1)
INSERT [dbo].[Dan] ([maSanPham], [tenSanPham], [loaiSanPham], [moTa], [giaBan], [matDan], [eoLung], [can], [matPhim], [day], [khoa], [cauNgua], [trangThai]) VALUES (N'SP004', N'Đàn Guitar Classic C-100-J', N'CLASSIC', N'Mo ta san pham 4', 2000000, N'Gỗ thông Sitka', N'Gỗ hồng đào', N'Gỗ giá tỵ', N'Gỗ mật', N'Alice AW432', N'Nhật Bản', N'Gỗ mật', 1)
INSERT [dbo].[Dan] ([maSanPham], [tenSanPham], [loaiSanPham], [moTa], [giaBan], [matDan], [eoLung], [can], [matPhim], [day], [khoa], [cauNgua], [trangThai]) VALUES (N'SP005', N'Đàn Guitar Acoustic D-200', N'ACOUSTIC', N'Mo ta san pham 5', 1800000, N'Thông Cedar', N'Ván ép chất lượng cao', N'Gỗ thao lao', N'Gỗ mun', N'Elixir', N'Đài Loan', N'Gỗ mun', 1)
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV001', N'Phó Phòng', N'Đại học', 4160000, N'PB001', N'CNV000001')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV002', N'Trưởng Phòng', N'Đại học', 3000000, N'PB002', N'CNV000002')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV003', N'Nhân Viên', N'Cao Đẳng', 4680000, N'PB001', N'CNV000003')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV004', N'Nhân Viên', N'Đại học', 3000000, N'PB003', N'CNV000004')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV005', N'Nhân Viên', N'Cao Đẳng', 4680000, N'PB004', N'CNV000005')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV006', N'Trưởng Phòng', N'Đại học', 3000000, N'PB005', N'CNV000006')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV007', N'Phó Phòng', N'Cao Đẳng', 4680000, N'PB001', N'CNV000007')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV008', N'Phó Phòng', N'Đại học', 3000000, N'PB002', N'CNV000008')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV009', N'Trưởng Phòng', N'Đại học', 3000000, N'PB003', N'CNV000009')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV010', N'Nhân Viên', N'Đại học', 3000000, N'PB004', N'CNV000010')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV011', N'Phó Phòng', N'Đại học', 3000000, N'PB005', N'CNV000011')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV012', N'Nhân Viên', N'Cao Đẳng', 3000000, N'PB004', N'CNV000012')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV013', N'Phó Phòng', N'Đại học', 3000000, N'PB003', N'CNV000013')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV014', N'Nhân Viên', N'Đại học', 4500000, N'PB002', N'CNV000022')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV015', N'Nhân Viên', N'Đại học', 4500000, N'PB001', N'CNV000023')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV016', N'Nhân Viên', N'Đại học', 4500000, N'PB001', N'CNV000024')
INSERT [dbo].[NhanVien] ([maNhanVien], [chucVu], [trinhDoVanHoa], [luongCoBan], [maPhongBan], [maCongNhanVien]) VALUES (N'NV017', N'Nhân Viên', N'Đại học', 4500000, N'PB001', N'CNV000025')
GO
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan]) VALUES (N'PB001', N'Marketing')
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan]) VALUES (N'PB002', N'Nhân Sự')
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan]) VALUES (N'PB003', N'Kinh Doanh')
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan]) VALUES (N'PB004', N'Phát Triển Sản Phẩm')
INSERT [dbo].[PhongBan] ([maPhongBan], [tenPhongBan]) VALUES (N'PB005', N'Điều phối')
GO
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau], [maNhanVien]) VALUES (N'NV002', N'123', N'NV002')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau], [maNhanVien]) VALUES (N'NV006', N'123', N'NV006')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau], [maNhanVien]) VALUES (N'NV008', N'123', N'NV008')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau], [maNhanVien]) VALUES (N'NV011', N'123', N'NV011')
GO
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD001', N'Bậc 1', N'CNV000014')
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD002', N'Bậc 1', N'CNV000015')
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD003', N'Bậc 2', N'CNV000016')
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD004', N'Bậc 3', N'CNV000017')
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD005', N'Bậc 4', N'CNV000018')
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD006', N'Bậc 5', N'CNV000019')
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD007', N'Bậc 1', N'CNV000020')
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD008', N'Bậc 2', N'CNV000021')
INSERT [dbo].[ThoLamDan] ([maThoLamDan], [tayNghe], [maCongNhanVien]) VALUES (N'TLD009', N'Bậc 3', N'CNV000022')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_CongNhanVien]    Script Date: 15/12/2023 1:28:19 PM ******/
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [UQ_CongNhanVien] UNIQUE NONCLUSTERED 
(
	[maCongNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_TaiKhoan_maNhanVien]    Script Date: 15/12/2023 1:28:19 PM ******/
ALTER TABLE [dbo].[TaiKhoan] ADD  CONSTRAINT [UQ_TaiKhoan_maNhanVien] UNIQUE NONCLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UC_maCongNhanVien]    Script Date: 15/12/2023 1:28:19 PM ******/
ALTER TABLE [dbo].[ThoLamDan] ADD  CONSTRAINT [UC_maCongNhanVien] UNIQUE NONCLUSTERED 
(
	[maCongNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CongNhanVien] ADD  CONSTRAINT [IDCNV]  DEFAULT ([DBO].[AUTO_IDCNV]()) FOR [maCongNhanVien]
GO
ALTER TABLE [dbo].[Dan] ADD  CONSTRAINT [IDSP]  DEFAULT ([DBO].[AUTO_IDSP]()) FOR [maSanPham]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [IDNV]  DEFAULT ([DBO].[AUTO_IDNV]()) FOR [maNhanVien]
GO
ALTER TABLE [dbo].[PhongBan] ADD  CONSTRAINT [IDPB]  DEFAULT ([DBO].[AUTO_IDPB]()) FOR [maPhongBan]
GO
ALTER TABLE [dbo].[ThoLamDan] ADD  CONSTRAINT [IDTLD]  DEFAULT ([DBO].[AUTO_IDTLD]()) FOR [maThoLamDan]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD FOREIGN KEY([maBangLuong])
REFERENCES [dbo].[BangLuongNhanVien] ([maBangLuong])
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[BangChamCongThoLamDan]  WITH CHECK ADD  CONSTRAINT [fk_BangChamCongThoLamDan_BangPhanCong] FOREIGN KEY([maThoLamDan], [maCongDoan], [ngayChamCong])
REFERENCES [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong])
GO
ALTER TABLE [dbo].[BangChamCongThoLamDan] CHECK CONSTRAINT [fk_BangChamCongThoLamDan_BangPhanCong]
GO
ALTER TABLE [dbo].[BangChamCongThoLamDan]  WITH CHECK ADD  CONSTRAINT [fk_maBangLuong] FOREIGN KEY([maBangLuong])
REFERENCES [dbo].[BangLuongThoLamDan] ([maBangLuong])
GO
ALTER TABLE [dbo].[BangChamCongThoLamDan] CHECK CONSTRAINT [fk_maBangLuong]
GO
ALTER TABLE [dbo].[BangLuongNhanVien]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[BangLuongThoLamDan]  WITH CHECK ADD FOREIGN KEY([maThoLamDan])
REFERENCES [dbo].[ThoLamDan] ([maThoLamDan])
GO
ALTER TABLE [dbo].[BangPhanCong]  WITH CHECK ADD  CONSTRAINT [FK_BangPhanCong_CongDoan] FOREIGN KEY([maCongDoan])
REFERENCES [dbo].[CongDoan] ([maCongDoan])
GO
ALTER TABLE [dbo].[BangPhanCong] CHECK CONSTRAINT [FK_BangPhanCong_CongDoan]
GO
ALTER TABLE [dbo].[BangPhanCong]  WITH CHECK ADD  CONSTRAINT [FK_BangPhanCong_ThoLamDan] FOREIGN KEY([maThoLamDan])
REFERENCES [dbo].[ThoLamDan] ([maThoLamDan])
GO
ALTER TABLE [dbo].[BangPhanCong] CHECK CONSTRAINT [FK_BangPhanCong_ThoLamDan]
GO
ALTER TABLE [dbo].[CongDoan]  WITH CHECK ADD FOREIGN KEY([maSanPham])
REFERENCES [dbo].[Dan] ([maSanPham])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([maCongNhanVien])
REFERENCES [dbo].[CongNhanVien] ([maCongNhanVien])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([maPhongBan])
REFERENCES [dbo].[PhongBan] ([maPhongBan])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[ThoLamDan]  WITH CHECK ADD  CONSTRAINT [fk_maCongNhanVien] FOREIGN KEY([maCongNhanVien])
REFERENCES [dbo].[CongNhanVien] ([maCongNhanVien])
GO
ALTER TABLE [dbo].[ThoLamDan] CHECK CONSTRAINT [fk_maCongNhanVien]
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD CHECK  (([soGioTangCa]>=(0) AND [soGioTangCa]<=(4)))
GO
ALTER TABLE [dbo].[BangChamCongNhanVien]  WITH CHECK ADD CHECK  (([trangThaiDiLam]=N'Nghỉ không phép' OR [trangThaiDiLam]=N'Nghỉ phép' OR [trangThaiDiLam]=N'Làm nửa ngày công' OR [trangThaiDiLam]=N'Làm nguyên ngày công'))
GO
ALTER TABLE [dbo].[BangLuongNhanVien]  WITH CHECK ADD CHECK  (([thang]>(0) AND [thang]<(13)))
GO
ALTER TABLE [dbo].[BangLuongNhanVien]  WITH CHECK ADD  CONSTRAINT [CK__BangLuongNh__nam__5EBF139D] CHECK  (([nam]>(1970) AND [nam]<=datepart(year,getdate())))
GO
ALTER TABLE [dbo].[BangLuongNhanVien] CHECK CONSTRAINT [CK__BangLuongNh__nam__5EBF139D]
GO
ALTER TABLE [dbo].[BangLuongThoLamDan]  WITH CHECK ADD CHECK  (([thang]>(0) AND [thang]<(13)))
GO
ALTER TABLE [dbo].[BangLuongThoLamDan]  WITH CHECK ADD CHECK  (([nam]>(1970) AND [nam]<=datepart(year,getdate())))
GO
ALTER TABLE [dbo].[CongDoan]  WITH CHECK ADD CHECK  (([giaCongDoan]>=(0)))
GO
ALTER TABLE [dbo].[CongNhanVien]  WITH CHECK ADD CHECK  (([gioiTinh]=(0) OR [gioiTinh]=(1)))
GO
ALTER TABLE [dbo].[CongNhanVien]  WITH CHECK ADD CHECK  (([hoTen] like N'%[A-Za-z ]%'))
GO
ALTER TABLE [dbo].[CongNhanVien]  WITH CHECK ADD CHECK  (([maCanCuocCongDan] like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
GO
ALTER TABLE [dbo].[CongNhanVien]  WITH CHECK ADD CHECK  (([ngaySinh]<=dateadd(year,(-18),getdate())))
GO
ALTER TABLE [dbo].[CongNhanVien]  WITH CHECK ADD CHECK  (([soDienThoai] like '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([can]=N'Gỗ giá tỵ' OR [can]=N'Gỗ thao lao'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([cauNgua]=N'Gỗ đen' OR [cauNgua]=N'Gỗ mun' OR [cauNgua]=N'Gỗ mật'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([day]=N'Alice AW432' OR [day]=N'Alice A206' OR [day]=N'Elixir' OR [day]=N'Alice A107'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([eoLung]=N'Gỗ hồng đào' OR [eoLung]=N'Gỗ điệp Solid' OR [eoLung]=N'Gỗ cẩm Ấn' OR [eoLung]=N'Ván ép chất lượng cao'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([giaBan]>=(0)))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([khoa]=N'Nhật Bản' OR [khoa]=N'Đài Loan'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([loaiSanPham]=N'CLASSIC' OR [loaiSanPham]=N'ACOUSTIC'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([matDan]=N'Thông Solid' OR [matDan]=N'Thông Cedar' OR [matDan]=N'Gỗ thông Sitka'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD  CONSTRAINT [CK__Dan__matPhim__4BAC3F29] CHECK  (([matPhim]=N'Gỗ đen' OR [matPhim]=N'Gỗ mun' OR [matPhim]=N'Gỗ mật'))
GO
ALTER TABLE [dbo].[Dan] CHECK CONSTRAINT [CK__Dan__matPhim__4BAC3F29]
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([moTa] like N'%[A-Za-z ]%'))
GO
ALTER TABLE [dbo].[Dan]  WITH CHECK ADD CHECK  (([tenSanPham] like N'%[A-Za-z ]%'))
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD CHECK  (([chucVu]=N'Nhân viên' OR [chucVu]=N'Phó phòng' OR [chucVu]=N'Trưởng phòng'))
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD CHECK  (([trinhDoVanHoa]=N'Đại học' OR [trinhDoVanHoa]=N'Cao đẳng'))
GO
ALTER TABLE [dbo].[PhongBan]  WITH CHECK ADD CHECK  (([tenPhongBan] like N'%[A-Za-z ]%'))
GO
ALTER TABLE [dbo].[ThoLamDan]  WITH CHECK ADD CHECK  (([tayNghe]=N'Bậc 5' OR [tayNghe]=N'Bậc 4' OR [tayNghe]=N'Bậc 3' OR [tayNghe]=N'Bậc 2' OR [tayNghe]=N'Bậc 1'))
GO
/****** Object:  StoredProcedure [dbo].[select_BCCNV]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_BCCNV]
as
	SELECT * FROM [dbo].[BangChamCongNhanVien]

GO
/****** Object:  StoredProcedure [dbo].[select_BCCTLD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_BCCTLD]
as
	SELECT * FROM [dbo].[BangChamCongThoLamDan]
GO
/****** Object:  StoredProcedure [dbo].[select_BLNV]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_BLNV]
as
	SELECT * FROM [dbo].[BangLuongNhanVien]

GO
/****** Object:  StoredProcedure [dbo].[select_BLTLD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_BLTLD]
as
	SELECT * FROM [dbo].[BangLuongThoLamDan]

GO
/****** Object:  StoredProcedure [dbo].[select_CD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_CD]
as
	SELECT * FROM [dbo].[CongDoan]
GO
/****** Object:  StoredProcedure [dbo].[select_CNV]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_CNV]
as
	SELECT * FROM [dbo].[CongNhanVien]

GO
/****** Object:  StoredProcedure [dbo].[select_Dan]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_Dan]
as
	SELECT * FROM [dbo].[Dan]
GO
/****** Object:  StoredProcedure [dbo].[select_NV]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_NV]
as
	SELECT * FROM [dbo].[NhanVien]
--ThoLamDan

GO
/****** Object:  StoredProcedure [dbo].[select_PB]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_PB]
as
	SELECT * FROM [dbo].[PhongBan]

GO
/****** Object:  StoredProcedure [dbo].[select_PC]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_PC]
as
	SELECT * FROM [dbo].[PhanCong]
GO
/****** Object:  StoredProcedure [dbo].[select_TLD]    Script Date: 15/12/2023 1:28:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[select_TLD]
as
	SELECT * FROM [dbo].[ThoLamDan]
GO
USE [master]
GO
ALTER DATABASE [QuanLyLuongSP] SET  READ_WRITE 
GO
