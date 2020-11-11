package com.example.JPAParametersAreNonnullByDefault;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.JPAParametersAreNonnullByDefault.domain.SimpleModelRepository;
import com.example.JPAParametersAreNonnullByDefault.domain.SimpleModelRepository2;

@SpringBootTest
class JpaParametersAreNonnullByDefaultApplicationTests {

	@Autowired
	SimpleModelRepository simpleModelRepository;
	
	@Autowired
	SimpleModelRepository2 simpleModelRepository2;
	
	@Test
	void test_withoutAnnotation() {
		assertNull(simpleModelRepository.findTopByBusinessKey("this-businesskey-does-not-exist"));
	}
	
	@Test
	void test_withAnnotation() {
		assertNull(simpleModelRepository2.findTopByBusinessKey("this-businesskey-does-not-exist"));
		
		/*
		 * causes:
		 * 
		 * org.springframework.dao.EmptyResultDataAccessException: Result must not be null!
		 * at org.springframework.data.repository.core.support.MethodInvocationValidator.invoke(MethodInvocationValidator.java:102)
		 * at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
		 * at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212)
		 * at com.sun.proxy.$Proxy84.findTopByBusinessKey(Unknown Source)
		 * at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		 * at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
		 * at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		 * at java.lang.reflect.Method.invoke(Method.java:498)
		 * at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)
		 * at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:205)
		 * at com.sun.proxy.$Proxy86.findTopByBusinessKey(Unknown Source)
		 * at com.example.JPAParametersAreNonnullByDefault.JpaParametersAreNonnullByDefaultApplicationTests.test_withAnnotation(JpaParametersAreNonnullByDefaultApplicationTests.java:28)
		 * at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		 * at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
		 * at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		 * at java.lang.reflect.Method.invoke(Method.java:498)
		 * at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:686)
		 * at org.junit.jupiter.engine.execution.MethodInvocation.proceed(MethodInvocation.java:60)
		 * at org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:131)
		 * at org.junit.jupiter.engine.extension.TimeoutExtension.intercept(TimeoutExtension.java:149)
		 * at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestableMethod(TimeoutExtension.java:140)
		 * at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestMethod(TimeoutExtension.java:84)
		 * at org.junit.jupiter.engine.execution.ExecutableInvoker$ReflectiveInterceptorCall.lambda$ofVoidMethod$0(ExecutableInvoker.java:115)
		 * at org.junit.jupiter.engine.execution.ExecutableInvoker.lambda$invoke$0(ExecutableInvoker.java:105)
		 * at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:106)
		 * at org.junit.jupiter.engine.execution.InvocationInterceptorChain.proceed(InvocationInterceptorChain.java:64)
		 * at org.junit.jupiter.engine.execution.InvocationInterceptorChain.chainAndInvoke(InvocationInterceptorChain.java:45)
		 * at org.junit.jupiter.engine.execution.InvocationInterceptorChain.invoke(InvocationInterceptorChain.java:37)
		 * at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:104)
		 * at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:98)
		 * at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$6(TestMethodTestDescriptor.java:212)
		 * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
		 * at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:208)
		 * at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:137)
		 * at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:71)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:135)
		 * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
		 * at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
		 * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
		 * at java.util.ArrayList.forEach(ArrayList.java:1259)
		 * at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
		 * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
		 * at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
		 * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
		 * at java.util.ArrayList.forEach(ArrayList.java:1259)
		 * at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
		 * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
		 * at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
		 * at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
		 * at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
		 * at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
		 * at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
		 * at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
		 * at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:248)
		 * at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$5(DefaultLauncher.java:211)
		 * at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:226)
		 * at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:199)
		 * at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:132)
		 * at org.eclipse.jdt.internal.junit5.runner.JUnit5TestReference.run(JUnit5TestReference.java:86)
		 * at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
		 * at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)
		 * at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)
		 * at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)
		 * at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)
		 */
	}

}
