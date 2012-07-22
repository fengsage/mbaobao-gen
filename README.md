#Mbaobao-person-gen

目标是开发一套适用于麦包包的快速开发环境。减少复制+粘贴的过程。减少不必要的体力劳动。

目前还是个人使用

##项目组成

###1.web-archetype 一个简单的springmvc+mybatis搭建工程

    mvn archetype:generate -DarchetypeGroupId=com.mbaobao.gen  -DarchetypeArtifactId=web-archetype -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=com.mbaobao.vip -DartifactId=demo

###2.table2bean 直接根据数据库(目前只支持mysql) schemal导处java bean\java dao\mybatis mapper

    目前还未完善.只能从main函数启动创建代码，后期使用maven plugin形式
    启动函数：com.mbaobao.gen.GenMain

配置文件:config.properties

    #数据库配置-必填
    prop.jdbc.default.driver=com.mysql.jdbc.Driver
    prop.jdbc.default.url=jdbc:mysql://127.0.0.1/test
    prop.jdbc.default.username=root
    prop.jdbc.default.password=

    #环境配置-默认以classpath生成
    gen.java.path=/home/fred/dev/development/java/gen_mbaobao/table2bean/src/test/java
    gen.java.package=com.mbaoabo.test
    gen.package.entity=com.mbaoabo.test.bean
    gen.package.dao=com.mbaoabo.test.dao
    gen.package.mapper=mapper
    gen.resources.path=/home/fred/dev/development/java/gen_mbaobao/table2bean/src/test/resources
    gen.author=kuci@mbaobao.com
    #表和对象映射关系，多表用,分割。 [表名]:[对象名]
    gen.mapping=ac_user:User



