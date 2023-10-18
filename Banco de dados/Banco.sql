CREATE SCHEMA `bancodedados` ;
CREATE TABLE Usuario 
( 
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,  
 nome VARCHAR(50),  
 cpf VARCHAR(15),  
 endereço VARCHAR(50),  
 telefone VARCHAR(15)
); 
CREATE TABLE Destino 
( 
 id INT PRIMARY KEY AUTO_INCREMENT,  
 estado VARCHAR(50),
 nome VARCHAR(50)
); 
CREATE TABLE reserva 
( 
 id INT PRIMARY KEY AUTO_INCREMENT,  
 id_usuario INT,  
 id_destino INT,  
 data_viagem VARCHAR(50),
 Valor FLOAT,  
 FOREIGN KEY(id_usuario) REFERENCES Usuario (id),
 FOREIGN KEY(id_destino) REFERENCES Destino (id)
); 
ALTER TABLE `bancodedados`.`reserva` 
DROP FOREIGN KEY `reserva_ibfk_1`,
DROP FOREIGN KEY `reserva_ibfk_2`;
ALTER TABLE `bancodedados`.`reserva` 
ADD CONSTRAINT `reserva_ibfk_1`
  FOREIGN KEY (`id_usuario`)
  REFERENCES `bancodedados`.`usuario` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `reserva_ibfk_2`
  FOREIGN KEY (`id_destino`)
  REFERENCES `bancodedados`.`destino` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

