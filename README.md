

## Эндпоинты
## port= 8081
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

# postgreSQL