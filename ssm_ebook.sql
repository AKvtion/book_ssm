/*
SQLyog Enterprise v13.1.1 (64 bit)
MySQL - 5.7.38-log : Database - ssm_ebook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm_ebook` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `ssm_ebook`;

/*Table structure for table `avatar` */

DROP TABLE IF EXISTS `avatar`;

CREATE TABLE `avatar` (
  `id` smallint(6) NOT NULL,
  `avatar_txt` varchar(20) DEFAULT NULL,
  `avatar_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `avatar` */

insert  into `avatar`(`id`,`avatar_txt`,`avatar_img`) values 
(1,'040601','resources/images/avatars/040601.jpg'),
(2,'040602','resources/images/avatars/040602.jpg'),
(3,'040603','resources/images/avatars/040603.jpg'),
(4,'040604','resources/images/avatars/040604.jpg'),
(5,'040605','resources/images/avatars/040605.jpg'),
(6,'040606','resources/images/avatars/040606.jpg'),
(7,'040607','resources/images/avatars/040607.jpg'),
(8,'040608','resources/images/avatars/040608.jpg'),
(9,'040609','resources/images/avatars/040609.jpg'),
(10,'040610','resources/images/avatars/040610.jpg');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `book_title` varchar(50) NOT NULL,
  `book_author` varchar(30) NOT NULL,
  `book_summary` text,
  `type_id` int(11) DEFAULT NULL,
  `download_times` int(11) DEFAULT NULL,
  `book_pubYear` date DEFAULT NULL,
  `book_file` varchar(100) DEFAULT NULL,
  `book_cover` varchar(100) DEFAULT NULL,
  `book_format` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`book_title`,`book_author`,`book_summary`,`type_id`,`download_times`,`book_pubYear`,`book_file`,`book_cover`,`book_format`) values 
(12010601180407991,'三国演义','罗贯中','这是一本三国演义。。。',12,2,'2001-06-01','G:/JavaWeb/project/JavaEEBeKeYe/book/doc/ebooks/经典文学/古典文学/三国演义.txt','G:/JavaWeb/project/JavaEEBeKeYe/book/doc/bookCovers/经典文学/古典文学/三国演义.jpg','txt'),
(12230501230619379,'古诗三百首','李白','古诗',12,0,'2023-05-01','G:/JavaWeb/project/JavaEEBeKeYe/book/doc/ebooks/经典文学/古典文学/古诗三百首.pdf','G:/JavaWeb/project/JavaEEBeKeYe/book/doc/bookCovers/经典文学/古典文学/古诗三百首.jpg','pdf'),
(12950801180403252,'资治通鉴','司马光','这是一本资治通鉴',12,4,'1995-08-01','G:/JavaWeb/project/JavaEEBeKeYe/book/doc/ebooks/经典文学/古典文学/资治通鉴.txt','G:/JavaWeb/project/JavaEEBeKeYe/book/doc/bookCovers/经典文学/古典文学/资治通鉴.jpg','txt'),
(31230601230619386,'C++','李四','新手教程',31,1,'2023-06-01','G:/JavaWeb/project/JavaEEBeKeYe/book/doc/ebooks/计算机类/编程语言/C++.pdf','G:/JavaWeb/project/JavaEEBeKeYe/book/doc/bookCovers/计算机类/编程语言/C.jpg','pdf');

/*Table structure for table `book_type` */

DROP TABLE IF EXISTS `book_type`;

CREATE TABLE `book_type` (
  `id` int(11) NOT NULL,
  `book_large_type` int(11) NOT NULL,
  `book_small_type` int(11) NOT NULL,
  `large_type_name` varchar(20) NOT NULL,
  `small_type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_type` */

insert  into `book_type`(`id`,`book_large_type`,`book_small_type`,`large_type_name`,`small_type_name`) values 
(11,1,1,'经典文学','现代文学'),
(12,1,2,'经典文学','古典文学'),
(13,1,3,'经典文学','国外文学'),
(14,1,4,'经典文学','纪实文学'),
(15,1,5,'经典文学','诗词歌赋'),
(21,2,1,'通俗小说','武侠玄幻'),
(22,2,2,'通俗小说','青春言情'),
(23,2,3,'通俗小说','悬疑推理'),
(24,2,4,'通俗小说','历史军事'),
(25,2,5,'通俗小说','职场生活'),
(31,3,1,'计算机类','编程语言'),
(32,3,2,'计算机类','数据库'),
(33,3,3,'计算机类','人工智能'),
(34,3,4,'计算机类','移动开发'),
(35,3,5,'计算机类','图形图像'),
(41,4,1,'杂志期刊','科学技术'),
(42,4,2,'杂志期刊','人文艺术'),
(43,4,3,'杂志期刊','政治军事'),
(44,4,4,'杂志期刊','经济管理'),
(45,4,5,'杂志期刊','娱乐休闲');

/*Table structure for table `contribution` */

DROP TABLE IF EXISTS `contribution`;

CREATE TABLE `contribution` (
  `id` smallint(6) NOT NULL,
  `level_txt` varchar(10) DEFAULT NULL,
  `lowerLimit` int(11) DEFAULT NULL,
  `upperLimit` int(11) DEFAULT NULL,
  `level_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contribution` */

insert  into `contribution`(`id`,`level_txt`,`lowerLimit`,`upperLimit`,`level_img`) values 
(1,'普通会员',0,20,'/resources/images/level/level1.jpg'),
(2,'白银会员',21,50,'/resources/images/level/level2.jpg'),
(3,'黄金会员',51,100,'/resources/images/level/level3.jpg'),
(4,'铂金会员',101,200,'/resources/images/level/level4.jpg'),
(5,'钻石会员',201,999999,'/resources/images/level/level5.jpg');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginedUser` bigint(20) DEFAULT NULL,
  `contact` varchar(30) DEFAULT NULL,
  `suggestion` varchar(500) DEFAULT NULL,
  `status` int(2) NOT NULL,
  `postTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

insert  into `feedback`(`id`,`loginedUser`,`contact`,`suggestion`,`status`,`postTime`) values 
(1,1,'782996468','正在测试中。。。',1,'2023-04-07 19:03:40');

/*Table structure for table `upload` */

DROP TABLE IF EXISTS `upload`;

CREATE TABLE `upload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uploader` bigint(20) NOT NULL,
  `uploadedBook` bigint(11) NOT NULL,
  `uploadedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `upload` */

insert  into `upload`(`id`,`uploader`,`uploadedBook`,`uploadedDate`) values 
(1,1,12950801180403252,'2023-04-03'),
(2,1,12010601180407991,'2023-04-07'),
(3,3,31230601230619386,'2023-06-19'),
(4,3,12230501230619379,'2023-06-19');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userCode` varchar(20) NOT NULL,
  `userPassword` varchar(20) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `avatarNum` smallint(11) DEFAULT NULL,
  `contribution` int(11) DEFAULT NULL,
  `creationDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userCode`,`userPassword`,`userName`,`email`,`avatarNum`,`contribution`,`creationDate`) values 
(1,'admin','abc123','管理员','',8,6,'2023-04-03'),
(3,'root123','root123','root123','',2,4,'2023-06-18');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
