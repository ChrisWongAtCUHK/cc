/*
 * Copyright 2002-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.interceptor;

import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.DerivedTestBean;
import org.springframework.beans.ITestBean;
import org.springframework.beans.TestBean;
import org.springframework.util.SerializationTestUtils;

/**
 * @author Juergen Hoeller
 * @since 06.04.2004
 */
public class ConcurrencyThrottleInterceptorTests extends TestCase {

	protected static final Log logger = LogFactory.getLog(ConcurrencyThrottleInterceptorTests.class);

	public static final int NR_OF_THREADS = 100;

	public static final int NR_OF_ITERATIONS = 1000;


	public void testSerializable() throws Exception {
		DerivedTestBean tb = new DerivedTestBean();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(new Class[] {ITestBean.class});
		ConcurrencyThrottleInterceptor cti = new ConcurrencyThrottleInterceptor();
		proxyFactory.addAdvice(cti);
		proxyFactory.setTarget(tb);
		ITestBean proxy = (ITestBean) proxyFactory.getProxy();
		proxy.getAge();

		ITestBean serializedProxy = (ITestBean) SerializationTestUtils.serializeAndDeserialize(proxy);
		Advised advised = (Advised) serializedProxy;
		ConcurrencyThrottleInterceptor serializedCti =
				(ConcurrencyThrottleInterceptor) advised.getAdvisors()[0].getAdvice();
		assertEquals(cti.getConcurrencyLimit(), serializedCti.getConcurrencyLimit());
		serializedProxy.getAge();
	}

	public void testMultipleThreadsWithLimit1() {
		testMultipleThreads(1);
	}

	public void testMultipleThreadsWithLimit10() {
		testMultipleThreads(10);
	}

	private void testMultipleThreads(int concurrencyLimit) {
		TestBean tb = new TestBean();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(new Class[] {ITestBean.class});
		ConcurrencyThrottleInterceptor cti = new ConcurrencyThrottleInterceptor();
		cti.setConcurrencyLimit(concurrencyLimit);
		proxyFactory.addAdvice(cti);
		proxyFactory.setTarget(tb);
		ITestBean proxy = (ITestBean) proxyFactory.getProxy();

		Thread[] threads = new Thread[NR_OF_THREADS];
		for (int i = 0; i < NR_OF_THREADS; i++) {
			threads[i] = new ConcurrencyTest(proxy, null);
			threads[i].start();
		}
		for (int i = 0; i < NR_OF_THREADS / 10; i++) {
			try {
				Thread.sleep(5);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			threads[i] = new ConcurrencyTest(proxy,
					i % 2 == 0 ? (Throwable) new OutOfMemoryError() : (Throwable) new IllegalStateException());
			threads[i].start();
		}
		for (int i = 0; i < NR_OF_THREADS; i++) {
			try {
				threads[i].join();
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}


	private static class ConcurrencyTest extends Thread {

		private ITestBean proxy;
		private Throwable ex;

		public ConcurrencyTest(ITestBean proxy, Throwable ex) {
			this.proxy = proxy;
			this.ex = ex;
		}

		public void run() {
			if (this.ex != null) {
				try {
					this.proxy.exceptional(this.ex);
				}
				catch (RuntimeException ex) {
					if (ex == this.ex) {
						logger.debug("Expected exception thrown", ex);
					}
					else {
						// should never happen
						ex.printStackTrace();
					}
				}
				catch (Error err) {
					if (err == this.ex) {
						logger.debug("Expected exception thrown", err);
					}
					else {
						// should never happen
						ex.printStackTrace();
					}
				}
				catch (Throwable ex) {
					// should never happen
					ex.printStackTrace();
				}
			}
			else {
				for (int i = 0; i < NR_OF_ITERATIONS; i++) {
					this.proxy.getName();
				}
			}
			logger.debug("finished");
		}
	}

}
