create database ecommerce ;
use ecommerce ; 
create table genre(
	idGenre int not null AUTO_INCREMENT ,
	genre varchar (100) not null ,
	primary key (idGenre) 
); 
create table sousgenre(
	idSousGenre int not null AUTO_INCREMENT ,
	idGenre int not null , 
	sousgenre varchar(100)  not null ,
	foreign key (`idGenre`) references genre (`idGenre`) ,
	primary key (idSousGenre)
);
create table marque(
	idMarque int  not null ,
	marque varchar(100) not null,
	discription varchar(255) ,
	logo varchar(100) default 'marque.png' ,
	primary key (`idMarque`) 
) ;
create table Produit(
	idProduit int not null AUTO_INCREMENT ,
	idMarque int  not null ,
	libelle varchar(100) not null , 
	logo varchar(100) default 'produit.png' ,
	prixVent int not null ,
	prixAchat int not null , 
	dateEnrg dateTime default NOW() ,
	idSousGenre int not null ,
	foreign key (`idSousGenre`) references sousgenre (`idSousGenre`),
	foreign key (`idMarque`) references marque (`idMarque`),
	primary key (idProduit)
) ;

create table role(
	idRole int not null AUTO_INCREMENT, 
	role varchar(24) not null  ,
	primary key (idRole) 
) ;

create table Personne(
	login varchar(100) not null ,
	password varchar(255) not null ,
	idRole int not null ,
	nom varchar(100) not null ,
	prenom varchar (100) not null ,
	dateNaissance date  not  null ,
	email varchar(100) not null , 
	tel varchar(20) not null ,
	adress varchar(255) not null ,
	ville varchar(100) not null ,
	paye varchar(100) not null ,
	foreign key (`idRole`) references role(`idRole`) ,
	primary key (`login`)
);

create table detail(
	idProduit int ,
	login varchar(100) ,
	adressLivraison varchar(255),
	villeLivraison varchar(100) not null ,
	payeLivraison varchar(100) not null ,
	qte int not null ,
	foreign key (idProduit) references Produit(idProduit) ,
	foreign key (login) references Personne(login)  ,
	primary key(idProduit , login) ,
	etatlivraison boolean default false ,
	etatreglement boolean default false 
);


create table commentaire(
	idComment int not null ,
	idProduit int not null , 
	txt varchar (255) , 
	login varchar (100) not null ,
	dateCommentaire dateTime default NOW() ,
	foreign key (idProduit) references Produit(idProduit),
	foreign key (login) references Personne (login) ,
	primary key (idComment)
);
create table jaime(
	idComment int not null , 
	login varchar(100) ,
	primary key (idComment , login ) ,
	foreign key (idComment) references commentaire(idComment) ,
	foreign key (login) references Personne (login)
);