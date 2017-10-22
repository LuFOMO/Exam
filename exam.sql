/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.16-log : Database - exam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`exam` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `exam`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL COMMENT '管理员姓名',
  `PASSWORD` varchar(20) NOT NULL COMMENT '密码',
  `fullname` varchar(32) DEFAULT NULL COMMENT '全名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_admin` */

insert  into `tb_admin`(`id`,`NAME`,`PASSWORD`,`fullname`) values (1,'admin','12345678','张三'),(2,'jerry','12341234','杰瑞');

/*Table structure for table `tb_exam` */

DROP TABLE IF EXISTS `tb_exam`;

CREATE TABLE `tb_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(12) DEFAULT NULL COMMENT '考试名称',
  `student_num` int(11) DEFAULT NULL COMMENT '学生人数',
  `teachname` varchar(12) DEFAULT NULL COMMENT '监考教师',
  `starttime` date DEFAULT NULL COMMENT '开始时间',
  `autostart` varchar(3) DEFAULT NULL COMMENT '是否自动开始',
  `started` varchar(3) DEFAULT NULL COMMENT '是否开始',
  `finished` varchar(3) DEFAULT NULL COMMENT '是否结束',
  `archived` varchar(3) DEFAULT NULL COMMENT '是否存档',
  `cleaned` varchar(3) DEFAULT NULL COMMENT '考试是否清理',
  `exampaper` varchar(20) DEFAULT NULL COMMENT '试卷名称',
  `paper_url` varchar(300) DEFAULT NULL COMMENT '试卷绝对路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_exam` */

/*Table structure for table `tb_exam_config` */

DROP TABLE IF EXISTS `tb_exam_config`;

CREATE TABLE `tb_exam_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tasktime` int(11) NOT NULL COMMENT '后台任务周期',
  `pagesize` int(11) NOT NULL COMMENT '分页查询每页数量',
  `timesize` int(11) NOT NULL COMMENT '开启考试阈值',
  `filesize` int(11) NOT NULL COMMENT '上传文件大小',
  `is_clean` varchar(3) NOT NULL COMMENT '是否允许清理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_exam_config` */

insert  into `tb_exam_config`(`id`,`tasktime`,`pagesize`,`timesize`,`filesize`,`is_clean`) values (1,30,30,15,1024,'是');

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(12) NOT NULL COMMENT '学号',
  `NAME` varchar(20) NOT NULL COMMENT '学生姓名',
  `clazz` varchar(12) NOT NULL COMMENT '班级',
  `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
  `is_login` varchar(3) DEFAULT NULL COMMENT '是否登录',
  `ipbinding` varchar(3) DEFAULT NULL COMMENT 'ip是否绑定',
  `is_submit` varchar(3) DEFAULT NULL COMMENT '是否交卷',
  `submittime` datetime DEFAULT NULL COMMENT '交卷时间',
  `submit_url` varchar(300) DEFAULT NULL COMMENT '交卷绝对路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student` */

insert  into `tb_student`(`id`,`sid`,`NAME`,`clazz`,`ip`,`is_login`,`ipbinding`,`is_submit`,`submittime`,`submit_url`) values (1,'1427151077','于航','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(2,'1427151088','吴文祥','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(3,'1510111249','周博文','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(4,'1510120003','马新强','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(5,'1510120005','李文志','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(6,'1510120006','詹旭旭','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(7,'1510120013','苏琳垠','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(8,'1510120020','张贵凯','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(9,'1510120026','肖斌','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(10,'1510120038','杨雄','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(11,'1510120044','刘庆昌','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(12,'1510120055','赵俊博','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(13,'1510120056','龚富成','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(14,'1510120060','代朝恒','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(15,'1510121004','王世超','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(16,'1510121010','乔聪','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(17,'1510121011','余海龙','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(18,'1510121012','王一','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(19,'1510121015','陈鹏','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(20,'1510121016','杨雅楠','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(21,'1510121018','冯震','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(22,'1510121023','何宏达','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(23,'1510121024','徐沛东','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(24,'1510121025','杨皓强','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(25,'1510121026','黄科强','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(26,'1510121027','崔海燕','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(27,'1510121028','党莹辉','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(28,'1510121030','高逸博','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(29,'1510121032','孙茂林','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(30,'1510121033','李锴','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(31,'1510121034','赵世恒','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(32,'1510121035','随亦粮','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(33,'1510121037','徐新伟','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(34,'1510121039','胡慧坤','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(35,'1510121040','崔英杰','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(36,'1510121042','郝梦瑶','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(37,'1510121053','王祥阳','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(38,'1510121054','董浣婷','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(39,'1510121055','田聪','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(40,'1510121056','高亚飞','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(41,'1510121057','张洪源','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(42,'1510121059','李新宇','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(43,'1510121060','韦宁','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(44,'1510121061','张强','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(45,'1510121067','程宁','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(46,'1510121082','李玉龙','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(47,'1510121086','李豪','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(48,'1510121089','孙彩芹','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(49,'1510121090','段高华','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(50,'1510121092','张伟','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(51,'1510121093','吴志鹏','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(52,'1510121098','高征辉','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(53,'1510121099','董知博','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(54,'1510121102','张文斌','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(55,'1510121111','冯朝阳','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(56,'1510121122','张成成','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(57,'1510121126','闫昌泽','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(58,'1510121127','周楠','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(59,'1510121128','刘志文','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(60,'1510121130','张远','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(61,'1510121132','张明','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(62,'1510121133','朱芬芬','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(63,'1510121137','徐宁','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(64,'1510121138','陈林','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(65,'1510121146','郭朴宸','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(66,'1510121149','张洪港','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(67,'1510121150','姜上君','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(68,'1510121152','马秋红','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(69,'1510121153','张悦','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(70,'1510121154','葛建伟','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(71,'1510121155','王慧芳','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(72,'1510121156','孙乔','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(73,'1510121163','夏雷雨','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(74,'1510121165','赵凤林','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(75,'1510121166','张亚康','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(76,'1510121167','赵俊福','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(77,'1510121178','闫世昌','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(78,'1510121182','任文杰','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(79,'1510121261','刘哲豪','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(80,'1510121277','隋越','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(81,'1510121278','李尚迪','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(82,'1510121280','李润雨','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(83,'1510121281','徐杰','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(84,'1510121283','马靖源','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(85,'1510121291','崔靖宇','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(86,'1510121294','魏鹏','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(87,'1510121295','贺伟','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(88,'1510131153','路炳为','15-3',NULL,NULL,NULL,NULL,NULL,NULL),(89,'1510200023','张铭豪','15-3',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tb_teacher` */

DROP TABLE IF EXISTS `tb_teacher`;

CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL COMMENT '教师姓名',
  `PASSWORD` varchar(20) NOT NULL COMMENT '密码',
  `fullname` varchar(32) DEFAULT NULL COMMENT '全名',
  `is_admin` varchar(3) DEFAULT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_teacher` */

insert  into `tb_teacher`(`id`,`NAME`,`PASSWORD`,`fullname`,`is_admin`) values (1,'jerry','12341234','杰瑞','是'),(2,'tom','11111111','汤姆','否'),(3,'rose','33333333','如丝','否'),(4,'potty','55555555','波特','否');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;