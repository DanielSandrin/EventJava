# API de castro de Eventos.

Api foi criada para estudo da linguagem Java, utilizando as seguintes Tecnologias 🛠.
  - Java 21
  - Spring Boot
  - Docker
  - Postgres
  - Amazon S3 (Utilizado localStack devido ao custo do S3)

# Sobre API
Api tem como objetivo o cadastro de eventos em uma determinada cidade, tendo a possibilidade de cadastrar o endereço e de cupons para desconto associado aos eventos.

# Rotas
<b>Post: </b><i>/api/coupon/event/{eventId}</i> 
 - Permite realizar a criação dos cupons e associalos ao evento
<b>Post: </b><i>/api/event/</i>
 - Permite cadastras os eventos, ele recebe um objeto no formato multi-part pois o payload comporta o envio de imagens junto com os de mais dados do evento:
   
<b>Get: </b><i>/api/event/</i>
  - Retorna Eventos que estão para acontecer de forma paginada.
    
<b>Get: </b><i>/api/event/filter</i>
  - Retorna eventos cujo a data pode ser informada pelo usuário em formato ISO ex: startDate:"2025-04-08T00:00:00Z" endDate: "2025-04-08T00:00:00Z"
    pode ser informado mais parâmetros como title,city,uf,page,size. Sendo size a quantidade de registros retornado pela pagina.
    
<b>Get: </b><i>/api/event/{eventId}</i>
  - Essa rota retorna um evento de um determinado ID com os dados de cupons vinculados. 
