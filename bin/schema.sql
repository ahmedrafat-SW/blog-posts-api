create table blogs (
                       blog_id bigserial PRIMARY KEY  ,
                       blog_title varchar(255) not null ,
                       blog_body text not null ,
                       publish_date date,
                       author_id bigint not null
);

create table authors(
                        author_id bigserial PRIMARY KEY ,
                        first_name varchar(255) not null,
                        last_name varchar(255) not null ,
                        bio text ,
                        phone varchar(50)  not null  default ('1234 534 543'),
                        job_title varchar(255) not null default ('Software Engineer'),
                        photo_path varchar(255),
                        email varchar(255) not null ,
                        password varchar(255) not null
);


create table users(
                      user_id bigserial PRIMARY KEY,
                      first_name varchar(255) not null ,
                      last_name varchar(255) not null ,
                      email varchar(255) not null ,
                      password varchar(255) not null
);

create table authors_blogs (author_id bigserial not null , blog_id bigserial not null );
alter table authors_blogs add foreign key (author_id) references authors(author_id);
alter table authors_blogs add foreign key (blog_id) references blogs(blog_id);
alter table authors_blogs rename column  authors_author_id TO  author_id;
alter table authors_blogs rename column blog_id TO blogs_blog_id;

alter table blogs add foreign key (author_id) references authors(author_id);



-- alter table authors
--     add column phone varchar(50)  not null  default ('1234 534 543');
-- alter table authors
--     add column job_title varchar(255) not null default ('Software Engineer');
-- alter table authors
--     add column photo_path varchar(255);

-- CREATE SEQUENCE users_id_seq;
-- ALTER TABLE users
--     ALTER COLUMN user_id SET INCREMENT BY 1;
--
-- CREATE SEQUENCE authors_id_seq;
-- ALTER TABLE authors
--     ALTER COLUMN author_id  ;
--
-- CREATE SEQUENCE blogs_id_seq;
-- ALTER TABLE blogs
--     ALTER COLUMN blog_id SET DEFAULT nextval('blogs_id_seq');

