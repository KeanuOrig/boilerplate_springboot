Features
- Service Repository Pattern
- DTO
- Used Lombok
- Standardized API Success Response Format:
		{
			"code": 200,
			"message": "Success",
			"result": []
		}
- Standardized API Error Response Format:	
		{
		    "code": 500,
		    "message": "Failed",
		    "errors": []
		}
- File based logging capability
- Flyway Migration
- Token Based Authentication
