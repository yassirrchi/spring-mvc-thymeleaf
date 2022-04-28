Pagination / Search / Deletion


![1](https://user-images.githubusercontent.com/65183563/162337105-0b14e5d7-c4e2-4abd-8f37-f5c5428d3c6c.gif)

Connecting Mysql to the project (+mysql dependency check pom.xml)

![2](https://user-images.githubusercontent.com/65183563/162337672-909af7d1-573c-46af-b48d-1a1f673e8f59.gif)

get a json as a response

![3](https://user-images.githubusercontent.com/65183563/162337818-a0c870b1-993e-4427-9fb5-28a1cb25bf7a.gif)

form validators using Spring Boot Starter Validation

![validator](https://user-images.githubusercontent.com/65183563/164327239-01fbc5ff-becb-435b-9dc5-478725a9f8ed.gif)

Adding a new patient

![add](https://user-images.githubusercontent.com/65183563/164327201-5c2b6133-cb52-40b7-8661-138283220591.gif)

Editing a patient

![update](https://user-images.githubusercontent.com/65183563/164327214-b4f17e60-21bc-4334-bf6e-384ee1c3cbc4.gif)

Login in as a user with basic privileges

![user](https://user-images.githubusercontent.com/65183563/164981134-68397baa-44c4-4626-a1e6-be5818d08c35.gif)

Login in as an admin with admin privileges

![admin](https://user-images.githubusercontent.com/65183563/164981141-6d061d2f-d66c-412b-8efb-d47df5bb31ba.gif)

Users and their roles 

![1](https://user-images.githubusercontent.com/65183563/164981373-2a7becee-812e-4ff6-be96-24df2e9eb234.PNG)

-i used the first method (commented code) which is the inMemoryAuth 
and the second method which is jdbc using the same database (mysql patint_db) that we've used before.
-i changed controllers path from raw to /admin/example and /user/example to manage roles easily in configure(HttpSecurity http)


![2](https://user-images.githubusercontent.com/65183563/164981842-cf3511a1-b2ad-40bd-80c1-2cac2ad19c57.PNG)


we created 3 more tables to authenticate users with jdbc

![4](https://user-images.githubusercontent.com/65183563/164981905-b9dc885d-4a25-4e37-a060-01fad0633cab.PNG)

i filled these tables with

![4](https://user-images.githubusercontent.com/65183563/164981961-5a4c0947-427a-433f-aa7d-329bf18e64e3.PNG)

![5](https://user-images.githubusercontent.com/65183563/164981938-cf5b8746-79c3-4ffb-a770-f5b2c4d4bae9.PNG)

![6](https://user-images.githubusercontent.com/65183563/164981943-ede9c824-1341-419f-bb6e-e4eecd2b93bd.PNG)

![7](https://user-images.githubusercontent.com/65183563/164981953-94ffda8a-6a81-4163-9112-f388252d374d.PNG)

in this part we are moving from jdbc verification to UserDetails

![2](https://user-images.githubusercontent.com/65183563/165654289-8dbd7558-c565-4e7c-a669-d6379a337029.PNG)

![3](https://user-images.githubusercontent.com/65183563/165654343-d72b1d62-a7a3-4a75-ba07-20200d77d59c.PNG)

and then, inserting another user for testing nammed "yassirrchi" identified by 1234 as a password with admin/user privileges, to the genrated table app_users that we've seen previously

![1](https://user-images.githubusercontent.com/65183563/165654709-b6f95903-1eec-4fba-923d-3628e3dcd1c6.PNG)

![4](https://user-images.githubusercontent.com/65183563/165654889-88b9d448-c6f9-4409-933f-f30d3e7690dd.PNG)

now lets try our app with UserDetails

![VID-20220427-174115](https://user-images.githubusercontent.com/65183563/165655162-8e96aa7b-43ed-42af-9545-74872db85e23.gif)

"yassirrchi" doesnt have ADMIN's role nor USER, cause there is a difference between roles and authorities in spring-security
now lets try fixing this issue by making some changes in SecurityConfig.java 

![VID-20220427-174317 (1)](https://user-images.githubusercontent.com/65183563/165655646-43939f49-d00b-4769-835e-1e93a2cdd4c2.gif)

(hasRole to hasAuthority)
-lets try once again

![VID-20220427-174628](https://user-images.githubusercontent.com/65183563/165656766-570e2d58-0f41-4b85-a046-c1bec3c91ff3.gif)
why "yassirrchi" is having only USER privileges even though he's an admin?
cause our user doesnt respect the conditions that we've set while working with thymeleaf templates

![VID-20220427-175352](https://user-images.githubusercontent.com/65183563/165657462-d42284d7-304a-46af-8600-42d6ebd215af.gif)

so after changing the condition from hasRole to hasAuthority, lets try again yassirrchi (admin) and anwar (regular user)

![VID-20220427-175648](https://user-images.githubusercontent.com/65183563/165658100-e77ee5a9-ab39-4360-9628-bde7005d1515.gif)

finally our app is up and running 🙌
