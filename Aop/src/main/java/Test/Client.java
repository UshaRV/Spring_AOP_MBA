package Test;

import org.springframework.aop.framework.ProxyFactoryBean;

import Business.Bank;
import Services.LogBeforeService;

public class Client {
	public static void main(String[] args) {
	//CREATE TARGET
	Bank b= new Bank();
	
	//CREATE ADVICE
	LogBeforeService lbs=new LogBeforeService();
	
	//ADD TARGET+ADVICE TO PROXY
	ProxyFactoryBean pfb = new ProxyFactoryBean();
	  pfb.setTarget(b);
	  pfb.addAdvice(lbs);
	  
	//get Generated Proxy Object
	  Bank bproxy=(Bank)pfb.getObject();
	  int amount =bproxy.deposit("sbi125694",5000);
	  System.out.println(amount);

}
}
