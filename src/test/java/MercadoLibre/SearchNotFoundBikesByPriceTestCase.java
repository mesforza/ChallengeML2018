package MercadoLibre;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;


public class SearchNotFoundBikesByPriceTestCase extends Base{

	@BeforeTest
	public void initialize() throws IOException
	{		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void SearchNotFoundBikesByPrice() throws Exception
	{
		//Home Page
		HomePage mlhomepage=new HomePage (driver);
		mlhomepage.Nationality().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		mlhomepage.CategoriesMouseHoverActions();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		mlhomepage.Sports();
		mlhomepage.BikesCycling();
				
		//SearchResultsPage
		SearchResultsPage mlsearchresults=new SearchResultsPage (driver);
		mlsearchresults.CategoriesBikes().click();
		mlsearchresults.FromPrice().sendKeys("350000");
		mlsearchresults.ToPrice().sendKeys("400000");
		mlsearchresults.SearchByPrice().click();
		mlsearchresults.NotFoundBikesByPrice();		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}

}
