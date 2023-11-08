
CREATE TABLE peliculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250),
    calificacion INT
);
CREATE TABLE salas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250),
    pelicula INT,
    FOREIGN KEY (pelicula) REFERENCES peliculas(id)
);
INSERT INTO peliculas (nombre,calificacion) VALUES
    ('Harry potter',7),
    ('Kill bill vol 2',15),
    ('Los puentes de madison',3);
   
INSERT INTO salas (nombre,pelicula) VALUES
    ('Sala peixos',2),
    ('Sala Bonaventura',3),
   ('Sala Napoleo',2),
    ('Sala Isla del tesoro',1),
     ('Sala pirata barbanegra',1);
