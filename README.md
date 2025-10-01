APIs

Bank Admin

POST http://localhost:8080/admin/create – Create a new admin

GET http://localhost:8080/admin/get – Retrieve all admins

PUT http://localhost:8080/admin/update/{id} – Update admin by ID

DELETE http://localhost:8080/admin/delete/{id} – Delete admin by ID

Bank Manager

GET http://localhost:8080/manager/count – Get total number of managers

GET http://localhost:8080/manager/cash – Get total cash managed

GET http://localhost:8080/cash/last?n=1 – Get last transaction(s)

Casher

PUT http://localhost:8080/cash/transfer – Transfer money between accounts
