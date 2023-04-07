import org.testng.annotations.Test;
import com.demo.pages.ProfilePage;


public class ProfileFlow {

   ProfilePage profile =new ProfilePage();
    
   @Test(priority = 1 ,description = "lanuch the application")
   public void openProfile() {

    profile.clickOnLogin();
     profile.clickOnProfile();
   
    
  }
  
  @Test(priority = 2,description = "Update the profile with  vaild data")
  public void modifyprofile(){

    profile.clickOnLogin();
    profile.clickOnProfile();
    profile.updateProfile();
    
   
  }

  @Test(priority = 3,description = "update the profile without password")
  public void WithoutPassword(){

    profile.clickOnLogin();
    profile.clickOnProfile();
    profile.emptyPassword();
  }

  @Test(priority = 4,description = "password length is not macthed ")
  public void invaidPasswordCase(){

    profile.clickOnLogin();
    profile.clickOnProfile();
    profile.invaidPasswordFormat();
  }

  @Test(priority = 5,description = "check order deatis from profile page")
  public void profile_Order_deatils(){
    
    profile.clickOnLogin();
    profile.clickOnProfile();
    profile.orderDeatils();
  }
}
