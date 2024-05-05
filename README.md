# Spring e Keycloak

Criando um container para o Keycloak

```
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:24.0.3 start-dev
```
Acessando console do Keycloak: http://localhost:8080/admin

Variáveis usadas:
JWT_ISSUER=${localhost:port}/realms/${realm-name}

JWT_JWK_SET=${localhost:port}/realms/${realm-name}/protocol/openid-connect/certs
