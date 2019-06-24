/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : sshtutorial

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-06-23 22:06:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `father_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '0', '综合', '0');
INSERT INTO `t_category` VALUES ('2', '0', '理科', '0');
INSERT INTO `t_category` VALUES ('3', '2', '国际', '0');
INSERT INTO `t_category` VALUES ('4', '0', '文科', '0');
INSERT INTO `t_category` VALUES ('5', '0', '工科', '0');
INSERT INTO `t_category` VALUES ('6', '0', '艺术', '0');
INSERT INTO `t_category` VALUES ('7', '0', '其他', '0');
INSERT INTO `t_category` VALUES ('8', '1', '国际', '0');
INSERT INTO `t_category` VALUES ('9', '1', '国家', '1');
INSERT INTO `t_category` VALUES ('10', '1', '省', '1');
INSERT INTO `t_category` VALUES ('11', '2', '国家', '0');
INSERT INTO `t_category` VALUES ('12', '2', '省', '1');
INSERT INTO `t_category` VALUES ('13', '4', '国际', '0');
INSERT INTO `t_category` VALUES ('14', '4', '国家', '0');
INSERT INTO `t_category` VALUES ('15', '4', '省', '0');
INSERT INTO `t_category` VALUES ('16', '5', '国际', '0');
INSERT INTO `t_category` VALUES ('17', '5', '国家', '0');
INSERT INTO `t_category` VALUES ('18', '5', '省', '0');
INSERT INTO `t_category` VALUES ('19', '6', '国际', '0');
INSERT INTO `t_category` VALUES ('20', '6', '国家', '0');
INSERT INTO `t_category` VALUES ('21', '6', '省', '0');

-- ----------------------------
-- Table structure for t_competition
-- ----------------------------
DROP TABLE IF EXISTS `t_competition`;
CREATE TABLE `t_competition` (
  `competition_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `competition_createTime` datetime DEFAULT NULL,
  `competition_title` varchar(255) DEFAULT NULL,
  `competition_status` int(11) DEFAULT NULL,
  `competition_updateTime` datetime DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`competition_id`),
  KEY `FK_rqjhrsdn6cdrnxm4qe0q4d8pt` (`category_id`),
  CONSTRAINT `FK_rqjhrsdn6cdrnxm4qe0q4d8pt` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_competition
-- ----------------------------
INSERT INTO `t_competition` VALUES ('1', '报名费用：每支队伍$100\r\n官方网站：http://www.comap.com/undergraduate/contests/steps/index.html\r\n2019年美国大学生数学建模竞赛辅助报名请点击：http://www.52jingsai.com/meisai/\r\n比赛时间：\r\n 美国东部时间：2019年1月24日下午5点-1月28日下午8点（共4天）\r\n北京时间：2019年1月25日（星期五 ）上午6点-1月29日（星期二 ）上午9点\r\n农历：十二月二十 ～ 十二月廿四\r\n2019年赛事最新变化：\r\nMCM/ICM将完全使用电子提交！\r\n参赛队伍不再需要邮寄论文纸质版给主办机构；\r\n参赛队伍不再需要邮寄签名的Control Sheet纸质版给主办机构。 \r\n今年赛事比2016年增加3个小时参赛时间，提前三个小时公布题目。\r\n 2019年赛事相关时间节点（以下时间均为美国东部时间EST，北京时间比美国东部时间早13个小时）：\r\n报名截止时间：2019年1月24日下午3点EST\r\n比赛开始时间：2019年1月24日下午5点EST\r\n比赛结束时间：2019年1月28日下午8点EST\r\nCOMAP收到论文电子版截止时间（接收邮箱：solutions@comap.com）：2019年1月28日下午9点EST\r\nCOMAP收到带签名Control Sheet电子版截止时间（接收邮箱：forms@comap.com，注意两接收邮箱是不同的！）：2019年2月8日下午5点EST\r\n成绩公布时间：2019年4月29日EST\r\n重要说明：\r\nCOMAP是所有的规则和政策的最后仲裁者，对不遵循竞赛规则和程序的任何队伍，拥有唯一的自由裁量权，取消参赛资格或拒绝注册。\r\n评委、竞赛组织者、以及UMAP杂志的编辑拥有最终裁定权。\r\n如果参赛队伍违反竞赛规则，其指导老师一年内将不能指导其他团队，其所在参赛单位将被处以一年的察看处理。\r\n如果同一机构第二次违反竞赛规则，该学校将至少不被允许参加下一年度的赛事。\r\n以下所有时间都是美国东部时间EST（北京时间比美国东部时间早13个小时）\r\n递交参赛论文后，意味参赛者同意以下条款： \r\n论文提交后，出版权归COMAP, Inc所有；\r\nCOMAP可以使用，编辑，引用和出版论文，用于宣传或任何其他目的，包括在线展示，出版电子刊物，在UMAP杂志刊登或其他方式，并且没有任何形式的补偿；\r\nCOMAP可以在没有进一步的通知，许可，或补偿的情形下，使用这次比赛相关材料，团队成员、指导老师的名字，以及和他们的背景资料。\r\n递交参赛论文后，意味参赛者作出以下承诺： \r\n论文中出现的所有的图像，数据，照片，图表，图画，如果未注明，都是由参赛者创建；如果引用其它资源，都在参考文献中列出，并在引用的具体位置标注来源。\r\n不论是直接，还是转述方式的文字引用，都在参考文献中列出，并在引用的具体位置标注来源；直接的文字引用使用引号标注。\r\n比赛之前\r\n A．注册报名\r\n报名截止时间：2019年1月24日下午3：00 EST。截止日期后，注册系统将自动关闭，不再接受任何新的注册，没有例外。\r\n参赛对象：对所有在校本科生和高中生开放。\r\n团队成员：一个团队可以由同一所学校的最多三名学生组成。\r\n指导老师： 每支参赛队伍都必须由一位来自参赛机构（institute）的教师担任导师（faculty advisor），不允许学生担任导师。由指导老师负责为其指导队伍注册报名，每位指导老师可注册的队伍数目没有限制。\r\n注册网址：http://www.comap.com/undergraduate/contests/mcm/\r\n B．报名费用\r\n每支队伍$100。\r\n报名费用将在网上报名期间被扣除，缴费方式为Mastercard 或 VISA card。提交缴费后，组委会将在数秒内收到费用，为参赛队伍分配一个control number。在收到control number之前，您的团队没有正式注册。正式注册后打印显示control number的网页，这将是参赛队唯一的注册证明，因为你将不会收到Email形式的注册认证。本页同时包含该队导师注册时使用的邮箱和密码，是整个比赛手续的必须信息。中山大学统一报名的队伍，报名后会收到数模组发送的PDF文件，该文件就是注册页面，请注意保存。\r\n报名后，导师仍然可以登入系统，在比赛前可以修改参赛人员、报名地址、联系方式等信息。\r\n注册后请经常登入系统，查看信息更新，非特殊情形下，组委会将不会以Email形式通知各种信息。\r\n C．参赛人员\r\n比赛开始前，每支队伍的参赛人员都可以更改；比赛开始后，参赛人员将不能修改或添加，但是可以删除（如果有人退出比赛）。\r\n每支队伍最多3个人。\r\n每位学生只能参加一支队伍。\r\n参赛学生必须是在读学生。\r\n参赛学生必须和其指导老师属于同一学校（不允许跨校组队，没有例外）。\r\n不允许研究生报名参赛。\r\n2019年美国大学生数学建模竞赛辅助报名请点击：http://www.52jingsai.com/meisai/\r\n比赛开始后\r\n A．赛题公示\r\n比赛将于美国东部时间2019年1月24日晚上5点准时开始。\r\n赛题将在美国东部时间2019年1月24日晚上5点准时在官方网站公布：https://www.comap.com/undergraduate/contests/mcm。\r\n赛题也将在2019年1月24日晚上4:50 EST准时在下述镜像网站公布：\r\nhttp://www.comap-math.com/mcm/index.html\r\nhttp://www.mathismore.net/mcm/index.html\r\nhttp://www.mathportals.com/mcm/index.html\r\nhttp://www.immchallenge.org/mcm/index.html\r\nB．选择赛题\r\n任何一个队伍都可以在六个赛题中选择一题且只能选择一题作答，选择A、B或C题意味参加MCM竞赛，选择D、E或F题意味参加ICM竞赛。\r\n C．论文准备\r\n参赛队可以使用计算机、软件、文献、网站、书籍等无生命的数据和材料资源来帮助完成赛题。所有的引用资源必须标明出处，否则参赛队将被取消比赛资格。\r\n参赛队禁止和导师以及队伍之外的成员以邮件、电话、对话、网上交流、网络问答平台以及其他任何方式交流。\r\n不完整的论文，或者没有完全解答的论文也可以提交，评审组的鉴定完全根据论文使用的方法和手段，评审结果不是分数，而是级别。\r\n摘要（summary）是MCM/ICM论文的重要组成部分。评委对摘要给予相当的重视，优秀的论文通常因为出色的摘要脱颖而出。一份简明而精彩的摘要应当能吸引读者仔细阅读你的工作，所以应该明确指出使用的方法，最重要的是，明确指出论文的主要结论，简单的问题重述或者对论文的剪切粘贴是软弱无力的。\r\n除了作为汇总描述的Summary sheet，每篇论文还应包含以下内容： \r\n问题重述及澄清（Restatement and clarification of the problem），用自己的话说出你要做什么。\r\n问题假设和变量说明（Explain assumptions and rationale/justification）：对问题需要的假设进行说明，基本原理说明，并对模型中的变量进行说明。\r\n模型设计和模型说明（Include your model design and justification）：模型的使用和模型的改进。\r\n模型的检验和灵敏度分析（Describe model testing and sensitivity analysis）：以及误差分析（error analysis）等等。\r\n讨论模型的优缺点（Discuss the strengths and weaknesses）：讨论模型以及使用方法的优缺点。\r\n评审团将依据以下事项评定写作质量： \r\n文字简洁和语言组织（Conciseness and organization）极其重要；\r\n关键陈述需要展示核心观点和结果（key views and results）；\r\n一个好的问题重述（a clarification or restatement，as appropriate）；\r\n清晰的假设和变量说明（a clear assumption and variable declaration）；\r\n对问题的分析（analysis of the problem），包括使用模型的动机以及理由（motivation or justification for the model）；\r\n模型的设计（a design of model）；\r\n模型的检验（test of model），包括误差分析和稳定性分析（条件敏感度）等等；\r\n对模型的明显的优缺点的说明讨论（strengths and weaknesses）。\r\n论文写作须用英文，使用易读字体，正文主体字号不小于12号。\r\n解决方案只允许通过论文方式递交，必须包括文字，必要的图形，图表，或其他书面材料。不允许使用任何非书面材料比如计算机文件或者软件。\r\n论文的每一页页眉必须有control number和Page number，形式为：\r\nTeam # 321                        Page 6 of 13\r\n论文电子版中不能出现学生、导师、单位等任何认证信息。\r\n任何不满足上述规范的论文将作废处理。\r\n D．下载summary sheet和打印control sheet\r\n比赛开始后，参赛队将全力准备赛题；导师将登入系统，说明选择的赛题，为每支参赛队打印一份control sheet，下载summary sheet作为论文电子版首页。这两份材料是论文必不可少的材料。\r\n比赛结束前\r\n 上传solution paper的电子稿\r\n导师，或者任何一名队员向solutions@comap.com提交电子稿（an electronic copy of its solution paper）。 \r\nCOMAP接收邮件的截止时间为美国东部时间2019年1月28日晚上9时；\r\n在2019年1月28日晚上9:00 EST前接收失败的队伍将被取消资格，为避免网络繁忙而提交失败，务必提前1个小时完成提交论文电子版；\r\n在2019年1月28日晚上8:00 EST后，不允许对论文做任何补充或者修改，否则将取消资格。\r\n邮件的主题（subject line）为control number，如1900000。\r\n电子版论文的名称为参赛队的control number，如1900000.pdf 。\r\n电子版论文的格式只可以是PDF；论文中不能包含Control Sheet；邮件中不要附上Control Sheet，计算机软件和计算机程序，因为这些内容不会进入评审程序；一封邮件只能包括一份论文。\r\n任何除control number之外的导师、队员、单位的信息不能在邮件和论文中出现，电子稿的首页必须是summary sheet。（*注：附件必须小于17MB。）\r\n不能使用任何临时储存功能（如云附件等）。\r\n为避免遗忘，在发送论文后，应马上发送control sheet，发送方法如下。\r\n比赛结束后\r\n准备一份纸质control sheet：每位队员在control sheet上签名，承诺遵守比赛规则。\r\n通过电子邮件发送签名后的control sheet电子版：\r\n将签名后的control sheet扫描或拍照为PDF文件或照片图像文件，文件名称为control number；\r\n向forms@comap.com提交control sheet文件；\r\n邮件的主题（subject line）为control number，如1900000；\r\n一封邮件只能包括一份control sheet文件；\r\n附件必须小于17MB；\r\n不能使用任何临时储存功能（如云附件等）；\r\ncontrol sheet文件接收截止时间：2019年2月8日下午5点EST。\r\n赛事结束后的评奖\r\n A．检查邮包收取\r\n导师登入系统检查论文电子版是否成功接收。\r\n B．竞赛结果公示\r\n评审工作将在三月结束，结果将在4月29日公示，分为Disqualified，Unsuccessful, Successful Participant（成功参赛奖）, Honorable Mention（二等奖）, Meritorious（一等奖）, Finalist（特等奖候选奖）, or Outstanding Winner（特等奖）。\r\n获奖证书\r\n所有国际参赛队伍，将只会收到PDF格式的获奖证书，参赛选手可在证书发布后登录账号下载（通常在成绩公布后的十天左右）。\r\n 奖项与荣誉\r\n今年起，Two Sigma Scholarship Award将成为国际奖项，奖学金将颁发给来自任何参与国的四个顶尖MCM/ICM团队；9000美元由团队成员分摊，1000美元颁给学校代表。\r\n美国运筹学和管理学研究协会将会在每个问题挑选一个队伍授予INFORMS Award。\r\n工业与应用数学学会将会在MCM问题A和B中各挑选一个队伍授予SIAM Award。\r\n美国数学学会将会在MCM问题中挑选两个队伍授予MAA Award。\r\n美国统计学会将会在MCM问题C中挑选一个队伍授予ASA winner。\r\n美国数学协会（AMS）将从MCM问题A、B和C各挑选一个队伍授予AMS winners。\r\nThe Ben Fusaro Award通常用于奖励进入MCM最后决赛的最有创新性的一篇论文。\r\nFrank R. Giordano Award开始于2012年，为表彰Frank R. Giordano准将领导MCM 20年而设立，用于奖励在建模执行过程中真正卓越的一篇MCM论文。\r\nThe Leonhard Euler Award授予由D题裁判长挑选出的一个队伍。评判准则：1）获得Meritorious，或Finalist，或Outstanding Winner；2）包含特别具有创意和创新的建模；3）显示了很好的交叉学科认识。奖项因为十八世纪瑞士数学家欧拉而命名。\r\nThe Rachel Carson Award因为一位美国著名的环保主义者而命名，他的著作《寂静的春天》引发了全球环境运动，许多学科开始关注的当地和全球环境问题。授予E题中运用科学的理论和数据建模的卓越团队。\r\nThe Pareto Award用以奖励在F题中对社会科学问题做出杰出模型的队伍，奖项命名是为了纪念著名意大利学者帕累托。', '2019-06-13 22:43:10', '2019年美国大学生数学建模竞赛（MCM/ICM）美赛', '2', '2019-06-13 22:52:14', '3');
INSERT INTO `t_competition` VALUES ('2', '2017年MCM / ICM比赛   2017年1月19日- 23日\r\n通过参加美国数学及其应用联合会举办（下文用COMAP\'s代替）的数学建模竞赛（下文中用MCM代替）将理论知识转化为实践，让你不再为空谈数学理论而对未来就业产生迷茫。以数学自身作为一门学科进行研究，可能要追溯到毕达哥拉斯时期，但数千年来，算数一直是人们日常生活中所必须的技能。由此可见，先贤们发明数学就是为了使人类可以更好的揭示和管理其所处的世界。\r\n \r\n你能从（MCM）中获得什么？\r\nMCM是一个挑战你的脑力、解决现实数学问题、并在国际舞台上得到认可的机会。同时，这又是一个通过团队合作来增强你个人交往能力的绝佳机会。而且，当你申请实习时，如果你的简历中有MCM参赛经历，其会成为你的优势并使用人单位眼前一亮。更吸引人的是，全美最强的团队有可能获得高达10000美金的Sigma奖学金，以及更多的无形优势。\r\n \r\n你所属的学校能从（MCM）中获得什么？\r\nMCM可以使你所属的学校被国际认可，以及获得成为COMAP第32届国际活动参与者的机会。同时，对于这类问题的研究会使得你所属的学校能在处理现实的问题，制定政策以及控制财政支出方面做出更有意义及充分的准备。除此之外，还可以为你所属的学校在未来设立更多应用类课程提供蓝图、动力及充足理由。\r\nCOMAP的数学建模竞赛（MCM）的赛题均源于现实世界的实际问题。在比赛中，你对于问题的研究、分析以及如何运用你的聪明才智起了主导的作用，当然，比赛的时限和运气这样的不可控的因素也有一定影响。你做好参赛准备了吗？\r\n数学建模竞赛（MCM）是一个面向于高中生和大学生的国际大赛。它对于团队在阐明、分析、和解决开放式问题等能力是一项极大的挑战。同时，大赛吸引了世界各地超过900个机构学生和指导老师。\r\n跨学科的数学建模竞赛(ICM)，是数学建模竞赛（MCM）的推广。它旨在提升和促进参赛者在跨学科问题的解决以及书面表达的能力。\r\n\r\n2017年MCM / ICM比赛日期定于，2017年1月19日- 23日。\r\n每个团队在下列问题中选择且只能选择一个问题，并提交解决方案。\r\nMCM问题A(连续)\r\nMCM问题B(离散)\r\nMCM问题C(对于数据的见解)\r\nICM问题D(运筹学/网络科学)\r\nICM问题E(环境科学)\r\nICM问题F(政策)\r\n \r\n奖品/证书:\r\n两个Sigma奖学金将授予两个顶级MCM / ICM美国团队；每个队伍10000美元，其中团队队员们可得9000美元，学校代表可得1000美元。获奖名单将于2017年4月宣布。（官网写错了，应该是17年）\r\n获奖名单发布后，每个成功参赛队伍的队员和指导老师将会收到一份参赛的证书。你可以登录竞赛网站，并使用用户名登录链接查看和打印你团队的证书。所有的国际队伍只会收到一个电子证书(PDF)。美国的参赛队伍会在结果公布的数周后收到你的打印证书。\r\n \r\nMCM奖项（A，B，C题）\r\nBen Fusaro奖将从入围决赛选手中选取，并颁发特别创意奖证书。\r\nFrank R. Giordano奖始于2012年。设立该奖为了表彰FrankR. Giordano在指导了数学建模竞赛20年。这个奖项授予那些模型在实际应用中效果显著的参赛队。\r\n \r\nICM奖项（D，E，F题）\r\nLeonhard Eule奖将颁发给由ICM问题D首席评阅人挑选的队伍。标准是：\r\n1）属于M，F，O奖等级；\r\n2）模型创造性与创新性明显；\r\n3）显示出对交叉学科良好的理解力。该奖项是为了表彰18世纪的瑞士的名称应用数学家，他因研究应用内容广博，著作等身，及在教学与交叉学科的杰出贡献而闻名。\r\n \r\nRachel Carson奖是为了纪念一位美国的自然资源保护论者，他的工作跨越了许多与当地环境和全球环境有关的学科，他的著作《寂静的春天》引发了全球环保运动。这个奖由ICM问题E的首席评阅人选出，颁发给在建模中应用科学理论与数据卓越的队伍。\r\n \r\nVilfredo Pareto（1848.7.15-1923.8.19）是一位意大利学者，建模师，问题解决专家。他在不同时期以工程师、社会学家、经济学家、政治学家、数学家和哲学家等不同身份对科学界做出贡献。ICM设立Pareto奖是为了表彰他在策略类建模问题（ICM的F题）的建树以及解决此著名社会科学问题所产生的对于后世巨大的影响。特别在此奖项中，首席评阅人很难找到最佳的模型，这些模型具有更多有动态的和挑战性的人为引入因素，此类因素可以使此类社科类模型很好的被简化及细化。\r\n运筹学和管理科学研究所（INFORMS）是世界上拥有运筹学（OR）领域、管理科学（MS）领域和分析领域专业人员最多的协会。INFORMS早已认识到将本科生以及教师参与到一些无固定方法的建模过程的重要性，这些建模问题囊括了很多INFORMS成员们正在关注的元素。MCM/ICM是这些特征的典范。因此，自MCM/ICM成立以来，INFORMS一直是MCM/ICM的积极支持者。\r\nINFORMS分别从6个问题（A、B、C、D、E、F）里精心的选择并指定一个O奖队伍作为INFORMS优秀队伍，要求其模型风格和内容可以很好的体现成员的专业和实践水平。每名学生会收到一封由现任INFORMS总裁的祝贺信，一个一年免费的INFORMS学生会员，以及个人现金奖励。相应的指导老师都会收到一封来自INFORMS总裁的祝贺信，以及免费一年访问的全套获奖INFORMS期刊的许可权。\r\n\r\n工业与数学应用协会（SIAM）将会从每一个MCM问题中选出一个优秀的队伍作为SIAM奖的获得者。\r\n \r\n奖项说明\r\n学生队伍成员：\r\n每个获奖队的学生都会得到500美元的现金奖励，以及三个一年期的SIAM学生会员资格。SIAM将会报销队伍成员650美元的国内路费或者800美元的国际路费。而由官方比赛的裁判从非获奖队中决选出一队作为杰出队伍，该队可获得SIAM一年的会员资格。\r\n指导老师：\r\n获奖队的指导老师将会获得此机构颁发的证书。\r\n\r\n美国数学协会（MAA）将从每一个问题中选出一个优秀的团队为MAA奖的获得者。每个学生的成员获奖团队将获得证书。MAA将部分报销他们参加Math Fest会议的部分费用，使其可以发表他们的论文。\r\n \r\n另附美赛参赛帮助原文\r\nMCM/ICM Contest    \r\nJanuary 19 - 23, 2017\r\nTurn theory into practice by entering COMAP\'s Mathematical Contest in Modeling (MCM). The study of mathematics as a subject in its own right may have started with Pythagoras, but people have been counting as a basic necessity of everyday life for thousands of years. It follows that mathematics was invented to help us understand and manage the world around us. \r\n\r\nWhat\'s in it for you? It\'s a chance to challenge your brain, solve a real world math problem, and get recognition for it on an international stage. It\'s an excellent opportunity to develop your interpersonal skills through teamwork. It\'s also an impressive resume credential and an advantage when applying for internships. Added Attraction: A chance for your top US team to win the Two Sigma $10,000 Scholarship Award, and more. \r\n\r\nWhat\'s in it for your school? The recognition and prestige of being part of COMAP\'s 32nd annual international event. Meaningful preparation for the real world of problems, politics and financial constraints. Impetus and justification for more applied courses\' a blueprint for your schools future.\r\n\r\nCOMAP\'s Mathematical Contest in Modeling (MCM) is Real World Mathematical Modelingwhere research, analytics and applied intelligence reign along with less-quantifiable factors like timing and luck. Think you\'re up to it?\r\nMathematical Contest in Modeling (MCM), an international contest for high school students and college undergraduates. It challenges teams of students to clarify, analyze, and propose solutions to open-ended problems. The contest attracts diverse students and faculty advisors from over 900 institutions around the world.\r\nThe Interdisciplinary Contest in Modeling (ICM), is an extension of the Mathematical Contest in Modeling (MCM). It is designed to develop and advance interdisciplinary problem-solving skills as well as competence in written communication.\r\n\r\nThe 2017 MCM/ICM contest dates are set for January 19 - 23, 2017Each team may choose any one of the six problem choices and should submit a solution to only one problem.\r\nMCM Problem A (continuous)\r\nMCM Problem B (discrete)\r\nMCM Problem C (data insights)\r\n         \r\nICM Problem D (operations research/network science)\r\nICM Problem E (environmental science)\r\nICM Problem F (policy)\r\n\r\nPrizes/Certificates:\r\n\r\nThe Two Sigma Scholarship Award will be awarded to two top MCM/ICM US teams; $10,000 per team with $9000 going to the team members and $1000 to the school represented. Awards will be announced in April 2016.\r\n\r\nAfter the results are issued, each successfully participating team advisor and student will receive a certificate of participation. You may login to the contest web site using the Advisor Login link to view and print your team\'s certificates. All international teams will ONLY receive an electronic (PDF) certificate. US teams should allow several weeks after the results are posted to the contest web site to receive your print certificate. Click here to download MCM/ICM certificates.. \r\n\r\nMCM Awards\r\n(Problem A, B and C)\r\nThe Ben Fusaro Award will be accorded to an especially creative paper and will be chosen from the contest finalists.\r\nThe Frank R. Giordano Award began in 2012. It honors Brig. Gen. (ret) Frank Giordano who directed the MCM for 20 years. This award goes to a paper that demonstrates true excellence in the execution of the modeling process.\r\nICM Awards\r\n(Problem D, E and F)\r\nThe Leonhard Euler Award is presented to a team selected by the head judge of the ICM\'s Problem D. The criteria are: 1) a paper in the Meritorious/Finalist/Outstanding rating; 2) contains especially creative and innovative modeling; and 3) shows good understanding of interdisciplinary science. The award honors the name of a 18th-century Swiss applied mathematician, who was known for the breadth of his research applications, volume of written work, excellent teaching, and interdisciplinarity.\r\nThe Rachel Carson Award honors an American conservationist whose book \"Silent Spring\" initiated the global environmental movement and whose work spanned many disciplines concerned with the local and global environments. This award is presented to a team selected by the Head Judge of ICM Problem E for excellence in using scientific theory and data in its modeling.\r\nVilfredo Pareto was an Italian scholar, modeler and problem solver, who at various times was an engineer, sociologist, economist, political scientist, mathematician, and philosopher. He lived and worked in the late 19th and early 20th centuries. The ICM Pareto Award for outstanding modeling in the Policy Modeling problem (ICM Problem F) honors the work and legacy of this famous social science problem solver. In particular for this award, the head judge seeks to highlight a paper that best models the more dynamic and challenging contextual human elements that make simplification or refinement of policy models so difficult.\r\n\r\nThe Institute for Operations Research and the Management Sciences (INFORMS) is the largest society in the world for professionals in the field of operations research (OR), management science (MS), and analytics. INFORMS has long recognized the importance of involving undergraduate students and faculty in an unscripted process of mathematical modeling whose problems contain many of the modern elements seen by its membership. The MCM/ICM exemplifies these characteristics. Consequently, INFORMS has been an active supporter of the MCM/ICM since its inception. \r\n\r\nINFORMS carefully selects and designates a single Outstanding team from each of the six problems - A, B, C, D, E, F - as an INFORMS Outstanding winning team whose modeling and analyses best exemplify the style and content reflected in its membership\'s professional practice. Each student receives a letter of congratulations from the current INFORMS President, a complimentary one-year INFORMS student membership, and an individual cash award. Each associated faculty advisor receives a letter of congratulations and appreciation from the current INFORMS President, along with complimentary one-year access to the full suite of award-winning INFORMS journals. \r\n\r\nThe Society for Industrial and Applied Mathematics (SIAM) will designate one Outstanding team from each MCM problem as a SIAM winner.\r\nDescription of the Award\r\nStudent Team Members:\r\nEach student member of the winning team will receive a cash award of $500 and three one-year student memberships in SIAM. Team members’ travel expenses will be reimbursed by SIAM up to $650 for domestic travel or $800 for international travel. A one-year student membership in SIAM will be given to each member of non-winning teams judged as \"Outstanding\" by the official contest judges.\r\nFaculty Adviser:\r\nA suitable certificate for the home institutions will be given to the faculty advisers of the winning teams\r\n\r\nThe Mathematical Association of America (MAA) will designate one Outstanding team from each problem for the MCM as a MAA winner. Each student member of the winning team will receive a certificate. MAA will partial reimburse teams travel expenses to Math Fest so that they may present their paper.\r\n\r\n官网及报名地址：http://www.comap.com/undergraduate/contests/', '2019-06-13 22:51:01', '2017年美国大学生数学建模竞赛', '3', '2019-06-13 22:51:01', '3');
INSERT INTO `t_competition` VALUES ('3', '高校参赛预报名：9月1日—9月20日\r\n指导思想\r\n为促进高校工程类及工程管理专业学生全面发展，提升学生解决工程管理领域实际问题的能力，上海市工程管理学会特举办第二届上海市工程管理创新大赛。大赛以工程类行业的实际需求为宗旨，要求参赛者将工程领域和管理领域的技能相结合，取得明显的工程应用效果，体现一定的工程管理能力。\r\n活动组织\r\n主办单位：上海市工程管理学会\r\n承办单位：上海理工大学\r\n赞助单位：中国建设第八工程局有限公司\r\n媒体支持：我爱竞赛网\r\n参赛对象\r\n参赛对象为上海各高校在校工程管理本科生和研究生，MEM专业学位研究生及其他各类工科专业本科生和研究生。每个项目组成员不得多于5人，每组至少有1名指导教师。\r\n形式和内容\r\n参赛形式以实践性报告或论文为主。内容可以是专题研究、工程应用（工程管理模型与方法、工程管理方案设计、管理诊断）、工程案例分析等。只要是应用工程管理技术和方法进行工程项目管理创新的作品均可参赛。\r\n报名方式\r\n高校统一参赛报名', '2019-06-13 22:55:03', '第二届上海市工程管理创新大赛', '2', '2019-06-13 22:55:03', '18');
INSERT INTO `t_competition` VALUES ('4', '报名及作品提交：2019年5月17日-7月30日\r\n大赛背景\r\n为贯彻落实《国务院关于深化“互联网+先进制造业”发展工业互联网的指导意见》，按照工业信息化部《工业互联网APP培育工程方案（2018-2020年）》有关要求，完成2020年培育30万个面向特定行业、特定场景工业APP的目标，天津市工业和信息化局、工业和信息化部电子第五研究所、中国工业技术软件化产业联盟联合承办了2019中国（天津）工业APP创新应用大赛。\r\n比赛内容\r\n1. 大赛设置场景赛和创意赛两大类比赛项目。\r\n2.其中场景赛围绕制造业提质增效和转型升级实际需求，面向国内汽车、家电、针织行业，提炼企业生产中场景的实际需求，形成了三个比赛场景。\r\n3. 创意赛分为解决方案创意赛和高校工业设计创意赛。\r\n4. 详细比赛内容请查看对应赛题详情页面。\r\n大赛赛题\r\n场景赛\r\n场景名称1：汽车雨刮器CAD设计优化工具\r\n场景名称2：防差错设计电子作业指导书\r\n场景名称3：针织个性化设计APP\r\n解决方案创意赛\r\n围绕工业产品研发设计、生产制造、运营维护和经营管理等制造业关键业务环节，一是面向国内制造业重点项目推进、重大工程实施和重要装备研制需求，征集具有高支撑价值的安全可靠工业APP解决方案；二是面向“工业四基”领域，征集普适性强、复用率高的基础共性工业APP解决方案；三是面向汽车、航空航天、石油化工、机械制造、轻工家电、信息电子及其他行业需求，征集推广价值高、带动作用强的行业通用工业APP解决方案；四是面向制造企业的个性化需求，征集高应用价值的企业专用工业APP解决方案。\r\n高校工业设计创意赛\r\n征集以工业三维数字化模型设计、工业应用创意设计为主题，面向工业数字设计（工业设计、产品设计、机电工程设计、模具设计等）和建筑数字设计（BIM建筑信息模型、CIM城市信息模型、室内外设计等）两个方向的作品。\r\n比赛赛程\r\n2019年3月-5月	赛题征集、场景调研、技术方案评审\r\n2019年5月16日	大赛启动仪式、赛题发布、报名开启\r\n2019年5月17日-7月30日	参赛团队邀约、场景需求对接，参赛作品提交\r\n2019年8月1日-8月3日	作品形式审核\r\n2019年8月4日-8月8日	创意赛大众投票，创意赛专家评审，场景赛初赛评审\r\n2019年8月9日-8月20日	场景赛工业APP测评，用户评价\r\n2019年8月底	场景赛现场答辩、大赛颁奖典礼、企业与人才及优秀产品开发团队对接会\r\n参赛条件\r\n1.国内高校、各类企事业单位及团队（海外留学回国创业人员、进入创业实施阶段的优秀科技团队、大学生创业团队等）均可免费报名参加场景赛和解决方案创意赛，高校工业设计创意赛仅面向高校；\r\n2. 团队成员2~5人，并明确队长；\r\n3. 参赛工业APP作品的创意、技术及相关知识产权归属参赛团队，无产权纠纷。\r\n大赛组织机构\r\n主办单位：工业和信息化部、天津市人民政府\r\n承办单位：天津市工业和信息化局、工业和信息化部电子第五研究所、中国工业技术软件化产业联盟\r\n联合承办单位：天津滨海高新技术产业开发区管理委员会、中国汽车技术研究中心有限公司数据资源中心、海尔COSMOPlat工业互联网平台、宁波慈星股份有限公司、清华大学软件学院\r\n协办单位：天津市企业技术创新服务中心、天津智慧城市研究院有限公司、天津市软件协会\r\n支持单位：树根互联技术有限公司、天津美腾科技有限公司\r\n大赛奖励\r\n大赛官网：http://competition2019.caitis.cn/index.html', '2019-06-16 17:34:55', '2019中国（天津）工业APP创新应用大赛', '2', '2019-06-16 17:34:55', '18');
INSERT INTO `t_competition` VALUES ('5', '报名截止日期：2019 年4 月30 日\r\n一、竞赛总则\r\n全国大学生物联网设计竞赛（以下简称“竞赛”）是以学科竞赛推动专业建设、培养大学生创新能力为目标，面向全国高校大学生举办的全国性竞赛。2019 年竞赛以物联网行业项目和创新产品为导向激发学生的创造、创新、创业活力，推动创新创业教育的开展，助力大众创业万众创新支撑平台的建设为办赛方针，以高校大学生为主体，为高质量的物联网工程专业人才培养搭建交流、展示、合作的平台，并推动物联网技术在相关领域的应用与发展。\r\n二、竞赛组织\r\n主办单位：教育部高等学校计算机类专业教学指导委员会\r\n承办单位：四川大学\r\n支持单位：机械工业出版社华章公司\r\n1．教育部高等学校计算机类专业教学指导委员会成立全国大学生物联网设计竞赛组织委员会（以下简称“竞赛组委会”），并在上海交通大学电子信息与电气工程学院设竞赛秘书处。 \r\n2．竞赛组委会负责组建竞赛专家指导委员会、竞赛评审委员会和竞赛监督委员会，指导、执行和监督各分赛区及全国总决赛的组织和奖项评审工作。 \r\n3．参赛队伍可自拟选题参赛，可自主选择技术平台制作参赛作品。同时，为促进参赛师生与业界的交流，提高参赛作品质量，竞赛组委会邀请合作伙伴设计了若干具有挑战性的竞赛命题，选择这些命题的参赛队伍有机会得到这些合作伙伴资深工程师的指导，并免费获得组委会发放的相关技术平台。使用推荐技术平台参赛将获得适当的加分。 \r\n4．竞赛组委会将同期举办创客交流、创业路演、技术交流与培训等活动。\r\n三、赛事流程及赛区设置\r\n（一）赛事流程\r\n第一阶段：报名和线上作品提交阶段 \r\n1．2019 年 3 月 赛事启动。 \r\n2．2019 年 3 月 31 日 竞赛官网公布合作伙伴为竞赛特别设计的具有前瞻性的竞赛主题，参赛队可以选择某一竞赛主题进行作品构思。 参赛队也可以自拟竞赛主题。 \r\n3．2019 年 4 月~5 月 组委会举办全国技术巡回讲座，参赛队可以线上和线下与合作伙伴的资深工程师交流，并根据需要领取组委会推荐的技术平台。参赛队线上提交报名表、作品选题、技术平台选择、作品构思。 \r\n4．2019 年 4 月 30 日 报名表、作品选题、技术平台选择、作品构思线上提交截止。 \r\n5．2019 年 6 月 30 日 作品完整方案和作品演示视频线上提交截止。\r\n第二阶段：分赛区竞赛阶段 \r\n6．2019 年 7 月 15 日前 各分赛区完成网上作品评审，公布入围分赛区决赛名单。 \r\n7．2019 年 8 月 15 日前 各分赛区决赛结束，公布入围全国总决赛名单。\r\n第三阶段：全国总决赛 \r\n8．2019 年 8 月下旬 全国总决赛暨颁奖典礼在四川大学举行。\r\n（二）赛区设置竞赛设立 5 个分赛区，分别是华东分赛区、华北分赛区、华中及西南分赛区、西北分赛区和东北分赛区。\r\n四、参赛对象\r\n1．参赛对象为普通高校全日制在校学生，也欢迎优秀的职业学校全日制在校学生参赛。 \r\n2．参赛学校以参赛队为基本单位报名参赛，同一所学校可组织多支参赛队，来自不同学校的学生不能联合组队参赛。每支参赛队参赛学生不超过 4 人，指导教师不超过 2 人。参赛指导教师可同时带领本校的多支参赛队，但参赛学生只得同时参加 1 支参赛队。 \r\n3．指导教师负责指导参赛队选题、组织学生参加赛前的技术培训，并鼓励学生应用竞赛推荐技术平台进行作品的创意设计与实现，同时负责竞赛过程中与学校及组委会之间的信息沟通。 \r\n4．各参赛学校应按竞赛通知的精神，统一组织和布置竞赛参赛工作，积极参加分赛区举办的赛事宣传和技术培训活动。\r\n五、报名流程 \r\n1．竞赛注册\r\n在竞赛网站http://iot.sjtu.edu.cn进行竞赛账号注册（注：往届参加过的学生和指导教师需重新注册）。学生注册采用邮箱验证方式自助进行；教师注册采用人工验证，注册信息提交后 2 个工作日内竞赛组委会审核注册信息并与指导教师联系确认完成注册。 \r\n2．创建团队使用注册好的竞赛账号登陆竞赛网站http://iot.sjtu.edu.cn，由一名学生担任队长创建团队，并将已经完成竞赛注册的指导教师和学生添加到团队中，完成团队创建。详见网站介绍。 \r\n3．作品提交完成团队创建的参赛队可以按要求提交作品相关。详见网站介绍。 \r\n4．竞赛组委会不收取任何报名费、参赛费、评审费及技术平台购买费等费用，竞赛推荐的技术平台由组委会免费向参赛队发放。 \r\n5．报名开始日期：2019 年 3 月 31 日 报名截止日期：2019 年 4 月 30 日（逾期报名系统将关闭） \r\n6．作品完整方案和演示视频提交开始日期：2019 年 5 月 1 日。作品完整方案和演示视频提交截止日期：2019 年 6 月 30 日（逾期作品提交系统将关闭）\r\n7．作品完整方案和演示视频提交截止后，各分赛区开始线上作品评审工作，评审结束后公布入围分赛区决赛名单，公布截止日期：2019 年 7 月 15 日前\r\n六、竞赛赛制\r\n（一）作品形式 \r\n1．线上提交的作品完整方案和演示视频一个基于物联网技术的、具有现实应用价值的物联网应用设计方案。 \r\n2．现场的作品演示和答辩参赛作品必须是学生原创，谢绝任何形式的导师课题参赛，或不经修改直接使用参加其他竞赛的参赛作品参赛。\r\n（二）竞赛形式 \r\n1．线上预赛由参赛队在竞赛网站提交作品完整方案和演示视频，采用线上评审方式对竞赛作品进行打分，并按分数高低决定入围分赛区决赛的参赛队伍名单。 \r\n2．分赛区决赛由各分赛区竞赛承办单位组织的现场集中式的竞赛，采用作品讲解和作品现场演示两个环节，评审专家现场打分，并按分数高低决定分赛区奖项归属及入围全国总决赛的参赛队伍名单。入围全国总决赛参赛队的总数不超过 120 支。 \r\n3．全国总决赛由竞赛组委会组织的现场集中式的竞赛，采用作品讲解和作品现场演示两个环节，评审专家现场打分，并按分数高低决定奖项归属。\r\n七、评审方法与奖项设置\r\n（一）评审方法 \r\n1．线上评审预赛阶段的评审将采用线上评审，各分赛区组织专家对本赛区的作品做出评审并计分。主要考察作品的创意、技术方案及其实现质量、应用价值等。分赛区按照线上评审结果确定入围分赛区决赛的参赛队。 2．现场评审分赛区决赛和全国总决赛都采用现场评审的方式。主要考察参赛作品的讲解和作品的现场演示效果。分赛区决赛和全国总决赛的评审结果当场产生。\r\n（二）奖项设置 \r\n1．竞赛将设置参赛队员奖、指导教师奖和优秀学校组织奖。 \r\n2．竞赛分区赛设分赛区特等奖若干名（分赛区特等奖入围全国总决赛），分赛区一、二等奖若干名，优秀指导教师和优秀学校组织奖若干名，发放获奖证书。 \r\n3．竞赛全国总决赛设一等奖若干名，颁发获奖证书和奖金；设二等奖、三等奖各若干名，颁发获奖证书；同时设创新奖若干名；设优秀指导教师和优秀学校组织奖，颁发获奖证书。 \r\n4．竞赛的获奖结果由竞赛评审委员会审定，并在竞赛网站上公示，获奖证书由教育部高等学校计算机类专业教学指导委员会会同竞赛组委会统一印制、颁发。\r\n八、交流活动 \r\n1．竞赛致力于推动物联网创新实践活动的开展，竞赛期间鼓励各种形式的参赛队间的交流活动，并组织主流媒体宣传优秀作品和参赛团队。 \r\n2．竞赛将争取更多的物联网行业龙头企业参与到竞赛的赞助、推广、宣传等活动中。 \r\n3．全国总决赛计划邀请国内代表性的物联网产业集聚区组团观摩竞赛。 \r\n4．全国总决赛计划邀请有影响力的跨国企业和投资机构参与物联网人才培养和物联网创新创客模式探索的讨论，推荐优秀团队与作品参与创业活动，加速技术转化。\r\n九、竞赛作品的知识产权 \r\n1．参赛作品的知识产权归参赛队及其所在学校所有。 \r\n2．参赛队应自觉遵守知识产权的有关法规，不得侵犯他人的知识产权或其他权益，对于由此造成的不良后果，本竞赛的主办、承办和协办方均不负任何法律责任。 \r\n3．竞赛的主要协办方，拥有免费使用参赛作品进行演示和出版的权利（不涉及技术细节）。如果以盈利为目的使用参赛作品，需与参赛队及其学校协商，经参赛队及其学校同意后，签署有关对参赛作品使用的协议。 \r\n4．对于进入全国总决赛的作品，竞赛专家委员会将遴选出部分优秀作品材料，由机械工业出版社华章分社汇集成书后正式出版发行。\r\n十、联系方式\r\n竞赛官方网站：http://iot.sjtu.edu.cn \r\n竞赛官方邮箱：iotcontests@sjtu.edu.cn \r\n竞赛组委会秘书处设在上海交通大学电子信息与电气工程学院\r\n联系电话：021-34205077 \r\n十一、其他本章程的具体解释权归全国大学生物联网设计竞赛组织委员会。\r\n教育部高等学校计算机类专业教学指导委员会 \r\n（主任单位代章）\r\n全国大学生物联网设计竞赛组委会 \r\n2019 年 3 月\r\n竞赛官方网站：http://iot.sjtu.edu.cn\r\n点击：http://iot.sjtu.edu.cn/show.aspx?info_lb=36&info_id=676&flag=2查看大赛命题', '2019-06-16 17:37:31', '2019年全国大学生物联网设计竞赛 ', '2', '2019-06-16 20:47:21', '17');
INSERT INTO `t_competition` VALUES ('6', '竞赛时间：2018年6月1日至6月3日\r\n赛项名称\r\n赛项名称：四川省大学生程序设计竞赛\r\n英语翻译：Sichuan Province Collegiate Programming Contest\r\n赛项组别：本科组\r\n赛项归属产业：计算机科学与技术类\r\n组织单位：\r\n主办单位：四川省教育厅\r\n承办单位：西南科技大学 \r\n竞赛目的\r\n通过本次大赛,旨在展示四川省内大学生创新能力、团队精神和在压力下编写程序、分析和解决问题的能力。引导学生关注程序设计中的算法问题；促进工学结合人才培养和课程的改革与创新；促进计算机程序设计的普及；提升四川省内计算机专业教师的指导水平。\r\n报名方式\r\n请各高校以学校为单位于2018年4月28日前填写《2018年（第十届）四川省大学生程序设计竞赛报名登记表》（附件3），加盖教务处公章后报送至西南科技大学，同时请发电子版至指定邮箱swustacm2018@163.com。\r\n竞赛流程\r\n1.竞赛时间：2018年6月1日至6月3日\r\n2.竞赛地点：西南科技大学逸夫图书馆\r\n竞赛内容\r\n1、竞赛内容：\r\n本次竞赛将采用ACM-ICPC国际大学生程序设计竞赛的比赛方式，至少命题10题，全英文题面，比赛时间为5个小时。比赛期间，每队使用1台电脑需要在5个小时内使用C、C++或Java中的一种编写程序解决问题。程序完成之后提交裁判运行，运行的结果会判定为“AC(正确)/WA（错误）/TLE（超时）/MLE（超出内存限制）/RE（运行错误）/PE（格式错误）”中的一种并及时通知参赛队。每队在正确完成一题后，组织者将在其位置上升起一只代表该题颜色的气球。最后的获胜者为正确解答题目最多且总用时最少的队伍。\r\n2、竞赛要求：\r\n参赛队员可以携带诸如词典、书、手册、程序清单等纸质参考资料。不能携带磁盘、存储功能计算器以及任何可用计算机处理的软件或数据。参赛队员不能携带任何类型的通讯工具，包括无线电接收器和移动电话等。不得自带键盘。比赛过程中严禁作弊，一旦发现将立即取消该队参赛资格并通报批评。\r\n竞赛方式\r\n1、比赛采用团体赛方式，不计选手个人成绩，统计参赛队的总成绩进行排序。\r\n2、队伍组成：每支参赛队由3名比赛选手组成，3名选手须为同校在籍学生，其中队长1名，性别不限。每队可配1名指导教师。所有参赛选手均为女生的队伍定义为女队。\r\n竞赛规则\r\n1、报名资格及参赛队伍要求\r\n（1）参赛选手须为高等学校全日制在籍学生；在读研究生一年级学生可以参加比赛。\r\n（2）组队要求：每个学校限报5支代表队，参赛选手为同一学校，不允许跨校组队；如果该学校存在女队，则限报6支代表队。\r\n竞赛环境\r\n1、竞赛语言： C,C++（gcc/g++ 4.6.1）和Java 1.8。\r\n2、裁判软件： PC^2 9.2.3-2565或者Online Judge。\r\n3、编辑器及版本：vim/vim-gtk 7.3.154，Emacs 23.3.1，gedit 3.2.3。\r\n4、IDE：CodeBlocks 10.05，Eclipse(Neon.1) 4.6.1。\r\n5、题目描述为全英文，知识点涉及数据结构、图论、动态规划、计算几何、搜索、组合数学和数论等。\r\n6、每支队伍使用一台计算机，所有队伍使用的计算机配置基本相同。\r\n奖项设定\r\n本赛项正式比赛奖项按队伍评奖（不包括中学生队伍和其它打星参赛的队伍），竞赛奖项的设定为：一等奖占比10%，二等奖占比20%，三等奖占比30%。优秀的指导教师可以颁发优秀指导教师奖。参赛女队超过3支队伍并且能正确解决一道比赛题目，可以颁发最佳女队奖。如果高职院校参赛队伍达到或超过10支，可以单独为高职设奖。\r\n大赛组委会颁发证书和奖励，为本次大赛的比赛成绩。\r\n其他事项：\r\n1、赛题由大赛组委会指定专家命题，由省教育厅全程监控，赛项专家和裁判由大赛组委会聘请。\r\n2、比赛期间，参赛队员和教练的餐费由西南科技大学解决。参赛报名费由西南科技大学收取，并开据发票；各参赛队自行联系酒店住宿，住宿缴费和住宿发票由酒店开据。\r\n参赛报名费缴费时间：2018年4月28日前。\r\n逾期未缴报名费的学校视为放弃参赛。\r\n缴费方式：请参赛高校将参赛报名费统一汇入大赛指定的账户，并注明“ACM参赛费-XX大学”。\r\n联系方式\r\n联系人：西南科技大学 韩强\r\n联系电话：0816-6089341，\r\n电子信箱：swustacm2018@163.com\r\n联系地址：四川省绵阳市涪城区青龙大道中段59号\r\n邮编：621010\r\n大赛讨论QQ群：732818609', '2019-06-16 20:09:46', '2018年（第十届）四川省大学生程序设计竞赛 ', '3', '2019-06-16 20:10:54', '18');
INSERT INTO `t_competition` VALUES ('7', '报名系统开放时间：2019年5月1日至8月30日\r\n\r\n各省、自治区、直辖市团委、网信办、工业和信息化及中小企业主管部门、人力资源社会保障厅（局）、农业农村（农牧）厅（局、委）、商务主管部门、扶贫办（局），中央军委政治工作部组织局群团处，全国铁道团委，全国民航团委，中央和国家机关团工委，中央金融团工委，中央企业团工委，新疆生产建设兵团团委、网信办、工信委、人力资源社会保障局、农业农村局、商务局、扶贫办：\r\n\r\n为深入学习贯彻习近平新时代中国特色社会主义思想，贯彻党的十九大和中央经济工作会议、中央农村工作会议精神，坚持创新、协调、绿色、开放、共享的发展理念，深化“创青春·中国青年创业行动”，鼓励和支持广大青年走在大众创业、万众创新前列，建功新时代、追梦新征程，共青团中央、中央网信办、工业和信息化部、人力资源社会保障部、农业农村部、商务部、国务院扶贫办决定，共同举办第六届“创青春”中国青年创新创业大赛暨2019中国青年创新创业交流会。现将相关事宜通知如下。\r\n\r\n一、活动目的\r\n搭建支持青年创新创业的展示交流、导师辅导、投融资对接、项目孵化等服务平台，建设创业导师、创投机构、创业园区、创业孵化器、青年创业者、大学生创业者等服务联盟，促进青年弘扬创业精神、培养创业意识、提升创业能力、提高创业成功率，动员更多青年为推进供给侧结构性改革和经济高质量发展，实施创新驱动发展战略、乡村振兴战略等重大战略，打好三大攻坚战、促进经济持续健康发展和社会大局稳定作贡献。\r\n\r\n二、活动主题\r\n青春建功新时代 创业追梦新征程\r\n\r\n三、组织单位\r\n1. 主办单位。 共青团中央、中央网信办、工业和信息化部、人力资源社会保障部、农业农村部、商务部、国务院扶贫办、山东省人民政府、浙江省人民政府。\r\n2. 承办单位。 中国青年创业就业基金会、中国青年企业家协会、中国农村青年致富带头人协会、中国青年创业联盟、KAB全国推广办公室、共青团山东省委、共青团浙江省委、青岛市人民政府、杭州市人民政府。\r\n3. 冠名赞助单位。 中国航天科工集团有限公司。\r\n\r\n四、组织机构\r\n1. 领导小组。 活动设立领导小组，由主办单位的负责同志组成。\r\n2. 全国组织委员会。 活动成立全国组织委员会，领导活动的整体规划和统筹组织，下设秘书处负责日常工作。秘书处设在团中央青年发展部，中国青年创业就业基金会、中国青年企业家协会共同参与。\r\n3. 评审委员会。 活动成立评审委员会，负责参赛项目的评审工作。评审委员会由创投行业人士、青年创业导师和相关行业专家学者组成。\r\n4. 地区赛组织机构。 各省（自治区、直辖市）及副省级城市、省会城市、市（地、州、盟）举办地区赛时，应在各地团委牵头下，参照成立相应的组织机构。\r\n\r\n五、赛制规则\r\n1. 赛事名称。 全国活动名称表述为：第六届“创青春”中国青年创新创业大赛暨2019中国青年创新创业交流会。各级组委会在活动组织中以赛事为主，表述为：“创青春”中国青年创新创业大赛。各地可根据自身情况，配套举办创交会。\r\n2. 全国赛类别。 本届大赛全国赛设商工组、农业农村组、互联网组3个类别。（大赛全国赛总体设商工组、农业农村组、互联网组和大学生组4个类别。其中，大学生组全国赛每两年举办一届，本届大赛全国赛不设大学生组。）\r\n商工组 重点关注节能环保、信息科技、先进制造、生物医药、新能源、新材料等领域相关产业，强调对实体经济给予重点倾斜\r\n农业农村组 重点关注先进种植养殖技术、农产品加工及销售、农业社会化服务、乡村旅游等涉农领域相关产业，着重对精准扶贫、精准脱贫攻坚相关项目给予重点倾斜。\r\n互联网组 重点关注移动互联网、互联网设备、共享经济、大数据、人工智能、智慧城市等互联网技术与应用相关产业，及运用互联网手段改造发展传统产业。\r\n3. 地区赛赛制。 各地可根据情况，将商工组、农业农村组、互联网组整合举办；也可分别举办。\r\n\r\n六、赛程安排\r\n1. 报名及审核。 参赛项目须登录“创青春”APP（附件4）和网站（http://cqc.casicloud.com/youthCmpe/common/home.do）注册报名。未登录系统报名的不得参加全国赛。\r\n报名系统开放时间：2019年5月1日至8月30日。\r\n2. 地区赛。 各省（自治区、直辖市）应举办省级赛事；原则上，各副省级城市、省会城市应举办市级赛事；鼓励有条件的市（地、州、盟）及县（市、区、旗）举办相应赛事。全国赛之前，秘书处将根据各地赛事规模及组织情况，进行晋级名额分配。\r\n时间：2019年8月30日前完成。\r\n3. 全国赛。 暂定于2019年10月，在浙江杭州举办互联网组全国赛，11月在山东青岛举办商工组、农业农村组全国赛暨2019中国青年创新创业交流会（交流会相关通知另行印发）。\r\n\r\n七、参赛条件\r\n（一）参赛人员\r\n1. 中国公民。\r\n2. 申报人年龄35岁以下（含），年龄划分以2019年6月30日为界。其中由团队申报的参赛项目，团队总人数不多于5人，且团队平均年龄不超过30周岁（含）。\r\n（二）参赛项目\r\n1. 符合国家法律法规和国家产业政策。\r\n2. 不得侵犯他人知识产权。\r\n3. 具有良好的经济效益、社会效益，经营规范，社会信誉良好。\r\n4. 尚未接受过投资或仅接受过早期投资（种子轮、天使轮或A轮投资）。\r\n5. 掌握具有较大投资价值的独特产品、技术或商业模式。\r\n（三）项目分组\r\n商工组、农业农村组、互联网组根据参赛项目所处的创业阶段及企业创办年限（以工商登记为准）不同，分设创新组、初创组、成长组；其中，农业农村组另设电商组。企业创办年限划分以2019年6月30日为界。\r\n1. 创新组为未进行企业登记注册，尚处于商业计划书阶段的创业项目。\r\n2. 初创组为企业登记注册时间不超过2年（含）的创业项目。\r\n3. 成长组为企业登记注册时间在2至5年（含）之间的创业项目。\r\n4. 电商组为企业登记注册时间在5年（含）以内的创业项目。\r\n（四）项目申报\r\n1. 未进行企业登记的参赛项目，须提交商业计划书，对市场调研、创业构想、项目发展等有详细介绍；附上专利、获奖、技术等级等省级以上行业主管部门出具的证书或证明；第一申报人须为产品开发、项目设计主要负责人，与相关证书或证明一致。\r\n2. 已进行企业登记的参赛项目，须提交营业执照、税务登记证副本、银行开户许可证复印件等相关文件，项目成长过程或生产流程相关介绍，项目发展构想及阶段性成果等资料；涉及国家限制行业和领域的，需有相关资质证明；第一申报人须为企业法人代表，且所占股份不低于30%（含）。\r\n\r\n八、奖励及激励\r\n全国赛设金奖、银奖、铜奖、优秀奖。获奖项目将获得全国组织委员会颁发的相应等次的奖杯和证书，并获得各主办单位给予的相关优惠政策。\r\n1. 政策支持。 在符合中央网信办、工业和信息化部、人力资源社会保障部、农业农村部、商务部、国务院扶贫办等政策要求的条件下，可优先给予相关政策支持。\r\n2. 融资服务。 可优先推荐在“中国青年创新创业板” 和各地青年创业板挂牌展示或融资，并视情况给予一定额度挂牌补贴；可优先推荐给大赛相关创投机构洽谈融资合作事项。\r\n3. 培育孵化。 可申请入驻大赛合作园区，优先享受优惠的创业支持政策和优质的创业孵化服务；可优先推荐导师“一对一”服务；可优先推荐在中国青年信用体系相关平台中接受激励措施。\r\n4. 社会荣誉。 可申报“中国青年创业奖”“全国农村青年致富带头人”等奖项，在同等条件下予以优先考虑。\r\n5. 会员推荐。 可申请加入中国青年创业联盟、中国青年电商联盟会员，可申请加入中国青年企业家协会、中国农村青年创业致富带头人协会会员，予以优先推荐。\r\n6. 展示交流。 可优先推荐参加全国大众创业万众创新活动周、世界互联网大会等相关活动。\r\n\r\n九、工作要求\r\n各地应根据《“创青春”中国青年创新创业大赛章程（试行）》 （附件1）、《第六届“创青春”中国青年创新创业大赛竞赛规则》 （附件3），设立地区赛事组织机构，按照地方经济社会发展状况和产业导向，细化赛事流程和竞赛规则，积极动员创业青年参赛，遴选、推荐优秀创业项目参加全国赛。各地要增强赛事品牌宣传意识，加大与新闻媒体合作力度，强化新媒体宣传，扩大赛事吸引力和影响力。各地要积极协调党政政策，整合社会资金资源，采取切实有效的举措，帮助青年解决创业过程中遇到的“痛点”“难点”。\r\n各省（自治区、直辖市）团委应于6月30日前，将地区赛事组织方案、赛事细则和宣传方案报至全国大赛组织委员会秘书处。\r\n\r\n大赛组委会秘书处\r\n联系人：叶志超 李征然\r\n电 话：010—85212087 85212452（兼传真）\r\n电子信箱：jycygzc@163.com\r\n官方微信微信号：创青春', '2019-06-24 23:19:58', '第六届“创青春”中国青年创新创业大赛', '2', '2019-06-24 23:19:58', '9');

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(255) DEFAULT NULL,
  `dict_name` varchar(255) DEFAULT NULL,
  `dict_sort` float DEFAULT NULL,
  `dict_status` int(11) DEFAULT NULL,
  `dict_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('1', '001', '综合', '1', '0', '类别');
INSERT INTO `t_dict` VALUES ('2', '010', '理科', '2', '0', '类别');
INSERT INTO `t_dict` VALUES ('3', '011', '文科', '3', '1', '类别');
INSERT INTO `t_dict` VALUES ('4', '100', '工科', '4', '0', '类别');
INSERT INTO `t_dict` VALUES ('5', '101', '艺术', '5', '1', '类别');
INSERT INTO `t_dict` VALUES ('6', '110', '其他', '6', '0', '类别');

-- ----------------------------
-- Table structure for t_premission
-- ----------------------------
DROP TABLE IF EXISTS `t_premission`;
CREATE TABLE `t_premission` (
  `premission_id` bigint(30) NOT NULL,
  `premission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`premission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_premission
-- ----------------------------
INSERT INTO `t_premission` VALUES ('1', 'user:select');
INSERT INTO `t_premission` VALUES ('2', 'user:read');
INSERT INTO `t_premission` VALUES ('3', 'user:save');
INSERT INTO `t_premission` VALUES ('4', 'user:update');
INSERT INTO `t_premission` VALUES ('5', 'user:delete');
INSERT INTO `t_premission` VALUES ('6', 'file:upload');
INSERT INTO `t_premission` VALUES ('7', 'file:download');
INSERT INTO `t_premission` VALUES ('8', 'competition:select');
INSERT INTO `t_premission` VALUES ('9', 'competition:save');
INSERT INTO `t_premission` VALUES ('10', 'competition:delete');
INSERT INTO `t_premission` VALUES ('11', 'competition:update');
INSERT INTO `t_premission` VALUES ('12', 'dict:select');
INSERT INTO `t_premission` VALUES ('13', 'dict:update');
INSERT INTO `t_premission` VALUES ('14', 'dict:delete');
INSERT INTO `t_premission` VALUES ('15', 'dict:save');
INSERT INTO `t_premission` VALUES ('16', 'file:delete');
INSERT INTO `t_premission` VALUES ('17', 'category:select');
INSERT INTO `t_premission` VALUES ('18', 'category:save');
INSERT INTO `t_premission` VALUES ('19', 'category:update');
INSERT INTO `t_premission` VALUES ('20', 'category:delete');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` bigint(30) DEFAULT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'manager');
INSERT INTO `t_role` VALUES ('2', 'user');

-- ----------------------------
-- Table structure for t_role_premission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_premission`;
CREATE TABLE `t_role_premission` (
  `id` bigint(30) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `premission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_premission
-- ----------------------------
INSERT INTO `t_role_premission` VALUES ('1', 'manager', 'user:select');
INSERT INTO `t_role_premission` VALUES ('2', 'manager', 'user:read');
INSERT INTO `t_role_premission` VALUES ('3', 'manager', 'user:write');
INSERT INTO `t_role_premission` VALUES ('4', 'manager', 'user:update');
INSERT INTO `t_role_premission` VALUES ('5', 'user', 'user:read');
INSERT INTO `t_role_premission` VALUES ('6', 'manager', 'user:delete');
INSERT INTO `t_role_premission` VALUES ('7', 'manager', 'file:upload');
INSERT INTO `t_role_premission` VALUES ('8', 'manager', 'file:download');
INSERT INTO `t_role_premission` VALUES ('9', 'manager', 'competition:select');
INSERT INTO `t_role_premission` VALUES ('10', 'manager', 'competition:save');
INSERT INTO `t_role_premission` VALUES ('11', 'manager', 'competition:delete');
INSERT INTO `t_role_premission` VALUES ('12', 'manager', 'competition:update');
INSERT INTO `t_role_premission` VALUES ('13', 'manager', 'dict:select');
INSERT INTO `t_role_premission` VALUES ('14', 'manager', 'dict:update');
INSERT INTO `t_role_premission` VALUES ('15', 'manager', 'dict:delete');
INSERT INTO `t_role_premission` VALUES ('16', 'manager', 'dict:save');
INSERT INTO `t_role_premission` VALUES ('17', 'manager', 'file:delete');
INSERT INTO `t_role_premission` VALUES ('18', 'manager', 'category:select');
INSERT INTO `t_role_premission` VALUES ('19', 'manager', 'category:save');
INSERT INTO `t_role_premission` VALUES ('20', 'manager', 'category:delete');
INSERT INTO `t_role_premission` VALUES ('21', 'manager', 'category:update');

-- ----------------------------
-- Table structure for t_store
-- ----------------------------
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store` (
  `Store_pkID` int(11) NOT NULL AUTO_INCREMENT,
  `Store_desStore` varchar(255) DEFAULT NULL,
  `Store_name` varchar(255) DEFAULT NULL,
  `Store_storageType` int(11) DEFAULT NULL,
  `Store_store` int(11) DEFAULT NULL,
  PRIMARY KEY (`Store_pkID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_store
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `user_phone` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `isRememberMe` bit(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('13', 'root', 'ff9830c42660c1dd1942844f8069b74a', '15720061118', '1114624206@qq.com', '\0');
INSERT INTO `t_user` VALUES ('16', '1', '6512bd43d9caa6e02c990b0a82652dca', '123213', '21312321', '\0');
INSERT INTO `t_user` VALUES ('19', '2', 'b6d767d2f8ed5d21a44b0e5886680cb9', '2', '2', '\0');
INSERT INTO `t_user` VALUES ('20', '3', '182be0c5cdcd5072bb1864cdee4d3d6e', '3', '3', '\0');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(30) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', 'root', 'manager');
INSERT INTO `t_user_role` VALUES ('2', '1', 'user');
INSERT INTO `t_user_role` VALUES ('3', '2', 'user');
INSERT INTO `t_user_role` VALUES ('4', '3', 'user');
