# Community-Info-System
## INFO5100 Final Project
| Name | NUID | Email |
| ---------- | --------- | ----------------------- |
| Xiaoyang CAI | 001586080 | cai.xiao@northeastern.edu |
| Zhi YAO      | 001520700 | yao.zhi1@northeastern.edu |
| Licong Lou | 002100980 | lou.li@northeastern.edu   |



## Project Description
The general goal of this design is to create a system for community group purchase, in order to reduce crowding shopping condition under the enviroment of COVID-19, as well as cut down the logistic costs and purchase efficiency.

#### Domain Model

##### Main Roles

- System Admin 

  >with the pre-set account information: Username as "Admin123" and Password as "Admin123"

- Market

- Delivery

- Community

  > Sign Up as "Apartment Resident", select their own community while sign up.

##### Main Duty of Each Role

- System Admin

  - View All Registered User Account Information

- Market

  - Add / Update / Delete products, manage products storage and manufactured date
  - View all community orders, with status of "Accepted"
  - Change the order status from "Accepted" to "Shipped" after complete product package.

- Delivery

  - View all packaged orders, with status of "Shipped"
  - Select grocery location based on the community location
  - Change the order status from "Shipped" to "Finished". 

- Community

  - Residents:
    - View all products on menu.
    - Select products from menu, and select items to cart.

  - Community:
    - View all residents` cart, with status of "Pending"
    - Place residents order together to supermarket, then change the order status from "Pending" to "Accepted"

**User Stories**

1. (Supermarket) Update products on the menu
2. (Residents) Select products from menu to personal cart, and confirm cart
3. (Order Status) Order created, with status "PENDING"
4. (Community) Verify all residents `(in this community) cart, place order
5. (Order Status) Order status changed, with status "ACCEPTED"
6. (Supermarket) Receive order, and complete packing products.
7. (Order Status) Order status changed, with status "SHIPPED"
8. (Delivery) Get the packaged order from the nearest grocery and sent it to community.
9. (Order Status) Order status changed, with status "FINISHED"
10. (Community) Receive Order.



### Run The Code

Clone the repository and run the following command in your shell:
```sh
git clone git@github.com:PDA26/Community-Info-System.git
```



### Input Data Validation

1. User SignIn/SignUp:

   - NO EMPTY INPUT is acceptable.

   - Username and Password should not be Overlapped.

   - For resident sign up, the username must be the same as their apt no.

2. Add Community:

   - NO EMPTY INPUT is acceptable.
   - Community contact phone must be digital.

3. Add Product:

   - NO EMPTY INPUT is acceptable.

   
