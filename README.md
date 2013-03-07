# CepFacil for Java

Wrapper Java para o serviço [CepFacil]

Obtenha qualquer endereço brasileiro a partir do CEP

## Uso

```java

String zipCode = "53417-540";
String token = "0E2ACA03-FC7F-4E87-9046-A8C46637BA9D"; // obtenha o seu em www.cepfacil.com.br

CepFacil ruaCasa = new CepFacil(zipCode, token);

ruaCasa.getZipCode(); // 53416-540

ruaCasa.getCity(); // PAULISTA

ruaCasa.getStreet(); // PANELAS

ruaCasa.isValid(); // retorna true se o endereço for encontrado, do contrário retorna false.

// Invocando o método toString(); você obtém o endereço por extenso:

System.out.println(ruaCasa); // RUA PANELAS, PAULISTA 53416-540 - PE, Brasil

// Para uma versão do método toString(); que inclui o atributo bairro (neighborhood)
// você pode usar um outro método, chamado fullAddress();

ruaCasa.fullAddress(); // RUA PANELAS, ARTUR LUNDGREN II, PAULISTA 53416-540 - PE, Brasil

CepFacil ufpe = new CepFacil("50740-540", token);

System.out.println(ufpe); // AVENIDA PROFESSOR LUIZ FREIRE, RECIFE 50740-540 - PE, Brasil

CepFacil masp = new CepFacil("01310-200", token);

System.out.println(masp); // AVENIDA PAULISTA, SÃO PAULO 01310-200 - SP, Brasil

```

O objeto rua `ruaCasa` tem 8 atributos:

`zipCode`, `apiKey`, `state`, `addressType`, `city`, `neighborhood`, `street`, `status`

a própria biblioteca trata de buscar e preencher os 6 últimos então não há métodos _getters_ para eles, obviamente.

Todos os atributos tem seus métodos _setters_.

A classe `CepFacil` possui também uma constante que informa a versão dela que está em funcionamento:

```java

System.out.print(CepFacil.VERSION);

```

## Autor

* Rodrigo Alves Vieira - rodrigovieira1994@gmail.com - http://www.rodrigoalvesvieira.com

## Agradecimentos

Obrigado ao pessoal do [CepFacil] por oferecer gratuitamente esse webservice.

## Doações

Se esse projeto é tão útil para você que lhe faz considerar fazer alguma doação, ao invés de me pagar uma cerveja (o que seria um boa ideia, com certeza) considere doar para o [Khan Academy](https://www.khanacademy.org/).

## Licença

CepFacil é liberado sob a licença do Eclipse.
Veja os detalhes no arquivo LICENSE desse repositório.

[CepFacil]: http://www.cepfacil.com.br
