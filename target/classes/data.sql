INSERT INTO category (category_name) VALUES
                                         ('Metals'),
                                         ('Battery Recycling'),
                                         ('Compost & Food Waste'),
                                         ('Computer & Electronics'),
                                         ('Glass & Fiberglass'),
                                         ('Chemicals'),
                                         ('Paper/Cardboard'),
                                         ('Plastic'),
                                         ('Textiles & Leather'),
                                         ('Tire & Rubber'),
                                         ('Wood'),
                                         ('Used Commercial Goods'),
                                         ('Used Clothes'),
                                         ('Used Equipment');


INSERT INTO users (name, surname, email, phone_number, password, register_date, user_type)
VALUES ('John', 'Doe', 'john.doe@example.com', '1234567890', 'hashed_password', NOW(), 'USER');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 2);


INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 2, 'Duracell AA Batteries - 10 Pack',
        'Duracell AA alkaline batteries with long-lasting power for household and portable devices. Pack of 10 batteries.',
        12.99, 'Warehouse A - Shelf 3', 50, '/resources/imagesdb/Battery1.jpg', NOW(), 'Available');

INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (2, 2, 'Energizer AAA Rechargeable Batteries - 4 Pack',
        'Energizer AAA rechargeable batteries, suitable for high-drain devices. Pack of 4 batteries.',
        16.50, 'Warehouse B - Shelf 7', 100, '/resources/imagesdb/Battery2.jpg', NOW(), 'Available');

INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (3, 2, 'Panasonic 9V Battery - Single',
        'Panasonic 9V battery ideal for smoke detectors and other safety devices. Single battery.',
        8.99, 'Warehouse C - Shelf 2', 30, '/resources/imagesdb/Battery3.jpg', NOW(), 'Available');

INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 2, 'Varta CR2032 Coin Cell Battery - 5 Pack',
        'Varta CR2032 lithium coin cell batteries for watches and small electronics. Pack of 5.',
        5.49, 'Warehouse A - Shelf 4', 150, '/resources/imagesdb/Battery4.jpg', NOW(), 'Available');

INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (4, 2, 'Sony Lithium Battery CR2025 - 2 Pack',
        'Sony CR2025 lithium batteries for car key fobs, watches, and medical devices. Pack of 2.',
        4.99, 'Warehouse D - Shelf 1', 80, '/resources/imagesdb/Battery5.jpg', NOW(), 'Available');


-- Insert chemical product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 6, 'Acetone - 1 Liter',
        'High-purity acetone for cleaning and solvent purposes. Suitable for industrial and household use. 1-liter bottle.',
        14.99, 'Warehouse E - Shelf 5', 25, '/resources/imagesdb/Chemicals1.jpg', NOW(), 'Available');

-- Insert chemical product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 6, 'Isopropyl Alcohol 99% - 500ml',
        '99% pure isopropyl alcohol for cleaning electronics and medical devices. 500ml bottle.',
        7.49, 'Warehouse E - Shelf 3', 60, '/resources/imagesdb/Chemicals2.jpg', NOW(), 'Available');

-- Insert chemical product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 6, 'Hydrogen Peroxide 30% - 1 Liter',
        'Industrial-strength hydrogen peroxide (30%) for laboratory and industrial applications. 1-liter bottle.',
        18.99, 'Warehouse E - Shelf 8', 40, '/resources/imagesdb/Chemicals3.jpg', NOW(), 'Available');

-- Insert chemical product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 6, 'Sodium Hydroxide (Caustic Soda) - 500g',
        'Pure sodium hydroxide (NaOH) pellets for cleaning, unblocking drains, and laboratory use. 500g package.',
        9.99, 'Warehouse F - Shelf 2', 80, '/resources/imagesdb/Chemicals4.jpg', NOW(), 'Available');

-- Insert chemical product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 6, 'Sulfuric Acid 96% - 1 Liter',
        'Concentrated sulfuric acid (96%) for industrial and laboratory use. 1-liter bottle. Handle with care.',
        22.99, 'Warehouse F - Shelf 6', 15, '/resources/imagesdb/Chemicals5.jpg', NOW(), 'Available');


-- Insert compost product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 3, 'Organic Compost - 20 lbs Bag',
        'Premium organic compost ideal for gardens, lawns, and flower beds. Rich in nutrients to improve soil health.',
        9.99, 'Warehouse G - Shelf 1', 200, '/resources/imagesdb/compost Food Waste1.jpg', NOW(), 'Available');

-- Insert compost product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 3, 'Compost Bin - 30 Gallon Capacity',
        'Durable compost bin with a 30-gallon capacity, perfect for food waste and organic material recycling at home.',
        29.99, 'Warehouse G - Shelf 3', 50, '/resources/imagesdb/compost Food Waste2.jpg', NOW(), 'Available');

-- Insert compost product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 3, 'Vermicompost Starter Kit',
        'Complete vermicomposting kit for beginners, including a worm bin, bedding, and live red worms to start composting at home.',
        49.99, 'Warehouse G - Shelf 5', 30, '/resources/imagesdb/compost Food Waste3.jpg', NOW(), 'Available');

-- Insert compost product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 3, 'Compostable Food Waste Bags - 50 Count',
        'Eco-friendly compostable bags for kitchen food waste. Pack of 50 bags, made from plant-based materials.',
        12.50, 'Warehouse G - Shelf 2', 150, '/resources/imagesdb/compost Food Waste4.jpg', NOW(), 'Available');

-- Insert compost product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 3, 'Garden Compost Tumbler - 50 Gallon',
        'Large 50-gallon compost tumbler with dual chambers for continuous composting. Easy to rotate and manage food waste and yard debris.',
        89.99, 'Warehouse G - Shelf 4', 20, '/resources/imagesdb/compost Food Waste5.jpg', NOW(), 'Available');

-- Insert electronics product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 4, 'Dell XPS 13 Laptop - 13.3" Display',
        'Dell XPS 13 with a 13.3" Full HD display, Intel i7 processor, 16GB RAM, and 512GB SSD. Perfect for productivity and travel.',
        1299.99, 'Warehouse H - Shelf 1', 10, '/resources/imagesdb/Computer & Electronics 1.jpg', NOW(), 'Available');

-- Insert electronics product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 4, 'Apple MacBook Pro 16" - M1 Chip',
        'Apple MacBook Pro with the M1 chip, 16" Retina display, 16GB RAM, and 1TB SSD. Ideal for creative professionals.',
        2499.99, 'Warehouse H - Shelf 2', 8, '/resources/imagesdb/Computer & Electronics 2.png', NOW(), 'Available');

-- Insert electronics product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 4, 'Samsung 4K Ultra HD Monitor - 27"',
        'Samsung 27-inch 4K Ultra HD monitor with HDR support and a 144Hz refresh rate. Great for gaming and productivity.',
        399.99, 'Warehouse H - Shelf 3', 15, '/resources/imagesdb/Computer & Electronics 3.jpg', NOW(), 'Available');

-- Insert electronics product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 4, 'Logitech Wireless Mouse - MX Master 3',
        'Logitech MX Master 3 wireless mouse with ergonomic design, customizable buttons, and ultra-fast scrolling.',
        99.99, 'Warehouse H - Shelf 4', 50, '/resources/imagesdb/Computer & Electronics 4.jpg', NOW(), 'Available');

-- Insert electronics product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 4, 'Sony WH-1000XM4 Noise Cancelling Headphones',
        'Sony WH-1000XM4 wireless headphones with industry-leading noise cancellation and 30 hours of battery life.',
        349.99, 'Warehouse H - Shelf 5', 25, '/resources/imagesdb/Computer & Electronics 5.jpg', NOW(), 'Available');

-- Insert electronics product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 4, 'Razer Blade 15 Gaming Laptop',
        'Razer Blade 15 with Intel i7 processor, NVIDIA RTX 3070, 16GB RAM, and 1TB SSD. High-performance laptop for gaming and content creation.',
        2299.99, 'Warehouse H - Shelf 6', 12, '/resources/imagesdb/Computer & Electronics 6.jpg', NOW(), 'Available');

-- Insert electronics product 7
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 4, 'ASUS ROG Strix Gaming Keyboard - RGB',
        'ASUS ROG Strix RGB mechanical gaming keyboard with Cherry MX switches and customizable lighting.',
        129.99, 'Warehouse H - Shelf 7', 40, '/resources/imagesdb/Computer & Electronics 7.jpg', NOW(), 'Available');


-- Insert glass product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 5, 'Tempered Glass Panel - 6mm, 24"x36"',
        'High-quality tempered glass panel, 6mm thickness, suitable for windows, doors, and furniture applications.',
        79.99, 'Warehouse I - Shelf 1', 50, '/resources/imagesdb/Glass & Fiberglass 1.jpeg', NOW(), 'Available');

-- Insert glass product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 5, 'Fiberglass Insulation Roll - 15"x50ft',
        'Fiberglass insulation roll, 15-inch width, 50 feet length, suitable for residential and commercial building insulation.',
        59.99, 'Warehouse I - Shelf 2', 30, '/resources/imagesdb/Glass & Fiberglass 2.jpg', NOW(), 'Available');

-- Insert glass product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 5, 'Stained Glass Sheet - 12"x12"',
        'Colorful stained glass sheet, 12"x12", ideal for decorative and craft projects such as windows and lamps.',
        19.99, 'Warehouse I - Shelf 3', 100, '/resources/imagesdb/Glass & Fiberglass 3.jpg', NOW(), 'Available');

-- Insert glass product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 5, 'Fiberglass Repair Kit - 1 Gallon',
        'Complete fiberglass repair kit, includes 1 gallon of resin and hardener. Ideal for marine, auto, and general repairs.',
        39.99, 'Warehouse I - Shelf 4', 20, '/resources/imagesdb/Glass & Fiberglass 4.jpg', NOW(), 'Available');

-- Insert glass product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 5, 'Glass Fiber Cloth - 10 sq ft',
        'High-strength glass fiber cloth for composite construction and repair. 10 square feet per roll.',
        24.99, 'Warehouse I - Shelf 5', 60, '/resources/imagesdb/Glass & Fiberglass 5.jpg', NOW(), 'Available');

-- Insert glass product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 5, 'Double Glazed Glass Unit - 36"x48"',
        'Energy-efficient double glazed glass unit, 36"x48", suitable for residential windows. Reduces heat transfer and noise.',
        149.99, 'Warehouse I - Shelf 6', 10, '/resources/imagesdb/Glass & Fiberglass 6.jpg', NOW(), 'Available');

-- Insert metal product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 1, 'Stainless Steel Sheet - 304 Grade, 24"x36"',
        'Premium 304 grade stainless steel sheet, 24"x36", 1mm thick. Ideal for industrial, construction, and home projects.',
        89.99, 'Warehouse J - Shelf 1', 20, '/resources/imagesdb/metals1.jpg', NOW(), 'Available');

-- Insert metal product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 1, 'Aluminum Rod - 1" Diameter, 4ft Long',
        'High-quality aluminum rod, 1-inch diameter, 4 feet long. Lightweight and corrosion-resistant, ideal for structural applications.',
        29.99, 'Warehouse J - Shelf 2', 50, '/resources/imagesdb/metals2.jpg', NOW(), 'Available');

-- Insert metal product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 1, 'Copper Wire - 12 AWG, 100ft',
        '12 AWG copper wire, 100 feet long. Ideal for electrical installations, motor winding, and other conductive applications.',
        49.99, 'Warehouse J - Shelf 3', 100, '/resources/imagesdb/metals3.jpg', NOW(), 'Available');

-- Insert metal product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 1, 'Carbon Steel Pipe - 2" Diameter, 6ft Long',
        'High-strength carbon steel pipe, 2-inch diameter, 6 feet long. Suitable for plumbing, structural, and industrial use.',
        59.99, 'Warehouse J - Shelf 4', 30, '/resources/imagesdb/metals4.jpg', NOW(), 'Available');

-- Insert metal product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 1, 'Galvanized Steel Sheet - 22 Gauge, 36"x48"',
        'Galvanized steel sheet, 22 gauge, 36"x48", rust-resistant for outdoor and industrial applications.',
        74.99, 'Warehouse J - Shelf 5', 40, '/resources/imagesdb/metals5.jpg', NOW(), 'Available');

-- Insert metal product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 1, 'Brass Hex Bar - 3/4" Diameter, 12ft Long',
        'Brass hexagonal bar, 3/4" diameter, 12 feet long. Suitable for machining, decorative hardware, and fittings.',
        109.99, 'Warehouse J - Shelf 6', 15, '/resources/imagesdb/metals6.jpg', NOW(), 'Available');

-- Insert paper/cardboard product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 7, 'Recycled Cardboard Sheets - 24"x36", 10 Pack',
        'Eco-friendly recycled cardboard sheets, 24"x36", perfect for packaging, crafts, and storage. 10 sheets per pack.',
        14.99, 'Warehouse K - Shelf 1', 100, '/resources/imagesdb/PaperCardboard1.jpg', NOW(), 'Available');

-- Insert paper/cardboard product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 7, 'A4 Recycled Printer Paper - 500 Sheets',
        'A4 size recycled printer paper, 80gsm, suitable for inkjet and laser printing. 500 sheets per ream.',
        9.99, 'Warehouse K - Shelf 2', 200, '/resources/imagesdb/PaperCardboard2.jpg', NOW(), 'Available');

-- Insert paper/cardboard product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 7, 'Corrugated Cardboard Rolls - 36"x100ft',
        'Corrugated cardboard rolls, 36" wide and 100 feet long, ideal for wrapping and protecting fragile items.',
        29.99, 'Warehouse K - Shelf 3', 50, '/resources/imagesdb/PaperCardboard3.jpg', NOW(), 'Available');

-- Insert paper/cardboard product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 7, 'Brown Kraft Paper - 24"x100ft Roll',
        'High-quality brown kraft paper, 24" wide and 100 feet long, perfect for wrapping, arts and crafts, and covering surfaces.',
        12.99, 'Warehouse K - Shelf 4', 75, '/resources/imagesdb/PaperCardboard4.jpg', NOW(), 'Available');

-- Insert paper/cardboard product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 7, 'Heavy-Duty Cardboard Boxes - 18"x18"x12", 5 Pack',
        'Heavy-duty cardboard boxes, 18"x18"x12", designed for shipping, moving, and storage. 5 boxes per pack.',
        24.99, 'Warehouse K - Shelf 5', 40, '/resources/imagesdb/PaperCardboard5.jpg', NOW(), 'Available');

-- Insert paper/cardboard product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 7, 'White Poster Board - 22"x28", 10 Sheets',
        'White poster board, 22"x28", suitable for presentations, posters, and signage. 10 sheets per pack.',
        8.99, 'Warehouse K - Shelf 6', 60, '/resources/imagesdb/PaperCardboard6.jpg', NOW(), 'Available');


-- Insert plastic product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 8, 'Plastic Storage Bin - 12"x12"x15"',
        'Durable plastic storage bin with a lid, 12"x12"x15", suitable for organizing and storing various household items.',
        9.99, 'Warehouse L - Shelf 1', 120, '/resources/imagesdb/Plastic1.jpeg', NOW(), 'Available');

-- Insert plastic product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 8, 'Polyethylene Tarp - 10ft x 20ft',
        'Heavy-duty polyethylene tarp, 10ft x 20ft, waterproof and UV-resistant. Ideal for covering materials and equipment.',
        24.99, 'Warehouse L - Shelf 2', 60, '/resources/imagesdb/Plastic2.jpg', NOW(), 'Available');

-- Insert plastic product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 8, 'Plastic Water Bottle - 1 Liter, BPA-Free',
        'BPA-free plastic water bottle, 1-liter capacity, with a secure screw-on cap. Ideal for sports and outdoor activities.',
        4.99, 'Warehouse L - Shelf 3', 300, '/resources/imagesdb/Plastic3.jpg', NOW(), 'Available');

-- Insert plastic product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 8, 'PVC Pipe - 2" Diameter, 10ft Long',
        'High-quality PVC pipe, 2-inch diameter, 10 feet long. Suitable for plumbing and drainage applications.',
        19.99, 'Warehouse L - Shelf 4', 80, '/resources/imagesdb/Plastic4.jpg', NOW(), 'Available');

-- Insert plastic product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 8, 'Plastic Cutting Board - 12"x18"',
        'Durable plastic cutting board, 12"x18", dishwasher safe and non-slip. Ideal for food preparation.',
        7.99, 'Warehouse L - Shelf 5', 150, '/resources/imagesdb/Plastic5.jpg', NOW(), 'Available');

-- Insert plastic product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 8, 'Acrylic Sheet - 24"x36", Clear',
        'Clear acrylic sheet, 24"x36", lightweight and shatter-resistant. Ideal for DIY projects and displays.',
        29.99, 'Warehouse L - Shelf 6', 45, '/resources/imagesdb/Plastic6.jpg', NOW(), 'Available');

-- Insert plastic product 7
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 8, 'Polypropylene Rope - 3/8" Diameter, 100ft',
        'Polypropylene rope, 3/8" diameter, 100 feet long. Strong and rot-resistant, perfect for marine and outdoor use.',
        12.99, 'Warehouse L - Shelf 7', 90, '/resources/imagesdb/Plastic7.jpg', NOW(), 'Available');

-- Insert plastic product 8
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 8, 'Plastic Chair - Stackable, Outdoor Use',
        'Stackable plastic chair designed for outdoor use, weather-resistant and lightweight. Available in multiple colors.',
        19.99, 'Warehouse L - Shelf 8', 75, '/resources/imagesdb/Plastic8.jpg', NOW(), 'Available');



-- Insert textiles & leather product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 9, 'Leather Wallet - Genuine Leather, Brown',
        'Handcrafted genuine leather wallet in brown. Slim design with multiple card slots and a cash compartment.',
        34.99, 'Warehouse M - Shelf 1', 50, '/resources/imagesdb/Textiles & Leather1.jpg', NOW(), 'Available');

-- Insert textiles & leather product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 9, 'Cotton Bedsheet Set - Queen Size, White',
        '100% cotton bedsheet set, queen size, includes one fitted sheet, one flat sheet, and two pillowcases. White color.',
        49.99, 'Warehouse M - Shelf 2', 100, '/resources/imagesdb/Textiles & Leather2.jpg', NOW(), 'Available');

-- Insert textiles & leather product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 9, 'Leather Belt - Black, Adjustable',
        'High-quality black leather belt with adjustable buckle. Perfect for formal and casual wear.',
        19.99, 'Warehouse M - Shelf 3', 200, '/resources/imagesdb/Textiles & Leather3.jpg', NOW(), 'Available');

-- Insert textiles & leather product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 9, 'Silk Scarf - Floral Print, 60"x20"',
        'Luxurious silk scarf with a floral print, 60"x20". Lightweight and perfect for all seasons.',
        24.99, 'Warehouse M - Shelf 4', 75, '/resources/imagesdb/Textiles & Leather4.jpg', NOW(), 'Available');

-- Insert textiles & leather product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 9, 'Denim Jacket - Unisex, Medium',
        'Classic unisex denim jacket, medium size. Durable and stylish, suitable for all casual occasions.',
        59.99, 'Warehouse M - Shelf 5', 30, '/resources/imagesdb/Textiles & Leather5.jpg', NOW(), 'Available');

-- Insert textiles & leather product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 9, 'Wool Blanket - King Size, Grey',
        'Warm and soft wool blanket, king size, in grey. Perfect for cold weather and cozy nights.',
        69.99, 'Warehouse M - Shelf 6', 40, '/resources/imagesdb/Textiles & Leather5 (1).jpg', NOW(), 'Available');

-- Insert textiles & leather product 7
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 9, 'Leather Gloves - Winter, Black',
        'Premium leather gloves for winter, in black. Insulated for warmth and comfort.',
        29.99, 'Warehouse M - Shelf 7', 80, '/resources/imagesdb/Textiles & Leather6.jpg', NOW(), 'Available');

-- Insert textiles & leather product 8
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 9, 'Cotton T-shirt - Unisex, Large, Blue',
        'Comfortable unisex cotton t-shirt, large size, in blue. Ideal for everyday wear.',
        14.99, 'Warehouse M - Shelf 8', 150, '/resources/imagesdb/Textiles & Leather7.jpg', NOW(), 'Available');




-- Insert tire & rubber product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 10, 'All-Season Car Tire - 205/55R16',
        'Durable all-season tire for cars. Size: 205/55R16, designed for optimal performance in all weather conditions.',
        89.99, 'Warehouse N - Shelf 1', 100, '/resources/imagesdb/Tire & Rubber1.jpg', NOW(), 'Available');

-- Insert tire & rubber product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 10, 'Rubber Floor Mat - 3ft x 5ft, Anti-Slip',
        'Heavy-duty rubber floor mat, 3ft x 5ft, with anti-slip design. Ideal for industrial and home use.',
        49.99, 'Warehouse N - Shelf 2', 60, '/resources/imagesdb/Tire & Rubber2.jpg', NOW(), 'Available');

-- Insert tire & rubber product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 10, 'Bicycle Tire - 26" x 2.0", Off-Road',
        'Durable off-road bicycle tire, 26" x 2.0", designed for mountain biking and rough terrains.',
        24.99, 'Warehouse N - Shelf 3', 80, '/resources/imagesdb/Tire & Rubber3.jpeg', NOW(), 'Available');

-- Insert tire & rubber product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 10, 'Rubber Seal Strip - 10ft, Weatherproof',
        'High-quality rubber seal strip, 10ft long, for weatherproofing doors and windows. Adhesive backing for easy installation.',
        12.99, 'Warehouse N - Shelf 4', 200, '/resources/imagesdb/Tire & Rubber4.jpg', NOW(), 'Available');

-- Insert tire & rubber product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 10, 'Heavy-Duty Truck Tire - 275/70R22.5',
        'Heavy-duty truck tire, size 275/70R22.5, designed for commercial use and long-haul performance.',
        259.99, 'Warehouse N - Shelf 5', 50, '/resources/imagesdb/Tire & Rubber5.jpg', NOW(), 'Available');

-- Insert tire & rubber product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 10, 'Rubber Mallet - 16oz, Non-Marking',
        '16oz rubber mallet with a non-marking head, ideal for construction, automotive, and home improvement projects.',
        15.99, 'Warehouse N - Shelf 6', 150, '/resources/imagesdb/Tire & Rubber6.jpg', NOW(), 'Available');

-- Insert tire & rubber product 7
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 10, 'Car Tire Repair Kit - Universal',
        'Universal car tire repair kit, includes all necessary tools and patches for quick tire repairs on the go.',
        29.99, 'Warehouse N - Shelf 7', 120, '/resources/imagesdb/Tire & Rubber7.jpg', NOW(), 'Available');





-- Insert used clothes product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 13, 'Vintage Denim Jacket - Size M',
        'Classic vintage denim jacket in size medium. Slightly distressed, perfect for layering over casual outfits.',
        25.00, 'Warehouse N - Shelf A1', 10, '/resources/imagesdb/Used Clothes.jpg', NOW(), 'Available');

-- Insert used clothes product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 13, 'Floral Print Maxi Dress - Size S',
        'Beautiful floral print maxi dress in size small. Ideal for summer outings and casual wear.',
        30.00, 'Warehouse N - Shelf A2', 15, '/resources/imagesdb/Used Clothes2.jpg', NOW(), 'Available');

-- Insert used clothes product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 13, 'Leather Boots - Size 8',
        'Stylish brown leather boots in size 8. Slightly worn but still in great condition, suitable for fall and winter.',
        40.00, 'Warehouse N - Shelf A3', 8, '/resources/imagesdb/Used Clothes3.jpg', NOW(), 'Available');

-- Insert used clothes product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 13, 'Striped Long Sleeve Shirt - Size L',
        'Comfortable striped long sleeve shirt in size large. Soft fabric, great for layering or wearing alone.',
        18.00, 'Warehouse N - Shelf A4', 20, '/resources/imagesdb/Used Clothes4.jpg', NOW(), 'Available');

-- Insert used clothes product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 13, 'Wool Sweater - Size XL',
        'Cozy wool sweater in size extra large. Excellent condition with no signs of wear, ideal for cold weather.',
        35.00, 'Warehouse N - Shelf A5', 12, '/resources/imagesdb/Used Clothes5.jpg', NOW(), 'Available');

-- Insert used clothes product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 13, 'Cargo Pants - Size 34',
        'Practical cargo pants in size 34. Includes multiple pockets and adjustable waistband, lightly used.',
        22.00, 'Warehouse N - Shelf A6', 18, '/resources/imagesdb/Used Clothes6.jpg', NOW(), 'Available');



-- Insert used commercial goods product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 12, 'Office Desk - 60x30 inches',
        'Spacious office desk with a sleek design. Measures 60x30 inches, includes drawer and storage compartments.',
        150.00, 'Warehouse N - Shelf B1', 5, '/resources/imagesdb/Used Commercial Goods1.jpg', NOW(), 'Available');

-- Insert used commercial goods product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 12, 'Conference Table - Seats 8',
        'Large conference table that seats up to 8 people. Made from high-quality wood with a polished finish.',
        300.00, 'Warehouse N - Shelf B2', 2, '/resources/imagesdb/Used Commercial Goods2.jpg', NOW(), 'Available');

-- Insert used commercial goods product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 12, 'Industrial Printer - Model X100',
        'Heavy-duty industrial printer, model X100. Ideal for high-volume printing needs, in good working condition.',
        400.00, 'Warehouse N - Shelf B3', 3, '/resources/imagesdb/Used Commercial Goods3.jpg', NOW(), 'Available');

-- Insert used commercial goods product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 12, 'Office Chairs - Ergonomic (Set of 4)',
        'Set of 4 ergonomic office chairs, designed for comfort and support during long hours of work. Adjustable and in excellent condition.',
        200.00, 'Warehouse N - Shelf B4', 1, '/resources/imagesdb/Used Commercial Goods4.jpg', NOW(), 'Available');

-- Insert used commercial goods product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 12, 'Reception Desk - Modern Design',
        'Modern reception desk with a contemporary design. Features built-in storage and ample workspace.',
        250.00, 'Warehouse N - Shelf B5', 4, '/resources/imagesdb/Used Commercial Goods5.jpg', NOW(), 'Available');


-- Insert wood product 1
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 11, 'Oak Wood Planks - 2x6 inches, 10ft',
        'High-quality oak wood planks, 2x6 inches, 10ft long. Ideal for flooring or cabinetry projects.',
        45.00, 'Warehouse N - Shelf C1', 20, '/resources/imagesdb/Wood1.jpg', NOW(), 'Available');

-- Insert wood product 2
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 11, 'Cherry Wood Lumber - 4x4 inches, 8ft',
        'Beautiful cherry wood lumber, 4x4 inches, 8ft long. Perfect for high-end furniture making.',
        60.00, 'Warehouse N - Shelf C2', 15, '/resources/imagesdb/Wood2.jpg', NOW(), 'Available');

-- Insert wood product 3
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 11, 'Pine Wood Boards - 1x12 inches, 6ft',
        'Versatile pine wood boards, 1x12 inches, 6ft long. Suitable for shelving, trim, and various woodworking projects.',
        25.00, 'Warehouse N - Shelf C3', 25, '/resources/imagesdb/Wood3.jpg', NOW(), 'Available');

-- Insert wood product 4
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 11, 'Walnut Wood Slabs - 2x8 inches, 12ft',
        'Rich walnut wood slabs, 2x8 inches, 12ft long. Ideal for custom tables and high-end cabinetry.',
        80.00, 'Warehouse N - Shelf C4', 10, '/resources/imagesdb/Wood4.jpg', NOW(), 'Available');

-- Insert wood product 5
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 11, 'Maple Wood Panels - 3x3 feet',
        'Durable maple wood panels, 3x3 feet. Great for cabinet doors and furniture backs.',
        50.00, 'Warehouse N - Shelf C5', 18, '/resources/imagesdb/Wood5.jpg', NOW(), 'Available');

-- Insert wood product 6
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 11, 'Birch Wood Sheets - 4x8 feet',
        'Quality birch wood sheets, 4x8 feet. Ideal for cabinetry, paneling, and craft projects.',
        70.00, 'Warehouse N - Shelf C6', 12, '/resources/imagesdb/Wood6.jpg', NOW(), 'Available');

-- Insert wood product 7
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 11, 'Hickory Wood Planks - 1x4 inches, 8ft',
        'Sturdy hickory wood planks, 1x4 inches, 8ft long. Great for trim work and custom wood projects.',
        35.00, 'Warehouse N - Shelf C7', 22, '/resources/imagesdb/Wood7.jpg', NOW(), 'Available');

-- Insert wood product 8
INSERT INTO product (user_id, category_id, title, description, price, location, quantity, images, date_posted, status)
VALUES (1, 11, 'Teak Wood Tiles - 12x12 inches',
        'Elegant teak wood tiles, 12x12 inches. Perfect for flooring and decorative wall panels.',
        90.00, 'Warehouse N - Shelf C8', 30, '/resources/imagesdb/Wood8.jpg', NOW(), 'Available');



