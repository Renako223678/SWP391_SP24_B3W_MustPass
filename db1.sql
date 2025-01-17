USE [master]
GO
/****** Object:  Database [BookStore]    Script Date: 21/04/2024 1:06:55 SA ******/
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
/****** Object:  Table [dbo].[Banner]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Banner](
	[BannerId] [int] IDENTITY(1,1) NOT NULL,
	[BannerName] [varchar](50) NULL,
	[Url] [varchar](50) NULL,
	[Content] [varchar](50) NULL,
	[StartDate] [date] NULL,
	[EndDate] [date] NULL,
	[UserId] [int] NULL,
 CONSTRAINT [PK__Banner__32E86AD15C6E7489] PRIMARY KEY CLUSTERED 
(
	[BannerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BookImages]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookImages](
	[ImageId] [int] IDENTITY(1,1) NOT NULL,
	[Url] [varchar](50) NULL,
	[Status] [int] NULL,
	[BookId] [int] NULL,
 CONSTRAINT [PK__BookImag__7516F70CA7C86FE1] PRIMARY KEY CLUSTERED 
(
	[ImageId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Books]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books](
	[BookId] [int] IDENTITY(1,1) NOT NULL,
	[BookName] [nvarchar](50) NULL,
	[Description] [nvarchar](50) NULL,
	[AuthorName] [nvarchar](50) NULL,
	[PublishingCompany] [nvarchar](50) NULL,
	[IssusingCompany] [nvarchar](50) NULL,
	[TranslatorName] [nvarchar](50) NULL,
	[PublishDate] [date] NULL,
	[Quantity] [int] NULL,
	[SubCategoryId] [int] NULL,
	[UnitPrice] [float] NULL,
	[CategoryID] [int] NULL,
	[Status] [int] NULL,
	[TotalFeedback] [int] NULL,
 CONSTRAINT [PK__Books__3DE0C2078BDCD8AC] PRIMARY KEY CLUSTERED 
(
	[BookId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 21/04/2024 1:06:55 SA ******/
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
/****** Object:  Table [dbo].[FeedBack]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeedBack](
	[FeedBackId] [bigint] NOT NULL,
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
/****** Object:  Table [dbo].[Orders]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderId] [bigint] NOT NULL,
	[Description] [text] NULL,
	[OrderDate] [date] NULL,
	[ShipFee] [decimal](18, 0) NULL,
	[UsedLotusBub] [int] NULL,
	[TotalPrice] [decimal](18, 0) NULL,
	[FinalPrice] [decimal](18, 0) NULL,
	[Status] [tinyint] NULL,
	[UserId] [int] NULL,
	[RecipientId] [bigint] NULL,
 CONSTRAINT [PK__Orders__C3905BCFB1567F5A] PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrdersDetail]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrdersDetail](
	[Quantity] [int] NULL,
	[UnitPrice] [decimal](18, 0) NULL,
	[TotalPrice] [decimal](18, 0) NULL,
	[Status] [tinyint] NULL,
	[BookId] [int] NOT NULL,
	[OrderId] [bigint] NOT NULL,
 CONSTRAINT [PK__OrdersDe__D1D9C7BBFE94AF37] PRIMARY KEY CLUSTERED 
(
	[BookId] ASC,
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 21/04/2024 1:06:55 SA ******/
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
	[OrderId] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[PaymentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recipient]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recipient](
	[RecipientId] [bigint] NOT NULL,
	[Dest_address] [text] NULL,
	[RecipientName] [varchar](30) NULL,
	[PhoneNumber] [int] NULL,
	[UserId] [int] NULL,
 CONSTRAINT [PK__Recipien__F0A6024DC37490A8] PRIMARY KEY CLUSTERED 
(
	[RecipientId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[RoleId] [bigint] NOT NULL,
	[RoleName] [varchar](50) NULL,
	[Descriptions] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SubCategory]    Script Date: 21/04/2024 1:06:55 SA ******/
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
/****** Object:  Table [dbo].[Users]    Script Date: 21/04/2024 1:06:55 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](100) NULL,
	[Password] [varchar](100) NULL,
	[Fullname] [varchar](100) NULL,
	[Number_of_Lotus] [int] NULL,
	[RoleID] [bigint] NULL,
 CONSTRAINT [PK__Users__1788CC4C57DFB817] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Books] ON 

INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishDate], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (4, N'Sách Việt Nam', N'Sách Việt Nam', N'Nam Cao', N'Công ti FAHASA', N'FaHASA', N'Nguyễn Công', CAST(N'2020-10-10' AS Date), 10, 1, 100000, 2, 1, 10)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishDate], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (5, N'Sách Trung Quốc', N'Sách Trung Quốc', N'Lão Hạc', N'Công ti FAHHA', N'Công ti FAHHA', N'Lão hạc', CAST(N'2020-10-10' AS Date), 1, 1, 150000, 3, 1, 1)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishDate], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (6, N'Sách Nhật', N'Sách Nhật', N'Chị Dậu', N'Công ti FAHHA', N'Công ti FAHHA', N'Lão hạc', NULL, NULL, 1, NULL, 2, NULL, NULL)
INSERT [dbo].[Books] ([BookId], [BookName], [Description], [AuthorName], [PublishingCompany], [IssusingCompany], [TranslatorName], [PublishDate], [Quantity], [SubCategoryId], [UnitPrice], [CategoryID], [Status], [TotalFeedback]) VALUES (7, N'Sách Hàn', N'Sách Hàn', N'Chị Dậu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Books] OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (2, N'Sách Việt Nam', 1)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (3, N'Sách Nhật Bản', 1)
INSERT [dbo].[Category] ([ID], [CategoryName], [Status]) VALUES (4, N'Sách Hàn Quốc', 1)
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
INSERT [dbo].[Roles] ([RoleId], [RoleName], [Descriptions]) VALUES (1, N'admin', N'admin')
INSERT [dbo].[Roles] ([RoleId], [RoleName], [Descriptions]) VALUES (2, N'staff', N'staff')
INSERT [dbo].[Roles] ([RoleId], [RoleName], [Descriptions]) VALUES (3, N'user', N'user')
GO
SET IDENTITY_INSERT [dbo].[SubCategory] ON 

INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (1, N'Tiểu thuyết', N'Tiểu thuyết', 1, NULL)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (2, N'Trinh thám', N'Trinh thám', 1, NULL)
INSERT [dbo].[SubCategory] ([ID], [SubName], [Description], [Status], [CategoryId]) VALUES (3, N'Hoạt hình', N'Hoạt hình', 1, NULL)
SET IDENTITY_INSERT [dbo].[SubCategory] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (1, N'admin@gmail.com', N'123', N'ADmin', 1, 1)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (2, N'staff@gmail.com', N'123', N'Staff', 1, 2)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (3, N'thuan@gmail.com', N'123', N'Thuan', 1, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (4, N'quang@gmail.com', N'123', N'quang', 1, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (5, N'quangtran2002qn@gmail.com', N'1234567890cc', N'aaa', 0, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (6, N'qu', N'1234567890cc', N'aaa', 0, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (7, N'quang@gmail.com', N'1234567890cc', N'aaa', 0, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (8, N'quang@gmail.com', N'1234567890cc', N'abc', 0, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (9, N'quanggg@gmail.com', N'123456', N'abv', 0, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (10, N'quang@gmail.com', N'123456', N'abbb', 0, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (11, N'quang123@gmail.com', N'1234567890cc', N'abb', 0, 3)
INSERT [dbo].[Users] ([UserId], [Email], [Password], [Fullname], [Number_of_Lotus], [RoleID]) VALUES (15, N'1234567890cc', N'quang1234@gmail.com', N'', 0, 3)
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Banner]  WITH CHECK ADD  CONSTRAINT [FK__Banner__UserId__4BAC3F29] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([UserId])
GO
ALTER TABLE [dbo].[Banner] CHECK CONSTRAINT [FK__Banner__UserId__4BAC3F29]
GO
ALTER TABLE [dbo].[BookImages]  WITH CHECK ADD  CONSTRAINT [FK__BookImage__BookI__4AB81AF0] FOREIGN KEY([BookId])
REFERENCES [dbo].[Books] ([BookId])
GO
ALTER TABLE [dbo].[BookImages] CHECK CONSTRAINT [FK__BookImage__BookI__4AB81AF0]
GO
ALTER TABLE [dbo].[Books]  WITH CHECK ADD  CONSTRAINT [FK_Books_Catogory] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Category] ([ID])
GO
ALTER TABLE [dbo].[Books] CHECK CONSTRAINT [FK_Books_Catogory]
GO
ALTER TABLE [dbo].[Books]  WITH CHECK ADD  CONSTRAINT [FK_Books_SubCategory] FOREIGN KEY([SubCategoryId])
REFERENCES [dbo].[SubCategory] ([ID])
GO
ALTER TABLE [dbo].[Books] CHECK CONSTRAINT [FK_Books_SubCategory]
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
ALTER TABLE [dbo].[OrdersDetail]  WITH CHECK ADD  CONSTRAINT [FK__OrdersDet__BookI__46E78A0C] FOREIGN KEY([BookId])
REFERENCES [dbo].[Books] ([BookId])
GO
ALTER TABLE [dbo].[OrdersDetail] CHECK CONSTRAINT [FK__OrdersDet__BookI__46E78A0C]
GO
ALTER TABLE [dbo].[OrdersDetail]  WITH CHECK ADD  CONSTRAINT [FK__OrdersDet__Order__5441852A] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([OrderId])
GO
ALTER TABLE [dbo].[OrdersDetail] CHECK CONSTRAINT [FK__OrdersDet__Order__5441852A]
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
