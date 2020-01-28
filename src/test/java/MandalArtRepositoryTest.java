import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.mandalart.domain.MandalArt;
import project.mandalart.domain.MandalArtRepository;
import project.mandalart.domain.MandalItemsRepository;
import project.mandalart.domain.MandalSubItemsRepository;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MandalArtRepositoryTest {
    @Autowired
    MandalArtRepository mandalArtRepository;

    @Autowired
    MandalItemsRepository mandalItemsRepository;

    @Autowired
    MandalSubItemsRepository mandalSubItemsRepository;

    @After
    public void cleanup() {
        mandalArtRepository.deleteAll();
    }

    @Test
    public void 생성하기() {
        //given
        mandalArtRepository.save(
                MandalArt.builder()
                .nothing("성찬이의 mandalart")
                .build());

        List<MandalArt> mandaList = mandalArtRepository.findAll();

        MandalArt mandalArt = mandaList.get(0);

        assertThat(mandalArt.getNothing(), is("성찬이의 mandalart"));
    }
}
