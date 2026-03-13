### 基于SpringBoot + Vue的药房在线开单销售管理系统.

医药ERP、智慧药店HIS、药品进销存、在线购药平台。

##### 管理员：
公告管理、药品管理、库存统计、物流信息、订单详情、订单评价、订单信息、缴费记录、药店管理、药店库存、员工管理、用户管理、数据统计、销售排行、员工统计、管理员管理、供应采购、供应商管理、电子处方、药品采购、库房预警、销售统计、采购物流

##### 用户：
我的信息、个人信息、我的订单、缴费记录、订单评价、药品购买、支付结果、药品处方

##### 药店医生：
店内管理、电子处方、库存统计、订单物流、订单管理、订单评价、店内库存、员工管理

##### 基础档案管理
###### 用户/管理员管理： 实现多角色权限分配，精细化管理系统使用者及其操作权限。

###### 员工/药店管理： 记录药店资质及员工档案，支持跨门店的人员调度与绩效查看。

###### 供应商管理： 维护合作伙伴信息，确保药品来源可追溯及采购渠道稳定。

##### 药品与库存控制
###### 药品/药店库存： 实时监控各门店药品存量，确保进销存数据同步与库存透明。

###### 库房预警： 当药品达到库存临界点时自动提醒，防止缺货或药耗过期。

###### 供应采购： 整合采购计划与供应商对接，实现从需求申请到入库的全流程。

##### 销售与订单处理
###### 药品购买/支付： 用户在线下单并完成结算，系统生成凭证并自动触发订单。

###### 订单/物流信息： 全程追踪订单状态与物流流转，确保药品准时、安全交付。

###### 订单评价： 收集用户真实反馈，作为药店服务提升与药品质量优化的参考。

##### 处方与医疗服务
###### 电子处方： 实现医生在线开具或审核处方，确保处方药销售合规、严谨。

###### 药品处方： 用户在线提交个人处方需求，由药店医生进行核验与配药处理。

##### 财务与数据分析
###### 缴费记录： 自动留存每笔交易收支流水，方便财务审计与用户报销查询。

###### 销售/统计排行： 通过可视化报表分析热销产品，为药店经营决策提供数据支撑。

###### 数据/员工统计： 综合考量门店业绩与员工工作量，量化考核指标，提升人效。

#### 安装环境

JAVA 环境 

Node.js环境 [https://nodejs.org/en/] 选择14.17

Yarn 打开cmd， 输入npm install -g yarn !!!必须安装完毕nodejs

Mysql 数据库 [https://blog.csdn.net/qq_40303031/article/details/88935262] 一定要把账户和密码记住

redis

Idea 编译器 [https://blog.csdn.net/weixin_44505194/article/details/104452880]

WebStorm OR VScode 编译器 [https://www.jianshu.com/p/d63b5bae9dff]

#### 采用技术及功能

后端：SpringBoot、MybatisPlus、MySQL、Redis、
前端：Vue、Apex、Antd、Axios

平台前端：vue(框架) + vuex(全局缓存) + rue-router(路由) + axios(请求插件) + apex(图表)  + antd-ui(ui组件)

平台后台：springboot(框架) + redis(缓存中间件) + shiro(权限中间件) + mybatisplus(orm) + restful风格接口 + mysql(数据库)

开发环境：windows10 or windows7 ， vscode or webstorm ， idea + lambok

#### 前台启动方式
安装所需文件 yarn install 
运行 yarn run dev

#### 默认后台账户密码
[管理员]
admin
1234qwer

[用户]
fank
1234qwer

[药店医生]
fkkk
1234qwer
#### 项目截图

|  |  |
|---------------------|---------------------|
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727393476.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727550883.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727384092.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727521780.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727371419.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727514515.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727332742.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727506587.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727691571.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727495250.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727680883.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727487174.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727649083.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727473995.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727631042.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727456465.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727606844.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727444948.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727591795.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727437077.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727583084.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727418948.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727574101.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727410852.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727567429.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1736727403702.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/work/936e9baf53eb9a217af4f89c616dc19.png) |


#### 演示视频

暂无

#### 获取方式

Email: fan1ke2ke@gmail.com

WeChat: `Storm_Berserker`

`附带部署与讲解服务，因为要恰饭资源非免费，伸手党勿扰，谢谢理解😭`

> 1.项目纯原创，不做二手贩子 2.一次购买终身有效 3.项目讲解持续到答辩结束 4.非常负责的答辩指导 5.**黑奴价格**

> 项目部署调试不好包退！功能逻辑没讲明白包退！

#### 其它资源

[2025年-答辩顺利通过-客户评价🍜](https://berserker287.github.io/2025/06/18/2025%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2024年-答辩顺利通过-客户评价👻](https://berserker287.github.io/2024/06/06/2024%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2023年-答辩顺利通过-客户评价🐢](https://berserker287.github.io/2023/06/14/2023%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2022年-答辩通过率100%-客户评价🐣](https://berserker287.github.io/2022/05/25/%E9%A1%B9%E7%9B%AE%E4%BA%A4%E6%98%93%E8%AE%B0%E5%BD%95/)

[毕业答辩导师提问的高频问题](https://berserker287.github.io/2023/06/13/%E6%AF%95%E4%B8%9A%E7%AD%94%E8%BE%A9%E5%AF%BC%E5%B8%88%E6%8F%90%E9%97%AE%E7%9A%84%E9%AB%98%E9%A2%91%E9%97%AE%E9%A2%98/)

[50个高频答辩问题-技术篇](https://berserker287.github.io/2023/06/13/50%E4%B8%AA%E9%AB%98%E9%A2%91%E7%AD%94%E8%BE%A9%E9%97%AE%E9%A2%98-%E6%8A%80%E6%9C%AF%E7%AF%87/)

[计算机毕设答辩时都会问到哪些问题？](https://www.zhihu.com/question/31020988)

[计算机专业毕业答辩小tips](https://zhuanlan.zhihu.com/p/145911029)

#### 接JAVAWEB毕设，纯原创，价格公道，诚信第一

`网站建设、小程序、H5、APP、各种系统 选题+开题报告+任务书+程序定制+安装调试+项目讲解+论文+答辩PPT`

More info: [悲伤的橘子树](https://berserker287.github.io/)

<p><img align="center" src="https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/%E5%90%88%E4%BD%9C%E7%89%A9%E6%96%99%E6%A0%B7%E5%BC%8F%20(3).png" alt="fankekeke" /></p>
