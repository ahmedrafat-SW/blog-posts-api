
insert into AUTHORS (FIRST_NAME, LAST_NAME, BIO, job_title, phone, photo_path, EMAIL, PASSWORD)
values ( 'John', 'sena', 'john sena is a boxing player play in usa wwe ',
        'Sales Engineer','643-241-988','john.jpeg','johnsena@hotmail.com','qwrew32423');

insert into AUTHORS ( FIRST_NAME, LAST_NAME, BIO, job_title, phone, photo_path, EMAIL, PASSWORD)
values ( 'Frank', 'PMoley', 'Frank Moley is a passionate software developer, architect, student,' ||
                                'and teacher.Frank has built everything from small, single-function internal applications to large-scale,' ||
                                'globally distributed platforms. From an architecture and development perspective, ' ||
                                'he focuses on building platforms using modern application architectures and containerization of systems in multi-cloud,' ||
                                'public and private cloud, and hybrid offerings. Frank''s drivers extend beyond developing software into security,' ||
                                'data design and modeling, DevOps, agility, and quality. His greatest professional passion is education, ' ||
                                'as both a teacher and student. Frank strives to learn something new every day and then teach it to as many people as he can.'
                                ,'Software Architect','632- 435-108'
                                ,'frank.jpeg','FrankMoley@gmail.com','atrwer1324');

insert into AUTHORS ( FIRST_NAME, LAST_NAME, BIO, job_title, phone, photo_path, EMAIL, PASSWORD)
values (  'Martine', 'Moses', 'Martine has over twenty years of experience in the design, development, and testing of distributed systems. ' ||
                                 'She is a senior software engineer at ASAPP in New York City and earned a BA in computer science from The Johns Hopkins University.'
                            ,'Software Engineer','142- 234- 807','matine.jpeg',
                            'Moses@outlock.com','qwrew32423');

insert into BLOGS ( BLOG_TITLE, BLOG_BODY, PUBLISH_DATE, AUTHOR_ID)
values ( 'How to execute .sql file in PostgreSQL',
        'In this tutorial, we will see how to execute .sql file in PostgreSQL. We can execute/run .sql or script file from following methods.1. From the Linux shell 2. From the psql tool'
        , '03/07/2023',1);

insert into USERS ( FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)
values ( 'mahmoud', 'rafat', 'mahmoudrafat@gmail.com', 'fsdfqw523423' );


insert into BLOGS ( BLOG_TITLE, BLOG_BODY, PUBLISH_DATE, AUTHOR_ID)
values ( 'Go REST API Server',
         'Go is one of the hottest programming languages today.' ||
         ' Familiarity with it empowers you to go after a job or project that uses Go as its programming language.' ||
         ' In this course, instructor Martine Moses goes over golang basics, ' ||
         'such as project layout, creating Go modules,' ||
         ' and importing your own libraries and modules or third-party libraries and modules.' ||
         ' She also shows you the processes for creating a rest server,' ||
         ' creating routers and handlers, and working with a database.'
           , '03/07/2023',3);



insert into BLOGS ( BLOG_TITLE, BLOG_BODY, PUBLISH_DATE, AUTHOR_ID)
values ('Build a Microservice with Go',
         'Go has risen as a powerful language selection for programs that rely on concurrency and speed,' ||
         ' making it a great option for the development of GRPC- or REST-based web services. Because of its popularity,' ||
         ' patterns have arisen that make building web services using Go much easier.' ||
         ' These patterns include the two most common abstractions: HTTP request response handling and data access.' ||
         ' In this course, software architect and developer Frank Moley guides you through the process of building microservices with Go.' ||
         ' Get started in Go by preparing and setting up your environment, project, and clients.' ||
         ' Go through the full process of building a service, including multiple challenges and solutions to check your understanding.' ||
         ' Plus, learn how to use GORM to read and write data to a database and how to use the Echo middleware framework.'
           , '03/07/2023',2);