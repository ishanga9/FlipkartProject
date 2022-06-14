package useClasses;

import org.testng.annotations.Factory;


public class FactoryAnnotationUse {
	Object[] data;
	
 @Factory
  public Object[] f() {
	 
	 data =new Object[5];
	 for(int i=0;i<5;i++)
	 {
		 data[i]= new useClasses.Test_CheckLogin();
	 }
	 
	 return (Object[])data;
  }
}
