package ibf2022.assessment.paf.batch3.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;

import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;

@Repository
public class BeerRepository {

	@Autowired
	JdbcTemplate jdbctemplate;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2

		List<Style> beer_styles = new ArrayList();

		SqlRowSet rs = jdbctemplate.queryForRowSet(GET_BEER_STYLES);

		while (rs.next()) {

			Style style = new Style();

			style.setStyleId(rs.getInt("style_id"));
			style.setName(rs.getString("styleName"));
			style.setBeerCount(rs.getInt("beerCount"));

			beer_styles.add(style);
		}

		return beer_styles;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(Integer styleId, String  styleName) {
		// TODO: Task 3

		List<Beer> xyz = new ArrayList();

		SqlRowSet rs = jdbctemplate.queryForRowSet(BEER_DESCRIPT, styleId,  styleName);

		while (rs.next()){
			
			Beer beer = new Beer();

			beer.setBeerName(rs.getString("beer_name"));
			beer.setBeerDescription(rs.getString("beer_description"));
			beer.setBreweryName(rs.getString("brewery_name"));
			beer.setBeerId(rs.getInt("beer_id"));
			beer.setBreweryId(rs.getInt("brewery_id"));
			xyz.add(beer);
		}

		return xyz;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(/* You can add any number of parameters here */) {
		// TODO: Task 4

		return Optional.empty();
	}
}
