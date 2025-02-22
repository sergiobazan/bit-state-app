# State Bid Backend API

### A project for the auction of properties where sellers and buyers interact

## 🟢 Users & Authentication BC
### Funcionalidades relacionadas con la gestión de usuarios, autenticación y roles.

1️⃣ Register User → POST /api/v1/auth/register
🔹 Permite a un nuevo usuario registrarse en la plataforma.

2️⃣ Login User → POST /api/v1/auth/login
🔹 Autentica un usuario y devuelve un token JWT.

3️⃣ Get User Profile → GET /api/v1/auth/me
🔹 Devuelve los datos del usuario autenticado.

4️⃣ Update User Profile → PUT /api/v1/auth/me
🔹 Permite actualizar la información del usuario autenticado.

5️⃣ Assign Role to User → POST /api/v1/auth/assign-role
🔹 Asigna un rol específico (SELLER o BUYER) a un usuario.

## 🏡 Property Management BC
### Funcionalidades para gestionar propiedades y vendedores.

1️⃣ Create Property → POST /api/v1/properties
🔹 Un vendedor puede registrar una nueva propiedad.

2️⃣ Get All Properties → GET /api/v1/properties
🔹 Devuelve una lista de todas las propiedades disponibles.

3️⃣ Get Property by ID → GET /api/v1/properties/{propertyId}
🔹 Obtiene los detalles de una propiedad específica.

4️⃣ Update Property → PUT /api/v1/properties/{propertyId}
🔹 Permite al vendedor actualizar una propiedad.

5️⃣ Delete Property → DELETE /api/v1/properties/{propertyId}
🔹 Elimina una propiedad de la base de datos.

6️⃣ Get All Sellers → GET /api/v1/sellers
🔹 Devuelve todos los vendedores registrados en la plataforma.

## 🔨 Auction Management BC
### 🔹 Funcionalidades para manejar las subastas de propiedades.

1️⃣ Create Auction → POST /api/v1/auctions
🔹 Un vendedor inicia una subasta para una propiedad.

2️⃣ Get All Auctions → GET /api/v1/auctions
🔹 Devuelve una lista de todas las subastas activas.

3️⃣ Get Auction by ID → GET /api/v1/auctions/{auctionId}
🔹 Obtiene los detalles de una subasta específica.

4️⃣ Place a Bid → POST /api/v1/auctions/{auctionId}/bids
🔹 Un comprador realiza una oferta en una subasta.

5️⃣ Get Bids for Auction → GET /api/v1/auctions/{auctionId}/bids
🔹 Devuelve todas las ofertas realizadas en una subasta.

6️⃣ Close Auction → POST /api/v1/auctions/{auctionId}/close
🔹 Cierra la subasta y asigna la propiedad al mejor postor.

## 💳 Payments & Transactions BC
### 🔹 Funcionalidades para manejar pagos y transacciones.

1️⃣ Make Payment → POST /api/v1/payments
🔹 Un comprador realiza un pago por una propiedad ganada en subasta.

2️⃣ Get Payment Status → GET /api/v1/payments/{paymentId}
🔹 Devuelve el estado de un pago realizado.

3️⃣ Generate Invoice → GET /api/v1/invoices/{transactionId}
🔹 Genera la factura de una transacción completada.

## 📢 Notifications & Communication BC
### 🔹 Funcionalidades para manejar notificaciones y mensajes.

1️⃣ Send Notification → POST /api/v1/notifications
🔹 Envía una notificación a un usuario.

2️⃣ Get User Notifications → GET /api/v1/notifications
🔹 Obtiene las notificaciones del usuario autenticado.

3️⃣ Send Message to Seller → POST /api/v1/messages/seller/{sellerId}
🔹 Permite a un comprador enviar un mensaje a un vendedor.

4️⃣ Get Messages → GET /api/v1/messages
🔹 Devuelve los mensajes recibidos por el usuario autenticado.