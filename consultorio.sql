# SHOW CHARACTER SET WHERE charset LIKE ‘latin1’;
#SHOW CHARACTER SET WHERE charset LIKE ‘utf8’;


create database if not exists dbconsultorio;
#use padaria;

use dbconsultorio;

#insert into paciente value (1,'andre','159.135.067-07','2000-08-30','M','rua dos miosotis','(21)16415135','andrefoto','bradesco','manerao','2010-07-15');
truncate table paciente;
create table if not exists paciente(
idPaciente int unsigned not null auto_increment primary key,
nome varchar(60),
cpf varchar(45),
data_nascimento DATE,
sexo enum('M','F'),
endereco varchar(100),
telefone varchar(100),
foto varchar(100),
plano_saude varchar(50),
observacoes text,
data_cadastro date
)engine=MyISAM default charset=utf8;


create table if not exists psicologo(
	idPsicologo int unsigned not null auto_increment primary key,
    nome varchar(60),
    cpf varchar(11),
    crp varchar(20),
    telefone varchar(20),
    login varchar(20) unique,
    senha varchar(20)
)engine=MyISAM default charset=utf8;

create table if not exists anamnese(
idAnamnese int unsigned not null auto_increment primary key,
queixas text,
sintomas text,
tratamentos_anteriores text,
medicamentos text,
infancia text,
rotina text,
vicios text,
hobbies text,
trabalho text,
historico_familiar text,
comportamento text,
linguagem text,
humor text,
hipotese_diagnostica text,
observacoes text,
numero_sessoes int,
valor decimal,
periodicidade varchar(20),
idPaciente int not null,
idPsicologo int not null,
foreign key(idPaciente)references paciente(idPaciente),
foreign key(idPsicologo) references psicologo(idPsicologo)
)engine=MyISAM default charset=utf8;

create table if not exists sessao (
idSessao int unsigned not null auto_increment primary key,
data datetime,
queixas_paciente text,
plano_tratamento text,
dignostico_final text,
resumo_sessao text,
evolucao int,
pago bit(1),
idAnamnece int not null,
foreign key (idAnamnece) references anamnece(idAnamnece)
)engine=MyISAM default charset=utf8;

select * from paciente;

#insert into psicologo value (1,"Jojo","15913506707","4848589856","(666)555-5557","JOJO","123") ;
#insert into psicologo value (2,"JC","15913506707","4848589856","(666)555-5557","JC","123") ;
#insert into psicologo value (3,"Pele","15913506707","4848589856","(666)555-5557","Pele","123") ;

#select * from psicologo;
#select * from anamnese;
select * from paciente;
