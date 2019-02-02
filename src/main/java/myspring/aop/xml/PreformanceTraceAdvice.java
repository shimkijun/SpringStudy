package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PreformanceTraceAdvice {

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result;
		//타겟 메서드의 signature 정보
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "시작");
		
		//타겟의 메서드가 호출되기 전의 시간
		long start =System.currentTimeMillis();
		try {
			result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString + "실행 시간 : " + (finish - start) + " ms");
		}
	}
	
}
