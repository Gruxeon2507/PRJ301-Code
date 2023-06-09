USE [SE1722_Stupid]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 2/20/2023 12:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[did] [int] NOT NULL,
	[dname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[did] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 2/20/2023 12:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[sid] [int] IDENTITY(1,1) NOT NULL,
	[sname] [varchar](150) NOT NULL,
	[gender] [bit] NOT NULL,
	[dob] [date] NOT NULL,
	[did] [int] NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[sid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 2/20/2023 12:05:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[displayname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Department] ([did], [dname]) VALUES (1, N'Information Technology')
INSERT [dbo].[Department] ([did], [dname]) VALUES (2, N'Economic')
INSERT [dbo].[Department] ([did], [dname]) VALUES (3, N'Graphical Design')
GO
SET IDENTITY_INSERT [dbo].[Student] ON 

INSERT [dbo].[Student] ([sid], [sname], [gender], [dob], [did]) VALUES (1, N'Lai Khanh Trang', 0, CAST(N'2003-03-14' AS Date), 1)
INSERT [dbo].[Student] ([sid], [sname], [gender], [dob], [did]) VALUES (2, N'Ngoc Mai', 0, CAST(N'2003-02-02' AS Date), 1)
INSERT [dbo].[Student] ([sid], [sname], [gender], [dob], [did]) VALUES (3, N'Le Thuy Linh', 0, CAST(N'2003-06-10' AS Date), 2)
INSERT [dbo].[Student] ([sid], [sname], [gender], [dob], [did]) VALUES (4, N'Ngo Tung Son', 1, CAST(N'1997-11-13' AS Date), 3)
SET IDENTITY_INSERT [dbo].[Student] OFF
GO
INSERT [dbo].[User] ([username], [password], [displayname]) VALUES (N'linh', N'linh', N'Linh cute ')
INSERT [dbo].[User] ([username], [password], [displayname]) VALUES (N'mai', N'mai', N'Ba met be doi')
INSERT [dbo].[User] ([username], [password], [displayname]) VALUES (N'mra', N'mra', N'Mr A')
INSERT [dbo].[User] ([username], [password], [displayname]) VALUES (N'mrb', N'mrb', N'Mr B')
INSERT [dbo].[User] ([username], [password], [displayname]) VALUES (N'sonnt', N'sonnt', N'Superman hehehe')
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [FK_Student_Department] FOREIGN KEY([did])
REFERENCES [dbo].[Department] ([did])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Department]
GO
