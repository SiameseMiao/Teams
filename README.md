# Teams
create project
maven创建org.apache.maven.archetypes:maven-archtype-webapp项目
然后把download的src和pom.xml复制过去
启动redis.server服务
就可以运行项目了。
小组成员一共五名：刘畅、庄莉，陈杰、郑春雨、杨越
我们的分工大概是：
刘畅：架构，RBAC权限模型，整合代码；
庄莉：实现树形结构设计、开发、展示，级联删除，多表关联、分页，模糊查询、联合查询
陈杰：文件上传与下载以及相应页面整合。
郑春雨：数据字典部分，admin下前端页面
杨越：RBAC权限模型的补充，改造user前端页面

数据库：MySQL
数据库名：sshtutorial
数据库连接名：root
数据库密码：123456

全都涉及到Java数据类型与数据库类型的关系

郑春雨
github账号：Zhengchunyu2016012011学号：2016012011
数据字典――排序
进入数据字典管理页面，按数据字典名称以及排序顺序排列。
编辑更改排序值，改变排序。
添加数据字典，自动保存同数据字典名称下最大排序值。
在搜索框输入字典名称，搜索结果按排序顺序显示。
点击“启用”“禁用”更改状态。
dict.html：（Dict.java、DictDao.java、DictService.java、DictServiceImpl.java、DictController.java）
数据字典后台管理界面
该界面主要由两部分组成，网页顶部导航栏，以及网页的主体内容部分；导航栏的部分主要是由左部的其他管理界面的链接构成，右部是由一个搜索框以及一个搜索按钮构成；页面的主体部分是由一个表格组成，用来存放后台传来的数据库数据字典的内容。后台管理人员可以通过在该页面添加、编辑、删除来对数据字典进行管理，点击添加以及编辑按钮时会出现弹出窗口，点击编辑时该条记录的原本内容也会出现在弹窗内，管理人员可以通过更改该条记录的某个属性的值对其进行更新。
文章管理后台界面
该界面主要由网页顶部导航栏、网页的主体内容部分以及底部的记录部分组成；导航栏的部分主要是由左部的其他管理界面的链接构成，右部是由一个搜索框以及一个搜索按钮构成，管理人员可以通过搜索级别ID来搜索需要的内容；记录部分主要是显示记录的条数以及页数；页面的主体部分是由一个表格组成，用来存放后台传来的数据库文章状态的内容。后台管理人员可以通过在该页面编辑、删除来对其进行管理，点击编辑按钮时会跳转进入竞赛文章的编辑页面，用户可以通过该页面对文章的标题、内容以及文件进行编辑更改。
栏目管理后台界面
该界面主要由网页顶部导航栏，以及网页的主体内容部分两个部分组成；导航栏的部分主要是其他管理界面的链接构成，页面的主体部分是由一个表格组成，用来存放后台传来的数据库ID、父ID等内容。后台管理人员可以通过在该页面添加、添加文章、编辑、删除来对栏目内容进行管理，栏目内容分为两级，添加、编辑会出现弹出窗口，点击一级的添加，根据用户填写的内容会添加一个属于它的二级内容，点击编辑时该条记录的原本内容也会出现在弹窗内，管理人员可以通过更改该条记录的某个属性的值对其进行更新。点击二级的添加竞赛，就会进入新建竞赛界面，管理人员可以通过输入想要的内容添加文章。
用户管理后台界面
该界面主要由网页顶部导航栏，以及网页的主体内容部分两部分组成；导航栏的部分主要是由左部的其他管理界面的链接构成，右部是由一个搜索框以及一个搜索按钮构成，管理人员可以通过其来搜索需要的内容；页面的主体部分是由一个表格组成，用来存放后台传来的数据库的用户个人信息的内容。后台管理人员可以通过在该页面点击添加、编辑、删除来对用户进行管理，点击编辑时该条记录的原本内容也会出现在弹窗内，管理人员可以通过更改该条记录的某个属性的值对其进行更新。
资源存储后台管理界面
该界面主要由网页顶部导航栏，以及网页的主体内容部分两部分组成；导航栏的部分主要是由其他管理界面的链接构成，页面的主体部分是由一个表格组成，用来存放后台传来的数据库的信息的内容。后台管理人员可以通过在该页面点击编辑、删除来对用户进行管理，点击编辑时该条记录的原本内容也会出现在弹窗内，管理人员可以通过更改该条记录的某个属性的值对其进行更新。
新添文章页面
该界面主要由网页顶部导航栏，以及网页的主体内容部分两部分组成；导航栏的部分主要是由其他管理界面的链接构成，页面的主体部分是由一个Form表单组成，管理人员可在该页面输入信息添加竞赛的文章内容进行提交。 

庄莉
 github账号：SiameseMiao  idea注释名：Siamese_miao  学号：2016012034
栏目管理――使用父id实现树形结构设计、开发、展示，级联删除
进入栏目管理页面。
表格按一二级别区别显示，二级栏目开头带“|-”符号（编辑修改二级栏目名称时请删除该符号）。一级栏目下显示其所有二级栏目。
一级类别添加点击表头粗体“添加”，父id为虚id“0”（自动显示无需输入）。
二级类别添加点击对应一级类别后的“添加”，父id为该一级类别id（自动显示无法修改）。
二级类别后“添加竞赛”为该类别下竞赛（上传文件为可选项）。
点击“禁用”，该类别状态改为“禁用”，无法添加子类或竞赛，并删除该类别下所有子类别以及相关竞赛（包括随带附件）。
点击“启用”，该类别状态改为“启用”，可以添加子类或竞赛。
点击“删除”，删除该类别以及其所有子类与相关竞赛（包括随带附件）。
columnManage.html:（Category.java、CategoryDao.java、CategoryService.java、CategoryServiceImpl.java、CategoryController.java）
文章管理——多表关联、分页
进入文章管理页面，按更新时间倒序分页显示（因数据较少使用每页条数为2）。
级别id外键链接栏目二级类别，在栏目管理添加竞赛处自动生成。
点击“正在进行”“已结束”更改文章状态。
点击“删除”删除文章并删除其所带附件。
搜索框输入级别id可搜索相同级别id下的文章分页显示。
articleManage.html、articleNew.html:（Competition.java、CompetitionDao.java、CompetitionService.java、CompetitionServiceImpl.java、CompetitionController.java）
主页——模糊查询
主页分类为“启用”状态下的第一级别分类。
主页搜索框搜索竞赛名称或内容带有关键词字样的竞赛。
index.html、searchPage.html:（ArticleController.java、SearchController.java）
类别页——模糊查询、多表关联、联合查询
由主页点击某一类别进入类别页，显示该类别下所有竞赛（该类别下所有子类下的全部竞赛）。
左边菜单栏显示该类别“启用”状态下的所有子类别。
该页面搜索框搜索该类别下所有竞赛名称带有关键词字样的竞赛。
categoriesPage.html: （SearchController.java）
竞赛页——模糊查询、分页
由类别页菜单栏选择级别进入竞赛页，该类该级别下的竞赛分页显示。
该页面搜索框搜索该类该级别下竞赛名称带有关键词字样的竞赛。
competitionPage.html：（SearchController.java）
详情页——多表关联
在类别页或竞赛页或搜索页点击竞赛名称进入竞赛详情页。
该页面显示竞赛具体内容与所带资源。
mainContainer.html：（SearchController.java）

陈杰
 github账号：CJFQT123   idea注释名：cj      学号：2016012099
资源存储路径―实现文件的上传下载
进入栏目管理页面
选择需要添加的竞赛的分类，编辑标题和内容后，选择对应的竞赛文件，点击提交即可上传。该文件的地址将存进数据库，而文件被存放在特定的地址而非项目里，这里我们选择在D盘建立一个SSH-FILE文件夹用来存储文件。
进入主页
在主页下选择要查找的竞赛类别，进入相关类别后，点击要查看的竞赛，再点击要下载的附件即可查看相关竞赛文件。
进入资源存储路径页面
在此页面可以删除竞赛文件路径，点击编辑后可以修改竞赛文件的名称和地址
相关代码：
UploadController，ResourceStore，StoreDao，StoreService，StoreServicelmpl和CompetitionController的上传功能相关代码
杨越
 github账号：YangYue2016012069   学号：2016012069
实现类UserService、RolePremissionServiceImpl、UserRoleServiceImpl、UserServiceImpl还有对一些前台页面的整合
刘畅
 github账号：liuc144 学号：2016012040
数据库的role、premission、user、userRole,rolePremission、等所有表的设计
对应的 entity的设计
以及radisCache的补充，权限模型框架的搭建
整个项目的架构，前台+后台
