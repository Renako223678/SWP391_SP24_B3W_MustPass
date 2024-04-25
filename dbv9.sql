USE [master]
GO
/****** Object:  Database [BookStore]    Script Date: 25/04/2024 9:13:59 CH ******/
CREATE DATABASE [BookStore]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookStore', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.QUANGTRAN\MSSQL\DATA\BookStore.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BookStore_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.QUANGTRAN\MSSQL\DATA\BookStore_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BookStore] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookStore].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookStore] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookStore] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookStore] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookStore] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookStore] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookStore] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [BookStore] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookStore] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookStore] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookStore] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookStore] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookStore] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookStore] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookStore] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookStore] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BookStore] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookStore] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookStore] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookStore] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookStore] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookStore] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookStore] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookStore] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BookStore] SET  MULTI_USER 
GO
ALTER DATABASE [BookStore] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookStore] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookStore] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookStore] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BookStore] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BookStore] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BookStore] SET QUERY_STORE = OFF
GO
USE [BookStore]
GO
/****** Object:  Table [dbo].[BookImages]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookImages](
	[ImageId] [int] IDENTITY(1,1) NOT NULL,
	[Url] [nvarchar](max) NULL,
	[Status] [int] NULL,
	[BookId] [int] NOT NULL,
 CONSTRAINT [PK__BookImag__7516F70CA7C86FE1] PRIMARY KEY CLUSTERED 
(
	[ImageId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Books]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books](
	[BookId] [int] IDENTITY(1,1) NOT NULL,
	[BookName] [nvarchar](max) NULL,
	[Description] [nvarchar](max) NULL,
	[AuthorName] [nvarchar](50) NULL,
	[PublishingCompany] [nvarchar](50) NULL,
	[IssusingCompany] [nvarchar](50) NULL,
	[TranslatorName] [nvarchar](50) NULL,
	[PublishYear] [int] NULL,
	[Quantity] [int] NULL,
	[SubCategoryId] [int] NULL,
	[UnitPrice] [int] NULL,
	[CategoryID] [int] NULL,
	[Status] [int] NULL,
	[TotalFeedback] [int] NULL,
 CONSTRAINT [PK__Books__3DE0C2078BDCD8AC] PRIMARY KEY CLUSTERED 
(
	[BookId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](50) NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK_Catogory] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FeedBack]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeedBack](
	[FeedBackId] [int] IDENTITY(1,1) NOT NULL,
	[Star] [int] NULL,
	[Description] [text] NULL,
	[UserId] [int] NULL,
	[BookId] [int] NULL,
 CONSTRAINT [PK__FeedBack__E2CB3B87D9818DAF] PRIMARY KEY CLUSTERED 
(
	[FeedBackId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderDetailId] [int] IDENTITY(1,1) NOT NULL,
	[BookId] [int] NOT NULL,
	[OrderId] [int] NOT NULL,
	[Quantity] [int] NULL,
	[UnitPrice] [float] NULL,
	[TotalPrice] [float] NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK__OrdersDe__D1D9C7BBFE94AF37] PRIMARY KEY CLUSTERED 
(
	[OrderDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderId] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](max) NULL,
	[OrderDate] [datetime] NULL,
	[ShipFee] [int] NULL,
	[UsedLotusBub] [int] NULL,
	[TotalPrice] [int] NULL,
	[FinalPrice] [int] NULL,
	[Status] [int] NULL,
	[UserId] [int] NOT NULL,
	[RecipientId] [int] NOT NULL,
 CONSTRAINT [PK__Orders__C3905BCFB1567F5A] PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[PaymentId] [bigint] NOT NULL,
	[PaymentDate] [date] NULL,
	[PaymentMethod] [varchar](50) NULL,
	[Total] [decimal](18, 0) NULL,
	[Status] [tinyint] NULL,
	[OrderId] [int] NULL,
 CONSTRAINT [PK__Payment__9B556A3857460A23] PRIMARY KEY CLUSTERED 
(
	[PaymentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recipient]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recipient](
	[RecipientId] [int] IDENTITY(1,1) NOT NULL,
	[DestAddress] [nvarchar](max) NULL,
	[RecipientName] [nvarchar](max) NULL,
	[PhoneNumber] [int] NULL,
	[Status] [int] NULL,
	[UserId] [int] NULL,
 CONSTRAINT [PK__Recipien__F0A6024DC37490A8] PRIMARY KEY CLUSTERED 
(
	[RecipientId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[RoleId] [int] NOT NULL,
	[RoleName] [varchar](50) NULL,
	[Descriptions] [varchar](100) NULL,
 CONSTRAINT [PK__Roles__8AFACE1A61D978B3] PRIMARY KEY CLUSTERED 
(
	[RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SubCategory]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SubCategory](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SubName] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[Status] [int] NULL,
	[CategoryId] [int] NULL,
 CONSTRAINT [PK_SubCatogory] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 25/04/2024 9:13:59 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[Email] [nvarchar](max) NULL,
	[Password] [nvarchar](max) NULL,
	[Fullname] [nvarchar](max) NULL,
	[Number_of_Lotus] [int] NULL,
	[RoleID] [int] NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK__Users__1788CC4C57DFB817] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[BookImages] ON 

INSERT [dbo].[BookImages] ([ImageId], [Url], [Status], [BookId]) VALUES (1, N'https://product.hstatic.net/200000017360/product/hh_nhungkhucnhac_hayvade_b1_10ed9b36960e4f44946fc10f9b8e520d_compact.jpg', 1, 8)
SET IDENTITY_INSERT [dbo].[BookImages] OFF
GO
SET IDENTITY_INSERT [dbo].[Books] ON 

INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (4, N'Sách Âm Nhạc ', N'Sách Việt Nam', N'Nam Cao', N'Công ti NASA', N'FaHASA', N'Nguyễn Cu', 2023, 30, 3, 100000, 2, 1, 10)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (5, N'Sách Hội họa', N'Sách Trung Quốc', N'Lão Hạc', N'Công ti FAHHA', N'Công ti FAHHA', N'Lão hạc', 2023, 30, 2, 150000, 2, 1, 1)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (6, N'Sách Văn học Việt Nam', N'Sách Nhật', N'Chị Dậu', N'Công ti FAHHA', N'Công ti FAHHA', N'Lão hạc', 2023, 30, 4, 100000, 3, 1, 1)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (7, N'Sách Âm Nhạc ', N'Sách Hàn Quốc', N'Chị Dậu', N'Công ti FAHHA', N'Công ti FAHHA', N'Lão hạc', 2023, 30, 3, 100000, 2, 2, 1)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (8, N'NHỮNG NHẠC KHÚC HAY & DỄ SOẠN CHO ĐÀN PIANO (TÁI BẢN 2023)', N'Sách Hàn', N' Song Minh (biên soạn)', N'Dân Trí', N'Công ti FAHHA', N'Lão hạc', 2023, 30, 1, 100000, 2, 1, 1)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (9, N'Sách Âm Nhạc ', N'AAA', N'AAAA', N'AAAA', N'AAAA', N'AAAA', 2023, 30, 2, 100000, 2, 1, 1)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (11, N'AAA', N'MapProjectsTeam', N'AAA', N'AAA', N'AAA', N'AAA1', 2020, 2222, 1, 2, 2, 1, 2)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (12, N'Con Cy Gia già  clm ', N'MapProjectsTeam', N'AAA1', N'AAA12', N'AAA1', N'AAA1', 2020, 222, 2, 2, 3, 2, 2)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (13, N'AAA1', N'MapProjectsTeam', N'AAA1', N'AAA1', N'AAA1', N'Nguyễn Cu', 1222, 1001, 2, 22, 2, 1, 2)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (15, N'AAA1', N'MapProjectsTeam', N'AAA1', N'Công ti NASA', N'AAA1', N'Nguyễn Cu', 2024, 22, 2, 22, 2, 1, 12)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (16, N'alo', N'MapProjectsTeam', N'AAA1', N'AAA12', N'AAA1', N'Nguyễn Cu', 2025, 30, 2, 22, 2, 1, 2)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (17, N'alo 2', N'MapProjectsTeam', N'AAA1', N'AAA12', N'AAA1', N'Nguyễn Cu', 2025, 30, 1, 22, 2, 1, 2)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (18, N'Sách Âm Nhạc ', N'MapProjectsTeam', N'AAA1', N'AAA1', N'AAA1', N'Nguyễn Cu', 2026, 2001, 1, 200000, 2, 1, 2)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (19, N'Sách thi ca', N'Sách Hàn', N'Chị Dậu', N'Dân Trí', N'Công ti FAHHA', N'Nguyễn Công', 2020, 123, 4, 123, 3, 1, 10)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (20, N'Sách thi ca', N'Sách Hàn', N'Chị Dậu', N'Dân Trí', N'Công ti FAHHA', N'Nguyễn Công', 2021, 30, 6, 100000, 4, 1, 10)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (21, N'eurro', N'tesst', N'test', N'test', N'aa', N'aa', 19, 30, 17, 50000, 11, 1, 0)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (22, N'eurro', N'tesst', N'test', N'test', N'aa', N'aa', 19, 123, 16, 123, 2, 1, 0)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishYear], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (23, N'eu', N'tesst', N'test', N'test', N'aa', N'aa', 2028, 123, 1, 123, 3, 1, 0)
SET IDENTITY_INSERT [dbo].[Books] OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (2, N'Văn Hóa - Nghệ Thuật', 2)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (3, N'Văn học', 1)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (4, N'Tâm lí- Nghệ thuật sống', 1)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (7, N'Văn Hóa - Nghệ Thuật2', 1)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (8, N'Văn Hóa - Nghệ Thuật2', 1)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (9, N'Văn Hóa - Nghệ Thuật', 1)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (10, N'Văn Hóa - Nghệ Thuật3', 1)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (11, N'The thao', 1)
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[FeedBack] ON 

INSERT [dbo].[FeedBack] ([FeedBackId], [Star], [Description], [UserId], [BookId]) VALUES (2, 3, N'Sach Nhu Con Cac Nguoi TA', 2, 5)
INSERT [dbo].[FeedBack] ([FeedBackId], [Star], [Description], [UserId], [BookId]) VALUES (3, 1, N'Sach Nhu Con Cac Nguoi TA', 3, 6)
INSERT [dbo].[FeedBack] ([FeedBackId], [Star], [Description], [UserId], [BookId]) VALUES (4, 3, N'Sach Nhu Con Cac Nguoi TA', 4, 7)
INSERT [dbo].[FeedBack] ([FeedBackId], [Star], [Description], [UserId], [BookId]) VALUES (5, 5, N'Sach Nhu Con Cac Nguoi TA', 4, 5)
INSERT [dbo].[FeedBack] ([FeedBackId], [Star], [Description], [UserId], [BookId]) VALUES (6, 5, N'Sach Nhu Con Cac Nguoi TA', 4, 5)
INSERT [dbo].[FeedBack] ([FeedBackId], [Star], [Description], [UserId], [BookId]) VALUES (7, 5, N'Sach Nhu Con Cac Nguoi TA', 4, 5)
SET IDENTITY_INSERT [dbo].[FeedBack] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderDetail] ON 

INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (1, 8, 8, 1, 100000, 100000, 1)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (2, 4, 9, 1, 100000, 100000, 1)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (3, 8, 9, 3, 100000, 300000, 1)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (4, 8, 10, 5, 100000, 500000, 1)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (5, 4, 11, 1, 100000, 100000, 1)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (6, 5, 11, 3, 150000, 450000, 1)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (7, 4, 12, 9, 100000, 900000, 1)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (8, 9, 13, 4, 100000, 400000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (9, 16, 14, 2, 22, 44, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (10, 5, 15, 1, 150000, 150000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (11, 7, 15, 3, 100000, 300000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (12, 5, 16, 2, 150000, 300000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (13, 5, 17, 2, 150000, 300000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (14, 7, 17, 2, 100000, 200000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (15, 5, 18, 1, 150000, 150000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (16, 6, 18, 1, 100000, 100000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (17, 5, 19, 8, 150000, 1200000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (18, 5, 20, 24, 150000, 3600000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (19, 5, 21, 31, 150000, 4650000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (20, 5, 22, 30, 150000, 4500000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (22, 5, 23, 2, 150000, 300000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (23, 5, 24, 6, 150000, 900000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (24, 5, 25, 2, 150000, 300000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (25, 5, 26, 3, 150000, 450000, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (26, 5, 27, 0, 150000, 0, 0)
INSERT [dbo].[OrderDetail] ([OrderDetailId], [BookId], [OrderId], [Quantity], [UnitPrice], [TotalPrice], [Status]) VALUES (27, 5, 28, 19, 150000, 2850000, 0)
SET IDENTITY_INSERT [dbo].[OrderDetail] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (8, N'Con cu da', CAST(N'2024-04-17T00:00:00.000' AS DateTime), 0, 0, 100000, 0, 4, 4, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (9, N'Con Cac Nhua', CAST(N'2024-04-14T00:00:00.000' AS DateTime), 0, 0, 400000, 0, 4, 4, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (10, N'Cai Lon ', CAST(N'2024-04-20T00:00:00.000' AS DateTime), 0, 0, 500000, 0, 4, 4, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (11, N'Dell Pass', CAST(N'2024-04-22T00:00:00.000' AS DateTime), 0, 0, 550000, 0, 4, 4, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (12, N'Rot Mon', CAST(N'2024-04-25T00:00:00.000' AS DateTime), 0, 0, 900000, 0, 5, 4, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (13, N'', CAST(N'2024-04-22T00:00:00.000' AS DateTime), 50000, 0, 400000, 450000, 2, 4, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (14, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 44, 50044, 1, 4, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (15, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 450000, 500000, 5, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (16, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 300000, 350000, 2, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (17, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 500000, 550000, 3, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (18, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 250000, 300000, 4, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (19, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 1200000, 1250000, 5, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (20, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 3600000, 3650000, 2, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (21, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 4650000, 4700000, 3, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (22, NULL, CAST(N'2024-04-24T00:00:00.000' AS DateTime), 50000, 0, 4500000, 4550000, 4, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (23, NULL, CAST(N'2024-04-24T22:22:46.507' AS DateTime), 50000, 0, 300000, 350000, 5, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (24, NULL, CAST(N'2024-04-24T22:29:39.740' AS DateTime), 50000, 0, 900000, 950000, 2, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (25, N'', CAST(N'2024-04-25T02:41:09.157' AS DateTime), 50000, 0, 300000, 350000, 5, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (26, NULL, CAST(N'2024-04-25T10:16:53.233' AS DateTime), 50000, 0, 450000, 500000, 5, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (27, N'', CAST(N'2024-04-25T10:18:31.360' AS DateTime), 50000, 0, 0, 50000, 5, 5, 1)
INSERT [dbo].[Orders] ([OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub], [TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]) VALUES (28, NULL, CAST(N'2024-04-25T19:41:16.593' AS DateTime), 50000, 0, 2850000, 2900000, 5, 5, 1)
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Recipient] ON 

INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (1, N'abc', N'abc', 123, NULL, 1)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (4, N'30 Gò Cát', N'Phan Vũ', 12345678, 1, 4)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (8, N'33 Gò Cát', N'Cris Phan', 123123123, 1, 4)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (9, N'33 Gò Cát', N'Cris Phan', 123123123, 1, 6)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (10, N'111 điện biên phủ', N'vu', 845473789, 1, 6)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (11, N'113 điện biên phủ', N'vu', 845473789, 1, 4)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (12, N'114 điện biên phủ', N'vu', 845473789, 1, 4)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (13, N'114 điện biên phủ', N'vu', 845473789, 1, 5)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (14, N'33 Gò Cát', N'vu', 845463789, 1, 5)
INSERT [dbo].[Recipient] ([RecipientId], [DestAddress], [RecipientName], [PhoneNumber], [Status], [UserId]) VALUES (15, N'33 Gò Cát', N'vu', 845463789, 1, 5)
SET IDENTITY_INSERT [dbo].[Recipient] OFF
GO
INSERT [dbo].[Roles] ([RoleId], [RoleName], [Descriptions]) VALUES (1, N'admin', N'admin')
INSERT [dbo].[Roles] ([RoleId], [RoleName], [Descriptions]) VALUES (2, N'manager', N'manager')
INSERT [dbo].[Roles] ([RoleId], [RoleName], [Descriptions]) VALUES (3, N'staff', N'staff')
INSERT [dbo].[Roles] ([RoleId], [RoleName], [Descriptions]) VALUES (4, N'user', N'user')
GO
SET IDENTITY_INSERT [dbo].[SubCategory] ON 

INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (1, N'Âm nhạc', N'Tiểu thuyết', 1, 3)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (2, N'Hội họa', N'Trinh thám', 1, 2)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (3, N'Thi ca', N'Hoạt hình', 1, 2)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (4, N'Văn học Việt Nam', N'MapProjectsTeam', 1, 3)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (5, N'Văn học thế giới', N'MapProjectsTeam', 1, 3)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (6, N'Tâm lí', N'MapProjects', 1, 4)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (7, N'Nghệ thuật sống', N'MapProjectsTeam', 1, 4)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (10, N'Taam li', N'12312', 1, 4)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (11, N'Taam li', N'MapProjectsTeam', 2, 9)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (12, N'Taam li ccc ', N'MapProjectsTeam', 1, 3)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (13, N'Taam li ccc ', N'MapProjectsTeam', 1, 3)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (14, N'Taam li ccc ', N'MapProjectsTeam', 1, 3)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (15, N'Taam li', N'MapProjectsTeam', 1, 2)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (16, N'Văn Hóa 123', N'Văn Hóa 123', 1, 10)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (17, N'sach bong da', N'bong da', 1, 11)
SET IDENTITY_INSERT [dbo].[SubCategory] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID], [Status]) VALUES (1, N'admin@gmail.com', N'123', N'ADmin', 1, 1, 1)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID], [Status]) VALUES (2, N'staff@gmail.com', N'123', N'Staff', 1, 3, 1)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID], [Status]) VALUES (3, N'manager@gmail.com', N'123', N'manager', 1, 2, 1)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID], [Status]) VALUES (4, N'user1@gmail.com', N'123', N'vu', 1, 4, 1)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID], [Status]) VALUES (5, N'user@gmail.com', N'123', N'Trần Đức Bo', 0, 4, 1)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID], [Status]) VALUES (6, N'user2@gmail.com', N'123', N'asdasdasdd', 0, 4, 1)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[BookImages]  WITH CHECK ADD  CONSTRAINT [FK__BookImage__BookI__4AB81AF0] FOREIGN KEY([BookId])
REFERENCES [dbo].[Books] ([BookId])
GO
ALTER TABLE [dbo].[BookImages] CHECK CONSTRAINT [FK__BookImage__BookI__4AB81AF0]
GO
ALTER TABLE [dbo].[FeedBack]  WITH CHECK ADD  CONSTRAINT [FK__FeedBack__BookId__4D94879B] FOREIGN KEY([BookId])
REFERENCES [dbo].[Books] ([BookId])
GO
ALTER TABLE [dbo].[FeedBack] CHECK CONSTRAINT [FK__FeedBack__BookId__4D94879B]
GO
ALTER TABLE [dbo].[FeedBack]  WITH CHECK ADD  CONSTRAINT [FK__FeedBack__UserId__5070F446] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([UserId])
GO
ALTER TABLE [dbo].[FeedBack] CHECK CONSTRAINT [FK__FeedBack__UserId__5070F446]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK__OrdersDet__BookI__46E78A0C] FOREIGN KEY([BookId])
REFERENCES [dbo].[Books] ([BookId])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK__OrdersDet__BookI__46E78A0C]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK__OrdersDet__Order__5441852A] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([OrderId])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK__OrdersDet__Order__5441852A]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK__Orders__Recipien__5165187F] FOREIGN KEY([RecipientId])
REFERENCES [dbo].[Recipient] ([RecipientId])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK__Orders__Recipien__5165187F]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK__Orders__UserId__52593CB8] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([UserId])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK__Orders__UserId__52593CB8]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK__Payment__OrderId__5535A963] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([OrderId])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK__Payment__OrderId__5535A963]
GO
ALTER TABLE [dbo].[Recipient]  WITH CHECK ADD  CONSTRAINT [FK__Recipient__UserI__5629CD9C] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([UserId])
GO
ALTER TABLE [dbo].[Recipient] CHECK CONSTRAINT [FK__Recipient__UserI__5629CD9C]
GO
ALTER TABLE [dbo].[SubCategory]  WITH CHECK ADD  CONSTRAINT [FK_SubCategory_Category] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Category] ([ID])
GO
ALTER TABLE [dbo].[SubCategory] CHECK CONSTRAINT [FK_SubCategory_Category]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK__Users__RoleID__571DF1D5] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Roles] ([RoleId])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK__Users__RoleID__571DF1D5]
GO
USE [master]
GO
ALTER DATABASE [BookStore] SET  READ_WRITE 
GO
