-- creation of Artists Table

CREATE TABLE Artists ( 
ArtistID INT PRIMARY KEY, 
Name VARCHAR(255) NOT NULL, 
Biography TEXT, 
Nationality VARCHAR(100)
);

-- Insertion of sample records

INSERT INTO Artists (ArtistID, Name, Biography, Nationality) VALUES 
(1, 'Pablo Picasso', 'Renowned Spanish painter and sculptor.', 'Spanish'), 
(2, 'Vincent van Gogh', 'Dutch post-impressionist painter.', 'Dutch'), 
(3, 'Leonardo da Vinci', 'Italian polymath of the Renaissance.', 'Italian'),
(4, 'Claude Monet', 'French painter, a founder of Impressionism.', 'French'), 
(5, 'Frida Kahlo', 'Mexican painter known for self-portraits.', 'Mexican'), 
(6, 'Salvador Dalí', 'Spanish surrealist artist.', 'Spanish'), 
(7, 'Johannes Vermeer', 'Dutch Baroque painter known for domestic scenes.', 'Dutch');

-- creation of Categories table

CREATE TABLE Categories ( 
CategoryID INT PRIMARY KEY, 
Name VARCHAR(100) NOT NULL); 

-- Insertion of sample records into Categories table

INSERT INTO Categories (CategoryID, Name) VALUES 
(1, 'Painting'), 
(2, 'Sculpture'), 
(3, 'Photography'),
(4, 'Digital Art'), 
(5, 'Calligraphy'); 

-- creation of Artworks Table

CREATE TABLE Artworks ( 
ArtworkID INT PRIMARY KEY, 
Title VARCHAR(255) NOT NULL, 
ArtistID INT, 
CategoryID INT, 
Year INT, 
Description TEXT, 
ImageURL VARCHAR(255), 
FOREIGN KEY (ArtistID) REFERENCES Artists (ArtistID), 
FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID)); 

-- Insertion of sample records into Artworks table

INSERT INTO Artworks (ArtworkID, Title, ArtistID, CategoryID, Year, Description, ImageURL) VALUES 
(1, 'Starry Night', 2, 1, 1889, 'A famous painting by Vincent van Gogh.', 'starry_night.jpg'), 
(2, 'Mona Lisa', 3, 1, 1503, 'The iconic portrait by Leonardo da Vinci.', 'mona_lisa.jpg'), 
(3, 'Guernica', 1, 1, 1937, 'Pablo Picasso\'s powerful anti-war mural.', 'guernica.jpg'), 
(4, 'Afghan Girl',7, 3, 1984, 'An iconic portrait photograph by Steve McCurry.', 'afghan_girl.jpg'), 
(5, 'The Calligrapher’s Art',6, 5, 2020, 'A contemporary Arabic calligraphy artwork.', 'calligraphy_art.jpg'), 
(6, 'Refik Anadol’s Machine Hallucinations',6, 4, 2021, 'A digital AI-generated artwork.', 'machine_hallucinations.jpg'),
(7, 'Girl with a Pearl Earring', 7, 1, 1665, 'A Baroque-era portrait by Johannes Vermeer.', 'girl_with_pearl_earring.jpg'), 
(8, 'David', 4, 2, 1504, 'Michelangelo’s famous marble sculpture.', 'david.jpg'), 
(9, 'The Thinker',5, 2, 1904, 'A bronze sculpture by Auguste Rodin.', 'the_thinker.jpg'),
(10, 'The Starry Night Over the Rhône', 6, 1, 1888, 'A stunning night scene by Vincent van Gogh.', 'starry_night_rhone.jpg'), 
(11, 'The Day', 6, 1, 1908, 'A famous symbolist painting by Gustav Klimt.', 'the_Day.jpg'), 
(12, 'Balloon Dog', 3, 2, 1994, 'A contemporary stainless steel sculpture by Jeff Koons.', 'balloon_dog.jpg'),
(13, 'The Birth of Venus', 3, 1, 1486, 'A masterpiece of the Italian Renaissance by Sandro Botticelli.', 'birth_of_venus.jpg');

-- creation of Exhibition Table

CREATE TABLE Exhibitions ( 
ExhibitionID INT PRIMARY KEY, 
Title VARCHAR(255) NOT NULL, 
StartDate DATE, 
EndDate DATE, 
Description TEXT); 

-- Insertion of sample records into Exhibition Table

INSERT INTO Exhibitions (ExhibitionID, Title, StartDate, EndDate, Description) VALUES 
(1, 'Modern Art Masterpieces', '2023-01-01', '2023-03-01', 'A collection of modern art masterpieces.'), 
(2, 'Renaissance Art', '2023-04-01', '2023-06-01', 'A showcase of Renaissance art treasures.'),
(3, 'Abstract Expressions', '2024-03-10', '2024-06-10', 'A showcase of abstract art from the 20th and 21st centuries.'), 
(4, 'The Golden Age of Art', '2024-09-15', '2024-12-15', 'A journey through the masterpieces of the Baroque and Rococo periods.'), 
(5, 'Futuristic Visions', '2025-04-05', '2025-07-05', 'An exhibition exploring the intersection of technology and art.'), 
(6, 'Cultural Heritage in Art', '2025-01-01', '2025-03-20', 'A display of artworks representing diverse cultural traditions and histories.');

-- creation of Exhibition Artworks Table

CREATE TABLE ExhibitionArtworks ( 
ExhibitionID INT, 
ArtworkID INT, 
PRIMARY KEY (ExhibitionID, ArtworkID), 
FOREIGN KEY (ExhibitionID) REFERENCES Exhibitions (ExhibitionID), 
FOREIGN KEY (ArtworkID) REFERENCES Artworks (ArtworkID));

-- Insertion of sample records into  ExhibitionArtworks Table.

INSERT INTO ExhibitionArtworks (ExhibitionID, ArtworkID) VALUES 
(1, 1), 
(1, 2), 
(1, 3), 
(2, 2),
(3, 6),
(4, 5),
(5, 9),
(5, 8); 

