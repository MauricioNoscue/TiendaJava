CREATE TABLE person(
    personid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    personName VARCHAR(50),
    personLastName VARCHAR(50),
    Email VARCHAR(50),
    phone VARCHAR(15)
);

CREATE TABLE user(
    userId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userName VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    personid INT NOT NULL,
    FOREIGN KEY (personid) REFERENCES person(personid)
);

CREATE TABLE role(
    roleId INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    roleName VARCHAR(50)
);

CREATE TABLE userrole(
    userroleId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    roleId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES user(userId),
    FOREIGN KEY (roleId) REFERENCES role(roleId)
);

CREATE TABLE category(
    categoryId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    categoryName VARCHAR(50)
);

CREATE TABLE product(    
    productId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    description TEXT,
    productPrice FLOAT,
    categoryId INT NOT NULL,
    FOREIGN KEY (categoryId) REFERENCES category(categoryId)
);

CREATE TABLE supplier(
    supplierId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    address VARCHAR(50),
    supplierName VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(50)
);

CREATE TABLE productsupplier(
    productsupplierId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    productId INT NOT NULL,
    supplierId INT NOT NULL,
    FOREIGN KEY (productId) REFERENCES product(productId),
    FOREIGN KEY (supplierId) REFERENCES supplier(supplierId)
);

CREATE TABLE invoice(
    invoiceId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    paymentMethod VARCHAR(50),
    userId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES user(userId)
);

CREATE TABLE invoiceproduct(
    invoiceproductId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    invoiceId INT NOT NULL,
    productId INT NOT NULL,
    quantity INT,
    totalPrice FLOAT,
    FOREIGN KEY (invoiceId) REFERENCES invoice(invoiceId),
    FOREIGN KEY (productId) REFERENCES product(productId)
);
