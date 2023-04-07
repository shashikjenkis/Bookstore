import org.testng.annotations.Test;

import com.demo.pages.CartPage;
import com.demo.pages.ProfilePage;

public class CartFlow  {

    ProfilePage profile =new ProfilePage();
    CartPage cart =new CartPage();

   //  @Test(priority = 1,description = "lanuch application and cart page")
   //  public void onClickCart() {

   //     profile.clickOnLogin(); 
   //     cart.clickOnCart();

   //  }
 
    // @Test(priority = 2,description = "check with empty cart")
    // public void emptyCartItem(){
    //     profile.clickOnLogin(); 
    //     cart.clickOnCart();
    //     cart.emptyCart();
    // }
    
    
    
   //   @Test(priority = 3,description = "add single iteam to cart")
   //   public void addSingleBook(){

   //      profile.clickOnLogin(); 
   //      cart.clickOnCart();
   //      cart.addIteam();
   //   }   

   //   @Test(priority = 4,description = "add qty of books")
   //   public void addMoreQty(){
   //    profile.clickOnLogin();
   //    cart.addQty();
   //   }

     @Test(priority = 5,description = "add rating to books")
     public void addReview(){
      profile.clickOnLogin();
      cart.reviewPage();
     }

}
