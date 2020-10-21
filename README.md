# gulimall
- gulimall-common 公共依赖
- gulimall-coupon 谷粒商城-优惠卷服务
- gulimall-gateway API网关
- gulimall-member 谷粒商城-会员服务
- gulimall-order 谷粒商城-订单服务
- gulimall-product 谷粒商城-商品服务
- gulimall-thrid-party 第三方服务
- gulimall-ware 谷粒商城-仓储服务





1. 如何使用Nacos作为配置中心统一管理配置

   - 如何使用Nacos作为配置中心统一管理配置

   - 引入依赖

     ```xml
     <dependency>
     	<groupId>com.alibaba.cloud</groupId>
     	<artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
     </dependency>
     ```

   - 创建一个bootstrap.properties

     ```yml
     spring.application.name=gulimall-coupon
     spring.cloud.nacos.config.server-addr=127.0.0.1:8848
     ```

   - 需要给配置中心默认添加一个叫 数据集（Data Id）gulimall-coupon.properties。默认规则，应用名.properties

   - 给 应用名.properties 添加任何配置

   - 动态获取配置

     @RefreshScope：动态获取并刷新配置

     @Value("${配置项的名}")：获取到配置。

     如果配置中心和当前应用的配置文件中都配置了相同的项，优先使用配置中心的配置。

2. 细节

   - 命名空间：配置隔离

     默认：public(保留空间)；默认新增的所有配置都在public空间

     开发，测试，生产：利用命名空间来做环境隔离。
             注意：在bootstrap.properties；配置上，需要使用哪个命名空间下的配置，
             spring.cloud.nacos.config.namespace=9de62e44-cd2a-4a82-bf5c-95878bd5e871

     每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置

   - 配置集：所有的配置的集合

   - 配置集ID：类似文件名

     Data ID：类似文件名

   - 配置分组：

     默认所有的配置集都属于：DEFAULT_GROUP；
     1111，618，1212

   项目中的使用：每个微服务创建自己的命名空间，使用配置分组区分环境，dev，test，prod

3. 同时加载多个配置集

   - 微服务任何配置信息，任何配置文件都可以放在配置中心中
   - 只需要在bootstrap.properties说明加载配置中心中哪些配置文件即可
   - @Value，@ConfigurationProperties。。。
   - 以前SpringBoot任何方法从配置文件中获取值，都能使用。配置中心有的优先使用配置中心中的



1. 整合MyBatis-Plus

   - 导入依赖

     ```xml
     <dependency>
     	<groupId>com.baomidou</groupId>
         <artifactId>mybatis-plus-boot-starter</artifactId>
         <version>3.2.0</version>
     </dependency>
     ```

   - 配置

     1. 配置数据源

        导入数据库的驱动。https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-versions.html
        在application.yml配置数据源相关信息

     2. 配置MyBatis-Plus

        使用@MapperScan
        告诉MyBatis-Plus，sql映射文件位置

2. 逻辑删除

   配置全局的逻辑删除规则（省略）
   配置逻辑删除的组件Bean（省略）
   给Bean加上逻辑删除注解@TableLogic

3. JSR303

   给Bean添加校验注解:javax.validation.constraints，并定义自己的message提示
   开启校验功能@Valid
   效果：校验错误以后会有默认的响应；
   给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
   分组校验（多场景的复杂校验）
    @NotBlank(message = "品牌名必须提交",groups = {AddGroup.class, UpdateGroup.class})
   给校验注解标注什么情况需要进行校验
   @Validated({AddGroup.class})
   默认没有指定分组的校验注解@NotBlank，在分组校验情况@Validated({AddGroup.class})下不生效，只会在@Validated生效；

   自定义校验
   编写一个自定义的校验注解
   编写一个自定义的校验器 ConstraintValidator
   关联自定义的校验器和自定义的校验注解

   ```java
   @Documented
   @Constraint(validatedBy = { ListValueConstraintValidator.class【可以指定多个不同的校验器，适配不同类型的校验】 })
   @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
   @Retention(RUNTIME)
   public @interface ListValue {}
   ```

4. 统一的异常处理

   @ControllerAdvice
   编写异常处理类，使用@ControllerAdvice。
   使用@ExceptionHandler标注方法可以处理的异常。