# Registration_Selenium
Selenium Framework project using Java,Maven,TestNG and POM
and i'm using DDT framework in the project 

Tech StacK:
Java
Maven
TestNG
DDT

1-First Package is called "Pages" include Each page to find it's web elements

2-Second Package is Called "tests" include test cases 
"UserRegisterationTestDDT_Excel" : 
  1-Method 1 :  test registration flow by DDT from "UserData.xlsx" Excel File 
  2-Method 2:   test that dublicated Emails can't signup using the same user data which recently SignedUP
"UserRegisterationwithSmallLetters":check that first name or last name with small letters can't sign up  

3-third Package is called Utilites : it contains Helper class that have ScrrenShot Capture Class
And SignUpAPIRequest : that sends the API Request And save the Response In Text file under Data Package


There is Issues Like 
1-First Name Can be signed up with small letter
2-Last Name can  start with small letter
3-First name and Last Name coul be the same

Hint: Login TestCase wasn't required i planned it to check login before includ login process  to the Registeration Flow 

Thanks...

