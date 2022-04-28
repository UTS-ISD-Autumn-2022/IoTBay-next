CREATE TABLE categories (
    id serial PRIMARY KEY,
    name varchar (255) NOT NULL,
    description text NOT NULL,
    img_url varchar (255) NOT NULL
);

CREATE TABLE products (
    id serial PRIMARY KEY,
    name varchar (255) NOT NULL,
    description text NOT NULL,
    category_id int REFERENCES categories (id) NOT NULL,
    stock_level int NOT NULL DEFAULT 0,
    order_level int NOT NULL DEFAULT 0,
    price money NOT NULL
);

CREATE TABLE product_images (
    id serial PRIMARY KEY,
    product_id int REFERENCES products (id) NOT NULL,
    img_url varchar (255) NOT NULL
);

INSERT INTO categories (name, description, img_url)
VALUES
    ('Embedded Computers, Education & Maker Boards', 'Low cost, rapid prototyping and development with the latest range of embedded computers. Choose from a range of ready-made boards, many with wifi connectivity that act as a gateway device for IoT, reducing both the cost and complexity of designing your own solution from scratch. Whatever your use type or application, choose from a complete ecosystem of Single Board Computers, expansion boards and peripherals that encourage and enable your creative ideas to become a reality.', 'https://au.element14.com/wcsstore/ExtendedSitesCatalogAssetStore/cms/asset/images/apac/common/homepage_new/dev-kits.jpg');

INSERT INTO products (name, description, category_id, stock_level, order_level, price)
VALUES
    ('MINI1857.', 'Daughter Board, MINI1857 Core Board, LPC1857FET256 MCU, 2x SPI Interfaces, 3x UART Interfaces', 1, 0, 0, 59.99),
    ('ATOLED1-XPRO', 'Expansion Board, OLED1 Xplained Pro, OLED Display 128x32 (SPI), Auto-ID for Board Identification', 1, 0, 0, 69.99),
    ('ATIO1-XPRO', 'Expansion Board, I/O1 Xplained Pro, For Xplained Pro, 2GB MicroSD Card, Temperature/Light sensor', 1, 0, 0, 74.50);
