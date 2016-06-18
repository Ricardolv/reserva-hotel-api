# Reserva de hotel

Uma rede de hoteis operando em Belo Horizonte deseja oferecer serviços de reserva
online. Eles possuem três hotéis: The Carlyle, The Plaza e Royal Hotel. Cada hotel
tem preços diferentes durante à semana e final de semana. Existem ainda preços
diferenciados para clientes vip. 

## Cada hotel tem uma quantidade de estrelas associada a ele:

```
  - The Carlyle possui 3 estrelas, sua diária durante à semana é R$110 para
    clientes regulares e R$80 para clientes vips. Durante o fim de semana os
    preços são R$90 para clientes regulares e R$80 para clientes vips.
    
  - The Plaza possui 4 estrelas, sua diária durante à semana é R$160 para
    clientes regulares e R$110 para clientes vips. Durante o fim de semana os
    preços são R$60 para clientes regulares e R$50 para clientes vips.
  
  - Royal Hotel possui 5 estrelas, sua diária durante à semana é R$220 para
    clientes regulares e R$100 para clientes vips. Durante o fim de semana os
    preços são R$150 para clientes regulares e R$40 para clientes vips.
```
O software deverá encontrar o melhor hotel para o cliente se hospedar. O melhor
hotel é aquele que fornecer o melhor preço no total de diárias. Em caso de empate de
preços, o hotel com mais estrelas deverá ser retornado.

##Exemplo de entrada:
  1. Regular: 16Mar2015(seg), 17Mar2015(ter), 18Mar2015(qua)
  2. Regular: 20Mar2015(sex), 21Mar2015(sab), 22Mar2015(dom)
  3. Vip: 26Mar2015(qui), 27Mar2015(sex), 28Mar2015(sab)

##Saída esperada:
  1. The Carlyle: R$330
  2. The Plaza: R$280
  3. Royal Hotel: R$240

## Como rodar reserva-hotel-api
```
git clone https://github.com/Ricardolv/reserva-hotel-api.git

cd reserva-hotel-api
mvn clean install
cd target

java -jar reserva-hotel-1.0.jar /path/input-data.txt 
obs: reserva-hotel-api/src/main/resources/input-data.txt

ou

java -jar reserva-hotel-1.0.jar
```



