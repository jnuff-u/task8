# task8



 **RmiClient**
>客户端，web项目

```

<bean id="studentServer" class="org.springframework.remoting.rmi.RmiProxyFactoryBean" lazy-init="true" >
    <property name="serviceInterface" value="com.stu.service.StudentService"/>
    <property name="serviceUrl" value="rmi://47.98.50.21:1099/studentService"/>
</bean>

<bean id="userService" class="org.springframework.remoting.rmi.RmiProxyFactoryBean" lazy-init="true" >
    <property name="serviceInterface" value="com.stu.service.UserService"/>
    <property name="serviceUrl" value="rmi://47.98.50.21:1098/userService"/>
</bean>

<bean id="studentServerB" class="org.springframework.remoting.rmi.RmiProxyFactoryBean" lazy-init="true" >
    <property name="serviceInterface" value="com.stu.service.StudentService"/>
    <property name="serviceUrl" value="rmi://119.29.17.188:1099/studentServiceB"/>
</bean>

<bean id="userServiceB" class="org.springframework.remoting.rmi.RmiProxyFactoryBean" lazy-init="true" >
    <property name="serviceInterface" value="com.stu.service.UserService"/>
    <property name="serviceUrl" value="rmi://119.29.17.188:1098/userServiceB"/>
</bean>
```

**StuServer**
>student服务端 远程服务
```
<!--student 远程服务 端口-->
<bean id="studentService" class="org.springframework.remoting.rmi.RmiServiceExporter">
        <property name="serviceName" value="studentServiceB"/>
        <property name="service" ref="studentServiceImpl"/>
        <property name="serviceInterface" value="com.stu.service.StudentService"/>
        <property name="registryPort" value="1099" />
        <property name="servicePort" value="1089" />
    </bean>
```

**UserServer**
>user服务端 远程服务

```
<!--user 远程服务端口-->
<bean id="userService" class="org.springframework.remoting.rmi.RmiServiceExporter" >
        <property name="serviceName" value="userServiceB"/>
        <property name="service" ref="userServiceImpl"/>
        <property name="serviceInterface" value="com.stu.service.UserService"/>
        <property name="registryPort" value="1098"/>
        <property name="servicePort" value="1088" />
    </bean>
```

