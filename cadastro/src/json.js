var x = {
	"nome" : "John Malkovich",
	"email" : "john.malkovich@gmail.com",
	"nascimento" : "1953-09-12",
	"telefone" : "(71) 1234-5678",
};

var k = [ {
	"property" : "email",
	"message" : "não é um endereço de e-mail"
} ];


insert 
into
    Pessoa
    (email, nascimento, nome, telefone, id) 
values
    (?, ?, ?, ?, ?)


//
//
// curl -X POST -H "Content-Type: application/json" \
// -d "{ \
// 'nome' : 'John Malkovich', \
// 'email' : 'john.malkovich.gmail.com', \
// 'nascimento' : '1953-09-12', \
// 'telefone' : '(71) 1234-5678' \
// };" http:// localhost:8080/cadastro/api/pessoa
//	
//
// curl -X POST -H "Content-Type: application/json" \
// -d "{ \
// \"nome\": \"John Malkovich\", \
// \"email\": \"john.malkovich.gmail.com\", \
// \"nascimento\": \"1953-09-12\", \
// \"telefone\": \"(71) 1234-5678\" \
// };" http:// 192.168.15.101:8080/cadastro/api/pessoa
