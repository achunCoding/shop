package top.wycfight.shop.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.wycfight.shop.demo.dto.PmsBrandDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopDemoApplicationTests {
    private Logger logger = LoggerFactory.getLogger(ShopDemoApplicationTests.class);
    @Test
    public void contextLoads() {
    }

    /**
     * 测试日志信息
     *
     * @throws Exception
     */
    @Test
    public void testLogStash() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PmsBrandDto pmsBrandDto = new PmsBrandDto();
        pmsBrandDto.setName("小米手机");
        pmsBrandDto.setBrandStory("小米");
        logger.info(mapper.writeValueAsString(pmsBrandDto));
        logger.error(mapper.writeValueAsString(pmsBrandDto));
    }



}
