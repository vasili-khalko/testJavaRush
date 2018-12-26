USE test;

DROP TABLE IF EXISTS `parts`;
CREATE TABLE `parts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `need` bit(1) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO Parts (name,quantity,need) VALUES ("материнская плата",50,1),("звуковая карта",123,0),("процессор",16,1),("подсветка корпуса",22,0),("HDD диск",27,0),("корпус",21,1),("память",52,1),("SSD диск",94,1),("видеокарта",33,0),("клавиатура",18,1);
INSERT INTO Parts (name,quantity,need) VALUES ("мышка",41,1),("коврик",23,0),("сетевая карта",160,0),("куллер",28,0),("флопик",37,0),("dvd привод",10,0),("блок питания",52,1),("шлейф",104,1),("картридер",13,0),("вебкамера",18,0);
INSERT INTO Parts (name,quantity,need) VALUES ("микрофон",35,0),("колонки",123,0),("тв-тюнер",116,0),("usb-хаб",22,0);