# Checkout from git:
    git clone <url>
    cd rewards

# Testing:
    mvn test

# Running the app:
    mvn spring-boot:run 

#Default Configuration (defines the break points and multipliers for the rewards):
* breakpointOne=50
* breakpointOneMultiplier=1
* breakpointTwo=100
* breakpointTwoMultiplier=2

### Dependencies
* spring-boot-starter-web
* lombok
* spring-boot-starter-test



# APIs:
* [GET] / - gets all transactions
* [GET] /user/104 - gets all transactions belonging to customer 104
* [GET] /get-reward-points?amount=245 - gets reward points based on amount USD 245
* [GET] /get-reward-points-by-user-id/102 - gets reward points based on the transactions done by customer with id 102
* [GET] /6 - gets the transaction with id 6
* [POST with payload] / - saves a transactions