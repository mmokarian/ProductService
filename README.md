# ProductService
A REST Service for Products and Shopping Cart

<h2> Features </h2>
<ul>
 <li>View product catalog</li>
<li>Show product details</li>
<li>Add product to cart</li>
<li>Remove a product from the cart</li>
<li>View cart content</li>
</ul>
Running the Application
======================
<h2> Environment </h2>
<ul>
<li> Maven 3.5 </li>
<li> Java 8 </li>
<li> Soring Boot 1.5.3 </li>
</ul>
<h2> Installation </h2>
* Run or debug the app with the ```Starter``` main class at the Controller package 
* Install application: ```mvn clean install```
<h2>Sample Requests</h2>
<ul>
<li>
[GET: Get all products]
* [http://localhost:8080/products](http://localhost:8080/products)  
</li>
<li>
[GET: Get detail of the product having productId=1]
* [http://localhost:8080/product/1](http://localhost:8080/product/1) 
</li>
<li>
[GET: Get items in cart for userId=1]
* [http://localhost:8080/cart/1](http://localhost:8080/cart/1) 
 </li>
 <li>
[PUT: Add Item (itemId=5) to Cart (belonging to user having userId=1)]
* [http://localhost:8080/cart/add/1/5](http://localhost:8080/cart/add/1/5)  
</li>
<li>
[DELETE: Remove An Item (itemId=3) from the cart belonging to user (with userId=1)]
* [http://localhost:8080/cart/remove/1/3](http://localhost:8080/cart/remove/1/3) 
</li>
<li>
* [Get Postman requests](https://www.getpostman.com/collections/61859559b64315c4081c)
</li>
</ul>
