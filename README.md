# Taco Cloud

Project from the book **Spring in Action, Fifth Edition** by Craig Walls _(from Chapter 1 to Chapter 9)_

- [:book: Official page (Manning Publications)](https://www.manning.com/books/spring-in-action-sixth-edition)

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Description](#description)
- [Project Summary](#project-summary)
- [API Documentation](#api-documentation)
  - [Get Recent Tacos](#get-recent-tacos)
  - [Get Tacos](#get-tacos)
  - [Get Ingredients](#get-ingredients)
  - [Get Orders](#get-orders)
  - [Get Users](#get-users)
  - [Get API Home](#get-api-home)
  - [Get Taco by ID](#get-taco-by-id)
  - [Get Ingredient by ID](#get-ingredient-by-id)
- [Deployment](#deployment)

## Description

From the book:

> "Through the course of this book, you’ll create Taco Cloud, an online application for ordering the most wonderful food created by man—tacos. Of course, you’ll use Spring, Spring Boot, and a variety of related libraries and frameworks to achieve this goal."

## Project Summary

- Project: Maven
- Java: 11
- Spring Boot: 2.4.5
- Dependencies
  - Thymeleaf
  - Spring Web
  - Spring Boot DevTools
  - Spring Boot Starter Test
  - Spring Boot Starter
  - Lombok
  - Validation
  - H2 Database
  - Spring Data JPA
  - Spring Security
  - Spring HATEOAS
  - Rest Repositories
  - Bucket4j Spring Boot Starter
  - Spring Cache Abstraction
  - Ehcache
- Plugins
  - Spring Boot Maven Plugin
  - Heroku Maven Plugin

## API Documentation

### Get Recent Tacos

Retrieves a list of the last 12 tacos created.

#### Request

```http
GET /api/tacos/recent
```

#### Sample Response (200 OK)

```json
{
    "_embedded": {
        "tacos": [
            {
                "name": "Taco 3",
                "createdAt": "2021-08-23T03:09:05.388+00:00",
                "ingredients": {
                    "..."
                },
                "_links": {
                    "self": {
                        "href": "https://safe-caverns-88645.herokuapp.com/design/3"
                    }
                }
            },
            
            "..."
        ]
    },
    "_links": {
        "recents": {
            "href": "https://safe-caverns-88645.herokuapp.com/tacos/recent"
        }
    }
}
```

### Get Tacos

Retrieves a list of all tacos.

#### Request

```http
GET /api/tacos
```

#### Sample Response (200 OK)

```json
{
    "_embedded": {
        "tacos": [
            {
                "createdAt": "2021-08-23T03:09:05.388+00:00",
                "name": "Taco 3",
                "_links": {
                    "self": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/tacos/3"
                    },
                    "taco": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/tacos/3"
                    },
                    "ingredients": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/tacos/3/ingredients"
                    }
                }
            },
       
            "..."
        ]
    },
    "_links": {
        "self": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/tacos"
        },
        "profile": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/profile/tacos"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 4,
        "totalPages": 1,
        "number": 0
    }
}
```

### Get Ingredients

Retrieves a list of all ingredients.

#### Request

```http
GET /api/ingredients
```

#### Sample Response (200 OK)

```json
{
    "_embedded": {
        "ingredients": [
            {
                "name": "Ingredient X",
                "type": "WRAP",
                "_links": {
                    "self": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/ingredients/INGRX"
                    },
                    "ingredient": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/ingredients/INGRX"
                    }
                }
            },
            
            "..."
        ]
    },
    "_links": {
        "self": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/ingredients"
        },
        "profile": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/profile/ingredients"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 10,
        "totalPages": 1,
        "number": 0
    }
}
```

### Get Orders

Retrieves a list of all orders.

#### Request

```http
GET /api/orders
```

#### Sample Response (200 OK)

```json
{
    "_embedded": {
        "orders": [
            {
                "placedAt": "2021-08-23T03:09:05.394+00:00",
                "deliveryName": "Name",
                "deliveryStreet": "Street",
                "deliveryCity": "City",
                "deliveryState": "ST",
                "deliveryZip": "12345678",
                "ccNumber": "1111222233334444",
                "ccExpiration": "03/30",
                "ccCVV": "123",
                "_links": {
                    "self": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/orders/5"
                    },
                    "order": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/orders/5"
                    },
                    "user": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/orders/5/user"
                    },
                    "tacos": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/orders/5/tacos"
                    }
                }
            },
            
            "..."
        ]
    },
    "_links": {
        "self": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/orders"
        },
        "profile": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/profile/orders"
        },
        "search": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/orders/search"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 2,
        "totalPages": 1,
        "number": 0
    }
}
```

### Get Users

Retrieves a list of all users.

#### Request

```http
GET /api/users
```

#### Sample Response (200 OK)

```json
{
    "_embedded": {
        "users": [
            {
                "username": "username",
                "password": "...",
                "fullname": "User",
                "street": "Street",
                "city": "City",
                "state": "ST",
                "zip": "12345678",
                "phoneNumber": "999999999",
                "enabled": true,
                "authorities": [
                    {
                        "authority": "ROLE_USER"
                    }
                ],
                "accountNonExpired": true,
                "accountNonLocked": true,
                "credentialsNonExpired": true,
                "_links": {
                    "self": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/users/1"
                    },
                    "user": {
                        "href": "https://safe-caverns-88645.herokuapp.com/api/users/1"
                    }
                }
            },
            
            "..."
        ]
    },
    "_links": {
        "self": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/users"
        },
        "profile": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/profile/users"
        },
        "search": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/users/search"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 1,
        "totalPages": 1,
        "number": 0
    }
}
```

### Get API Home

Retrieves a list of all API links.

#### Request

```http
GET /api
```

#### Sample Response (200 OK)

```json
{
    "_links": {
        "tacos": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/tacos{?page,size,sort}",
            "templated": true
        },
        "orders": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/orders{?page,size,sort}",
            "templated": true
        },
        "users": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/users{?page,size,sort}",
            "templated": true
        },
        "ingredients": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/ingredients{?page,size,sort}",
            "templated": true
        },
        "profile": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/profile"
        }
    }
}
```

### Get Taco by ID

Retrieves a taco by ID.

#### Request

```http
GET /api/tacos/:id
```

#### Sample Response (200 OK)

```json
{
    "createdAt": "2021-08-23T03:09:05.363+00:00",
    "name": "Taco 2",
    "_links": {
        "self": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/tacos/2"
        },
        "taco": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/tacos/2"
        },
        "ingredients": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/tacos/2/ingredients"
        }
    }
}
```

### Get Ingredient by ID

Retrieves a ingredient by ID.

#### Request

```http
GET /api/ingredients/:id
```

#### Sample Response (200 OK)

```json
{
    "name": "Ingredient X",
    "type": "WRAP",
    "_links": {
        "self": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/ingredients/INGRX"
        },
        "ingredient": {
            "href": "https://safe-caverns-88645.herokuapp.com/api/ingredients/INGRX"
        }
    }
}
```

## Deployment

App (Web and API) deployed on [Heroku](https://safe-caverns-88645.herokuapp.com/)
