INSERT INTO "vendor" ("vendor_id", "created_at", "name", "email")
VALUES ('58ce15e8-d2b6-4940-a5c2-db1c543f8320', '2024-08-19T16:55:59.359515', 'Charles', 'c@lima.com');
INSERT INTO "vendor" ("vendor_id", "created_at", "name", "email")
VALUES ('84ac6466-5247-4590-811e-ac70142f57cd', '2024-08-19T17:14:45.7967', 'Leonardo', 'l@silva.com');
INSERT INTO "vendor" ("vendor_id", "created_at", "name", "email")
VALUES ('ea152483-ad40-4913-9ab9-44d5142758a8', '2024-08-19T17:15:03.971771', 'Apple', 'steve.jobs@apple.com');

INSERT INTO "product" ("product_id", "vendor_id", "created_at", "name", "price", "category")
VALUES ('5850a5ae-3142-4ae2-98e7-3c93a0fba0f8','58ce15e8-d2b6-4940-a5c2-db1c543f8320', '2024-08-19T17:55:59.359515', 'Product 1', 100.50, 'Category X');
INSERT INTO "product" ("product_id", "vendor_id", "created_at", "name", "price", "category")
VALUES ('1071b2ff-1cfe-4be8-8fc0-f88982a9799c','84ac6466-5247-4590-811e-ac70142f57cd', '2024-08-19T18:14:45.7967', 'Product 2', 200.50, 'Category Y');
INSERT INTO "product" ("product_id", "vendor_id", "created_at", "name", "price", "category")
VALUES ('5aa8aa56-3e78-4ac2-9b09-031cb35038bd','ea152483-ad40-4913-9ab9-44d5142758a8', '2024-08-19T18:15:03.971771', 'Product 3', 300.50, 'Category Z');
