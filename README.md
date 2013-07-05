# CepFacil

Wrapper Java para o serviço [CepFacil]. Obtenha qualquer endereço brasileiro a partir do CEP.

[![Build Status](https://travis-ci.org/rodrigoalvesvieira/cepfacil.png?branch=master)](https://travis-ci.org/rodrigoalvesvieira/cepfacil)

## Uso

```java

String zipCode = "53416-540";
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


CepFacil ufpe;
try {
    ufpe = new CepFacil("53416-540", token);
} catch (AddressNotFoundException e) {
    e.printStackTrace();
}

System.out.println(ufpe); // AVENIDA PROFESSOR LUIZ FREIRE, RECIFE 50740-540 - PE, Brasil

CepFacil masp = new CepFacil("01310-200", token);

System.out.println(masp); // AVENIDA PAULISTA, SÃO PAULO 01310-200 - SP, Brasil


// Dispara uma exeção do tipo AddressNotFoundException pois não existe
// endereço no Brasil correspondente ao CEP 00000-000

try {
    CepFacil infinitopolis = new CepFacil("00000-000", token);
} catch (AddressNotFoundException e) {
    System.out.println("oops. Fail");
    e.printStackTrace();
}
```

O objeto `ruaCasa` do exemplo acima tem 8 atributos:

`zipCode`, `apiKey`, `state`, `addressType`, `city`, `neighborhood`, `street`, `status`

a própria biblioteca trata de buscar e preencher os 6 últimos então não há métodos _getters_ para eles, obviamente.

Todos os atributos tem seus métodos _setters_.

#### Outros métodos

```java

// Recebe uma String e faz o parse desssa para formatar o CEP antes da submissão para o webservice.
String teatroBourbon = "91340-110";
CepFacil.parseZipCode(teatroBourbon); // "91340110"

// CEPs possuem 8 caracteres portanto informar um CEP que não atenda essa regra dispara uma exceção:
CepFacil.parseZipCode("53417-5400"); // dispara InvalidZipCodeException
```

A classe `CepFacil` possui também uma constante que informa a versão dela que está em funcionamento:

```java

System.out.print(CepFacil.VERSION);
```

## Autor

* Rodrigo Alves - rodrigovieira1994 [at] gmail [dot] com - http://www.rodrigoalvesvieira.com

## Agradecimentos

Obrigado ao pessoal do [CepFacil] por oferecer gratuitamente esse webservice.

## Licença

CepFacil é liberado sob a licença do Eclipse.
Veja os detalhes no arquivo LICENSE na raiz do projeto.

[CepFacil]: http://www.cepfacil.com.br
