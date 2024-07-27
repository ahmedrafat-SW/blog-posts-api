# API Documentation

## User API

### Get All Users

- **Endpoint**: `GET /api/v1/users`
- **Description**: Retrieves a list of all users.
- **Response**:
  - **200 OK**: List of `UserDTO` objects.

### Get User By ID

- **Endpoint**: `GET /api/v1/users/{id}`
- **Description**: Retrieves a user by their ID.
- **Path Parameters**:
  - `id` (Long): ID of the user.
- **Response**:
  - **200 OK**: `UserDTO` object.
  - **404 Not Found**: If the user with the specified ID is not found.

### Create User

- **Endpoint**: `POST /api/v1/users/register`
- **Description**: Registers a new user.
- **Request Body**: `User` object
  - **Fields**:
    - `userId` (Long): Unique ID of the user.
    - `firstName` (String): First name of the user.
    - `lastName` (String): Last name of the user.
    - `email` (String): Email address of the user.
- **Response**:
  - **201 Created**: User created successfully.
  - **400 Bad Request**: If the email already exists.

### Delete User

- **Endpoint**: `DELETE /api/v1/users/delete/{id}`
- **Description**: Deletes a user by their ID.
- **Path Parameters**:
  - `id` (Long): ID of the user.
- **Response**:
  - **200 OK**: User deleted successfully.
  - **404 Not Found**: If the user with the specified ID is not found.

## Blog API

### Get All Blogs

- **Endpoint**: `GET /api/v1/blogs`
- **Description**: Retrieves a list of all blogs.
- **Response**:
  - **200 OK**: List of `BlogDTO` objects.

### Get Blog By ID

- **Endpoint**: `GET /api/v1/blogs/{id}`
- **Description**: Retrieves a blog by its ID.
- **Path Parameters**:
  - `id` (int): ID of the blog.
- **Response**:
  - **200 OK**: `BlogDTO` object.
  - **404 Not Found**: If the blog with the specified ID is not found.

### Create Blog

- **Endpoint**: `POST /api/v1/blogs`
- **Description**: Creates a new blog.
- **Request Body**: `BlogDTO` object
  - **Fields**:
    - `id` (int): Unique ID of the blog.
    - `title` (String): Title of the blog.
    - `content` (String): Content of the blog.
- **Response**:
  - **201 Created**: `BlogDTO` object with the created blog.

### Update Blog Content

- **Endpoint**: `PUT /api/v1/blogs/edit/{id}`
- **Description**: Updates the content of a blog.
- **Path Parameters**:
  - `id` (int): ID of the blog.
- **Request Body**: `BlogDTO` object
  - **Fields**:
    - `title` (String): Title of the blog.
    - `content` (String): Content of the blog.
- **Response**:
  - **200 OK**: `BlogDTO` object with the updated blog.
  - **404 Not Found**: If the blog with the specified ID is not found.

### Delete Blog

- **Endpoint**: `DELETE /api/v1/blogs/delete/{id}`
- **Description**: Deletes a blog by its ID.
- **Path Parameters**:
  - `id` (int): ID of the blog.
- **Response**:
  - **200 OK**: Blog deleted successfully.
  - **404 Not Found**: If the blog with the specified ID is not found.

## Author API

### Get All Authors

- **Endpoint**: `GET /api/v1/authors`
- **Description**: Retrieves a list of all authors.
- **Response**:
  - **200 OK**: List of `AuthorDTO` objects.

### Get Author By First Name

- **Endpoint**: `GET /api/v1/authors/name`
- **Description**: Retrieves an author by their first name.
- **Request Parameters**:
  - `firstName` (String): First name of the author.
- **Response**:
  - **200 OK**: `AuthorDTO` object.
  - **404 Not Found**: If the author with the specified first name is not found.

### Get Author By ID

- **Endpoint**: `GET /api/v1/authors/{id}`
- **Description**: Retrieves an author by their ID.
- **Path Parameters**:
  - `id` (Long): ID of the author.
- **Response**:
  - **200 OK**: `AuthorDTO` object.
  - **404 Not Found**: If the author with the specified ID is not found.

### Save Author

- **Endpoint**: `POST /api/v1/authors`
- **Description**: Registers a new author.
- **Request Body**: `AuthorDTO` object
  - **Fields**:
    - `id` (Long): Unique ID of the author.
    - `name` (String): Name of the author.
    - `email` (String): Email of the author.
- **Response**:
  - **201 Created**: `AuthorDTO` object with the created author.

### Update Author Data

- **Endpoint**: `PUT /api/v1/authors/edit/{id}`
- **Description**: Updates an author's data.
- **Path Parameters**:
  - `id` (Long): ID of the author.
- **Request Body**: `AuthorDTO` object
  - **Fields**:
    - `name` (String): Name of the author.
    - `email` (String): Email of the author.
- **Response**:
  - **200 OK**: `AuthorDTO` object with the updated author.
  - **404 Not Found**: If the author with the specified ID is not found.

### Delete Author

- **Endpoint**: `DELETE /api/v1/authors/delete/{id}`
- **Description**: Deletes an author by their ID.
- **Path Parameters**:
  - `id` (Long): ID of the author.
- **Response**:
  - **200 OK**: Author deleted successfully.
  - **404 Not Found**: If the author with the specified ID is not found.




### Blog Post React.Js: https://github.com/ahmedrafat-SW/Personal-Blog
