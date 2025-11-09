Bank Admin
POST /admin/create – Create a new admin
GET /admin/get – Retrieve all admins
PUT /admin/update/{id} – Update admin by ID
DELETE /admin/delete/{id} – Delete admin by ID

Bank Manager
GET /manager/count – Get total number of managers
GET /manager/cash – Get total cash managed
GET /cash/last?n=1 – Get last transaction(s)

Casher
PUT /cash/transfer – Transfer money between accounts
