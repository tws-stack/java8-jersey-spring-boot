Gaia
==========

### 开发环境
- 确保开发环境下有jdk8，以及mysql 5.5+
- 使用下面的脚本,提前在mysql中建好数据库

```
DROP DATABASE IF EXISTS `gaia`; CREATE SCHEMA `gaia` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
```

- 使用`./gradlew cleanIdea idea`生成Intellij工程
- 使用`Intellij`打开生成的`gaia.ipr`文件
- 找到`GaiaApplication`这个类，运行`main()`方法启动服务器

### 测试服务器是否启动正常

- 检查启动中有无异常log
- 打开浏览器，访问<http://localhost:8080/gaia/rest/application.wadl>，看是否有API列表输出
- 打开浏览器，访问<http://localhost:8080/gaia/rest/product/1>，看是否返回包含`"errorCode":"RESOURCE_NOT_FOUND"`这样的出错信息
- 在数据库console中，使用后面的脚本在数据库中插入一条数据`insert into gaia.PRODUCT (`name`, `time_created`) values ('product_name', NOW());`
- 在数据库console中，使用`select * from gaia.PRODUCT`，查看是否已插入数据成功，并记下数据的`id`
- 加入上一步记下的`id`为`1`，打开浏览器，访问<http://localhost:8080/gaia/rest/product/1>
- 检查浏览器的返回是否是 `{"id":1,"name":"product_name","timeCreated":1474615151000}`，其中`timeCreated`对应的数字可能会略有不同

### 查看所有API 地址及请求所需方式、参数

- 中心服务器：<http://localhost:8080/gaia/rest/application.wadl>

*注意：更改localhost到你希望查看的服务器IP*
