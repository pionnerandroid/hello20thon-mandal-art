import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import project.mandalart.domain.mandalart.MandalItems;
import project.mandalart.domain.mandalart.MandalItemsRepository;
import project.mandalart.dto.MandalItemsSaveRequestDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UrlControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MandalItemsRepository itemsRepository;

    @After
    public void tearDown() throws Exception {
        itemsRepository.deleteAll();
    }

    @Test
    public void 등록된다() throws Exception {
        // given

        //    private MandalArt mandalArt;
        Long itemsSquare = 1L;
        String itemsItem = "아이템이야~";
        MandalItemsSaveRequestDto requestDto = MandalItemsSaveRequestDto
                .builder()
                .itemsSquare(itemsSquare)
                .itemsItem(itemsItem)
                .build();

        String url = "http://localhost:" + port + "/mandalart/items";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<MandalItems> all = itemsRepository.findAll();
        assertThat(all.get(0).getItemsSquare()).isEqualTo(itemsSquare);
        assertThat(all.get(0).getItemsItem()).isEqualTo(itemsItem);

    }
}
