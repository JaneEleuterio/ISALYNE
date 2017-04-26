Serviços:

MasterCardA - Porta 8183
MasterCardB - Porta 8184
VisaA - Porta 8180
VisaB - Porta 8181
VisaC - Porta 8182

1. Gerar os JARs de cada uma das classes do package com.webservice.server com a opção "Package required libraries into generated JAR";
2. Colocar todos os JARs na mesma pasta;
3. Copiar a pasta db para a mesma pasta onde se encontram os JARs.

Estrutura Sugerida:

Arquivos JARs em C:\WebService\
Pasta db no mesmo diretório, ficando C:\WebService\db\

Abrir um console para cada serviço e executar o seguinte comando:
java -jar {nome do servico}.jar