# 人事管理系统
## 环境搭配
### idea、mysql8.0.X、tomcat9.0.31
本项目有使用SSM（spring+SpringMVC+Mybatis）版本的，联系即可获得
视频预览，一个朋友帮我写的，[地址]:https://www.bilibili.com/video/BV1MK4y1x7sv "bilibili"

索引目录安装在web/pages目录下
#### administration 人事管理
添加部门  addDepa.jsp </br>
部门管理  depaList.jsp</br>
岗位管理  暂时无更新</br>
添加员工  addEmp.jsp</br>
员工管理  empList.jsp</br>
empUpdate.jsp 更新员工信息</br>
#### administration 人事管理
#### attendance 考勤管理
#### expense 报销管理
#### include 放一些常使用页面
#### income 收支管理
incomestatistics 收入统计</br>
paystatistics 支出统计</br>
#### personal 个人名台

#### 密码
密码默认是123456，时间长了，忘了编辑文档了🤡
可以修改一下密码
```java
import org.apache.shiro.crypto.hash.Md5Hash;
//可以自己写一个测试方法
        String password = "123456";
        Md5Hash md5Hash = new Md5Hash(password, "hu", 2);
        System.out.println(md5Hash);
```
支持一下吧！

<img src="https://z3.ax1x.com/2021/06/11/2h6EWR.jpg" alt="支付宝" style="zoom:25%;"/>
<img src="https://z3.ax1x.com/2021/06/11/2h6AY9.jpg" alt="微信" style="zoom:25%;"/>
<img src="https://z3.ax1x.com/2021/06/11/2h6kFJ.jpg" alt="QQ"  style="zoom:25%;" />
