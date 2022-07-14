# Software Engineering course

## Online shop project

### Problem Statement/Description
With the development of the Internet, more and more people will choose to shop online. This online shopping system is designed to meet people's online shopping needs. The first is the login interface. There are registration and login functions. Registration can register buyer accounts and seller accounts. There are also two modes of login. In the seller mode, you can browse the shops and purchase products. If you see the right product, you can put it in the shopping cart. When an order needs to be placed, the goods in the shopping cart will be put into the order, input relevant information and pay. You can then view the order information through the function of viewing the order information. The seller will also receive orders and obtain order information at this time. When you log in in the seller mode/admin mode, you can add and remove products, adjust product prices, and view order information.

Table of Contents
1. Introduction 
2. Definitions 
    1. shopping trolly 
    2. payment 
    3. Store 
    4. User 
    5. Booking 

1. **Introduction**

This document uses some professional vocabulary to explain the problems that readers may involve or items used when reading other documents. Usually this document can be used as an informal data dictionary to collect data definitions, so that other documents can better focus on its essential purpose.

2. **Definitions**

This glossary contains the definitions of vocabulary used in the " Online Shopping System " APP.
   
    1. Shopping trolley

Store and record the products purchased by users, and users can add, delete and purchase products.
Payment information for the user to pay for the ordered goods
    
    2. Payment

Payment information for the user to pay for the ordered goods

    3.  Store

Store, used to record information about the store’s products, store credit, and store products

    4. User

Users, including buyers and sellers

    5. Booking

Record order information, including buyer, seller, product, shipping address, transaction time and other information.


### Architecture
![Architecture](/LastProjecteCommerce/diagrams/Architecture.png)
### Use Case Description
[Use Case Description](/LastProjecteCommerce/Use%20Case%20Description.md)

### Context diagram
![Context diagram](/LastProjecteCommerce/diagrams/Context%20diagram.jpeg)

### Use Case diagram
![Use case diagram](/LastProjecteCommerce/diagrams/Use%20case%20diagram.jpeg)

### Product add Use Case diagram
![Product add Use Case diagram](/LastProjecteCommerce/diagrams/Product%20add%20sequence.png)

### Order add Use Case diagram
![Order add Use Case diagram](/LastProjecteCommerce/diagrams/Order%20add%20sequence.png)

### Class updated diagram
![Class diagram](/LastProjecteCommerce/diagrams/updated%20class%20diagram.png)
### Class diagram
![Class diagram](/LastProjecteCommerce/diagrams/Class%20Diagram.jpeg)

### Sequence diagram
![Sequence diagram](/LastProjecteCommerce/diagrams/Sequence%20diagram.png)

## Docker
### Backend
1. Build docker image
```
$ docker build --tag xocbayar/ecommerce-backend .
```
2. Push docker image to docker hub
```
$ docker push --all-tags xocbayar/ecommerce-backend
```
### FrontEnd
1. Build docker image
```
$ docker build --tag xocbayar/ecommerce-frontend .
```
2. Push docker image to docker hub
```
$ docker push --all-tags xocbayar/ecommerce-frontend
```

### Docker-Compose
```
$ docker-compose up
$ docker-compose down
```

## Kubernetes

### Helm start MySQL
```
$ helm repo add bitnami https://charts.bitnami.com/bitnami
$ helm install ecommercedb  --set auth.rootPassword=nuuts,auth.database=app_database bitnami/mysql 

$ kubectl create deployment ecommerce-backend --image=xocbayar/ecommerce-backend --dry-run=client -o=yaml > ecommerce-backend.yaml 
$ echo --- >> ecommerce-backend.yaml
$ kubectl create service loadbalancer ecommerce-backend --tcp=8080:8080 --dry-run=client -o=yaml >> ecommerce-backend.yaml
$ kubectl apply -f ecommerce-backend.yaml

$ kubectl create deployment ecommerce-frontend --image=xocbayar/ecommerce-frontend --dry-run=client -o=yaml > ecommerce-frontend.yaml 
$ echo --- >> ecommerce-frontend.yaml
$ kubectl create service loadbalancer ecommerce-frontend --tcp=8081:8080 --dry-run=client -o=yaml >> ecommerce-frontend.yaml
$ kubectl apply -f ecommerce-frontend.yaml
```
### Minikube
```
$ minikube start
$ minikube dashboard
$ minikube tunnel

```
### Application properties
```
spring.datasource.url=jdbc:mysql://ecommercedb-mysql.default.svc.cluster.local:3306/ecommercedb?user=root&password=nuuts&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
```


### Team members
1. Khosbayar Sandag
2. Temuujin Tsogt
3. Tamir Bold