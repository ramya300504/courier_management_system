-- 1.Retrieve the names of all artists along with the number of artworks they have in the gallery, and 
-- list them in descending order of the number of artworks

select artists.artistID,artists.name,count(artworks.artworkID) as Number_of_Artworks
from artists artists 
join artworks artworks on artists.ArtistID=artworks.ArtistID
group by artists.ArtistID,artists.Name
order by Number_of_Artworks desc;

-- 2. List the titles of artworks created by artists from 'Spanish' and 'Dutch' nationalities, and order 
-- them by the year in ascending order. 

select artworks.title,artists.Nationality,artworks.year
from artists artists join
artworks artworks on artists.ArtistID=artworks.ArtistID
where Nationality='Spanish' or Nationality='Dutch'
order by year;

-- 3. Find the names of all artists who have artworks in the 'Painting' category, and the number of 
-- artworks they have in this category. 

select artists.name,c.name,count(artworks.artworkID) as Number_of_Artworks
from artworks artworks 
join artists artists on artists.ArtistID=artworks.ArtistID
join categories c on c.CategoryID=artworks.CategoryID
where c.name='Painting'
group by artists.ArtistID;

-- 4. List the names of artworks from the 'Modern Art Masterpieces' exhibition, along with their 
-- artists and categories.

select a.Title as Artwork_Name, ar.Name AS Artist_Name, c.Name AS Category_Name
from ExhibitionArtworks ea
join Artworks a on ea.ArtworkID = a.ArtworkID
join Artists ar on a.ArtistID = ar.ArtistID
join Categories c on a.CategoryID = c.CategoryID
join Exhibitions e on ea.ExhibitionID = e.ExhibitionID
where e.Title = 'Modern Art Masterpieces';

-- 5. Find the artists who have more than two artworks in the gallery. 

select ar.name as Artist_Name,Count(aw.artistID) as Number_of_Artworks
from artworks aw 
join artists ar on ar.ArtistID=aw.ArtistID
group by ar.name
having Number_of_Artworks>2;

-- 6. Find the titles of artworks that were exhibited in both 'Modern Art Masterpieces' and 
-- 'Renaissance Art' exhibitions 

select aw.title as Artwork_Title,e.Title as Exhibition_Title
from artworks aw 
join exhibitionartworks ea on ea.ArtworkID=aw.ArtworkID
join exhibitions e on e.ExhibitionID=ea.ExhibitionID
where e.title in ('Modern Art Masterpieces', 'Renaissance Art');

-- 7. Find the total number of artworks in each category 

select count(aw.categoryID) as Number_of_Artworks,c.name 
from artworks aw 
join categories c on c.CategoryID=aw.CategoryID
group by aw.CategoryID;

-- 8. List artists who have more than 3 artworks in the gallery.
 
select ar.name as Artist_name,count(aw.artistID) as Number_of_Artworks
from artworks aw 
join artists ar on ar.ArtistID=aw.ArtistID
group by aw.artistID
having count(aw.artistID)>3;

-- 9. Find the artworks created by artists from a specific nationality (e.g., Spanish). 

select ar.artistID,ar.name as Artist_name,aw.title as Artwork_name,ar.nationality
from artists ar join
artworks aw on aw.ArtistID=ar.artistID
where Nationality='Spanish';

-- 10.  List exhibitions that feature artwork by both Vincent van Gogh and Leonardo da Vinci. 

select e.title as Exhibition,ar.name as Artist_name
from exhibitions e 
join exhibitionartworks ea on ea.ExhibitionID=e.ExhibitionID
join artworks aw on aw.artworkID=ea.ArtworkID
join artists ar on ar.ArtistID=aw.ArtistID
where ar.name in ('Vincent van Gogh', 'Leonardo da Vinci');

-- 11. Find all the artworks that have not been included in any exhibition. 

select aw.Title as Artwork_Title
from artworks aw
join artists ar on ar.ArtistID = aw.ArtistID
left join exhibitionartworks ea on aw.ArtworkID = ea.ArtworkID
where ea.ExhibitionID IS NULL;

-- 12.  List artists who have created artworks in all available categories. 

select ar.name as artist_name
from artists ar
join artworks aw on ar.artistid = aw.artistid
group by ar.artistid, ar.name
having count(distinct aw.categoryid) = (select count(categoryid) from categories);

-- 13.  List the total number of artworks in each category. 

select c.name as Category_name,count(aw.artistID) as Number_of_Artworks
from artworks aw 
join categories c on c.CategoryID=aw.CategoryID
group by c.name;

-- 14. Find the artists who have more than 2 artworks in the gallery. 

select ar.name as Artist_Name,Count(aw.artistID) as Number_of_Artworks
from artworks aw 
join artists ar on ar.ArtistID=aw.ArtistID
group by ar.name
having Number_of_Artworks>2;

-- 15.  List the categories with the average year of artworks they contain, only for categories with more 
-- than 1 artwork. 

select c.name as category_name, avg(aw.year) as avg_year
from artworks aw
join categories c on aw.categoryid = c.categoryid
group by c.categoryid, c.name
having count(aw.artworkid) > 1;

-- 16. Find the artworks that were exhibited in the 'Modern Art Masterpieces' exhibition. 

select aw.title as Artwork_title, ar.name as Artist_name
from artworks aw
join exhibitionartworks ea on aw.artworkid = ea.artworkid
join exhibitions e on e.exhibitionid = ea.exhibitionid
join artists ar on ar.artistid = aw.artistid
where e.title = 'modern art masterpieces';

-- 17. Find the categories where the average year of artworks is greater than the average year of all artworks.
 
select c.name as category_name, avg(aw.year) as avg_year
from artworks aw
join categories c on aw.categoryid = c.categoryid
group by c.categoryid, c.name
having avg(aw.year) > (select avg(year) from artworks);

-- 18. List the artworks that were not exhibited in any exhibition. 

select aw.title as Artwork_title
from artworks aw
left join exhibitionartworks ea on aw.artworkid = ea.artworkid
left join artists ar on ar.artistid = aw.artistid
where ea.exhibitionid is null;

-- 19. Show artists who have artworks in the same category as "Mona Lisa." 

select distinct ar.name as Artist_Name
from artists ar
join artworks aw on ar.artistid = aw.artistid
where aw.categoryid = (
    select categoryid from artworks where title = 'Mona Lisa'
);

-- 20.  List the names of artists and the number of artworks they have in the gallery. 

select ar.name as artist_name, count(aw.artworkid) as number_of_artworks
from artists ar
join artworks aw on ar.artistid = aw.artistid
group by ar.artistid, ar.name;