-- Datos de ejemplo para evidenciar la relación uno a muchos (Biblioteca -> Libros)

INSERT INTO bibliotecas (nombre, direccion, telefono, responsable) VALUES ('Biblioteca Central', 'Av. Principal 123', '3001234567', 'Ana Gomez');
INSERT INTO bibliotecas (nombre, direccion, telefono, responsable) VALUES ('Biblioteca Norte', 'Calle 45 #67-89', '3019876543', 'Carlos Ruiz');

INSERT INTO libros (titulo, autor, categoria, biblioteca_id) VALUES ('Cien Años de Soledad', 'Gabriel Garcia Marquez', 'Novela', 1);
INSERT INTO libros (titulo, autor, categoria, biblioteca_id) VALUES ('El Principito', 'Antoine de Saint-Exupery', 'Infantil', 1);
INSERT INTO libros (titulo, autor, categoria, biblioteca_id) VALUES ('1984', 'George Orwell', 'Distopia', 2);
