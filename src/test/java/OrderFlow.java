
import org.testng.annotations.Test;


import com.demo.pages.OrderPage;
import com.demo.pages.SignupPage;



public class OrderFlow {
 
   OrderPage lanuchPage=new OrderPage();
   SignupPage signupPage = new SignupPage();



   @Test(description = "lanuch the application")
   public void endtoendFlow(){
    lanuchPage.lanuchBookStore();
    lanuchPage.clickOnSignIn();
   lanuchPage.addToCart();
   lanuchPage.checkout();
   lanuchPage.deleteadd();
   lanuchPage.addAddress();
 lanuchPage.payment();
   lanuchPage.orderPlace();
    
    
   }
  

   }
    

