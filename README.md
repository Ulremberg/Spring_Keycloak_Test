# Spring e Keycloak

Criando um container para o Keycloak

```
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:24.0.3 start-dev
```
Acessando console do Keycloak: http://localhost:8080/admin

Variáveis usadas:

```
JWT_ISSUER=${localhost:port}/realms/${realm-name}

JWT_JWK_SET=${localhost:port}/realms/${realm-name}/protocol/openid-connect/certs
```

### Configurando Keycloak
Criar o realm em "Create realm" onde há a branch master do Keycloak

Em "Client" criar um novo client, ao criar pegar o "Client Secret" que será usado na request "client_id"

Em "Authentication" desabilitar as opções em "Required actions" uma vez que ao criar um usuário, por padrão, ele precisa validar algum tipo de dado

Criar roles em "Realm roles" que será atribuído aos usuários.

Na opção "Users" criar novos usuários, atribuir senha em "Credentials" (será usada em "grant_type" como password) e cargo em "Role mapping"



### Exemplo de request para gerar token usando senha:

```
POST /realms/{REALM_NAME}/protocol/openid-connect/token HTTP/1.1
Content-Type: application/x-www-form-urlencoded
User-Agent: insomnia/9.1.0
Host: localhost:8080
Content-Length: 123

client_id={CLIENT_ID}&client_secret={CLIENT_SECRET}&grant_type=password&username={USERNAME}%40user.com&password={PASSWORD}

```