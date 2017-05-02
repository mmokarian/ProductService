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

<h2> Environment </h2>
<ul>
<li> Maven 3.5 </li>
<li> Java 8 </li>
<li> Soring Boot 1.5.3 </li>
</ul>
<h2> Installation </h2>
<ul>
<li>Run or debug the app with the <b>Starter</b> main class at the Controller package </li>
<li>Install application: <b>mvn clean install</b></li>
</ul>
<h2>Database</h2>
<ul>
<li><b>Please Note:</b> By starting the application the in-memory database will be pre-populated by some data. Hence you can make your sample calls once the service started. </li>
</ul>
<h2>Sample Requests</h2>
<ul>
<li>
[GET: Get all products]
<a href="http://localhost:8080/products">{ENV}/products</a>
</li>
<li>
[GET: Get detail of the product having productId=1]
<a href="http://localhost:8080/product/1">{ENV}/product/1</a>
</li>
<li>
[GET: Get items in cart for userId=1]
<a href="http://localhost:8080/cart/1">{ENV}/cart/1</a>
 </li>
 <li>
[PUT: Add Item (itemId=5) to Cart (belonging to user having userId=1)]
<a href="http://localhost:8080/cart/add/1/5">{ENV}/cart/add/1/5</a>
</li>
<li>
[DELETE: Remove An Item (itemId=3) from the cart belonging to user (with userId=1)]
<a href="http://localhost:8080/cart/remove/1/3">{ENV}/cart/remove/1/3</a>
</li>
<li>
<a href="https://www.getpostman.com/collections/61859559b64315c4081c">Get Postman requests</a>
</li>
</ul>
