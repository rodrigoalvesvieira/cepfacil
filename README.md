# CepFacil for Java

Wrapper Java para o serviço [CepFacil]

## Uso

```java

String zipCode = "53417-540";
String token = "0E2ACA03-FC7F-4E87-9046-A8C46637BA9D"; // obtenha o seu em www.cepfacil.com.br

CepFacil ruaCasa = new CepFacil(zipCode, token);

ruaCasa.getZipCode();

ruaCasa.getCity();

ruaCasa.getNeighborhood();

ruaCasa.isValid(); // retorna true caso o endereço tenha sido encontrado, do contrário retorna false. Essa tu advinhou, hein?

// Invocando o método toString(); você obtém o endereço por extenso:

System.out.println(ruaCasa); // RUA PANELAS, PAULISTA 53416-540 - PE, Brasil

// Para uma versão do método toString(); que inclui o atributo bairro (neighborhood)
// você pode usar um outro método, chamado fullAddress();

ruaCasa.fullAddress(); // RUA PANELAS, ARTUR LUNDGREN II, PAULISTA 53416-540 - PE, Brasil

```

O objeto rua `ruaCasa` tem 8 atributos:

`zipCode`, `apiKey`, `state`, `addressType`, `city`, `neighborhood`, `street`, `status`

a própria biblioteca trata de buscar e preencher os 6 últimos então não há métodos _getters_ para eles, obviamente.

Todos os atributos tem seus métodos _setters_.

## Autor

* Rodrigo Alves Vieira - rodrigovieira1994@gmail.com - http://www.rodrigoalvesvieira.com

## Agradecimentos

Obrigado ao pessoal do [CepFacil] por oferecer gratuitamente esse webservice.

## Doações

Se esse projeto é tão útil para você que lhe faz considerar fazer alguma doação, ao invés de me pagar uma cerveja (o que seria um boa ideia, com certeza) considere doar para o [Khan Academy](https://www.khanacademy.org/).

## Licença

CepFacil é liberado sob a licença do Eclipse com atribuições a Rodrigo Alves Vieira.
Veja os detalhes no arquivo LICENSE desse repositório.

[CepFacil]: http://www.cepfacil.com.br