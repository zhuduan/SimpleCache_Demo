# SimpleCache_Demo
使用了AOP缓存插件 [SimpleCache_Annotation](https://github.com/zhuduan/SimpleCache_Annotation) 的Demo
细节请直接参考：
	- pom.xml
	- applicationxml
	- app.java
	

## 注意点
1. 由于Spring AOP的特点，缓存仅整针对public的方法生效
2. 因为采用的是CGLib的实现方式，所以需要在application.xml的配置中也选择cglib（如果有需要JDK动态代理的实现请私信，考虑做进一步实现）
3. 如果要在类内部使用缓存，由于代理模式的原因会造成缓存不生效，需要而外配置自身的Proxy对象，具体原因参考[AOP切面时BeanPostProcessor返回Bean未被CGlib代理](http://www.jianshu.com/p/f12e298f12fe)


## 最后
have fun~
