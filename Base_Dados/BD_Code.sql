create table user (
					user_id int not null auto_increment,
					user_name VARCHAR(60) not null, 
					user_phone int not null, 					
					user_bdate date, 			
					user_password VARCHAR(15) not null, 		
					user_email VARCHAR(30) not null, 			
					primary key (user_id)	
);
		     		     
create table events (
					events_id int not null auto_increment,
					events_name VARCHAR(40) not null,
					events_latitude float(53) default 0,    
					events_longitude float(53) default 0,   
					events_idate date not null,
					events_fdate date,
					events_localphoto VARCHAR(300);  		
					primary key (events_id)
);
		           
create table lqrcode (
					lqrcode_id int not null auto_increment,
					lqrcode_qrcode VARCHAR(200),
					lqrcode_localphoto VARCHAR(300),
                    lqrcode_latitude float(53) default 0,    
                    lqrcode_longitude float(53) default 0,   
                    lqrcode_altitude float(53) default 0,    
					primary key (lqrcode_id)
);	     
		           
create table post (
					post_id int not null auto_increment,
					post_foto VARCHAR(300),		                
					post_text VARCHAR(200), 			
					primary key (post_id)
);

create table achivements (
					achivements_id int not null auto_increment,
					achivements_name VARCHAR(60),
					primary key (achivements_id)

);
		    
create table ulq (
					ulq_id int not null auto_increment,
          		    ulq_user_id int,				
					ulq_post_id int,				
					ulq_lqrcode_id int,
					primary key (ulq_id)
);		
		            		                 		     
create table lqe (
					lqe_id int not null auto_increment,
					lqe_lqrcode_id int,
					lqe_events_id int,			
					primary key (lqe_id)
);

create table achlqe (
					achlqe_id int not null auto_increment,
					achlqe_lqe_id int,
					achlqe_achivements_id int,
					primary key (achlqe_id)
);


-- Foreign Keys

alter table ulq 
add constraint ulq_fk_user
foreign key (ulq_user_id) references user(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table ulq 
add constraint ulq_fk_post
foreign key (ulq_post_id) references post(post_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;
            
alter table ulq
add constraint ulq_fk_lqrcode
foreign key (ulq_lqrcode_id) references lqrcode(lqrcode_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;            
            
alter table lqe
add constraint lqe_fk_lqrcode
foreign key (lqe_lqrcode_id) references lqrcode(lqrcode_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;            

alter table lqe
add constraint lqe_fk_events
foreign key (lqe_events_id) references events(events_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table achlqe
add constraint achlqe_fk_lqe
foreign key (achlqe_lqe_id) references lqe(lqe_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION; 

alter table achlqe
add constraint achlqe_fk_achivements
foreign key (achlqe_achivements_id) references achivements(achivements_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION; 
                        