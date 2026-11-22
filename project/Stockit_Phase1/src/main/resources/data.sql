MERGE INTO products (id,name,sku,category,quantity,price,reorder_level,supplier,created_at) KEY(sku) VALUES
(1,'Wireless Mouse','EL-1001','ELECTRONICS',34,24.99,10,'TechSource',CURRENT_TIMESTAMP),
(2,'USB-C Hub','EL-1002','ELECTRONICS',7,49.95,10,'TechSource',CURRENT_TIMESTAMP),
(3,'A4 Printer Paper','OF-2001','OFFICE_SUPPLIES',120,8.49,25,'PaperWorks',CURRENT_TIMESTAMP),
(4,'Desk Organizer','OF-2002','OFFICE_SUPPLIES',9,16.50,10,'PaperWorks',CURRENT_TIMESTAMP),
(5,'Ergonomic Chair','FU-3001','FURNITURE',5,189.00,4,'OfficeComfort',CURRENT_TIMESTAMP),
(6,'Standing Desk','FU-3002','FURNITURE',2,349.00,5,'OfficeComfort',CURRENT_TIMESTAMP),
(7,'Laptop Sleeve','AC-4001','ACCESSORIES',26,19.99,8,'CarryPro',CURRENT_TIMESTAMP),
(8,'HDMI Cable','AC-4002','ACCESSORIES',4,12.99,10,'CarryPro',CURRENT_TIMESTAMP),
(9,'Label Maker','EL-1003','ELECTRONICS',15,64.99,5,'TechSource',CURRENT_TIMESTAMP),
(10,'Whiteboard Markers','OF-2003','OFFICE_SUPPLIES',65,11.75,20,'PaperWorks',CURRENT_TIMESTAMP),
(11,'Storage Bin','OT-5001','OTHER',12,22.00,10,'SupplyHouse',CURRENT_TIMESTAMP),
(12,'Monitor Stand','FU-3003','FURNITURE',3,45.00,5,'OfficeComfort',CURRENT_TIMESTAMP);

ALTER TABLE products ALTER COLUMN id RESTART WITH 1000;
