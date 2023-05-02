package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {

    public static final String GET_BEER_STYLES = "SELECT styles.style_name as styleName, styles.id as style_id, COUNT(beers.style_id) as beerCount FROM beers JOIN styles on styles.id = beers.style_id GROUP BY styles.id ORDER BY beerCount DESC, styleName ASC" ;

    public static final String BEER_DESCRIPT = """
            SELECT 
            beers.id as beer_id,
            beers.name as beer_name, 
            beers.descript as beer_description, 
            breweries.name as brewery_name,
            breweries.id as brewery_id
            FROM beers JOIN breweries
            ON  beers.brewery_id = breweries.id
            JOIN styles 
            ON styles.id = beers.style_id
            WHERE styles.id = ? AND styles.style_name = ?
            ORDER BY beer_name ASC;
            """;

}
