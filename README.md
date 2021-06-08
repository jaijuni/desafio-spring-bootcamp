![banner promocional mercado livre](https://macoe.com.br/wp-content/uploads/2017/04/Banner-Macoe-Mercado-Livre.jpg)
# Desafio Spring - SocialMELI
Este desafio consiste na criação de uma rede social para vendedores e usuários comuns, onde um usuário pode seguir um vendedor e ver o que ele posta, e um vendedor além de ter todas as funcionalidades de um usuário normal também pode criar posts e inserir produtos promocionais pra poder divulgá-los.

## **Atenção**
Para o uso da aplicação é necessário fazer a inicialização da mesma, como o banco de dados está na memória da aplicação, deve-se rodar o endpoint `localhost:8080/init` para poder inicializar o banco de dados e inserir alguns dados de testes para o funcionamento da aplicação.
Caso queira colocar o banco de dados para ser como arquivo, basta descomentar a linha: `#spring.datasource.url=jdbc:h2:file:~/socialMeli` dentro do application.properties.
Basicamente todos os endpoints estão na mesma forma que o proposto nos requisitos técnicos, mas recomendo o uso do arquivo json pra importar todos as requisições no insomnia, pra poder já ter acesso alguns endpoints usados nos testes da aplicação
[Download Arquivo JSON](https://drive.google.com/file/d/1kfw_Edszq_68NjKxjcxROGJ0KjZhRCmx/view?usp=sharing)

##Observação:
No **12º exercicio** temos a questão de mostrar se os posts são promocionais ou não, no caso no enunciado não manda uma request específica pra cada, então para poder ajustar essa questão e mostrar somente os promos quando desejado e somente os não promos também quando desejado temos a variável promo no Path param na uri ficando assim a requisição `localhost:8080/products/2/list/?promo=false`.

#### Muito obrigado pela atenção e desejo uma ótima experiência com o Social Meli =]