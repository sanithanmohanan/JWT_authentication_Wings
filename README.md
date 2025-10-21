# JWT Demo

Simple Spring Boot application demonstrating JWT authentication (study purpose).

Endpoints
- POST /auth/login  -> { "username": "user", "password": "password" }
  returns { "token": "..." }
- GET /api/hello -> protected, send Authorization: Bearer <token>

Build & run

- Build: mvn package
- Run: mvn spring-boot:run

Example using curl (Windows PowerShell):

$login = @'{"username":"user","password":"password"}'@
curl -Method POST -Uri http://localhost:8080/auth/login -Body $login -ContentType 'application/json'

Then call protected endpoint (replace <token>):

curl -Method GET -Uri http://localhost:8080/api/hello -Headers @{ Authorization = "Bearer <token>" }

Notes
- Secret key is hard-coded for study only. Do not use in production.
- Uses an in-memory user (username: user, password: password).
