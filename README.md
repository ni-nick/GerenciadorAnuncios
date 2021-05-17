# GerenciadorAnuncios


O presente projeto é um Gerenciador de Anúncios construído no Eclipse Java, onde possibilita o usuário a cadastrar um cliente com nome e CPF, cadastrar anúncios com nome, data de início e término e o quanto será investido, e vincular um cliente ao anúncios. O sistema possuí uma interface bem simples com telas separadas e nomes expressivos para melhor entendimento.

No arquivo chamado "Gerenciador de Anuncios" possuí a pasta 'src', onde contém as packages e classes utilizadas para construir o sistema, estas estão divididas em 4 packages:

-> Conexão - onde é estabelecida a conexão com o banco de dados. Também é feito a inserção e recuperação de dados das entidades.

-> Entidades - onde é declarado as entidades utilizadas no sistema.

-> TrataDados - onde é feito verificações de inconsistências das entidades.

-> Visual - onde contém todas as telas (JFrames) criadas para este sistema.


Como descrito no documento do programa da Capgemini, o sistema requer persistência de dados, para isso foi utilizado o programa MySQL Workbench usando o localhost. Então para executar o sistema, quem o testar deve baixar o MySQL Workbench inserindo durante a instalação o mesmo user e senha, o user é 'root' e a senha '123456'. Após a instalação é necessário criar a conexão com o banco de dados que deve se chamar 'ProvaGerenciador'.

OBS:. Todas as informações precisam ser iguais para que o sistema consiga ser executado.

O MySQL Workbench se encontra no link: https://dev.mysql.com/downloads/installer/ - instale a segunda opção.

Espero que gostem :). Obrigado pelo experiência.
