/** */
package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:26:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBase {
	/** 日志 */
	protected Logger logger = LogManager.getLogger(this.getClass());
}
