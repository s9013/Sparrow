##Sparrow
  	麻雀虽小 五脏俱全 技术集成

##技术简介
#前台
	Angularjs
	Requirejs
	各种插件

#后台
	Spring boot
	Spring MVC
	
#数据库
	Monogdb

#项目构建工具
	Maven
	
#版本控制工具
	Git
	

##################
##Spring data mongodb

##Mongodb的安装

	http://docs.mongodb.org/manual/tutorial/install-mongodb-on-windows/
	https://fastdl.mongodb.org/win32/mongodb-win32-x86_64-2008plus-ssl-3.0.3-signed.msi
	作为一个服务
	
	安装mongodb
	在bin的同一个路径下创建data文件夹
	在data文件夹下创建db log两个文件夹
	
	mongod --dbpath "D:\dev\mongodb\data\db" --logpath "D:\dev\mongodb\data\log\MongoDB.log" --install --serviceName "MongoDB"
	
	客户端 Robomongo

	不能注入的问题
	解决方法
	http://www.blogjava.net/wangxinsh55/archive/2012/03/29/372994.html
	
	<!-- mongodb bean的仓库目录，会自动扫描扩展了MongoRepository接口的接口进行注入 -->
	<mongo:repositories base-package="com.sparrow.repository" />


##如何加入日志和异常 有问题

	@ControllerAdvice
	@ExceptionHandler
	url请求时才有用
		<context:component-scan base-package="com.sparrow" use-default-filters="false">
				<!-- 扫描符合@Controller @Service @Repository的类 -->
				<context:include-filter expression="org.springframework.stereotype.Controller" type="annotation" />
				<context:include-filter expression="org.springframework.web.bind.annotation.ControllerAdvice" type="annotation"/>  
				<context:include-filter type="annotation" expression="org.springframework.stereotype.Service" />
				<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository" />
		</context:component-scan>
	没作用
	spring组件扫描<context:component-scan/>使用详解
	http://blog.csdn.net/longeremmy/article/details/8183621
	还是没看懂 不起作用

	自定义异常 全部往外抛 在AdviceController handleException 处理异常 修改status code


##AOP
	http://blog.chinaunix.net/uid-26959955-id-3275282.html
	logback
	http://blog.csdn.net/haidage/article/details/6794509
	http://www.cnblogs.com/-bumblebee-/archive/2012/03/29/2423408.html
	http://www.blogjava.net/justfly/archive/2014/08/10/416768.html
	
	1.XML 配置<aop:aspectj-autoproxy/>
	2.注解 @EnableAspectJAutoProxy
	
	spring doc
	http://docs.spring.io/spring/docs/current/spring-framework-reference/html/aop.html#aop-aspectj-programmatic
	
	@Component
	@Aspect
	public class LogAspect {
		
		@Before("execution(* com.sparrow.controller.*.*(..))")
		public void beforeController() {
			System.out.println("before controller.");
		}
	
		@After(value = "execution(* com.sparrow.controller.*.*(..))")
		public void afterController() {
			System.out.println("after controller.");
		}
	}

	execution(* * cn.com.spring.service.impl.*.*(..))
	1)* 所有的修饰符
	2)* 所有的返回类型
	3)* 所有的类名
	4)* 所有的方法名
	5)* ..所有的参数名
	
	
##日志
[logback](http://logback.qos.ch/)

	  logback 位置
	  <?xml version="1.0" encoding="UTF-8"?>
		<configuration scan="true" scanPeriod="30 seconds">
		
			<appender name="console" class="ch.qos.logback.core.ConsoleAppender">
				<encoder>
					<pattern>%d  %-5level %logger{1} - %msg%n</pattern>
				</encoder>
			</appender>
		
			<root level="info">
				<appender-ref ref="console" />
			</root>
			
		</configuration>	

##新增随机数util

##配置文件
	application.properties 修改
		server.tomcat.uri-encoding=UTF-8
		server.port=8888
	  	server.context-path=/sparrow
  
  
  
##restTemplate
	http://www.aichengxu.com/view/44867

## PropertySource
	http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html


##SMS 配置文件
	发送短信


##mongodb高级
	排序 多条件查询
	Query query = new Query();
    query.with(new Sort(Sort.Direction.DESC,"date"));
    List<Article> list = mongoTemplate.find(query, Article.class);

	Query query = new Query();
	query.skip((pageNumber-1)*pageSize);
	query.limit(pageSize);
	List<Article> list = mongoTemplate.find(query, Article.class);
	
	
##http协议了解
	 headers = "Accept =application/json, text/plain,version=1.0" 没有version
	 
	 http://www.blogjava.net/zjusuyong/articles/304788.html
 
## spring mvc 测试
	写前端ajax请求
	MockMvc

	``` java
	@RunWith(SpringJUnit4ClassRunner.class)
	@WebAppConfiguration
	@SpringApplicationConfiguration(classes = Application.class)
	//@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext-webmvc-config.xml"})
	public class ArticleControllerTest {
		
		@Autowired
		private WebApplicationContext wac;
		
		private MockMvc mockMvc;
		``
		@Before
		public void setUp() {
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		}
		
		
		@Test
		public void testGetArtilces() {
			try {
				mockMvc.perform(get("/api/article/getArticles")).andExpect(status().isOk());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void testGetArticleById() throws Exception {
			ResultActions  r = mockMvc.perform(get("/api/article/getArticleById").param("id", "55655a86bea2a17ddba295ae"));//.andExpect(status().isOk());
			System.out.println(r);
		}
	
	}
	``` 
 
## web.xml 不知道怎么配
	logback

## 富文本

[ckeditor](http://ckeditor.com/)	


##分页
https://github.com/angular-ui
http://angular-ui.github.io/bootstrap/

引进ui-bootstrap js
html
		<div class="pull-right">
				<pagination boundary-links="true" total-items="totalItems"
					ng-model="currentPage" previous-text="&lsaquo;" next-text="&rsaquo;"  ng-click="pageChanged()" max-size="maxSize" items-per-page ="itemsPerPage"
					first-text="&laquo;" last-text="&raquo;"></pagination>
			</div>
			
js

	//$scope.currentPage = 0;
			$scope.maxSize = 5;
			$scope.itemsPerPage = 9;
			
			httpService.querywithParams('get','api/article/getArticles',{page:1,size:$scope.itemsPerPage}).then(function(data){
				console.log(data);
				$scope.articles= data.data;
				$scope.totalItems = data.totalItems;
			});

			$scope.trust = function(html){
				return $sce.trustAsHtml(html);
			};

			/*$scope.setPage = function (pageNo) {
			    $scope.currentPage = pageNo;
			};*/

			// 分页
			$scope.pageChanged = function() {
				console.log($scope.currentPage);
			    $log.log('Page changed to: ' + $scope.currentPage);
			    httpService.querywithParams('get','api/article/getArticles',{page:$scope.currentPage,size:$scope.itemsPerPage}).then(function(data){
			    	console.log(data);
					$scope.articles= data.data;
					$scope.totalItems = data.totalItems;
				});
		    };
	
	
## tomcat 中不能启动
	
	http://www.tuicool.com/articles/jqAJ73f 
	加入tomcat 版本
		
	http://blog.csdn.net/java85140031/article/details/12944295
	web 版本
	
	还是不行
	
##mongodb文件上传
	package com.sparrow.util;

	import java.io.IOException;
	
	import org.bson.types.ObjectId;
	
	import com.mongodb.DB;
	import com.mongodb.Mongo;
	import com.mongodb.gridfs.GridFS;
	import com.mongodb.gridfs.GridFSDBFile;
	
	/**
	 * File util
	 * @author 		Jay
	 * @time		2015年6月3日
	 */
	public class FileUtil {
	
	public static void main(String[] args) throws IOException {
		Mongo mongo = new Mongo();  
		    DB db = mongo.getDB("SparrowDB");   //创建数据库连接  
		    GridFS myFS = new GridFS(db,"File"); //创建GridFS   对mongoDBFile数据库中的user1进行操作，这样文件的读取和删除都是user1中的文件  
		      
		    //保存文件  
		   // GridFSFile file = myFS.createFile(new File("D:/test.jpg"));  
		   // file.save();
		      
		    //输出文件  
		   //GridFSDBFile file =myFS.findOne("test.jpg"); 
		   // file.writeTo(new File("D:/image1.jpg")); 
		      
		     //删除文件  
		    GridFSDBFile file =myFS.findOne("test.jpg"); 
		    myFS.remove((ObjectId) file.getId());
		}
		
		 
	}

	
	

----------
	上传下载



	
	