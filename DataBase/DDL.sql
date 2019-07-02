DROP DATABASE IF EXISTS studyMe;
CREATE DATABASE studyMe;

USE studyMe;

DROP DATABASE IF EXISTS amministratore;
CREATE TABLE amministratore(
nomeAmministratore varchar(30) primary key,
password varchar(30) not null,
confPassword varchar(30) not null,
email varchar(50) not null);

DROP DATABASE IF EXISTS cliente;
CREATE TABLE cliente(
nomeUtente varchar(20) primary key,
password varchar(30) not null,
email varchar(50) not null);

DROP DATABASE IF EXISTS categoria;
CREATE TABLE categoria(
 nomeCategoria varchar(30) primary key
);

DROP DATABASE IF EXISTS sottoCategoria;
CREATE TABLE sottoCategoria(
	idSottocat varchar(6) primary key,
    nomeSott  varchar(30) not null);

DROP DATABASE IF EXISTS pacchetto;
CREATE TABLE pacchetto(
codicePacchetto varchar(6) primary key,
categoria	varchar(20) not null,
idSott  varchar(6) not null,
prezzo double not null,
descrizione varchar(1000) not null,
titolo varchar(200) not null,
foto varchar(300) not null,
foreign key (categoria) references categoria(nomeCategoria)
	on update cascade
    on delete cascade,
foreign key (idSott) references sottoCategoria(idSottocat)
		on update cascade
        on delete cascade);

DROP DATABASE IF EXISTS lezioni;
CREATE TABLE lezioni(
url  varchar(100) primary key,
titolo varchar(200) not null,
durata time not null,
codiceP varchar(6),
foreign key (codiceP) references pacchetto(codicePacchetto)
		on update cascade
        on delete cascade);

DROP DATABASE IF EXISTS ordine;
CREATE TABLE ordine(
numFattura int primary key,
nomeCliente varchar(20) not null,
iva double not null,
imponibile double not null,
prezzoTot double not null,
data date not null,
quantità int not null,
foreign key(nomeCliente) references cliente(nomeUtente)
		on update cascade
        on delete cascade);

DROP DATABASE IF EXISTS acquisto;
CREATE TABLE acquisto(
idAcquisto varchar(15) primary key,
numFattura int,
codiceP varchar(6),
importo double not null,
modaltàPagamento varchar(30) not null,
foreign key (numFattura) references ordine(numFattura)
	on update cascade
    on delete cascade,
foreign key (codiceP) references pacchetto(codicePacchetto)
	on update cascade
    on delete cascade);

DROP DATABASE IF EXISTS recensione;
CREATE TABLE recensione(
idRecensione varchar(15) primary key,
userCliente varchar(20) not null,
codiceP varchar(6) not null,
commento varchar(50) not null,
foreign key (userCliente) references cliente(nomeUtente)
	on update cascade
    on delete cascade,
foreign key (codiceP) references pacchetto(codicePacchetto)
	on update cascade
    on delete cascade);