<<<<<<< Updated upstream

=======
## Ветка t1  Первое задание. 

## port = 8081
>>>>>>> Stashed changes

### Получить все товары
`GET /api/items`

### Получить товар по ID
`GET /api/items/{id}`

### Создать новый товар
`POST /api/items`
- **Тело запроса**: JSON с полями `name`, `description`, `price`, `inStock`.

### Обновить товар
`PUT /api/items/{id}`
- **Тело запроса**: JSON с обновленными полями товара.

### Удалить товар
`DELETE /api/items/{id}`

### Удалить все товары
`DELETE /api/items`

<<<<<<< Updated upstream
# postgreSQL
=======
## Ветка t2  Второе задание. 

Добавлено соединение с СУБД Postgres

###Создание таблиц происходит при запуске приложения, если таких таблиц нет в СУБД при помощи initDB.sql

## Ветка t3  Третье задание. 
  
### Созданы образы при помощи
 - Dockerfile
 - docker-compose.yml
 - СУБД Postgres добавлена в docker-compose.yml

## Ветка t4  Четвертое задание. 

### Добавлен метод sortingAndFiltering в ItemService, производит фильтрацию, сортировку, пагинацию и валидацию данных


## Ветка t5  Пятое задание. 

### Добавлены сущности ItemDelivery и ItemSold.
### Добавлены репозитории и сервисы для  ItemDelivery и ItemSold.
### Созданы контроллеры для  ItemDelivery и ItemSold.

### Получить все доставки
`GET /api/deliveries`

### Получить доставку по ID
`GET /api/deliveries/{id}`

### Создать новую доставку
`POST /api/deliveries`
- **Тело запроса**: JSON с полями `nameOfDocument`, `item: {'name', 'description', 'price', 'inStock','amountToSell'}`, `quantity`.

### Обновить доставку
`PUT /api/deliveries/{id}`
- **Тело запроса**: JSON с обновленными полями товара.

### Удалить доставку
`DELETE /api/deliveries/{id}`

### Удалить все доставки
`DELETE /api/deliveries`


### Получить все продажи
`GET /api/sales`

### Получить продажу по ID
`GET /api/sales/{id}`

### Создать новую продажу
`POST /api/sales`
- **Тело запроса**: JSON с полями `nameOfDocument`, `item: {'name', 'description', 'price', 'inStock','amountToSell'}`, `quantity`, 'cost'.

### Обновить продажу
`PUT /api/sales/{id}`
- **Тело запроса**: JSON с обновленными полями товара.

### Удалить продажу
`DELETE /api/sales/{id}`

### Удалить все продажи
`DELETE /api/sales`

>>>>>>> Stashed changes
