CREATE TYPE order_status
    AS ENUM ('processing', 'picked', 'packing', 'onboard_for_delivery');

CREATE TABLE orders (
    id uuid PRIMARY KEY,
    address_id uuid REFERENCES address (id) NOT NULL,
    delivery_instructions text NOT NULL DEFAULT '',
    date_ordered timestamp NOT NULL DEFAULT now(),
    last_update timestamp NOT NULL DEFAULT now(),
    order_status order_status NOT NULL DEFAULT 'processing',
    customer_id uuid REFERENCES customers (id)
);

CREATE TABLE orders_products (
    id uuid PRIMARY KEY,
    order_id uuid REFERENCES orders (id) NOT NULL,
    product_id int REFERENCES products (id) NOT NULL
);

