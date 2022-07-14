INSERT INTO ecommercedb.categories (category_name,description,image_url) VALUES
	 ('Clothes','Mongolian clothes','https://images.unsplash.com/photo-1567401893414-76b7b1e5a7a5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80'),
	 ('Shoes','Mongolian shoes','https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Skor_fr%C3%A5n_1700-_till_1960-talet_-_Nordiska_Museet_-_NMA.0056302.jpg/1024px-Skor_fr%C3%A5n_1700-_till_1960-talet_-_Nordiska_Museet_-_NMA.0056302.jpg'),
	 ('Jewelry','Mongolian jewelry','https://www.thermofisher.com/blog/metals/wp-content/uploads/sites/4/2020/07/istock-533556062_scrapsilver.jpg');
INSERT INTO ecommercedb.products (description,imageurl,name,price,category_id) VALUES
	 ('Mongolian tradional deel','https://mongolianstore.com/wp-content/uploads/2017/12/Mongolian-Men-Deel-2-600x713.jpg','Deel',300.0,1),
	 ('Mongolian traditional shoes','https://i.etsystatic.com/20826271/r/il/2911fc/2525999725/il_1140xN.2525999725_40t9.jpg','Mongolian shoes',100.0,2),
	 ('Mongolian traditional silver bowl','https://cdn.zochil.shop/ef5d361b-b3ff-444f-9ce5-8f5d3407258f_t1500.jpg','Silver bowl',150.0,3),
     ('Mongolian Nomadic House','https://mongoliainstitute.anu.edu.au/sites/default/files/styles/news-440-229/public/ger_440x229.png?itok=tKGZI3lg','Mongolian Nomadic House',4900.0,1),
	 ('Handmade silver bowl','https://resource.market.sodonsolution.org/olz/product/2018/09/14/va1z657c51nyx6lf/imageFile_m.jpg','Silver bowl',990.0,1),
	 ('Mongolian saddle of horse','https://cdn.zochil.shop/af5977af-13aa-4929-8520-87b7e06091eb_t1500.jpg','Saddle',7900.0,1),
	 ('Mongolia Leather FULL Body Armor Costume ','https://i.etsystatic.com/25289394/r/il/14ec7f/3427112688/il_1140xN.3427112688_bwsc.jpg','Armor Costume ',2500.0,2),
	 ('Mongolia Culture Shoes(Handmade)','https://www.mongolianz.com/wp-content/uploads/2020/03/16-ugalztai-300-1-1-scaled.jpg','Shoes',190.0,2),
	 ('Mongolian woman''s headdress','https://pbs.twimg.com/media/EhY6LZFUwAEevSW?format=jpg&name=small','Headdress',6900.0,2);
INSERT INTO ecommercedb.users (email,first_name,last_name,password,`role`) VALUES
	 ('admin@admin.com','admin','admin','21232F297A57A5A743894A0E4A801FC3','user');