#Mbaobao-person-gen

目标是开发一套适用于麦包包的快速开发环境。减少复制+粘贴的过程。减少不必要的体力劳动。

目前还是个人使用

##项目组成

###1.web-archetype 一个简单的springmvc+mybatis搭建工程

    mvn archetype:generate -DarchetypeGroupId=com.mbaobao.gen  -DarchetypeArtifactId=web-archetype -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=<groupId> -DartifactId=<artifactId>

###2.table2bean 直接根据数据库(目前只支持mysql) schemal导处java bean\java dao\mybatis mapper

    测试函数：com.mbaoabo.test.MyBatisGeneratorTest

配置文件:config.properties

    gen.jdbc.default.driver=com.mysql.jdbc.Driver
    gen.jdbc.default.url=jdbc:mysql://127.0.0.1/test
    gen.jdbc.default.username=root
    gen.jdbc.default.password=
    
    gen.java.path=/home/fred/dev/development/java/gen_mbaobao/table2bean/src/test/java
    gen.java.path.bean=com.mbaoabo.test.bean
    gen.java.path.dao=com.mbaoabo.test.dao
    
    gen.resource.path=/home/fred/dev/development/java/gen_mbaobao/table2bean/src/test/resources
    gen.resource.path.mapper=mapper
    
    gen.mapping=ac_user:User


###3.maven-tabl2bean-plugins 对table2bean的封装


####1.添加pom

    	<plugins>
			<plugin>
				<groupId>com.mbaobao.plugins</groupId>
				<artifactId>maven-table2bean-plugin</artifactId>
				<version>1.0-SNAPSHOT</version>
			</plugin>
		</plugins>

####2.执行命令

    mvn table2bean:gen

