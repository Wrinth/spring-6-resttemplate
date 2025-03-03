package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void testGetBeerById() {
        Page<BeerDTO> beerDTOs = beerClient.listBeers();

        BeerDTO beerDTO = beerDTOs.getContent().getFirst();

        BeerDTO byId = beerClient.getBeerById(beerDTO.getId());

        assertNotNull(byId);
    }

    @Test
    void testListBeersWithNoBeerName() {
        beerClient.listBeers(null, null, null, null, null);
    }

    @Test
    void testListBeers() {
        beerClient.listBeers("ALE", null, null, null, null);
    }
}