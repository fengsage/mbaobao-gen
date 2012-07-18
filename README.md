mbaobao-gen
===========

目标是开发一套适用于麦包包的快速开发环境。减少复制+粘贴的过程。减少不必要的体力劳动。

项目组成
-------

* web-archetype 一个简单的springmvc+mybatis搭建工程。

    mvn archetype:generate \
      -DarchetypeGroupId=com.mbaobao \
      -DarchetypeArtifactId=web-archetype \
      -DarchetypeVersion=1.0-SNAPSHOT  \
      -DgroupId=com.mbaobao.vip  \
      -DartifactId=demo-demo


